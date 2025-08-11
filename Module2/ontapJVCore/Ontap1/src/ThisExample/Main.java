package ThisExample;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Student với constructor có 1 tham số
        Student student1 = new Student("Alice");

        // Gọi các setter sử dụng fluent interface
        student1.setAge(20).setName("Alice Nguyen");

        // Truyền đối tượng hiện tại vào một hàm khác
        student1.introduce();

        // Gọi inner class
        Student.StudentPrinter printer = student1.new StudentPrinter();
        printer.print();
    }
}