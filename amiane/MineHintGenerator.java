import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MineHintGenerator {
    
    private static final String FILE_NAME = "minesweeper_output.txt";

    public static void main(String[] args) {
        new MineHintGenerator();
    }

    private char[][] getMineField(final Scanner theSc, final int theHeight, final int theWidth) {
  
        theSc.nextLine();
        char[][] mineField = new char[theHeight][theWidth];

        for (int i = 0; i < theHeight; i++) {
            mineField[i] = theSc.nextLine().toCharArray();    
        }

        return mineField;
    }

    private String generateHints(final char[][] theMineField, final int theHeight, final int theWidth) {

        //pad hint with a border in order to handle edge of the area
        int[][] hints = new int[theHeight + 2][theWidth + 2];
        //-1 represents a mine field
        for (int y = 0; y < theHeight; y++) {
            for (int x = 0; x < theWidth; x++) {
                if (theMineField[y][x] == '*') {
                    //theMineField[y][x] == hints[y+1][x+1]
                    //add 1 to the hints around the theMineField area
                    hints[y][x] += 1;
                    hints[y][x + 1] += 1;
                    hints[y + 1][x] += 1;
                    hints[y][x + 2] += 1;
                    hints[y + 2][x] += 1;
                    hints[y + 1][x + 2] += 1;
                    hints[y + 2][x + 1] += 1;
                    hints[y + 2][x + 2] += 1;
                }
            }
        }

        for (int y = 0; y < theHeight; y++) {
            for (int x = 0; x < theWidth; x++) {
                if (theMineField[y][x] == '*') {
                    //theMineField[y][x] == hints[y+1][x+1]
                    hints[y + 1][x + 1] = -1;
                }
            }
        }

        StringBuilder hintField = new StringBuilder();
        for (int y = 1; y < hints.length - 1; y++) {
            for (int x = 1; x < hints[0].length - 1; x++) {
                char converted = hints[y][x] == -1 ? '*' : Character.forDigit(hints[y][x], 10);
                hintField.append(converted);
            }
            hintField.append("\n");
        }

        return hintField.toString();
    }

    public MineHintGenerator() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the minefields:");
        
        int height = sc.nextInt();
        int width = sc.nextInt();
        int field = 1;

        StringBuilder finalResult = new StringBuilder();

        while (height != 0 && width != 0) {
            char[][] mineField = getMineField(sc, height, width);
            String hintField = generateHints(mineField, height, width);
            finalResult.append("Field #" + field++ + ":\n");
            finalResult.append(hintField + "\n");
            height = sc.nextInt();
            width = sc.nextInt();
        }

        try {
            FileWriter myWriter = new FileWriter(FILE_NAME);
            myWriter.write(finalResult.toString());
            myWriter.close();
            System.out.println(finalResult.toString());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
