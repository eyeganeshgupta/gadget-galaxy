/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gadgetgalaxy.pojo;

/**
 *
 * @author Ganesh
 */
public class Order {

    private String orderId;
    private String productId;
    private int quantity;
    private double amount;
    private int isShipped;

    // Constructors
    public Order() {
        System.out.println("=== Order Pojo ===");
    }

    public Order(String orderId, String productId, int quantity, double amount, int isShipped) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.isShipped = isShipped;
        System.out.println("=== Order Pojo ===");
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getIsShipped() {
        return isShipped;
    }

    public void setIsShipped(int isShipped) {
        this.isShipped = isShipped;
    }

    @Override
    public String toString() {
        return "╔═══════════════════════════════════════════╗\n"
                + "║            Order Information              ║\n"
                + "╠═══════════════════════════════════════════╣\n"
                + "║ Order ID:  " + padRight(orderId, 30) + "║\n"
                + "║ Product:   " + padRight(productId, 30) + "║\n"
                + "║ Quantity:  " + padRight(String.valueOf(quantity), 30) + "║\n"
                + "║ Amount:    " + padRight(String.format("%.2f", amount), 30) + "║\n"
                + "║ Is Shipped:" + padRight(String.valueOf(isShipped), 30) + "║\n"
                + "╚═══════════════════════════════════════════╝";
    }

    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
