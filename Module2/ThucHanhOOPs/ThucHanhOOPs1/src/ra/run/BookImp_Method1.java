package ra.run;

import ra.entity.Book_Method1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookImp_Method1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Nhập số lượng sách: ");
        n = scanner.nextInt();
        Book_Method1[] books = new Book_Method1[n];

        int choice;
        do {
            System.out.println("\n*********************MENU******************");
            System.out.println("1. Nhập thông tin n sách");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
                        books[i] = new Book_Method1();
                        books[i].input();
                    }
                    break;
                case 2:
                    System.out.println("Lợi nhuận sách đã được tính trong quá trình nhập");
                    break;
                case 3:
                    for (Book_Method1 book : books) {
                        book.display();
                    }
                    break;
                case 4:
                    sortByExportPrice(books);
                    System.out.println("Sách đã được sắp xếp theo giá bán tăng dần.");
                    break;
                case 5:
                    sortByInterest(books);
                    System.out.println("Sách đã được sắp xếp theo lợi nhuận giảm dần.");
                    break;
                case 6:
                    searchByBookName(books, scanner);
                    break;
                case 7:
                    statisticByYear(books);
                    break;
                case 8:
                    statisticByAuthor(books);
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (choice != 9);
    }

    private static void sortByExportPrice(Book_Method1[] books) {
        // Sắp xếp sách theo giá bán tăng dần sử dụng thuật toán sắp xếp nổi bọt (Bubble Sort)
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (books[j].getExportPrice() > books[j + 1].getExportPrice()) {
                    // Hoán đổi v ị trí
                    Book_Method1 temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    private static void sortByInterest(Book_Method1[] books) {
        // Sắp xếp sách theo lợi nhuận giảm dần sử dụng thuật toán sắp xếp nổi bọt (Bubble Sort)
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (books[j].getInterest() < books[j + 1].getInterest()) {
                    // Hoán đổi vị trí
                    Book_Method1 temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    private static void searchByBookName(Book_Method1[] books, Scanner scanner) {
        System.out.print("Nhập tên sách để tìm: ");
        scanner.nextLine(); // Clear buffer
        String bookName = scanner.nextLine();
        boolean found = false;

        for (Book_Method1 book : books) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                book.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách với tên '" + bookName + "'.");
        }
    }

    private static void statisticByYear(Book_Method1[] books) {
        int[] countByYear = new int[100]; // Giả sử không có năm nào trước năm 2000
        for (Book_Method1 book : books) {
            if (book.getYear() >= 2000) {
                countByYear[book.getYear() - 2000]++;
            }
        }

        System.out.println("Thống kê số lượng sách theo năm xuất bản:");
        for (int year = 2000; year < countByYear.length + 2000; year++) {
            if (countByYear[year - 2000] > 0) {
                System.out.println("Năm " + year + ": " + countByYear[year - 2000] + " sách");
            }
        }
    }

    private static void statisticByAuthor(Book_Method1[] books) {
        HashMap<String, Integer> authorCount = new HashMap<>();
        for (Book_Method1 book : books) {
            authorCount.put(book.getAuthor(), authorCount.getOrDefault(book.getAuthor(), 0) + 1);
        }

        System.out.println("Thống kê số lượng sách theo tác giả:");
        for (Map.Entry<String, Integer> entry : authorCount.entrySet()) {
            System.out.println("Tác giả: " + entry.getKey() + ", Số lượng sách: " + entry.getValue());
        }
    }
}
