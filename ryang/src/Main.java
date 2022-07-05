/*
 * Main.java
 * Griffin Ryan
 */

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main is the exectuable for the Minesweeper
 * project.
 *
 * Running this will take an input .txt file as a
 * command-line argument and output to another .txt
 * file that is given as a second command-line argument.
 *
 * @author Griffin Ryan (glryan@uw.edu)
 * @version 0.0.2
 */
public class Main {

	/**
	 * The main method will parse an input .txt file, then
	 * determine the 'hints' for Minesweeper.
	 *
	 * Then, it prints the output to a .txt file.
	 *
	 * @param args command-line arguments for the program.
	 */
    public static void main(String[] args) {
		InputStream inputStream = System.in;
		ArrayList<String> input = parseInput(inputStream);

		StringBuilder output = generateOutput(input);
        System.out.println(output);
    }

	/**
	 * parseInput will store System.in lines and return them
	 * in an ArrayList of <String> type.
	 *
	 * @return parseInput returns an ArrayList where each
	 * string of the System.in input is parsed into the list.
	 */
	public static ArrayList<String> parseInput(InputStream theInputStream){
		ArrayList<String> input = new ArrayList<>(5800);
		Scanner scanner = new Scanner(theInputStream);

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
	public static StringBuilder generateOutput(ArrayList<String> theInput){
		StringBuilder output = new StringBuilder();
		int totalMineFields = 0;
		int rows = 0;
		int columns = 0;
		int index = 0;

		while(index < theInput.size()){
			String currentLine = theInput.get(index);

			if(currentLine.charAt(0) != '#'){
				Scanner sc = new Scanner(currentLine);
				rows = sc.nextInt();
				columns = sc.nextInt();
				totalMineFields++;

				if(rows > 0){
					output.append("Field #");
					output.append(totalMineFields);
					output.append(":\n");

					char[][] field = new char[rows][columns];
					for(int j = 0; j < rows; j++){
						field[j] = theInput.get(1 + index + j).toCharArray();
					}
					output.append(new MineField(field).getHint());
					index += rows + 1;
					output.append("\n");
				} else {
					break;
				}
			} else {
				index++;
			}
		}

		if(output.length() > 0){
			output.deleteCharAt(output.length() - 1);
		}

		return output;
	}

}
