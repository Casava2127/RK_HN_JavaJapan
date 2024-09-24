package ra.entity;

public class Book {
    // định nghĩa các thuộc tính quan tâm
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;



    // Constructor có tham số
    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, int year) {
        this.bookId = bookId;
        //các giá trị caafn Validate thì hãy dùng hàm set để viết
        setBookName(bookName); // Validate tên sách
        setImportPrice(importPrice); // Validate giá nhập
        setExportPrice(exportPrice); // Validate giá xuất
        setAuthor(author); // Validate tên tác giả
        setYear(year); // Validate năm xuất bản
        this.interest = calculateInterest();
    }

    // Getters và Setters
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
        // viết trực tiếp validate trong hàm set
        if (bookName != null && bookName.length() == 4 && bookName.charAt(0) == 'B') {
            this.bookName = bookName;
        } else {
            throw new IllegalArgumentException("Tên sách phải có 4 ký tự và bắt đầu bằng chữ 'B'.");
        }
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        // viết validate
        if (importPrice > 0) {
            this.importPrice = importPrice;
        } else {
            throw new IllegalArgumentException("Giá nhập phải lớn hơn 0.");
        }
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        if (exportPrice > importPrice * 1.3f) {
            this.exportPrice = exportPrice;
        } else {
            throw new IllegalArgumentException("Giá xuất phải lớn hơn ít nhất 30% giá nhập.");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && author.length() >= 6 && author.length() <= 50) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Tên tác giả phải từ 6 đến 50 ký tự.");
        }
    }

    public float getInterest() {
        return interest;
    }
    // không set được Interest vì nó phụ thuộc vào 2 giá trị nhập và xuất

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 2000) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Năm xuất bản phải sau năm 2000.");
        }
    }

    // Phương thức tính lợi nhuận
    public float calculateInterest() {
        return this.exportPrice - this.importPrice;
    }

    // Phương thức nhập dữ liệu sách
    public void inputBookData() {
        // Bạn có thể sử dụng Scanner để nhập dữ liệu từ bàn phím và validate
    }

    // Phương thức hiển thị dữ liệu sách
    public void displayBookData() {
        System.out.println("Mã sách: " + this.bookId);
        System.out.println("Tên sách: " + this.bookName);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Tác giả: " + this.author);
        System.out.println("Lợi nhuận: " + this.interest);
        System.out.println("Năm xuất bản: " + this.year);
    }

}
