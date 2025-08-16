<%--
  Created by IntelliJ IDEA.
  User: zevae
  Date: 14.08.2025
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% uz.pdp.omnborxona.model.dto.ProductDto product = (uz.pdp.omnborxona.model.dto.ProductDto) request.getAttribute("product"); %>
<html>
<head>
    <title>Product Details</title>
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
        .card {
            border: none;
            border-radius: 10px;
            background-color: #f8fafc;
            padding: 20px;
        }
        .card img {
            max-width: 100%;
            border-radius: 10px;
            margin-bottom: 20px;
        }
        .card p {
            font-size: 16px;
            margin: 10px 0;
            color: #1f2937;
        }
        .label {
            font-weight: bold;
            color: #1e3a8a;
        }
        .btn-back {
            background: linear-gradient(45deg, #3b82f6, #2563eb);
            color: white;
            border-radius: 25px;
            padding: 10px 20px;
            transition: all 0.3s ease;
        }
        .btn-back:hover {
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
    <h1>Product Details</h1>
    <div class="card">
        <% if (product != null) { %>
        <p><span class="label">ID:</span> <%= product.getId() %></p>
        <p><span class="label">Name:</span> <%= product.getName() %></p>
        <p><span class="label">Description:</span> <%= product.getDescription() != null ? product.getDescription() : "No description" %></p>
        <p><span class="label">Price:</span> $<%= String.format("%.2f", product.getPrice()) %></p>
        <p><span class="label">Quantity:</span> <%= product.getQuantity() %></p>
        <p><span class="label">Warehouse ID:</span> <%= product.getWarehouseId() %></p>
        <p><span class="label">Category ID:</span> <%= product.getCategoryId() %></p>
        <% if (product.getImage() != null && !product.getImage().isEmpty()) { %>
        <p><span class="label">Image:</span> <img src="<%= product.getImage() %>" alt="Product Image"></p>
        <% } %>
        <% } else { %>
        <p class="text-center">Product not found</p>
        <% } %>
    </div>
    <a href="/product" class="btn btn-back">Back to List</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```