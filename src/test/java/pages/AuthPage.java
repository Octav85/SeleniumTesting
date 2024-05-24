package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPage {
    WebDriver driver;
    String url = "https://www.saucedemo.com/";

    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginLocator = By.id("login-button");
    public AuthPage(WebDriver webDriver){
        driver = webDriver;
    }

    public AuthPage open(){
        driver.get(url);
        return this;
    }

    public AuthPage waitPageIsLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameLocator));
        return this;
    }

    public AuthPage enterUsername(String username){
        WebElement usernameFld = driver.findElement(usernameLocator);
        usernameFld.clear();
        usernameFld.sendKeys(username);
        return this;
    }

    public AuthPage enterPassword(String password){
        WebElement passwordFld = driver.findElement(passwordLocator);
        passwordFld.clear();
        passwordFld.sendKeys(password);
        return this;
    }

    public InventoryPage clickToLogin(){
        driver.findElement(loginLocator).click();
        return this.clickToLogin();
    }
}
