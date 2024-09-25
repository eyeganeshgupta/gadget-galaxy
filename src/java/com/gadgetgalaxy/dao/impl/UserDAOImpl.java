package com.gadgetgalaxy.dao.impl;

/**
 *
 * @author Ganesh
 */

import com.gadgetgalaxy.dao.UserDAO;
import com.gadgetgalaxy.pojo.User;
import com.gadgetgalaxy.utility.DBUtil;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getName());

    /**
     * 🚀 Register a new user
     */
    @Override
    public String registerUser(User user) {
        if(isRegistered(user.getUserEmail())) {
            return "This email address is already linked to an existing account.";
        }
        
        String sql = "INSERT INTO users (user_email, user_name, mobile_number, address, postal_code, password) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            Connection conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserEmail());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getMobileNumber());
            pstmt.setString(4, user.getAddress());
            pstmt.setInt(5, user.getPostalCode());
            pstmt.setString(6, user.getPassword());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return "User registered successfully!";
            } else {
                return "User registration failed.";
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occurred during registration", e);
            return "Error occurred during registration: " + e.getMessage();
        } finally {
            DBUtil.closeStatement(pstmt);
        }
    }

    /**
     * 🔍 Check if a user is already registered
     */
    @Override
    public boolean isRegistered(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE user_email = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking user registration", e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(pstmt);
        }
        return false;
    }

    /**
     * 🔐 Validate user credentials
     */
    @Override
    public String isValidCredentails(String email, String password) {
        String sql = "SELECT user_name FROM users WHERE user_email = ? AND password = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("user_name") + "Successfully logged in.";
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error validating user credentials", e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(pstmt);
        }
        return "Access denied. Incorrect username or password.";
    }

    /**
     * 📋 Retrieve full user details
     */
    @Override
    public User getUserDetails(String email) {
        String sql = "SELECT * FROM users WHERE user_email = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserEmail(rs.getString("user_email"));
                user.setUserName(rs.getString("user_name"));
                user.setMobileNumber(rs.getString("mobile_number"));
                user.setAddress(rs.getString("address"));
                user.setPostalCode(rs.getInt("postal_code"));
                // Note: We typically don't return the password for security reasons
                return user;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving user details", e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(pstmt);
        }
        return null;
    }

    /**
     * 👤 Get the first name of a user
     */
    @Override
    public String getUserFirstName(String email) {
        String sql = "SELECT user_name FROM users WHERE user_email = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String fullName = rs.getString("user_name");
                return fullName.split(" ")[0]; // Assuming the first name is the first part of the full name
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving user's first name", e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(pstmt);
        }
        return null;
    }

    /**
     * 🏠 Get the address of a user
     */
    @Override
    public String getUserAddress(String email) {
        String sql = "SELECT address FROM users WHERE user_email = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.provideConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("address");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving user's address", e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(pstmt);
        }
        return null;
    }
}
