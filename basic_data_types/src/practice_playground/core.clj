(ns basic_data_types.core
  (:gen-class))

(defn if-w00t [input]
  (if (= input "w00t")
    "cool"
    "bummer man"))

(defn do-w00t [input]
  (if (= input "w00t")
    (do (println "cool")
    "cool")
    (do (println "bummer man")
    "bummer man")))

(defn when-w00t [input]
  (when (= input "w00t")
  "cool"))

(defn -main [])
