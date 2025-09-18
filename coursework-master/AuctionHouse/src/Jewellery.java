// Jewellery Class extending Collectible
public class Jewellery extends Collectible {
    private String material;   // E.g., "gold", "silver"
    private String gemType;    // E.g., "diamond", "ruby", or "none"

    // Constructor for Jewellery, calling Collectible's constructor
    public Jewellery(String title, int lowYearEstimate, int highYearEstimate, String owner,
                     String condition, double startingPrice, String uniqueIdentifier,
                     String material, String gemType) {
        // Pass parameters to Collectible's constructor
        super(title, lowYearEstimate, highYearEstimate, owner, condition, startingPrice, uniqueIdentifier);
        this.material = material; // Set material
        this.gemType = gemType;   // Set gem type
    }

    // Implement the abstract method from Collectible class
    @Override
    public String getUniqueDetails() {
        return "Material: " + material + ", Gem Type: " + gemType;
    }

    // Getters and Setters for Jewelry-specific fields

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getGemType() {
        return gemType;
    }

    public void setGemType(String gemType) {
        this.gemType = gemType;
    }


    // Method to provide a brief description of the jewellery
    @Override
    public String getShortDescriptor() {
        return "Jewellery (" + material + ", Gem: " + gemType + ")";
    }

    // Removed @Override from getCondition, assuming no new functionality added
    public String getCondition() {
        return super.getCondition();
    }

    // Method to display detailed information about the jewellery
    public void displayDetails() {
        System.out.println("Jewellery details: Title - " + getTitle() +
                ", Material - " + material +
                ", Gem - " + gemType +
                ", Year Estimate - " + getYearEstimate() +
                ", Condition - " + getCondition() +
                ", Starting Price - AED " + getStartingPrice() +
                ", Owner - " + getOwner() +
                ", ID - " + getUniqueIdentifier());
    }

    // Method to return a detailed description of the jewellery
    public String getDescription() {
        return "Jewellery: " + getTitle() +
                ", Material: " + material +
                ", Gem: " + gemType +
                ", Year Estimate: " + getYearEstimate() +
                ", Condition: " + getCondition() +
                ", Starting Price: AED " + getStartingPrice() +
                ", Owner: " + getOwner();
    }
    @Override
    public String getDetails() {
        return getDefaultDetails() + "\n" +  // Get the common details from Collectible
                "Jewellery details: Title - " + getTitle() +
                ", Material - " + material +
                ", Gem - " + gemType +
                ", Year Estimate - " + getYearEstimate() +
                ", Condition - " + getCondition() +
                ", Starting Price - AED " + getStartingPrice() +
                ", Owner - " + getOwner() +
                ", ID - " + getUniqueIdentifier();
    }
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%.2f,%s,%d,%d,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                "Jewelry",                                        // 1. Type
                title != null ? title : "Unknown Title",          // 2. Title
                owner != null ? owner : "Unknown Owner",          // 3. Owner
                condition != null ? condition : "Unknown Condition", // 4. Condition
                startingPrice,                                    // 5. Starting Price
                uniqueIdentifier != null ? uniqueIdentifier : "Unknown ID", // 6. Unique ID
                yearEstimate != null ? yearEstimate.getLowYearEstimate() : 0, // 7. Low Year Estimate
                yearEstimate != null ? yearEstimate.getHighYearEstimate() : 0, // 8. High Year Estimate
                material != null ? material : "Unknown Material", // 9. Material
                gemType != null ? gemType : "Unknown Gem Type",    // 10. Gem Type
                "",                                                // 11. Make (not applicable)
                "",                                                // 12. Model (not applicable)
                "",                                                // 13. Style (not applicable)
                "",                                                // 14. Width (not applicable)
                "",                                                // 15. Height (not applicable)
                "",                                                // 16. Author (not applicable)
                "",                                                // 17. Edition (not applicable)
                "",                                                // 18. Genre (not applicable)
                "");                                               // 19. Service History (not applicable)
    }


}


