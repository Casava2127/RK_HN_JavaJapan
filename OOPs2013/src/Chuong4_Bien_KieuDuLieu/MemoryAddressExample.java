package Chuong4_Bien_KieuDuLieu;

public class MemoryAddressExample {
    public static void main(String[] args) {
        // Biến kiểu cơ bản
        // bien luu tru tai stack
        int a = 10;
        int b = a; // Sao chép giá trị
        b = 20; // Thay đổi giá trị của b

        // In ra giá trị của a và b
        System.out.println("Giá trị của a: " + a); // 10
        System.out.println("Giá trị của b: " + b); // 20

        // Biến tham chiếu - luu tru tai stack, chua gia tri la dia chi cua obj tai heap
        Dog dog1 = new Dog("Buddy"); //bien tham chieu - Lưu trữ trong stack, chứa địa chỉ của đối tượng nam trong heap.
        Dog dog2 = dog1; // dog2 tham chiếu đến dog1
        dog2.setName("Max"); // Thay đổi tên thông qua dog2

        // In ra giá trị và địa chỉ tham chiếu
        System.out.println("Giá trị của dog1: " + dog1.getName()); // Max
        System.out.println("Giá trị của dog2: " + dog2.getName()); // Max

        // Hiển thị địa chỉ tham chiếu
        System.out.println("Địa chỉ tham chiếu của dog1: " + System.identityHashCode(dog1));
        System.out.println("Địa chỉ tham chiếu của dog2: " + System.identityHashCode(dog2));
    }
}
// Một biến tham chiếu là biến
//địa phương của một hàm sẽ kết thúc sự tồn tại của mình sau khi hàm kết thúc. Còn
//đối tượng được tạo ra từ  bên trong hàm ( luu tai heap)  đó vẫn tiếp tục tồn tại cho đến khi nào
//được máy ảo Java giải phóng – sau khi đối tượng đó không còn được dùng đến nữa.

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
