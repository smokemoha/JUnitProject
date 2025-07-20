# Java JUnit Testing Portfolio Project

This project serves as a practical demonstration of Java development combined with comprehensive unit and integration testing using JUnit 5 and Mockito. It's designed to showcase robust testing practices and clean code, making it an ideal addition to a developer's portfolio.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Building the Project](#building-the-project)
  - [Running the Application](#running-the-application)
- [Testing Strategy](#testing-strategy)
  - [Running Tests](#running-tests)
  - [Code Coverage](#code-coverage)
- [Project Structure](#project-structure)
- [Contribution](#contribution)
- [License](#license)




## Project Overview

This project implements a set of simple utility classes in Java, including a `Calculator`, a `BankAccount` management system, and `StringUtils` for common string operations. The primary focus of this project is to demonstrate the effective use of JUnit 5 for unit testing and Mockito for mocking dependencies, ensuring high code quality and reliability. It also includes configuration for Maven Surefire Plugin for test execution and JaCoCo for code coverage reporting.




## Features

### Calculator
- Basic arithmetic operations: addition, subtraction, multiplication, and division.
- Handles division by zero gracefully with an `IllegalArgumentException`.

### BankAccount
- Account creation with initial balance and account number validation.
- Deposit and withdrawal functionalities with input validation.
- Tracks account activity status (active/closed).
- Throws `IllegalStateException` for operations on closed accounts and `IllegalArgumentException` for invalid amounts or insufficient funds.

### StringUtils
- `isPalindrome`: Checks if a given string is a palindrome, ignoring case and non-alphanumeric characters.
- `reverse`: Reverses a given string.
- `countWords`: Counts the number of words in a string.
- `capitalize`: Capitalizes the first letter of a string and converts the rest to lowercase.
- `findCommonWords`: Finds common words between two strings (case-insensitive).

### TransactionService
- Demonstrates fund transfer logic between accounts.
- Utilizes Mockito for testing interactions with the `BankAccount` dependency, showcasing how to test complex logic with external dependencies.




## Technologies Used

- **Java 11+**: The core programming language.
- **Maven**: Project management and build automation tool.
- **JUnit 5**: The testing framework for writing unit and integration tests.
- **Mockito**: A mocking framework for Java, used for isolating unit tests by creating mock objects.
- **JaCoCo**: A code coverage library for Java, integrated with Maven to generate test coverage reports.




## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Apache Maven 3.6.3 or higher

### Building the Project

Navigate to the root directory of the project (`JUnitProject`) and run the following Maven command to build the project:

```bash
mvn clean install
```

This command compiles the source code, runs the tests, and packages the application into a JAR file.

### Running the Application

To run the main application (which demonstrates the usage of `Calculator`, `BankAccount`, and `StringUtils`):

```bash
mvn exec:java -Dexec.mainClass="com.example.junit.App"
```




## Testing Strategy

This project emphasizes a robust testing strategy using JUnit 5 for unit and integration tests, and Mockito for effective mocking of dependencies.

### Unit Tests

- **CalculatorTest.java**: Contains unit tests for all arithmetic operations, including edge cases like division by zero.
- **BankAccountTest.java**: Tests account creation, deposit, withdrawal, and account status changes, covering various valid and invalid scenarios.
- **StringUtilsTest.java**: Comprehensive tests for string utility methods, including palindrome checks, string reversal, word counting, and capitalization, with nested test classes for better organization.

### Mocking with Mockito

- **TransactionServiceTest.java**: Demonstrates how to use Mockito to mock the `BankAccount` dependency. This allows for isolated testing of the `TransactionService` logic without relying on a real `BankAccount` instance, ensuring that tests are fast, reliable, and focused.

### Running Tests

To run all tests, navigate to the project root and execute:

```bash
mvn test
```

### Code Coverage

Code coverage reports are generated using JaCoCo. After running `mvn test`, you can find the detailed coverage report at:

`target/site/jacoco/index.html`

This report provides insights into which parts of the code are covered by tests, helping to identify areas that might need more testing.




## Project Structure

```
JUnitProject
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │       └── com
│   │           └── example
│   │               └── junit
│   │                   ├── App.java
│   │                   ├── BankAccount.java
│   │                   ├── Calculator.java
│   │                   ├── StringUtils.java
│   │                   └── TransactionService.java
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── junit
│                       ├── BankAccountTest.java
│                       ├── CalculatorTest.java
│                       ├── StringUtilsTest.java
│                       └── TransactionServiceTest.java
└── target
    └── site
        └── jacoco
            └── index.html (Generated after running tests with JaCoCo)
```




## Contribution

Feel free to fork this repository, submit pull requests, or open issues for any improvements or suggestions.

## License

This project is open-source and available under the [MIT License](LICENSE).




## Static Analysis with SpotBugs

To further enhance code quality and identify potential vulnerabilities, this project integrates **SpotBugs**, a static analysis tool for Java. SpotBugs analyzes compiled Java bytecode to find common kinds of programming errors, including potential security flaws, performance issues, and bad practices.

### Running SpotBugs Analysis

To run SpotBugs analysis, navigate to the project root and execute:

```bash
mvn spotbugs:check
```

This command will run the analysis and report any identified issues. By default, the build will not fail on warnings or errors from SpotBugs, allowing for continuous integration even with minor issues. For a more detailed report, you can run:

```bash
mvn spotbugs:spotbugs
```

This will generate an HTML report located at `target/site/spotbugs.html`.

### Benefits of Static Analysis for Security

Integrating static analysis tools like SpotBugs into the development workflow offers several security benefits:

-   **Early Detection**: Identifies potential security vulnerabilities and coding errors early in the development cycle, reducing the cost and effort of fixing them later.
-   **Automated Review**: Automates the process of code review for common pitfalls, ensuring consistent application of coding standards and security best practices.
-   **Improved Code Quality**: Helps enforce coding standards, leading to more maintainable, reliable, and secure code.
-   **Compliance**: Assists in meeting compliance requirements by systematically checking for known vulnerability patterns.
-   **Developer Education**: Provides immediate feedback to developers on potential issues, fostering a deeper understanding of secure coding practices.

By incorporating SpotBugs, this project demonstrates a commitment to building not just functional, but also secure and high-quality software.



