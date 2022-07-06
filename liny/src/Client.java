/**
 * @author Yudong Lin
 */

import java.util.ArrayList;
import java.util.Scanner;

final public class Client {

    final static ArrayList<String> mylines = new ArrayList<>(5800);

    public static void main(String[] args) {
        updateInput();
        int index = 0;
        int totalMineFields = 1;
        final StringBuilder OUT = new StringBuilder();
        while (index < mylines.size()) {
            final String current_line = mylines.get(index);
            final var mineFieldInfo = current_line.split("\\s+");
            final int _row = Integer.parseInt(mineFieldInfo[0]);
            final int _column = Integer.parseInt(mineFieldInfo[1]);
            if (_row > 0) {
                OUT.append("Field #");
                OUT.append(totalMineFields);
                OUT.append(":\n");
                final var mineField = new char[_row][_column];
                for (int i = 0; i < _row; i++) {
                    mineField[i] = mylines.get(index + 1 + i).toCharArray();
                }
                OUT.append(new MineField(mineField).getHint());
                OUT.append("\n");
                totalMineFields++;
                index += _row + 1;
            } else {
                break;
            }
        }
        if (OUT.length() > 0) {
            OUT.deleteCharAt(OUT.length() - 1);
        }
        System.out.println(OUT);
    }

    private static ArrayList updateInput() {
        final Scanner _scanner = new Scanner(System.in);
        while (_scanner.hasNext()) {
            mylines.add(_scanner.nextLine());
        }
        return mylines;
    }
}
