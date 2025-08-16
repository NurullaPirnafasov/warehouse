<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Edit Auth User</title>
</head>
<body>
<h1>Edit User</h1>
<form action="${pageContext.request.contextPath}/auth-users/edit" method="post">
  <input type="hidden" name="_method" value="PUT"/>
  <input type="hidden" name="id" value="${user.id}"/>
  Username: <input type="text" name="username" value="${user.username}"/><br/>
  Password: <input type="password" name="password"/><br/>
  First Name: <input type="text" name="firstName" value="${user.firstName}"/><br/>
  Last Name: <input type="text" name="lastName" value="${user.lastName}"/><br/>
  Super Admin: <input type="checkbox" name="superAdmin" <c:if test="${user.superAdmin}">checked</c:if>/><br/>
  Phone: <input type="text" name="phone" value="${user.phone}"/><br/>
  Image URL: <input type="text" name="imageUrl" value="${user.imageUrl}"/><br/>
  Warehouse ID: <input type="text" name="warehouseId" value="${user.warehouseId}"/><br/>
  <input type="submit" value="Update"/>
</form>
<a href="${pageContext.request.contextPath}/auth-users">Back</a>
</body>
</html>
