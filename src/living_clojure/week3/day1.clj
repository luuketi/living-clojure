(ns living-clojure.week3.day1)

; Write a predicate which checks whether or not a given sequence represents a binary tree. Each node in the tree must have a value, a left child, and a right child.
(defn is-binary-tree? [tree]
  (cond
     (nil? tree) true
     (false? tree) false
     (not (empty? (nthrest tree 3))) false
     (not= 3 (count (take 3 tree))) false
     :else (and (is-binary-tree? (second tree)) (is-binary-tree? (nth tree 2)))))

(= (is-binary-tree? '(:a (:b nil nil) nil))
   true)
(= (is-binary-tree? '(:a (:b nil nil)))
   false)
(= (is-binary-tree? [1 nil [2 [3 nil nil] [4 nil nil]]])
   true)
(= (is-binary-tree? [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false)
(= (is-binary-tree? [1 [2 [3 [4 nil nil] nil] nil] nil])
   true)
(= (is-binary-tree? [1 [2 [3 [4 false nil] nil] nil] nil])
   false)
(= (is-binary-tree? '(:a nil ()))
   false)


; Let us define a binary tree as “symmetric” if the left half of the tree is the mirror image of the right half of the tree. Write a predicate to determine whether or not a given binary tree is symmetric. (see To Tree, or not to Tree for a reminder on the tree representation we’re using).
(defn is-symmetric-binary-tree? [tree]
   (defn are-symmetric? [tree1 tree2]
      (cond
         (and (nil? tree1) (nil? tree2)) true
         (and (= (first tree1) (first tree2))
              (and (are-symmetric? (second tree1) (nth tree2 2))
                   (are-symmetric? (second tree2) (nth tree1 2)))) true
         :else false)
      )
   (are-symmetric? (second tree) (nth tree 2)))

(= (is-symmetric-binary-tree? '(:a (:b nil nil) (:b nil nil))) true)
(= (is-symmetric-binary-tree? '(:a (:b nil nil) nil)) false)
(= (is-symmetric-binary-tree? '(:a (:b nil nil) (:c nil nil))) false)
(= (is-symmetric-binary-tree? [1 [2 nil [6 nil nil]] [2 [6 nil nil] nil]])
   true)
(= (is-symmetric-binary-tree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)
(= (is-symmetric-binary-tree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)
(= (is-symmetric-binary-tree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)