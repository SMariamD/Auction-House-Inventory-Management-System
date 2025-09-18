# F20-21SF Coursework Project

> Author: Syeda Mariam Danish 

## Getting started:
 
- [ ] Fork project in personal space
- [ ] Clone project on machine
- [ ] Create first issue on GitLab
- [ ] Edit code to address issue
- [ ] Commit by referencing issue number
- [ ] Push commits
- [ ] Edit README 


## Stage 1

### 1. Book Class
- Created the `Book` class with the following attributes:
  - [ ] **Title**
  - [ ] **Author's Name**
  - [ ] **Edition**
  - [ ] **Genre**
  - [ ] **Year of Origin**
  - [ ] **Owner**
  - [ ] **Condition**
  - [ ] **Starting Price**
  - [ ] **Unique Identifier**
- Developed getter and setter methods for each attribute.

---

### 2. BookCollection Class
- Designed the `BookCollection` class to manage a collection of `Book` objects.
- Implemented methods to:
  - [ ] Add books to the collection.
  - [ ] Get the number of books.
  - [ ] Find the most and least expensive books.
  - [ ] Get the oldest and newest books.
  - [ ] Retrieve a list of unique owners.

---

### 3. UML Class Diagram
- Created a UML class diagram representing the `Book` and `BookCollection` classes, including attributes and methods.
- Indicated the relationship between the two classes.

---

### 4. Main Class Setup
- Established a `Main` class for testing and demonstrating the functionality of the `Book` and `BookCollection` classes.
- Included code to:
  - Create `Book` instances.
  - Add `Book` instances to a `BookCollection`.

  

## Stage 2

### 1. CSV Reading Implementation
- Developed the core functionality to read data from a CSV file, ensuring efficient data retrieval.

---

### 2. File Reading Structure
- Organized the file reading process using a `try` block, facilitating effective error handling during the reading operation.

---

### 3. Missing Fields Check
- Implemented checks for missing fields in the CSV data, ensuring data integrity before processing.

---

### 4. Book Creation and Addition
- Finalized the process of creating `Book` objects from CSV data and adding them to the collection using an `addBook` method.

---

### 5. Error Handling
- Developed `catch` blocks for parsing and I/O errors, enhancing resilience during the file reading process.

---

### 6. Resource Cleanup
- Implemented a `finally` block for proper resource management post file operations, ensuring that resources are released appropriately.

---

### 7. Condition Validation
- Established a method to validate the condition of books during CSV processing, preventing invalid entries.

---

### 8. Unique Identifier Validation
- Developed a method to ensure each book has a unique identifier, maintaining data consistency.

---

### 9. Year and Price Validation
- Implemented helper methods to parse and validate the year of origin and starting price, ensuring accurate data entry.

---

### 10. Statistical Methods
- **Statistical Calculations:**
  - Calculated the standard deviation of starting prices.
  - Generated a breakdown of book conditions.
  - Implemented a method for calculating the average starting price.
- **Collection Overview:**
  - Implemented a method to return the total number of books in the collection.
  - Developed methods to identify the oldest and newest books.
  - Created methods to find the most and least expensive books in the collection.

---

### 11. Short Descriptors
- Created a helper method for generating short descriptors for books, enhancing data representation.

---

### 12. Statistics Writing
- Developed functionality to write statistical data to an output file, facilitating data analysis and reporting.

---

### 13. Corrupted Files Management
- Created a mechanism to comment/uncomment lines for handling corrupted entries, improving error resilience.

---

### 14. Header Row Handling
- Added functionality to skip the header row during CSV reading, streamlining data processing.

---

### 15. UML Diagram Update
- Updated the UML diagram to reflect Stage 2 functionality and design changes.

---

### 16. Resource File Management
- Uploaded files to the **Resources** folder and set up relative paths for file access.





## Stage 3

# Stage 3 Design Decisions

## 1. Extend Class Structure
**Objective:** Ensure flexibility and reusability for handling new collectible types.

**Action:**
- Introduce new subclasses for each collectible type.
- Implement and override methods in these subclasses to accommodate specific collectible attributes.
- Modify the base class (`Collectible`) to support the `YearEstimate` class for consistent date handling.

---

## 2. CSV Parsing and Error Handling
**Objective:** Make the system robust against invalid data in CSV files.

**Action:**
- Implement error-handling mechanisms for unexpected strings and invalid numbers in CSV files.
- Add functionality to log or report parsing errors to ensure transparency and debugging ease.

---

## 3. Generalized Year Estimate Handling
**Objective:** Create a consistent way to handle year-related data.

**Action:**
- Develop a `YearEstimate` class to manage single-year and range-based year data.
- Implement methods to calculate middle-year estimates and identify oldest/newest items using this metric.

---

## 4. Statistics and Analysis
**Objective:** Provide insightful summaries across all collectibles.

**Action:**
- Implement methods to find items with the largest differences in year estimates.
- Write general statistics (e.g., counts, averages) to a file for easy accessibility.

---

## 5. UML Diagram for Documentation
**Objective:** Provide a clear visualization of the extended class structure.

**Action:**
- Create and update the UML diagram to reflect the new subclasses and methods, ensuring it aligns with Stage 3 design.

---

## 6. Testing
**Objective:** Validate functionality at every stage of development.

**Action:**
- Conduct thorough testing for collectible objects and CSV parsing to ensure data accuracy and correct functionality.
- Update and test the program to confirm CSV file updates are handled correctly.


## Stage 4

# Stage 4 Design Decisions

## 1. Manager Class Integration
**Objective:** Centralize control of user interface actions and data management.

**Action:**
- Create a Manager class to handle button actions, update inventory data, and coordinate between the UI and backend logic.
- Ensure the Manager class is modular and easily extendable for future features.

## 2. User Interface Implementation
**Objective:** Develop an intuitive and functional user interface to manage collectibles.

**Action:**
- Implement a graphical user interface (GUI) with basic components like buttons, text fields, and lists for interacting with the collectible data.
- Add specific buttons for functionality such as adding items, editing items, saving data, and generating statistics.
- Ensure the interface is user-friendly and visually appealing.

---

## 3. Advanced Button Functionalities
**Objective:** Enhance the interactivity and usability of the application.

**Action:**
- Implement functionality for key buttons:
  - **Sort Items Button**: Enable users to sort collectibles by their price,id,year.
  - **Edit Button**: Allow users to update information for existing items.
  - **More Info Button**: Display detailed information about selected collectibles.
  - **Generate Stats Button**: Generate and display summary statistics directly through the interface.
  - **Save Button**: Allow users to save information that is updated.

---

## 4. Inventory Management
**Objective:** Improve the system for managing collectible data.

**Action:**
- Develop methods to update the inventory dynamically when items are added, edited, or removed.
- Implement a sorting method to organize collectibles based on user preferences or specific attributes.

---

## 5. Data Persistence
**Objective:** Ensure collectible data is saved and retrieved reliably.

**Action:**
- Implement functionality to save the inventory to a file or database.
- Ensure saved data can be reloaded accurately when the application restarts.

---

## 6. Testing and Validation
**Objective:** Verify the functionality and robustness of the system.

**Action:**
- Set up a comprehensive JUnit testing framework.
- System testing to ensure the interface and backend logic work seamlessly together.
- Test specific cases such as empty collections, invalid inputs, and large datasets to ensure system stability.

---

## 7. UML and Activity Diagrams
**Objective:** Provide clear documentation of the design and workflows.

**Action:**
- Update the UML diagram to reflect the Stage 4 design, including the new Manager class and button functionalities.
- Create an activity diagram to document the user interaction flow and system response for key processes.

---

## 8. Error Handling
**Objective:** Maintain application stability during user interactions.

**Action:**
- Add robust error-handling logic for invalid inputs and unexpected user actions.
- Provide clear error messages and logs to guide users and assist in debugging.

---


