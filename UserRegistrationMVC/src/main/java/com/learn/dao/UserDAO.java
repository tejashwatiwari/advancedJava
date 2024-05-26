package com.learn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learn.bean.UserBean;

public class UserDAO {

	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");
	}

	public UserBean getUserBean(UserBean userBean) {
		try (Connection connection = getConnection()) {
			String query = "SELECT * FROM user WHERE username=? AND password=?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, userBean.getUserName());
				statement.setString(2, userBean.getPassword());
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						userBean.setFirstName(resultSet.getString("firstname"));
						userBean.setLastName(resultSet.getString("lastname"));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userBean;
	}

	public boolean isUsernameExists(String username) {
		try (Connection connection = getConnection()) {
			String query = "SELECT 1 FROM user WHERE username=?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, username);
				try (ResultSet resultSet = statement.executeQuery()) {
					return resultSet.next();
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean registerUser(UserBean userBean) {
		try (Connection connection = getConnection()) {
			String query = "INSERT INTO user (firstname, lastname, username, password) VALUES (?, ?, ?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, userBean.getFirstName());
				statement.setString(2, userBean.getLastName());
				statement.setString(3, userBean.getUserName());
				statement.setString(4, userBean.getPassword());
				int result = statement.executeUpdate();
				return result > 0;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
