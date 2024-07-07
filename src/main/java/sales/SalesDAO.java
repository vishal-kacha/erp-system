package sales;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/SRS_sdac";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String INSERT_SALES_SQL = "INSERT INTO sales (salespersonName, Target, NumberOfUnits, NumberOfUnitsSold, CompletionStatus) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_SALES_SQL = "UPDATE sales SET salespersonName=?, Target=?, NumberOfUnits=?, NumberOfUnitsSold=?, CompletionStatus=? WHERE salesID=?";
    private static final String DELETE_SALES_SQL = "DELETE FROM sales WHERE salesID=?";
    private static final String SELECT_ALL_SALES = "SELECT * FROM sales";
    private static final String SELECT_SALES_BY_ID = "SELECT * FROM sales WHERE salesID=?";

    public SalesDAO() {}

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertSales(Sales sales) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SALES_SQL)) {
            preparedStatement.setString(1, sales.getSalespersonName());
            preparedStatement.setInt(2, sales.getTarget());
            preparedStatement.setInt(3, sales.getNumberOfUnits());
            preparedStatement.setInt(4, sales.getNumberOfUnitsSold());
            preparedStatement.setString(5, sales.getCompletionStatus());
            preparedStatement.executeUpdate();
        }
    }

    public boolean updateSales(Sales sales) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SALES_SQL)) {
            statement.setString(1, sales.getSalespersonName());
            statement.setInt(2, sales.getTarget());
            statement.setInt(3, sales.getNumberOfUnits());
            statement.setInt(4, sales.getNumberOfUnitsSold());
            statement.setString(5, sales.getCompletionStatus());
            statement.setInt(6, sales.getSalesID());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteSales(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SALES_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public List<Sales> getAllSales() {
        List<Sales> salesList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SALES);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int salesID = rs.getInt("salesID");
                String salespersonName = rs.getString("salespersonName");
                int target = rs.getInt("Target");
                int numberOfUnits = rs.getInt("NumberOfUnits");
                int numberOfUnitsSold = rs.getInt("NumberOfUnitsSold");
                String completionStatus = rs.getString("CompletionStatus");
                salesList.add(new Sales(salesID, salespersonName, target, numberOfUnits, numberOfUnitsSold, completionStatus));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return salesList;
    }

    public Sales getSales(int id) {
        Sales sales = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SALES_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String salespersonName = rs.getString("salespersonName");
                int target = rs.getInt("Target");
                int numberOfUnits = rs.getInt("NumberOfUnits");
                int numberOfUnitsSold = rs.getInt("NumberOfUnitsSold");
                String completionStatus = rs.getString("CompletionStatus");
                sales = new Sales(id, salespersonName, target, numberOfUnits, numberOfUnitsSold, completionStatus);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return sales;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
