(defproject sudoku-solver "1.0.0"
  :description "Sudoku solver (4x4 version)"
  :url "github.com/jacquesattack/sudoku_solver"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot sudoku-solver.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
