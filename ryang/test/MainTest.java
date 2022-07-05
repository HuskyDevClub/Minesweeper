/*
 * MainTest.java
 * Griffin Ryan
 */

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * MainTest is a JUnit test case
 * for the Minesweeper project.
 *
 * JUnit checks parseInput() and generateOutput() methods
 * in the Main.java class.
 *
 * @author Griffin Ryan (glryan@uw.edu)
 * @version 0.0.1
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
	void testGenerateOutput() {
	}
}
