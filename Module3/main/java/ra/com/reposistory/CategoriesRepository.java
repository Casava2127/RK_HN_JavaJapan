package ra.com.reposistory;

import ra.com.entity.Categories;

import java.util.List;

public interface CategoriesRepository {
    List<Categories> findAll(); // tra ve 1 danh sach Categories
}
