package model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.CoderResult;
import java.util.ArrayList;

public class GameThread implements Constants, Runnable {

    private Board theBoard;
    private Referee theRef;

    public Board getTheBoard() {
        return theBoard;
    }

    private BufferedReader xSocketIn;
    private PrintWriter xSocketOut;

    private BufferedReader oSocketIn;
    private PrintWriter oSocketOut;
    // private Player xPlayer, oPlayer;

    private ArrayList<String> theMoves = new ArrayList<>();

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                Referee theRef;
                Player xPlayer, oPlayer;
                GameThread theGame = new GameThread(xSocketIn, xSocketOut, oSocketIn, oSocketOut);

                oSocketOut.println("Waiting for X Player");
                xSocketOut.println("Please enter your name");
                String xPlayerName = xSocketIn.readLine();

                xPlayer = new Player(xPlayerName, LETTER_X);
                xPlayer.setBoard(this.theBoard);

                oSocketOut.println("Please enter your name");
                String oPlayerName = oSocketIn.readLine();

                xSocketOut.println("Ready to play");
                oSocketOut.println("Ready to play");

                xSocketOut.println("Enter the row you would like to place your mark ");
                theMoves.add(xSocketIn.readLine());

                xSocketOut.println("Enter the column you would like to place your mark ");
                theMoves.add(xSocketIn.readLine());

                // System.out.println(xPlayerName);

                // oSocketOut.println("Please enter your name");
                // String oPlayerName = oSocketIn.readLine();
                // System.out.println(oPlayerName);

                break;

            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    /**
     * Constructor of the game that creates instances of all key objects to play a
     * tic tac toe game
     */
    public GameThread(BufferedReader xSocketIn, PrintWriter xSocketOut, BufferedReader oSocketIn,
            PrintWriter oSocketOut) {
        this.theBoard = new Board();
        this.xSocketIn = xSocketIn;
        this.xSocketOut = xSocketOut;
        this.oSocketIn = oSocketIn;
        this.oSocketOut = oSocketOut;
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

    // public static void main(String[] args) throws IOException {
    // Referee theRef;
    // Player xPlayer, oPlayer;
    // BufferedReader stdin;
    // Game theGame = new Game();

    // stdin = new BufferedReader(new InputStreamReader(System.in));
    // System.out.print("\nPlease enter the name of the \'X\' player: ");
    // String name = stdin.readLine();
    // while (name == null) {
    // System.out.print("Please try again: ");
    // name = stdin.readLine();
    // }

    // xPlayer = new Player(name, LETTER_X);
    // xPlayer.setBoard(theGame.theBoard);

    // System.out.print("\nPlease enter the name of the \'O\' player: ");
    // name = stdin.readLine();
    // while (name == null) {
    // System.out.print("Please try again: ");
    // name = stdin.readLine();
    // }

    // oPlayer = new Player(name, LETTER_O);
    // oPlayer.setBoard(theGame.theBoard);

    // theRef = new Referee();
    // theRef.setBoard(theGame.theBoard);
    // theRef.setoPlayer(oPlayer);
    // theRef.setxPlayer(xPlayer);

    // theGame.appointReferee(theRef); // this calls a theRef.runTheGameMethod()

    // }

}
