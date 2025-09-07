package DataStructures.ArrList;

import java.util.*;

public class LibrarySystem {
    public static void main(String[] args) {
        // 1. Danh sách sách (ArrayList)
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Java Basics", "James"));
        books.add(new Book(2, "Data Structures", "Mark"));
        books.add(new Book(3, "Algorithms", "Robert"));

        // 2. Danh sách độc giả (HashSet - không trùng)
        Set<String> readers = new HashSet<>();
        readers.add("Alice");
        readers.add("Bob");
        readers.add("Alice"); // bị bỏ qua

        // 3. Ai mượn sách nào (HashMap)
        Map<String, Book> borrowedBooks = new HashMap<>();
        borrowedBooks.put("Alice", books.get(0)); // Alice mượn Java Basics
        borrowedBooks.put("Bob", books.get(2));   // Bob mượn Algorithms

        // 4. Duyệt sách bằng Iterator
        System.out.println("Danh sách sách trong thư viện:");
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 5. In danh sách độc giả (HashSet không trùng lặp)
        System.out.println("\nĐộc giả:");
        for (String reader : readers) {
            System.out.println(reader);
        }

        // 6. In danh sách mượn sách (HashMap: key-value)
        System.out.println("\nDanh sách mượn sách:");
        for (Map.Entry<String, Book> entry : borrowedBooks.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // 7. TreeMap để sắp xếp độc giả theo tên
        TreeMap<String, Book> sortedBorrowed = new TreeMap<>(borrowedBooks);
        System.out.println("\nDanh sách mượn sách (sắp xếp theo tên):");
        for (Map.Entry<String, Book> entry : sortedBorrowed.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}
