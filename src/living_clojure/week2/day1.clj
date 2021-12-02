(ns living-clojure.week2.day1)

; Write a function which returns the first X Fibonacci numbers.
(defn fibonacci [n]
  (loop [result [1]
         x 1]
    (if (= x n)
      result
      (recur (conj result (reduce + (take-last 2 result))) (inc x)))))

(= (fibonacci 3) '(1 1 2))
(= (fibonacci 6) '(1 1 2 3 5 8))
(= (fibonacci 8) '(1 1 2 3 5 8 13 21))


; Write a function which takes a string and returns a new string containing only the capital letters.
(defn only-caps [phrase]
  (apply str (filter #(Character/isUpperCase %) phrase)))

(= (only-caps "HeLlO, WoRlD!") "HLOWRD")
(empty? (only-caps "nothing"))
(= (only-caps "$#A(*&987Zf") "AZ")


; The some function takes a predicate function and a collection. It returns the first logical true value of (predicate x) where x is an item in the collection.
(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))

; Write a function which calculates factorials.
(defn factorial [n]
  (loop [result 1
         x 1]
    (if (> x n)
      result
      (recur (* x result) (inc x)))))

 (= (factorial 1) 1)
 (= (factorial 3) 6)
 (= (factorial 5) 120)
 (= (factorial 8) 40320)


; Let bindings and function parameter lists support destructuring.
(= [2 4] (let [[a b c d e f g] (range)] [c e]))

