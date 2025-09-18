import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Collectibles Inventory Application...");

        // Initialize Manager
        Manager manager = new Manager();

        // Option 1: Test collectibles.csv (default main file)
        // Uncomment the following block to test the main file:

        System.out.println("\n=== file: collectibles.csv ===");
        manager.loadCollectiblesFromCSV("collectibles.csv");
        System.out.println("Collectibles loaded successfully for file: collectibles.csv");


        //Option 2: Test invalidNumbers.csv
        // Uncomment the following block to test invalidnumbers.csv:

       // System.out.println("\n=== Testing file: invalidnumbers.csv ===");
       // manager.loadCollectiblesFromCSV("invalidnumbers.csv");
       // System.out.println("Collectibles loaded successfully for file: invalidNumbers.csv");


        // Option 3: Test unexpectedStrings.csv
        // Uncomment the following block to test unexpectedStrings.csv:
        /*
        System.out.println("\n=== Testing file: unexpectedstrings.csv ===");
        manager.loadCollectiblesFromCSV("unexpectedstrings.csv");
        System.out.println("Collectibles loaded successfully for file: unexpectedStrings.csv");
        */

        // Option 4: Test missingFields.csv
        // Uncomment the following block to test missingFields.csv:

        //System.out.println("\n=== Testing file: missingfields.csv ===");
        //manager.loadCollectiblesFromCSV("missingfields.csv");
        //System.out.println("Collectibles loaded successfully for file: missingFields.csv");


        // Notify about the statistics file
        System.out.println("Statistics will be written to: statistics_summary.txt");

        // Save and verify statistics for the current test
        try {
            manager.writeStatisticsToFile("statistics_summary.txt");
            System.out.println("Statistics successfully written to file: statistics_summary.txt");
        } catch (Exception e) {
            System.err.println("Error writing statistics: " + e.getMessage());
        }

        // Retrieve the list of collectibles
        List<Collectible> collectibles = manager.getCollectibles();

        // Create and display the CustomFrame (UI part)
        CustomFrame customFrame = new CustomFrame("Collectibles Inventory");

        // Pass manager and collectibles to CustomFrame
        customFrame.setManager(manager);
        customFrame.setListContent(collectibles); // Populate the JList with data
        customFrame.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("Saving updated collectibles to CSV...");
                manager.saveUpdatedCollectiblesToCSV("collectibles.csv");
                System.out.println("Collectibles saved successfully.");
            } catch (Exception e) {
                System.err.println("Failed to save collectibles during shutdown: " + e.getMessage());
            }
        }));
    }
}

