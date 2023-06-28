package ra.model;

public class Product {
    private String productId; // id sản phẩm
    private String productName; // tên sản phẩm
    private String description; // miêu tả sản phẩm
    private int stock; // giá
    private Catalog catalog; // mục lục
    private boolean status;// tình trạng sản phẩm

    public Product() {
    }

    public Product(String productId, String productName, String description, int stock, Catalog catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.stock = stock;
        this.catalog = catalog;
        this.status = status;
    }

    public Product(String productId, String productName, double productPrice, String description, int stock, Catalog catalog, boolean status) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", catalog=" + catalog +
                ", status=" + (status? "còn hàng":"hết hàng") +
                '}';
    }

    public void setProductPrice(double newPrice) {
    }

    public static <T> double getProductPrice(T t) {
        return 0;
    }
}
