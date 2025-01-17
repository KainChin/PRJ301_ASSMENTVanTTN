<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Mechanic</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: white;
            color: #f0f0f0; /* Màu chữ sáng */
            text-align: center;
            padding: 20px;
        }
        
        p {
            color: #8B4513;
        }
        h1 {
            font-size: 2.5em;
            color: #ffcc00; /* Màu vàng kim loại */
            text-shadow: 2px 2px 4px #000; /* Tạo hiệu ứng bóng */
        }
        .menu {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 50px;
        }
        .menu-item {
            background-color: #333;
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
            cursor: pointer;
            text-transform: uppercase;
            font-weight: bold;
            transition: transform 0.3s ease, background-color 0.3s ease;
        }
        .menu-item:hover {
            background-color: #555;
            transform: scale(1.1); /* Hiệu ứng phóng to */
        }
        .menu-item a {
            text-decoration: none;
            color: #ffcc00;
            font-size: 1.2em;
        }
        .menu-item a:hover {
            color: #fff; /* Chữ đổi màu khi hover */
        }
    </style>
</head>
<body>
    <h1>Welcome, <%= request.getAttribute("mechanicName") %>!</h1>
    <p>You have successfully logged in as a mechanic. Here are your details:</p>
  
    
    <!-- Menu -->
    <div class="menu">
        <div class="menu-item">
            <a href="xem-ve-dich-vu.html">Xem vé dịch vụ</a>
        </div>
        <div class="menu-item">
            <a href="cap-nhat-ve-dich-vu.html">Cập nhật vé dịch vụ</a>
        </div>
        <div class="menu-item">
            <a href="quan-ly-dich-vu.html">Quản lý dịch vụ</a>
        </div>
    </div>
</body>
</html>
