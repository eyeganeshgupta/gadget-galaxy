package com.gadgetgalaxy.utility;

/**
 *
 * @author Ganesh
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private static Connection conn;

    /**
     * 🔓 Opens a database connection
     * @param dbUrl The database URL
     * @param username The database username
     * @param password The database password
     */
    public static void openConnection(String dbUrl, String username, String password) {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(dbUrl, username, password);
                System.out.println("Connection opened! 🎉");
            } catch (SQLException ex) {
                System.out.println("Error in opening connection 😢");
                ex.printStackTrace();
            }
        }
    }

    /**
     * 🔒 Closes the database connection
     */
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed! 👋");
            } catch (SQLException ex) {
                System.out.println("Error in closing connection 😱");
                ex.printStackTrace();
            }
        }
    }

    /**
     * 🔗 Provides the current database connection
     * @return The active Connection object
     */
    public static Connection provideConnection() {
        return conn;
    }

    /**
     * 📊 Closes a ResultSet object
     * @param rs The ResultSet to be closed
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("ResultSet closed 📊✅");
            } catch (SQLException ex) {
                System.out.println("Error in closing ResultSet 📊❌");
                ex.printStackTrace();
            }
        }
    }

    /**
     * 📝 Closes a Statement object
     * @param st The Statement to be closed
     */
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
                System.out.println("Statement closed 📝✅");
            } catch (SQLException ex) {
                System.out.println("Error in closing Statement 📝❌");
                ex.printStackTrace();
            }
        }
    }
}
