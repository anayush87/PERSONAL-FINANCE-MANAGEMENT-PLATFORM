package com.expensetracker.service;

import com.expensetracker.dao.UserDAO;
import com.expensetracker.model.User;
import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userDAO);
    }

    @Test
    void testRegisterUser() {
        User user = new User("testuser", "testpass", "testemail@example.com", "Test User");
        when(userDAO.addUser(user)).thenReturn(true);

        boolean result = userService.registerUser(user);
        assertTrue(result, "User registration should succeed.");
        verify(userDAO, times(1)).addUser(user);
    }

    @Test
    void testLoginUser() {
        User user = new User("testuser", "testpass", "testemail@example.com", "Test User");
        when(userDAO.getUserByUsername("testuser")).thenReturn(user);

        User result = userService.loginUser("testuser", "testpass");
        assertNotNull(result, "User should be logged in successfully.");
        assertEquals("testuser", result.getUsername());
    }
}
