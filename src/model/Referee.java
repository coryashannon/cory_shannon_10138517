package model;

public class Referee {

    Player xPlayer;
    Player oPlayer;
    Board board;

    public Referee() {
    };

    /**
     * The referee starts the game by setting the opponents which links the two
     * players
     * then displays the board
     * then inititates the play() method
     * * note that all getters and settters are assumed to be self explanitory and
     * not needed in java docs
     */
    public void runTheGame() {
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);

        board.display();
        oPlayer.play();
        xPlayer.play();
        oPlayer.play();
        xPlayer.play();
        oPlayer.play();
        xPlayer.play();
        oPlayer.play();
        xPlayer.play();
        oPlayer.play();

    }

    /**
     * Sets the board
     * 
     * @param board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Sets the o player
     * 
     * @param oPlayer
     */
    void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * sets the x player
     * 
     * @param xPlayer
     */
    void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }

    String getName(Player player) {
        return player.name;

    }

}
