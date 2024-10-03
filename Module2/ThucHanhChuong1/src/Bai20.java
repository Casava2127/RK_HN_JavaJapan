public class Bai20 {
    // Hàm kiểm tra số K có thuộc dãy Fibonacci không và trả về vị trí của nó
    public static int checkFibonacci(int k) {
        int a = 0, b = 1;
        int position = 1; // Bắt đầu từ vị trí 1

        // Kiểm tra cho đến khi b lớn hơn hoặc bằng K
        while (a < k) {
            int next = a + b;
            a = b;
            b = next;
            position++;
        }

        // Kiểm tra nếu a bằng K thì trả về vị trí, nếu không thì trả về -1
        return (a == k) ? position : -1;
    }

    public static void main(String[] args) {
        int K = 13; // Thay đổi giá trị của K tại đây
        int position = checkFibonacci(K);

        if (position != -1) {
            System.out.println(K + " thuộc dãy Fibonacci và là phần tử ở vị trí thứ " + position);
        } else {
            System.out.println(K + " không thuộc dãy Fibonacci");
        }
    }
}
