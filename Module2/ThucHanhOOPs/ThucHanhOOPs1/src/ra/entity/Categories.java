package ra.entity;

import java.util.Scanner;

public class Categories {
    private static int maxCatalogId = 0;//TU DONG TANG
    private int catalogId = 0; // TU DONG TANG tu tang khi tao muc moi ma danh muc lay ma lon nhat +1
    private String catalogName; // 50 ky tu, khong trung lap
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
        this.catalogId = ++maxCatalogId;
    }

    Categories(String catalog, String description, boolean catalogStatus) {
        this.catalogId = ++maxCatalogId;
        this.catalogName = catalog;
        this.descriptions = description;
        this.catalogStatus = catalogStatus;
    }
    // getter and setter

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }


    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void intputData(Scanner scanner, Categories[] arrCategories, int index) {
        String catalogName, descriptions;
        int catalogId;
        boolean catalogStatus = false;
        boolean validInput = false;

//        do {
//            System.out.print("Enter catalog ID (4 characters, must be unique): ");
//            catalogId = scanner.nextInt();
//        } while (!isExistCatalogId(catalogId, arrCategories, index));
//        setCatalogId(catalogId);
//        scanner.nextLine();


        do {
            System.out.print("Enter catalog name (50 characters): ");
            catalogName = scanner.nextLine();
        } while (!isCatalogName(catalogName, arrCategories));
        setCatalogName(catalogName);
        scanner.nextLine();

        do {
            System.out.print("Enter descriptions (500 characters): ");

            descriptions = scanner.nextLine();
        } while (!isDescriptions(descriptions));
        setDescriptions(descriptions);

        do {
            System.out.print("Enter catalog status (true/false): ");
            if (scanner.hasNextBoolean()) {
                catalogStatus = scanner.nextBoolean();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter true or false.");
                scanner.next(); // clear buffer
            }
        } while (!validInput);
        setCatalogStatus(catalogStatus);
    }

    // check catalogId
//    private boolean isExistCatalogId(int catalogId, Categories[] arrCategories, int index) {
//        for(int i = 0; i < arrCategories.length; i++){
//            if(arrCategories[i] != null && arrCategories[i].getCatalogId() == catalogId){
//                return false;
//            }
//        }
//        return true;
//
//    }
    private boolean isCatalogName(String catalogName, Categories[] arrCategories) {
        for (Categories arrCategory : arrCategories) {
            if (arrCategory.getCatalogName().equals(catalogName) || arrCategory.getCatalogName().length() > 50) {
                return false;
            }
        }
        return true;
    }

    private boolean isDescriptions(String descriptions) {
        return descriptions.length() <= 500;
    }

    public void displayData() {
        System.out.printf("%-10s %-50s %-50s %-5s\n",
                catalogId, catalogName, descriptions, catalogStatus);
    }


}
