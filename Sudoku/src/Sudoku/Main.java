/**
 * Mark Van der Merwe and Tarun Sunkaraneni
 */
package Sudoku;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Main method to run tests on our two Sudoku solvers.
 * 
 * @author markvandermerwe and tarunsunkaraneni
 *
 */
public class Main {
	/**
	 * Run tests against the puzzles provided by classmates.
	 */
	public static void main(String[] args) {
		for (int puzzleNum = 0; puzzleNum < 40; puzzleNum++) {
			Sudoku puzzle = null;
			try {
				puzzle = new Sudoku("/sample_puzzles/puzzle" + puzzleNum + ".txt");
				System.out.println(puzzleNum);
				System.out.println(puzzle.percentComplete());

				// Solve test w/ brute-force recursion:
				puzzle.solve_sudoku();
				System.out.println(puzzle.get_guess_count());

				// Solve test w/ elimination:
				// puzzle.solve_by_elimination();
				// System.out.println(puzzle.percentComplete());
			} catch (Exception e) {
				System.out.println("Puzzle " + puzzleNum + " failed to load.");
			}
		}
	}

}
