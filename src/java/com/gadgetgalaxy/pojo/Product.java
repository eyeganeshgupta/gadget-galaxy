package com.gadgetgalaxy.pojo;

import java.io.InputStream;

/**
 *
 * @author Ganesh
 */
public class Product {

    private String productId;
    private String productName;
    private String productType;
    private String productInfo;
    private double productPrice;
    private int productQuantity;
    private InputStream image;

    // Constructors
    public Product() {
        System.out.println("=== Product Pojo ===");
    }

    public Product(String productId, String productName, String productType, String productInfo,
            double productPrice, int productQuantity, InputStream image) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productInfo = productInfo;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.image = image;
        System.out.println("=== Product Pojo ===");
    }

    // Getters and setters
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "╔═══════════════════════════════════════════╗\n"
                + "║           Product Information             ║\n"
                + "╠═══════════════════════════════════════════╣\n"
                + "║ ID:       " + padRight(productId, 30) + "║\n"
                + "║ Name:     " + padRight(productName, 30) + "║\n"
                + "║ Type:     " + padRight(productType, 30) + "║\n"
                + "║ Price:    " + padRight(String.format("%.2f", productPrice), 30) + "║\n"
                + "║ Quantity: " + padRight(String.valueOf(productQuantity), 30) + "║\n"
                + "╚═══════════════════════════════════════════╝";
    }

    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
