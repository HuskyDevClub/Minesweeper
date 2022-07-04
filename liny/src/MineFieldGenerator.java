/**
 * @author Yudong Lin
 * @Date July 4th, 2022
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public final class MineFieldGenerator {
    public static void main(String[] args) {
        final Scanner _scanner = new Scanner(System.in);
        System.out.println("# PLease enter row:");
        final int _row = _scanner.nextInt();
        System.out.println("# PLease enter column:");
        final int _column = _scanner.nextInt();
        System.out.println("# PLease enter the percentage of mine:");
        final double _percentage = _scanner.nextDouble();
        final var mineField = MineFieldGenerator.generate(_row, _column, _percentage);
        System.out.printf("%d %d\n", _row, _column);
        for (final char[] _rowOfMine : mineField) {
            System.out.println(String.copyValueOf(_rowOfMine));
        }
    }

    private static char[][] generate(final int row, final int column, final double percentage) {
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

    private static void ensureValidInput(final int row, final int column, final double percentage) {
        if (percentage < 0 || percentage > 1) {
            throw new NumberFormatException("The percentage has to be between 0.0 and 1.0");
        } else if (row < 1 || row > 100) {
            throw new NumberFormatException("The row has to be between 1 and 100");
        } else if (column < 1 || column > 100) {
            throw new NumberFormatException("The column has to be between 1 and 100");
        }
    }

    private static char[][] new2dArray(final int row, final int column, final char _data) {
        final char[][] _matrix = new char[row][column];
        for (final char[] _row : _matrix) {
            Arrays.fill(_row, _data);
        }
        return _matrix;
    }
}
