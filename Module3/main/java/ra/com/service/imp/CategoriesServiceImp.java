package ra.com.service.imp; // Khai báo package chứa lớp triển khai của CategoriesService

import ra.com.entity.Categories; // Import lớp Categories từ package ra.com.entity
import ra.com.reposistory.CategoriesRepository; // Import interface CategoriesRepository từ package ra.com.reposistory
import ra.com.reposistory.imp.CategoriesRepositoryImp; // Import lớp triển khai của CategoriesRepository từ package ra.com.reposistory.imp
import ra.com.service.CategoriesService; // Import interface CategoriesService từ package ra.com.service

import java.util.List; // Import lớp List từ thư viện Java để làm việc với danh sách

public class CategoriesServiceImp implements CategoriesService { // Định nghĩa lớp CategoriesServiceImp triển khai interface CategoriesService

    // Tạo một instance của CategoriesRepository để tương tác với tầng lưu trữ dữ liệu
    private CategoriesRepository categoriesRepository;

    public CategoriesServiceImp() { // Constructor của lớp CategoriesServiceImp
        categoriesRepository = new CategoriesRepositoryImp(); // Khởi tạo đối tượng categoriesRepository là một instance của CategoriesRepositoryImp
    }

    @Override
    public List<Categories> findAll() { // Triển khai phương thức findAll từ interface CategoriesService
        return categoriesRepository.findAll(); // Gọi phương thức findAll() từ categoriesRepository để lấy danh sách tất cả các danh mục
    }
}
