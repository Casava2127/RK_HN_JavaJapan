public class Bai15 {
    // so CHINH PHUONG
    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    // display
    public static void main(String[] args){
        int num = 16;
        if (isPerfectSquare(num)) {
            System.out.println(num + " la so chinh phuong.");
        } else {
            System.out.println(num + " khong phai la so chinh phuong.");
        }
    }
}
