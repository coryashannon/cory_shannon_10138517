package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import model.Board;

public class ClientTicTacToe {

    private Socket aSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;
    private BufferedReader stdIn;

    private ArrayList<String> theMoves = new ArrayList<>();
    String name;
    String mark;

    private Board clientBoard;

    public ClientTicTacToe(String serverName, int portNumber) {
        try {
            aSocket = new Socket(serverName, portNumber);
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
            socketOut = new PrintWriter(aSocket.getOutputStream(), true);
            clientBoard = new Board();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void commmunicate() {

        String line = "";
        String response = "";

        while (true) {
            try {
                line = socketIn.readLine();

                if (line.contains("name")) {
                    System.out.println(line);
                    response = stdIn.readLine();
                    socketOut.println(response);
                }

                else if (line.contains("Waiting") || line.contains("Ready")) {
                    System.out.println(line);
                }

                else if (line.contains("row") || line.contains("column")) {
                    System.out.println(line);
                    response = stdIn.readLine();
                    theMoves.add(response);
                    socketOut.println(response);
                }

                // else if (line.contains("column")) {
                // System.out.println(line);
                // response = stdIn.readLine();
                // socketOut.println(response);
                // }

            } catch (IOException e) {
                e.getStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        ClientTicTacToe myClient = new ClientTicTacToe("localhost", 9090);
        myClient.commmunicate();
    }

}
