package model;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 
/**
 * The purpose of this class is to create a the board of a tic tac toe game
 * represented by rows and columns
 * Implements the constants chars requried for a tic tac toe game X, O, ' '
 * 
 * @author M.Moshirpour
 * @version 1.0
 * @since Sept, 2022
 * 
 *        * note that all getters and settters are assumed to be self
 *        explanitory and not needed in java docs
 */

public class Board implements Constants {
	private char theBoard[][];
	private int markCount;

	/**
	 * Constructs a Board object using a 2D array of type char
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * A getter method that returns the position (row and column) where a player
	 * wishes to play their X or O piece
	 * 
	 * @param row row where person wants to play piece
	 * @param col column where person wants to play piece
	 * @return theBoard with the newly played piece
	 */

	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * Checks to see if all the positions in the board are used
	 * A tic tac toe game has a max of 9 moves total
	 * 
	 * @return boolean used as a condition to terminate or continue the game
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Checks to see if the player assigned with X pices wins the game
	 * 
	 * @return boolean condition used to end game
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Checks to see if the player assigned with O pices wins the game
	 * 
	 * @return boolean condition used to end game
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Displays the board and formats it using other methods into a table
	 * represetning a tic tac toe board
	 * 
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Adds either an X or O in the position the player indicates
	 * 
	 * @param row  the row position the player wants to play
	 * @param col  the column position the player wants to play
	 * @param mark either the X or O character the player is using
	 */
	public void addMark(int row, int col, char mark) {

		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Clears the board and starts a new game
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks the board after a player places a piece to determine if their X/O has
	 * 3 in a row
	 * 
	 * @param mark the token that the player is playing with
	 * @return result the
	 */

	// would love to hear the thought process around creating thi
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Helps to format the board
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Helps to format the board
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Helps to format the board
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
