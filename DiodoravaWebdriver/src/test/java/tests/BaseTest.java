package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.net.URL;

abstract public class BaseTest {
   protected WebDriver driver;

    @Before
    public void createDriver() {
        URL url = this.getClass().getClassLoader().getResource("drivers/geckodriver.exe");
        File file = new File(url.getFile());
        GeckoDriverService.Builder bldr = (new GeckoDriverService.Builder())
                .usingDriverExecutable(file)
                .usingAnyFreePort();

        driver = new FirefoxDriver(bldr.build());
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver(){
        driver.quit();
        driver = null;
    }
}
