public abstract class Collectible {

    protected String title;
    protected YearEstimate yearEstimate;
    protected String owner;
    protected String condition;
    protected double startingPrice;
    protected String uniqueIdentifier;

    // Constructor
    public Collectible(String title, int lowYearEstimate, int highYearEstimate, String owner,
                       String condition, double startingPrice, String uniqueIdentifier) {
        // Ensure required fields are not null
        if (title == null || owner == null || uniqueIdentifier == null) {
            throw new IllegalArgumentException("Title, owner, and unique identifier cannot be null.");
        }
        this.title = title;
        this.owner = owner;
        this.condition = condition != null ? condition : "Unknown Condition";
        this.startingPrice = Math.max(startingPrice, 0); // Ensure non-negative price
        this.uniqueIdentifier = uniqueIdentifier;
        this.yearEstimate = new YearEstimate(lowYearEstimate, highYearEstimate);
    }

    // Getters and Setters
    public YearEstimate getYearEstimate() {
        return yearEstimate;
    }

    public void updateYearEstimate(int lowYear, int highYear) {
        if (this.yearEstimate == null) {
            this.yearEstimate = new YearEstimate(lowYear, highYear);
        } else {
            this.yearEstimate.setLowYearEstimate(lowYear);
            this.yearEstimate.setHighYearEstimate(highYear);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner cannot be null or empty.");
        }
        this.owner = owner;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        if (condition == null || condition.trim().isEmpty()) {
            throw new IllegalArgumentException("Condition cannot be null or empty.");
        }
        this.condition = condition;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        if (startingPrice < 0) {
            throw new IllegalArgumentException("Starting price cannot be negative.");
        }
        this.startingPrice = startingPrice;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        if (uniqueIdentifier == null || uniqueIdentifier.trim().isEmpty()) {
            throw new IllegalArgumentException("Unique identifier cannot be null or empty.");
        }
        this.uniqueIdentifier = uniqueIdentifier;
    }

    // Descriptive Methods
    public String getDescription() {
        if (yearEstimate == null) {
            return String.format("%s (Year Estimate: Unknown Year, Owner: %s, Condition: %s, Starting Price: AED %.2f, ID: %s)",
                    title, owner, condition, startingPrice, uniqueIdentifier);
        }
        return String.format("%s (Year Estimate: %d - %d, Owner: %s, Condition: %s, Starting Price: AED %.2f, ID: %s)",
                title, yearEstimate.getLowYearEstimate(), yearEstimate.getHighYearEstimate(), owner, condition, startingPrice, uniqueIdentifier);
    }

    public String getShortDescriptor() {
        return yearEstimate == null
                ? String.format("%s (Unknown Year) - Owned by %s", title, owner)
                : String.format("%s (%d) - Owned by %s", title, yearEstimate.getMiddleYearEstimate(), owner);
    }

    @Override
    public String toString() {
        return getShortDescriptor();
    }
    public String getDefaultDetails() {
        return String.format(
                "Title: %s\nYear Estimate: %s\nCondition: %s\nStarting Price: AED %.2f\nOwner: %s\nID: %s",
                title != null ? title : "Unknown Title",
                yearEstimate != null ? (yearEstimate.getLowYearEstimate() + " - " + yearEstimate.getHighYearEstimate()) : "Unknown Year",
                condition != null ? condition : "Unknown Condition",
                startingPrice,
                owner != null ? owner : "Unknown Owner",
                uniqueIdentifier != null ? uniqueIdentifier : "Unknown ID"
        );
    }


    // Abstract Methods to be Implemented by Subclasses
    public abstract void displayDetails();

    public abstract String getDetails();

    public abstract String getUniqueDetails();

    // Default CSV Implementation (Can Be Overridden by Subclasses)
    public String toCSV() {
        System.out.println("Base Collectible toCSV() method called. Ensure this is intentional.");
        return String.format("%s,%s,%s,%s,%.2f,%s,%d,%d,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                "Base",                                      // Type
                title != null ? title : "Unknown Title",     // Title
                owner != null ? owner : "Unknown Owner",     // Owner
                condition != null ? condition : "Unknown Condition", // Condition
                startingPrice,                               // Starting Price
                uniqueIdentifier != null ? uniqueIdentifier : "Unknown ID", // Unique ID
                yearEstimate != null ? yearEstimate.getLowYearEstimate() : 0, // Low Year Estimate
                yearEstimate != null ? yearEstimate.getHighYearEstimate() : 0, // High Year Estimate
                "", "",                                      // Material, GemType (not applicable)
                "", "",                                      // Make, Model (not applicable)
                "", "",                                      // Style, Width, Height (not applicable)
                "", "", "",                                  // Author, Edition, Genre (not applicable)
                "");                                         // Service History (not applicable)
    }
}
