package ra.model;

public class CartItem {
    private int cartItemId; //id sản phẩm
    private Product product; // sản phẩm
    private float price; // giá sản phẩm
    private int quantity;//số lượng sản phẩm

    public CartItem(String productId, int stock, int quantity) {
    }

    public CartItem(int cartItemId, Product product, float price, int quantity) {
        this.cartItemId = cartItemId;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return " [ "+"cartItemId = " + cartItemId + " || " +
                "product = '" + product + " || " +
                "price = " + price + " || " +
                "quantity = " + quantity + " ] ";
    }
}
