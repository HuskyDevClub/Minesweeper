import java.util.Arrays;
import java.util.Random;

public final class MineFieldGenerator {
    public static char[][] generate(final int row, final int column, final double percentage) {
        if (percentage == 1.0) {
            return MineFieldGenerator.new2dArray(row, column, '*');
        } else if (percentage < 0) {
            throw new NumberFormatException("The percentage cannot be negative");
        } else if (percentage > 1) {
            throw new NumberFormatException("The percentage cannot be more than 1.");
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

    private static char[][] new2dArray(final int row, final int column, final char _data) {
        final char[][] _matrix = new char[row][column];
        for (final char[] _row : _matrix) {
            Arrays.fill(_row, _data);
        }
        return _matrix;
    }
}
