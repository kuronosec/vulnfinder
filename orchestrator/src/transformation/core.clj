(ns transformation.core
  (:require [clojure.java.io :as io]
            [clojure.string :as s]
            [clj-http.client :as http]
            [me.raynes.conch.low-level :as sh])
  (:import (org.zaproxy.clientapi.core ApiResponse
                                       ApiResponseElement
                                       ClientApi))
  (:gen-class
   :methods [#^{:static true} [start [String String Object String int] String]
             #^{:static true} [attackurls [String] Object]]))


;; Utitily functions

(defn unwrap-str
  "Strips first and end char"
  [s]
  (subs s 1 (dec (count s))))

(defn wrap-str
  "Put double quotes on a string"
  [s]
  (str \" s \"))

(defn dbg
  "Debugging"
  ([x]
   (prn '[ORCH] x)
   x)
  ([msg x]
   (prn '[ORCH] msg x)
   x))


;; I/O

(defn make-path [base relative]
  (.getPath (io/file base relative)))

(defn append-current-path
  "Make the absolute path where the model will be"
  [path]
  (if (#{\\ \/} (first path))           ;absolute path?
    (.getPath (io/file path))
    (make-path (System/getProperty "user.dir") path)))

(defn parse-file
  "Parse the file containing the model"
  [path-in]
  (with-open [rdr (java.io.PushbackReader. (io/reader path-in))]
    (binding [*read-eval* false]
      (read rdr))))

(defn write-file-sqlmap-commands!
  "Create the file with sql commands"
  [parsed-toes path-sqlmap-in toes->sqlmap-command]
  (with-open [wrt (io/writer path-sqlmap-in)]
    (doseq [line (->> parsed-toes
                      (mapv toes->sqlmap-command)
                      (filter #(not= "" %))
                      (interpose "\n"))]
      (.write wrt line))
    (.write wrt "\n")))


;; Parsing and transform model

(defn from-toes
  "Extract url and pages from a toe"
  [[_ & toes]]
  (mapv (fn [[ _ url & pages]]
          {:url url :pages pages})
        toes))

(defn extract-toes
  "Extract the toes from the path where exist the model"
  [path-in]
  (let [[_ _ [& toes] attacks-def] (parse-file path-in)]
    toes))

(defn correct-page
  "Make sure an page URL starts with an slash (/)"
  [[first-char & rest-chars :as url]]
  (if (= \/ first-char)
    (apply str rest-chars)
    (do
      (println "WARNING: I got a page starting without / but don't worry, I fix it.")
      url)))

(defn correct-pad
  "Correct padding of / at the end of a complete URL"
  [page]
  (if (= (last page) \/)
    page
    (let [slashed-split (s/split page #"/")]
      (if (or (= (count slashed-split) 3)
              (not (re-find #".+\..+" (last slashed-split))))
        (str page "/")
        page))))

(defn append-static-field
  "Handles concatenation of URL when there is a static field,
  for example the field 'page' in hello/?page=index.php"
  [url s]
  (let [static-field (s/split url #"\?")]
    (if (= 1 (count static-field))      ;no ? found
      (str url s)
      (let [last-index (s/last-index-of url "/")
            u (str (subs url 0 last-index) "/")]
        (str u s "&" (last static-field))))))


;; SQLmap attack

(defn concat-fields
  "Join a group of fields with &"
  [[_ page & fields] filter-fn]
  (str (correct-page page)
       (if (= 1 (count (s/split page #"\?"))) ;no ? found
         "?"
         "&")
       (s/join "&"
               (->> fields
                    (filter filter-fn)
                    (mapv
                     (fn [[_ field attacks]]
                       (str field "=a"))
                     )))))

(defn concat-fields-sqlmap
  "Concat only fields specified with the SQLInjection attack"
  [page-with-fields]
  (concat-fields
   page-with-fields
   (fn [[_ field-name attacks]]
     ((set attacks) "SQLInjection"))))

(defn fields->sqlmap
  "Construct the comand of a specific field for SQLmap"
  [dir {:keys [url-with-params post-params]}]
  (s/join " "
          ["sqlmap"
           "--batch"
           "--smart"
           "--risk=1"
           "--level=2"
           "--time-sec=2"
           "--delay=1"
           "--timeout=5"
           "--retries=1"
           "--keep-alive"
           "--random-agent"
           "--threads=10"
           "--answers='extending=N,others=Y'"
           (format "--url '%s'" url-with-params)
           (format "--data '%s'" post-params)
           (format "--output-dir '%s'" dir)]))

(defn url-get-post
  "Return a map with the url and get params, and also the post params"
  [url field]
  (let [url-with-params (append-static-field
                         (correct-pad url)
                         field)]
    {:url url
     :url-with-params url-with-params
     :post-params (last (s/split url-with-params #"\?"))}))

(defn attack-command-sqlmap
  "Construct the comand for SQLmap"
  [dir {:keys [url pages]}]
  (->>
   pages
   (filter #(>= (count %) 3))            ;exclude pages without fields
   (mapv concat-fields-sqlmap)
   (map #(fields->sqlmap dir
                         (url-get-post url %)))
   (s/join "\n")))


;; ZAP spidering for marking fields to attack

(defn concat-fields-zap
  "Concat all fields"
  [page-with-fields]
  (concat-fields
   page-with-fields
   (fn [[_ _ attacks]]
     (> (count attacks) 0))))

(defn spidering-scan-fields!
  "Spider a specific page to let ZAP have that specific tree"
  [proxy {:keys [url url-with-params post-params]}]
  (dbg "url-get" url-with-params)
  (dbg "url-post" post-params)
  (http/get url-with-params
            proxy)
  (http/post url
             (merge proxy
                    {:body post-params})))

(defn spidering-scan!
  "Spider a target to let ZAP have that specific tree"
  [{:keys [url pages proxy-host proxy-port]}]
  (->>
   pages
   ;; (filter #(>= (count %) 3)) ;exclude pages without fields
   (filter (fn [[_ _ [_ _ attacks]]]
             (> (count attacks) 0)))
   dbg
   (mapv concat-fields-zap)
   dbg
   ((comp doall map) #(spidering-scan-fields!
                       {:proxy-host proxy-host
                        :proxy-port proxy-port}
                       (url-get-post url %)))))

(defn scan-to-mark-in-zap!
  "Tell to ZAP what specific tree will be attack"
  [toes {:keys [proxy-host proxy-port] :as proxy}]

  ;; remove previous result of spidering
  (-> (ClientApi. proxy-host proxy-port)
      (.core)
      (.newSession nil nil nil))

  ;; old way of removing results
  #_(doseq [toe (-> toes from-toes)]
      (let [toe-url (:url toe)
            limit-site (s/index-of toe-url "/" 7)
            site-url (subs toe-url 0 limit-site)]
        (try
          (-> (ClientApi. proxy-host proxy-port)
              (.core)
              (.deleteSiteNode nil site-url nil nil))
          (catch Exception e
            (println "WARNING: The" site-url "was not in the ZAP Sites Tree")))))

  ;; scan for mark fields to attack
  (->> toes
       from-toes
       dbg
       (mapv (partial merge proxy))
       dbg
       (mapv spidering-scan!)
       ;; first
       ;; vec
       ))

(defn correct-toe
  "Make sure the toe always ends in slash (/)"
  [url]
  (str (->> (s/split url #"/" 4)
            (take 3)
            (s/join "/"))
       "/"))

(defn do-attack-zap!
  "Instruct ZAP to attack"
  [obj zap-result {:keys [url proxy-host proxy-port]}]
  (let [continue (atom true)
        url-toe (correct-toe url)
        api (ClientApi.
             proxy-host
             proxy-port)
        resp (-> api
                 (.ascan)
                 (.scan nil
                        url-toe
                        "True"
                        "False"
                        nil, nil, nil))
        scanid (.getValue resp)
        progress (atom 0)]
    (while (and @continue (< @progress 100))
      (Thread/sleep 5000)
      (reset! progress (-> api
                           (.ascan)
                           (.status scanid)
                           (.getValue)
                           (Integer/parseInt)))
      (try
        (.updateProgress obj @progress "ZAP")
        (catch Exception e
          (reset! zap-result e)
          #_(reset! progress 100)
          (reset! continue false)       ; to avoid race condition
          #_(dbg "||||" (.getValue (-> api
                                       (.ascan)
                                       (.stop nil
                                              scanid))))
          (dbg "||||" (.getValue (-> api
                                     (.ascan)
                                     (.pauseAllScans nil))))
          (dbg "||||" (.getValue (-> api
                                     (.ascan)
                                     (.stopAllScans nil))))
          (-> api
              (.ascan)
              (.stopAllScans nil))
          (println "WARNING: An exception was thrown when trying to update the ZAP progress.")))
      (println
       (str "\n===\nZAP Progress: " @progress "%\n===\n")))))

(defn do-attack-sqlmap!
  "Instruct ZAP to attack"
  [obj path-sqlmap-in sqlmap-promise sqlmap-result]
  (with-open [rdr-sqlmap-in (io/reader path-sqlmap-in)]
    (doall (map
            (fn [line]
              (let [progress (atom 0)
                    proc (apply
                          sh/proc
                          (s/split (apply str
                                          (remove #(= \' %) line)) #" "))
                    exec (future (sh/stream-to-out
                                  proc
                                  :out))]
                (while (and (not (realized? exec)) (< @progress 100)) #_(< @progress 100)
                       #_(swap! progress #(+ % 10))
                       (Thread/sleep 15000)
                       (try
                         (.updateProgress obj @progress "SQLmap")
                         (println
                          (str "\n===\nSQLmap is still working...\n===\n")
                          #_(str "\n===\nSQLmap Progress: " @progress "%\n===\n"))
                         (catch Exception e
                           (println "WARNING: An exception was thrown when trying to update the progress of SQLmap.")
                           (sh/destroy proc)
                           (sh/exit-code proc)
                           (future-cancel exec)
                           #_(sh/proc "pppkill" "sqlmap")
                           (println "Waiting 1 minute while stoping all process.")
                           (deliver sqlmap-promise "\n\n===\n===\nSQLmap has ended with an exception.\n===\n===\n\n")
                           (reset! sqlmap-result e)
                           (reset! progress 100))))))
            (line-seq rdr-sqlmap-in)))))

(defn orchestrate!
  "Orchestrate the security tools"
  [toes path-out path-sqlmap-in obj proxy]

  (write-file-sqlmap-commands! (from-toes toes)
                               path-sqlmap-in
                               (partial attack-command-sqlmap path-out))

  (let [zap-promise (promise)
        zap-result (atom "OK")
        sqlmap-promise (promise)
        sqlmap-result (atom "OK")]
    @(future
       ;; Attack ZAP
       (future (println @zap-promise))
       (future (->> toes
                    from-toes
                    (mapv (partial merge proxy))
                    (mapv (partial do-attack-zap! obj zap-result)))
               (deliver zap-promise "\n\n===\n===\nZAP proxy has ended. Now you can check ZAP application.\n===\n===\n\n"))
       ;; Attack SQLmap
       (future (println @sqlmap-promise))
       (future (do-attack-sqlmap! obj path-sqlmap-in sqlmap-promise sqlmap-result)
               (deliver sqlmap-promise "\n\n===\n===\nSQLmap has ended. Now you can review the output files.\n===\n===\n\n"))
       @(future (when (and @zap-promise @sqlmap-promise)
                  (set [@zap-result @sqlmap-result]))))))


(defn attackurls
  "Construct the urls to attack, but do not perform any further action"
  [path-in proxy]
  (let [toes (extract-toes path-in)
        urls (scan-to-mark-in-zap! toes proxy)]
    urls))

(defn -start
  "The entry point from the API"
  [model-in dir-out obj proxy-host proxy-port]
  (let [proxy {:proxy-host proxy-host :proxy-port proxy-port}
        path-in (append-current-path model-in)
        path-out (append-current-path dir-out)
        path-sqlmap-in (make-path path-out "sqlmap-in.sh")]
    (println "== Input path:" path-in)
    (println "== Output path:" path-out)
    (let [toes (extract-toes path-in)
          _ (attackurls path-in proxy)
          result (orchestrate! toes path-out path-sqlmap-in obj proxy)
          exceptions (remove #{"OK"} result)]
      (if (empty? exceptions)           ;there is not exceptions?
        "OK"
        (do
          (when (> (count exceptions) 1)
            (println "WARNING: Exceptions on both ZAP and SQLmap, but returning just one of them."))
          (throw (first exceptions)))))
    #_(println (sh "sh" path-sqlmap-in))))

(defn -main
  "The entry point when running standalone"
  [& args]
  (cond (= (count args) 0)
        (do (println "WARNING: Using default paths")
            (let [path-in (make-path "resources" "model.seclang")
                  path-out "generated"]
              (-start path-in path-out "localhost" 8080)))
        (= (count args) 2)
        (-start (first args) (second args) "localhost" 8080)
        :else
        (do (println "Usage: java -cp transformation.jar:. Run <in-file> <out-dir>")
            "BAD PARAMS")))

#_(sh/stream-to-string (sh/proc "ls" "-l") :out)
#_(sh/stream-to-out (sh/proc "ls" "-l") :out)
