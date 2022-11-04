package model;

import java.util.Scanner;

/**
 * Player class to establish opponent and the players involved in the game
 * * note that all getters and settters are assumed to be self explanitory and
 * not needed in java docs
 */
public class Player {

    String name;
    char mark;
    Player opponent;
    Board board;

    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;

        // should know it's opponent and the board
        // construct board and oppoent in this constructor?
    }

    /**
     * method to check conditions for terminating the game based on the boards state
     * X wins, O wins, board is full
     * then promts the makeMove() method invoked on either playerx or player o
     */

    public void play() {

        if (board.xWins()) {
            System.out.println(opponent.getName().name + " wins the game");
            // System.out.println("Player X wins");
            System.exit(1);
        }

        if (board.oWins()) {
            System.out.println(opponent.getName().name + " wins the game");
            // System.out.println("Player O wins");
            System.exit(1);
        }

        if (board.isFull()) {
            System.out.println("Game is a draw");
            System.exit(1);
        }

        makeMove();

    }

    /**
     * asks the player to make a move by entering the row and colung numbers
     * then puts an X or O by calling the addMark() method
     */
    public void makeMove() {
        // asks the player to make a move by entering the row and colung numbers
        // then puts an X or O by calling the addMark() method

        System.out.println(opponent.name + " what row should your next " + opponent.mark + " be placed in?");
        Scanner scn = new Scanner(System.in);
        String rowString = scn.next();
        int row = Integer.parseInt(rowString);

        System.out.println(opponent.name + " what column should your next " + opponent.mark + " be placed in?");
        Scanner scn2 = new Scanner(System.in);
        String colString = scn.next();
        int column = Integer.parseInt(colString);

        board.addMark(row, column, opponent.mark);
        board.display();

        // scn.close();
        // scn2.close();

    }

    /**
     * sets opponent
     * 
     * @param opponent the opposite character (oppoennte of x is o)
     */

    public void setOpponent(Player opponent) {
        // connects other player with this player
        this.opponent = opponent;
    }

    /**
     * Sets the board
     * 
     * @param board - passed into setter
     */

    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * to get the name of the opponent
     * 
     * @return returns the oppoenent player
     */

    Player getName() {
        return opponent;

    }

}
