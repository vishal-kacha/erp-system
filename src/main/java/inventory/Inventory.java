package inventory;
public class Inventory {

    private int itemId;
    private String itemName;
    private int quantity;
    private int availableQuantity;
    private int daysOfSupply;
    private String recentSalesTrend;
    private int minimumStockLevel;

    // Default constructor
    public Inventory() {
    }

    // Parameterized constructor
    public Inventory(int itemId, String itemName, int quantity, int availableQuantity, int daysOfSupply, String recentSalesTrend, int minimumStockLevel) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.availableQuantity = availableQuantity;
        this.daysOfSupply = daysOfSupply;
        this.recentSalesTrend = recentSalesTrend;
        this.minimumStockLevel = minimumStockLevel;
    }

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getDaysOfSupply() {
        return daysOfSupply;
    }

    public void setDaysOfSupply(int daysOfSupply) {
        this.daysOfSupply = daysOfSupply;
    }

    public String getRecentSalesTrend() {
        return recentSalesTrend;
    }

    public void setRecentSalesTrend(String recentSalesTrend) {
        this.recentSalesTrend = recentSalesTrend;
    }

    public int getMinimumStockLevel() {
        return minimumStockLevel;
    }

    public void setMinimumStockLevel(int minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }

    // Optionally, override toString() method for better readability
    @Override
    public String toString() {
        return "Inventory{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", availableQuantity=" + availableQuantity +
                ", daysOfSupply=" + daysOfSupply +
                ", recentSalesTrend='" + recentSalesTrend + '\'' +
                ", minimumStockLevel=" + minimumStockLevel +
                '}';
    }
}
