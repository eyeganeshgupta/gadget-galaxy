package com.gadgetgalaxy.dao.impl;

/**
 *
 * @author Ganesh
 */
import com.gadgetgalaxy.dao.ProductDAO;
import com.gadgetgalaxy.pojo.Product;
import com.gadgetgalaxy.utility.DBUtil;
import com.gadgetgalaxy.utility.IDUtil;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAOImpl implements ProductDAO {

    private static final Logger LOGGER = Logger.getLogger(ProductDAOImpl.class.getName());

    @Override
    public String addProduct(Product product) {
        if (product.getProductId() == null) {
            product.setProductId(IDUtil.generateProductId());
        }

        String sql = "INSERT INTO products (product_id, product_name, product_type, product_info, product_price, product_quantity, image) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        String message = "Failed to add product.";
        try {
            conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getProductId());
            pstmt.setString(2, product.getProductName());
            pstmt.setString(3, product.getProductType());
            pstmt.setString(4, product.getProductInfo());
            pstmt.setDouble(5, product.getProductPrice());
            pstmt.setInt(6, product.getProductQuantity());
            pstmt.setBlob(7, product.getImage());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 1) {
                message = "Product added successfully!";
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding product", e);
            message = "Error adding in product";
        } finally {
            DBUtil.closeStatement(pstmt);
        }
        return message;
    }

    @Override
    public String updateProduct(Product previousProduct, Product updatedProduct) {
        if (!previousProduct.getProductId().equals(updatedProduct.getProductId())) {
            return "Product Identification Mismatch: Update Process Unsuccessful";
        }
        
        String sql = "UPDATE products SET product_name = ?, product_type = ?, product_info = ?, product_price = ?, product_quantity = ?, image = ? WHERE product_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        String message = "Failed to update product.";
        try {
            conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updatedProduct.getProductName());
            pstmt.setString(2, updatedProduct.getProductType());
            pstmt.setString(3, updatedProduct.getProductInfo());
            pstmt.setDouble(4, updatedProduct.getProductPrice());
            pstmt.setInt(5, updatedProduct.getProductQuantity());
            pstmt.setBlob(6, updatedProduct.getImage());
            pstmt.setString(7, previousProduct.getProductId());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                message = "Product updated successfully!";
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating product", e);
        } finally {
            DBUtil.closeStatement(pstmt);
        }
        return message;
    }

    @Override
    public String updateProductPrice(String productId, double updatedPrice) {
        String sql = "UPDATE products SET product_price = ? WHERE product_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        String message = "Failed to update product price.";
        try {
            conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, updatedPrice);
            pstmt.setString(2, productId);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                message = "Product price updated successfully!";
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating product price", e);
        } finally {
            DBUtil.closeStatement(pstmt);
        }
        return message;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.provideConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductType(rs.getString("product_type"));
                product.setProductInfo(rs.getString("product_info"));
                product.setProductPrice(rs.getDouble("product_price"));
                product.setProductQuantity(rs.getInt("product_quantity"));
                product.setImage(rs.getAsciiStream("image"));
                products.add(product);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all products", e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
        }
        return products;
    }

    @Override
    public List<Product> getAllProductsByType(String type) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE product_type like ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + type + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductType(rs.getString("product_type"));
                product.setProductInfo(rs.getString("product_info"));
                product.setProductPrice(rs.getDouble("product_price"));
                product.setProductQuantity(rs.getInt("product_quantity"));
                product.setImage(rs.getAsciiStream("image"));
                products.add(product);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving products by type", e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(pstmt);
        }
        return products;
    }

    @Override
    public List<Product> searchAllProducts(String search) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE lower(product_name) LIKE ? OR lower(product_type) LIKE ? OR product_info LIKE ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + search + "%");
            pstmt.setString(2, "%" + search + "%");
            pstmt.setString(3, "%" + search + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductType(rs.getString("product_type"));
                product.setProductInfo(rs.getString("product_info"));
                product.setProductPrice(rs.getDouble("product_price"));
                product.setProductQuantity(rs.getInt("product_quantity"));
                product.setImage(rs.getAsciiStream("image"));
                products.add(product);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error searching products", e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(pstmt);
        }
        return products;
    }

    @Override
    public Product getProductDetails(String productId) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Product product = null;
        try {
            conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductType(rs.getString("product_type"));
                product.setProductInfo(rs.getString("product_info"));
                product.setProductPrice(rs.getDouble("product_price"));
                product.setProductQuantity(rs.getInt("product_quantity"));
                product.setImage(rs.getAsciiStream("image"));
                return product;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving product details", e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(pstmt);
        }
        return product;
    }

    @Override
    public int getProductQuantity(String productId) {
        String sql = "SELECT product_quantity FROM products WHERE product_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int quantity = 0;
        try {
            conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("product_quantity");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving product quantity", e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(pstmt);
        }
        return quantity;
    }
}
