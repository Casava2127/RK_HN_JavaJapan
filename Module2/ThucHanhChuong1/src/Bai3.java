public class Bai3 {
    //giai pt bac 2
    public static void main(String[] args) {
        double a = 1, b = 2, c = 1;
        double delta = b * b - 4 * a * c;
        double x1, x2;

        if (delta > 0) {
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phuong trinh co 2 nghiem phan biet: " + x1 + " " + x2);
        } else if (delta == 0) {
            x1 = x2 = -b / (2 * a);
            System.out.println("Phuong trinh co nghiem kep: " + x1);
        } else {
            System.out.println("Phuong trinh vo nghiem");
        }
    }
}
