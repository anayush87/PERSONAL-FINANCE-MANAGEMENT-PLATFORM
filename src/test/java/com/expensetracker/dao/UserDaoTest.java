package com.expensetracker.dao;

import com.expensetracker.model.User;
import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private UserDAO userDAO;
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        // Mock or use a test database connection
        connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/expense_tracker", 
            "root", 
            "mysql"
        );
        userDAO = new UserDAO(connection);
    }

    @Test
    void testAddUser() throws SQLException {
        User user = new User("testuser", "testpass", "testemail@example.com", "Test User");
        boolean result = userDAO.addUser(user);
        assertTrue(result, "User should be added successfully.");
    }

    @Test
    void testGetUserByUsername() throws SQLException {
        User user = userDAO.getUserByUsername("testuser");
        assertNotNull(user, "User should exist in the database.");
        assertEquals("testuser", user.getUsername());
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }
}
