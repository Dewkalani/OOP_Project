package services;

import dao.ProductDB;
import models.Product;
import java.util.List;

public class ProductService {

    private final ProductDB dao = new ProductDB();

    public boolean addProduct(Product p) {
        return dao.addProduct(p);
    }

    public boolean updateProduct(Product p) {
        return dao.updateProduct(p);
    }

    public boolean deleteProduct(int productId) {
        return dao.deleteProduct(productId);
    }

    public boolean updateStock(int productId, int quantityAdded) {
        return dao.updateStock(productId, quantityAdded);
    }

    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    public List<Product> getLowStockProducts() {
        return dao.getLowStockProducts();
    }

    public Product getProductById(int productId) {
        return dao.getProductById(productId);
    }
}
