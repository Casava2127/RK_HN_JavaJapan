package DataStructures.ArrList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class ArrList1 {
    public static void main(String[] args) {
        // ==========================
        // 1. Khởi tạo ArrayList
        // ==========================
        List<String> cars = new ArrayList<>();

        // ==========================
        // 2. Thêm phần tử (add)
        // ==========================
        cars.add("Toyota");
        cars.add("Honda");
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Audi");
        System.out.println("Danh sách xe ban đầu: " + cars);

        // Thêm ở vị trí cụ thể
        cars.add(2, "Ford");
        System.out.println("Thêm Ford vào vị trí 2: " + cars);

        // Thêm tất cả từ collection khác
        List<String> moreCars = List.of("Kia", "Hyundai");
        cars.addAll(moreCars);
        System.out.println("Thêm Kia, Hyundai: " + cars);

        // ==========================
        // 3. Truy xuất phần tử
        // ==========================
        System.out.println("Xe ở vị trí 3: " + cars.get(3));
        System.out.println("Chỉ số đầu tiên của BMW: " + cars.indexOf("BMW"));
        System.out.println("Chỉ số cuối cùng của Audi: " + cars.lastIndexOf("Audi"));
        System.out.println("Có chứa Toyota? " + cars.contains("Toyota"));

        // ==========================
        // 4. Cập nhật phần tử (set)
        // ==========================
        cars.set(1, "Nissan");
        System.out.println("Thay Honda bằng Nissan: " + cars);

        // ==========================
        // 5. Xóa phần tử (remove)
        // ==========================
        cars.remove(4); // Xóa Mercedes
        cars.remove("Kia"); // Xóa Kia theo tên
        System.out.println("Sau khi xóa: " + cars);

        // ==========================
        // 6. Kích thước & kiểm tra rỗng
        // ==========================
        System.out.println("Số lượng xe: " + cars.size());
        System.out.println("Danh sách rỗng? " + cars.isEmpty());

        // ==========================
        // 7. Duyệt danh sách
        // ==========================
        System.out.println("Duyệt bằng for-each:");
        for (String car : cars) {
            System.out.println(car);
        }

        System.out.println("Duyệt bằng Iterator:");
        Iterator<String> it = cars.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // ==========================
        // 8. Sắp xếp và subList
        // ==========================
        Collections.sort(cars);
        System.out.println("Sau khi sắp xếp: " + cars);

        List<String> subList = cars.subList(1, 4);
        System.out.println("SubList từ 1 đến 3: " + subList);

        // ==========================
        // 9. Chuyển thành mảng
        // ==========================
        String[] carArray = cars.toArray(new String[0]);
        System.out.println("Chuyển sang mảng:");
        for(String car : carArray) {
            System.out.println(car);
        }

        // ==========================
        // 10. Clear danh sách
        // ==========================
        cars.clear();
        System.out.println("Sau khi clear, danh sách rỗng? " + cars.isEmpty());
    }

}
