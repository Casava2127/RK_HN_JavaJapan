package BaiTap;


public class main {
    public static void main(String[] args) {
        // Tạo đối tượng Circle
        Circle circle = new Circle(5.0, "blue");
        System.out.println(circle.toString());

        // Tạo đối tượng Cylinder
        Cylinder cylinder = new Cylinder(5.0, "green", 10.0);
        System.out.println(cylinder.toString());
    }
}
