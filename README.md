# sudoku_solver

Sudoku Solver (4x4 version).

## Usage

See unit tests for puzzle format

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

    (solve puzzle)

## License

Copyright © 2020 jacquesattack

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
