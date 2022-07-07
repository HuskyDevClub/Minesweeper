/*
 * InputGenerator.java
 * Griffin Ryan
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * InputGenerator takes user input to create a .txt
 * file to use for the Minesweeper application.
 * 
 * @author Griffin Ryan (glryan@uw.edu)
 * @version 0.0.1
 */
public class InputGenerator {

	/**
	 * The main method will call create a Field[] and
	 * prompt the user via the command-line for the
	 * dimensions of each particular field.
	 * 
	 * @param args command line arguments.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 0;

		System.out.println("\nWelcome to the InputGenerator.\n");
		System.out.print("Please specify the number of fields to generate: ");
		int numOfFields = input.nextInt();
		System.out.println("\n\t...now generating " + numOfFields + " fields for Minesweeper.\n");

		Field[] userFields = createFields(numOfFields, input);

		printMineFields(userFields);

		input.close();
		System.out.println("\n\n\tDone! Check minesweeper_input.txt for the generated file.\n");
	}

	/**
	 * createFields creates a 2D array for the number of fields
	 * specified by the user.
	 * 
	 * @param theNum number of fields to create.
	 * @param theInput user input.
	 * @return
	 */
	private static Field[] createFields(int theNum, Scanner theInput) {

		Field[] result = new Field[theNum];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < 50; j++) {
				System.out.print("-");
			}

			System.out.print("\nPlease specify the number of rows for Field " + i + ": ");
			int rows = theInput.nextInt();

			System.out.print("\nPlease specify the number of columns for Field " + i + ": ");
			int columns = theInput.nextInt();

			result[i] = new Field(rows, columns, i);
		}

		for (int j = 0; j < 50; j++) {
			System.out.print("-");
		}
		return result;
	}

	/**
	 * printMineFields writes the Field[] object
	 * to a .txt file using PrintWriter.
	 * 
	 * @param theUserFields the Field[] to be printed.
	 */
	private static void printMineFields(Field[] theUserFields) {
		File minesweeper_input = null;
		PrintWriter writer = null;

		try {
			minesweeper_input = new File("minesweeper_input.txt");
			writer = new PrintWriter(minesweeper_input);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < theUserFields.length; i++) {
			/* Select the next board to print. */
			int rows = theUserFields[i].getRows();
			int columns = theUserFields[i].getColumns();
			char[][] temp = theUserFields[i].getBoard();
			writer.print(rows + " " + columns);

			/* Print out the individual board. */
			for (int j = 0; j < rows; j++) {
				writer.println();
				for (int k = 0; k < columns; k++) {
					writer.print(temp[j][k]);
				}
				if (j == rows - 1 && i != theUserFields.length - 1) {
					writer.println();
				}
			}

		}

		writer.flush();
		writer.close();
	}

}
