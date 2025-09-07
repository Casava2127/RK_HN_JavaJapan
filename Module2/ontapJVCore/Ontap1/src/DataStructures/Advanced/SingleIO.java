package DataStructures.Advanced;

import java.io.*;

public class SingleIO {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhập tên của bạn: ");
        String name = br.readLine();  // ⛔ Chương trình dừng lại chờ nhập
        System.out.println("Xin chào " + name);
    }
}
