package ra.entity;

import java.util.Scanner;

public class Product1 {
    private String productId; // 4 ky tu
    private String productName; // 6-50 ky tu
    private float importPrice; // > 0
    private float exportPrice; // > 20% importPrice
    private float profit; // theo cong thuc
    private int quantity; // > 0
    private String description;
    private boolean status;

    public Product1() {}

    public Product1(String productId, String productName, float importPrice, float exportPrice, int quantity, String description, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.profit = calculateProfit();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public float getProfit() {
        return profit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public void inputData(Scanner scanner, Product1[] arrProduct) {
        String productId, productName, description;
        float importPrice, exportPrice;
        int quantity;
        boolean status = false;
        boolean validInput=false ;

        do {
            System.out.print("Enter product ID (4 characters, must be unique): ");
            productId = scanner.nextLine();
        } while (productId.length() != 4 || !isUniqueProductId(productId, arrProduct, arrProduct.length));
        setProductId(productId);

        do {
            System.out.print("Enter product name (6-50 characters): ");
            productName = scanner.nextLine();
        } while (!isValidProductName(productName));
        setProductName(productName);

        do {
            System.out.print("Enter import price (more than 0): ");
            importPrice = scanner.nextFloat();
        } while (!isValidImportPrice(importPrice));
        setImportPrice(importPrice);

        do {
            System.out.print("Enter export price (more than 20% of import price): ");
            exportPrice = scanner.nextFloat();
        } while (!isValidExportPrice(exportPrice));
        setExportPrice(exportPrice);

        System.out.print("Enter quantity (more than 0): ");
        quantity = scanner.nextInt();
        setQuantity(quantity);

        System.out.print("Enter description: ");
        scanner.nextLine(); // Clear buffer after nextInt()
        description = scanner.nextLine();
        setDescription(description);
        do{
            System.out.print("Enter status (true/false): ");
            if(scanner.hasNextBoolean()){
                status = scanner.nextBoolean();
                scanner.nextLine(); // Clear buffer after nextBoolean()
                validInput = true;
            }else{
                System.out.println("Invalid input. Please enter a boolean value.");
                scanner.nextLine(); // Clear buffer after invalid input
                validInput = false;
            }
            
        }while(!validInput);
        setStatus(status);

        // Tính toán lại profit sau khi nhập giá trị importPrice và exportPrice
        this.profit = calculateProfit();
    }


    public void displayData() {
        System.out.printf("%-10s %-20s %-10.2f %-10.2f %-10d %-20s %-5s\n",
                productId, productName, importPrice, exportPrice, quantity, description, status);
    }

    private boolean isUniqueProductId(String productId, Product1[] arrProduct, int productCount) {
        for (int i = 0; i < productCount; i++) {
            // Kiểm tra xem phần tử có null không trước khi gọi getProductId
            if (arrProduct[i] != null && productId.equals(arrProduct[i].getProductId())) {
                return false;
            }
        }
        return true;
    }
    private boolean isValidProductName(String productName) {
        return productName.length() >= 6 && productName.length() <= 50;
    }

    private boolean isValidImportPrice(float price) {
        return price > 0;
    }

    private boolean isValidExportPrice(float price) {
        return price > 1.2 * this.importPrice;
    }

    private float calculateProfit() {
        return this.exportPrice - this.importPrice;
    }
}
