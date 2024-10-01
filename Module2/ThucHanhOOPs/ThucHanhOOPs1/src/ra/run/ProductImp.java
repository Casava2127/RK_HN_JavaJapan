package ra.run;

import ra.entity.Product1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductImp {
    private Product1[] productList;
    private int productCount;
    private static final int MAX_PRODUCT = 100;
    Scanner scanner = new Scanner(System.in);

    public ProductImp() {
        productList = new Product1[MAX_PRODUCT];
        productCount = 0;
    }

    public void addProduct() {
        if (productCount >= MAX_PRODUCT) {
            System.out.println("Danh sách sản phẩm đã đầy.");
            return;
        }
        Product1 newProduct = new Product1();
        newProduct.inputData(scanner, productList);
        productList[productCount] = newProduct;
        productCount++;
        System.out.println("Thêm sản phẩm thành công.");
    }

    public void displayAllProducts() {
        if (productCount == 0) {
            System.out.println("Danh sách sản phẩm rỗng.");
            return;
        }
        System.out.printf("%-10s %-20s %-10s %-10s %-10s %-20s %-5s\n",
                "Mã SP", "Tên SP", "Giá Nhập", "Giá Xuất", "Số Lượng", "Mô Tả", "Trạng Thái");
        for (int i = 0; i < productCount; i++) {
            productList[i].displayData();
        }
    }

    public void calculateProductProfits() {
        if (productCount == 0) {
            System.out.println("Danh sách sản phẩm rỗng.");
            return;
        }
        float totalProfit = 0;
        for (int i = 0; i < productCount; i++) {
            totalProfit += productList[i].getProfit();
        }
        System.out.println("Tổng lợi nhuận của tất cả sản phẩm: " + totalProfit);
    }

    public void sortProductsByProfit() {
        if (productCount == 0) {
            System.out.println("Danh sách sản phẩm rỗng.");
            return;
        }
        for (int i = 0; i < productCount - 1; i++) {
            for (int j = i + 1; j < productCount; j++) {
                if (productList[i].getProfit() < productList[j].getProfit()) {
                    Product1 temp = productList[i];
                    productList[i] = productList[j];
                    productList[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp sản phẩm theo lợi nhuận giảm dần:");
        displayAllProducts();
    }

    public void countProductsByPriceRange() {
        if (productCount == 0) {
            System.out.println("Danh sách sản phẩm rỗng.");
            return;
        }
        float fromPrice = 0, toPrice = 0;
        while (true) {
            try {
                System.out.print("Nhập giá bắt đầu (fromPrice): ");
                fromPrice = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
                scanner.next();
            }
        }
        while (true) {
            try {
                System.out.print("Nhập giá kết thúc (toPrice): ");
                toPrice = scanner.nextFloat();
                if (toPrice < fromPrice) {
                    System.out.println("Giá kết thúc phải lớn hơn hoặc bằng giá bắt đầu.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
                scanner.next();
            }
        }

        int count = 0;
        for (int i = 0; i < productCount; i++) {
            if (productList[i].getExportPrice() >= fromPrice && productList[i].getExportPrice() <= toPrice) {
                count++;
            }
        }
        System.out.println("Số sản phẩm trong khoảng giá từ " + fromPrice + " đến " + toPrice + " là: " + count);
    }

    public void inputProductStock() {
        System.out.print("Nhập mã sản phẩm cần nhập: ");
        String productId = scanner.nextLine();
        System.out.print("Nhập số lượng cần nhập: ");
        int quantity = scanner.nextInt();

        for (int i = 0; i < productCount; i++) {
            if (productId.equals(productList[i].getProductId())) {
                productList[i].setQuantity(productList[i].getQuantity() + quantity);
                System.out.println("Nhập hàng thành công cho sản phẩm " + productId);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với mã " + productId);
    }

    public void sellProduct() {
        System.out.print("Nhập tên sản phẩm cần bán: ");
        String productName = scanner.nextLine();
        System.out.print("Nhập số lượng cần bán: ");
        int quantity = scanner.nextInt();

        for (int i = 0; i < productCount; i++) {
            if (productName.equals(productList[i].getProductName())) {
                if (productList[i].getQuantity() >= quantity) {
                    productList[i].setQuantity(productList[i].getQuantity() - quantity);
                    System.out.println("Bán hàng thành công cho sản phẩm " + productName);
                } else {
                    System.out.println("Số lượng không đủ để bán.");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với tên " + productName);
    }

    public void updateProductStatus(String productId) {
        if (productCount == 0) {
            System.out.println("Danh sách sản phẩm rỗng.");
            return;
        }
        for (int i = 0; i < productCount; i++) {
            if (productId.equals(productList[i].getProductId())) {
                productList[i].setStatus(!productList[i].isStatus());
                String status = productList[i].isStatus() ? "hiện" : "ẩn";
                System.out.println("Trạng thái sản phẩm với mã " + productId + " đã được cập nhật sang trạng thái " + status);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với mã " + productId);
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer after nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm cần thêm: ");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        addProduct();
                    }
                    break;
                case 2:
                    displayAllProducts();
                    break;
                case 3:
                    calculateProductProfits();
                    break;
                case 4:
                    sortProductsByProfit();
                    break;
                case 5:
                    countProductsByPriceRange();
                    break;
                case 6:
                    System.out.print("Nhập tên sản phẩm để tìm: ");
                    String productName = scanner.nextLine();
                    findProductsByName(productName);
                    break;
                case 7:
                    inputProductStock();
                    break;
                case 8:
                    sellProduct();
                    break;
                case 9:
                    System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
                    String productIdStatus = scanner.nextLine();
                    updateProductStatus(productIdStatus);
                    break;
                case 10:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 10);
    }

    public void findProductsByName(String productName) {
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (productList[i].getProductName().toLowerCase().contains(productName.toLowerCase())) {
                productList[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với tên " + productName);
        }
    }

    public static void main(String[] args) {
        ProductImp productImp = new ProductImp();
        productImp.menu();
    }
}
