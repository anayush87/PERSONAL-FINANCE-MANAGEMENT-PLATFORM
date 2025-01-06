package com.expensetracker;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.model.Expense;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/expenses")
public class ExpenseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ExpenseService expenseService = new ExpenseService(); // Assume this uses DAO

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");  // Get logged-in user

        if (user != null) {
            // Fetch expenses for the logged-in user
            List<Expense> expenses = expenseService.getExpensesByUserId(user.getId());
            request.setAttribute("expenses", expenses);

            // Forward to JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/expense-table.jsp");
            dispatcher.forward(request, response);
        } else {
            // Redirect to login page if user is not logged in
            response.sendRedirect("login.jsp");
        }
    }
}
}
