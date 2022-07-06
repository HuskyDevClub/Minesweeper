/*
 * MainTest.java
 * Griffin Ryan, Yudong Lin, Elijah Amian
 */
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
/**
 * MainTest is a JUnit test case
 * for the Minesweeper project.
 *
 * JUnit checks parseInput() and generateOutput() methods
 * in the Main.java class.
 *
 * @author Griffin Ryan (glryan@uw.edu)
 * @author Yudong Lin (yudong9912@gmail.com)
 * @author Elijah Amian (elijah25@uw.edu)
 * @version 0.1.0
 */
class MainTest {

	/**
	 * testParseInput creates an InputStream from a test_input.txt
	 * file in the classpath. Using this, parseInput() method is tested
	 * instead of whatever is passed through System.in.
	 *
	 * @see Main
	 * */
	@Test
	void testParseInput() throws FileNotFoundException {
		File testFile = new File("test_input.txt");
		InputStream is = new FileInputStream(testFile);

		ArrayList<String> listTest = Main.parseInput(is);

		assertAll("Should return lines of input from test_input.txt",
				() -> assertEquals("2 2", listTest.get(0), "Returns 1st line of test_input.txt"),
				() -> assertEquals("..", listTest.get(1), "Returns 2snd line of test_input.txt"),
				() -> assertEquals(".*", listTest.get(4), "Returns 5th line of test_input.txt")
		);
	}

	/**
	 * testGenerateOutput creates a test_output.txt file
	 * from the test_input.txt file.
	 *
	 * @see Main
	 * */
	@Test
	void testGenerateOutput() throws FileNotFoundException {
		File testIn = new File("test_input.txt");
		File testOut = new File("test_output.txt");
		InputStream is = new FileInputStream(testIn);

		ArrayList<String> listTest = Main.parseInput(is);

		StringBuilder out = Main.generateOutput(listTest);
		PrintWriter pw = new PrintWriter(testOut);
		pw.println(out);
		pw.flush();
		pw.close();

		Scanner s = new Scanner(testOut);

		assertAll("Should return lines of output from test_output.txt",
				() -> assertEquals("Field #1:", s.nextLine(), "Returns 1st line of test_output.txt"),
				() -> assertEquals("00", s.nextLine(), "Returns 2nd line of test_output.txt"),
				() -> assertEquals("00", s.nextLine(), "Returns 3rd line of test_output.txt"),
				() -> assertEquals("", s.nextLine(), "Returns 1st line of test_output.txt"),
				() -> assertEquals("Field #2:", s.nextLine(), "Returns 4th line of test_output.txt"),
				() -> assertEquals("1*", s.nextLine(), "Returns 5th line of test_output.txt"),
				() -> assertEquals("11", s.nextLine(), "Returns 6th line of test_output.txt")
		);
	}
}
