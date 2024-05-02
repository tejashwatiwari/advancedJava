package com.training;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class AccountDAO {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");
			System.out.println(connection);
			Statement statement = connection.createStatement();
//			int insert = statement.executeUpdate("insert into account values(1, 'mohit','temp',1000)");
//			System.out.println("Number return "+ insert);
//			int update = statement.executeUpdate("update account set bal=2000 where id=1");
//			System.out.println("Number return " + update);
//			statement.executeUpdate= statement.executeUpdate("");
//			statement.executeQuery = statement.executeQuery("");
//			int delete = statement.executeUpdate("delete from account where id=1");
//			System.out.println("Number return " + delete);
			ResultSet resultSet = statement.executeQuery("select * from account");
			while (resultSet.next()) {
				System.out.println("ID of User is "+resultSet.getInt(1));
				System.out.println("FirstName of User is "+resultSet.getString(2));
				System.out.println("LastName of User is "+resultSet.getString(3));
				System.out.println("Bal of User is "+resultSet.getInt(4));
				System.out.println("----------------------------------------------------------------");
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} 
			finally {
			connection.close();
		}
	}

}
