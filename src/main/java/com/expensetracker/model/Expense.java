package com.expensetracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense {
    private int expenseId;
    private int userId;
    private BigDecimal amount;
    private String category;
    private String description;
    private Date expenseDate;

    // Getters and Setters
    public int getExpenseId() { return expenseId; }
    public void setExpenseId(int expenseId) { this.expenseId = expenseId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getExpenseDate() { return expenseDate; }
    public void setExpenseDate(Date expenseDate) { this.expenseDate = expenseDate; }
}
