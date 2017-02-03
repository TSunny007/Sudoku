Welcome to the Sudoku Solver

The current main function setup uses the recursive solver to solve the Sudoku. It will also print out the number of guesses used. If you would like to
switch to the constraint solver, simply comment out the 2 recursive lines and uncomment the 2 constraint solver lines. The comments should guide you
in which is which.

The rest of our methodology is pretty straight forward. Our main will go through all the puzzles in the provided test "package" of puzzles. Note,
diagnostics, like console prints of the puzzle state, have been removed for clarity in testing, though they can be called easily and will function. 
The current console output is:

Puzzle Number from test folder
Percentage of puzzle complete before we solve.
Then either count of guesses for recursion or percentage complete after constraint solver.

for each puzzle.