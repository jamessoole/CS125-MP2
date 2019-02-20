package edu.illinois.cs.cs125.spring2019.mp2.lib;

/**
 * our class bois.
 */
class ConnectN {
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

    /**
     * @param width
     */
    private int width;
    /**
     * @param height
     */
    private int height;
    /**
     * @param nValue
     */
    private int nValue;


    /** new board with nothing initialized. */
    ConnectN() {
        int[][] board = new int[][];
        //how to make of undef length
    }
    /** new board with dimensions and n of another board.
     * @param otherBoard   another board to copy shape and n value. **/
    ConnectN(final ConnectN otherBoard) {
        int[][] board = new int[otherBoard.length][otherBoard[0].length];
        // this doesnt workkkk??????
    }
    /** new board with width and height initialized.
     * @param setWidth sets width.
     * @param setHeight sets height. **/
    ConnectN(final int setWidth, final int setHeight) {
        width = setWidth;
        height = setHeight;
        int[][] board = new int[width][height];
    }
    /** new board with height, width, and n initialized.
     * @param setWidth sets width.
     * @param setHeight sets height.
     * @param setN sets n.**/
    ConnectN(final int setWidth, final int setHeight, final int setN) {
        width = setWidth;
        height = setHeight;
        nValue = setN;
        int[][] board = new int[width][height];
        //set n value??
    }


    /**
     * creates a new board
     * @param width the width.
     * @param height the height.
     * @param n the n value.
     * @return ConnectN
     **/
    public static ConnectN create(final int width, final int height, final int n) {
        if (width == null || height == null || n == null) {
            return null;
        }
        ConnectN board = new ConnectN();
        return board;
    }

    /**
     * @param number number of instances created.
     * @param width the width.
     * @param height the height.
     * @param n n value.
     * @return ConnectN makes many instances of connectN.
     **/
    public static ConnectN[] createMany(final int number, final int width, final int height, final int n) {
        //like above, but many instances
    }

    public static boolean compareBoards(Object o, ConnectN board) {
    }
    // 2 compare board, one with 2 input, one with any number o finputs



    /**
     * @param setWidth
     */
    public boolean setWidth(final int setWidth) {
        // fails if inputs invalid
        width = setWidth;
    }
    /**
     * @param setHeight
     */
    public boolean setHeight(final int setHeight) {
        // fails if inputs invalid
        //if
        height = setHeight;
    }
    /**
     * @param setN
     */
    public boolean setN(final int setN) {
        // fails if inputs invalid
        if (setN < MIN_N || setN > MAX_WIDTH - 1 || setN > MAX_HEIGHT - 1) {
            continue; // do nothing
        }   else {
            nValue = setN;
        }
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

    /**
     * @param player the player
     * @param setX column value
     * @param setY row value
     * @return smthn
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {

    }


    /**
     *
     * @param player the player
     * @param setX column value
     * @return somthn
     */
    public boolean setBoardAt(Player player, int setX) {

    }


    /**
     * @return smthn
     */
    public Player[][] getBoard() {
    }

    /**
     * @param getX column value
     * @param getY row value
     * @return
     */
    public Player getBoardAt(final int getX, final int getY) {
    }

    /**
     * @return who won
     */
    public Player getWinner() {
    }
}
