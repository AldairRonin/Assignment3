package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    
    private static final String URL = "jdbc:postgresql://localhost:5432/A3_PlaylistManager";
    private static final String USER = "postgres";
    private static final String PASSWORD = "25al08di2007ar";

    private static Connection connection;

    private DatabaseConnection() {
    }
    //получение соединения с базой данных
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }
}
