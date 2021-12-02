(ns living-clojure.week2.day3)
(require '[clojure.math.numeric-tower :as math])

; Simple closures
(defn func [n]
  #(math/expt % n))

(= 256 ((func 2) 16) ((func 8) 2))
(= [1 8 27 64] (map (func 3) [1 2 3 4]))
(= [1 2 4 8 16] (map #((func %) 2) [0 1 2 3 4]))


;Write a function which calculates the Cartesian product of two sets.
(defn cartesian-product [set1 set2]
    (set (for [s1 set1 s2 set2] [s1 s2])))

(= (cartesian-product #{"ace" "king" "queen"} #{"spade" "heart" "diamond" "club"})
   #{["ace" "spade"] ["ace" "heart"] ["ace" "diamond"] ["ace" "club"] ["king" "spade"] ["king" "heart"] ["king" "diamond"] ["king" "club"]
     ["queen" "spade"] ["queen" "heart"] ["queen" "diamond"] ["queen" "club"]})

(= (cartesian-product #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(= 300 (count (cartesian-product (into #{} (range 10))
                  (into #{} (range 30)))))