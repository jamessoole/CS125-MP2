package edu.illinois.cs.cs125.spring2019.mp2.lib;

//import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

/**
 * our class bois.
 */
public class ConnectN {
    /** maximum width. */
    public static final int MAX_WIDTH = 16;
    /** maximum height. */
    public static final int MAX_HEIGHT = 16;
    /** maximum N. */
    public static final int MIN_N = 4;
    /** minimum height. */
    public static final int MIN_HEIGHT = 6;
    /** minimum width. */
    public static final int MIN_WIDTH = 6;

    /** th width.*/
    private int width;
    /*** the height.*/
    private int height;
    /*** the nvalue.*/
    private int nValue;
    /** the board of type player. */
    private Player[][] board;
    /** if game has started.*/
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
        width = 0;
        height = 0;
        nValue = 0;
        if (setWidth <= MAX_WIDTH && setWidth >= MIN_WIDTH) {
            width = setWidth;
        }
        if (setHeight <= MAX_HEIGHT && setHeight >= MIN_HEIGHT) {
            height = setHeight;
        }
        if (setN >= MIN_N && (setN <= MAX_WIDTH - 1 || setN <= MAX_HEIGHT - 1)) {
            if (setN <= height - 1 && setN <= width - 1) {
                nValue = setN;
            }
        }
        board = new Player[width][height];
    }

    /** new board with nothing initialized. */
    ConnectN() {
        width = 0;
        height = 0;
        board = new Player[width][height];
        nValue = 0;
    }

    /** new board with width and height initialized.
     * @param setWidth sets width.
     * @param setHeight sets height. **/
    ConnectN(final int setWidth, final int setHeight) {
        width = 0;
        height = 0;
        if (setWidth <= MAX_WIDTH && setWidth >= MIN_WIDTH) {
            width = setWidth;
        }
        if (setHeight <= MAX_HEIGHT && setHeight >= MIN_HEIGHT) {
            height = setHeight;
        }
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
        if (n < MIN_N || (n > width - 1 && n > height - 1)) {
            return null;
        }
        return new ConnectN(width, height, n);
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
    public static ConnectN[] createMany(final int number, final int width, final int height, final int n) {
        if (width < MIN_WIDTH || width > MAX_WIDTH || height < MIN_HEIGHT || height > MAX_HEIGHT) {
            return null;
        }
        if (n < MIN_N || (n > width - 1 && n > height - 1)) {
            return null;
        }
        ConnectN[] myArray = new ConnectN[number];
        if (number == 0) {
            return null;
        }
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
        if (firstBoard == null || secondBoard == null) {
            return false;
        }
        if (firstBoard.width == secondBoard.width && firstBoard.height == secondBoard.height) {
            if (firstBoard.nValue == secondBoard.nValue && firstBoard != null) {
                if (firstBoard != null && secondBoard != null) {
                    for (int i = 0; i < firstBoard.width; i++) {
                        for (int j = 0; j < firstBoard.height; j++) {
                            if (firstBoard.getBoardAt(i, j) == null) {
                                if (secondBoard.getBoardAt(i, j) == null) {
                                    continue;
                                }
                                return false;
                            }
                            if (!firstBoard.getBoardAt(i, j).equals(secondBoard.getBoardAt(i, j))) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
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
    public boolean setWidth(final int setWidth)  {
        if (gameStart == true) {
            return false;
        }
        if (setWidth <= MAX_WIDTH && setWidth >= MIN_WIDTH) {
            width = setWidth;
            if (!(nValue <= width - 1 || nValue <= height - 1)) {
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
    public boolean setHeight(final int setHeight) {
        if (gameStart == true) {
            return false;
        }
        if (setHeight <= MAX_HEIGHT && setHeight >= MIN_HEIGHT) {
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
    public boolean setN(final int setN) {
        if (gameStart == true) {
            return false;
        }
        if (width == 0 || height == 0) {
            return false;
        }
        if (setN >= MIN_N && (setN <= MAX_WIDTH - 1 || setN <= MAX_HEIGHT - 1)) {
            if (setN <= height - 1 || setN <= width - 1) {
                nValue = setN;
                return true;
            }
            return false;
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
    /**Return a copy of the board.
     * Once the width and height are set, this function should not return null.
     * Until then, it should return null.
     * Note that this function should not expose the private board instance variable.
     * Any changes to the board or players returned should not affect the state of the class.
     * @return the board
     */
    public Player[][] getBoard() {
        if (width == 0 || height == 0) {
            return null;
        }
        return board.clone();
    }


    /**Get the player at a specific board position.
     * Should return null if the board position is invalid,
     * if the game has not started, or if nobody has played yet at that position.
     * Otherwise returns the player whose tile is at that position.
     * @param getX column value
     * @param getY row value
     * @return the player
     */
    public Player getBoardAt(final int getX, final int getY) {
        if (getX < 0 || getX >= width || getY < 0 || getY >= height) {
            return null;
        }
        if (gameStart == false) {
            return null;
        }
        if (board[getX][getY] == null) {
            return null;
        }
        return board[getX][getY];
    }


    //STILL TO COMPLETE





    /** Set the board at a specific position.
     * Allows a player to attempt to place a tile at a specific location on the board.
     * If the move is successful, the board should track that this player has played at
     * this location so that it can determine a winner and prevent future invalid moves.
     * A move should fail and return false if:
     * any board parameters remain uninitialized, including width, height, and N
     * the player is invalid  <-------
     * the position is invalid for this board <-------
     * the game has already ended
     * This function also needs to enforce the rules of ConnectN.
     * A tile cannot be played at a particular location if there are empty squares below it.
     * Put another way, a tile can only be placed on top of a stack of existing tiles.
     * If the requested location is invalid, you should return false and no tile
     * should be added to the board.
     * If a given play results in the game ending, future plays should fail and getWinner()
     * should return the player that won.
     * Note that the first successful call to setBoardAt represents the start of game.
     * @param player the player
     * @param setX column value
     * @param setY row value
     * @return true if able to set
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
        gameStart = true;
        if (width == 0 || height == 0 || nValue == 0 || gameStart == false || player == null) {
            return false;
        }
        if (setX < 0 || setY < 0 || setX > width - 1 || setY > height - 1) {
            return false;
        }
        if (board[setX][setY] != null) {
            return false;
        }
        if (setY == 0) {
            board[setX][setY] = player;
            return true;
        }
        if (board[setX][setY - 1] != null && setY >= 1) {
            board[setX][setY] = player;
            return true;
        }
        //run getWinner() if someone wins
        return false;
    }


    /**
     *
     * @param player the player.
     * @param setX column value.
     * @return true if able to set n.
     */
    public boolean setBoardAt(final Player player, final int setX) {
        gameStart = true;
        if (width == 0 || height == 0 || nValue == 0 || gameStart == false || player == null) {
            return false;
        }
        System.out.println("howdy fam");
        if (setX < 0 || setX > width) {
            return false;
        }


        for (int i = 0; i < height; i++) {
            if (board[setX][i] == null) {
                board[setX][i] = player;
                return true;
            }
        }
        //run getWinner() if someone wins
        return false;
    }





    /**
     * @return player who won
     */
    public Player getWinner() {
        return null;
    }
}
