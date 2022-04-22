package org.example.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:postgresql://localhost:5432/hw-7";
    private static final String username = "postgres";
    private static final String password = "arlen2002";


    public static Connection connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to the PostgresSQL successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
