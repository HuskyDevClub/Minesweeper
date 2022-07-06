/**
 * @author Yudong Lin
 */

final class MineField {
    private final char[][] myMineField;
    private final int[][] myHint;

    public MineField(final char[][] _mineField) {
        this.myMineField = _mineField;
        this.myHint = new int[this.getRow() + 2][this.getColumn() + 2];
        // loop through the 2d array and pre-generate the hint.
        for (int y = 0; y < this.getRow(); y++) {
            for (int x = 0; x < this.getColumn(); x++) {
                // if a mine is found on the current location
                if (this.myMineField[y][x] == '*') {
                    // the update the rounding area
                    for (int y1 = y; y1 < y + 3; y1++) {
                        for (int x1 = x; x1 < x + 3; x1++) {
                            myHint[y1][x1]++;
                        }
                    }
                }
            }
        }
    }

    /**
     * @return the row of MineField
     */
    public int getRow() {
        return this.myMineField.length;
    }

    /**
     * @return the column of MineField
     */
    public int getColumn() {
        return this.myMineField[0].length;
    }

    /**
     * @return the hint regarding the minefield
     */
    public String getHint() {
        final StringBuilder resultStr = new StringBuilder();
        for (int y = 0; y < this.getRow(); y++) {
            for (int x = 0; x < this.getColumn(); x++) {
                if (this.myMineField[y][x] == '*') {
                    resultStr.append('*');
                } else {
                    resultStr.append(this.myHint[y + 1][x + 1]);
                }
            }
            resultStr.append("\n");
        }
        return resultStr.toString();
    }
}
