package com.gadgetgalaxy.pojo;

/**
 *
 * @author Ganesh
 */
public class UserCart {

    private String userEmail;
    private String productId;
    private int quantity;

    // Constructors
    public UserCart() {
        System.out.println("=== UserCart Pojo ===");
    }

    public UserCart(String userEmail, String productId, int quantity) {
        this.userEmail = userEmail;
        this.productId = productId;
        this.quantity = quantity;
        System.out.println("=== UserCart Pojo ===");
    }

    // Getters and setters
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "╔═══════════════════════════════════════════╗\n"
                + "║          User Cart Information            ║\n"
                + "╠═══════════════════════════════════════════╣\n"
                + "║ User:     " + padRight(userEmail, 30) + "║\n"
                + "║ Product:  " + padRight(productId, 30) + "║\n"
                + "║ Quantity: " + padRight(String.valueOf(quantity), 30) + "║\n"
                + "╚═══════════════════════════════════════════╝";
    }

    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
