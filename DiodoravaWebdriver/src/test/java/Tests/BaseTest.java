package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

abstract public class BaseTest {
   protected WebDriver driver;

    @Before
    public void createDriver() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver(){
        driver.quit();
        driver = null;
    }
}
