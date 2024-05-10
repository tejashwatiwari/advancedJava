package com.training;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement checkUserStmt = null;
        PreparedStatement insertStmt = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");

            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            String checkUserSQL = "SELECT * FROM user WHERE username = ?";
            checkUserStmt = connection.prepareStatement(checkUserSQL);
            checkUserStmt.setString(1, username);
            resultSet = checkUserStmt.executeQuery();

            if (resultSet.next()) {
                HttpSession session = request.getSession();
            	session.getAttribute(username);
                session.setAttribute("error", username + " Username already exists! Enter a different username");
                RequestDispatcher dispatcher = request.getRequestDispatcher("registerPage.jsp");
                dispatcher.forward(request, response);
            } else {
                String insertSQL = "INSERT INTO user (firstname, lastname, username, password) VALUES (?, ?, ?, ?)";
                insertStmt = connection.prepareStatement(insertSQL);
                insertStmt.setString(1, firstname);
                insertStmt.setString(2, lastname);
                insertStmt.setString(3, username);
                insertStmt.setString(4, password);

                int result = insertStmt.executeUpdate();
                if (result > 0) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("registerSuccessful.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Database connection problem", e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (checkUserStmt != null) checkUserStmt.close();
                if (insertStmt != null) insertStmt.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
