import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static final Scanner _scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("1 for customize random mine field, 2 for loading mine fields from a file:");
        final int opt = _scanner.nextInt();
        switch (opt) {
            case 1 -> customize();
            case 2 -> loadFromFile(args);
        }
    }

    private static void customize() {
        System.out.println("PLease enter row:");
        final int _row = _scanner.nextInt();
        System.out.println("PLease enter column:");
        final int _column = _scanner.nextInt();
        System.out.println("PLease enter the percentage of mine:");
        final double _percentage = _scanner.nextDouble();
        final var mineField = MineFieldGenerator.generate(_row, _column, _percentage);
        for (final char[] _rowOfMine : mineField) {
            System.out.println(Arrays.toString(_rowOfMine));
        }
        System.out.println(new MineField(mineField).getHint());
    }

    private static void loadFromFile(String[] args) throws IOException {
        final List<String> _lines;
        if (args.length == 1) {
            _lines = (new BufferedReader(new FileReader(args[0]))).lines().toList();
        } else {
            System.out.println("PLease enter mine field:");
            _lines = new ArrayList<>();
            while (_scanner.hasNext()) {
                _lines.add(_scanner.next());
            }
        }
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
                output.append((new MineField(mineField)).getHint());
                index += _row + 1;
                output.append("\n");
            } else {
                break;
            }
        }
        System.out.println(output);
    }

}
