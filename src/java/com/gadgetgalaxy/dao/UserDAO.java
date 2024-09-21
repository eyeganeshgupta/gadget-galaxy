package com.gadgetgalaxy.dao;

import com.gadgetgalaxy.pojo.User;

/**
 * 🌟 UserDAO Interface 🌟
 * 
 * This interface defines the data access operations for User management in the GadgetGalaxy.
 * It provides methods for user registration, authentication, and retrieval of user details.
 */
public interface UserDAO {

    /**
     * 🚀 Register a new user
     * @param user The User object containing registration details
     * @return A String message indicating the registration status
     */
    String registerUser(User user);

    /**
     * 🔍 Check if a user is already registered
     * @param email The email address to check
     * @return true if the user is registered, false otherwise
     */
    boolean isRegistered(String email);

    /**
     * 🔐 Validate user credentials
     * @param email The user's email address
     * @param password The user's password
     * @return A String message indicating the validation status
     */
    String isValidCredentails(String email, String password);

    /**
     * 📋 Retrieve full user details
     * @param email The email address of the user
     * @return A User object containing all user details
     */
    User getUserDetails(String email);

    /**
     * 👤 Get the first name of a user
     * @param email The email address of the user
     * @return The first name of the user
     */
    String getUserFirstName(String email);

    /**
     * 🏠 Get the address of a user
     * @param email The email address of the user
     * @return The address of the user
     */
    String getUserAddress(String email);
}
