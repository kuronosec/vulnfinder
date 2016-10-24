(ns transformation.core-test
  (:require [clojure.test :refer :all]
            [transformation.core :refer :all]))

(deftest validation
  (testing "validate-url fn"
    (is (= "http://udea.edu.co:80/dir/index.php?login=123&lang=es"
           (validate-url "http://udea.edu.co:80/dir/index.php?login=123&lang=es")))
    (is (= nil (validate-url "\"")))
    (is (= nil (validate-url "'"))))
  (testing "validate-path fn"
    (is (= "c:\\\\Docs and Setts\\user\\" (validate-path "c:\\\\Docs and Setts\\user\\")))
    (is (= "/home/user/" (validate-path "/home/user/")))
    (is (= "-" (validate-path "-")))
    (is (= nil (validate-path ".")))
    (is (= nil (validate-path "\\.\\")))
    (is (= nil (validate-path "../"))))
  )

(deftest append-static-field-t
  (testing "append-static-field fn"
    (is (= "web/static&param" (append-static-field "web/?param" "static")))))

(deftest correct-page-t
  (testing "correct-page fn"
    (is (= "hola" (correct-page "/hola")))
    (is (= "hola" (correct-page "hola")))
    (is (= "hola.php" (correct-page "/hola.php")))
    (is (= "hola.php" (correct-page "hola.php")))
    (is (= "hola.php?a=123&b=4" (correct-page "/hola.php?a=123&b=4")))))

(deftest correct-pad-t
  (testing "correct-pad fn"
    (is (= "http://www.udea.edu.co/2/"
           (correct-pad "http://www.udea.edu.co/2")))
    (is (= "http://www.udea.edu.co/2/index.php"
           (correct-pad "http://www.udea.edu.co/2/index.php")))
    (is (= "http://192.168.0.14/"
           (correct-pad "http://192.168.0.14")))
    (is (= "http://192.168.0.14/"
           (correct-pad "http://192.168.0.14/")))
    (is (= "http://www.udea.edu.co/2/"
           (correct-pad "http://www.udea.edu.co/2/")))))

(deftest toe
  (is (= "http://www.udea.edu.co:81/"
         (correct-toe "http://www.udea.edu.co:81/")))
  (is (= "http://www.udea.edu.co:81/"
         (correct-toe "http://www.udea.edu.co:81")))
  (is (= "http://www.udea.edu.co:81/"
         (correct-toe "http://www.udea.edu.co:81/directory/index.php?page=login.php"))))

(deftest wraping
  (is (= (unwrap-str "\"hola\"") "hola"))
  (is (= (wrap-str "hola") "\"hola\""))
  (is (= (wrap-str (unwrap-str "\"hola\"")) "\"hola\"")))
