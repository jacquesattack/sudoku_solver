(ns sudoku-solver.core
  (:gen-class))

(def digits (range 4))

(defn find-open-position [puzzle]
  (first 
    (remove nil? 
            (for [i digits j digits] 
              (cond (nil? (puzzle [i j])) [i j] 
                    :else nil)))))
  
(defn nums-in-row [puzzle position]
  (remove nil? (for [j digits] (puzzle [(first position) j]))))
              
(defn nums-in-col [puzzle position]
  (remove nil? (for [i digits] (puzzle [i (last position)]))))
  
(defn get-squ-digits [x] 
  (let [val (/ x 2)]
    (cond
      (>= val 1) [2 3]
      (>= val 0) [0 1])))
  
(defn nums-in-squ [puzzle position]
  (remove nil? (for [i (get-squ-digits (first position)) j (get-squ-digits (last position))] (puzzle [i j]))))
  
(defn used-numbers [puzzle position]
  (distinct 
    (concat 
      (nums-in-row puzzle position)
      (nums-in-col puzzle position)
      (nums-in-squ puzzle position))))
  
(defn open-positions [puzzle]
  (remove nil? (for [i digits j digits] (cond (nil? (puzzle [i j])) [i j] :else nil))))
  
(defn free-numbers [puzzle position]
  (remove (fn [num] (contains? (set (used-numbers puzzle position)) num)) digits))
  
(defn find-next-moves [puzzle]
  (for [position (open-positions puzzle) number (free-numbers puzzle position)]
    {:position position :number number}))
  
(defn solved? [puzzle] 
    (= (count puzzle) 16))