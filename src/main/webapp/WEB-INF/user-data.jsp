<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Data</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>User Data</h1>
    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Full Name</th>
                <th>Registration Date</th>
            </tr>
        </thead>
        <tbody>
            <!-- Use JSTL to iterate over the list of users -->
            <c:forEach var="user" items="${users}">
                <tr>
                    <!-- Use EL to access user properties -->
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.fullName}" /></td>
                    <td><c:out value="${user.registrationDate}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="dashboard.html">Back to Dashboard</a>
</body>
</html>
