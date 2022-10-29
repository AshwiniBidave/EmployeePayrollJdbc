package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
    static final String USER_NAME = "root";
    static final String PASSWORD = "root";

    static Connection connection = null;
    private static Config config = new Config();

    private Config() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Config getInstance() {
        return config;
    }

}
