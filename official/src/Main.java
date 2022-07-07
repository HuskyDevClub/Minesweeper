/*
 * Main.java
 * Griffin Ryan, Yudong Lin, Elijah Amian
 */
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Main is the executable for the Minesweeper
 * project.
 *
 * Running this will take an input .txt file as a
 * command-line argument and output to another .txt
 * file that is given as a second command-line argument.
 *
 * @author Griffin Ryan (glryan@uw.edu)
 * @author Yudong Lin (yudong9912@gmail.com)
 * @author Elijah Amian (elijah25@uw.edu)
 * @version 0.1.0
 */
final public class Main {

    /**
     * The main method will parse an input .txt file, then
     * determine the 'hints' for Minesweeper.
     *
     * Then, it prints the output to a .txt file.
     *
     * @param args command-line arguments for the program.
     */
    public static void main(final String[] args) {
        final InputStream inputStream = System.in;
        final ArrayList<String> input = parseInput(inputStream);

        final StringBuilder output = generateOutput(input);
        System.out.println(output);
    }

    /**
     * parseInput will store System.in lines and return them
     * in an ArrayList of <String> type.
     *
     * @return parseInput returns an ArrayList where each
     * string of the System.in input is parsed into the list.
     */
    public static ArrayList<String> parseInput(final InputStream theInputStream) {
        final ArrayList<String> input = new ArrayList<>(5800);
        final Scanner scanner = new Scanner(theInputStream);

        while (scanner.hasNext()) {
            input.add(scanner.nextLine());
        }

        return input;
    }

    /**
     * generateOutput will return a StringBuilder object with
     * the outputted Minesweeper fields w/ the generated hints.
     *
     * The main method will then print this StringBuilder
     * object using System.out.
     *
     * @param theInput as an ArrayList of type <String>.
     * @return output as a StringBuilder object.
     */
    public static StringBuilder generateOutput(final ArrayList<String> theInput) {
        final StringBuilder output = new StringBuilder();
        int totalMineFields = 0;
        int rows;
        int columns;
        int index = 0;

        while (index < theInput.size()) {
            final String currentLine = theInput.get(index);

<<<<<<< HEAD
			final Scanner sc = new Scanner(currentLine);
			rows = sc.nextInt();
			columns = sc.nextInt();
			totalMineFields++;

			if (rows > 0) {
				output.append("Field #");
				output.append(totalMineFields);
				output.append(":\n");

				final char[][] field = new char[rows][columns];
				for (int j = 0; j < rows; j++) {
					field[j] = theInput.get(1 + index + j).toCharArray();
				}
				output.append(new MineField(field).getHint());
				index += rows + 1;
				output.append("\n");
			} else {
				break;
			}
=======
            final Scanner sc = new Scanner(currentLine);
            rows = sc.nextInt();
            columns = sc.nextInt();
            totalMineFields++;

            if (rows > 0) {
                output.append("Field #");
                output.append(totalMineFields);
                output.append(":\n");

                final char[][] field = new char[rows][columns];
                for (int j = 0; j < rows; j++) {
                    field[j] = theInput.get(1 + index + j).toCharArray();
                }
                output.append(new MineField(field).getHint());
                index += rows + 1;
                output.append("\n");
            } else {
                break;
            }

>>>>>>> main
        }

        if (output.length() > 0) {
            output.deleteCharAt(output.length() - 1);
        }

        return output;
    }
}
