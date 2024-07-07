package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/SRS_sdac";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product (ProductName, Description, Category, Price, stockLevel) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT productId, ProductName, Description, Category, Price, stockLevel FROM product WHERE productId = ?";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM product WHERE productId = ?";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE product SET ProductName = ?, Description = ?, Category = ?, Price = ?, stockLevel = ? WHERE productId = ?";

    public ProductDAO() {}

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

    public boolean insertProduct(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getStockLevel());

            return preparedStatement.executeUpdate() > 0;
        }
    }

    public Product selectProduct(int productId) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("ProductName");
                String description = rs.getString("Description");
                String category = rs.getString("Category");
                double price = rs.getDouble("Price");
                int stockLevel = rs.getInt("stockLevel");
                product = new Product(productId, productName, description, category, price, stockLevel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("productId");
                String name = rs.getString("ProductName");
                String description = rs.getString("Description");
                String category = rs.getString("Category");
                double price = rs.getDouble("Price");
                int stockLevel = rs.getInt("stockLevel");
                products.add(new Product(id, name, description, category, price, stockLevel));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean deleteProduct(int productId) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            preparedStatement.setInt(1, productId);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public boolean updateProduct(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getStockLevel());
            preparedStatement.setInt(6, product.getProductId());

            return preparedStatement.executeUpdate() > 0;
        }
    }
}
