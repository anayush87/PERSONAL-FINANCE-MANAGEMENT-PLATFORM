package com.expensetracker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login");
            return;
        }

        String username = (String) session.getAttribute("username");
        try (Connection connection = DatabaseConnection.initializeDatabase()) {
            String sql = "SELECT username, email FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                request.setAttribute("username", resultSet.getString("username"));
                request.setAttribute("email", resultSet.getString("email"));
                request.getRequestDispatcher("WEB-INF/views/profile.jsp").forward(request, response);
            } else {
                response.sendRedirect("WEB-INF/views/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("WEB-INF/views/error.jsp");
        }
    }
}
