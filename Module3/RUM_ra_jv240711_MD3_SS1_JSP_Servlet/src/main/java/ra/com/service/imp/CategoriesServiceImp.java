package ra.com.service.imp;

import ra.com.entity.Categories;
import ra.com.repository.CategoriesRepository;
import ra.com.repository.imp.CategoriesRepositoryImp;
import ra.com.service.CategoriesService;

import java.util.List;

public class CategoriesServiceImp implements CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceImp() { // Constructor của CategoriesServiceImp.
        categoriesRepository = new CategoriesRepositoryImp(); // Khởi tạo đối tượng CategoriesRepositoryImp và gán vào biến categoriesRepository.
    }

    @Override
    public List<Categories> findAll() { // Ghi đè phương thức findAll từ CategoriesService.
        return categoriesRepository.findAll(); // Gọi phương thức findAll của categoriesRepository để lấy danh sách danh mục.
    }

    @Override
    public boolean save(Categories catalog) { // Ghi đè phương thức save từ CategoriesService.
        return categoriesRepository.save(catalog); // Gọi phương thức save của categoriesRepository để lưu danh mục vào cơ sở dữ liệu.
    }

    @Override
    public Categories findById(int catalogId) { // Ghi đè phương thức findById từ CategoriesService.
        return categoriesRepository.findById(catalogId); // Gọi phương thức findById của categoriesRepository để tìm danh mục theo ID.
    }

    @Override
    public boolean update(Categories catalog) { // Ghi đè phương thức update từ CategoriesService.
        return categoriesRepository.update(catalog); // Gọi phương thức update của categoriesRepository để cập nhật danh mục trong cơ sở dữ liệu.
    }

    @Override
    public boolean delete(int catalogId) { // Ghi đè phương thức delete từ CategoriesService.
        return categoriesRepository.delete(catalogId); // Gọi phương thức delete của categoriesRepository để xóa danh mục theo ID.
    }
}
