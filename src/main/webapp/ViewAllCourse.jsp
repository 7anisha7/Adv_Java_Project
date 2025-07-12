<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Bean.*,java.util.*" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Course List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .msg {
            text-align: center;
            color: #28a745;
            font-size: 1.2em;
            margin-bottom: 20px;
        }

        .table-container {
            max-width: 90%;
            margin: auto;
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
            text-transform: uppercase;
            font-size: 14px;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        input[type="text"] {
            width: 50%;
            padding: 10px;
            margin: 20px auto;
            display: block;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
    </style>

    <script>
        function filterTable() {
            let input = document.getElementById("searchInput");
            let filter = input.value.toLowerCase();
            let rows = document.querySelectorAll("table tbody tr");

            rows.forEach(row => {
                let text = row.innerText.toLowerCase();
                row.style.display = text.includes(filter) ? "" : "none";
            });
        }
    </script>
</head>
<body>

    <h2>Available Courses</h2>

    <% String msg = (String) request.getAttribute("msg"); %>
    <% if (msg != null) { %>
        <div class="msg"><%= msg %></div>
    <% } %>

    <input type="text" id="searchInput" onkeyup="filterTable()" placeholder="Search for courses...">

    <div class="table-container">
    <%
        ArrayList<CourseBean> al = (ArrayList<CourseBean>) request.getAttribute("alist");
        if (al != null) {
    %>
        <table>
            <thead>
                <tr>
                    <th>Course Id</th>
                    <th>Name</th>
                    <th>Teacher</th>
                    <th>Duration</th>
                    <th>Fees</th>
                    <th>Language</th>
                    <th>Description</th>
                    <th>Rating</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
            <%
                for(CourseBean course : al){
            %>
                <tr>
                    <td><%=course.getCid() %></td>
                    <td><%=course.getCname() %></td>
                    <td><%=course.getTeachName() %></td>
                    <td><%=course.getCduration() %></td>
                    <td><%=course.getCfee() %></td>
                    <td><%=course.getLang() %></td>
                    <td><%=course.getDesc() %></td>
                    <td><%=course.getRate() %></td>
                    <td><a href="#">edit</a></td>
                    <td><a href="deleteCourse?cid=<%=course.getCid() %>">Delete</a></td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    <%
        }
    %>
    </div>

</body>
</html>
