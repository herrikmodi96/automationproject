package com.qa.hmautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/Resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file://" + System.getProperty("user.dir") + "/src/Resources/QE-index.html");
    }

    @Test(priority = 1)
    public void testUserAuthentication() {
        

        WebElement emailInput = driver.findElement(By.id("inputEmail"));
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));

        Assert.assertTrue(emailInput.isDisplayed() && passwordInput.isDisplayed() && loginButton.isDisplayed(),
                "Email and password inputs along with login button are not present.");

        emailInput.sendKeys("test@example.com");
        passwordInput.sendKeys("password");
        loginButton.click();

        // Pass message
        System.out.println("Test 1 - User Authentication: Passed");
    }

    @Test(priority = 2)
    public void testListGroupValidation() {
        
        WebElement listGroup = driver.findElement(By.xpath("//div[@id='test-2-div']/ul[1]"));
        java.util.List<WebElement> listItems = listGroup.findElements(By.tagName("li"));

        Assert.assertEquals(listItems.size(), 3, "Incorrect number of list items.");
        

        WebElement secondListItem = driver.findElement(By.xpath("//div[@id='test-2-div']/ul[1]/li[2]"));
        String actualtext=secondListItem.getText();
        //System.out.println(actualtext);
        String expectedtText="List Item 2";
    
        Assert.assertTrue(actualtext.contains(expectedtText), "Second list item's value is incorrect.");

        WebElement badge = secondListItem.findElement(By.xpath("//span[contains(text(),'6')]"));
        Assert.assertEquals(badge.getText(), "6", "Second list item's badge value is incorrect.");
    }

    @Test(priority = 3)
    public void testSelectOptionFunctionality() {
        
        WebElement dropdownButton = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
        Assert.assertEquals(dropdownButton.getText(), "Option 1", "Default selected value is not 'Option 1'.");
        
        dropdownButton.click();
        WebElement option3 = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[contains(text(),'Option 3')]"));
        option3.click();
        
        Assert.assertEquals(dropdownButton.getText(), "Option 3", "Selected value is not 'Option 3'.");
    }

    @Test(priority = 4)
    public void testButtonStateValidation() {
        
        WebElement firstButton = driver.findElement(By.xpath("//div[@id='test-4-div']//button[@class='btn btn-lg btn-primary']"));
        WebElement secondButton = driver.findElement(By.xpath("//div[@id='test-4-div']//button[@class='btn btn-lg btn-secondary']"));

        Assert.assertTrue(firstButton.isEnabled(), "The first button is not enabled.");
        Assert.assertFalse(secondButton.isEnabled(), "The second button is not disabled.");
    }

    @Test(priority = 5)
    public void testButtonInteraction() {
        

        // Wait for the button to be displayed (with random delay)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement test5button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='test5-button']")));

        //WebElement test5button = driver.findElement(By.xpath("//button[@id='test5-button']"));
        test5button.click();

        WebElement successMessage = driver.findElement(By.id("test5-alert"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed after clicking the button.");
        Assert.assertFalse(test5button.isEnabled(), "The button is not disabled after clicking.");
    }

    @Test(priority = 6)
    public void testGridCellValueRetrieval() {
       
        String cellValue = getCellValue(2, 2);
        Assert.assertEquals(cellValue, "Ventosanzap", "Value of the cell at coordinates (2, 2) is not 'Ventosanzap'.");
    }

    private String getCellValue(int row, int column) {
        String xpath = String.format("//table/tbody/tr[%d]/td[%d]", row + 1, column + 1);
        WebElement cell = driver.findElement(By.xpath(xpath));
        return cell.getText();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
