<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Account</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 0;
    }

    .account-container {
      max-width: 400px;
      background: white;
      padding: 20px;
      margin: 50px auto;
      border-radius: 10px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }

    .account-container h2 {
      text-align: center;
      color: #333;
    }

    .account-info {
      margin-top: 20px;
    }

    .account-info p {
      font-size: 16px;
      margin: 8px 0;
    }

    .logout-btn {
      display: block;
      width: 95%;
      padding: 10px;
      background-color: #e74c3c;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      margin-top: 20px;
      text-align: center;
      text-decoration: none;
    }

    .logout-btn:hover {
      background-color: #c0392b;
    }
  </style>
</head>
<body>

<div class="account-container">
  <h2>Account Information</h2>
  <div class="account-info">
    <img width="100%" src="photo_2025-08-11_09-14-19.jpg" alt="">
    <p><Strong>Username: </Strong> Jkesh</p>
    <p><strong>First Name: </strong> John</p>
    <p><strong>Last Name: </strong> Doe</p>
    <p><strong>Phone: </strong> +998 (93) 604 59 01</p>
    <p><strong>Role: </strong> User</p>


  </div>
  <a href="index.html" class="logout-btn">Log Out</a>
</div>

</body>
</html>
