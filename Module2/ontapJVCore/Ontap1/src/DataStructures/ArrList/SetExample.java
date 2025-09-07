package DataStructures.ArrList;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        // Thêm phần tử
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Apple"); // trùng → không thêm
        System.out.println("HashSet: " + hashSet);

        // Kiểm tra
        System.out.println("Có chứa Banana? " + hashSet.contains("Banana"));

        // Xóa phần tử
        hashSet.remove("Orange");
        System.out.println("Sau khi xóa Orange: " + hashSet);

        // Duyệt Set
        System.out.println("Duyệt HashSet:");
        for(String fruit : hashSet) {
            System.out.println(fruit);
        }

        // TreeSet sắp xếp tự nhiên
        Set<String> treeSet = new TreeSet<>(hashSet);
        System.out.println("TreeSet (tự sắp xếp): " + treeSet);

        // LinkedHashSet giữ thứ tự chèn
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Apple");
        linkedSet.add("Banana");
        linkedSet.add("Orange");
        System.out.println("LinkedHashSet (giữ thứ tự): " + linkedSet);
    }
}

