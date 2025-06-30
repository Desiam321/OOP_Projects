# Object-Oriented Programming (OOP) Project Collection

## Overview

This repository contains a comprehensive collection of Java programming exercises designed to demonstrate fundamental Object-Oriented Programming concepts. The project consists of six distinct modules, each focusing on different aspects of OOP design patterns, data structures, and practical applications.

## Project Structure

```
oop-a/
├── src/
│   ├── TheGoldenBucket/        # Restaurant management system (Basic OOP)
│   ├── TheGoldenBucket2/       # Enhanced restaurant system with linked lists
│   ├── CrazyStation/           # Train station management system
│   ├── CrazyStation2/          # Advanced train system with inheritance
│   ├── NeedForSpeed/           # Racing simulation with polymorphism
│   ├── Titanic/                # Data analysis of Titanic passenger data
│   └── PStA/                   # Project documentation (PDF files)
└── README.md
```

## Module Descriptions

### 1. TheGoldenBucket 🍽️
**Concepts:** Basic OOP, Classes, Objects, Methods

A restaurant management system that demonstrates fundamental OOP concepts through:
- **Customer**: Customer information management
- **Employee**: Staff management with roles (Waiter, Cook)
- **Order**: Order processing for food and drinks
- **Reservation**: Table reservation system
- **Food & Drink**: Menu item management with pricing

**Key Features:**
- Order management with automatic price calculation
- Customer reservation system
- Employee role assignment
- Menu item categorization

### 2. TheGoldenBucket2 🍽️➕
**Concepts:** Advanced OOP, Custom Data Structures, Linked Lists

An enhanced version of the restaurant system featuring:
- **LinkedList Implementation**: Custom linked list data structure
- **Catalogue**: Menu management system
- **Enhanced Order System**: More sophisticated ordering capabilities
- **Person**: Base class demonstrating inheritance

**Key Features:**
- Custom linked list implementation with full CRUD operations
- Menu catalogue system
- Enhanced customer and employee management
- Comprehensive test suite

### 3. CrazyStation 🚂
**Concepts:** Collections, Generic Programming, Complex Object Relationships

A train station management system that includes:
- **Station**: Regular train stations
- **CentralStation**: Hub stations with multiple train connections
- **Train**: Train objects with route management
- **Car**: Individual train cars with destinations
- **List & ListImpl**: Custom generic list implementation

**Key Features:**
- Multi-station train network simulation
- Car routing and destination management
- Custom generic list implementation
- Station-to-station transportation logic

### 4. CrazyStation2 🚂🔧
**Concepts:** Inheritance, Polymorphism, Package Organization

Advanced train system with hierarchical design:
- **Train Hierarchy**: 
  - `ElectricLocomotive`
  - `SteamLocomotive` 
  - `FreightTrain`
- **Car Specialization**:
  - `FoodCar`
  - `MaterialCar`
  - `ProductCar`
- **TrainRental**: Business logic implementation

**Key Features:**
- Multiple train types with specific characteristics
- Specialized car types for different cargo
- Train rental business simulation
- Comprehensive inheritance hierarchy

### 5. NeedForSpeed 🏎️
**Concepts:** Polymorphism, Interfaces, Racing Simulation

A racing simulation system featuring:
- **Vehicle Hierarchy**: Cars, Trucks, Motorcycles
- **Human Participants**: Cyclists, Cavaliers
- **Racing System**: Multiple race types and conditions
- **Handicap System**: Performance modification system

**Key Features:**
- Multiple vehicle types with unique characteristics
- Different race formats (drag race, flying start, normal race)
- Distance and time-based competitions
- Performance handicap system
- Polymorphic race participant handling

### 6. Titanic 🚢
**Concepts:** Data Analysis, File I/O, Collections, Statistical Methods

Historical data analysis of Titanic passengers:
- **TitanicAnalyse**: Main analysis engine with statistical methods
- **TitanicStatistics**: Data loading and processing utilities
- **Ticket**: Passenger ticket information model
- **CSV Data Processing**: Real historical passenger data

**Key Features:**
- Statistical analysis of passenger data
- Surname and age frequency analysis
- Survival rate calculations by various demographics
- File I/O operations with CSV data
- HashMap-based data aggregation

## Technical Highlights

### Design Patterns Used
- **Template Method Pattern**: In racing system
- **Strategy Pattern**: Different race types
- **Factory Pattern**: Object creation in various modules
- **Observer Pattern**: Event handling in train systems

### Data Structures Implemented
- **Custom Linked Lists**: Generic implementation with full functionality
- **Generic Lists**: Type-safe collections
- **HashMaps**: For statistical analysis and data aggregation
- **LinkedLists**: Java standard library usage

### OOP Principles Demonstrated
- **Encapsulation**: Private fields with public accessors
- **Inheritance**: Hierarchical class structures
- **Polymorphism**: Interface implementations and method overriding
- **Abstraction**: Abstract classes and interfaces

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Running the Projects

Each module contains a main class that can be executed independently:

```bash
# Navigate to the project directory
cd oop-a/src

# Compile and run individual modules
javac TheGoldenBucket/*.java
java TheGoldenBucket.TheGoldenBucketRestaurant

javac CrazyStation/*.java
java CrazyStation.CrazyStation

javac NeedForSpeed/*.java
java NeedForSpeed.NeedForSpeed

# And so on for other modules...
```

### Testing

Several modules include test classes:
- `ListImplTest.java` - Tests for custom list implementation
- `LinkedListImpTest.java` - Tests for linked list implementation
- `TitanicAnalysenTest.java` - Tests for Titanic analysis methods

Run tests using your IDE's test runner or compile and execute manually.

## Learning Objectives

This project collection is designed to teach and demonstrate:

1. **Fundamental OOP Concepts**: Classes, objects, methods, constructors
2. **Advanced OOP Principles**: Inheritance, polymorphism, encapsulation, abstraction
3. **Data Structure Implementation**: Custom lists, linked lists, generic programming
4. **Design Patterns**: Common software design patterns
5. **Real-world Applications**: Restaurant management, transportation systems, racing simulation
6. **Data Analysis**: Statistical methods, file I/O, data processing
7. **Testing**: Unit testing and test-driven development concepts

## Documentation

Detailed project specifications and requirements can be found in the PDF files located in the `src/PStA/` directory:

- `PStA - 01 The golden Bucket EN.pdf`
- `PStA - 02 CrazyStation.pdf`
- `PStA - 03 TheGoldenBucket2.pdf`
- `PStA - 04 CrazyStation2.pdf`
- `PStA - 05 Titanic EN.pdf`
- `PStA - 06 NeedForSpeed.pdf`



---

**Note**: This project demonstrates progressive complexity in OOP concepts, starting from basic class design to advanced polymorphism and data analysis. Each module builds upon concepts from previous modules while introducing new programming paradigms.
