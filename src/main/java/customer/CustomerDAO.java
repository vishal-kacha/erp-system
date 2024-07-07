package customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/SRS_sdac";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	private Connection jdbcConnection;

	public void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
		}
	}

	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public void insertCustomer(CustomerPojo customer) throws SQLException {
		String sql = "INSERT INTO customers (customer_name, total_lifetime_value, average_order_value, customer_segment) VALUES (?, ?, ?, ?)";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, customer.getCustomerName());
		statement.setDouble(2, customer.getTotalLifetimeValue());
		statement.setDouble(3, customer.getAverageOrderValue());
		statement.setString(4, customer.getCustomerSegment());

		statement.executeUpdate();

		statement.close();
		disconnect();
	}

	public boolean customerExists(int customerId, String customerName) throws SQLException {
		String sql = "SELECT COUNT(*) FROM customers WHERE user_id = ? AND customer_name = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, customerId);
		statement.setString(2, customerName);

		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		boolean exists = resultSet.getInt(1) > 0;

		resultSet.close();
		statement.close();
		disconnect();

		return exists;
	}

	public void updateCustomer(CustomerPojo customer) throws SQLException {
		String sql = "UPDATE customers SET customer_name = ?, total_lifetime_value = ?, average_order_value = ?, customer_segment = ? WHERE user_id = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, customer.getCustomerName());
		statement.setDouble(2, customer.getTotalLifetimeValue());
		statement.setDouble(3, customer.getAverageOrderValue());
		statement.setString(4, customer.getCustomerSegment());
		statement.setInt(5, customer.getCustomerId());

		statement.executeUpdate();

		statement.close();
		disconnect();
	}

	public void deleteCustomer(int customerId, String customerName) throws SQLException {
		String sql = "DELETE FROM customers WHERE user_id = ? AND customer_name = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, customerId);
		statement.setString(2, customerName);

		statement.executeUpdate();

		statement.close();
		disconnect();
	}
	
    public List<CustomerPojo> getAllCustomers() throws SQLException {

		connect();
        List<CustomerPojo> customers = new ArrayList<CustomerPojo>();
        String query = "SELECT * FROM customers";
        
        try (PreparedStatement statement = jdbcConnection.prepareStatement("SELECT * FROM customers");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String customerName = resultSet.getString("customer_name");
                double totalLifetimeValue = resultSet.getDouble("total_lifetime_value");
                double averageOrderValue = resultSet.getDouble("average_order_value");
                String customerSegment = resultSet.getString("customer_segment");
                
                CustomerPojo customer = new CustomerPojo(userId, customerName, totalLifetimeValue, averageOrderValue, customerSegment);
                customers.add(customer);
            }
        }
        
        return customers;
    }
}

