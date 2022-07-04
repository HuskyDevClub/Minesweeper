/**
 * @author Yudong Lin
 * @Date July 4th, 2022
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        final ArrayList<String> _lines = new ArrayList<>(5800);
        final Scanner _scanner = new Scanner(System.in);
        while (_scanner.hasNext()) {
            _lines.add(_scanner.nextLine());
        }
        int index = 0;
        final var output = new StringBuilder();
        int totalMineFields = 1;
        while (index < _lines.size()) {
            final String current_line = _lines.get(index);
            if (current_line.charAt(0) != '#') {
                final var mineFieldInfo = current_line.split("\\s+");
                final var _row = Integer.parseInt(mineFieldInfo[0]);
                final var _column = Integer.parseInt(mineFieldInfo[1]);
                if (_row > 0) {
                    output.append("Field #");
                    output.append(totalMineFields);
                    totalMineFields++;
                    output.append(":\n");
                    final var mineField = new char[_row][_column];
                    for (int i = 0; i < _row; i++) {
                        mineField[i] = _lines.get(index + 1 + i).toCharArray();
                    }
                    output.append((new MineField(mineField)).getHint());
                    index += _row + 1;
                    output.append("\n");
                } else {
                    break;
                }
            } else {
                index++;
            }
        }
        if (output.length() > 0) {
            output.deleteCharAt(output.length() - 1);
        }
        System.out.println(output);
    }
}
