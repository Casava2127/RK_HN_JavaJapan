package DataStructures.ArrList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparisonExample {
    public static void main(String[] args) {
        // ==========================
        // 1. Khởi tạo ArrayList và LinkedList
        // ==========================
        List<String> arrayCars = new ArrayList<>();
        List<String> linkedCars = new LinkedList<>();

        // ==========================
        // 2. Thêm phần tử vào cuối
        // ==========================
        for (int i = 1; i <= 10; i++) {
            arrayCars.add("Car" + i);
            linkedCars.add("Car" + i);
        }

        System.out.println("ArrayList ban đầu: " + arrayCars);
        System.out.println("LinkedList ban đầu: " + linkedCars);

        // ==========================
        // 3. Thêm phần tử ở giữa
        // ==========================
        arrayCars.add(5, "NewCarArray");
        linkedCars.add(5, "NewCarLinked");

        System.out.println("\nSau khi thêm ở giữa:");
        System.out.println("ArrayList: " + arrayCars);
        System.out.println("LinkedList: " + linkedCars);

        // ==========================
        // 4. Truy cập phần tử theo index
        // ==========================
        System.out.println("\nTruy cập phần tử thứ 6:");
        System.out.println("ArrayList: " + arrayCars.get(5));   // nhanh
        System.out.println("LinkedList: " + linkedCars.get(5)); // chậm hơn

        // ==========================
        // 5. Xóa phần tử đầu và cuối
        // ==========================
        arrayCars.remove(0); // xóa đầu → phải shift các phần tử → chậm
        arrayCars.remove(arrayCars.size() - 1); // xóa cuối → nhanh

        linkedCars.remove(0); // xóa đầu → nhanh
        linkedCars.remove(linkedCars.size() - 1); // xóa cuối → nhanh

        System.out.println("\nSau khi xóa đầu/cuối:");
        System.out.println("ArrayList: " + arrayCars);
        System.out.println("LinkedList: " + linkedCars);

        // ==========================
        // 6. Duyệt danh sách
        // ==========================
        System.out.println("\nDuyệt ArrayList bằng for-each:");
        for(String car : arrayCars) System.out.print(car + " ");
        System.out.println("\nDuyệt LinkedList bằng Iterator:");
        linkedCars.forEach(car -> System.out.print(car + " "));

        // ==========================
        // 7. Kết hợp ArrayList và LinkedList
        // ==========================
        // Giả sử muốn sử dụng LinkedList để thêm/xóa nhanh ở đầu/mid
        // Sau đó chuyển sang ArrayList để truy cập nhanh
        LinkedList<String> tempList = new LinkedList<>();
        tempList.add("CarA");
        tempList.add("CarB");
        tempList.add(1, "CarC"); // thêm nhanh ở giữa

        // Chuyển sang ArrayList để truy cập nhanh
        List<String> finalList = new ArrayList<>(tempList);
        System.out.println("\nKết hợp LinkedList -> ArrayList: " + finalList);
    }
}
