(ns living-clojure.week3.day4)

; Write a function which returns the first x number of prime numbers.
(defn primes [n]
  (defn prime-from [n]
    (loop [x (inc n)]
      (if (some #(= 0 (rem x %)) (range 2 x))
        (recur (inc x))
        x)))

  (loop [result [2]]
    (if (= n (count result))
      result
      (recur (conj result (prime-from (last result)))))))

(= (primes 2) [2 3])
(= (primes 5) [2 3 5 7 11])
(= (last (primes 100)) 541)