<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>User Info</title>
</head>
<body>
<h1>User Details</h1>
<p>ID: ${user.id}</p>
<p>Username: ${user.username}</p>
<p>Full Name: ${user.firstName} ${user.lastName}</p>
<p>Phone: ${user.phone}</p>
<p>Super Admin: ${user.superAdmin}</p>
<p>Warehouse: ${user.warehouseName}</p>
<p><img src="${user.imageUrl}" alt="User Image" width="100"/></p>
<a href="${pageContext.request.contextPath}/auth-users">Back</a>
</body>
</html>
