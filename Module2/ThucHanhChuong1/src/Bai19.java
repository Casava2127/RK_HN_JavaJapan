public class Bai19 {
    // Hàm in n số Fibonacci đầu tiên
    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Dãy Fibonacci: " + a + " " + b);

        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(" " + next);
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        int n = 10; // Số lượng chữ số Fibonacci muốn in ra (thay đổi tại đây)
        printFibonacci(n);
    }
}
