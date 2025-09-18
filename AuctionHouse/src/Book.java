// Book Class extending Collectible
public class Book extends Collectible {
    private String author;
    private String edition;
    private String genre;

    // Constructor for Book with updated parameters, including low and high year estimates
    public Book(String title,
                int lowYearEstimate,
                int highYearEstimate,
                String owner,
                String condition,
                double startingPrice,
                String uniqueIdentifier,
                String author,
                String edition,
                String genre) {

        // Call to Collectible's constructor with low and high year estimates
        super(title, lowYearEstimate, highYearEstimate, owner, condition, startingPrice, uniqueIdentifier);

        // Initializing Book-specific attributes
        this.author = author;
        this.edition = edition;
        this.genre = genre;
    }

    // Implement the abstract method from Collectible class
    @Override
    public String getUniqueDetails() {
        return "Author: " + author + ", Edition: " + edition + ", Genre: " + genre;
    }

    // Getter and Setter methods for Book-specific fields
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Method to retrieve the condition, inherited from Collectible
    @Override
    public String getCondition() {
        return super.getCondition();
    }

    // Override the toString method to include the year estimate and more readable formatting
    //@Override
    //public String toString() {
        //return getTitle() + " by " + author + " (" + edition + "), Genre: " + genre +
                //"\nYear Estimate: " + getYearEstimate() +
                //"\nCondition: " + getCondition() +
                //"\nStarting Price: AED " + getStartingPrice() +
                //"\nOwner: " + getOwner() +
                //"\nID: " + getUniqueIdentifier();


    // Override the displayDetails method to display the year estimate details
    @Override
    public void displayDetails() {
        System.out.println("Book details: ");
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Genre: " + getGenre());
        System.out.println("Edition: " + getEdition());
        System.out.println("Year Estimate: " + getYearEstimate());
        System.out.println("Condition: " + getCondition());
        System.out.println("Starting Price: AED " + getStartingPrice());
        System.out.println("Owner: " + getOwner());
        System.out.println("ID: " + getUniqueIdentifier());
    }
    // New method: Override getShortDescriptor for a brief description of the Book
    @Override
    public String getShortDescriptor() {
        return "Book: " + getTitle() + " by " + author;  // Short description
    }
    // Override the getDescription method to provide a full description of the book
    //@Override
    //public String getDescription() {
        //return super.getDescription() +
                //", Author: " + author +
                //", Edition: " + edition +
                //", Genre: " + genre;
    //}

    @Override
    public String getDetails() {
        return getDefaultDetails() + "\n" +
                "Author: " + author + "\n" +
                "Edition: " + edition + "\n" +
                "Genre: " + genre + "\n" +
                "Starting Price: AED " + startingPrice + "\n" +
                "Owner: " + owner;
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%.2f,%s,%d,%d,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                "Book",                                          // 1. Type
                title != null ? title : "Unknown Title",         // 2. Title
                owner != null ? owner : "Unknown Owner",         // 3. Owner
                condition != null ? condition : "Unknown Condition", // 4. Condition
                startingPrice,                                   // 5. Starting Price
                uniqueIdentifier != null ? uniqueIdentifier : "Unknown ID", // 6. Unique ID
                yearEstimate != null ? yearEstimate.getLowYearEstimate() : 0, // 7. Low Year Estimate
                yearEstimate != null ? yearEstimate.getHighYearEstimate() : 0, // 8. High Year Estimate
                "",                                              // 9. Material (not applicable)
                "",                                              // 10. GemType (not applicable)
                "",                                              // 11. Make (not applicable)
                "",                                              // 12. Model (not applicable)
                "",                                              // 13. Style (not applicable)
                "",                                              // 14. Width (not applicable)
                "",                                              // 15. Height (not applicable)
                author != null ? author : "Unknown Author",      // 16. Author
                edition != null ? edition : "Unknown Edition",   // 17. Edition
                genre != null ? genre : "Unknown Genre",         // 18. Genre
                "");                                             // 19. ServiceHistory (not applicable)
    }



}
