ArrayList = mảng động, nhanh khi truy cập theo chỉ số, chậm khi thêm/xóa giữa.

LinkedList = danh sách liên kết đôi, nhanh khi thêm/xóa node, chậm khi truy cập theo chỉ số


* Viết **chương trình nhỏ nhưng thực tế**.
* Có **comment giải thích nhanh/chậm ở đâu**.
* Nói **nên dùng khi nào**.

---

# 1. LIST (ArrayList vs LinkedList)

```java
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        // ArrayList: lưu dữ liệu dạng mảng động
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");
        arrayList.add("Python"); // Cho phép trùng lặp

        // LinkedList: danh sách liên kết đôi
        List<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        // In ra
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // So sánh hiệu suất
        // ArrayList: truy cập theo chỉ số nhanh (O(1))
        System.out.println("Phần tử thứ 2 của ArrayList: " + arrayList.get(1));

        // LinkedList: thêm/xóa giữa danh sách nhanh (O(1)) nếu có iterator
        linkedList.add(1, "X"); 
        System.out.println("LinkedList sau khi thêm: " + linkedList);
    }
}
```

💡 Ghi chú:

* **ArrayList**: nhanh khi truy cập, duyệt; chậm khi thêm/xóa ở giữa.
* **LinkedList**: nhanh khi thêm/xóa ở giữa, chậm khi truy cập theo chỉ số.
* 👉 Dùng ArrayList khi cần **tìm kiếm, duyệt nhiều**.
* 👉 Dùng LinkedList khi cần **thêm/xóa nhiều**.

---

# 2. SET (HashSet, TreeSet, LinkedHashSet)

```java
import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // HashSet: không trùng, không có thứ tự
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Banana"); // bị bỏ qua

        // TreeSet: sắp xếp tự nhiên (alphabet)
        Set<String> treeSet = new TreeSet<>(hashSet);

        // LinkedHashSet: nhớ thứ tự thêm
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Z");
        linkedHashSet.add("Y");
        linkedHashSet.add("X");

        System.out.println("HashSet: " + hashSet);
        System.out.println("TreeSet: " + treeSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
    }
}
```

💡 Ghi chú:

* **HashSet**: thêm/xóa/tìm nhanh nhất (O(1)), không sắp xếp, không trùng.
* **TreeSet**: tự động sắp xếp (O(log n)), chậm hơn.
* **LinkedHashSet**: giữ thứ tự thêm vào, nhanh gần bằng HashSet.
* 👉 Dùng Set khi muốn **loại bỏ trùng lặp**.
* 👉 Dùng TreeSet khi cần **sắp xếp dữ liệu không trùng**.

---

# 3. MAP (HashMap, TreeMap, LinkedHashMap)

```java
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        // HashMap: key-value, không có thứ tự
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(2, "Java");
        hashMap.put(1, "Python");
        hashMap.put(3, "C++");

        // TreeMap: sắp xếp key tăng dần
        Map<Integer, String> treeMap = new TreeMap<>(hashMap);

        // LinkedHashMap: nhớ thứ tự thêm vào
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(10, "A");
        linkedHashMap.put(5, "B");
        linkedHashMap.put(7, "C");

        System.out.println("HashMap: " + hashMap);
        System.out.println("TreeMap: " + treeMap);
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // Truy cập nhanh bằng key (O(1) với HashMap)
        System.out.println("Lấy phần tử key=2 từ HashMap: " + hashMap.get(2));
    }
}
```

💡 Ghi chú:

* **HashMap**: nhanh nhất (O(1)) để thêm/xóa/tìm theo key. Không có thứ tự.
* **TreeMap**: sắp xếp theo key (O(log n)).
* **LinkedHashMap**: nhớ thứ tự thêm vào (O(1)).
* 👉 Dùng HashMap cho lookup nhanh.
* 👉 Dùng TreeMap khi cần dữ liệu **theo thứ tự key**.

---

# 4. ITERATOR

```java
import java.util.*;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));

        // Duyệt bằng Iterator
        Iterator<String> it = list.iterator();
        System.out.println("Duyệt bằng Iterator:");
        while (it.hasNext()) {
            String lang = it.next();
            System.out.println(lang);

            // Xóa phần tử khi duyệt (Iterator cho phép)
            if (lang.equals("Python")) {
                it.remove(); 
            }
        }
        System.out.println("Sau khi xóa bằng Iterator: " + list);
    }
}
```

💡 Ghi chú:

* **Iterator** duyệt được mọi Collection (List, Set, Map.keySet(), …).
* Cho phép **xóa an toàn khi đang duyệt** (không lỗi ConcurrentModification).
* 👉 Dùng khi cần duyệt/xóa trên nhiều loại Collection mà không quan tâm nó là ArrayList, HashSet hay TreeMap.

---

# TÓM TẮT (chọn nhanh)

| Cấu trúc       | Ưu điểm                                | Nhược điểm                | Khi nào dùng                       |
| -------------- | -------------------------------------- | ------------------------- | ---------------------------------- |
| **ArrayList**  | Truy cập nhanh (O(1))                  | Thêm/xóa giữa chậm        | Khi cần duyệt, tìm nhiều           |
| **LinkedList** | Thêm/xóa nhanh (O(1))                  | Truy cập theo chỉ số chậm | Khi cần thêm/xóa nhiều             |
| **HashSet**    | Không trùng, rất nhanh                 | Không có thứ tự           | Khi cần loại trùng, không cần sắp  |
| **TreeSet**    | Sắp xếp tự động                        | Chậm hơn (O(log n))       | Khi cần dữ liệu duy nhất + sắp xếp |
| **HashMap**    | Tìm kiếm nhanh nhất (O(1))             | Không có thứ tự           | Khi cần ánh xạ key→value           |
| **TreeMap**    | Sắp xếp theo key                       | Chậm hơn (O(log n))       | Khi cần map có thứ tự              |
| **Iterator**   | Duyệt được mọi Collection, xóa an toàn | Cần code dài hơn for-each | Khi duyệt & xóa phần tử            |

---

👉 Bạn có muốn mình viết thêm **một ví dụ tổng hợp lớn** (như quản lý Hệ thống Bán Hàng: sản phẩm, khách hàng, đơn hàng) để cùng lúc thấy rõ **List + Set + Map + Iterator** hoạt động chung không?
