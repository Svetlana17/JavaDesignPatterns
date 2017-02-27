package proxy;

public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println(ProxyAdder.getSum(3, 11));
        } catch (Exception e) {
            System.out.println("Something went terribly wrong");
        }
    }
}
