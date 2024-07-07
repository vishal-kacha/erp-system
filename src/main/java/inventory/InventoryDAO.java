package inventory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/SRS_sdac";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";
    private static final String SELECT_ALL_INVENTORIES = "SELECT * FROM inventory";
    private static final String INSERT_INVENTORY_SQL = "INSERT INTO inventory (itemname, quantity, availableQuantity, Daysofsupply, recentsalestrend, MinimumStockLevel) VALUES (?, ?, ?, ?, ?, ?);";
	private static final String UPDATE_INVENTORY_SQL = "UPDATE inventory SET itemname = ?, quantity = ?, availableQuantity = ?, Daysofsupply = ?, recentsalestrend = ?, MinimumStockLevel = ? WHERE itemid = ?;";
    public InventoryDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertInventory(Inventory inventory) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INVENTORY_SQL)) {
            preparedStatement.setString(1, inventory.getItemName());
            preparedStatement.setInt(2, inventory.getQuantity());
            preparedStatement.setInt(3, inventory.getAvailableQuantity());
            preparedStatement.setInt(4, inventory.getDaysOfSupply());
            preparedStatement.setString(5, inventory.getRecentSalesTrend());
            preparedStatement.setInt(6, inventory.getMinimumStockLevel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateInventory(Inventory inventory) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_INVENTORY_SQL);) {
            statement.setString(1, inventory.getItemName());
            statement.setInt(2, inventory.getQuantity());
            statement.setInt(3, inventory.getAvailableQuantity());
            statement.setInt(4, inventory.getDaysOfSupply());
            statement.setString(5, inventory.getRecentSalesTrend());
            statement.setInt(6, inventory.getMinimumStockLevel());
            statement.setInt(7, inventory.getItemId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public List<Inventory> selectAllInventories() {
        List<Inventory> inventories = new ArrayList();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INVENTORIES);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("itemid");
                String itemName = rs.getString("itemname");
                int quantity = rs.getInt("quantity");
                int availableQuantity = rs.getInt("availableQuantity");
                int daysOfSupply = rs.getInt("Daysofsupply");
                String recentSalesTrend = rs.getString("recentsalestrend");
                int minimumStockLevel = rs.getInt("MinimumStockLevel");
                inventories.add(new Inventory(id, itemName, quantity, availableQuantity, daysOfSupply, recentSalesTrend, minimumStockLevel));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }
    
    public Inventory selectInventory(int id) {
        Inventory inventory = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM inventory WHERE itemid = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String itemName = rs.getString("itemname");
                int quantity = rs.getInt("quantity");
                int availableQuantity = rs.getInt("availableQuantity");
                int daysOfSupply = rs.getInt("Daysofsupply");
                String recentSalesTrend = rs.getString("recentsalestrend");
                int minimumStockLevel = rs.getInt("MinimumStockLevel");
                inventory = new Inventory(id, itemName, quantity, availableQuantity, daysOfSupply, recentSalesTrend, minimumStockLevel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    public boolean deleteInventory(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM inventory WHERE itemid = ?")) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

}
