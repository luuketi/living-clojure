(ns living-clojure.week3.day5)
(require '[clojure.math.combinatorics :as combo])

; Write a function which finds all the anagrams in a vector of words. A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y. Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other. Each sub-set should have at least two words. Words without any anagrams should not be included in the result.
(defn anagrams [words]
  (let [words (set words)]
    (set (for [w words
               :let [permutations (for [x (combo/permutations w)] (apply str x))
                     grouped-permutations (set (for [p permutations :when (contains? words p)] p))]
               :when (> (count grouped-permutations) 1)]
           grouped-permutations))))

(= (anagrams ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})
(= (anagrams ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})
