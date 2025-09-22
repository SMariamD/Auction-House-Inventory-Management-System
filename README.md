# Auction House Inventory Management System

> **F20-21SF Coursework Project**  
> **Author:** Syeda Mariam Danish

A comprehensive Java and JavaFX application designed to manage auction house inventories featuring various collectibles. The system provides a user-friendly interface with multiple functionalities for inventory management, statistical analysis, and data persistence.

##  Application Screenshot

![Auction House Inventory Management System](full%20ui%20window.PNG)

*The main interface showing the Collectibles Inventory management system with various collectible items and control buttons.*

## ✨ Features

### Core Functionality
- **Multi-Type Collectible Management**: Support for books, cars, jewelry, and paintings
- **CSV Data Import/Export**: Bulk data operations with error handling
- **Statistical Analysis**: Comprehensive reporting and analytics
- **Data Validation**: Robust input validation and error handling
- **Graphical User Interface**: Intuitive GUI for easy management
- **Search and Filter**: Advanced search capabilities across collectibles

### Key Capabilities
- Add, edit, and remove collectible items
- Sort items by various criteria (price, year, ID)
- Generate detailed statistics and reports
- Import data from CSV files with validation
- Export data and statistics
- Year estimation and range handling
- Condition validation and tracking


##  Technologies Used

- **Java** - Core programming language
- **JavaFX** - GUI framework
- **MVC Architecture** - Model-View-Controller pattern
- **CSV Processing** - Data import/export functionality
- **UML Design** - Object-oriented design principles

## 🏗️ System Architecture

### Class Hierarchy
```
Collectible (Base Class)
├── Book
├── Car
├── Jewellery
└── Painting

Supporting Classes:
├── CollectibleCollection
├── Manager
├── YearEstimate
├── CustomFrame
└── CollectibleComparators
```

### Core Components
- **CollectibleCollection**: Manages collections of various collectible types
- **Manager**: Handles UI interactions and business logic
- **CustomFrame**: Provides the graphical user interface
- **YearEstimate**: Handles year-related data and calculations

## 🚀 Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java IDE (Eclipse, IntelliJ IDEA, or VS Code)
- Git (for version control)

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/SMariamD/Auction-House-Inventory-Management-System.git
   cd Auction-House-Inventory-Management-System
   ```

2. **Navigate to the project directory**
   ```bash
   cd AuctionHouse
   ```

3. **Compile the project**
   ```bash
   javac -cp src src/*.java
   ```

4. **Run the application**
   ```bash
   java -cp src Main
   ```

## 💻 Usage

### Starting the Application
1. Run the `Main.java` class
2. The GUI will launch automatically
3. Use the interface to manage your collectible inventory

### Adding Collectibles
1. Click "Add Item" button
2. Fill in the required information
3. Select the collectible type
4. Click "Save" to add to inventory

### Importing Data
1. Prepare CSV files with collectible data
2. Use the import functionality in the GUI
3. System will validate and process the data
4. Review any error messages for data issues

### Generating Reports
1. Click "Generate Stats" button
2. View comprehensive statistics
3. Export reports as needed


## 📁 Project Structure

```
Auction-House-Inventory-Management-System/
├── AuctionHouse/                    # Main application source code
│   ├── src/                        # Java source files
│   │   ├── Book.java               # Book collectible class
│   │   ├── Car.java                # Car collectible class
│   │   ├── Collectible.java        # Base collectible class
│   │   ├── CollectibleCollection.java # Collection management
│   │   ├── CollectibleComparators.java # Sorting comparators
│   │   ├── CustomFrame.java        # GUI main frame
│   │   ├── Jewellery.java          # Jewelry collectible class
│   │   ├── Main.java               # Application entry point
│   │   ├── Manager.java            # Business logic controller
│   │   ├── Painting.java           # Painting collectible class
│   │   ├── YearEstimate.java       # Year estimation utility
│   │   ├── Resources/              # Data files and resources
│   │   │   ├── collectibles.csv    # Sample collectible data
│   │   │   ├── invalidnumbers.csv  # Test data for validation
│   │   │   ├── missingfields.csv   # Test data for error handling
│   │   │   ├── statistics_summary.txt # Generated statistics
│   │   │   └── unexpectedstrings.csv # Test data for parsing
│   │   └── test/                   # Unit test files
│   │       ├── CollectibleCollectionTest.java
│   │       ├── CustomFrameTest.java
│   │       └── Resources/           # Test data files
│   └── Stage_1_Diagram.drawio.png  # UML diagram
├── Files for Stage 2/              # Stage 2 development files
│   ├── books.csv                   # Sample book data
│   ├── invalidnumbers.csv          # Test data
│   ├── missingfields.csv           # Test data
│   └── unexpectedstrings.csv       # Test data
├── Stage UML Diagrams/             # UML documentation
│   ├── Method Activity Diagram.drawio.png
│   ├── Stage 3 Diagram.drawio updated.drawio.png
│   ├── Stage 4 Diagram.drawio updated.drawio (1).drawio.png
│   ├── Stage_1_Diagram.drawio.png
│   └── Stage_2_Diagram.drawio.png
├── full ui window.PNG              # Application screenshot
├── Stage_1_Diagram.drawio.png      # Main UML diagram
├── README.md                       # Project documentation
└── .gitignore                      # Git ignore rules
```

##  Development Stages

### Stage 1: Core Classes
- **Book Class**: Created with comprehensive attributes (title, author, edition, genre, year, owner, condition, price, ID)
- **BookCollection Class**: Manages collections with statistical methods
- **UML Design**: Class diagrams and relationships
- **Main Class**: Testing and demonstration setup

### Stage 2: Data Processing
- **CSV Reading**: Efficient data retrieval from CSV files
- **Error Handling**: Robust try-catch blocks for data validation
- **Statistical Methods**: Standard deviation, averages, condition breakdowns
- **Data Validation**: Unique ID validation, year/price validation
- **File Management**: Resource cleanup and path management

### Stage 3: Extended Architecture
- **Collectible Subclasses**: Support for multiple collectible types
- **YearEstimate Class**: Flexible date handling for single years and ranges
- **Enhanced Statistics**: Cross-collectible analysis and reporting
- **Error Resilience**: Improved handling of corrupted data

### Stage 4: User Interface
- **Manager Class**: Centralized UI control and data management
- **Interactive GUI**: Buttons, text fields, and lists for user interaction
- **Advanced Functionality**:
  - Sort items by ID, price, or year
  - Edit existing items
  - Display detailed information
  - Generate statistics
  - Save data changes
- **Data Persistence**: Reliable save/load functionality
- **JUnit Testing**: Comprehensive test framework

##  Key Functionalities

### Inventory Management
- Add new collectible items
- Edit existing item information
- Remove items from inventory
- View detailed item information

### Data Analysis
- Generate statistical reports
- Calculate averages and standard deviations
- Identify oldest/newest items
- Find most/least expensive items
- Condition breakdown analysis

### User Interface Controls
- **More Info**: Display detailed item information
- **Edit Item**: Modify existing collectible data
- **Save Data**: Persist changes to storage
- **Sort Options**: Organize by ID, price, or year
- **Generate Stats**: Create statistical reports

##  Application Interface

The application features a clean, intuitive interface with:
- **Item List**: Displays all collectibles with basic information
- **Control Panel**: Bottom toolbar with all management functions
- **Selection Highlighting**: Visual feedback for selected items
- **Responsive Design**: Adapts to different screen sizes

##  Testing

The project includes comprehensive testing:
- **Unit Tests**: Individual component testing
- **Integration Tests**: System-wide functionality testing
- **Edge Case Testing**: Empty collections, invalid inputs, large datasets
- **JUnit Framework**: Automated test execution

##  Future Enhancements

- Database integration for improved data persistence
- Advanced search and filtering capabilities
- Export functionality for reports
- Multi-user support with authentication
- Cloud synchronization features

##  Contributing

1. Fork the repository
2. Create a feature branch (git checkout -b feature/AmazingFeature)
3. Commit your changes (git commit -m 'Add some AmazingFeature')
4. Push to the branch (git push origin feature/AmazingFeature)
5. Open a Pull Request

##  License

This project is part of academic coursework and is available for educational purposes.

##  Author

**Syeda Mariam Danish**
- GitHub: [@SMariamD](https://github.com/SMariamD)
- Email: syedamariamdanish2020@gmail.com

##  Acknowledgments

- Heriot-Watt University for academic guidance
- JavaFX community for documentation and support
- Open source contributors for inspiration and best practices
