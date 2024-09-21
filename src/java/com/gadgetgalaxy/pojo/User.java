package com.gadgetgalaxy.pojo;

/**
 *
 * @author Ganesh
 */

public class User {
    private String userEmail;
    private String userName;
    private String mobileNumber;
    private String address;
    private int postalCode;
    private String password;

    public User() {
        System.out.println("User Pojo");
    }

    public User(String userEmail, String userName, String mobileNumber, String address, int postalCode, String password) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.password = password;
        System.out.println("User Pojo");
    }

    // Getters and setters
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "╔═══════════════════════════════════════════╗\n" +
               "║             User Information              ║\n" +
               "╠═══════════════════════════════════════════╣\n" +
               "║ Name:     " + padRight(userName, 30) + "║\n" +
               "║ Email:    " + padRight(userEmail, 30) + "║\n" +
               "║ Mobile:   " + padRight(mobileNumber, 30) + "║\n" +
               "║ Address:  " + padRight(address, 30) + "║\n" +
               "║ Postal:   " + padRight(String.valueOf(postalCode), 30) + "║\n" +
               "╚═══════════════════════════════════════════╝";
    }

    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
