/*
 * Main.java
 * Griffin Ryan
 */
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
 * @version 0.0.1
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
		ArrayList<String> input = parseInput();
		StringBuilder output = new StringBuilder();
		int totalMineFields = 0;
		int rows = 0;
		int columns = 0;
		

		// TO-DO: Make the hints and print them out to an
		//		  output .txt file using System.out.
		for(int i = 0; i < input.size(); i++){
			if(input.get(i).contains("*") || input.get(i).contains(".")){
				

			} else {
				String s = input.get(i);
				Scanner sc = new Scanner(s);

				totalMineFields++;
				rows = sc.nextInt();
				columns = sc.nextInt();
			}
		}

        System.out.println(output);
    }

	/**
	 * parseInput will store System.in lines and return them
	 * in an ArrayList of <String> type.
	 * 
	 * @return parseInput returns an ArrayList where each
	 * 	string of the System.in input is parsed into
	 * 	the list.
	 */
	private static ArrayList<String> parseInput(){
		ArrayList<String> input = new ArrayList<>(5800);
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			input.add(scanner.nextLine());
		}

		return input;
	}
}
