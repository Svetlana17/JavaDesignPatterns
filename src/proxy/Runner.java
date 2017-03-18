package proxy;

import java.util.Scanner;

public class Runner {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(ProxyAdder.getSum(a, b));
        } catch (Exception e) {
            System.out.println("Something went terribly wrong");
        }
    }
}
