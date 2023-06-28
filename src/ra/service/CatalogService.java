package ra.service;

import ra.config.Config;
import ra.model.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogService implements IService {
    static List<Catalog> catalogArrayList = new ArrayList<>();

    @Override
    public List<Catalog> getAll() {
        return catalogArrayList;
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

    public void catalogManagement() {
        System.out.println("********************CATALOG-MANAGEMENT********************");
        System.out.println("1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục");
        System.out.println("2. Hiển thị thông tin tất cả các danh mục ");
        System.out.println("3. Sửa tên danh mục theo mã danh mục ");
        System.out.println("4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm)");
        System.out.println("5. Quay lại");
        int choice = Config.getInteger();
        switch (choice) {
            case 1:
                updateData();
                break;
            case 2:
                displayCatalog();
                break;
            case 3:
                create();
                break;
            case 4:
                delete();
                break;
            case 5:
                break;
            default:
                System.err.println("không tìm thấy yêu cầu");
                break;
        }
    }

    public static void updateData() {
        Catalog catalog = new Catalog();
        System.out.println("nhập mã ID danh mục");
        catalog.setCatalogId(Config.getInteger());
        System.out.println("nhập tên danh mục ");
        catalog.setCatalogName(Config.getString());
        catalogArrayList.add(catalog);
        System.out.println("thêm thành công");
    }

    public static void displayCatalog() {
        for (Catalog car : catalogArrayList
        ) {
            System.out.println(car);
        }
    }

    public static void create() {
        Catalog catalog = new Catalog();
        System.out.println("nhập mã ID danh mục cần sửa");
        int id = Config.getInteger();
        for (int i = 0; i < catalogArrayList.size(); i++) {
            if (catalogArrayList.get(i).getCatalogId() == id) {
                System.out.println("nhận lại tên danh mục");
                catalogArrayList.get(i).setCatalogName(Config.getString());
            }
        }
    }

    public static void delete() {
        System.out.println("nhập mã ID danh mục muốn xóa");
        int id = Config.getInteger();
        for (int i = 0; i < catalogArrayList.size(); i++) {
            if (catalogArrayList.get(i).getCatalogId() == id) {
                catalogArrayList.remove(catalogArrayList.get(i));
            }
        }
    }

}
