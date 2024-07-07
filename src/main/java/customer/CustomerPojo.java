package customer;
public class CustomerPojo {
    private int customerId;
    private String customerName;
    private double totalLifetimeValue;
    private double averageOrderValue;
    private String customerSegment;

    // Default constructor
    public CustomerPojo() {
    }

    public CustomerPojo(int userId, String customerName, double totalLifetimeValue, double averageOrderValue, String customerSegment) {
        this.customerId = userId;
        this.customerName = customerName;
        this.totalLifetimeValue = totalLifetimeValue;
        this.averageOrderValue = averageOrderValue;
        this.customerSegment = customerSegment;
    }



	// Getter and Setter methods
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalLifetimeValue() {
        return totalLifetimeValue;
    }

    public void setTotalLifetimeValue(double totalLifetimeValue) {
        this.totalLifetimeValue = totalLifetimeValue;
    }

    public double getAverageOrderValue() {
        return averageOrderValue;
    }

    public void setAverageOrderValue(double averageOrderValue) {
        this.averageOrderValue = averageOrderValue;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }
}
