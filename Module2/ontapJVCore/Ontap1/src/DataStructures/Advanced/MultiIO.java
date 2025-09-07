package DataStructures.Advanced;

import java.io.*;

public class MultiIO {
    public static void main(String[] args) {
        Thread inputThread = new Thread(() -> {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Nhập tên của bạn: ");
                String name = br.readLine();
                System.out.println("Xin chào " + name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread progressThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("⏳ Đang chờ bạn nhập... " + i);
                try { Thread.sleep(1000); } catch (Exception e) {}
            }
        });

        inputThread.start();
        progressThread.start();
    }
}
