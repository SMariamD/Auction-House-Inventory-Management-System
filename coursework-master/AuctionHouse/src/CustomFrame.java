import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CustomFrame extends JFrame {
    private JList<Collectible> collectiblesList;
    private DefaultListModel<Collectible> listModel;
    private JButton moreInfoButton, editItemButton, saveButton, sortByIDButton, sortByPriceButton, sortByYearButton, generateStatsButton;
    private Manager manager; // Manager object to handle the collectibles

    public CustomFrame(String title) {
        super(title);
        this.setSize(800, 600); // Set window size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        this.setLayout(new BorderLayout()); // Set layout manager for the frame

        // List Panel
        listModel = new DefaultListModel<>();
        collectiblesList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(collectiblesList);
        this.add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Initialize buttons
        moreInfoButton = new JButton("More Info");
        editItemButton = new JButton("Edit Item");
        saveButton = new JButton("Save Data");
        sortByIDButton = new JButton("Sort by ID");
        sortByPriceButton = new JButton("Sort by Price");
        sortByYearButton = new JButton("Sort by Year");
        generateStatsButton = new JButton("Generate Stats");

        // Add buttons to the panel
        buttonPanel.add(moreInfoButton);
        buttonPanel.add(editItemButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(sortByIDButton);
        buttonPanel.add(sortByPriceButton);
        buttonPanel.add(sortByYearButton);
        buttonPanel.add(generateStatsButton);

        // Add button panel to the frame
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        moreInfoButton.addActionListener(e -> {
            Collectible selectedItem = collectiblesList.getSelectedValue();
            if (selectedItem != null) {
                showMoreInfo(selectedItem);
            } else {
                JOptionPane.showMessageDialog(this, "Please select an item first.");
            }
        });

        editItemButton.addActionListener(e -> {
            Collectible selectedItem = collectiblesList.getSelectedValue();
            if (selectedItem != null) {
                showEditDialog(selectedItem);
                manager.getCollectibles().stream()
                        .filter(collectible -> collectible.getUniqueIdentifier().equals(selectedItem.getUniqueIdentifier()))
                        .findFirst()
                        .ifPresent(collectible -> {
                            collectible.setStartingPrice(selectedItem.getStartingPrice());
                            collectible.setCondition(selectedItem.getCondition());
                        });
                setListContent(manager.getCollectibles()); // Refresh the list view
            } else {
                JOptionPane.showMessageDialog(this, "Please select an item first.");
            }
        });

        saveButton.addActionListener(e -> {
            if (manager != null) {
                try {
                    manager.saveCollectiblesToCSV("collectibles.csv");
                    JOptionPane.showMessageDialog(this, "Data saved successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        sortByIDButton.addActionListener(e -> {
            manager.sortByID();
            setListContent(manager.getCollectibles());
            JOptionPane.showMessageDialog(this, "Sorted by ID (Ascending).");
        });

        sortByPriceButton.addActionListener(e -> {
            manager.sortByPriceDescending();
            setListContent(manager.getCollectibles());
            JOptionPane.showMessageDialog(this, "Sorted by Price (Descending).");
        });

        sortByYearButton.addActionListener(e -> {
            manager.sortByYearEstimate();
            setListContent(manager.getCollectibles());
            JOptionPane.showMessageDialog(this, "Sorted by Year Estimate (Ascending).");
        });

        generateStatsButton.addActionListener(e -> {
            if (manager != null) {
                try {
                    String statsFilePath = "statistics_summary.txt"; // Path for the stats file
                    manager.writeStatisticsToFile(statsFilePath);
                    JOptionPane.showMessageDialog(this, "Statistics summary generated at: " + statsFilePath);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error generating statistics: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Set the manager instance
    public void setManager(Manager manager) {
        this.manager = manager;
        if (manager != null) {
            setListContent(manager.getCollectibles());
        }
    }

    // Update the list content in the UI
    public void setListContent(List<Collectible> collectibles) {
        listModel.clear();
        for (Collectible collectible : collectibles) {
            listModel.addElement(collectible);
        }
    }

    // Show detailed information for a selected collectible
    private void showMoreInfo(Collectible collectible) {
        String details = collectible.getDetails();
        JOptionPane.showMessageDialog(this, details, "Collectible Details", JOptionPane.INFORMATION_MESSAGE);
    }

    // Show the edit dialog for editing price and condition
    private void showEditDialog(Collectible collectible) {
        JDialog editDialog = new JDialog(this, "Edit Item", true);
        editDialog.setLayout(new GridLayout(3, 2));
        editDialog.setSize(400, 200);

        JTextField priceField = new JTextField(String.valueOf(collectible.getStartingPrice()));
        JComboBox<String> conditionComboBox = new JComboBox<>(new String[]{"New", "Used", "Damaged"});
        conditionComboBox.setSelectedItem(collectible.getCondition());

        editDialog.add(new JLabel("Price (AED):"));
        editDialog.add(priceField);
        editDialog.add(new JLabel("Condition:"));
        editDialog.add(conditionComboBox);

        JButton saveChangesButton = new JButton("Save Changes");
        saveChangesButton.addActionListener(e -> {
            try {
                double newPrice = Double.parseDouble(priceField.getText());
                String newCondition = (String) conditionComboBox.getSelectedItem();

                collectible.setStartingPrice(newPrice);
                collectible.setCondition(newCondition);

                setListContent(manager.getCollectibles()); // Refresh the list view
                editDialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(editDialog, "Invalid price entered.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        editDialog.add(new JLabel()); // Spacer
        editDialog.add(saveChangesButton);
        editDialog.setVisible(true);
    }
}

