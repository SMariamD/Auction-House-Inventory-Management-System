import java.util.*;
import java.io.*;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
import java.io.BufferedReader;
import java.util.HashMap;
import java.io.FileReader;
import java.util.ArrayList;


import java.util.*;
import java.io.*;

public class Manager {
    private CollectibleCollection collectibleCollection;

    public Manager() {
        this.collectibleCollection = new CollectibleCollection();
    }

    // Add a collectible to the collection
    public void addCollectible(Collectible collectible) {
        collectibleCollection.addCollectible(collectible);
    }

    // Get the list of collectibles
    public List<Collectible> getCollectibles() {
        return collectibleCollection.getCollectibles();
    }

    // Load collectibles from a CSV file
    public void loadCollectiblesFromCSV(String filename) {
        System.out.println("Loading from file: " + filename);
        collectibleCollection.readCollectiblesFromCSV(filename);
        System.out.println("Loaded collectibles: ");
        collectibleCollection.getCollectibles().forEach(collectible -> System.out.println(collectible.toCSV()));
    }
    // Sort by ID
    public void sortByID() {
        Collections.sort(collectibleCollection.getCollectibles(), new CollectibleComparators.SortByID());
    }

    // Sort by Price (descending)
    public void sortByPriceDescending() {
        Collections.sort(collectibleCollection.getCollectibles(), new CollectibleComparators.SortByPriceDescending());
    }

    // Sort by Year Estimate
    public void sortByYearEstimate() {
        Collections.sort(collectibleCollection.getCollectibles(), new CollectibleComparators.SortByYearEstimate());
    }

    // Write statistics about the collectibles to a specified file
    public void writeStatisticsToFile(String filePath) throws IOException {
        collectibleCollection.writeStatisticsToFile(filePath);
    }



    // Save all collectibles to a new CSV file
    public void saveCollectiblesToCSV(String filePath) {
        System.out.println("Saving all collectibles to file: " + filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Type,Title,Owner,Condition,StartingPrice,UniqueID,LowYearEstimate,HighYearEstimate,Material,GemType,Make,Model,Style,Width,Height,Author,Edition,Genre,ServiceHistory\n");

            for (Collectible collectible : collectibleCollection.getCollectibles()) {
                writer.write(collectible.toCSV());
                writer.newLine();
            }

            System.out.println("All collectibles saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filePath + ". " + e.getMessage());
        }
    }

    // Save only updated collectibles to the same CSV file
    public void saveUpdatedCollectiblesToCSV(String filePath) {
        System.out.println("Saving updated collectibles to file: " + filePath);

        String tempFilePath = filePath + ".tmp";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFilePath))) {

            String header = reader.readLine(); // Read and write the header row
            if (header != null) {
                writer.write(header);
                writer.newLine();
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String uniqueID = (data.length > 5) ? data[5] : null; // Extract UniqueID

                if (uniqueID == null) {
                    System.err.println("Skipping malformed line: " + line);
                    writer.write(line); // Write the original line as-is
                    writer.newLine();
                    continue;
                }

                Collectible collectible = collectibleCollection.getCollectibles().stream()
                        .filter(c -> c.getUniqueIdentifier().equals(uniqueID))
                        .findFirst()
                        .orElse(null);

                if (collectible != null) {
                    // Write updated collectible data
                    writer.write(collectible.toCSV());
                } else {
                    // Write the original line if no update is found
                    writer.write(line);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error while saving updates: " + e.getMessage());
            return;
        }

        // Replace the original file with the updated file
        try {
            java.nio.file.Files.move(
                    java.nio.file.Paths.get(tempFilePath),
                    java.nio.file.Paths.get(filePath),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Updated collectibles saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error replacing original file: " + e.getMessage());
        }
    }

    // Update collectibles data from another CSV file
    public void updateCollectiblesFromCSV(String filePath) {
        System.out.println("Updating collectibles from file: " + filePath);
        Map<String, Collectible> updatedCollectibles = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine(); // Skip the header row
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String uniqueID = (data.length > 5) ? data[5] : null;

                if (uniqueID == null) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }

                Collectible updatedCollectible = collectibleCollection.createCollectibleFromCSV(data);
                if (updatedCollectible != null) {
                    updatedCollectibles.put(uniqueID, updatedCollectible);
                }
            }

            for (Collectible oldCollectible : collectibleCollection.getCollectibles()) {
                Collectible updated = updatedCollectibles.get(oldCollectible.getUniqueIdentifier());
                if (updated != null) {
                    updateCollectibleFields(oldCollectible, updated);
                }
            }

            System.out.println("Collectibles updated from file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath + ". " + e.getMessage());
        }
    }

    // Helper method to update fields of a collectible
    private void updateCollectibleFields(Collectible oldCollectible, Collectible updated) {
        if (!updated.getTitle().equals(oldCollectible.getTitle())) {
            oldCollectible.setTitle(updated.getTitle());
        }
        if (!updated.getOwner().equals(oldCollectible.getOwner())) {
            oldCollectible.setOwner(updated.getOwner());
        }
        if (!updated.getCondition().equals(oldCollectible.getCondition())) {
            oldCollectible.setCondition(updated.getCondition());
        }
        if (updated.getStartingPrice() != oldCollectible.getStartingPrice()) {
            oldCollectible.setStartingPrice(updated.getStartingPrice());
        }
        if (updated.getYearEstimate().getLowYearEstimate() != oldCollectible.getYearEstimate().getLowYearEstimate() ||
                updated.getYearEstimate().getHighYearEstimate() != oldCollectible.getYearEstimate().getHighYearEstimate()) {
            oldCollectible.updateYearEstimate(
                    updated.getYearEstimate().getLowYearEstimate(),
                    updated.getYearEstimate().getHighYearEstimate()
            );
        }
    }
}
