package com.gadgetgalaxy.listener;

import com.gadgetgalaxy.utility.DBUtil;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Ganesh
 */

public class DBConnectionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        String dbUrl = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        DBUtil.openConnection(dbUrl, username, password);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       DBUtil.closeConnection();
    }
}
