import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SRS_sdac";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public void addUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            // Prepare statement
            statement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            
            // Execute the query
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
