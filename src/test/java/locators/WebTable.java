package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.className;

public class WebTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        sleep(3000);
        if (driver != null) {
            // close all tabs and windows
            driver.quit();
            // close current tab
            // driver.close()
        }
    }

    @Test
    public void testWebTable() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php#");
        Thread.sleep(2000);

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the table
        WebElement table = driver.findElement(By.xpath("//div[@class='bd-example table-responsive']"));

        // Find all rows in the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Iterate through each row
        for (int i = 1; i < rows.size(); i++) {
            // Re-locate the table to get fresh elements
            table = driver.findElement(By.xpath("//div[@class='bd-example table-responsive']"));
            // Re-find all rows in the table
            rows = table.findElements(By.tagName("tr"));

            WebElement row = rows.get(i);
            // Extract data from each row
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String name = cells.get(0).getText();
            String age = cells.get(1).getText();
            String email = cells.get(3).getText();
            String salary = cells.get(4).getText();
            String department = cells.get(5).getText();

            // Perform assertions or validations based on the extracted data
            System.out.println("Name: " + name + ", Age: " + age + ", Email: " + email + ", Salary: " + salary + ", Department: " + department);

            // Click edit button and submit
            WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//td[7]/a[1]//*[name()='svg']")));
            editButton.click();
            WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Submit']")));
            submitButton.click();

            // Click delete button
            WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//td[7]/a[2]//*[name()='svg']")));
            deleteButton.click();
        }

        // Click add button and assert registration form
        WebElement addButton = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
        addButton.click();
        WebElement registrationForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='staticBackdropLive']//div[@class='modal-content']")));
        Assert.assertTrue(registrationForm.isDisplayed());
    }
}