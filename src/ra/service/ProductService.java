package ra.service;

import ra.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductService implements IService<Product, String> {
    private static List<Product> productList;

    public ProductService() {
        this.productList = new ArrayList<>();
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(String productId) {
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(String productId) {
        Product product = findById(productId);
        if (product != null) {
            productList.remove(product);
        }
    }

    public void sortProductsByPriceDescending() {
        productList.sort(Comparator.comparingDouble(Product::getProductPrice).reversed());
    }

    public List<Product> searchProductByName(String productName) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }

    public void updateProductInfo(String productId, String newName, double newPrice, String newDescription) {
        Product product = findById(productId);
        if (product != null) {
            product.setProductName(newName);
            product.setProductPrice(newPrice);
            product.setDescription(newDescription);
        }
    }
}
