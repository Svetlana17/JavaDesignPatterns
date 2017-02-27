package proxy;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static int PORT = 5000;

    private Server() {
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket listener = new ServerSocket(PORT)) {
            while (true) {
                try (Socket socket = listener.accept()) {
                    Scanner in = new Scanner(socket.getInputStream());
                    int a = in.nextInt();
                    int b = in.nextInt();

                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    out.print(a + b);
                    out.flush();
                }
            }
        }
    }
}
