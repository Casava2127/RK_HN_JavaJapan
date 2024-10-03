import java.io.Serializable;

public class Bai2 {
    //giai pt bac 1
    public static Serializable giaiPTBac1(double a, double b) {
        return ((a==0) ? (b==0 ?" vo so" :"Vo nghiem"): (double)-b/a);
    }

    public static void main(String[] args) {



        double x1 = (double) giaiPTBac1(-5,1);
        System.out.println("Nghiệm: " + x1);

    }
}
