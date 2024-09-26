package com.gadgetgalaxy.dao;

import com.gadgetgalaxy.pojo.Product;
import java.util.List;

/**
 *
 * @author Ganesh
 */
public interface ProductDAO {

    public String addProduct(Product product);

    public String updateProduct(Product previousProduct, Product updatedProduct);

    public String updateProductPrice(String productId, double updatedPrice);

    public List<Product> getAllProducts();

    public List<Product> getAllProductsByType(String type);

    public List<Product> searchAllProducts(String search);

    public Product getProductDetails(String productId);

    public int getProductQuantity(String productId);

    public String updateProductWithoutImage(String previousProductId, Product updatedProduct);

    public double getProductPrice(String productId);

    public boolean sellNProduct(String productId, int noOfProduct);

    public List<String> getAllProductsType();

    public byte[] getImage(String productId);

    public String removeProduct(String productId);
}
