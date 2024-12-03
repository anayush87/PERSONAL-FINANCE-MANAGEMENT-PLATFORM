package com.expensetracker;

import com.expensetracker.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (userDAO.loginUser(email, password)) {
            // Login successful, redirect to dashboard
            request.getSession().setAttribute("user", email);
            response.sendRedirect("dashboard.html");
        } else {
            // Login failed, redirect back to login page with an error message
            request.setAttribute("error", "Invalid email or password");
            request.getRequestDispatcher("index.html").forward(request, response);
        }
    }
}
