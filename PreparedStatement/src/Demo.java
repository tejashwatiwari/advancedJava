import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) throws SQLException {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");
			if (connection!=null) {
				PreparedStatement statement = connection.prepareStatement("insert into user values(?,?,?,?)");
				statement.setString(1, "John");
				statement.setString(2, "Ross");
				statement.setString(3, "JohnRoss");
				statement.setString(4, "John19");
				int executeUpdate = statement.executeUpdate();
				System.out.println(executeUpdate);
				statement.close();
			}
//			connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
