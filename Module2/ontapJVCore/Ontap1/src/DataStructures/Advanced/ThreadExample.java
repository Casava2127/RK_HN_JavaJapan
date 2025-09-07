package DataStructures.Advanced;

public class ThreadExample {
    public static void main(String[] args) {
        // Tạo 2 luồng: 1 cho tải file, 1 cho xử lý dữ liệu
        DownloadTask downloadThread = new DownloadTask(); // extends Thread
        Thread processingThread = new Thread(new DataProcessing()); // implements Runnable

        // Bắt đầu cả 2 luồng
        downloadThread.start();
        processingThread.start();

        // Luồng chính hiển thị progress (không bị chặn bởi 2 luồng kia)
        for (int i = 1; i <= 10; i++) {
            System.out.println("⏳ Main thread: đang theo dõi tiến trình... " + i);
            try {
                Thread.sleep(300); // nghỉ 0.3s
            } catch (InterruptedException e) {
                System.out.println("Main thread bị gián đoạn!");
            }
        }

        // Chờ 2 luồng kia hoàn thành
        try {
            downloadThread.join();
            processingThread.join();
        } catch (InterruptedException e) {
            System.out.println("Join bị gián đoạn!");
        }

        System.out.println("🎉 Tất cả công việc đã hoàn thành!");
    }
}
