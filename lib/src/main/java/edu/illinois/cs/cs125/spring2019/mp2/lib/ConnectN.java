package edu.illinois.cs.cs125.spring2019.mp2.lib;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

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

    /** th width.
     */
    public int width;
    /**
     * the height.
     * */
    private int height;
    /**
     * the nvalue.
     */
    private int nValue;


    /** new board with nothing initialized. */
    ConnectN() {
        int[][] board = new int[width][height];
        //how to make of undef length
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
    /** new board with dimensions and n of another board.
     * @param otherBoard   another board to copy shape and n value. **/
    ConnectN(final ConnectN otherBoard) {
        int[][] board = new int[otherBoard.width][otherBoard.height];
        nValue = otherBoard.nValue;
    }


    /**
     * creates a new board.
     * @param width the width.
     * @param height the height.
     * @param n the n value.
     * @return ConnectN
     **/
    public static ConnectN create(final int width, final int height, final int n) {
        /**
        if (width > MAX_WIDTH || width < MIN_WIDTH) {
            return null;
        }
        if (height > MAX_HEIGHT || height < MIN_HEIGHT) {
            return null;
        }
         */
        if (setWidth(width) == true && setHeight(height) == true && setN(n) == true) {
            ConnectN board = new ConnectN(width, height, n);
            return board;
        }
        return null;
    }

    /**
     * @param number number of instances created.
     * @param width the width.
     * @param height the height.
     * @param n n value.
     * @return ConnectN makes many instances of connectN.
     **/
    private static ConnectN[] createMany(final int number, final int width, final int height, final int n) {
        //like above, but many instances
        if (setWidth(width) == true && setHeight(height) == true && setN(n) == true) {
            for (int i = 0; i < number; i++) {
                ConnectN board = new ConnectN(width, height, n);
            }
            return null;
    }

    /**
     * compares boards.
     * @param firstBoard idk yet.
     * @param secondBoard the board.
     * @return idk yet.
     */
    private static boolean compareBoards(final ConnectN firstBoard, final ConnectN secondBoard) {
        if (firstBoard.width == secondBoard.width && firstBoard.height == secondBoard.height) {
            if (firstBoard.nValue == secondBoard.nValue) {
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        if (firstBoard[i][j] == secondBoard[i][j]) {
                            return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    // 2 compare board, one with 2 input, one with any number o finputs



    /**
     * @param setWidth this set the width.
     */
    private boolean setWidth(final int setWidth) {
        // fails if inputs invalid
        if (width < MAX_WIDTH && width > MIN_WIDTH) {
            if (setN(nValue) == true) {
                width = setWidth;
                return true;
            }   else if (setN(nValue) == false) {
                nValue = 0;
                width = setWidth;
                return true;
            }
        }
        return false;
    }
    /**
     * @param setHeight sets the height.
     */
    private boolean setHeight(final int setHeight) {
        if (height < MAX_HEIGHT && height > MIN_HEIGHT) {
            if (setN(nValue) == true) {
                height = setHeight;
                return true;
            }   else if (setN(nValue) == false) {
                nValue = 0;
                height = setHeight;
                return true;
            }
        }
        return false;
    }
    /**
     * @param setN sste n yo.
     */
    private boolean setN(final int setN) {
        //static is right?
        // fails if inputs invalid
        if (width == null || height == null)
        if (setN < MIN_N || setN > MAX_WIDTH - 1 || setN > MAX_HEIGHT - 1) {
            System.out.println("hey");
        }   else {
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

    /**
     * @param player the player
     * @param setX column value
     * @param setY row value
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {

    }


    /**
     *
     * @param player the player
     * @param setX column value.
     */
    public boolean setBoardAt(final Player player, final int setX) {
        int x;
    }


    /**
     * @return smthn
     */
    private Player[][] getBoard() {
        //if widht/height exist, retrun board
        //esle. return null
        return null;
        return board;
    }

    /**
     * @param getX column value
     * @param getY row value
     * @return the board?
     */
    public Player getBoardAt(final int getX, final int getY) {
        return null;
    }

    /**
     * @return who won
     */
    public Player getWinner() {
        return null;
    }
}
