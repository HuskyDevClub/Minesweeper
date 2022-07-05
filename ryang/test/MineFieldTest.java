/*
 * MineFieldTest.java
 * Griffin Ryan
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * MineFieldTest is a JUnit test case
 * for the Minesweeper project.
 *
 * JUnit checks getRow(), getColumn(), and getHint() methods
 * in the MineField.java class.
 *
 * @author Griffin Ryan (glryan@uw.edu)
 * @version 0.0.1
 */
class MineFieldTest {

	char[][] toTest;

	/**
	 * setArray() is used to easily set a 2D char
	 * array for testing the Minefield object.
	 *
	 * @see MineField
	 * */
	void setArray() {
		char[] row1 = {'.','.','*'};
		char[] row2 = {'.','.','.'};
		char[] row3 = {'*','.','.'};
		this.toTest = new char[3][3];
		toTest[0] = row1;
		toTest[1] = row2;
		toTest[2] = row3;
	}

	/**
	 * testGetRow() tests the different charAt in the 2D char array.
	 *
	 * @see MineField
	 * */
	@Test
	void testGetRow() {
		setArray();

		assertAll("Should return size of row in Minefield object.",
				() -> assertEquals('.', toTest[0][0], "Returns 1st char of 1st row in 2D array."),
				() -> assertEquals('.', toTest[1][0], "Returns 1st char of 2nd row in 2D array."),
				() -> assertEquals('*', toTest[2][0], "Returns 2nd char of 3rd row in 2D array.")
		);
	}

	/**
	 * testGetColumn() actually tests the getRow() and getColumn() method
	 * in the Minefield object. The get() methods in the object only
	 * return the size of row/object in the current instance of Minefield.
	 *
	 * @see MineField
	 * */
	@Test
	void testGetColumn() {
		setArray();
		assertAll("Should return size of column in Minefield object.",
				() -> assertEquals(3, toTest.length, "Returns length of row in 2D array."),
				() -> assertEquals(3, toTest[0].length, "Returns length of column in 2D array.")
		);
	}

	/**
	 * testGetHint() tests the generated hints for the
	 * Minefield object. Checks using substrings.
	 *
	 * @see MineField
	 * */
	@Test
	void testGetHint() {
		setArray();
		MineField field = new MineField(this.toTest);
		String s = field.getHint();

		assertAll("Should return hints in the Minefield object.",
				() -> assertEquals("01*", s.substring(0,3), "Returns line of hints in Minefield object."),
				() -> assertEquals("121", s.substring(4,7), "Returns line of hints in Minefield object."),
				() -> assertEquals("*10", s.substring(8,11), "Returns line of hints in Minefield object.")
		);
	}
}
