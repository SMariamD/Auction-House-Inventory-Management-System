# Auction House Inventory Management System

> **F20-21SF Coursework Project**  
> **Author:** Syeda Mariam Danish

A comprehensive Java and JavaFX application designed to manage auction house inventories featuring various collectibles. The system provides a user-friendly interface with multiple functionalities for inventory management, statistical analysis, and data persistence.

##  Application Screenshot

![Auction House Inventory Management System](full%20ui%20window.PNG)

*The main interface showing the Collectibles Inventory management system with various collectible items and control buttons.*

##  Features

- **Multi-Collectible Support**: Manage books, jewelry, cars, paintings, and other collectibles
- **Interactive GUI**: User-friendly JavaFX interface with intuitive controls
- **Data Management**: Add, edit, and save collectible information
- **Statistical Analysis**: Generate comprehensive statistics and reports
- **Sorting Capabilities**: Sort items by ID, price, or year
- **Data Persistence**: Save and load inventory data
- **Error Handling**: Robust validation and error management

##  Technologies Used

- **Java** - Core programming language
- **JavaFX** - GUI framework
- **MVC Architecture** - Model-View-Controller pattern
- **CSV Processing** - Data import/export functionality
- **UML Design** - Object-oriented design principles

##  Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- JavaFX runtime environment
- IDE (Eclipse, IntelliJ IDEA, or NetBeans)

### Installation

1. **Fork** the project to your personal space
2. **Clone** the repository to your local machine:
   `ash
   git clone https://github.com/SMariamD/Auction-House-Inventory-Management-System.git
   `
3. **Open** the project in your preferred IDE
4. **Configure** JavaFX in your IDE
5. **Run** the main application class

##  Project Structure

`
Auction-House-Inventory-Management-System/
 AuctionHouse/                 # Main application source code
 Files for Stage 2/           # CSV data files and resources
 Stage UML Diagrams/          # UML documentation
 full ui window.PNG           # Application screenshot
 Stage_1_Diagram.drawio.png   # UML diagram
 README.md                    # Project documentation
 .gitignore                   # Git ignore file
`

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
