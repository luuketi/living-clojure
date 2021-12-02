(ns living-clojure.week2.day5)

; Write a function which returns the nth row of Pascal’s Triangle.
(defn pascal-triangle [n]
   (cond
      (= 1 n) [1]
      (= 2 n) [1 1]
      :else (let [previous (pascal-triangle (dec n))
                  tuples-to-sum (map vector previous (rest previous))
                  middle (for [[a b] tuples-to-sum] (+ a b))]
               (flatten (list 1 middle 1)))))

(= (pascal-triangle 1) [1])
(= (map pascal-triangle (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]])
(= (pascal-triangle 11)
   [1 10 45 120 210 252 210 120 45 10 1])