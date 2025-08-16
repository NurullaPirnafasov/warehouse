<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Warehouse System</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, sans-serif;
            background: #f5f5f5;
            color: #333;
            line-height: 1.6;
        }


        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #2f3b4c;
            padding: 10px 20px;
            color: white;
        }

        .logo {
            display: flex;
            align-items: center;
        }

        .logo-icon {
            width: 30px;
            height: 30px;
            margin-right: 10px;
        }

        .account-btn {
            background-color: #4a90e2;
            color: white;
            padding: 8px 15px;
            border-radius: 5px;
            text-decoration: none;
        }

        .account-btn:hover {
            background-color: #357ac9;
        }


        .header h1 {
            font-size: 1.5rem;
            font-weight: 500;
        }

        .container {
            max-width: 1200px;
            margin: 2rem auto;
            padding: 0 1rem;
        }

        .tabs {
            background: white;
            border-radius: 8px;
            padding: 1rem;
            margin-bottom: 2rem;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            display: flex;
            gap: 2rem;
        }

        .tab {
            color: #666;
            text-decoration: none;
            padding: 0.5rem 0;
            border-bottom: 2px solid transparent;
            transition: all 0.3s;
        }

        .tab:hover,
        .tab.active {
            color: #2c3e50;
            border-bottom-color: #3498db;
        }

        .stats {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 1rem;
            margin-bottom: 2rem;
        }

        .stat-card {
            background: white;
            padding: 1.5rem;
            border-radius: 8px;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
        }

        .stat-number {
            font-size: 2rem;
            font-weight: 600;
            color: #2c3e50;
        }

        .stat-label {
            color: #666;
            font-size: 0.9rem;
            margin-top: 0.5rem;
        }

        .content {
            display: grid;
            grid-template-columns: 2fr 1fr;
            gap: 2rem;
        }

        .table-section {
            display: flex;
            background: white;
            border-radius: 8px;
            padding: 1.5rem;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
        }

        .section-title {
            font-size: 1.2rem;
            margin-bottom: 1rem;
            color: #2c3e50;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            text-align: left;
            padding: 0.75rem;
            background: #f8f9fa;
            color: #666;
            font-weight: 500;
            font-size: 0.9rem;
        }

        td {
            padding: 0.75rem;
            border-top: 1px solid #e9ecef;
        }

        tr:hover {
            background: #f8f9fa;
        }

        .status {
            display: inline-block;
            padding: 0.25rem 0.75rem;
            border-radius: 12px;
            font-size: 0.85rem;
            font-weight: 500;
        }

        .status.available {
            background: #d4edda;
            color: #155724;
        }

        .status.low {
            background: #fff3cd;
            color: #856404;
        }

        .status.out {
            background: #f8d7da;
            color: #721c24;
        }

        .side-panel {
            background: white;
            border-radius: 8px;
            padding: 1.5rem;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            height: fit-content;
        }

        .category-list {
            list-style: none;
        }

        .product-container {
            display: flex;
            gap: 20px;
        }

        .product-card {
            border: 2px solid green;
            border-radius: 10px;
            padding: 15px;
            width: 250px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .product-card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 8px;
        }

        button {
            margin: 5px 0;
            padding: 10px;
            border: none;
            border-radius: 5px;
        }

        .add {
            background-color: #4a90e2;
            color: white;
        }

        .delete {
            background-color: #bbb;
            color: white;
        }

        .category-list li {
            padding: 0.75rem;
            border-bottom: 1px solid #e9ecef;
            cursor: pointer;
            transition: background 0.2s;
        }

        .category-list li:hover {
            background: #f8f9fa;
        }

        .category-list li:last-child {
            border-bottom: none;
        }

        .category-count {
            float: right;
            background: #e9ecef;
            padding: 0.2rem 0.5rem;
            border-radius: 10px;
            font-size: 0.85rem;
        }

        .actions {
            margin-top: 2rem;
        }

        button {
            padding: 0;
            border: none;
            background: none;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            color: white;
            background-color: #4a90e2;
            /* Blue */
            border-radius: 5px;
        }

        .btn.secondary {
            background-color: #bbb;
            /* Gray */
        }

        .btn:hover {
            background-color: #357ac9;
            /* Darker blue */
        }

        .btn.secondary:hover {
            background-color: #999;
            /* Darker gray */
        }





        /* Search Bar */
        .search-bar {
            margin-bottom: 1rem;
        }

        .search-bar input {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 1rem;
        }

        .search-bar input:focus {
            outline: none;
            border-color: #3498db;
        }

        @media (max-width: 768px) {
            .content {
                grid-template-columns: 1fr;
            }

            .stats {
                grid-template-columns: 1fr;
            }

            .tabs {
                flex-wrap: wrap;
                gap: 1rem;
            }

            table {
                font-size: 0.9rem;
            }

            th,
            td {
                padding: 0.5rem;
            }
        }

        .cards {
            display: flex;
        }

        .card {
            text-align: center;
            border-radius: 12px;
            width: 200px;
            height: 250px;
            border: green 3px solid;
            padding: 10px;
            box-shadow: 1px 3px 5px grey;

        }
        .streamline--warehouse-1 {
            display: inline-block;
            width: 20px;
            height: 20px;
            --svg: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 14 14'%3E%3Cg fill='none' stroke='%23000' stroke-linecap='round' stroke-linejoin='round' stroke-width='1'%3E%3Cpath d='M13.5 6.94a1 1 0 0 0-.32-.74L7 .5L.82 6.2a1 1 0 0 0-.32.74v5.56a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1z'/%3E%3Cpath d='M7.25 10.001h2.999s.25 0 .25.25v2.999s0 .25-.25.25H7.25s-.25 0-.25-.25v-2.999s0-.25.25-.25m-1.75-3.5h2.999s.25 0 .25.25V9.75s0 .25-.25.25H5.5s-.25 0-.25-.25V6.751s0-.25.25-.25m-1.749 3.5H6.75s.25 0 .25.25v2.999s0 .25-.25.25H3.751s-.25 0-.25-.25v-2.999s0-.25.25-.25'/%3E%3C/g%3E%3C/svg%3E");
            background-color: currentColor;
            -webkit-mask-image: var(--svg);
            mask-image: var(--svg);
            -webkit-mask-repeat: no-repeat;
            mask-repeat: no-repeat;
            -webkit-mask-size: 100% 100%;
            mask-size: 100% 100%;
            margin-right: 17px;

        }
    </style>
</head>

<body>
<!-- Header -->
<header class="header">
    <div class="logo">
        <span class="streamline--warehouse-1"></span>
        <h1>Warehouse Management</h1>
    </div>
    <nav>
        <a href="account.html" class="account-btn">Account</a>
    </nav>
</header>


<!-- Container -->
<div class="container">

    <!-- Stats -->
    <div class="stats">
        <div class="stat-card">
            <div class="stat-number">2</div>
            <div class="stat-label">Total Products</div>
        </div>
        <div class="stat-card">
            <div class="stat-number">6</div>
            <div class="stat-label">Categories</div>
        </div>
        <div class="stat-card">
            <div class="stat-number">89%</div>
            <div class="stat-label">Stock Level</div>
        </div>
    </div>

    <!-- Main Content -->
    <div class="content">
        <!-- Product Table -->


        <div class="product-container">
            <div class="product-card">
                <img src="china dragon image.png" alt="Dragon Art">
                <h3>Iphone X</h3>
                <details>
                    <summary>Description</summary>
                    <p>High-quality smartphone with unique design.</p>
                </details>
                <p><strong>Price:</strong> $175</p>
                <p><strong>Quantity:</strong> 134</p>
                <button>
                    <a href="#add" class="btn">Add Product</a>
                </button>
                <button>
                    <a href="#delete" class="btn secondary">Delete</a>
                </button>

            </div>

            <div class="product-card">
                <img src="photo_2025-08-11_09-14-19.jpg" alt="Person">
                <h3>Iphone X</h3>
                <details>
                    <summary>Description</summary>
                    <p>High-quality smartphone with unique design.</p>
                </details>
                <p><strong>Price:</strong> $175</p>
                <p><strong>Quantity:</strong> 134</p>
                <button>
                    <a href="#add" class="btn">Add Product</a>
                </button>
                <button>
                    <a href="#delete" class="btn secondary">Delete</a>
                </button>

            </div>

        </div>


        <!-- Side Panel -->
        <div class="side-panel">
            <h2 class="section-title">Categories</h2>
            <ul class="category-list">
                <li>
                    Electronics
                    <span class="category-count">342</span>
                </li>
                <li>
                    Furniture
                    <span class="category-count">156</span>
                </li>
                <li>
                    Office Supplies
                    <span class="category-count">423</span>
                </li>
                <li>
                    Hardware
                    <span class="category-count">89</span>
                </li>
                <li>
                    Tools
                    <span class="category-count">67</span>
                </li>
                <li>
                    Safety Equipment
                    <span class="category-count">45</span>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>

</html>