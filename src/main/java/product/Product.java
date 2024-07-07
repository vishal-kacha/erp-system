package product;
public class Product {
    private int productId;
    private String productName;
    private String description;
    private String category;
    private double price;
    private int stockLevel;

    // Default constructor
    public Product() {
    }

    public Product(String productName, String description, String category, double price, int stockLevel) {
		this.productName = productName;
		this.description = description;
		this.category = category;
		this.price = price;
		this.stockLevel = stockLevel;
	}

	// Parameterized constructor
    public Product(int productId, String productName, String description, String category, double price, int stockLevel) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stockLevel = stockLevel;
    }

    // Getter and setter methods


	public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stockLevel=" + stockLevel +
                '}';
    }
}
