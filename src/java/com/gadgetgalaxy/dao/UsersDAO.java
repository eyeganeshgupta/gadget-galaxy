package com.gadgetgalaxy.dao;

import com.gadgetgalaxy.pojo.Users;
import java.util.List;

public interface UsersDAO {
    void addUser(Users user);
    Users getUserByEmail(String email);
    List<Users> getAllUsers();
    void updateUser(Users user);
    void deleteUser(String email);
}