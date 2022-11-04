package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Board;
import model.GameThread;

public class ServerTicTacToe {

    private Board serverBoard;
    private ArrayList<String> theMoves = new ArrayList<String>();

    private ServerSocket serverSocket;
    private ExecutorService executor;

    private Socket xSocket;
    private BufferedReader xSocketIn;
    private PrintWriter xSocketOut;

    private Socket oSocket;
    private BufferedReader oSocketIn;
    private PrintWriter oSocketOut;

    public ServerTicTacToe(int port) {

        try {
            serverSocket = new ServerSocket(port);
            executor = Executors.newFixedThreadPool(10);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startServer() {

        try {

            while (true) {

                // connect xSocket to the server
                xSocket = serverSocket.accept();
                xSocketIn = new BufferedReader(new InputStreamReader(xSocket.getInputStream()));
                xSocketOut = new PrintWriter(xSocket.getOutputStream(), true);
                System.out.println("A client is connected, waiting for another client to connect......");

                // connect oSocket to the server
                oSocket = serverSocket.accept();
                oSocketIn = new BufferedReader(new InputStreamReader(oSocket.getInputStream()));
                oSocketOut = new PrintWriter(oSocket.getOutputStream(), true);
                System.out.println("A second client has conneted starting the game!");

                GameThread theGame = new GameThread(xSocketIn, xSocketOut, oSocketIn, oSocketOut);
                executor.execute(theGame);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        try {
            xSocketIn.close();
            xSocketOut.close();
            oSocketIn.close();
            oSocketOut.close();
            xSocket.close();
            oSocket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //

    }

    public static void main(String[] args) {
        ServerTicTacToe myServer = new ServerTicTacToe(9090);
        myServer.startServer();
    }

}
