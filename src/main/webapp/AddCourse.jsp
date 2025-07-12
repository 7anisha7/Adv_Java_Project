<%@page import="Bean.Teacher"%>
<%@page import="java.util.ArrayList"%>
<%@page import="AdminOperations.AllTeacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Course</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #74ebd5, #ACB6E5);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: white;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            width: 450px;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, textarea, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
        }

        textarea {
            resize: vertical;
        }

        button {
            width: 100%;
            margin-top: 25px;
            padding: 12px;
            background-color: #4facfe;
            border: none;
            color: white;
            font-size: 18px;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #00f2fe;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Add New Course</h2>
    <% String msg = (String) request.getAttribute("msg"); %>
		
		<% if(msg!=null){%>
		<h3 style="text-align:center; color:red;"><%=msg %></h3>
		<%} %>
    <form action="AddCourseServlet" method="post">
        <label for="course_id">Course ID</label>
        <input type="text" id="course_id" name="course_id" maxlength="10" required>

        <label for="courseName">Course Name</label>
        <input type="text" id="courseName" name="courseName" maxlength="40" required>

        <label for="courseDuration">Course Duration (in hours)</label>
        <input type="number" id="courseDuration" name="courseDuration" required>

        <label for="courseFee">Course Fee (₹)</label>
        <input type="number" id="courseFee" name="courseFee" step="0.01" required>

        <label for="rate">Rating (out of 5)</label>
        <input type="number" id="rate" name="rate" step="0.1" max="5" required>

        <label for="TeacherName">Teacher Name</label>
        
        <label for="options">Choose an option:</label>
        <select id="options" name="options">		
		 <option >Select the faculty</option>
        <%
       ArrayList<Teacher>al= new AllTeacher().getAllTeacher();
        for(Teacher t:al)
        {
        %>
        	 <option value="<%=t.getTeacherName()%>"><%=t.getTeacherName()%></option>
        	 <% 
        }
        %>
		</select>
        

        <label for="Language">Language</label>
		<select id="options" name="Languages">	
         <option >Select the language </option>
		 <option value="eng">English</option>
		 <option value="hin">Hindi</option>
		 <option value="tel">Telugu</option>
		 <option value="hinglish">Both</option>
		 </select>

        <label for="description">Description</label>
        <textarea id="description" name="description" rows="4" maxlength="255" required></textarea>

		<label for="image">Image</label>
        <textarea id="image" name="image" rows="4" maxlength="255" required></textarea>


        <button type="submit">Add Course</button>
    </form>
</div>

</body>
</html>
