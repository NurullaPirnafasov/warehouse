<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Auth Users List</title>
</head>
<body>
<h1>Auth Users</h1>
<a href="${pageContext.request.contextPath}/auth-users?action=add">+ Add User</a>
<table border="1" cellpadding="5">
  <tr>
    <th>ID</th>
    <th>Username</th>
    <th>Full Name</th>
    <th>Phone</th>
    <th>Warehouse</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="u" items="${users}">
    <tr>
      <td>${u.id}</td>
      <td>${u.username}</td>
      <td>${u.firstName} ${u.lastName}</td>
      <td>${u.phone}</td>
      <td>${u.warehouseName}</td>
      <td>
        <a href="${pageContext.request.contextPath}/auth-users/${u.id}">Info</a> |
        <a href="${pageContext.request.contextPath}/auth-users?action=update&id=${u.id}">Edit</a> |
        <form action="${pageContext.request.contextPath}/auth-users" method="post" style="display:inline;">
          <input type="hidden" name="_method" value="DELETE"/>
          <input type="hidden" name="id" value="${u.id}"/>
          <input type="submit" value="Delete"/>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
