<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Edit Category</title></head>
<body>
<h2>Edit Category</h2>
<form action="/categories" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="${category.id}"/>
    Name: <input type="text" name="name" value="${category.name}" required/>
    Description: <input type="text" name="description" value="${category.description}"/>
    <button type="submit">Update</button>
</form>
</body>
</html>
