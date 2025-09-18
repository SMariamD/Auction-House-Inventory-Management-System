import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomFrameTest {
    private CustomFrame frame;
    private Collectible collectible;

    @BeforeEach
    public void setUp() {
        frame = new CustomFrame("Test Frame");
        collectible = new Book(
                "The Great Gatsby",
                1923,
                1925,
                "John Doe",
                "Used",
                100.0,
                "ID001",
                "F. Scott Fitzgerald",
                "First Edition",
                "Fiction"
        );

        Manager manager = new Manager();
        manager.addCollectible(collectible);
        frame.setManager(manager);
        frame.setVisible(true); // Make the frame visible for testing
    }

    @Test
    public void testEditButtonFunctionality() throws InterruptedException {
        // Arrange: Select the collectible in the list
        frame.getCollectiblesList().setSelectedIndex(0);

        Collectible collectible = frame.getCollectiblesList().getSelectedValue();
        assertNotNull(collectible, "Collectible should exist");
        assertEquals(100.0, collectible.getStartingPrice(), "Initial price should be 100.0");
        assertEquals("Used", collectible.getCondition(), "Initial condition should be 'Used'");

        // Act: Simulate clicking the Edit Item button
        JButton editButton = frame.getEditItemButton();
        assertNotNull(editButton, "Edit button should exist");
        editButton.doClick();

        // Wait for the dialog to appear
        waitForDialogToAppear();

        // Assert: Verify that the dialog is displayed and visible
        JDialog editDialog = getDialogComponent(frame);
        assertNotNull(editDialog, "Edit dialog should appear");
        assertTrue(editDialog.isVisible(), "Edit dialog should be visible");

        // Simulate user interaction: Change price and condition
        JTextField priceField = getComponentOfType(editDialog, JTextField.class);
        assertNotNull(priceField, "Price field should exist");
        priceField.setText("150.0");

        JComboBox<String> conditionComboBox = getComponentOfType(editDialog, JComboBox.class);
        assertNotNull(conditionComboBox, "Condition dropdown should exist");
        conditionComboBox.setSelectedItem("New");

        // Simulate clicking the Save Changes button
        JButton saveChangesButton = getComponentOfType(editDialog, JButton.class);
        assertNotNull(saveChangesButton, "Save button should exist");
        saveChangesButton.doClick();

        // Assert: Verify the changes are applied
        collectible = frame.getCollectiblesList().getSelectedValue();
        assertEquals(150.0, collectible.getStartingPrice(), 0.01, "Price should be updated to 150.0");
        assertEquals("New", collectible.getCondition(), "Condition should be updated to 'New'");
    }

    /**
     * Helper method to find an active dialog.
     *
     * @param frame The parent JFrame.
     * @return The visible JDialog, or null if no visible dialog is found.
     */
    private JDialog getDialogComponent(JFrame frame) {
        System.out.println("Checking for visible dialogs...");
        for (Window window : JFrame.getWindows()) {
            System.out.println("Window: " + window + ", Visible: " + window.isVisible() + ", Type: " + window.getClass().getName());
            if (window instanceof JDialog && window.isVisible()) {
                System.out.println("Found visible dialog: " + ((JDialog) window).getTitle());
                return (JDialog) window;
            }
        }
        System.out.println("No visible dialogs found.");
        return null;
    }

    /**
     * Waits for a JDialog to appear and be visible.
     *
     * @throws InterruptedException if the thread is interrupted during the wait.
     */
    private void waitForDialogToAppear() throws InterruptedException {
        int maxRetries = 10; // Maximum retries
        int delay = 200;     // Delay per retry in milliseconds
        int attempts = 0;

        while (attempts < maxRetries) {
            JDialog dialog = getDialogComponent(frame);
            if (dialog != null && dialog.isVisible()) {
                return; // Dialog is visible, exit the loop
            }
            Thread.sleep(delay); // Wait and retry
            attempts++;
        }

        // If dialog is still not visible, fail the test
        fail("Dialog did not appear within the expected time.");
    }

    /**
     * Generic helper method to find a component of a specific type in a container.
     *
     * @param <T>       The type of the component to find.
     * @param container The container to search.
     * @param type      The class type of the component to find.
     * @return The component of the specified type, or null if not found.
     */
    private <T> T getComponentOfType(Container container, Class<T> type) {
        for (Component component : container.getComponents()) {
            if (type.isInstance(component)) {
                return type.cast(component);
            }
            if (component instanceof Container) {
                T result = getComponentOfType((Container) component, type);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}


