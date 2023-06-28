package ra.service;

import ra.config.Config;
import ra.model.CartItem;
import ra.model.Product;

public class cartltemService {
    static ProductService  productService = new ProductService();
    public void cartltem() {
        while (true) {
            System.out.println("1. tất cả sản phẩm trong cửa hàng");
            System.out.println("2. mua sản phẩm");
            System.out.println("3. hiển thị sản phẩm đã mua");
            System.out.println("4. cập nhập số ");
            System.out.println("5. xóa 1 sản phẩm");
            System.out.println("6. xóa toàn bộ sản phẩm");
            System.out.println("7. Quay lại");
            int choice = Config.getInteger();
            switch (choice) {
                case 1:
                    displayProduct();
                    break;
                case 2:
                    addCart();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    return;
                default:
                    System.err.println("mời nhập lại yêu cầu");
                    break;
            }
        }
    }
    public static void displayProduct(){
        System.out.println("Danh sách tất cả sản phẩm:");
        for (Product product : productService.getAll()) {
            System.out.println(product.toString());
        }
    }
    public static void addCart() {
        System.out.print("Nhập mã sản phẩm: ");
        String productId = Config.getString();
        Product product = productService.findById(productId);
        if (product != null) {
            System.out.print("Nhập số lượng: ");
            int quantity = Config.getInteger();
            int stock = product.getStock();
            if (quantity > 0 && quantity <= stock) {
                CartItem cart = new CartItem(productId, product.getStock(), quantity);
                cartltemService.addCart(cart);
                System.out.println("Sản phẩm đã được thêm vào giỏ hàng.");
            } else {
                System.out.println("Số lượng sản phẩm không khả dụng.");
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }
}
