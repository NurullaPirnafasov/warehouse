<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Category List</title></head>
<body>
<h2>Categories</h2>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Description</th><th>Actions</th></tr>
    <c:forEach var="cat" items="${categories}">
        <tr>
            <td>${cat.id}</td>
            <td>${cat.name}</td>
            <td>${cat.description}</td>
            <td>
                <a href="/categories?action=edit&id=${cat.id}">Edit</a> |
                <form action="/categories" method="post" style="display:inline">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${cat.id}"/>
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<h3>Add Category</h3>
<form action="/categories" method="post">
    <input type="hidden" name="action" value="create"/>
    Name: <input type="text" name="name" required/>
    Description: <input type="text" name="description"/>
    <button type="submit">Save</button>
</form>
</body>
</html>
