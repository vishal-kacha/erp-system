package sales;
public class Sales {
    private int salesID;
    private String salespersonName;
    private int target;
    private int numberOfUnits;
    private int numberOfUnitsSold;
    private String completionStatus;

    // Constructors
    public Sales() {
    }

    public Sales(String salespersonName, int target, int numberOfUnits, int numberOfUnitsSold, String completionStatus) {
        this.salespersonName = salespersonName;
        this.target = target;
        this.numberOfUnits = numberOfUnits;
        this.numberOfUnitsSold = numberOfUnitsSold;
        this.completionStatus = completionStatus;
    }
    public Sales(int salesid, String salespersonName, int target, int numberOfUnits, int numberOfUnitsSold, String completionStatus) {
    	this.salesID = salesid;
        this.salespersonName = salespersonName;
        this.target = target;
        this.numberOfUnits = numberOfUnits;
        this.numberOfUnitsSold = numberOfUnitsSold;
        this.completionStatus = completionStatus;
    }

    // Getters and Setters
    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }

    public String getSalespersonName() {
        return salespersonName;
    }

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public int getNumberOfUnitsSold() {
        return numberOfUnitsSold;
    }

    public void setNumberOfUnitsSold(int numberOfUnitsSold) {
        this.numberOfUnitsSold = numberOfUnitsSold;
    }

    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        this.completionStatus = completionStatus;
    }

    // toString() method for debugging or logging
    @Override
    public String toString() {
        return "Sales{" +
                "salesID=" + salesID +
                ", salespersonName='" + salespersonName + '\'' +
                ", target=" + target +
                ", numberOfUnits=" + numberOfUnits +
                ", numberOfUnitsSold=" + numberOfUnitsSold +
                ", completionStatus='" + completionStatus + '\'' +
                '}';
    }
}
