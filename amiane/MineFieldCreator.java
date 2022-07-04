import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class MineFieldCreator {

    private static final String PROMPT = "Type the width and height of the minefield you want to generate (Type 0 to exit).";
    private static final String WIDTH_PROMPT = "What is the width? ";
    private static final String HEIGHT_PROMPT = "What is the height? ";
    private static final String FREQUENCY_PROMPT = "What percent of the mines do we want (0 - 100)? ";
    private static final String FILE_NAME = "minesweeper_input.txt";
    private static final String MINE = "*";
    private static final String NO_MINE = ".";
    private final Scanner SC;
    private int myHeight;
    private int myWidth;
    private int myFrequency;

    public static void main(String[] args){
        new MineFieldCreator();
    }

    public MineFieldCreator() {
        SC = new Scanner(System.in);

        System.out.println(PROMPT);
        getInput();

        try {
            FileWriter myWriter = new FileWriter(FILE_NAME);
            Random r = new Random();

            while (myWidth != 0 && myHeight != 0) {

                StringBuilder mineField = new StringBuilder();
                mineField.append(myHeight + " " + myWidth+ "\n");

                for (int i = 0; i < myHeight; i++) {
                    for (int j = 0; j < myWidth; j++) {
                        int rInt = r.nextInt(101);
                        if (rInt > 0 && rInt <= myFrequency) {
                            mineField.append(MINE);
                        } else {
                            mineField.append(NO_MINE);
                        }
                    }
                    mineField.append("\n");
                }
                
                myWriter.write(mineField.toString());
                System.out.print(mineField.toString());
                getInput();
            }

            myWriter.write("0 0");
            System.out.print("0 0");
            myWriter.close();

          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    
    private void getInput() {
        System.out.printf(HEIGHT_PROMPT);
        myHeight = SC.nextInt();
        System.out.printf(WIDTH_PROMPT);
        myWidth = SC.nextInt();
        System.out.printf(FREQUENCY_PROMPT);
        myFrequency = SC.nextInt();
    }
}