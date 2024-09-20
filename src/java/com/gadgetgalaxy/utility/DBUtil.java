package com.gadgetgalaxy.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ganesh
 */
public class DBUtil {
    private static Connection conn;
    private static final Logger LOGGER = Logger.getLogger(DBUtil.class.getName());

    /**
     * Opens a database connection
     * @param dbUrl The database URL
     * @param username The database username
     * @param password The database password
     */
    public static void openConnection(String dbUrl, String username, String password) {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(dbUrl, username, password);
                LOGGER.info("Connection opened!");
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error in opening connection", ex);
            }
        }
    }

    /**
     * Closes the database connection
     */
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                LOGGER.info("Connection closed!");
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error in closing connection", ex);
            }
        }
    }

    /**
     * Provides the current database connection
     * @return The active Connection object
     */
    public static Connection provideConnection() {
        return conn;
    }

    /**
     * Closes a ResultSet object
     * @param rs The ResultSet to be closed
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                LOGGER.info("ResultSet closed");
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error in closing ResultSet", ex);
            }
        }
    }

    /**
     * Closes a Statement object
     * @param st The Statement to be closed
     */
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
                LOGGER.info("Statement closed");
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error in closing Statement", ex);
            }
        }
    }
}
