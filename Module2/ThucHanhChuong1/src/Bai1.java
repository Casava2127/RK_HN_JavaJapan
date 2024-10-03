public class Bai1 {
    public static double maxValue(double a, double b, double c) {
        // if-else
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }

        // Ternary operator
       // return (a > b && a > c) ? a : (b > a && b > c) ? b : c;
    }
    //Tìm max của 3 biến a,b,c (Dùng if, if…else, ?:)
    public static void main(String[] args) {
        double a=5, b=5, c=7;
        System.out.println("Max a,b,c is : " + maxValue(a,b,c));
    }
}
