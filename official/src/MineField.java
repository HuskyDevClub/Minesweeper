/*
 * MineField.java
 * Griffin Ryan, Yudong Lin, Elijah Amian
 */
/**
 * MineField is an Object for Minesweeper to use as a
 * game board in a session.
 * 
 * Instiating a MineField object will fill a 2D char array's
 * 'safe' spots (. not *) with hint/number indicators.
 *
 * @author Griffin Ryan (glryan@uw.edu)
 * @author Yudong Lin (yudong9912@gmail.com)
 * @author Elijah Amian (elijah25@uw.edu)
 * @version 0.1.0
 */
public final class MineField {

    private final char[][] myField;
    private final int[][] myHint;

    /**
     * MineField constructor will create a MineField object
     * containing a 2D array for the field with bombs, and
     * a 2D array for the generated hints.
     *
     * @param theField 2D character array with the Minesweeper board.
     */
    public MineField(final char[][] theField) {
        this.myField = theField;
        this.myHint = new int[this.getRow() + 2][this.getColumn() + 2];

        for (int y = 0; y < this.getRow(); y++) {
            for (int x = 0; x < this.getColumn(); x++) {

                if (this.myField[y][x] == '*') {
                    for (int y1 = y; y1 < y + 3; y1++) {
                        for (int x1 = x; x1 < x + 3; x1++) {
                            myHint[y1][x1] += 1;
                        }
                    }
                }
            }
        }
    }

    /**
     * getRow returns the size of myField's row.
     *
     * @return Length of myField's row.
     */
    public int getRow() {
        return this.myField.length;
    }

    /**
     * getColumn returns the size of myField's column.
     *
     * @return Length of myField's column.
     */
    public int getColumn() {
        return this.myField[0].length;
    }

    /**
     * getHint generates the hints and places them on the
     * Minesweeper board.
     *
     * @return String result is the generated hints to a string.
     */
    public String getHint() {
        final StringBuilder result = new StringBuilder();

        for (int y = 0; y < this.getRow(); y++) {
            for (int x = 0; x < this.getColumn(); x++) {
                if (this.myField[y][x] == '*') {
                    result.append('*');
                } else {
                    result.append(this.myHint[y + 1][x + 1]);
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}
