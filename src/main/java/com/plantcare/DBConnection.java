package com.plantcare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException 
    {
        String url = "jdbc:postgresql://localhost:5432/plantdb";
        String user = "postgres";
        String password = "admin1711"; 
        return DriverManager.getConnection(url, user, password);
    }
}
