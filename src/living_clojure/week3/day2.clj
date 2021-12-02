(ns living-clojure.week3.day2)
(require '[clojure.math.numeric-tower :as math])

; Write a higher-order function which flips the order of the arguments of an input function.
(defn flip-args [f]
  (fn [& args] (apply f (reverse args))))

(= 3 ((flip-args nth) 2 [1 2 3 4 5]))
(= true ((flip-args >) 7 8))
(= 4 ((flip-args quot) 2 8))
(= [1 2 3] ((flip-args take) [1 2 3 4 5] 3))

; Write a function which can rotate a sequence in either direction.
(defn rotate-seq [direction sequence]
    (let [dir (rem (math/abs direction) (count sequence))]
      (if (> direction 0)
        (concat (drop dir sequence) (take dir sequence))
        (concat (take-last dir sequence) (take (inc dir) sequence)))))

(= (rotate-seq 2 [1 2 3 4 5]) '(3 4 5 1 2))
(= (rotate-seq -2 [1 2 3 4 5]) '(4 5 1 2 3))
(= (rotate-seq 6 [1 2 3 4 5]) '(2 3 4 5 1))
(= (rotate-seq 1 '(:a :b :c)) '(:b :c :a))
(= (rotate-seq -4 '(:a :b :c)) '(:c :a :b))
