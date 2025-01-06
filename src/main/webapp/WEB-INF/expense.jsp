<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Expense Table</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Your Expenses</h1>
        <table border="1" style="width: 100%; border-collapse: collapse;">
            <thead>
                <tr>
                    <th>Expense ID</th>
                    <th>Amount</th>
                    <th>Category</th>
                    <th>Description</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="expense" items="${expenses}">
                    <tr>
                        <td><c:out value="${expense.expenseId}" /></td>
                        <td><c:out value="${expense.amount}" /></td>
                        <td><c:out value="${expense.category}" /></td>
                        <td><c:out value="${expense.description}" /></td>
                        <td><c:out value="${expense.expenseDate}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
