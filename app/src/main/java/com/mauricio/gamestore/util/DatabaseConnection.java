package com.mauricio.gamestore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/loja_games?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "app_user";
    private static final String PASSWORD = "app_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
