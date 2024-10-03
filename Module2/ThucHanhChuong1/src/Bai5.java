public class Bai5 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int stg = findMiddle(a, b, c);
        System.out.println("Số trung gian là: " + stg);
    }

    public static int findMiddle(int a, int b, int c) {
        // Kiểm tra số trung gian
        if ((a > b && a < c) || (a < b && a > c)) {
            return a;
        } else if ((b > a && b < c) || (b < a && b > c)) {
            return b;
        } else {
            return c;
        }
    }
}
