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

    /** th width.*/
    private int width;
    /*** the height.* */
    private int height;
    /*** the nvalue.*/
    private int nValue;

    private Player[][] board;


    /** new board with height, width, and n initialized.
     * Note that this method should not reject invalid values.
     * attempts to set the width, height, or N value to invalid ~.
     * value should lead to them being uninitialized.
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
        board = new Player[otherBoard.width][otherBoard.height]; //does this work??
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
        ConnectN newConnect = new ConnectN(width, height, n);
        return newConnect;
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
        for (int i = 0; i < number; i++) {
            ConnectN newBoard = new ConnectN(width, height, n);
        }
        return null;
    }

    /**
     * compares boards.
     * @param firstBoard idk yet.
     * @param secondBoard the board.
     * @return idk yet.
     */
    public static boolean compareBoards(final ConnectN firstBoard, final ConnectN secondBoard) {
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
     * Fails if the width is invalid,
     * or if the game has already started.  <------------------
     * If the new width would cause the current N value to become invalid,
     * setWidth should reset the current N value to zero.
     * @param setWidth this set the width.
     */
    private boolean setWidth(final int setWidth) {
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
     * or if the game has already started. <-------------
     * If the new height would cause the current N value to become invalid,
     * setHeight should reset the current N value to zero.
     * @param setHeight sets the height.
     */
    private boolean setHeight(final int setHeight) {
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
     * N cannot be set after the game has started * <----------------------
     * N cannot be set before the width or the height  <----------------------
     * N cannot be less than 4
     * N can be at most 1 less than the maximum of the width and height
     * So on a 6x10 board, the minimum N value is 4 and the maximum is 9.
     * On a 10x8 board, the minimum is 4 and the maximum is 9.
     * Setting N should never affect the width or the height.
     * @param setN sste n yo.
     */
    private boolean setN(final int setN) {
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







    /**
     * @param player the player
     * @param setX column value
     * @param setY row value
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
        return false;
    }


    /**
     *
     * @param player the player
     * @param setX column value.
     */
    public boolean setBoardAt(final Player player, final int setX) {
        int x;
        return true;
    }


    /**
     * @return smthn
     */
    private Player[][] getBoard() {
        //if widht/height exist, retrun board
        //esle. return null
        return null;
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
