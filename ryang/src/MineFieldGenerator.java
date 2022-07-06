/*
 * MineFieldGenerator.java
 * Yudong Lin
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 * MineFieldGenerator generates a minesweeper_input.txt file
 * to be used with the Minesweeper project.
 *
 * @author Yudong Lin
 */
public final class MineFieldGenerator {

	/**
	 * The executable main method for MineFieldGenerator
	 * will take user input to generate a .txt file.
	 *
	 * @param args command-line arguments.
	 * */
	public static void main(String[] args) throws IOException {
		final Scanner _scanner = new Scanner(System.in);
		final FileWriter _writer = new FileWriter("custom_minesweeper_input.txt");
		while (true) {
			System.out.println("Please enter row:");
			final int _row = _scanner.nextInt();
			System.out.println("Please enter column:");
			final int _column = _scanner.nextInt();
			System.out.println("Please enter the percentage of mine:");
			final double _percentage = _scanner.nextDouble();
			final var mineField = MineFieldGenerator.generate(_row, _column, _percentage);
			_writer.write(String.format("%d %d\n", _row, _column));
			for (final char[] _rowOfMine : mineField) {
				_writer.write(String.copyValueOf(_rowOfMine));
				_writer.write('\n');
			}
			System.out.println("Continue? (0 for yes and everything else for no):");
			if (_scanner.nextInt() != 0) {
				break;
			}
		}
		_writer.write("0 0\n");
		_writer.close();
	}

	/**
	 * generate() will return a 2D character array
	 * with a specified number of rows, columns, and bomb chance.
	 *
	 * @param row the amount of rows.
	 * @param column the amount of columns.
	 * @param percentage the percentage of bombs placed in field.
	 * @return char[][] generated minefield.
	 * */
	public static char[][] generate(final int row, final int column, final double percentage) {
		ensureValidInput(row, column, percentage);
		if (percentage == 1.0) {
			return MineFieldGenerator.new2dArray(row, column, '*');
		}
		final char[][] result = MineFieldGenerator.new2dArray(row, column, '.');
		final Random rand = new Random();
		int numOfMines = (int) (percentage * row * column);
		while (numOfMines > 0) {
			final int _x = rand.nextInt(column);
			final int _y = rand.nextInt(row);
			if (result[_y][_x] != '*') {
				result[_y][_x] = '*';
				numOfMines--;
			}
		}
		return result;
	}

	/**
	 * ensureValidInput() will check the input given by user
	 * and throw exceptions if it is not valid.
	 *
	 * @param column the amount of columns.
	 * @param row the amount of rows.
	 * @param percentage the percentage of bombs placed in the field.
	 * */
	private static void ensureValidInput(final int row, final int column, final double percentage) {
		if (percentage < 0 || percentage > 1) {
			throw new NumberFormatException("The percentage has to be between 0.0 and 1.0");
		} else if (row < 1 || row > 100) {
			throw new NumberFormatException("The row has to be between 1 and 100");
		} else if (column < 1 || column > 100) {
			throw new NumberFormatException("The column has to be between 1 and 100");
		}
	}

	/**
	 * new2dArray() will create a new 2D array using the char _data.
	 *
	 * @param row the row of field.
	 * @param column the column of field.
	 * @param _data the character to be inserted.
	 * */
	private static char[][] new2dArray(final int row, final int column, final char _data) {
		final char[][] _matrix = new char[row][column];
		for (final char[] _row : _matrix) {
			Arrays.fill(_row, _data);
		}
		return _matrix;
	}
}
