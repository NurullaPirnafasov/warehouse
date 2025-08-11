<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Auth User</title>
</head>
<body>
<h1>Add New User</h1>
<form action="${pageContext.request.contextPath}/auth-users" method="post">
    Username: <input type="text" name="username"/><br/>
    Password: <input type="password" name="password"/><br/>
    First Name: <input type="text" name="firstName"/><br/>
    Last Name: <input type="text" name="lastName"/><br/>
    Super Admin: <input type="checkbox" name="superAdmin"/><br/>
    Phone: <input type="text" name="phone"/><br/>
    Image URL: <input type="text" name="imageUrl"/><br/>
    Warehouse ID: <input type="text" name="warehouseId"/><br/>
    <input type="submit" value="Save"/>
</form>
<a href="${pageContext.request.contextPath}/auth-users">Back</a>
</body>
</html>
