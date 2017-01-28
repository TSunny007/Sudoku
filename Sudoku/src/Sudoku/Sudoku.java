/**
 * Mark Van der Merwe and Tarun Sunkaraneni
 */
package Sudoku;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Sudoku {

	/**
	 * Declare fields here as needed.
	 *
	 * Remember - the puzzle should (for our purposes) be a one dimensional
	 * array
	 */
	private int[] puzzle;
	private int guessCount;

	/**
	 * Constructor
	 */
	public Sudoku() {
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
		return null;
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
		return false;
	}

	/**
	 * Function: valid_for_col (see above)
	 */
	private boolean valid_for_column(int col, int number) {
		return false;
	}

	/**
	 * Function: valid_for_box (see above)
	 *
	 * The sudoku boxes are:
	 *
	 * 0 | 1 | 2 
	 * ---+---+--- 
	 * 3 | 4 | 5 
	 * ---+---+--- 
	 * 6 | 7 | 8
	 *
	 * where each box represents a 3x3 square in the game.
	 *
	 */
	private boolean valid_for_box(int box, int number) {
		return false;
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
		return false;
	}

	/**
	 * Function: toString( )
	 *
	 * @return a string showing the state of the board
	 *
	 */
	@Override
	public String toString() {
		return null;
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
