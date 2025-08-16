<%--
  Created by IntelliJ IDEA.
  User: zevae
  Date: 14.08.2025
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String error = (String) request.getAttribute("error"); %>
<html>
<head>
    <title>Error</title>
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
        }
        .alert {
            background: linear-gradient(45deg, #ef4444, #dc2626);
            color: white;
            border-radius: 10px;
            padding: 15px;
        }
        .btn-back {
            background: linear-gradient(45deg, #3b82f6, #2563eb);
            color: white;
            border-radius: 25px;
            padding: 10px 20px;
            font-weight: 500;
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
    <h1>Error</h1>
    <div class="alert">
        <%= error != null ? error : "An unexpected error occurred" %>
    </div>
    <a href="/product" class="btn btn-back">Back to List</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```
