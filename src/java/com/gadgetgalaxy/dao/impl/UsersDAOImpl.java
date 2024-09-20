package com.gadgetgalaxy.dao.impl;

/**
 *
 * @author Ganesh
 */

import com.gadgetgalaxy.dao.UsersDAO;
import com.gadgetgalaxy.pojo.Users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    private Connection connection; 

    @Override
    public void addUser(Users user) {
        String sql = "INSERT INTO users (user_email, user_name, mobile_number, address, postal_code, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserEmail());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getMobileNumber());
            pstmt.setString(4, user.getAddress());
            pstmt.setInt(5, user.getPostalCode());
            pstmt.setString(6, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE user_email = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Users(
                    rs.getString("user_email"),
                    rs.getString("user_name"),
                    rs.getString("mobile_number"),
                    rs.getString("address"),
                    rs.getInt("postal_code"),
                    rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new Users(
                    rs.getString("user_email"),
                    rs.getString("user_name"),
                    rs.getString("mobile_number"),
                    rs.getString("address"),
                    rs.getInt("postal_code"),
                    rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(Users user) {
        String sql = "UPDATE users SET user_name = ?, mobile_number = ?, address = ?, postal_code = ?, password = ? WHERE user_email = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getMobileNumber());
            pstmt.setString(3, user.getAddress());
            pstmt.setInt(4, user.getPostalCode());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getUserEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String email) {
        String sql = "DELETE FROM users WHERE user_email = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
