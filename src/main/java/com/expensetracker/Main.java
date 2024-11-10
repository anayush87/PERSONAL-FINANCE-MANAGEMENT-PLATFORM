package com.expensetracker;

import com.expensetracker.util.DatabaseConnection;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // Test the database connection
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) 
        {
            System.out.println("Database connected successfully!");
        } 
        else
        {
            System.out.println("Failed to connect to the database.");
        }
    }
}
