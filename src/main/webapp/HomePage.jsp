<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<!-- Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<!-- CSS -->
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #667eea, #764ba2);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .container {
        background: rgba(255, 255, 255, 0.1);
        padding: 40px 60px;
        border-radius: 20px;
        backdrop-filter: blur(12px);
        box-shadow: 0 10px 30px rgba(0,0,0,0.2);
        text-align: center;
        width: 90%;
        max-width: 500px;
    }

    h2 {
        color: #fff;
        font-size: 36px;
        margin-bottom: 20px;
        text-shadow: 2px 2px 5px rgba(0,0,0,0.2);
    }

    h3 {
        color: #fff;
        margin-bottom: 20px;
        font-weight: 500;
    }

    .btn {
        display: block;
        width: 100%;
        margin: 10px 0;
        padding: 14px;
        font-size: 18px;
        border: none;
        border-radius: 12px;
        background: #ffffff;
        color: #333;
        text-decoration: none;
        transition: all 0.3s ease;
        position: relative;
        overflow: hidden;
    }

    .btn i {
        margin-right: 8px;
    }

    .btn:hover {
        background-color: #4e54c8;
        color: #fff;
        transform: scale(1.03);
        box-shadow: 0 6px 15px rgba(0,0,0,0.2);
    }

    @media (max-width: 600px) {
        .container {
            padding: 30px 20px;
        }

        .btn {
            font-size: 16px;
        }
    }
</style>

<!-- JS Animation -->
<script>
    window.onload = function() {
        const buttons = document.querySelectorAll('.btn');
        buttons.forEach((btn, index) => {
            btn.style.opacity = '0';
            setTimeout(() => {
                btn.style.transition = 'opacity 0.8s ease-in-out';
                btn.style.opacity = '1';
            }, 200 * index);
        });
    }
</script>
</head>

<body>
    <div class="container">
        <h2>Welcome to HomePage</h2>

        <% String msg = (String) request.getAttribute("msg"); %>
        <% if(msg != null) { %>
            <h3><%= msg %></h3>
        <% } %>  

        <a class="btn" href="AddCourse.jsp"><i class="fas fa-plus-circle"></i>Add Course</a>
        <a class="btn" href="view"><i class="fas fa-eye"></i>View Courses</a>
        <a class="btn" href="AddTeacher.jsp"><i class="fas fa-user-plus"></i>Add Teacher</a>
         <a class="btn" href="viewTeacher"><i class="fas fa-user-plus"></i>View All Teacher</a>
    </div>
</body>
</html>
