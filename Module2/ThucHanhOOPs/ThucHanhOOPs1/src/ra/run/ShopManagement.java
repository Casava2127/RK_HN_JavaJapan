package ra.run;

import ra.entity.Categories;
import ra.entity.Product;
import java.util.Scanner;

public class ShopManagement {
    private static Categories[] arrCategories = new Categories[100];
    private static Product[] arrProducts = new Product[100];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    categoriesMenu();
                    break;
                case 2:
                    productMenu();
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void categoriesMenu() {
        while (true) {
            System.out.println("********************CATEGORIES MENU***********");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputCategories();
                    break;
                case 2:
                    displayCategories();
                    break;
                case 3:
                    updateCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                case 5:
                    updateCategoryStatus();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void productMenu() {
        while (true) {
            System.out.println("*******************PRODUCT MANAGEMENT*****************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputProducts();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    sortProductsByPrice();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    searchProductByName();
                    break;
                case 7:
                    searchProductByPriceRange();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    // Phương thức xử lý quản lý danh mục
    private static void inputCategories() {
        // Nhập thông tin danh mục
    }

    private static void displayCategories() {
        // Hiển thị thông tin danh mục
    }

    private static void updateCategory() {
        // Cập nhật thông tin danh mục
    }

    private static void deleteCategory() {
        // Xóa danh mục
    }

    private static void updateCategoryStatus() {
        // Cập nhật trạng thái danh mục
    }

    // Phương thức xử lý quản lý sản phẩm
    private static void inputProducts() {
        // Nhập thông tin sản phẩm
    }

    private static void displayProducts() {
        // Hiển thị thông tin sản phẩm
    }

    private static void sortProductsByPrice() {
        // Sắp xếp sản phẩm theo giá
    }

    private static void updateProduct() {
        // Cập nhật thông tin sản phẩm
    }

    private static void deleteProduct() {
        // Xóa sản phẩm theo mã
    }

    private static void searchProductByName() {
        // Tìm kiếm sản phẩm theo tên
    }

    private static void searchProductByPriceRange() {
        // Tìm kiếm sản phẩm trong khoảng giá
    }

    public static Categories[] getArrCategories() {
        return arrCategories;
    }

    public static void setArrCategories(Categories[] arrCategories) {
        ShopManagement.arrCategories = arrCategories;
    }

    public static Product[] getArrProducts() {
        return arrProducts;
    }

    public static void setArrProducts(Product[] arrProducts) {
        ShopManagement.arrProducts = arrProducts;
    }
}
