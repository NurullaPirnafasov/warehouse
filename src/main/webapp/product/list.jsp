<%--
  Created by IntelliJ IDEA.
  User: zevae
  Date: 14.08.2025
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
```jsp
<% java.util.List<uz.pdp.omnborxona.model.dto.ProductDto> products = (java.util.List<uz.pdp.omnborxona.model.dto.ProductDto>) request.getAttribute("products"); %>
<html>
<head>
    <title>Product List</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #6b7280, #1e3a8a); /* Jonli gradient fon */
            min-height: 100vh;
            padding: 20px;
            color: #fff;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
            animation: fadeIn 1s ease-in-out;
        }
        h1 {
            color: #1e3a8a;
            text-align: center;
            font-weight: bold;
            margin-bottom: 30px;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
        }
        table {
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
        }
        th {
            background: linear-gradient(45deg, #2563eb, #3b82f6); /* Gradient table header */
            color: white;
            padding: 15px;
        }
        td {
            padding: 15px;
            vertical-align: middle;
        }
        tr:hover {
            background-color: #f0f9ff;
            transform: scale(1.01);
            transition: all 0.3s ease;
        }
        .btn-custom {
            padding: 8px 15px;
            border-radius: 25px;
            font-weight: 500;
            transition: all 0.3s ease;
        }
        .btn-view { background: linear-gradient(45deg, #2ecc71, #22c55e); }
        .btn-edit { background: linear-gradient(45deg, #f59e0b, #d97706); }
        .btn-delete { background: linear-gradient(45deg, #ef4444, #dc2626); }
        .btn-add {
            background: linear-gradient(45deg, #3b82f6, #2563eb);
            margin-bottom: 20px;
        }
        .btn-custom:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Products</h1>
    <a href="/product?action=add" class="btn btn-custom btn-add text-white">Add New Product</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% if (products != null && !products.isEmpty()) { %>
        <% for (uz.pdp.omnborxona.model.dto.ProductDto product : products) { %>
        <tr>
            <td><%= product.getId() %></td>
            <td><%= product.getName() %></td>
            <td>$<%= String.format("%.2f", product.getPrice()) %></td>
            <td><%= product.getQuantity() %></td>
            <td>
                <a href="/product?id=<%= product.getId() %>" class="btn btn-custom btn-view text-white">View</a>
                <a href="/product?action=update&id=<%= product.getId() %>" class="btn btn-custom btn-edit text-white">Edit</a>
                <a href="/product?action=delete&id=<%= product.getId() %>" class="btn btn-custom btn-delete text-white" onclick="return confirm('Are you sure you want to delete?')">Delete</a>
            </td>
        </tr>
        <% } %>
        <% } else { %>
        <tr>
            <td colspan="5" class="text-center">No products found</td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<!-- Bootstrap JS (for interactive components if needed) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```
```
