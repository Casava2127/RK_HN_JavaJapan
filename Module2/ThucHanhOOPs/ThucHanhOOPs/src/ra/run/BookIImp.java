package ra.run;

import ra.entity.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class BookIImp {
    //dungf arrayList để lưu trữ danh sách kểu Book
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("*********************MENU******************");
            System.out.println("1. Nhập thông tin n sách (n nhập từ bàn phím)");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự newline còn sót

            switch (choice) {
                case 1:
                    inputBooks();
                    break;
                case 2:
                    calculateInterests();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    sortBooksByPrice();
                    break;
                case 5:
                    sortBooksByInterest();
                    break;
                case 6:
                    findBookByName();
                    break;
                case 7:
                    statisticsByYear();
                    break;
                case 8:
                    statisticsByAuthor();
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 9);
    }

    // 1. Nhập thông tin n sách
    private static void inputBooks() {
        System.out.print("Nhập số lượng sách: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline còn sót

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1));
            System.out.print("Mã sách: ");
            String bookId = scanner.nextLine();
            System.out.print("Tên sách - Tên sách phải có 4 ký tự và bắt đầu bằng chữ 'B': ");
            String bookName = scanner.nextLine();
            System.out.print("Giá nhập (giá nhập phải lớn hơn 0): ");
            float importPrice = scanner.nextFloat();
            System.out.print("Giá xuất( Giá xuất phải lớn hơn ít nhất 30% giá nhập: ");
            float exportPrice = scanner.nextFloat();
            scanner.nextLine(); // Đọc ký tự newline còn sót
            System.out.print("Tác giả -Tên tác giả phải từ 6 đến 50 ký tự: ");
            String author = scanner.nextLine();
            System.out.print("Năm xuất bản sau năm 2000: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự newline còn sót

            try {
                Book book = new Book(bookId, bookName, importPrice, exportPrice, author, year);
                bookList.add(book);
            } catch (IllegalArgumentException e) { // bắt lỗi validate
                System.out.println("Lỗi khi nhập sách: " + e.getMessage());
                i--; // Thử nhập lại sách này
            }
        }
    }

    // 2. Tính lợi nhuận các sách
    private static void calculateInterests() {
        float interest = 0;
        for (Book book : bookList) {
           interest += book.calculateInterest();
        }
        System.out.println("Đã tính lợi nhuận cho tất cả các sách: "+interest);
    }

    // 3. Hiển thị thông tin sách
    private static void displayBooks() {
        for (Book book : bookList) {
            book.displayBookData();
            System.out.println("-----------------------");
        }
    }

    // 4. Sắp xếp sách theo giá bán tăng dần
    private static void sortBooksByPrice() {
        bookList.sort(Comparator.comparing(Book::getExportPrice));
        System.out.println("Đã sắp xếp sách theo giá bán tăng dần.");
    }

    // 5. Sắp xếp sách theo lợi nhuận giảm dần
    private static void sortBooksByInterest() {
        bookList.sort((b1, b2) -> Float.compare(b2.getInterest(), b1.getInterest()));
        System.out.println("Đã sắp xếp sách theo lợi nhuận giảm dần.");
    }

    // 6. Tìm sách theo tên sách
    private static void findBookByName() {
        System.out.print("Nhập tên sách cần tìm: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(name)) {
                book.displayBookData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với tên: " + name);
        }
    }

    // 7. Thống kê số lượng sách theo năm xuất bản
    private static void statisticsByYear() {
        System.out.println("Thống kê số lượng sách theo năm xuất bản:");
        bookList.stream().map(Book::getYear)
                .distinct()
                .forEach(year -> {
                    long count = bookList.stream().filter(book -> book.getYear() == year).count();
                    System.out.println("Năm " + year + ": " + count + " sách");
                });
    }

    // 8. Thống kê số lượng sách theo tác giả
    private static void statisticsByAuthor() {
        System.out.println("Thống kê số lượng sách theo tác giả:");
        bookList.stream().map(Book::getAuthor)
                .distinct()
                .forEach(author -> {
                    long count = bookList.stream().filter(book -> book.getAuthor().equals(author)).count();
                    System.out.println("Tác giả " + author + ": " + count + " sách");
                });
    }
}
