package com.apex;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class LoginServlet
 */


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Init Load for SuccessServlet");
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");
			System.out.println(connection);
			Statement statement = connection.createStatement();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			ResultSet resultSet = statement.executeQuery("select * from user where username='"+username+"' and password='"+password+"'");
			if (!resultSet.next()) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.html");
				requestDispatcher.include(request, response); //use if we want to show the html content page
			}
			while (resultSet.next()) {
				if(resultSet.getString(1)!=null) {
					//success
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("successServlet");
					requestDispatcher.forward(request, response); //if we want to forward this to a specific page
				} 

			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
