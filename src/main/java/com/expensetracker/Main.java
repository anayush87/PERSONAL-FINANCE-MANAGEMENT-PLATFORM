package com.expensetracker;

import java.sql.Connection;

import com.expensetracker.util.DatabaseConnection;

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
