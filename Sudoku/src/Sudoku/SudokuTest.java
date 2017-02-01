package Sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

	@Test
	public void test_valid_for_row(){
		Sudoku puzzle = new Sudoku("Sudoku2.txt");
		assertEquals(false, puzzle.valid_for_row(0, 4));
		
		assertEquals(false, puzzle.valid_for_row(5, 8));
		
		assertEquals(true, puzzle.valid_for_row(6, 8));
	}
	
	@Test
	public void test_valid_for_column(){
		Sudoku puzzle = new Sudoku("Sudoku2.txt");
		assertEquals(true, puzzle.valid_for_column(0, 4));
		
		assertEquals(false, puzzle.valid_for_column(5, 9));
		
		assertEquals(true, puzzle.valid_for_column(8, 8));
	}
	
	@Test
	public void test_valid_for_box() {
		Sudoku puzzle = new Sudoku("Sudoku2.txt");
		
		assertEquals(true, puzzle.valid_for_box(0, 7));
		
		assertEquals(false, puzzle.valid_for_box(4, 7));
		
		assertEquals(false, puzzle.valid_for_box(8, 3));
		
		assertEquals(true, puzzle.valid_for_box(6, 7));
	}
	
	@Test
	public void test_is_valid() {
		Sudoku puzzle = new Sudoku("Sudoku2.txt");
		
		assertEquals(true, puzzle.is_valid(0, 7));
		
		assertEquals(true, puzzle.is_valid(44, 2));
		
		assertEquals(false, puzzle.is_valid(44, 3));
		
		assertEquals(true, puzzle.is_valid(24, 3));
	}

}
