package ra.entity;

import java.util.Scanner;

public class Book_Method1 {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;



    // Getters and Setters
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Phương thức nhập dữ liệu
    public void input() {
        Scanner scanner = new Scanner(System.in);

        // Nhập bookId
        System.out.print("Nhập mã sách (bookId): ");
        this.bookId = scanner.nextLine();

        // Nhập bookName
        do {
            System.out.print("Nhập tên sách (4 ký tự, bắt đầu bằng 'B'): ");
            this.bookName = scanner.nextLine();
        } while (!isValidBookName(this.bookName));

        // Nhập giá nhập
        do {
            System.out.print("Nhập giá nhập (lớn hơn 0): ");
            this.importPrice = scanner.nextFloat();
        } while (this.importPrice <= 0);

        // Nhập giá xuất
        do {
            System.out.print("Nhập giá xuất (lớn hơn 30% giá nhập): ");
            this.exportPrice = scanner.nextFloat();
        } while (this.exportPrice <= 1.3 * this.importPrice);

        // Nhập tác giả
        do {
            System.out.print("Nhập tác giả (6-50 ký tự): ");
            scanner.nextLine(); // Clear buffer
            this.author = scanner.nextLine();
        } while (!isValidAuthor(this.author));

        // Nhập năm xuất bản
        do {
            System.out.print("Nhập năm xuất bản (sau năm 2000): ");
            this.year = scanner.nextInt();
        } while (this.year <= 2000);

        // Tính lợi nhuận
        this.interest = calculateInterest();
    }

    // Phương thức hiển thị dữ liệu
    public void display() {
        System.out.printf("Mã sách: %s, Tên sách: %s, Giá nhập: %.2f, Giá xuất: %.2f, Tác giả: %s, Lợi nhuận: %.2f, Năm xuất bản: %d%n",
                bookId, bookName, importPrice, exportPrice, author, interest, year);
    }

    // Phương thức tính lợi nhuận
    public float calculateInterest() {
        float interest = 0;
        interest+=this.exportPrice - this.importPrice;
        return interest;
    }

    // Kiểm tra tính hợp lệ của tên sách
    private boolean isValidBookName(String bookName) {
        return bookName.length() == 4 && bookName.charAt(0) == 'B';
    }

    // Kiểm tra tính hợp lệ của tác giả
    private boolean isValidAuthor(String author) {
        return author.length() >= 6 && author.length() <= 50;
    }
}
