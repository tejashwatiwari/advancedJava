package com.apex;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			ServletContext servletContext = config.getServletContext();
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=	DriverManager.getConnection(servletContext.getInitParameter("connectionURL"),
					servletContext.getInitParameter("userName"), servletContext.getInitParameter("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			Statement statement = connection.createStatement();
			String queryString = "update user set password='"+password+"' where username='"+username+"'";
			int executeUpdate = statement.executeUpdate(queryString);
			PrintWriter writer = response.getWriter();
			response.setContentType("text/html");
			if (executeUpdate > 0) {
				writer.append("User Details updated successfully");
			} else {
				writer.append("Error updating the user");
			}
//			writer.close(); 
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}
	


}
