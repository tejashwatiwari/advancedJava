package com.example.SpringBootDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.SpringBootDemo.beans.User;

import jakarta.annotation.PostConstruct;

@Repository
public class UserDAO {

	private Connection connection = null;
//
//	@Value("${dbusername}")
//	private String dbUsername;
//
//	@Value("${dbpassword}")
//	private String dbPassword;

	@PostConstruct
	private void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");
	}

	public int addUser(User user) {
		int executeStatus = 0;
		try {
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement("insert into user2(name,age,address) values(?,?,?,?)");

				statement.setString(2, user.getName());
				statement.setInt(3, user.getAge());
				statement.setString(4, user.getAddress());
				executeStatus = statement.executeUpdate();
				System.out.println(executeStatus);
				statement.close();
			}
//			connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return executeStatus;
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from user2 ");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setName(resultSet.getString(2));
				user.setAge(resultSet.getInt(3));
				user.setAddress(resultSet.getString(4));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public int deleteUser(int id) {
		int executeStatus = 0;
		try {
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement("delete from user2 where id=?");
				statement.setInt(1, id);
				executeStatus = statement.executeUpdate();
				System.out.print(executeStatus);
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return executeStatus;
	}

	public User getUser(int id) {
		User user = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from user2 where id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setId(id);
				user.setName(resultSet.getString(2));
				user.setAge(resultSet.getInt(3));
				user.setAddress(resultSet.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
