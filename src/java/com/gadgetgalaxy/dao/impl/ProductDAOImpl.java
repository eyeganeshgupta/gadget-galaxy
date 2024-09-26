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
}
