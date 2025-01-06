package com.expensetracker;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Register the user in the database (implement using DAO)
        if (UserDAO.registerUser(username, password, email)) {
            response.sendRedirect("index.jsp?success=Registration successful. Please log in.");
        } else {
            response.sendRedirect("register.jsp?error=Registration failed. Try again.");
        }
    }
}
