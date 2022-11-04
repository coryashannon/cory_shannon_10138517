package model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.CoderResult;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 
/**
 * The Game class runs the tic tac toe game using Referee, Player, and Board
 * Implements the constants chars for the X player and O player
 * Implements the space char for board configuration
 * 
 * note that all getters and settters are assumed to be self explanitory and not
 * needed in java docs
 */
public class Game implements Constants, Runnable {

	private Board theBoard;
	private Referee theRef;

	private

	@Override public void run() {
		// TODO Auto-generated method stub

	}

	/**
	 * Constructor of the game that creates instances of all key objects to play a
	 * tic tac toe game
	 */
	public Game() {
		this.theBoard = new Board();
	}

	/**
	 * apoints the referee then calls the runTheGame() method to start the game
	 * after players have entered their name
	 * 
	 * @param r arugment of type referee
	 * @throws IOException
	 */
	public void appointReferee(Referee r) throws IOException {
		this.theRef = r;
		theRef.runTheGame();
	}

	/**
	 * Run's the app, no args passed into the main
	 * 
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();

		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);

		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);

		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);

		theGame.appointReferee(theRef); // this calls a theRef.runTheGameMethod()

	}

}
