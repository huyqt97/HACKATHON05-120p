package ra.service;

import ra.config.Config;
import ra.model.Catalog;
import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService {
    static List<Product> productList = new ArrayList<>();
    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void findById(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    public void productManagement() {
        System.out.println("********************PRODUCT-MANAGEMENT********************");
        System.out.println("1. Nhập số sản sản phẩm và nhập thông tin sản phẩm ");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Sắp xếp sản phẩm theo giá giảm dần ");
        System.out.println("4. Xóa sản phẩm theo mã ");
        System.out.println("5. Tìm kiếm sách theo tên sách ");
        System.out.println("6. Thay đổi thông tin của sách theo mã sách ");
        System.out.println("7. Quay lại");
        int choice = Config.getInteger();
        switch (choice) {
            case 1:
                updateData();
                break;
            case 2:
                display();
                break;
            case 3:
                break;
            case 4:
                delete();
                break;
            case 5:
                break;
            case 6:
                edit();
                break;
            case 7:
                break;
            default:
                System.err.println("không tìm thấy yêu cầu");
                break;
        }
    }
    public static void updateData() {
        Product product = new Product();
        System.out.println("nhập mã ID danh mục");
        product.setProductId(Config.getString());
        System.out.println("nhập tên danh mục ");
        product.setProductName(Config.getString());
        System.out.println("mô tả sản phẩm ");
        product.setDescription(Config.getString());
        System.out.println("stock ");
        product.setStock(Config.getInteger());
        System.out.println("Trạng thái ");
        product.setStatus(Config.getBoolean());
        productList.add(product);
        System.out.println("thêm thành công");
    }
    public  static void display(){
        for (Product pro:
             productList) {
            System.out.println(pro);
        }
    }
    public static void delete(){
        System.out.println("nhập mã ID danh mục muốn xóa");
        String id = Config.getString();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId().equals(id)) {
                productList.remove(productList.get(i));
            }
        }
    }
    public static void edit(){
        System.out.println("nhập mã ID sản phẩm cần sửa");
        String id = Config.getString();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId().equals(id)) {
                System.out.println("nhận lại tên sản phẩm");
                productList.get(i).setProductName(Config.getString());
                System.out.println(" nhập lại mô tả sản phẩm ");
                productList.get(i).setDescription(Config.getString());
                System.out.println("nhập lại stock");
                productList.get(i).setStock(Config.getInteger());
                System.out.println("nhập lại trạng thái");
                productList.get(i).setStatus(Config.getBoolean());
            }
        }
    }
}
