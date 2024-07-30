## Overview

The `intassign` project is a multi-module Maven project designed for integration testing and automation. It leverages various tools and libraries for testing, reporting, and browser automation.

## Prerequisites

Ensure you have the following software installed:

- **Java Development Kit (JDK)** 17 or higher
- **Apache Maven** 3.6 or higher

## Getting Started

##Building the Project
To build the project, navigate to the root directory of the project and run:

mvn clean install

##Running Tests:
To build the project, navigate to the root directory of the project and run:
mvn clean test



Dependencies:-
The project includes various dependencies essential for testing and automation:

JUnit: Testing framework (version 4.11)
ExtentReports: Reporting library (version 4.1.4)
Cucumber: BDD testing library (version 7.18.0)
Selenium: Browser automation (version 4.21.0)
TestNG: Testing framework (version 6.8.8)
Log4j: Logging framework (version 2.14.1)
Apache POI: Handling Excel files (version 3.17)
WebDriverManager: Manages browser drivers (version 5.8.0)
OpenCSV: Handling CSV files (version 4.1)


Modules
The project consists of the following modules:

automation-framework: Core automation framework
core-product-tests: Tests for the core product
derived-product1-tests: Tests for derived product 1
derived-product2-tests: Tests for derived product 2
