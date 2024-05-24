package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{


    // Locators
    By bagItemLocator = By.id("item_4_title_link");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
    }

    public void isBagIsPresent(){
        isElementAppear(bagItemLocator, "Item is not present in the cart");
    }

}