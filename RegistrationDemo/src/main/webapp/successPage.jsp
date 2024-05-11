<%@ page import="java.util.List" %>
<html>
<head>
    <title>Success Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    
</head>
<body>
    <h1>Welcome, <%= request.getSession().getAttribute("firstName") %></h1>
    <table border="1" class="table table-striped" style="width: 100%; max-width: 800px;">
     <thead class="thead-dark">
        <tr>
            <th scope="col">Order ID</th>
            <th scope="col">Item Name</th>
            <th scope="col">Date Ordered</th>
            <th scope="col">Amount</th>
        </tr></thead>
        <%
            List<String> orderIDs = (List<String>) request.getSession().getAttribute("orderIDs");
            List<String> itemNames = (List<String>) request.getSession().getAttribute("itemNames");
            List<String> orderDates = (List<String>) request.getSession().getAttribute("orderDates");
            List<String> amounts = (List<String>) request.getSession().getAttribute("amounts");

            if (orderIDs != null) {
                for (int i = 0; i < orderIDs.size(); i++) {
        %>
                    <tr>
                        <td scope="row"><%= orderIDs.get(i) %></td>
                        <td scope="row"><%= itemNames.get(i) %></td>
                        <td scope="row"><%= orderDates.get(i) %></td>
                        <td scope="row"><%= amounts.get(i) %></td>
                    </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
