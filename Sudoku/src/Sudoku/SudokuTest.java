package Sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

	//Two sudoku puzzles to test with.
	private Sudoku puzzle1;
	private Sudoku puzzle2;

	/**
	 * Create a few puzzles to test on.
	 */
	@org.junit.Before
	public void Before() {
		puzzle1 = new Sudoku("Sudoku1.txt");
		puzzle2 = new Sudoku("Sudoku2.txt");
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

}
