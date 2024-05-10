package com.training;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");
			String firstName = "";
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
	        List<String> orderIDs = new ArrayList<>();
	        List<String> itemNames = new ArrayList<>();
	        List<String> orderDates = new ArrayList<>();
	        List<String> amounts = new ArrayList<>();
			if (null != userName && null != password) {
				if (connection != null) {
					PreparedStatement statement = connection
							.prepareStatement("select * from user where username=? and password=?");
					statement.setString(1, userName);
					statement.setString(2, password);
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						firstName = resultSet.getString(1);
					}
				}
			}
			HttpSession session = request.getSession();
			if (firstName.length() != 0) {
				session.setAttribute("firstName", firstName);
				
				//fetching table logic
				PreparedStatement statement = connection.prepareStatement("select * from orders");
				ResultSet orderSet = statement.executeQuery();
				while(orderSet.next()) {
					 orderIDs.add(orderSet.getString("orderID"));
	                 itemNames.add(orderSet.getString("item_name"));
	                 orderDates.add(orderSet.getString("date_order_placed"));
	                 amounts.add(orderSet.getString("amount"));
				}
                session.setAttribute("orderIDs", orderIDs);
                session.setAttribute("itemNames", itemNames);
                session.setAttribute("orderDates", orderDates);
                session.setAttribute("amounts", amounts);	
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("successPage.jsp");
				requestDispatcher.forward(request, response);
				

			} else {
				session.setAttribute("error", "Invalid Login");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.jsp");
				requestDispatcher.include(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}