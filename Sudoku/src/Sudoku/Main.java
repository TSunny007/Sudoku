/**
 * Mark Van der Merwe and Tarun Sunkaraneni
 */
package Sudoku;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author markvandermerwe and tarunsunkaraneni
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create new puzzles.
		Sudoku puzzle1 = null;
		Sudoku puzzle2 = null;
		try {
			BufferedReader file1 = new BufferedReader(new FileReader("src/puzzles/Sudoku1.txt"));
			puzzle1 = new Sudoku(file1);
			puzzle2 = new Sudoku("Sudoku2.txt");
		} catch (Exception e) {
			System.out.println("File is bad.");
		}

		// Display, then solve puzzle with elimination.
		System.out.println(puzzle1.toString());
		puzzle1.solve_by_elimination();

		// Display, then solve puzzle by brute-force recursion.
		System.out.println(puzzle2.toString());
		puzzle2.solve_sudoku();
	}

}
