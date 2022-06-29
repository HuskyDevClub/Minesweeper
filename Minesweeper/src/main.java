import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        final var _lines = (new BufferedReader(new FileReader(("minesweeper_input.txt")))).lines().toList();
        int index = 0;
        final var output = new StringBuilder();
        int totalMineFields = 1;

        while (index < _lines.size()) {
            final var mineFieldInfo = _lines.get(index).split("\\s+");
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
                output.append((new Field(mineField)).getHint());
                index += _row + 1;
                output.append("\n");
            } else {
                break;
            }
        }

        Files.writeString(Paths.get("output.txt"), output.toString(), StandardCharsets.UTF_8);
    }
}
