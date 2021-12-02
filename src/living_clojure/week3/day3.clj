(ns living-clojure.week3.day3)

; Write a function which reverses the interleave process into x number of subsequences.
(defn reverse-interleave [seq groups]
  (for [start (range 0 groups)]
    (for [x (range start (count seq) groups)]
      (nth seq x))))

(= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
(= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
(= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))


; Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous sub-sequences. The internal order of each sub- sequence should be maintained, but the sub-sequences themselves can be returned in any order (this is why set is used in the test cases).
(defn split-by-type [seq]
  (let [types (set (for [s seq] (type s)))]
    (for [t types]
      (filter #(= t (type %)) seq))
    )
  )

(= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
(= (set (split-by-type [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
(= (set (split-by-type [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})