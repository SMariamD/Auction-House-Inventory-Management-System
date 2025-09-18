// Painting Class extending Collectible
public class Painting extends Collectible {
    private String artist;    // Artist's name
    private String style;     // Art style, e.g., "Impressionism"
    private double width;     // Width in cm
    private double height;    // Height in cm

    // Constructor for Painting, calling Collectible's constructor with low and high year estimates
    public Painting(String title, int lowYearEstimate, int highYearEstimate, String owner,
                    String condition, double startingPrice, String uniqueIdentifier,
                    String artist, String style, double width, double height) {
        // Pass low and high year estimates to Collectible's constructor
        super(title, lowYearEstimate, highYearEstimate, owner, condition, startingPrice, uniqueIdentifier);
        this.artist = artist;
        this.style = style;
        this.width = width;
        this.height = height;
    }

    // Implement the abstract method from Collectible class
    @Override
    public String getUniqueDetails() {
        return "Artist: " + artist + ", Style: " + style + ", Width: " + width + "cm, Height: " + height + "cm";
    }
    // Getters and Setters for Painting-specific fields
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Method to provide a brief description of the painting
    @Override
    public String getShortDescriptor() {
        return "Painting: " + title + " by " + artist + uniqueIdentifier;
    }


    // Removed @Override from getCondition since it does not change the superclass's implementation
    public String getCondition() {
        return super.getCondition();
    }

    // Method to display detailed information about the painting
    public void displayDetails() {
        System.out.println("Painting details: Title - " + getTitle() +
                ", Artist - " + artist +
                ", Style - " + style +
                ", Dimensions - " + width + "x" + height + " cm" +
                ", Year Estimate - " + getYearEstimate() +
                ", Condition - " + getCondition() +
                ", Starting Price - AED " + getStartingPrice() +
                ", Owner - " + getOwner() +
                ", ID - " + getUniqueIdentifier());
    }

    // Method to return a detailed description of the painting
    public String getDescription() {
        return super.getDescription() +
                ", Artist: " + artist +
                ", Style: " + style +
                ", Dimensions: " + width + "x" + height + " cm";
    }

    @Override
    public String getDetails() {
        return getDefaultDetails() + "\n" +  // Get the common details from Collectible
                "Painting details: Title - " + getTitle() +
                ", Artist - " + artist +
                ", Style - " + style +
                ", Dimensions - " + width + "x" + height + " cm" +
                ", Year Estimate - " + getYearEstimate() +
                ", Condition - " + getCondition() +
                ", Starting Price - AED " + getStartingPrice() +
                ", Owner - " + getOwner() +
                ", ID - " + getUniqueIdentifier();
    }
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%.2f,%s,%d,%d,%s,%s,%s,%s,%s,%.2f,%.2f,%s,%s,%s,%s",
                "Painting",                                      // 1. Type
                getTitle() != null ? getTitle() : "Unknown Title", // 2. Title
                getOwner() != null ? getOwner() : "Unknown Owner", // 3. Owner
                getCondition() != null ? getCondition() : "Unknown Condition", // 4. Condition
                getStartingPrice(),                              // 5. Starting Price
                getUniqueIdentifier() != null ? getUniqueIdentifier() : "Unknown ID", // 6. Unique ID
                getYearEstimate() != null ? getYearEstimate().getLowYearEstimate() : 0, // 7. Low Year Estimate
                getYearEstimate() != null ? getYearEstimate().getHighYearEstimate() : 0, // 8. High Year Estimate
                "",                                              // 9. Material (not applicable)
                "",                                              // 10. GemType (not applicable)
                "",                                              // 11. Make (not applicable)
                "",                                              // 12. Model (not applicable)
                style != null ? style : "Unknown Style",         // 13. Style
                width,                                           // 14. Width
                height,                                          // 15. Height
                artist != null ? artist : "Unknown Artist",      // 16. Author (Artist for Painting)
                "",                                              // 17. Edition (not applicable)
                "",                                              // 18. Genre (not applicable)
                "");                                             // 19. ServiceHistory (not applicable)
    }


}

