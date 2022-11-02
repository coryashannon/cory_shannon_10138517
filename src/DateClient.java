import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DateClient {

    private Socket aSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;
    private BufferedReader stdIn;

    public DateClient(String serverName, int portNumber) {

        try {
            aSocket = new Socket(serverName, portNumber);
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
            socketOut = new PrintWriter(aSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void commmunicate() {
        String line = "";
        String response = "";
        boolean running = true;

        while (!line.contentEquals("QUIT")) {

            try {
                System.out.println("Please enter an option (DATE/TIME)");
                line = stdIn.readLine();
                socketOut.println(line);
                response = socketIn.readLine();
                System.out.println(response);

            } catch (Exception e) {
                // TODO: handle exception
                e.getStackTrace();
            }

        }

        try {
            stdIn.close();
            socketIn.close();
            socketOut.close();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

    public static void main(String[] args) {
        DateClient myClient = new DateClient("localhost", 9090);
        myClient.commmunicate();
    }

}
