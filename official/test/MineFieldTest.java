/*
 * MineFieldTest.java
 * Yudong Lin, Griffin Ryan, Elijah Amian
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
/**
 * MineFieldTest is a JUnit test case
 * for the Minesweeper project.
 *
 * JUnit checks getRow(), getColumn(), and getHint() methods
 * in the MineField.java class.
 *
 * @author Yudong Lin (yudong9912@gmail.com)
 * @author Griffin Ryan (glryan@uw.edu)
 * @author Elijah Amian (elijah25@uw.edu)
 * @version 0.1.0
 */
class MineFieldTest {

	/**
	 * test100x100AllMines() tests the edge cases of 100x100 all mines
	 *
	 * @see MineField
	 */
	@Test
	void test100x100AllMines() {
		final var testMineField = new MineField(MineFieldGenerator.generate(100, 100, 1.0));
		// test to see whether the minefield has correct shape
		Assertions.assertEquals(100, testMineField.getRow(), "The getRow() method should return a value of 100");
		Assertions.assertEquals(100, testMineField.getColumn(), "The getColumn() method should return a value of 100");
		// check if the getHint() method output the correct result
		final var expectMineData = new char[100];
		Arrays.fill(expectMineData, '*');
		final var mineFieldHint = testMineField.getHint();
		for (int i = 0; i < 100; i++) {
			Assertions.assertArrayEquals(expectMineData, mineFieldHint.substring(100 * i + i, 100 * (i + 1) + i).toCharArray(), "The current mine field should only contain mine");
		}
	}


	/**
	 * test100x100NoMines() tests the edge cases of 100x100 no mine
	 *
	 * @see MineField
	 */
	@Test
	void test100x100NoMines() {
		final var testMineField = new MineField(MineFieldGenerator.generate(100, 100, 0.0));
		// test to see whether the minefield has correct shape
		Assertions.assertEquals(100, testMineField.getRow(), "The getRow() method should return a value of 100");
		Assertions.assertEquals(100, testMineField.getColumn(), "The getColumn() method should return a value of 100");
		// check if the getHint() method output the correct result
		final var expectMineData = new char[100];
		Arrays.fill(expectMineData, '0');
		final var mineFieldHint = testMineField.getHint();
		for (int i = 0; i < 100; i++) {
			Assertions.assertArrayEquals(expectMineData, mineFieldHint.substring(100 * i + i, 100 * (i + 1) + i).toCharArray(), "The current mine field should not contain mine");
		}
	}

	/**
	 * test1x1AllMines() tests the edge cases of 1x1 all mine
	 *
	 * @see MineField
	 */
	@Test
	void test1x1AllMines() {
		final var testMineField = new MineField(MineFieldGenerator.generate(1, 1, 1.0));
		// test to see whether the minefield has correct shape
		Assertions.assertEquals(1, testMineField.getRow(), "The getRow() method should return a value of 1");
		Assertions.assertEquals(1, testMineField.getColumn(), "The getColumn() method should return a value of 1");
		// check if the getHint() method output the correct result
		final var mineFieldHint = testMineField.getHint();
		Assertions.assertEquals('*', mineFieldHint.toCharArray()[0], "The current mine field should only contain mine");
	}

	/**
	 * test1x1NoMines() tests the edge cases of 1x1 all mine
	 *
	 * @see MineField
	 */
	@Test
	void test1x1NoMines() {
		final var testMineField = new MineField(MineFieldGenerator.generate(1, 1, 0.0));
		// test to see whether the minefield has correct shape
		Assertions.assertEquals(1, testMineField.getRow(), "The getRow() method should return a value of 1");
		Assertions.assertEquals(1, testMineField.getColumn(), "The getColumn() method should return a value of 1");
		// check if the getHint() method output the correct result
		final var mineFieldHint = testMineField.getHint();
		Assertions.assertEquals('0', mineFieldHint.toCharArray()[0], "The current mine field should not contain mine");
	}
}
