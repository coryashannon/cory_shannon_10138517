import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket aSocket;
    private ServerSocket serverSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;

    public Server(int port) {
        // communicate via sockets
        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // boolean palindrome_logic(String line) {
    // boolean is_palindrome = true;

    // int len_line = line.length() - 1;

    // for (int i = 0; i < line.length(); i++) {
    // if (line.charAt(i) == line.charAt(len_line)) {
    // continue;
    // } else {
    // is_palindrome = false;
    // }

    // }
    // return is_palindrome;
    // }

    public void palindrome() {
        String line = null;

        while (true) {
            try {
                line = socketIn.readLine();

                // line = line + " test";
                // socketOut.println(line);

                if (line.equals("QUIT")) {
                    line = "Good Bye";
                    socketOut.println(line);
                    break;
                }

                // boolean check_palindrome = palindrome_logic(line);

                boolean ispalindrome = true;
                int len = line.length() - 1;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == line.charAt(len)) {
                        len--;
                        ispalindrome = true;
                    } else {
                        ispalindrome = false;
                        line = line + " is not a palindrome";
                        break;
                    }
                }

                if (ispalindrome) {
                    line = line + " is a palindrome";
                    socketOut.println(line);
                } else if (!ispalindrome) {
                    socketOut.println(line);
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {

        try {
            Server myServer = new Server(8099);
            myServer.aSocket = myServer.serverSocket.accept();
            System.out.println("console at server side: connection accepted");
            myServer.socketIn = new BufferedReader(new InputStreamReader(myServer.aSocket.getInputStream()));
            myServer.socketOut = new PrintWriter(myServer.aSocket.getOutputStream(), true);

            myServer.palindrome();

            myServer.socketIn.close();
            myServer.socketOut.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

}
