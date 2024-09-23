package com.gadgetgalaxy.pojo;

import java.sql.Date;

/**
 *
 * @author Ganesh
 */
public class Transaction {

    private String transactionId;
    private String userEmail;
    private Date transactionTimeDate;
    private double amount;

    // Constructors
    public Transaction() {
        System.out.println("=== Transaction Pojo ===");
    }

    public Transaction(String transactionId, String userEmail, Date transactionTimeDate, double amount) {
        this.transactionId = transactionId;
        this.userEmail = userEmail;
        this.transactionTimeDate = transactionTimeDate;
        this.amount = amount;
        System.out.println("=== Transaction Pojo ===");
    }

    // Getters and setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getTransactionTimeDate() {
        return transactionTimeDate;
    }

    public void setTransactionTimeDate(Date transactionTimeDate) {
        this.transactionTimeDate = transactionTimeDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "╔═══════════════════════════════════════════╗\n"
                + "║         Transaction Information           ║\n"
                + "╠═══════════════════════════════════════════╣\n"
                + "║ ID:       " + padRight(transactionId, 30) + "║\n"
                + "║ User:     " + padRight(userEmail, 30) + "║\n"
                + "║ Date:     " + padRight(transactionTimeDate.toString(), 30) + "║\n"
                + "║ Amount:   " + padRight(String.format("%.2f", amount), 30) + "║\n"
                + "╚═══════════════════════════════════════════╝";
    }

    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
