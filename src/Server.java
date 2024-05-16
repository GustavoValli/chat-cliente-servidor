import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4000);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        Scanner scanner = new Scanner(System.in);
        new ServerThread(socket).start();
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        while (socket.isConnected()) {
            printStream.println("Server: " + scanner.nextLine());
        }
    }
}