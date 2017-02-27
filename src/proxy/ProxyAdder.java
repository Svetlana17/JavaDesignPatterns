package proxy;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

class ProxyAdder {
    private ProxyAdder() {
    }

    static int getSum(int a, int b) throws IOException {
        try (Socket sender = new Socket(InetAddress.getLocalHost(), Server.PORT)) {
            PrintWriter out = new PrintWriter(sender.getOutputStream());
            out.println(a);
            out.println(b);
            out.flush();

            Scanner in = new Scanner(sender.getInputStream());

            return in.nextInt();
        }
    }
}