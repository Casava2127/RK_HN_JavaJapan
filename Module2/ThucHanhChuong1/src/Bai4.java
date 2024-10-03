public class Bai4 {
    // Giải hệ phương trình bậc nhất:
    //ax+by=c
    //dx+ey=f
    // Giá trị determinant D = ad - bc
    public static double determinant(double a, double b, double c, double d, double e, double f) {
        return a * e - b * d;
    }

    // Giải hệ phương trình bậc 2:
    //ax+by=c
    //dx+ey=f
    public static double[] solveEquation(double a, double b, double c, double d, double e, double f) {
        double D = determinant(a, b, c, d, e, f);
        if (D == 0) {
            System.out.println("Phương trình có vô số nghiệm.");
            return null;
        }

        double x = (c * e - b * f) / D;
        double y = (a * f - c * d) / D;

        return new double[]{x, y};

    }

    public static void main(String[] args) {
        double a = 1;
        double b = 2;
        double c = 3;
        double d = 4;
        double e = 5;
        double f = 6;

        double[] solutions = solveEquation(a, b, c, d, e, f);
        if (solutions!= null) {
            System.out.printf("Nghiệm của phương trình: x = %.2f, y = %.2f%n", solutions[0], solutions[1]);
        }
    }
}
