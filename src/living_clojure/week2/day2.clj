(ns living-clojure.week2.day2)

; Here is an example of some more sophisticated destructuring.
(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] [1 2 3 4 5]] [a b c d]))

; Write a function which takes a variable number of booleans. Your function should return true if some of the parameters are true, but not all of the parameters are true. Otherwise your function should return false.

(defn xor [& params]
  (cond
    (every? true? params) false
    (some true? params) true
    :else false))

(= false (xor false false))
(= true (xor true false))
(= false (xor true))
(= true (xor false true false))
(= false (xor true true true))
(= true (xor true true true false))


; Given two integers, write a function which returns the greatest common divisor.
(defn gcd [a b]
  (loop [a a
         b b]
    (let [r (rem a b)]
      (if (= 0 r)
        b
        (recur b r)))))

(= (gcd 2 4) 2)
(= (gcd 10 5) 5)
(= (gcd 5 7) 1)
(= (gcd 1023 858) 33)