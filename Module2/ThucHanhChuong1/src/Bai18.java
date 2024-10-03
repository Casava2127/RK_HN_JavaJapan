public class Bai18 {
    // Hàm kiểm tra số hoàn hảo
    public static boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {
        System.out.println("Các số hoàn hảo nhỏ hơn 1000: ");
        for (int i = 1; i < 1000; i++) {
            if (isPerfectNumber(i)) {
                System.out.println(i);
            }
        }
    }
}
