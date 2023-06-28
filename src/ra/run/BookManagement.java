package ra.run;

import ra.config.Config;
import ra.model.Catalog;
import ra.model.Product;
import ra.service.CatalogService;
import ra.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class BookManagement {
    static CatalogService catalogService = new CatalogService();
    static ProductService productService = new ProductService();
    static List<Product> productList = new ArrayList<>();
    static List<Catalog> catalogList = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("**************************BASIC-MENU**************************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Dành cho người dùng (***)");
            System.out.println("4. Thoát ");
            int choice = Config.getInteger();
            switch (choice) {
                case 1:
                    catalogManagement(catalogService);
                    break;
                case 2:
                    productManagement(productService);
                    break;
                case 3:
//                    cartltemService.cartltem();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("yêu cầu không đúng mời nhập lại");
                    break;
            }
        }
    }

    public static void catalogManagement(CatalogService catalogService) {
        int catalogChoice;
        System.out.println("********************CATALOG-MANAGEMENT********************");
        System.out.println("1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục");
        System.out.println("2. Hiển thị thông tin tất cả các danh mục");
        System.out.println("3. Sửa tên danh mục theo mã danh mục");
        System.out.println("4. Xóa danh mục theo mã danh mục (lưu ý không xóa khi có sản phẩm)");
        System.out.println("5. Quay lại");
        System.out.print("Nhập lựa chọn: ");
        catalogChoice = Config.getInteger();

        switch (catalogChoice) {
            case 1:
                System.out.print("Nhập số danh mục cần thêm: ");
                int numOfCatalogs = Config.getInteger();

                for (int i = 0; i < numOfCatalogs; i++) {
                    System.out.println("Nhập thông tin danh mục thứ " + (i + 1) + ":");
                    System.out.print("Mã danh mục: ");
                    int catalogId = Config.getInteger();
                    System.out.print("Tên danh mục: ");
                    String catalogName = Config.getString();

                    Catalog catalog = new Catalog(catalogId, catalogName);
                    catalogService.save(catalog);
                    System.out.println("Đã thêm danh mục thành công.");
                }
                break;
            case 2:
                System.out.println("Thông tin tất cả các danh mục:");
                for (Catalog catalog : catalogService.getAll()) {
                    System.out.println(catalog.toString());
                }
                break;
            case 3:
                System.out.print("Nhập mã danh mục cần sửa: ");
                int editCatalogId = Config.getInteger();

                Catalog editCatalog = catalogService.findById(editCatalogId);
                if (editCatalog != null) {
                    System.out.print("Nhập tên danh mục mới: ");
                    String newCatalogName = Config.getString();
                    editCatalog.setCatalogName(newCatalogName);
                    System.out.println("Đã sửa tên danh mục thành công.");
                } else {
                    System.out.println("Không tìm thấy danh mục có mã " + editCatalogId);
                }
                break;
            case 4:
                System.out.print("Nhập mã danh mục cần xóa: ");
                int deleteCatalogId = Config.getInteger();

                Catalog deleteCatalog = catalogService.findById(deleteCatalogId);
                if (deleteCatalog != null) {
                    boolean hasProducts = productService.getAll().stream()
                            .anyMatch(product -> product.getCatalog().getCatalogId() == deleteCatalogId);
                    if (hasProducts) {
                        System.out.println("Không thể xóa danh mục vì có sản phẩm thuộc danh mục này.");
                    } else {
                        catalogService.delete(deleteCatalogId);
                        System.out.println("Đã xóa danh mục thành công.");
                    }
                } else {
                    System.out.println("Không tìm thấy danh mục có mã " + deleteCatalogId);
                }
                break;
            case 5:
                System.out.println("Quay lại BASIC-MENU.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                break;
        }
    }

    public static void productManagement(ProductService productService) {
        int productChoice;
        System.out.println("********************PRODUCT-MANAGEMENT********************");
        System.out.println("1. Nhập số sản phẩm và nhập thông tin sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Sắp xếp sản phẩm theo giá giảm dần");
        System.out.println("4. Xóa sản phẩm theo mã");
        System.out.println("5. Tìm kiếm sách theo tên sách");
        System.out.println("6. Thay đổi thông tin của sách theo mã sách");
        System.out.println("7. Quay lại");
        System.out.print("Nhập lựa chọn: ");
        productChoice = Config.getInteger();
        switch (productChoice) {
            case 1:
                System.out.print("Nhập số sản phẩm cần thêm: ");
                int numOfProducts = Config.getInteger();
                for (int i = 0; i < numOfProducts; i++) {
                    System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
                    System.out.print("Mã sản phẩm: ");
                    String productId = Config.getString();
                    System.out.print("Tên sản phẩm: ");
                    String productName = Config.getString();
                    System.out.print("Giá sản phẩm: ");
                    double productPrice = Config.getDouble();
                    System.out.print("Mô tả sản phẩm: ");
                    String description = Config.getString();
                    System.out.print("Số lượng tồn kho: ");
                    int stock = Config.getInteger();
                    System.out.print("Mã danh mục: ");
                    int catalogId = Config.getInteger();
                    System.out.print("Trạng thái sản phẩm: ");
                    boolean status = Config.getBoolean();
                    Catalog catalog = catalogService.findById(catalogId);
                    if (catalog != null) {
                        Product product = new Product(productId, productName, productPrice,
                                description, stock, catalog, status);
                        productService.save(product);
                        System.out.println("Đã thêm sản phẩm thành công.");
                    } else {
                        System.out.println("Không tìm thấy danh mục có mã " + catalogId);
                    }
                }
                break;
            case 2:
                System.out.println("Thông tin tất cả các sản phẩm:");
                for (Product product : productService.getAll()) {
                    System.out.println(product.toString());
                }
                break;
            case 3:
                System.out.println("Sắp xếp sản phẩm theo giá giảm dần:");
                for (Product product : productService.getAll()) {
                    System.out.println(product.toString());
                }
                break;
            case 4:
                System.out.print("Nhập mã sản phẩm cần xóa: ");
                String deleteProductId = Config.getString();

                Product deleteProduct = productService.findById(deleteProductId);
                if (deleteProduct != null) {
                    productService.delete(deleteProductId);
                    System.out.println("Đã xóa sản phẩm thành công.");
                } else {
                    System.out.println("Không tìm thấy sản phẩm có mã " + deleteProductId);
                }
                break;
            case 5:
                System.out.print("Nhập tên sách cần tìm kiếm: ");
                String searchProductName = Config.getString();
                if (!productList.isEmpty()) {
                    System.out.println("Kết quả tìm kiếm:");
                    for (Product product : productList) {
                        System.out.println(product.toString());
                    }
                } else {
                    System.out.println("Không tìm thấy sách có tên " + searchProductName);
                }
                break;
            case 6:
                System.out.print("Nhập mã sản phẩm cần thay đổi thông tin: ");
                String editProductId = Config.getString();

                Product editProduct = productService.findById(editProductId);
                if (editProduct != null) {
                    System.out.println("Nhập thông tin mới cho sản phẩm:");
                    System.out.print("Tên sản phẩm: ");
                    String newProductName = Config.getString();
                    System.out.print("Giá sản phẩm: ");
                    double newProductPrice = Config.getDouble();
                    System.out.print("Mô tả sản phẩm: ");
                    String newDescription = Config.getString();
                    System.out.print("Số lượng tồn kho: ");
                    int newStock = Config.getInteger();
                    System.out.print("Mã danh mục: ");
                    int newCatalogId = Config.getInteger();
                    System.out.print("Trạng thái sản phẩm (true/false): ");
                    boolean newStatus = Config.getBoolean();
                    Catalog newCatalog = catalogService.findById(newCatalogId);
                    if (newCatalog != null) {
                        editProduct.setProductName(newProductName);
                        editProduct.setProductPrice(newProductPrice);
                        editProduct.setDescription(newDescription);
                        editProduct.setStock(newStock);
                        editProduct.setCatalog(newCatalog);
                        editProduct.setStatus(newStatus);

                        productService.save(editProduct);
                        System.out.println("Đã cập nhật thông tin sản phẩm thành công.");
                    } else {
                        System.out.println("Không tìm thấy danh mục có mã " + newCatalogId);
                    }
                } else {
                    System.out.println("Không tìm thấy sản phẩm có mã " + editProductId);
                }
                break;
            case 7:
                System.out.println("Quay lại BASIC-MENU.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                break;
        }
    }
}
