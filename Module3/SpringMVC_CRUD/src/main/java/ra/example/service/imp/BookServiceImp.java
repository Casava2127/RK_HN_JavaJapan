package ra.example.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.example.model.Book;
import ra.example.repository.BookRepository;
import ra.example.repository.imp.BookRepositoryImp;
import ra.example.service.BookService;

import java.util.List;

// Đánh dấu lớp này là một Service trong Spring, nơi chứa các logic nghiệp vụ của ứng dụng
@Service
public class BookServiceImp implements BookService {

    // Tiêm instance của Bean BookRepository đã được nạp trong container Spring
    // Sử dụng @Autowired để tiêm phụ thuộc, nhưng nên sử dụng tiêm qua constructor thay vì tiêm qua setter.
    private final BookRepository bookRepository;

    // Constructor nhận BookRepositoryImp (thực thi của BookRepository) để tiêm vào BookServiceImp
    @Autowired
    public BookServiceImp(BookRepositoryImp bookRepositoryImp) {
        this.bookRepository = bookRepositoryImp; // Gán BookRepositoryImp vào bookRepository
    }

    // Phương thức tìm tất cả sách
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll(); // Gọi phương thức findAll từ repository để lấy danh sách sách
    }

    // Phương thức tìm sách theo ID
    @Override
    public Book findById(int bookId) {
        return bookRepository.findById(bookId); // Gọi phương thức findById từ repository để tìm sách theo ID
    }

    // Phương thức lưu sách mới
    @Override
    public boolean save(Book book) {
        return bookRepository.save(book); // Gọi phương thức save từ repository để lưu sách vào cơ sở dữ liệu
    }

    // Phương thức cập nhật thông tin sách
    @Override
    public boolean update(Book book) {
        return bookRepository.update(book); // Gọi phương thức update từ repository để cập nhật thông tin sách
    }

    // Phương thức xóa sách
    @Override
    public boolean delete(int bookId) {
        return bookRepository.delete(bookId); // Gọi phương thức delete từ repository để xóa sách theo ID
    }
}
