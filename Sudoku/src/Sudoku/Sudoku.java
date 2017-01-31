/**
 * Mark Van der Merwe and Tarun Sunkaraneni
 */
package Sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Sudoku {

	// Integer array representing all the values in our puzzle.
	private int[] puzzle = new int[81];
	// Number of guesses for the recursive solver.
	private int guessCount;

	/**
	 * Constructor
	 */
	public Sudoku(String fileName) {
		File sudokuFile = new File("src/puzzles/" + fileName);
		try {
			Scanner scanner = new Scanner(sudokuFile);
			int index = 0;
			// Parse the puzzle file and place the values inside of our puzzle
			// array.
			while (scanner.hasNextInt()) {
				int s = scanner.nextInt();
				puzzle[index] = s;
				index++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found!");
			e.printStackTrace();
		}

		this.valid_for_box(2, 1);
	}

	/**
	 * Create a new puzzle by reading a file
	 *
	 * the file should be 9 rows of 9 numbers separated by whitespace
	 *
	 */
	public Sudoku(BufferedReader reader) {
	}

	/**
	 * @return a copy of the puzzle as a 2D matrix
	 */
	public int[][] get_puzzle() {
		int[][] puzzleMatrix = new int[9][9];
		// Cycle through the rows and columns of the 2D puzzle matrix.
		for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++) {
				// To get value, must add which column we're in to nine times
				// the row so that it lines up correctly.
				puzzleMatrix[row][column] = puzzle[(row * 9) + column];
			}
		}
		return puzzleMatrix;
	}

	/**
	 * @return how many guesses it took to recursively solve the problem.
	 */
	public int get_guess_count() {
		return this.guessCount;
	}

	/**
	 * Function: valid_for_row
	 *
	 * Description: Determine if the given number can be placed in the given row
	 * without violating the rules of sudoku
	 *
	 * Inputs:
	 * 
	 * @input row : which row to see if the number can go into
	 * @input number: the number of interest
	 *
	 *        Outputs:
	 *
	 *        true if it is possible to place that number in the row without
	 *        violating the rule of 1 unique number per row.
	 *
	 *        In other words, if the given number is already present in the row,
	 *        it is not possible to place it again (return false), otherwise it
	 *        is possible to place it (return true);
	 * 
	 *        WARNING: call this function before placing the number in the
	 *        puzzle...
	 *
	 */
	private boolean valid_for_row(int row, int number) {
		if (row > 8 || row < 0 || number < 1 || number > 9) {
			throw new IndexOutOfBoundsException();
		}
		int currentRow = 9 * row;
		for (int currentColumn = 0; currentColumn < 9; currentColumn++) {
			if (puzzle[currentRow + currentColumn] == number) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Function: valid_for_col (see above)
	 */
	private boolean valid_for_column(int col, int number) {
		if (col > 8 || col < 0 || number < 1 || number > 9) {
			throw new IndexOutOfBoundsException();
		}
		for (int currentRow = 0; currentRow < 9; currentRow += 9) {
			if (puzzle[col + currentRow] == number) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Function: valid_for_box (see above)
	 *
	 * The sudoku boxes are:
	 *
	 * 0 | 1 | 2 ---+---+--- 3 | 4 | 5 ---+---+--- 6 | 7 | 8
	 *
	 * where each box represents a 3x3 square in the game.
	 *
	 */
	private boolean valid_for_box(int box, int number) {
		// Determine which row/col to start in based on box.
		int rowStart = box;
		int colStart = 3 * (box % 3);

		for (int row = rowStart; row < rowStart + 3; row++) {
			for (int col = colStart; col < colStart + 3; col++) {
				// For each value in box, test if it is the given number.
				if (this.puzzle[9 * row + col] == number) {
					return false;
				}
			}
		}
		// If we reach here, the value is valid because it's not present in the
		// box.
		return true;
	}

	/**
	 *
	 * Function is_valid( position, value )
	 *
	 * Determine if the given value is valid in the puzzle at that position.
	 *
	 * Inputs:
	 * 
	 * @param position
	 *            - which bucket in the puzzle to check for validity - should be
	 *            empty
	 * @param possible_value
	 *            - the value to check (1-9)
	 * 
	 * @return true if valid
	 */
	private boolean is_valid(int position, int possible_value) {
		return false;
	}

	/**
	 * solve the sudoku problem
	 * 
	 * @return true if successful
	 */
	public boolean solve_sudoku() {
		return false;
	}

	/**
	 *
	 * Function solve_sudoku( puzzle, position )
	 *
	 * Recursively check to see if the puzzle can be solved following class
	 * algorithm
	 *
	 * Inputs: position - the index of the "current" box in the array (should be
	 * set to 0 by initial call)
	 *
	 */
	public boolean solve_sudoku(int position) {
		int valueAtIndex = puzzle[position];

		// If not value present, then attempt to solve that position.
		if (valueAtIndex == 0) {
			// Iterate through the possible solutions for this position.
			for (int possibleSolution = 1; possibleSolution <= 9; possibleSolution++) {
				// Check if it is a valid solution.
				if (is_valid(position, possibleSolution)) {
					// If valid and last value in array, return true (puzzle
					// solved!)
					// This is our BASE CASE:
					if (position == 80) {
						return true;
					}

					// If true tell the next position to solve.
					if (solve_sudoku(position + 1)) {
						// If it returns true, return true to signal that the
						// current value set works.
						return true;
					}
				}
			}
			// If we reach here then no values work at that position and we need
			// to
			// change the previous position's value.
			return false;
		} else {
			// If number is set before, we still need to be able to recurse
			// "through" it.
			if (solve_sudoku(position + 1)) {
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * Function: toString( )
	 *
	 * @return a string showing the state of the board
	 *
	 */
	@Override
	public String toString() {
		String puzzleString = "";
		// Get puzzle as matrix.
		int[][] puzzle = get_puzzle();

		// iterate through the puzzle and paste with space after each number and
		// new line after each row.
		for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++) {
				puzzleString += puzzle[row][column] + " ";
			}
			puzzleString += "\n";
		}

		return puzzleString;
	}

	/**
	 * Given a puzzle (filled or partial), verify that every element does not
	 * repeat in row, col, or box.
	 * 
	 * @return true if a validly solved puzzle
	 */
	public boolean verify() {
		return false;
	}

	/**
	 * Attempt to solve a sudoku by eliminating obviously wrong values Algorithm
	 *
	 * 1) build a 81 (representing 9x9) array of sets 2) put a set of 1-9 in
	 * each of the 81 spots 3) do initial elimination for each known value,
	 * eliminate nubmers from sets in same row, col, box eliminate all values in
	 * the given square 4) while progress is being made (initially true) find a
	 * non-processed square with one possible answer and eliminate this number
	 * from row, col, box
	 */
	public void solve_by_elimination() {
		// Each HashSet represents all possible values (1-9) for each position
		// in our puzzle.
		ArrayList<HashSet> possibilites = new ArrayList<>();
		for (int index = 0; index < 81; index++) {
			// For each of the 81 spots in the puzzle, create a hashset of
			// possible values 1-9
			HashSet<Integer> possibleSet = new HashSet<>();
			for (int possibility = 1; possibility <= 9; possibility++) {
				possibleSet.add(possibility);
			}
			possibilites.add(index, possibleSet);
		}

		do {
			// Write solving code here.
		} while (!verify());
	}

	/**
	 * print a grid showing all possible valid answers This should be a 27x27
	 * matrix.
	 *
	 * I would suggest you do this first to get good debugging help
	 * 
	 * @param possibilities
	 *            - array list of all the sets of 1-9s
	 */
	private static void print_possibilities(ArrayList<HashSet<Integer>> possibilities) {
	}

	/**
	 * Given a possibility constraint matrix (81 sets of [1-9]) remove the given
	 * number from every matrix in the given box
	 * 
	 * @param possibilities
	 *            - 81 sets of [1-9]
	 * @param position
	 *            - where the value exists (transform to row,col)
	 * @param value
	 *            - the value to prune
	 */
	private static void prune_box(ArrayList<HashSet<Integer>> possibilities, int position, Integer value) {
	}

	private static void prune_column(ArrayList<HashSet<Integer>> possibilities, int position, Integer value) {
	}

	private static void prune_row(ArrayList<HashSet<Integer>> possibilities, int position, Integer value) {
	}

	/**
	 * Add any private helper functions you need as appropriate
	 */

}
