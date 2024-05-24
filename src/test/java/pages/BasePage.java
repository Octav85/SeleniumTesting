package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    By addToCartBagLocator = By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']");
    By cartLocator = By.className("shopping_cart_link");

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void waitElementIsLoaded () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBagLocator));
    }


    public void waitElementIsClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void isElementAppear(By locator, String message){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e){
            Assert.fail(message);
        }
    }
}


