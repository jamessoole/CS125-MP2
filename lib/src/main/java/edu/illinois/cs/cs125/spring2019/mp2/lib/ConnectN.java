package edu.illinois.cs.cs125.spring2019.mp2.lib;

//import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

/**
 * our class bois.
 */
public class ConnectN {
    /** maximum width. */
    private static final int MAX_WIDTH = 16;
    /** maximum height. */
    private static final int MAX_HEIGHT = 16;
    /** maximum N. */
    private static final int MIN_N = 4;
    /** minimum height. */
    private static final int MIN_HEIGHT = 6;
    /** minimum width. */
    private static final int MIN_WIDTH = 6;

    /** th width.*/
    private int width;
    /*** the height.*/
    private int height;
    /*** the nvalue.*/
    private int nValue;
    /** the board of type player. */
    private Player[][] board;
    /** if game has started */
    private boolean gameStart = false;


    /** new board with height, width, and n initialized.
     * Note that this method should not reject invalid values.
     * attempts to set the width, height, or N value to invalid ~.
     * value should lead to them being uninitialized. (acheived by setters)
     *
     * For example, new ConnectN(1, 10, 4) should return a ConnectN game with width=0,.
     * height=10, and N=0, since 1 is an invalid width (too small) and N cannot
     * be set until the width is defined.
     * @param setWidth sets width.
     * @param setHeight sets height.
     * @param setN sets n.**/
    ConnectN(final int setWidth, final int setHeight, final int setN) {
        width = setWidth;
        height = setHeight;
        nValue = setN;
        board = new Player[width][height];
    }

    /** new board with nothing initialized. */
    ConnectN() {
        board = new Player[0][0];
        nValue = 0;
    }

    /** new board with width and height initialized.
     * @param setWidth sets width.
     * @param setHeight sets height. **/
    ConnectN(final int setWidth, final int setHeight) {
        width = setWidth;
        height = setHeight;
        board = new Player[width][height];
    }

    /** new board with dimensions and n of another board.
     * @param otherBoard   another board of same shape and n value. **/
    ConnectN(final ConnectN otherBoard) {
        width = otherBoard.width;
        height = otherBoard.height;
        board = new Player[width][height];
        nValue = otherBoard.nValue;
    }


    /**
     * Class method to create a new ConnectN board.
     * Unlike the class constructor, static methods can return null on failure.
     * Sometimes these methods are referred to as static factory methods.
     * This method should return null if its arguments are invalid.
     * Otherwise, it should return a new ConnectN instance.
     *
     * Parameters:
     * @param width the width.
     * @param height the height.
     * @param n the n value.
     * @return ConnectN
     **/
    //probably right
    public static ConnectN create(final int width, final int height, final int n) {
        if (width < MIN_WIDTH || width > MAX_WIDTH || height < MIN_HEIGHT || height > MAX_HEIGHT) {
            return null;
        }
        if (n < MIN_N || n > MAX_WIDTH - 1 || n > MAX_HEIGHT - 1) {
            return null;
        }
        return new ConnectN();
    }

    /**
     * Creates multiple new ConnectN instances.
     * Like create(), createMany should return null if the parameters are invalid.
     * Otherwise, it should return an array of newly-created ConnectN instances.
     * @param number number of instances created.
     * @param width the width.
     * @param height the height.
     * @param n n value.
     * @return ConnectN makes many instances of connectN.
     **/
    private static ConnectN[] createMany(final int number, final int width, final int height, final int n) {
        ConnectN[] myArray = new ConnectN[number];
        for (int i = 0; i < number; i++) {
            ConnectN newBoard = new ConnectN(width, height, n);
            myArray[i] = newBoard;
        }
        return myArray;
    }

    /**
     * This method should compare two ConnectN boards. Two boards are equal if:
     * they have the same dimensions
     * they have the same n value
     * they have tiles by the same players in the same position
     * You can use the Player.equals method to compare two players.
     * @param firstBoard idk yet.
     * @param secondBoard the board.
     * @return idk yet.
     */
    public static boolean compareBoards(final ConnectN firstBoard, final ConnectN secondBoard) {
        if (firstBoard.width == secondBoard.width && firstBoard.height == secondBoard.height) {
            if (firstBoard.nValue == secondBoard.nValue) {
                for (int i = 0; i < firstBoard.width; i++) {
                    for (int j = 0; j < firstBoard.height; j++) {
                        if (firstBoard.board[i][j].equals(secondBoard.board[i][j])) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    /** Compare any number of ConnectN boards.
     * This method takes a variadic number of arguments.
     * It should return true if all the boards are the same.
     * See the notes on compareBoards(first, second) for a definition of board equality.
     * @param boards input boards.
     * @return true if boards r equal.
     */
    public static boolean compareBoards(final ConnectN... boards) {
        for (int i = 0; i < boards.length - 1; i++) {
            if (!compareBoards(boards[i], boards[i + 1])) {
                return false;
            }
        }
        return true;
    }



    /**
     * Fails if the width is invalid,
     * or if the game has already started.
     * If the new width would cause the current N value to become invalid,
     * setWidth should reset the current N value to zero.
     * @param setWidth this set the width.
     * @return boolean true if able to set width.
     */
    private boolean setWidth(final int setWidth)  {
        if (gameStart == true) {
            return false;
        }
        if (width < MAX_WIDTH && width > MIN_WIDTH) {
            width = setWidth;
            if (setN(nValue) == false) {
                nValue = 0;
            }
            return true;
        }
        return false;
    }



    /**
     * Fails if the height is invalid,
     * or if the game has already started.
     * If the new height would cause the current N value to become invalid,
     * setHeight should reset the current N value to zero.
     * @param setHeight sets the height.
     * @return boolean true if able to set height.
     */
    private boolean setHeight(final int setHeight) {
        if (gameStart == true) {
            return false;
        }
        if (height < MAX_HEIGHT && height > MIN_HEIGHT) {
            height = setHeight;
            if (setN(nValue) == false) {
                nValue = 0;
            }
            return true;
        }
        return false;
    }



    /**
     * N cannot be set after the game has started.
     * N cannot be set before the width or the height
     * N cannot be less than 4
     * N can be at most 1 less than the maximum of the width and height
     * So on a 6x10 board, the minimum N value is 4 and the maximum is 9.
     * On a 10x8 board, the minimum is 4 and the maximum is 9.
     * Setting N should never affect the width or the height.
     * @param setN sste n yo.
     * @return true if able to set n.
     */
    private boolean setN(final int setN) {
        if (gameStart == true) {
            return false;
        }
        if (width == 0 || height == 0) {
            return false;
        }
        if (setN > MIN_N && (setN < MAX_WIDTH - 1 || setN < MAX_HEIGHT - 1)) {
            nValue = setN;
            return true;
        }
        return false;
    }






    /**
     * @return int
     */
    public int getWidth() {
        return width;
    }
    /**
     * @return int
     */
    public int getHeight() {
        return height;
    }
    /**
     * @return int
     */
    public int getN() {
        return nValue;
    }





    //STILL TO COMPLETE





    /** YVUB.
     * @param player the player
     * @param setX column value
     * @param setY row value
     * @return true if able to set
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
        return false;
    }


    /**
     *
     * @param player the player.
     * @param setX column value.
     * @return true if able to set n.
     */
    public boolean setBoardAt(final Player player, final int setX) {
        int x;
        return true;
    }


    /**
     * @return the board/player array?
     */
    private Player[][] getBoard() {
        //if widht/height exist, retrun board
        //esle. return null
        return null;
    }

    /**
     * @param getX column value
     * @param getY row value
     * @return the player
     */
    public Player getBoardAt(final int getX, final int getY) {
        return null;
    }

    /**
     * @return player who won
     */
    public Player getWinner() {
        return null;
    }
}
