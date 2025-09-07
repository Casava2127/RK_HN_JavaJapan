package DataStructures.Advanced;

public class DataProcessing implements Runnable{
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("⚙️ Đang xử lý dữ liệu... bước " + i);
            try {
                Thread.sleep(700); // giả lập xử lý mất 0.7s
            } catch (InterruptedException e) {
                System.out.println("Xử lý dữ liệu bị gián đoạn!");
            }
        }
        System.out.println("✅ Xử lý dữ liệu xong!");
    }
}
