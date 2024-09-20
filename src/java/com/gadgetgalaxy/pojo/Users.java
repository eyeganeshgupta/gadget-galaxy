package com.gadgetgalaxy.pojo;

/**
 *
 * @author Ganesh
 */

public class Users {
    private String userEmail;
    private String userName;
    private String mobileNumber;
    private String address;
    private int postalCode;
    private String password;

    public Users() {
        System.out.println("Users Pojo");
        
    }

    public Users(String userEmail, String userName, String mobileNumber, String address, int postalCode, String password) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.password = password;
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
}
