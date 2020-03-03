(ns sudoku-solver.core-test
  (:require [clojure.test :refer :all]
            [sudoku-solver.core :refer :all]))

(def puzzle {[0 0] 0
             [0 1] 1
             [0 2] 2
             [0 3] 3
             [1 0] 2
             [1 3] 1
             [2 1] 2
             [2 2] 3
             [2 3] 0
             [3 0] 3
             [3 1] 0
             [3 2] 1})

(deftest test-find-open-position
  (testing "find-open-position"
    (is (= (find-open-position puzzle) [1 1]))))

(deftest test-nums-in-row
  (testing "nums-in-row"
    (is (= (nums-in-row puzzle [0 0]) '(0 1 2 3)))))

(deftest test-nums-in-col
  (testing "nums-in-col"
    (is (= (nums-in-col puzzle [0 0]) '(0 2 3)))))

(def expected-get-squ-digits (map get-squ-digits digits))
(deftest test-get-squ-digits
  (testing "get-squ-digits"
    (is (= expected-get-squ-digits '([0 1] [0 1] [2 3] [2 3])))))

(deftest test-nums-in-squ
  (testing "nums-in-squ"
    (is (= (nums-in-squ puzzle [0 1]) [0 1 2]))))

(deftest test-used-numbers
  (testing "used-numbers"
    (is (= (sort (used-numbers puzzle [1 1])) [0 1 2]))))

(deftest test-open-positions
  (testing "open-positions"
    (is (= (open-positions puzzle) '([1 1] [1 2] [2 0] [3 3])))))

(deftest test-free-numbers
  (testing "free-numbers"
    (is (= (free-numbers puzzle [1 1]) '(3)))))

(deftest test-find-next-moves
  (testing "find-next-moves"
    (is (= (find-next-moves puzzle)
           '({:position [1 1], :number 3}
             {:position [1 2], :number 0}
             {:position [2 0], :number 1}
             {:position [3 3], :number 2})))))

(deftest test-solved
  (testing "solved?"
    (is (= (solved? puzzle) false))))
