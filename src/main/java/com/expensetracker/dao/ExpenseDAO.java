package com.expensetracker.dao;

import com.expensetracker.model.Expense;
import com.expensetracker.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

	public List<Expense> getExpensesByUserId(int userId) {
	    List<Expense> expenses = new ArrayList<>();
	    String sql = "SELECT * FROM expenses WHERE user_id = ?";

	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        
	        statement.setInt(1, userId);  // Pass the user ID to the query
	        ResultSet resultSet = statement.executeQuery();
	        
	        while (resultSet.next()) {
	            Expense expense = new Expense();
	            expense.setExpenseId(resultSet.getInt("expense_id"));
	            expense.setUserId(resultSet.getInt("user_id"));
	            expense.setAmount(resultSet.getBigDecimal("amount"));
	            expense.setCategory(resultSet.getString("category"));
	            expense.setDescription(resultSet.getString("description"));
	            expense.setExpenseDate(resultSet.getDate("expense_date"));
	            expenses.add(expense);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return expenses;
	}

}
