package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


    public class BaseTest {
        WebDriver driver;

        @BeforeMethod
        public void setUpDriver(){
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            if(driver!= null){
                driver.quit();
            }
        }
    }

