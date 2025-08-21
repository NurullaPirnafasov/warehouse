<%--
  Created by IntelliJ IDEA.
  User: zevae
  Date: 14.08.2025
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
```jsp
<% uz.pdp.omnborxona.model.dto.ProductDto product = (uz.pdp.omnborxona.model.dto.ProductDto) request.getAttribute("product"); %>
<html>
<head>
    <title>Update Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #6b7280, #1e3a8a);
            min-height: 100vh;
            padding: 20px;
            color: #fff;
        }
        .container {
            max-width: 600px;
            margin: auto;
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
        }
        .form-label {
            font-weight: bold;
            color: #1e3a8a;
        }
        .form-control, .form-control-file {
            border-radius: 10px;
            border: 1px solid #d1d5db;
            padding: 10px;
            transition: all 0.3s ease;
        }
        .form-control:focus, .form-control-file:focus {
            border-color: #3b82f6;
            box-shadow: 0 0 5px rgba(59, 130, 246, 0.5);
        }
        textarea.form-control {
            height: 100px;
        }
        .btn-update {
            background: linear-gradient(45deg, #f59e0b, #d97706);
            color: white;
            border-radius: 25px;
            padding: 10px 20px;
            font-weight: 500;
            transition: all 0.3s ease;
        }
        .btn-back {
            background: linear-gradient(45deg, #3b82f6, #2563eb);
            color: white;
            border-radius: 25px;
            padding: 10px 20px;
            font-weight: 500;
            transition: all 0.3s ease;
        }
        .btn-update:hover, .btn-back:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        }
        .current-image {
            max-width: 150px;
            border-radius: 10px;
            margin-top: 10px;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Update Product</h1>
    <% if (product != null) { %>
    <form action="/product" method="post" enctype="multipart/form-data" class="needs-validation" novalidate>
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= product.getId() %>">
        <div class="mb-3">
            <label for="name" class="form-label">Name:</label>
            <input type="text" id="name" name="name" class="form-control" value="<%= product.getName() %>" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description:</label>
            <textarea id="description" name="description" class="form-control"><%= product.getDescription() != null ? product.getDescription() : "" %></textarea>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price:</label>
            <input type="number" id="price" name="price" class="form-control" step="0.01" value="<%= String.format("%.2f", product.getPrice()) %>" required>
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">Image:</label>
            <input type="file" id="image" name="image" class="form-control-file" accept="image/*">
            <% if (product.getImage() != null && !product.getImage().isEmpty()) { %>
            <p>Current Image: <img src="<%= product.getImage() %>" alt="Current Image" class="current-image"></p>
            <% } %>
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity:</label>
            <input type="number" id="quantity" name="quantity" class="form-control" value="<%= product.getQuantity() %>" required>
        </div>
        <div class="mb-3">
            <label for="warehouseId" class="form-label">Warehouse ID:</label>
            <input type="text" id="warehouseId" name="warehouseId" class="form-control" value="<%= product.getWarehouseId() %>" required>
        </div>
        <div class="mb-3">
            <label for="categoryId" class="form-label">Category ID:</label>
            <input type="text" id="categoryId" name="categoryId" class="form-control" value="<%= product.getCategoryId() %>" required>
        </div>
        <button type="submit" class="btn btn-update">Update</button>
        <a href="/product" class="btn btn-back">Back to List</a>
    </form>
    <% } else { %>
    <p class="text-center">Product not found</p>
    <% } %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```

