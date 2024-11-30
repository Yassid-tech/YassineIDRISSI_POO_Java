package com.poo_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SignletonConnexionDB {
    private static Connection connection;

    static {
        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load MySQL JDBC driver", e);
        }
    }

    public SignletonConnexionDB() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/gestionprofesseurs",
                        "root",
                        ""
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
