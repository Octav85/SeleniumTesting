package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.random.RandomGenerator;

import static java.lang.Thread.sleep;

public class Forms {
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
    public void forms() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000);

        WebElement firstName = driver.findElement(By.id("name"));
        firstName.sendKeys("Alessandro");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("alssesandro@mail.com");

        WebElement genderMale = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        genderMale.click();

        WebElement mobile = driver.findElement(By.id("mobile"));
        mobile.sendKeys("64124121");

        WebElement birthday = driver.findElement(By.id("dob"));
        birthday.sendKeys("28.05.2005");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate enteredDate = LocalDate.parse("01.01.2005", formatter); // Example birthday value
        // Calculate age
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.minusYears(enteredDate.getYear()).getYear();
        if (age < 18) {
            System.out.println("You are below 18 years old.");
        } else {
            System.out.println("You are 18 years old or older.");
        }

        WebElement subjects = driver.findElement(By.id("subjects"));
        subjects.sendKeys("Subject");

        WebElement hobbies = driver.findElement(By.id("hobbies"));
        Assert.assertFalse(hobbies.isSelected(), "Radio button should not be selected before clicking.");
        hobbies.click();

        WebElement pictureInput = driver.findElement(By.xpath("//input[@id='picture']"));
        pictureInput.sendKeys("C:\\Users\\oplopa\\Desktop\\haha");

        WebElement address = driver.findElement(By.xpath("//textarea[@id='picture']"));
        address.sendKeys(" Apple Street 13");

        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickableState = wait.until(ExpectedConditions.elementToBeClickable(state));

        WebElement dropdownOption = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='Rajasthan']")));
        dropdownOption.click();

        WebElement city = driver.findElement(By.xpath("//select[@id='city']"));
        WebElement clickableCity = wait.until(ExpectedConditions.elementToBeClickable(city));
        city.click();
        WebElement cityOptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='Agra']")));
        cityOptions.click();

        WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
// Wait for the login element to be clickable
        WebElement clickableLogin = wait.until(ExpectedConditions.elementToBeClickable(login));
        clickableLogin.click();
    }
}
