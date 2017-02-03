package Sudoku;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class SudokuTest {

	// Several sudoku puzzles to test with.
	private Sudoku puzzle1;
	private Sudoku puzzle2;
	private Sudoku solvedPuzzle;

	/**
	 * Create a few puzzles to test on.
	 */
	@org.junit.Before
	public void Before() {
		try {
			puzzle1 = new Sudoku("Sudoku1.txt");
			puzzle2 = new Sudoku("Sudoku2.txt");
			solvedPuzzle = new Sudoku("Sudoku4.txt");
		} catch (Exception e) {
			System.out.println("File(s) bad.");
		}

	}

	/**
	 * Test our valid_for_row method by checking values against rows that we
	 * know the validity of.
	 */
	@Test
	public void test_valid_for_row() {

		assertEquals(false, puzzle2.valid_for_row(0, 4));

		assertEquals(false, puzzle2.valid_for_row(5, 8));

		assertEquals(true, puzzle2.valid_for_row(6, 8));
	}

	/**
	 * Test our valid_for_column method by checking values against columns that
	 * we know the validity of.
	 */
	@Test
	public void test_valid_for_column() {

		assertEquals(true, puzzle2.valid_for_column(0, 4));

		assertEquals(false, puzzle2.valid_for_column(5, 9));

		assertEquals(true, puzzle2.valid_for_column(8, 8));
	}

	/**
	 * Test our valid_for_box method by checking values against boxes that we
	 * know the validity of.
	 */
	@Test
	public void test_valid_for_box() {
		assertEquals(true, puzzle2.valid_for_box(0, 7));

		assertEquals(false, puzzle2.valid_for_box(4, 7));

		assertEquals(false, puzzle2.valid_for_box(8, 3));

		assertEquals(true, puzzle2.valid_for_box(6, 7));
	}

	/**
	 * Test more general is_valid to make sure that once we have confirmed each
	 * of the separate validity tests, we don't have some logic somewhere that's
	 * faulty.
	 */
	@Test
	public void test_is_valid() {
		assertEquals(true, puzzle2.is_valid(0, 7));

		assertEquals(true, puzzle2.is_valid(44, 2));

		assertEquals(false, puzzle2.is_valid(44, 3));

		assertEquals(true, puzzle2.is_valid(24, 3));
	}

	/**
	 * Make sure we can prune our HashSets of certain numbers.
	 */
	@Test
	public void test_prune_row() {
		ArrayList<HashSet<Integer>> possibilities = new ArrayList<>();
		for (int index = 0; index < 81; index++) {
			// For each of the 81 spots in the puzzle, create a hashset of
			// possible values 1-2
			HashSet<Integer> possibleSet = new HashSet<>();
			for (int possibility = 1; possibility <= 2; possibility++) {
				possibleSet.add(possibility);
			}
			possibilities.add(index, possibleSet);
		}
		Sudoku.prune_row(possibilities, 0, 1);
		for (int i = 0; i < 9; i++) {
			assertEquals("[2]", (possibilities.get(i).toString()));
			// the value of 1 should be eliminated from all compatible rows
		}
		//////////////////////////////////
		possibilities = new ArrayList<>();
		for (int index = 0; index < 81; index++) {
			// For each of the 81 spots in the puzzle, create a hashset of
			// possible values 1-3
			HashSet<Integer> possibleSet = new HashSet<>();
			for (int possibility = 1; possibility <= 3; possibility++) {
				possibleSet.add(possibility);
			}
			possibilities.add(index, possibleSet);
		}
		Sudoku.prune_row(possibilities, 6, 1);
		for (int i = 0; i < 9; i++) {
			// the value of 1 should be eliminated from all compatible rows so
			// that 2 and 3 are still options
			assertEquals("[2, 3]", (possibilities.get(i).toString()));
		}
		Sudoku.prune_row(possibilities, 5, 3);
		for (int i = 0; i < 9; i++) {
			// if 3 is also gone then 2 is the only option
			// also the position mentioned refer to the same row so the
			// difference in position still affects the same cells
			assertEquals("[2]", (possibilities.get(i).toString()));
		}
	}

	/**
	 * Make sure we can prune our HashSets of certain numbers.
	 */
	@Test
	public void test_prune_column() {
		ArrayList<HashSet<Integer>> possibilities = new ArrayList<>();
		for (int index = 0; index < 81; index++) {
			// For each of the 81 spots in the puzzle, create a hashset of
			// possible values 1-2
			HashSet<Integer> possibleSet = new HashSet<>();
			for (int possibility = 1; possibility <= 2; possibility++) {
				possibleSet.add(possibility);
				// adds the values 1 and 2
			}
			possibilities.add(index, possibleSet);
		}
		Sudoku.prune_column(possibilities, 2, 2);
		// removes a 2 from all positions on the same column as position of 2
		for (int currentRow = 0; currentRow < 9; currentRow++) {
			assertEquals("[1]", possibilities.get(2 + (9 * currentRow)).toString());
			// since 2 is gone from these, 1 is the only possible number left
		}
		//////////////////////////////////
		possibilities = new ArrayList<>();
		for (int index = 0; index < 81; index++) {
			// For each of the 81 spots in the puzzle, create a hashset of
			// possible values 1-3
			HashSet<Integer> possibleSet = new HashSet<>();
			for (int possibility = 1; possibility <= 3; possibility++) {
				possibleSet.add(possibility);
			}
			possibilities.add(index, possibleSet);
		}
		Sudoku.prune_column(possibilities, 5, 1);
		// Removes only the value of 1 so that values of 2 and 3 should still be
		// present
		for (int i = 0; i < 9; i++) {
			assertEquals("[2, 3]", (possibilities.get(5 + (9 * i)).toString()));
		}
		Sudoku.prune_column(possibilities, 5, 3);
		// Removes only the value of 3 so that values of 2 should be the only
		// one still be present
		for (int i = 0; i < 9; i++) {
			assertEquals("[2]", (possibilities.get(5 + (9 * i)).toString()));
		}

	}

	/**
	 * Make sure we can prune our HashSets of certain numbers.
	 */
	@Test
	public void test_prune_box() {
		ArrayList<HashSet<Integer>> possibilities = new ArrayList<>();
		for (int index = 0; index < 81; index++) {
			// For each of the 81 spots in the puzzle, create a hashset of
			// possible values 1-2
			HashSet<Integer> possibleSet = new HashSet<>();
			for (int possibility = 1; possibility <= 2; possibility++) {
				possibleSet.add(possibility);
			}
			possibilities.add(index, possibleSet);
		}
		Sudoku.prune_box(possibilities, 34, 1);
		for (int currentRow = 3; currentRow < 6; currentRow++) {
			// the box should be the the fifth box due to given constraints
			for (int currentCol = 6; currentCol < 9; currentCol++) {
				// the box should be the the fifth box due to given constraints
				// 1 is wiped out
				assertEquals("[2]", (possibilities.get((9 * currentRow) + currentCol).toString()));
			}
		}
		possibilities = new ArrayList<>();
		for (int index = 0; index < 81; index++) {
			// For each of the 81 spots in the puzzle, create a hashset of
			// possible values 1-2
			HashSet<Integer> possibleSet = new HashSet<>();
			for (int possibility = 1; possibility <= 3; possibility++) {
				possibleSet.add(possibility);
			}
			possibilities.add(index, possibleSet);
		}
		Sudoku.prune_box(possibilities, 34, 1);
		// any values on the same box should affect the code the same way
		for (int currentRow = 3; currentRow < 6; currentRow++) {
			// the box should be the the fifth box due to given constraints
			for (int currentCol = 6; currentCol < 9; currentCol++) {
				// the box should be the the fifth box due to given constraints
				assertEquals("[2, 3]", (possibilities.get((9 * currentRow) + currentCol).toString()));
				// gets rid of only 1
			}
		}
		Sudoku.prune_box(possibilities, 34, 2);
		// any values on the same box should affect the code the same way
		for (int currentRow = 3; currentRow < 6; currentRow++) {
			for (int currentCol = 6; currentCol < 9; currentCol++) {
				assertEquals("[3]", (possibilities.get((9 * currentRow) + currentCol).toString()));
				// gets rid of 2 as well.
			}
		}

	}

	/**
	 * Make sure the function to verify our puzzles as complete or not works as
	 * expected.
	 */
	@Test
	public void test_verify() {
		// Make sure solved puzzle comes back as solved.
		assertTrue(solvedPuzzle.verify());
		// And the inverse.
		assertFalse(puzzle1.verify());
	}

	/**
	 * Make sure continue solve tells the system to continue solving if there is
	 * a HashSet of size one.
	 */
	@Test
	public void test_continue_solve() {
		ArrayList<HashSet<Integer>> possibilities = new ArrayList<>();
		for (int index = 0; index < 81; index++) {
			// For each of the 81 spots in the puzzle, create a hashset of
			// possible values 1-2
			HashSet<Integer> possibleSet = new HashSet<>();
			for (int possibility = 1; possibility <= 3; possibility++) {
				possibleSet.add(possibility);
			}
			possibilities.add(index, possibleSet);
		}
		// Make sure if no new solutions, kill elimination method - otherwise
		// infinite loop.
		assertFalse(puzzle1.continueSolve(possibilities));

		possibilities = new ArrayList<>();
		for (int index = 0; index < 81; index++) {
			// For each of the 81 spots in the puzzle, create a hashset of
			// possible values 1-2
			HashSet<Integer> possibleSet = new HashSet<>();
			possibleSet.add(1);
			possibilities.add(index, possibleSet);
		}
		// Make sure if new solutions, keep solving.
		assertTrue(puzzle1.continueSolve(possibilities));
	}

	/**
	 * Make sure our recursive solver solves correctly.
	 */
	@Test
	public void test_solve_recursive() {
		//Reinitialize just in case.
		try {
			puzzle1 = new Sudoku("Sudoku1.txt");
			puzzle2 = new Sudoku("Sudoku2.txt");
			solvedPuzzle = new Sudoku("Sudoku4.txt");
		} catch (Exception e) {
			System.out.println("File(s) bad.");
		}
		
		puzzle1.solve_sudoku();
		assertTrue(puzzle1.verify());
		
		puzzle2.solve_sudoku();
		assertTrue(puzzle2.verify());
	}
	
	/**
	 * Make sure our elimination solver solves correctly.
	 */
	@Test
	public void test_solve_by_elimination() {
		//Reinitialize just in case.
		try {
			puzzle1 = new Sudoku("Sudoku1.txt");
			puzzle2 = new Sudoku("Sudoku2.txt");
			solvedPuzzle = new Sudoku("Sudoku4.txt");
		} catch (Exception e) {
			System.out.println("File(s) bad.");
		}
		
		puzzle1.solve_by_elimination();
		assertTrue(puzzle1.verify());
		
		puzzle2.solve_by_elimination();
		assertTrue(puzzle2.verify());
	}
}
