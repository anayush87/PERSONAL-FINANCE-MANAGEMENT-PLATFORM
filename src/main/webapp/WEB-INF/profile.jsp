<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Welcome, <c:out value="${username}" /></h1>
    <p>Email: <c:out value="${email}" /></p>
    <a href="logout">Logout</a>
</body>
</html>
