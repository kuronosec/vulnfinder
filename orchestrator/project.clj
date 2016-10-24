(defproject transformation "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha13"]
                 [org.zaproxy/zap-clientapi "1.0.0"]
                 [clj-http "3.1.0"]
                 [me.raynes/conch "0.8.0"]]
  :main ^:skip-aot transformation.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
