package ra.run;

import ra.config.Config;
import ra.service.CatalogService;
import ra.service.ProductService;

public class BookManagement {
    public static void main(String[] args) {
        CatalogService catalogService = new CatalogService();
        ProductService productService = new ProductService();
        while (true) {
            System.out.println("**************************BASIC-MENU**************************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát ");
            int choice = Config.getInteger();
            switch (choice) {
                case 1:
                    catalogService.catalogManagement();
                    break;
                case 2:
                    productService.productManagement();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("yêu cầu không đúng mời nhập lại");
                    break;
            }
        }
    }
}
