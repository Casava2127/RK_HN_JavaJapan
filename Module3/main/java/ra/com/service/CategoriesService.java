package ra.com.service; // Khai báo package chứa interface CategoriesService

import ra.com.entity.Categories; // Import lớp Categories từ package ra.com.entity
import java.util.List; // Import lớp List từ thư viện Java để làm việc với danh sách

public interface CategoriesService { // Định nghĩa interface CategoriesService

    List<Categories> findAll(); // Phương thức findAll() trả về một danh sách các đối tượng Categories, đại diện cho tất cả các danh mục
}
