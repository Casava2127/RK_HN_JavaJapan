package DataStructures.Advanced;

class DownloadTask extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("📥 Đang tải file... " + (i * 20) + "%");
            try {
                Thread.sleep(500); // giả lập tải mất 0.5s mỗi bước
            } catch (InterruptedException e) {
                System.out.println("Download bị gián đoạn!");
            }
        }
        System.out.println("✅ Tải file xong!");
    }
}
