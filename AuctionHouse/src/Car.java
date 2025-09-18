// Car Class extending Collectible
public class Car extends Collectible {
    private String make;         // E.g., "Ford", "Chevrolet"
    private String model;        // E.g., "Mustang", "Camaro"
    private String serviceHistory; // Service history records
    private YearEstimate yearEstimate; // Year estimate with low, high, and middle values

    // Constructor for Car, calling Collectible's constructor
    public Car(String title, int lowYearEstimate, int highYearEstimate, String owner,
               String condition, double startingPrice, String uniqueIdentifier,
               String make, String model, String serviceHistory) {

        // Initialize the Collectible attributes
        super(title, lowYearEstimate, highYearEstimate, owner, condition, startingPrice, uniqueIdentifier);

        // Initialize Car-specific attributes
        this.make = make;
        this.model = model;
        this.serviceHistory = serviceHistory;

        // Initialize the year estimate using low and high estimates
        this.yearEstimate = new YearEstimate(lowYearEstimate, highYearEstimate);
    }

    // Implement the abstract method from Collectible class
    @Override
    public String getUniqueDetails() {
        return "Make: " + make + ", Model: " + model + ", Service History: " + serviceHistory;
    }

    // Getter and Setter for year estimate
    public YearEstimate getYearEstimate() {
        return yearEstimate;
    }

    public void setYearEstimate(YearEstimate yearEstimate) {
        this.yearEstimate = yearEstimate;
    }

    // Getters and Setters for Car-specific fields
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(String serviceHistory) {
        this.serviceHistory = serviceHistory;
    }


    // Overridden method to provide a brief description
    @Override
    public String getShortDescriptor() {
        return "Car (" + make + " " + model + ", Service: " + serviceHistory + ")";
    }

    // Overridden method to display detailed information about the car
    @Override
    public void displayDetails() {
        System.out.println("Car details: Title - " + getTitle() +
                ", Make - " + make +
                ", Model - " + model +
                ", Year Estimate - " + yearEstimate +
                ", Condition - " + getCondition() +
                ", Starting Price - AED " + getStartingPrice() +
                ", Owner - " + getOwner() +
                ", Service History - " + serviceHistory);
    }

    // Removed @Override from getCondition, as it’s not adding new functionality
    public String getCondition() {
        return super.getCondition();
    }

    // Removed @Override from getDescription, assuming it’s not defined in Collectible
    public String getDescription() {
        return "Car: " + getTitle() +
                ", Make: " + make +
                ", Model: " + model +
                ", Year Estimate: " + yearEstimate +
                ", Service History: " + serviceHistory;
    }

    @Override
    public String getDetails() {
        return getDefaultDetails() + "\n" +
                "Car details: Title - " + getTitle() +
                ", Make - " + make +
                ", Model - " + model +
                ", Year Estimate - " + yearEstimate +
                ", Condition - " + getCondition() +
                ", Starting Price - AED " + getStartingPrice() +
                ", Owner - " + getOwner() +
                ", Service History - " + serviceHistory;


    }
    // Override the toCSV method for the Car class
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%.2f,%s,%d,%d,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                "Car",                                            // 1. Type
                getTitle() != null ? getTitle() : "Unknown Title", // 2. Title
                getOwner() != null ? getOwner() : "Unknown Owner", // 3. Owner
                getCondition() != null ? getCondition() : "Unknown Condition", // 4. Condition
                getStartingPrice(),                              // 5. Starting Price
                getUniqueIdentifier() != null ? getUniqueIdentifier() : "Unknown ID", // 6. Unique ID
                getYearEstimate() != null ? getYearEstimate().getLowYearEstimate() : 0, // 7. Low Year Estimate
                getYearEstimate() != null ? getYearEstimate().getHighYearEstimate() : 0, // 8. High Year Estimate
                "", "",                                          // 9-10. Material, GemType (not applicable)
                make != null ? make : "Unknown Make",             // 11. Make
                model != null ? model : "Unknown Model",          // 12. Model
                "", "", "",                                      // 13-15. Style, Width, Height (not applicable)
                "", "", "",                                      // 16-18. Author, Edition, Genre (not applicable)
                serviceHistory != null ? serviceHistory : "No Service History" // 19. Service History
        );
    }




}

