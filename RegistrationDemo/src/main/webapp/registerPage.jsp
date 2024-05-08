<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<% if (session.getAttribute("error") != null) { %>
        <p style="color:red;"><%= session.getAttribute("error") %></p>
        <% session.removeAttribute("error"); %>
    <% } %>
    
<h1>Welcome to Registration Page</h1>
<form action="registrationServlet" method="post">
FirstName : <input type="text" name="firstname"><br>
LastName : <input type="text" name="lastname"><br>
UserName : <input type="text" name="username"><br>
Password : <input type="text" name="password"><br>
<input type="submit">
</form>
</body>
</html>