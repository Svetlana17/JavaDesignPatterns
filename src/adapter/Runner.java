package adapter;

import java.io.*;

public class Runner {

    public static void main(String[] args) throws IOException {
        OutputStreamAdapter streamAdapter = new OutputStreamAdapter(new File("file.obj"));
        String[] s = {"string 1", "string#2", "string # 3"};
        streamAdapter.write(s);
        streamAdapter.close();
        System.out.println("Data is written");

        BufferedReader in = new BufferedReader(new FileReader("file.obj"));
        String str;

        System.out.println("Data from file");
        while ((str = in.readLine()) != null) {
            System.out.println(str);
        }
    }
}
