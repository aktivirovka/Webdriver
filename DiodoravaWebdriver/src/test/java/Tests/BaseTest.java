package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.net.URL;

abstract public class BaseTest {
   protected WebDriver driver;

    @Before
    public void createDriver() {
        //driver = new FirefoxDriver();
        //driver.manage().window().maximize();

        URL url = this.getClass().getClassLoader().getResource("drivers/geckodriver.exe");
        File file = new File(url.getFile()); // Strangely, URL.getFile does not return a File
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
