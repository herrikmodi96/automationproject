# Introduction
This repository contains automation tests developed to fulfill a tech assignment's requirements. The project utilizes Maven, TestNG, Selenium WebDriver, and Java. The tests are executed in Visual Studio Code.

# Project Structure
- src/main/java: Contains the main Java source files.
- src/test/java: Contains the test Java source files.
- src/Resources: Contains the test HTML files and other resources.
- pom.xml: Maven configuration file.

# Dependencies
Ensure you have the following dependencies installed:

- Java Development Kit (JDK)
- Maven
- TestNG
- Selenium WebDriver
- ChromeDriver

# Setup
1. Clone the repository to your local machine.
2. Set up the project in your preferred Java IDE (e.g., Visual Studio Code, IntelliJ IDEA).
3. Configure the project with Maven and ensure all dependencies are resolved.
4. Download and configure the ChromeDriver according to your operating system.

# Implemented Methods
- @BeforeClass Method: This method initializes the WebDriver and sets up the test environment before each test execution. It maximizes the browser window and waits for 2 seconds.

- @AfterClass Method: This method quits the WebDriver instance and closes the browser after all tests are executed.

## Implemented Tests

## Test1 

- Navigate to the Home Page: Opens the web page in the browser, through @BeforeClass
- Assert Element Presence: Finds email input field, password input field and Login button through properly formatted selectors, and assert their presence through assertTrue Method of TetNG
- Enter Value in Email & Password field: Fills Email and password field through sendkeys method

## Test2- testListGroupValidation

- Navigate to the Home Page: Ensures the browser is on the home page
- Assert list items: After finding Group list element and the list items in it, This test will check if the list has 3 items,if the listgroup has less or more than 3 items in it, test will fail and show a failure message on console 
- Assert Value and Badge: Verifies second list item's value is 'List item 2' and second list item's badge value is 6

## Test3- testSelectOptionFunctionality

- Navigate to the Home Page: Ensures the browser is on the home page
- Assert default selection: After finding dropdown element, Test3 checks default value is Option 1, through assertEquals
- Select Option 3- After finding Option 3 element, it selects Options 3 and asserts that the selected value is Option 3

## Test4- testButtonStateValidation

- Navigate to the Home Page: Ensures the browser is on the home page
- Assert button states: After finding both button elements, Test4 checks if the first button is enabled and the second button is disabled

## Test5- testButtonInteraction

- Navigate to the Home Page: Ensures the browser is on the home page
- Wait for button display: Using WebdriverWait method, test assigns wait time of 20 seconds to wait variable. Using this wait variable, visibilityOfElementLocated method is used to wait for the button to appear until 20 seconds
- Click Button: clicks the button after it becomes visible
- Assert Success message: Checks if success message is displayed
- Assert Button State: confirms if the button is disabled

## Test6- testGridCellValueRetrieval
- Navigate to the Home Page: Ensures the browser is on the home page
- Value retrival method: getCellValue method, which is created to find value of any cell of grid format
- Value retrival: Utilizing getCellValue, retrives the value of the cell at coordinates (2,2)
- Assert Cell value: Asserts the vlaue of the cell at (2,2) is "Ventosanzap"

# Execution
Execute the test suite using TestNG. Make sure the ChromeDriver is properly configured and available in the system PATH.

# Testing Environment

Operating System: Mac OS
Browser: Google Chrome [123.0.6312.107]
Java Version: [22]
Chromedriver version: [123.0.6312.105]
