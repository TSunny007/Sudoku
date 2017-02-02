/**
 * Mark Van der Merwe and Tarun Sunkaraneni
 */
package Sudoku;

/**
 * @author markvandermerwe and tarunsunkaraneni
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a new puzzle.
		Sudoku puzzle = null;
		try {
			puzzle = new Sudoku("Sudoku1.txt");
		} catch (Exception e) {
			System.out.println("File is bad.");
		}
		System.out.println(puzzle.toString());
		puzzle.solve_sudoku(0);
		System.out.println(puzzle.toString());
	}

}
