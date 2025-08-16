<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Product List</title></head>
<body>
<h2>Products</h2>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Price</th><th>Category</th><th>Actions</th></tr>
    <c:forEach var="prod" items="${products}">
        <tr>
            <td>${prod.id}</td>
            <td>${prod.name}</td>
            <td>${prod.price}</td>
            <td>${prod.categoryId}</td>
            <td>
                <a href="/products?action=edit&id=${prod.id}">Edit</a> |
                <form action="/products" method="post" style="display:inline">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${prod.id}"/>
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Add Product</h3>
<form action="/products" method="post">
    <input type="hidden" name="action" value="create"/>
    Name: <input type="text" name="name" required/>
    Price: <input type="number" step="0.01" name="price" required/>
    Category ID: <input type="number" name="categoryId" required/>
    <button type="submit">Save</button>
</form>
</body>
</html>
