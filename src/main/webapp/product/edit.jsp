<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Edit Product</title></head>
<body>
<h2>Edit Product</h2>
<form action="/products" method="post">
  <input type="hidden" name="action" value="update"/>
  <input type="hidden" name="id" value="${product.id}"/>
  Name: <input type="text" name="name" value="${product.name}" required/>
  Price: <input type="number" step="0.01" name="price" value="${product.price}" required/>
  Category ID: <input type="number" name="categoryId" value="${product.categoryId}" required/>
  <button type="submit">Update</button>
</form>
</body>
</html>
