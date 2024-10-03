public class Bai16 {
    // kiemtra so doi xung
    public static boolean isPalindrome(int n) {
        int temp = n;
        int reverse = 0;
        while (temp > 0) {
            int digit = temp % 10;
            reverse = reverse * 10 + digit;
            temp /= 10;
        }
        return n == reverse;
    }
//    display
    public static void main(String[] args) {
        int n = 2321;
        if (isPalindrome(n)) {
            System.out.println(n + " la so doi xung.");
        } else {
            System.out.println(n + " khong la so doi xung.");
        }
    }
}

