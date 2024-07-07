import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/SRS_sdac";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "password";

	public boolean validate(Login login) {
		boolean isValid = false;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish connection
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			// Prepare statement
			statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
			statement.setString(1, login.getUsername());
			statement.setString(2, login.getPassword());

			// Execute the query
			resultSet = statement.executeQuery();

			// Check if user exists
			isValid = resultSet.next();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// Close resources
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isValid;
	}
}
