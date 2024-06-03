package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Checkbox {
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
    public void mainCheckboxes() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
        Thread.sleep(2000);
        WebElement checkbox1 = driver.findElement(By.cssSelector("#c_bs_1"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#c_bs_2"));
        assertFalse(checkbox1.isSelected(), "Checkbox 1 is initially selected");
        assertFalse(checkbox2.isSelected(), "Checkbox 2 is initially selected");
        WebElement plus1 = driver.findElement(By.xpath("(//span[@class='plus'])[1]"));
        plus1.click();
        WebElement plus2 = driver.findElement(By.xpath("//body/main/div[@class='container']/div[@class='row d-flex justify-content-center logindiv bg-white rounded']/div[@class='col-md-8 col-lg-8 col-xl-8']/div[@class='tree_main']/ul[@id='bs_main']/li[@id='bs_2']/span[1]"));
        plus2.click();
        checkbox1.click();
        checkbox2.click();
    }

    @Test
    public void subCheckbox1() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
        Thread.sleep(2000);
        WebElement checkbox1 = driver.findElement(By.cssSelector("#c_bs_1"));
        WebElement plus1 = driver.findElement(By.xpath("(//span[@class='plus'])[1]"));
        plus1.click();
        WebElement plusSubCheckbox = driver.findElement(By.cssSelector("li[id='bf_1'] span[class='plus']"));
        WebElement subLevel1 = driver.findElement(By.id("c_bf_1"));
        WebElement[] lastLevelCheckboxes = new WebElement[4];
        for (int i = 0; i < 4; i++) {
            lastLevelCheckboxes[i] = driver.findElement(By.id("c_io_" + (i + 1)));
        }
        plusSubCheckbox.click();
        subLevel1.click();
        assertTrue(subLevel1.isSelected(), "subLevel1 checkbox is not clicked");
        for (WebElement lastLevelCheckbox : lastLevelCheckboxes) {
            assertTrue(lastLevelCheckbox.isSelected(), "lastLevel checkbox is not clicked");
            subLevel1.click();
            assertFalse(subLevel1.isSelected(), "subLevel1 checkbox is still clicked");
            for (WebElement lastLevelCheckbox1 : lastLevelCheckboxes) {
                lastLevelCheckbox1.click();
                assertTrue(lastLevelCheckbox1.isSelected(), "lastLevel checkbox is not clicked");
            }
            assertTrue(subLevel1.isSelected(), "subLevel1 checkbox is not clicked when all lastLevel checkboxes are clicked");
        }
    }







}


