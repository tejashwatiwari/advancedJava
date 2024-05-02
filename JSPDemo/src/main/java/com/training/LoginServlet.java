package com.training;

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

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection;
		try {
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");
		 
		 String firstName="";
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if(null!=userName && null!=password) {
			if (connection!=null) {
				 PreparedStatement statement = connection.prepareStatement("select * from user where username=? and password=?");
				 statement.setString(1,  userName);
				 statement.setString(2,  password);
				 ResultSet resultSet = statement.executeQuery();
				 while (resultSet.next()) {
					 firstName = resultSet.getString(0);
							 System.out.println();
				 }
			 }
		}
		HttpSession session = request.getSession();
		session.setAttribute("firstName", firstName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
