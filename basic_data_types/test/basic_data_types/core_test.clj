(ns basic_data_types.core-test
  (:require [clojure.test :refer :all]
            [basic_data_types.core :refer :all]))

(deftest test-value
  (def thing "you did it")
  (is (= "you did it" thing)))

(deftest test-if
  (is (= "cool" (if-w00t "w00t")))
  (is (= "bummer man" (if-w00t "yay"))))

(deftest test-do
  (is (= "cool" (do-w00t "w00t")))
  (is (= "bummer man" (do-w00t "yay"))))

(deftest test-when
  (is (= "cool" (when-w00t "w00t")))
  (is (= nil (when-w00t "yay"))))

(deftest test-or
  (is (= "w00t" (or "w00t")))
  (is (= "yay" (or false "yay")))
  (is (= nil (or false nil))))

(deftest test-and
  (is (= false (and false)))
  (is (= nil (and "yay" nil)))
  (is (= "w00t" (and "w00t"))))

(deftest test-map-structure
  (is (= (hash-map :a 1 :b 2) {:a 1 :b 2}))
  (is (= (get {:a 1 :b 2} :a) 1))
  (is (= (get-in {:a 1 :b {:c 3}} [:b :c]) 3))
  (is (= ({:a 1 :b 2} :a) 1)))

(deftest test-keyword-as-function
  (is (= (:a {:a 1 :b 2}) 1)))

(deftest test-vector
  (is (= (get ["a" 1 "woohoo" 2] 0) "a"))
  (is (= (vector "a" 1 "yay" 2) ["a" 1 "yay" 2]))
  (is (= (conj [1 2 3] 4) [1 2 3 4])))

(deftest test-list
  (is (= (list 1 "two" {3 4}) '(1 "two" {3 4})))
  (is (= (nth '(1 2 3) 0) 1))
  (is (= (conj '(1 2 3) 4) '(4 1 2 3))))

(deftest test-set
  (is (= (hash-set 1 2) #{1 2}))
  (is (= (hash-set 1 1 2 2) #{1 2}))
  (is (= (conj #{1 2} 1) #{1 2}))
  (is (= (set [3 3 3 4 4]) #{3 4}))
  (is (= (contains? #{:a :b} :a) true))
  (is (= (contains? #{:a :b} :c) false))
  (is (= (get #{:a :b} :a) :a))
  (is (= (get #{:a :b} :c) nil))
  (is (= (get #{:a :b nil} nil) nil)))

(deftest test-math
  (is (= (+ 1 2) 3))
  (is (= (- 2 1) 1))
  (is (= (* 3 4) 12))
  (is (= (/ 4 2) 2))
  (is (= (/ 4 2) (* 2 1)))
  (is (= (+ (inc 199) (/ 100 (- 7 2))) 220))
  (is (= (max 1 2 3) 3))
  (is (= (apply max [1 2 3 4 3]) 4))
  (is (= (apply max '(1 2 3 4 3)) 4)))

(deftest test-map
  (is (= (map inc [0 1 2]) [1 2 3]))
  (is (= (map int [1.2 2.7 3]) [1 2 3]))
  (is (= (map zero? [0 1 2]) [true false false])))
