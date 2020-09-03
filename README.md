# Sudoku_solver
an implementation of recursive backtracking to solve a given sudoku puzzle
//Anthony Licea
//CS 245	
//DATA STRUCTURES AND ALGORITHMS


/*This program incorporates a recursive backtracking algorithm to solve a given sudoku board.
the board is constructed using characters, and the algorithm first determines whether a given value
is already present at a position in the 2D array. if not present, it will check which values can be
placed at the current position so that it doesn't "break the board" this process will continue until
the board is either solved, or it will return unsolvable. */
