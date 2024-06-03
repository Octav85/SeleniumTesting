package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Buttons {
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
    public void buttons() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");
        Thread.sleep(2000);

        WebElement clickMe = driver.findElement(By.xpath("//button[normalize-space()='Click Me']"));
        WebElement rightClick = driver.findElement(By.xpath("//button[normalize-space()='Right Click Me']"));
        WebElement doubleClick = driver.findElement(By.xpath("//button[normalize-space()='Double Click Me']"));

        clickMe.click();
        WebElement clickMessage = driver.findElement(By.xpath("//div[@id='welcomeDiv']"));
        Assert.assertTrue(clickMessage.isDisplayed(),"You have done a dynamic click");

        Actions actions = new Actions(driver);
        actions.contextClick(rightClick).build().perform();
        actions.doubleClick(doubleClick).build().perform();

    }
}
