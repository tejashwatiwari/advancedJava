<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration Page</title>
    <!-- Include Bootstrap CSS from CDN -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
   <%--  <div class="container mt-5">
        <% if (session.getAttribute("error") != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= session.getAttribute("error") %>
            </div>
            <% session.removeAttribute("error"); %>
        <% } %> --%>
		<h1>
       <% out.println(request.getAttribute("message")); %>
       </h1>
        <form action="registrationSuccessful" method="post" class="w-50">
            <div class="form-group">
                <label for="firstname">FirstName:</label>
                <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Enter your first name">
            </div>
            <div class="form-group">
                <label for="lastname">LastName:</label>
                <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter your last name">
            </div>
            <div class="form-group">
                <label for="username">UserName:</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Choose a username">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter a password">
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>

    <!-- Include Bootstrap JS, Popper.js, and jQuery from CDN -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
