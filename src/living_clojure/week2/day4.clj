(ns living-clojure.week2.day4)
(require '[living-clojure.week2.day2 :as day2])


; Write a function which returns the symmetric difference of two sets. The symmetric difference is the set of items belonging to one but not both of the two sets.
(defn symmetric-difference [set1 set2]
  (let [ones (for [s1 set1 :when (not (contains? set2 s1))] s1)
        seconds (for [s2 set2 :when (not (contains? set1 s2))] s2)]
    (set (concat ones seconds))))

(= (symmetric-difference #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
(= (symmetric-difference #{:a :b :c} #{}) #{:a :b :c})
(= (symmetric-difference #{} #{4 5 6}) #{4 5 6})
(= (symmetric-difference #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})


; Write a function which calculates the least common multiple. Your function should accept a variable number of positive integers or ratios.
(defn least-common-multiple [& c]
  (reduce #(/ (* %1 %2) (day2/gcd %1 %2)) c))

(== (least-common-multiple 2 3) 6)
(== (least-common-multiple 5 3 7) 105)
(== (least-common-multiple 1/3 2/5) 2)
(== (least-common-multiple 3/4 1/6) 3/2)
(== (least-common-multiple 7 5/7 2 3/5) 210)