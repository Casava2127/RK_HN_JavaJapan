import java.util.Scanner;

public class Bai17 {
    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Các số nguyên tố nhỏ hơn hoặc bằng 9 + ");
        for (int i = 2; i <= 9; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
