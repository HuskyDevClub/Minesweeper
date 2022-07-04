/**
 * @author Yudong Lin
 * @Date July 4th, 2022
 */

final class MineField {
    private final char[][] myMineField;
    private final int[][] myHint;

    public MineField(final char[][] _mineField) {
        this.myMineField = _mineField;
        this.myHint = new int[this.getRow() + 2][this.getColumn() + 2];
        for (int y = 0; y < this.getRow(); y++) {
            for (int x = 0; x < this.getColumn(); x++) {
                if (this.myMineField[y][x] == '*') {
                    for (int y1 = y; y1 < y + 3; y1++) {
                        for (int x1 = x; x1 < x + 3; x1++) {
                            myHint[y1][x1] += 1;
                        }
                    }
                }
            }
        }
    }

    public int getRow() {
        return this.myMineField.length;
    }

    public int getColumn() {
        return this.myMineField[0].length;
    }

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
