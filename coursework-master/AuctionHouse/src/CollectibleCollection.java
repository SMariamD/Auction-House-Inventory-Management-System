import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.io.FileWriter;
import java.util.Map;
import java.io.BufferedWriter;
import java.util.HashSet;
import java.util.Set;

    public class CollectibleCollection {
        private List<Collectible> collectibles;

        public CollectibleCollection() {
            collectibles = new ArrayList<>();
        }

        // Method to read collectibles from CSV file
        /*public void readCollectiblesFromCSV(String filename) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                // Skip the header row
                String header = br.readLine();
                if (header == null) {
                    throw new IOException("File is empty or missing header row.");
                }

                String line;
                int lineNumber = 1;

                while ((line = br.readLine()) != null) {
                    lineNumber++; // Increment line number

                    // Skip blank or empty lines
                    if (line.trim().isEmpty()) {
                        continue;
                    }

                    // Split line by comma, and use trim to clean up any excess spaces
                    String[] data = line.split(",", -1); // Use -1 to keep trailing empty fields
                    for (int i = 0; i < data.length; i++) {
                        data[i] = data[i].trim(); // Clean spaces from each field
                    }

                    boolean hasError = false;
                    StringBuilder errorMessages = new StringBuilder();

                    // Check if data has at least 8 elements before accessing requiredFields
                    if (data.length < 8) { // Minimum fields required for all collectibles
                        errorMessages.append("Insufficient data fields; ");
                        hasError = true;
                    } else {
                        // Common fields for all collectibles
                        String[] requiredFields = { data[1], data[2], data[3], data[4], data[5], data[6], data[7] };
                        String[] fieldNames = { "Title", "Owner", "Condition", "Starting Price", "Unique ID", "Low Year Estimate", "High Year Estimate" };

                        for (int i = 0; i < requiredFields.length; i++) {
                            if (requiredFields[i].isEmpty()) {
                                errorMessages.append("Missing " + fieldNames[i] + "; ");
                                hasError = true;
                            }
                        }

                        // Validate numeric values for price and year estimates
                        if (!isValidNumber(data[4], false)) {
                            errorMessages.append("Invalid starting price format; ");
                            hasError = true;
                        }
                        if (!isValidNumber(data[6], true)) {
                            errorMessages.append("Invalid low year estimate format; ");
                            hasError = true;
                        }
                        if (!isValidNumber(data[7], true)) {
                            errorMessages.append("Invalid high year estimate format; ");
                            hasError = true;
                        }
                    }

                    // Type-specific field validation based on collectible type
                    String type = data[0].toLowerCase(); // Get the type (Book, Car, Painting, Jewelry)
                    switch (type) {
                        case "book":
                            // Ensure data length for book-specific fields
                            if (data.length < 18 || data[15].isEmpty()) {
                                errorMessages.append("Missing author; ");
                                hasError = true;
                            }
                            if (data.length < 18 || data[16].isEmpty()) {
                                errorMessages.append("Missing edition; ");
                                hasError = true;
                            }
                            if (data.length < 18 || data[17].isEmpty()) {
                                errorMessages.append("Missing genre; ");
                                hasError = true;
                            }
                            break;

                        case "car":
                            // Ensure data length for car-specific fields
                            if (data.length < 13) {  // For car, there must be at least 13 fields (including make, model, and service history)
                                errorMessages.append("Missing fields for car; ");
                                hasError = true;
                            }

                            // Check for missing make (index 10)
                            if (data.length > 10 && data[10].isEmpty()) { // Make is at index 10
                                errorMessages.append("Missing make; ");
                                hasError = true;
                            }

                            // Check for missing model (index 11)
                            if (data.length > 11 && data[11].isEmpty()) { // Model is at index 11
                                errorMessages.append("Missing model; ");
                                hasError = true;
                            }
// Check for missing service history (index 18)
                            if (data.length > 18 && data[18].isEmpty()) {
                                errorMessages.append("Missing service history; ");
                                hasError = true;
                            }

                            break;



                        case "painting":
                            // Ensure data length for painting-specific fields
                            if (data.length < 15 || data[13].isEmpty()) {
                                errorMessages.append("Missing width; ");
                                hasError = true;
                            }
                            if (data.length < 15 || data[14].isEmpty()) {
                                errorMessages.append("Missing height; ");
                                hasError = true;
                            }
                            break;

                        case "jewellery":
                            // Trim extra empty fields
                            while (data.length > 10 && data[data.length - 1].isEmpty()) {
                                data = Arrays.copyOf(data, data.length - 1);
                            }
                            // Ensure data length for jewelry-specific fields
                            if (data.length < 9 || data[8].isEmpty()) {
                                errorMessages.append("Missing material; ");
                                hasError = true;
                            }
                            if (data.length < 10 || data[9].isEmpty()) {
                                errorMessages.append("Missing gem type; ");
                                hasError = true;
                            }
                            break;

                        default:
                            errorMessages.append("Invalid collectible type: ").append(data[0]).append("; Expected types: book, car, painting, jewelry; ");
                            hasError = true;
                            break;
                    }

                    if (hasError) {
                        // Output the error message
                        System.out.println("Error with line " + lineNumber + ": " + line);
                        System.out.println("Issues: " + errorMessages.toString());
                        continue; // Skip this line and move to the next
                    }

                    // Process and add valid collectible
                    Collectible collectible = createCollectibleFromCSV(data);
                    if (collectible != null) {
                        collectibles.add(collectible); // Add valid collectible to the list
                    }
                }
            } catch (IOException e) {
                // Handle exception here, such as logging or rethrowing it
                System.err.println("Error reading file: " + e.getMessage());
                e.printStackTrace(); // Or log it as needed
            }
        }
        /
         */

        // Method to read collectibles from CSV file
        public void readCollectiblesFromCSV(String filename) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                // Skip the header row
                String header = br.readLine();
                if (header == null) {
                    throw new IOException("File is empty or missing header row.");
                }
                System.out.println("Header row: " + header); // Debug: Display header row

                String line;
                int lineNumber = 1;

                while ((line = br.readLine()) != null) {
                    lineNumber++; // Increment line number

                    // Skip blank or empty lines
                    if (line.trim().isEmpty()) {
                        System.out.println("Skipping blank line at line number: " + lineNumber); // Debug
                        continue;
                    }

                    System.out.println("Processing line " + lineNumber + ": " + line); // Debug: Display raw line

                    // Split line by comma, and use trim to clean up any excess spaces
                    String[] data = line.split(",", -1); // Use -1 to keep trailing empty fields
                    for (int i = 0; i < data.length; i++) {
                        data[i] = data[i].trim(); // Clean spaces from each field
                    }

                    // Debug: Display cleaned data
                    System.out.println("Cleaned data for line " + lineNumber + ": " + Arrays.toString(data));

                    boolean hasError = false;
                    StringBuilder errorMessages = new StringBuilder();

                    // Check if data has at least 8 elements before accessing requiredFields
                    if (data.length < 8) { // Minimum fields required for all collectibles
                        errorMessages.append("Insufficient data fields; ");
                        hasError = true;
                    } else {
                        // Common fields for all collectibles
                        String[] requiredFields = {data[1], data[2], data[3], data[4], data[5], data[6], data[7]};
                        String[] fieldNames = {"Title", "Owner", "Condition", "Starting Price", "Unique ID", "Low Year Estimate", "High Year Estimate"};

                        for (int i = 0; i < requiredFields.length; i++) {
                            if (requiredFields[i].isEmpty()) {
                                errorMessages.append("Missing ").append(fieldNames[i]).append("; ");
                                hasError = true;
                            }
                        }

                        // Validate numeric values for price and year estimates
                        if (!isValidNumber(data[4], false)) {
                            errorMessages.append("Invalid starting price format; ");
                            hasError = true;
                        }
                        if (!isValidNumber(data[6], true)) {
                            errorMessages.append("Invalid low year estimate format; ");
                            hasError = true;
                        }
                        if (!isValidNumber(data[7], true)) {
                            errorMessages.append("Invalid high year estimate format; ");
                            hasError = true;
                        }
                    }

                    // Normalize and validate the collectible type
                    String type = data[0].trim().toLowerCase(); // Normalize type for case-insensitive matching
                    System.out.println("Detected type: " + type); // Debug: Display detected type

                    switch (type) {
                        case "book":
                            if (data.length < 18 || data[15].isEmpty()) {
                                errorMessages.append("Missing author; ");
                                hasError = true;
                            }
                            if (data.length < 18 || data[16].isEmpty()) {
                                errorMessages.append("Missing edition; ");
                                hasError = true;
                            }
                            if (data.length < 18 || data[17].isEmpty()) {
                                errorMessages.append("Missing genre; ");
                                hasError = true;
                            }
                            break;

                        case "car":
                            if (data.length < 13) {
                                errorMessages.append("Missing fields for car; ");
                                hasError = true;
                            }
                            if (data.length > 10 && data[10].isEmpty()) {
                                errorMessages.append("Missing make; ");
                                hasError = true;
                            }
                            if (data.length > 11 && data[11].isEmpty()) {
                                errorMessages.append("Missing model; ");
                                hasError = true;
                            }
                            if (data.length > 18 && data[18].isEmpty()) {
                                errorMessages.append("Missing service history; ");
                                hasError = true;
                            }
                            break;

                        case "painting":
                            if (data.length < 15 || data[13].isEmpty()) {
                                errorMessages.append("Missing width; ");
                                hasError = true;
                            }
                            if (data.length < 15 || data[14].isEmpty()) {
                                errorMessages.append("Missing height; ");
                                hasError = true;
                            }
                            break;

                        case "jewelry": // Support both "jewellery" and "jewelry"
                        case "jewellery":
                            while (data.length > 10 && data[data.length - 1].isEmpty()) {
                                data = Arrays.copyOf(data, data.length - 1);
                            }
                            if (data.length < 9 || data[8].isEmpty()) {
                                errorMessages.append("Missing material; ");
                                hasError = true;
                            }
                            if (data.length < 10 || data[9].isEmpty()) {
                                errorMessages.append("Missing gem type; ");
                                hasError = true;
                            }
                            break;

                        default:
                            errorMessages.append("Invalid collectible type: ").append(data[0]).append("; Expected types: book, car, painting, jewelry; ");
                            hasError = true;
                            break;
                    }

                    if (hasError) {
                        System.out.println("Error with line " + lineNumber + ": " + line); // Debug: Log line with error
                        System.out.println("Issues: " + errorMessages.toString()); // Debug: Log issues
                        continue; // Skip this line and move to the next
                    }

                    // Process and add valid collectible
                    Collectible collectible = createCollectibleFromCSV(data);
                    if (collectible != null) {
                        collectibles.add(collectible);
                        System.out.println("Added collectible from line " + lineNumber + ": " + collectible); // Debug: Log added collectible
                    } else {
                        System.err.println("Failed to create collectible from valid line " + lineNumber + ": " + line);
                    }
                }

                System.out.println("Total collectibles loaded: " + collectibles.size()); // Debug: Log total loaded
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
                e.printStackTrace(); // Debug: Log stack trace
            }
        }
        // Getter method to access the list of collectibles
        public List<Collectible> getCollectibles() {
            return collectibles;
        }


        // Helper method to validate numeric values (prices or years)
        private boolean isValidNumber(String value, boolean isYear) {
            try {
                if (isYear) {
                    int year = Integer.parseInt(value);
                    return year >= 1000 && year <= 9999; // Example valid year range
                } else {
                    Double.parseDouble(value);
                    return true; // valid price format
                }
            } catch (NumberFormatException e) {
                return false; // Invalid number format
            }
        }


        // Method to create the appropriate Collectible based on the CSV data
                public Collectible createCollectibleFromCSV(String[] data) {
        // Check if the line is completely empty or only contains blank fields
        boolean allFieldsEmpty = Arrays.stream(data).allMatch(field -> field == null || field.trim().isEmpty());

        if (allFieldsEmpty) {
            // Skip printing for a fully empty line
            return null;
        }

        String type;
        try {
            // Attempt to extract and process the collectible type
            type = data[0].trim().toLowerCase(); // Trim whitespace and convert to lowercase
            System.out.println("Detected collectible type: " + type); // Debug output
        } catch (Exception e) {
            System.out.println("Error processing collectible type: " + Arrays.toString(data) + " - " + e.getMessage());
            return null; // Return null to skip this line if type extraction fails
        }

        int minimumFields;
        try {
            switch (type) {
                case "book":
                    minimumFields = 18;
                    if (data.length < minimumFields) {
                        System.out.println("Insufficient data for book: " + Arrays.toString(data));
                        return null;
                    }
                    return createBook(data);

                case "jewelry":
                case "jewellery":
                    minimumFields = 10;
                    if (data.length < minimumFields) {
                        System.out.println("Insufficient data for jewellery: " + Arrays.toString(data));
                        return null;
                    }
                    return createJewellery(data);

                case "car":
                    minimumFields = 11;
                    if (data.length < minimumFields) {
                        System.out.println("Insufficient data for car: " + Arrays.toString(data));
                        return null;
                    }
                    return createCar(data);

                case "painting":
                    minimumFields = 12;
                    if (data.length < minimumFields) {
                        System.out.println("Insufficient data for painting: " + Arrays.toString(data));
                        return null;
                    }
                    return createPainting(data);

                default:
                    System.out.println("Unknown collectible type: " + Arrays.toString(data));
                    return null; // Handle unknown type
            }
        } catch (Exception e) {
            // Catch unexpected errors during the creation of collectibles
            System.out.println("Error processing collectible data: " + Arrays.toString(data) + " - " + e.getMessage());
            return null; // Return null to skip this line if an error occurs
        }
    }

    // Custom method to parse a double with error handling
    private double parseDouble(String input, String fieldName) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing " + fieldName + ": " + input + " is not a valid number.");
            return 0.0; // Default value if parsing fails
        }
    }

    // Custom method to handle unexpected strings (optional)
    private boolean isUnexpectedString(String input, String fieldName) {
        // Implement validation for unexpected strings in critical fields
        // For example, check for empty or invalid values
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Invalid value for " + fieldName + ": " + input);
            return true;
        }
        return false;
    }

    // Helper method to create a book, only extracting the first 11 fields
    private Collectible createBook(String[] fields) {
        try {
            if (fields.length < 18) { // Ensure there are enough fields for processing
                System.out.println("Insufficient data for book: " + Arrays.toString(fields));
                return null;
            }

            String title = fields[1];
            String owner = fields[2];
            String condition = fields[3];
            double startingPrice = parseDouble(fields[4], "Starting Price");
            String uniqueIdentifier = fields[5];
            int lowYearEstimate = parseYear(fields[6]);
            int highYearEstimate = parseYear(fields[7]);
            String author = fields[15];
            String edition = fields[16];
            String genre = fields[17];

            // Check for unexpected strings in critical fields
            if (isUnexpectedString(title, "title") || isUnexpectedString(owner, "owner") ||
                    isUnexpectedString(condition, "condition") || isUnexpectedString(author, "author") ||
                    isUnexpectedString(edition, "edition") || isUnexpectedString(genre, "genre") ||
                    isUnexpectedString(uniqueIdentifier, "uniqueID")) {
                System.out.println("Unexpected string in fields for book: " + Arrays.toString(fields));
                return null;
            }

            // Return a new Book object if all checks are passed
            return new Book(title, lowYearEstimate, highYearEstimate, owner, condition,
                    startingPrice, uniqueIdentifier, author, edition, genre);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error parsing book: " + Arrays.toString(fields) + " - " + e.getMessage());
            return null;
        }
    }

    // Helper method to create jewellery
    private Collectible createJewellery(String[] fields) {
        try {
            if (fields.length < 10) {
                System.out.println("Insufficient data for jewellery: " + Arrays.toString(fields));
                return null;
            }

            String title = fields[1];
            String owner = fields[2];
            String condition = fields[3];
            double startingPrice = parseDouble(fields[4], "Starting Price");
            String uniqueIdentifier = fields[5];
            int lowYearEstimate = parseYear(fields[6]);
            int highYearEstimate = parseYear(fields[7]);
            String material = fields[8];
            String gemType = fields[9];

            // Check for unexpected strings in critical fields
            if (isUnexpectedString(title, "title") || isUnexpectedString(owner, "owner") ||
                    isUnexpectedString(condition, "condition") || isUnexpectedString(material, "material") ||
                    isUnexpectedString(gemType, "gemType") || isUnexpectedString(uniqueIdentifier, "uniqueID")) {
                System.out.println("Unexpected string in fields for jewellery: " + Arrays.toString(fields));
                return null;
            }

            return new Jewellery(title, lowYearEstimate, highYearEstimate, owner, condition,
                    startingPrice, uniqueIdentifier, material, gemType);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error parsing jewellery: " + Arrays.toString(fields));
            return null;
        }
    }

    // Helper method to create a Car object
    private Collectible createCar(String[] fields) {
        try {
            // Ensure there are enough fields for a car
            if (fields.length < 14) { // For car, there must be at least 14 fields (including make, model, and service history)
                System.out.println("Insufficient data for car: " + Arrays.toString(fields));
                return null;
            }

            // General fields
            String title = fields[1];
            String owner = fields[2];
            String condition = fields[3];
            double startingPrice = parseDouble(fields[4], "Starting Price");
            String uniqueIdentifier = fields[5];
            int lowYearEstimate = parseYear(fields[6]);
            int highYearEstimate = parseYear(fields[7]);

            // Handle car-specific fields (make, model, and service history)
            String make = fields.length > 10 && !fields[10].isEmpty() ? fields[10] : "Unknown";  // Make at index 10
            String model = fields.length > 11 && !fields[11].isEmpty() ? fields[11] : "Unknown";  // Model at index 11

            // Adjust serviceHistory to fetch the correct column index (service history at index 19)
            String serviceHistory = fields.length > 18 && !fields[18].isEmpty() ? fields[18] : "No Service History";

            // Validate fields
            if (make.isEmpty()) {
                System.out.println("Invalid value for make: " + make);
                return null;
            }

            if (model.isEmpty()) {
                System.out.println("Invalid value for model: " + model);
                return null;
            }

            // Default service history if missing
            if (serviceHistory.isEmpty()) {
                serviceHistory = "No Service History";  // Default value if missing
            }

            // Create and return the Car object
            return new Car(title, lowYearEstimate, highYearEstimate, owner, condition, startingPrice, uniqueIdentifier, make, model, serviceHistory);

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // Handle errors related to data format or indexing
            System.out.println("Error parsing car: " + Arrays.toString(fields));
            return null;
        }
    }


        // Helper method to create painting
    private Painting createPainting(String[] data) {
        // Ensure sufficient data length for painting fields
        if (data.length < 16) {
            throw new IllegalArgumentException("Insufficient data for painting: " + Arrays.toString(data));
        }

        // Extract essential fields
        String title = data[1];
        int lowYearEstimate = parseYear(data[6]);
        int highYearEstimate = parseYear(data[7]);
        String owner = data[2];
        String condition = data[3];
        double startingPrice = parsePrice(data[4]);
        String uniqueID = data[5];

        // Ensure that the artist and style are present
        String style = (data.length > 12 && !data[12].isEmpty()) ? data[12] : null;
        if (style == null) {
            throw new IllegalArgumentException("Style is missing for painting: " + title);
        }

        // Validate width and height presence
        double width;
        double height;

        if (data.length > 13 && !data[13].isEmpty()) {
            try {
                width = Double.parseDouble(data[13]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid width value for painting: " + title + " - " + data[13]);
            }
        } else {
            throw new IllegalArgumentException("Width is missing for painting: " + title);
        }

        if (data.length > 14 && !data[14].isEmpty()) {
            try {
                height = Double.parseDouble(data[14]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid height value for painting: " + title + " - " + data[14]);
            }
        } else {
            throw new IllegalArgumentException("Height is missing for painting: " + title);
        }

        // Ensure the artist (Author) is present
        String artist = null;
        if (data.length > 15 && !data[15].isEmpty()) {
            artist = data[15];
        } else {
            throw new IllegalArgumentException("Artist is missing for painting: " + title);
        }

        // Return a new Painting object
        return new Painting(title, lowYearEstimate, highYearEstimate, owner, condition, startingPrice, uniqueID,
                artist, style, width, height);
    }





    // Method to parse and validate the year
    public static int parseYear(String yearString) {
        if (yearString.isEmpty()) {
            return -1; // Return a placeholder for missing year
        }
        try {
            return Integer.parseInt(yearString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format: " + yearString);
            return -1; // Placeholder error value for invalid year
        }
    }

    // Method to parse and validate the starting price
    public static double parsePrice(String priceString) {
        if (priceString.isEmpty()) {
            return -1; // Return a placeholder for missing price
        }
        try {
            return Double.parseDouble(priceString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format: " + priceString); // Output the invalid price
            return -1; // Placeholder error value for invalid price
        }
    }


        // Method to parse and validate double values (for width and height)
    public static double parseDouble(String value) {
        if (value.isEmpty()) {
            return -1; // Return a placeholder for missing value
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            System.out.println("Invalid double format: " + value);
            return -1; // Placeholder error value for invalid double
        }
    }

    // Method to add a Collectible to the collection
    public void addCollectible(Collectible collectible) {
        collectibles.add(collectible);
    }

    public Collectible getOldestCollectible() {
        Collectible oldest = null;

        for (Collectible collectible : collectibles) {
            if (collectible.getYearEstimate().isValid()) {
                if (oldest == null || collectible.getYearEstimate().getLowYearEstimate() < oldest.getYearEstimate().getLowYearEstimate()) {
                    oldest = collectible;
                }
            }
        }

        return oldest;
    }

    public Collectible getNewestCollectible() {
        Collectible newest = null;

        for (Collectible collectible : collectibles) {
            if (collectible.getYearEstimate().isValid()) {
                if (newest == null || collectible.getYearEstimate().getHighYearEstimate() > newest.getYearEstimate().getHighYearEstimate()) {
                    newest = collectible;
                }
            }
        }

        return newest;
    }
        public Collectible getOldestCollectibleByMiddleEstimate() {
            Collectible oldest = null;

            for (Collectible collectible : collectibles) {
                if (collectible.getYearEstimate().isValid()) {
                    int middleYearEstimate = collectible.getYearEstimate().getMiddleYearEstimate();
                    if (oldest == null || middleYearEstimate < oldest.getYearEstimate().getMiddleYearEstimate()) {
                        oldest = collectible;
                    }
                }
            }

            return oldest;
        }

        public Collectible getNewestCollectibleByMiddleEstimate() {
            Collectible newest = null;

            for (Collectible collectible : collectibles) {
                if (collectible.getYearEstimate().isValid()) {
                    int middleYearEstimate = collectible.getYearEstimate().getMiddleYearEstimate();
                    if (newest == null || middleYearEstimate > newest.getYearEstimate().getMiddleYearEstimate()) {
                        newest = collectible;
                    }
                }
            }

            return newest;
        }

    public Collectible getMiddleEstimateCollectible() {
        Collectible middleEstimate = null;

        for (Collectible currentCollectible : collectibles) {
            if (currentCollectible.getYearEstimate().isValid()) {
                if (middleEstimate == null || currentCollectible.getYearEstimate().getMiddleYearEstimate() > middleEstimate.getYearEstimate().getMiddleYearEstimate()) {
                    middleEstimate = currentCollectible;
                }
            }
        }

        return middleEstimate;
    }

    // Method to get the items with the top 3 most difference in the years estimates.
    public List<Collectible> getTop3MostDifferent() {
        List<Collectible> top3 = new ArrayList<>();

        for (Collectible collectible : collectibles) {
            if (collectible.getYearEstimate().isValid()) {
                int difference = collectible.getYearEstimate().getYearDifference();

                // Add to top3 if less than 3 items or if this item has a larger difference
                if (top3.size() < 3) {
                    top3.add(collectible);
                } else {
                    // Find the collectible with the smallest difference in top3
                    int minIndex = 0;
                    for (int i = 1; i < top3.size(); i++) {
                        if (top3.get(i).getYearEstimate().getYearDifference() < top3.get(minIndex).getYearEstimate().getYearDifference()) {
                            minIndex = i;
                        }
                    }

                    // If the current collectible's difference is greater, replace the smallest in top3
                    if (difference > top3.get(minIndex).getYearEstimate().getYearDifference()) {
                        top3.set(minIndex, collectible);
                    }
                }
            }
        }

        return top3;
    }

    // Method to get the total number of items in the collection
    public int getNumberOfItems() {
        return collectibles.size(); // Returns the size of the collection
    }

    // Method to get the most expensive collectible (generic for all types)
    public Collectible getMostExpensiveCollectible() {
        Collectible mostExpensive = null;
        for (Collectible collectible : collectibles) {
            if (mostExpensive == null || collectible.getStartingPrice() > mostExpensive.getStartingPrice()) {
                mostExpensive = collectible;
            }
        }
        return mostExpensive;
    }

    // Method to get the least expensive collectible (generic for all types)
    public Collectible getLeastExpensiveCollectible() {
        Collectible leastExpensive = null;
        for (Collectible collectible : collectibles) {
            if (leastExpensive == null || collectible.getStartingPrice() < leastExpensive.getStartingPrice()) {
                leastExpensive = collectible;
            }
        }
        return leastExpensive;
    }

    // Method to get a list of all unique owners
    public List<String> getUniqueOwners() {
        List<String> uniqueOwners = new ArrayList<>();
        for (Collectible collectible : collectibles) {
            if (!uniqueOwners.contains(collectible.getOwner())) {
                uniqueOwners.add(collectible.getOwner());
            }
        }
        return uniqueOwners;
    }

    // Method to display all collectibles in the collection
    public void displayCollectibles() {
        for (Collectible collectible : collectibles) {
            System.out.println(collectible);
        }
    }

    // Helper method for short descriptors (can be adapted for all collectible types)
    //private String getShortDescriptor(Collectible collectible) {
    //return collectible.getTitle() + " (" + collectible.getYearEstimate() + ") - " + collectible.getUniqueIdentifier();
    //}

    // Method to calculate average starting price for all collectibles
    public double getAverageStartingPrice() {
        if (collectibles.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Collectible collectible : collectibles) {
            total += collectible.getStartingPrice();
        }
        return total / collectibles.size();
    }

        // Helper method to validate the condition (e.g., Mint, Good, Fair, etc.)
        private boolean isValidCondition(String condition) {
            // Define a list of valid conditions
            List<String> validConditions = Arrays.asList("Mint", "Good", "Fair", "Poor", "Restored", "Needs Restoring", "Excellent",
                    "New", "Used", "Damaged", "Very Good","Awesome");

            // Check if the condition is null or empty
            if (condition == null || condition.trim().isEmpty()) {
                System.err.println("Warning: Condition cannot be null or empty");
                return false; // Return false instead of throwing an exception
            }

            // Check if the provided condition is valid
            if (!validConditions.contains(condition)) {
                System.err.println("Warning: Invalid condition value: " + condition);
                return false; // Return false for invalid condition values
            }

            // Return true if the condition is in the list of valid conditions
            return true;
        }

        // Method to get breakdown by condition for all types of collectibles
        public Map<String, Integer> getConditionBreakdown() {
            Map<String, Integer> breakdown = new HashMap<>();
            for (Collectible collectible : collectibles) {
                String condition = collectible.getCondition();
                if (isValidCondition(condition)) { // Check if the condition is valid
                    breakdown.put(condition, breakdown.getOrDefault(condition, 0) + 1);
                } else {
                    System.err.println("Warning: Invalid condition '" + condition + "' for collectible: " + collectible);
                }
            }
            return breakdown;
        }


        // Method to calculate the standard deviation of starting prices for all collectibles
    public double getStartingPriceStandardDeviation() {
        if (collectibles.isEmpty()) {
            return 0;
        }
        double mean = getAverageStartingPrice(); // Calculate the mean
        double sumSquaredDeviations = 0;
        for (Collectible collectible : collectibles) {
            double deviation = collectible.getStartingPrice() - mean; // Calculate deviation from the mean
            sumSquaredDeviations += deviation * deviation; // Add squared deviation to the sum
        }
        return Math.sqrt(sumSquaredDeviations / collectibles.size()); // Return the standard deviation
    }

        public Collectible findByUniqueID(String uniqueID) {
            for (Collectible collectible : collectibles) {
                if (collectible.getUniqueIdentifier().equals(uniqueID)) {
                    return collectible;
                }
            }
            return null;
        }


        // Replace an existing collectible or update its fields, or add a new one
        public void replaceCollectible(Collectible updatedCollectible) {
            for (int i = 0; i < collectibles.size(); i++) {
                Collectible existingCollectible = collectibles.get(i);

                // Check if the collectible exists by comparing unique identifiers
                if (existingCollectible.getUniqueIdentifier().equals(updatedCollectible.getUniqueIdentifier())) {
                    // Update the fields of the existing collectible
                    existingCollectible.setTitle(updatedCollectible.getTitle());
                    existingCollectible.setOwner(updatedCollectible.getOwner());
                    existingCollectible.setCondition(updatedCollectible.getCondition());
                    existingCollectible.setStartingPrice(updatedCollectible.getStartingPrice());

                    // Update the year estimate using the new YearEstimate values
                    existingCollectible.updateYearEstimate(
                            updatedCollectible.getYearEstimate().getLowYearEstimate(),
                            updatedCollectible.getYearEstimate().getHighYearEstimate()
                    );

                    // You can add more updates for specific fields, depending on the type of collectible
                    return; // Exit after updating the collectible
                }
            }

            // If the collectible is not found, add it as a new one
            collectibles.add(updatedCollectible);
        }


        // Save the collection to a CSV file
            public void saveToCSV(String filePath) throws IOException {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    writer.write("Type,Title,Owner,Condition,StartingPrice,UniqueID,LowYearEstimate,HighYearEstimate,Material,GemType,Make,Model,Style,Width,Height,Author,Edition,Genre,ServiceHistory\n");
                    for (Collectible collectible : collectibles) {
                        writer.write(collectible.toCSV());
                        writer.newLine();
                    }
                }




        }



    public void writeStatisticsToFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Gather data for statistics
            Collectible oldestItem = getOldestCollectible();
            Collectible newestItem = getNewestCollectible();
            Collectible oldestByMiddleEstimate = getOldestCollectibleByMiddleEstimate();
            Collectible newestByMiddleEstimate = getNewestCollectibleByMiddleEstimate();
            Collectible mostExpensiveItem = getMostExpensiveCollectible();
            Collectible leastExpensiveItem = getLeastExpensiveCollectible();
            List<Collectible> topItems = getTop3MostDifferent();
            Map<String, Integer> conditionBreakdown = getConditionBreakdown();
            List<String> uniqueOwners = getUniqueOwners();

            // Write general statistics
            writer.write(String.format("Total items: %d%n", getNumberOfItems()));

            // Oldest and newest items with year estimates
            if (oldestItem != null) {
                writer.write(String.format("Oldest item: %s%n", oldestItem.getShortDescriptor()));
            }
            if (newestItem != null) {
                writer.write(String.format("Newest item: %s%n", newestItem.getShortDescriptor()));
            }

            // Items with the top 3 largest differences in year estimates
            writer.write("Top 3 items with the largest year estimate differences:\n");
            for (Collectible item : topItems) {
                int yearEstimateDifference = item.getYearEstimate().getHighYearEstimate() -
                        item.getYearEstimate().getLowYearEstimate();
                writer.write(String.format("%s (Year Estimate Difference: %d years)%n",
                        item.getShortDescriptor(), yearEstimateDifference));
            }
// Write statistics for oldest and newest based on middle year estimate
            if (oldestByMiddleEstimate != null) {
                writer.write(String.format("Oldest item by middle year estimate: %s%n", oldestByMiddleEstimate.getShortDescriptor()));
            }
            if (newestByMiddleEstimate != null) {
                writer.write(String.format("Newest item by middle year estimate: %s%n", newestByMiddleEstimate.getShortDescriptor()));
            }

            // Most and least expensive items
            if (mostExpensiveItem != null) {
                writer.write(String.format("Most expensive item: %s - AED %.2f%n",
                        mostExpensiveItem.getShortDescriptor(), mostExpensiveItem.getStartingPrice()));
            }
            if (leastExpensiveItem != null) {
                writer.write(String.format("Least expensive item: %s - AED %.2f%n",
                        leastExpensiveItem.getShortDescriptor(), leastExpensiveItem.getStartingPrice()));
            }

            // Average and standard deviation of starting prices
            writer.write(String.format("Avg price: AED %.2f%n", getAverageStartingPrice()));
            writer.write(String.format("Price Std Dev: %.2f%n", getStartingPriceStandardDeviation()));

            // Condition breakdown
            writer.write("Condition breakdown:\n");
            for (Map.Entry<String, Integer> entry : conditionBreakdown.entrySet()) {
                writer.write(String.format("%s: %d%n", entry.getKey(), entry.getValue()));
            }

            // Unique owners
            writer.write("Unique owners:\n");
            for (String owner : uniqueOwners) {
                writer.write(owner + "\n");
            }

            writer.flush(); // Ensure all data is written to the file
            System.out.println("Statistics successfully written to file: " + filePath);
        }
    }
}
    /*public void writeStatisticsToFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Collect the data once to avoid multiple method calls
            Collectible oldestItem = getOldestCollectible();
            Collectible newestItem = getNewestCollectible();
            Collectible mostExpensiveItem = getMostExpensiveCollectible();
            Collectible leastExpensiveItem = getLeastExpensiveCollectible();
            List<Collectible> topItems = getTop3MostDifferent();
            Map<String, Integer> conditionBreakdown = getConditionBreakdown();
            List<String> uniqueOwners = getUniqueOwners();

            // Write statistics in a concise format
            writer.write(String.format("Total items: %d\n", getNumberOfItems()));

            // Oldest and newest items using low and high estimates, and middle estimate
            writer.write(String.format("Oldest item: %s\n", getShortDescriptor(oldestItem)));
            writer.write(String.format("Newest item: %s\n", getShortDescriptor(newestItem)));


            // Items with the top 3 largest differences in year estimates
            writer.write("Top 3 items with the largest year estimate differences:\n");
            for (Collectible item : topItems) {
                int yearEstimateDifference = item.getYearEstimate().getHighYearEstimate() -
                        item.getYearEstimate().getLowYearEstimate();
                writer.write(String.format("%s (Year Estimate Difference: %d years)\n", getShortDescriptor(item), yearEstimateDifference));
            }

            // Most and least expensive items
            writer.write(String.format("Most expensive item: %s - AED %.2f\n",
                    getShortDescriptor(mostExpensiveItem), mostExpensiveItem.getStartingPrice()));
            writer.write(String.format("Least expensive item: %s - AED %.2f\n",
                    getShortDescriptor(leastExpensiveItem), leastExpensiveItem.getStartingPrice()));

            // Average and standard deviation of starting prices
            writer.write(String.format("Avg price: AED %.2f\n", getAverageStartingPrice()));
            writer.write(String.format("Price Std Dev: %.2f\n", getStartingPriceStandardDeviation()));

            // Breakdown by condition
            writer.write("Condition breakdown:\n");
            conditionBreakdown.forEach((condition, count) -> {
                try {
                    writer.write(String.format("%s: %d\n", condition, count));
                } catch (IOException e) {
                    System.err.println("Error writing condition breakdown: " + e.getMessage());
                }
            });

            // Unique owners
            writer.write("Unique owners:\n");
            uniqueOwners.forEach(owner -> {
                try {
                    writer.write(owner + "\n");
                } catch (IOException e) {
                    System.err.println("Error writing unique owner: " + e.getMessage());
                }
            });

            writer.flush(); // Ensure content is written to the file
            System.out.println("Statistics successfully written to file: " + filePath);
        }
    }

}



/*
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.io.FileWriter;
//import java.util.HashMap;
//import java.util.Map;

//public class BookCollection {
    // List to store Book objects
    //private List<Book> books;

    // Constructor
    public BookCollection() {
        this.books = new ArrayList<>();
    }

    // Method to read books from a CSV file
    public void readBooksFromCSV(String filename) {
        BufferedReader reader = null;
        int lineNum = 1;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            // Skip the header row (first line)
            reader.readLine(); // Read and discard the header line

            while ((line = reader.readLine()) != null) {
                try {
                    String[] attributes = line.split(",");
                    if (attributes.length < 9) {
                        System.err.println("Error: Missing fields on line " + lineNum);
                        continue; // Skip to next line
                    }
                    // Validate the condition before creating the Book object
                    String condition = attributes[6];
                    if (!isValidCondition(condition)) {
                        System.err.println("Error on line " + lineNum + ": Invalid condition value ('" + condition + "')");
                        lineNum++;
                        continue; // Skip invalid lines
                    }
                    // Parse year and price with error handling
                    int yearOfOrigin = parseYear(attributes[4], lineNum);
                    double startingPrice = parsePrice(attributes[7], lineNum);
                    String uniqueIdentifier = attributes[8];

                    if (!isValidUniqueIdentifier(uniqueIdentifier)) {
                        System.err.println("Error on line " + lineNum + ": Invalid unique identifier ('" + uniqueIdentifier + "')");
                        lineNum++;
                        continue; // Skip invalid lines
                    }

                    if (yearOfOrigin != -1 && startingPrice != -1) {
                        // Only create a Book if all fields are valid
                        Book book = new Book(
                                attributes[0], // Title
                                attributes[1], // Author
                                attributes[2], // Edition
                                attributes[3], // Genre
                                yearOfOrigin,  // Year of Origin (validated above)
                                attributes[5], // Owner
                                condition,     // Condition (validated above)
                                startingPrice, // Starting Price (validated above)
                                attributes[8]  // Unique Identifier
                        );
                        books.add(book); // Assuming 'books' is a List<Book> defined in the class
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error on line " + lineNum + ": Missing fields - " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Unexpected error on line " + lineNum + ": " + e.getMessage());
                }
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // Helper method to parse and validate year
    private int parseYear(String yearString, int lineNum) {
        if (yearString == null || yearString.isEmpty()) {
            System.err.println("Error on line " + lineNum + ": Missing year of origin");
            return -1;
        }
        try {
            return Integer.parseInt(yearString);
        } catch (NumberFormatException e) {
            System.err.println("Error on line " + lineNum + ": Invalid number format for year ('" + yearString + "')");
            return -1;
        }
    }

    // Helper method to parse and validate price
    private double parsePrice(String priceString, int lineNum) {
        if (priceString == null || priceString.isEmpty()) {
            System.err.println("Error on line " + lineNum + ": Missing starting price");
            return -1;
        }
        try {
            return Double.parseDouble(priceString);
        } catch (NumberFormatException e) {
            System.err.println("Error on line " + lineNum + ": Invalid number format for starting price ('" + priceString + "')");
            return -1;
        }
    }

    // Helper method to validate the condition (e.g., Mint, Good, Fair, etc.)
    private boolean isValidCondition(String condition) {
        // Define a list of valid conditions
        List<String> validConditions = Arrays.asList("Mint", "Good", "Fair", "Poor", "Restored", "Needs Restoring");

        // Check if the condition is null or empty
        if (condition == null || condition.trim().isEmpty()) {
            throw new IllegalArgumentException("Condition cannot be null or empty");
        }

        // Check if the provided condition is valid
        if (!validConditions.contains(condition)) {
            throw new IllegalArgumentException("Invalid condition value: " + condition);
        }

        // Return true if the condition is in the list of valid conditions
        return true; // Returning true since the condition is valid
    }
    // Method to get breakdown by condition
    public Map<String, Integer> getConditionBreakdown() {
        Map<String, Integer> breakdown = new HashMap<>();
        for (Book book : books) {
            String condition = book.getCondition();
            if (isValidCondition(condition)) { // Check if the condition is valid
                breakdown.put(condition, breakdown.getOrDefault(condition, 0) + 1);
            } else {
                System.err.println("Warning: Invalid condition '" + condition + "' for book: " + book); // Log invalid conditions if needed
            }
        }
        return breakdown;
    }
    // Helper method to validate the unique identifier
    private boolean isValidUniqueIdentifier(String uniqueIdentifier) {
        // Define a regex pattern for valid unique identifiers (alphanumeric)
        return uniqueIdentifier != null && uniqueIdentifier.matches("^[a-zA-Z0-9]+$");
    }
    // Method to add a book to the collection
    //public void addBook(Book book) {
        //books.add(book);
    //}

    // Method to get the number of books in the collection
    public int getNumberOfBooks() {
        return books.size();
    }

    // Method to find the oldest book in the collection
    public Book getOldestBook() {
        Book oldestBook = null;
        for (Book book : books) {
            if (oldestBook == null || book.getYearOfOrigin() < oldestBook.getYearOfOrigin()) {
                oldestBook = book;
            }
        }
        return oldestBook;
    }

    // Method to find the newest book in the collection
    public Book getNewestBook() {
        Book newestBook = null;
        for (Book book : books) {
            if (newestBook == null || book.getYearOfOrigin() > newestBook.getYearOfOrigin()) {
                newestBook = book;
            }
        }
        return newestBook;
    }

    // Method to find the most expensive book
    public Book getMostExpensiveBook() {
        Book mostExpensiveBook = null;
        for (Book book : books) {
            if (mostExpensiveBook == null || book.getStartingPrice() > mostExpensiveBook.getStartingPrice()) {
                mostExpensiveBook = book;
            }
        }
        return mostExpensiveBook;
    }

    // Method to find the least expensive book
    public Book getLeastExpensiveBook() {
        Book leastExpensiveBook = null;
        for (Book book : books) {
            if (leastExpensiveBook == null || book.getStartingPrice() < leastExpensiveBook.getStartingPrice()) {
                leastExpensiveBook = book;
            }
        }
        return leastExpensiveBook;
    }

    // Method to get a list of all unique owners
    public List<String> getUniqueOwners() {
        List<String> uniqueOwners = new ArrayList<>();
        for (Book book : books) {
            if (!uniqueOwners.contains(book.getOwner())) {
                uniqueOwners.add(book.getOwner());
            }
        }
        return uniqueOwners;
    }

    // Method to display all books in the collection (optional)
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Helper method for short descriptors
    private String getShortDescriptor(Book book) {
        return book.getTitle() + " (" + book.getYearOfOrigin() + ") - " + book.getUniqueIdentifier();
    }

    // Method to calculate average starting price
    private double getAverageStartingPrice() {
        if (books.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Book book : books) {
            total += book.getStartingPrice();
        }
        return total / books.size();
    }

    // Method to calculate standard deviation of starting prices
    private double getStartingPriceStandardDeviation() {
        if (books.isEmpty()) {
            return 0;
        }
        double mean = getAverageStartingPrice(); // Calculate the mean
        double sumSquaredDeviations = 0;
        for (Book book : books) {
            double deviation = book.getStartingPrice() - mean; // Calculate deviation from the mean
            sumSquaredDeviations += deviation * deviation; // Add squared deviation to the sum
        }
        return Math.sqrt(sumSquaredDeviations / books.size()); // Return the standard deviation
    }

    // Method to generate and write statistics summary to a file
    public void writeStatisticsToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Total number of books
            writer.write("Total number of items in inventory: " + getNumberOfBooks() + "\n");

            // Oldest and newest books
            writer.write("Oldest book: " + getShortDescriptor(getOldestBook()) + "\n");
            writer.write("Newest book: " + getShortDescriptor(getNewestBook()) + "\n");

            // Most and least expensive books
            writer.write("Most expensive book: " + getShortDescriptor(getMostExpensiveBook()) + " - AED " + getMostExpensiveBook().getStartingPrice() + "\n");
            writer.write("Least expensive book: " + getShortDescriptor(getLeastExpensiveBook()) + " - AED " + getLeastExpensiveBook().getStartingPrice() + "\n");

            // Average of starting prices
            writer.write("Average starting price: Aed " + getAverageStartingPrice() + "\n");
            writer.write("Standard deviation of starting prices: " + getStartingPriceStandardDeviation() + "\n");

            // Write breakdown by condition
            writer.write("Breakdown by condition: \n");
            Map<String, Integer> conditionBreakdown = getConditionBreakdown();
            for (String condition : conditionBreakdown.keySet()) {
                writer.write(condition + ": " + conditionBreakdown.get(condition) + "\n");
            }

            writer.flush(); // Ensure all content is written to the file
            System.out.println("Statistics successfully written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing statistics to file: " + e.getMessage());
        }
    }
}
 */
