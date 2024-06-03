package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import static java.lang.Thread.sleep;

public class Radio_Buttons {

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
    public void radioButtons() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/radio-button.php");
        Thread.sleep(2000);

        // Waiting for the radio buttons to be clickable

        WebElement radioButtonYes = driver.findElement(By.xpath("//input[@value='igottwo']"));
        WebElement radioButtonImpressive = driver.findElement(By.xpath("//input[@value='igotthree']"));

        radioButtonYes.click();
        WebElement messageElement1 = driver.findElement(By.id("check"));
        Assert.assertTrue(messageElement1.isDisplayed(),"You have checked Yes");

        radioButtonImpressive.click();
        WebElement messageElement2 = driver.findElement(By.id("check1"));
        Assert.assertTrue(messageElement2.isDisplayed()," You have checked Impressive");
        // Closing the browser
        driver.quit();
    }


}


