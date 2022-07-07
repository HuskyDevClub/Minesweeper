/*
 * Field.java
 * Griffin Ryan
 */
import java.util.Random;

/**
 * Field is an Object for InputGenerator to instaniate as a
 * game board to be used in a single round of Minesweeper.
 * 
 * Instiating a Field object will fill a 2D char array 'myBoard'
 * with either safe tiles (.) or bombs (*) with the bombChance
 * double determining chance of bomb/safe.
 * 
 * @author Griffin Ryan (glryan@uw.edu)
 * @version 0.0.1
 */
public class Field {

    private int myRows;
    private int myColumns;
    private int myLocation;
    private char[][] myBoard;
    private double bombChance;

    /**
     * Constructor for the Field object. 
     * 
     * @param theRows rows for the game board.
     * @param theColumns columns for the game board.
     * @param theLocation the order in which the game board is.
     */
    public Field(int theRows, int theColumns, int theLocation) {

        this.myRows = theRows;
        this.myColumns = theColumns;
        this.myLocation = theLocation;

        this.myBoard = new char[theRows][theColumns];
        this.bombChance = 0.20; // Chance for a placed tile to be a bomb.
        Random r = new Random();

        /* Create the myBoard[][] using bombChance double. */
        for (int i = 0; i < myRows; i++) {
            for (int j = 0; j < myColumns; j++) {

                if (r.nextDouble() < bombChance) {
                    myBoard[i][j] = '*';
                } else {
                    myBoard[i][j] = '.';
                }
            }
        }
    }

    /**
     * @return myRows
     */
    public int getRows() {
        return this.myRows;
    }

    /**
     * @return myColumns
     */
    public int getColumns() {
        return this.myColumns;
    }

    /**
     * @return myLocation
     */
    public int getLocation() {
        return this.myLocation;
    }

    /**
     * @return myBoard
     */
    public char[][] getBoard() {
        return this.myBoard;
    }

}
