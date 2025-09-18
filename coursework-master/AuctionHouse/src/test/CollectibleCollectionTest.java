
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class CollectibleCollectionTest {

    @Test
    public void testGetTop3MostDifferent_Ascending() {
        // Arrange
        CollectibleCollection collection = new CollectibleCollection();

        collection.addCollectible(new Book(
                "The Great Gatsby",
                1923,
                1925,
                "John Doe",
                "Awesome",
                100.00,
                "ID001",
                "F. Scott Fitzgerald",
                "First Edition",
                "Fiction"
        ));

        collection.addCollectible(new Car(
                "Vintage Car Model X",
                1965,
                1970,
                "Bob Brown",
                "Restored",
                25000.00,
                "ID004",
                "Ford",
                "Mustang",
                "Serviced"
        ));

        collection.addCollectible(new Jewellery(
                "Antique Necklace",
                1800,
                1850,
                "Alice Green",
                "Fair",
                500.00,
                "ID003",
                "Gold",
                "Diamond"
        ));

        // Act
        List<Collectible> result = collection.getTop3MostDifferent();

        // Assert (smallest difference comes first in ascending order)
        assertEquals(3, result.size());
        assertEquals("ID001", result.get(0).getUniqueIdentifier()); // Book with smallest difference (2 years)
        assertEquals("ID004", result.get(1).getUniqueIdentifier()); // Car with next smallest difference (5 years)
        assertEquals("ID003", result.get(2).getUniqueIdentifier()); // Jewelry with the largest difference (50 years)
    }

    @Test
    public void testGetTop3MostDifferent_EmptyCollection() {
        // Arrange
        CollectibleCollection collection = new CollectibleCollection();

        // Act
        List<Collectible> result = collection.getTop3MostDifferent();

        // Assert
        assertEquals(0, result.size()); // No items to return
    }
    @Test
    public void testGetTop3MostDifferent_SameYearDifferences() {
        // Arrange
        CollectibleCollection collection = new CollectibleCollection();

        collection.addCollectible(new Book(
                "Book A",
                1900,
                1950,
                "Owner A",
                "Good",
                100.0,
                "ID001",
                "Author A",
                "First Edition",
                "Fiction"
        ));

        collection.addCollectible(new Car(
                "Car A",
                1900,
                1950,
                "Owner B",
                "Fair",
                20000.0,
                "ID002",
                "Make A",
                "Model A",
                "Serviced"
        ));

        collection.addCollectible(new Jewellery(
                "Jewelry A",
                1900,
                1950,
                "Owner C",
                "Mint",
                500.0,
                "ID003",
                "Gold",
                "Diamond"
        ));

        // Act
        List<Collectible> result = collection.getTop3MostDifferent();

        // Assert (all year differences are the same)
        assertEquals(3, result.size());
        assertTrue(result.contains(collection.getCollectibles().get(0))); // Contains Book A
        assertTrue(result.contains(collection.getCollectibles().get(1))); // Contains Car A
        assertTrue(result.contains(collection.getCollectibles().get(2))); // Contains Jewelry A
    }
    @Test
    public void testLoadCollectiblesFromCSV_ValidFile() {
        Manager manager = new Manager();
        // Use the absolute path for Resources
        String filePath = getClass().getClassLoader().getResource("collectibles.csv").getPath();
        manager.loadCollectiblesFromCSV(filePath);



        List<Collectible> collectibles = manager.getCollectibles();
        assertFalse(collectibles.isEmpty(), "Collectibles should be loaded successfully.");
        // Add more assertions to verify the correct data is loaded
        assertEquals(5, collectibles.size(), "There should be 5 items loaded from collectibles.csv.");
    }

    @Test
    public void testLoadCollectiblesFromCSV_InvalidFile() {
        Manager manager = new Manager();
        String filePath = getClass().getClassLoader().getResource("invalidnumbers.csv").getPath();
        manager.loadCollectiblesFromCSV(filePath);

        List<Collectible> collectibles = manager.getCollectibles();
        // Assert that invalid rows are skipped but valid rows are loaded
        assertEquals(1, collectibles.size(), "One valid row should be loaded from invalidnumbers.csv.");
        assertEquals("ID002", collectibles.get(0).getUniqueIdentifier(), "Loaded row should have ID002.");
    }

    @Test
    public void testLoadCollectiblesFromCSV_UnexpectedStrings() {
        Manager manager = new Manager();
        String filePath = getClass().getClassLoader().getResource("unexpectedstrings.csv").getPath();
        manager.loadCollectiblesFromCSV(filePath);


        List<Collectible> collectibles = manager.getCollectibles();
        // Example: Validate the size of the loaded list
        assertEquals(3, collectibles.size(), "Expected 3 valid collectibles to be loaded.");

// Example: Validate specific collectible properties
        Collectible collectible = collectibles.get(0);
        assertEquals("ID001", collectible.getUniqueIdentifier(), "The first collectible ID should be ID001.");

    }

    @Test
    public void testLoadCollectiblesFromCSV_MissingFields() {
        Manager manager = new Manager();
        String filePath = getClass().getClassLoader().getResource("missingfields.csv").getPath();
        manager.loadCollectiblesFromCSV(filePath);

        List<Collectible> collectibles = manager.getCollectibles();
        assertFalse(collectibles.isEmpty(), "Rows with missing fields should be skipped, but valid rows should still load.");
        assertEquals(1, collectibles.size(), "Only one valid collectible should be loaded from missingfields.csv.");

        // Optional: Validate the loaded collectible
        Collectible loadedCollectible = collectibles.get(0);
        assertEquals("Antique Necklace", loadedCollectible.getTitle(), "The title of the valid collectible should match.");
        assertEquals("Alice Green", loadedCollectible.getOwner(), "The owner of the valid collectible should match.");
        assertEquals("Fair", loadedCollectible.getCondition(), "The condition of the valid collectible should match.");
        assertEquals(500.0, loadedCollectible.getStartingPrice(), "The starting price of the valid collectible should match.");
    }


}






