package PageObject.GoogleCalculator;

import PageObject.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class TimeSite extends BasePage {
    public TimeSite(WebDriver driver) {
        super(driver);
        url = "https://10minutemail.com";
    }

    @FindBy(className = "copy_icon")
    private WebElement copyEmailAddress;

    @FindBy(xpath = "//span[@class='small_message_icon']")
    private WebElement getMessage;

    @FindBy(id = "mail_address")
    private WebElement mailAddress;

    @FindBy(xpath = "//*[contains(text(), 'USD')]")
    private WebElement xpathTotalCost;

    static JavascriptExecutor executor;
    static ArrayList<String> allTabs;

    public TimeSite openNewTab() {
        executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open();");
        allTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(allTabs.get(1));
        driver.get(url);
        /*String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(By.linkText(url)).sendKeys(selectLinkOpeninNewTab);
        String selectLinkOpeninNewTab2 = Keys.chord(Keys.CONTROL,"t");
        driver.findElement(By.linkText("https://10minutemail.com")).sendKeys(selectLinkOpeninNewTab2);
*/
        return this;
    }


    public String copyEmailAddress() throws IOException, UnsupportedFlavorException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) driver).executeScript(
                "return document.readyState"
        ).equals("complete"));// не успевает появиться адрес
          // не работает при входе во фрейм в CalculatorPage

        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(copyEmailAddress));

        copyEmailAddress.click();
        return (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);//вставляет из буфера текст
    }


    public void getMessage() {
        driver.switchTo().window(allTabs.get(1));
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='small_message_icon']")));
        getMessage.click();
    }

    public boolean isCostTrue(String totalCost) {
        String textFromXpath = xpathTotalCost.getText();
        String[] arrayWords = textFromXpath.split("USD", 2);
        return arrayWords[1].trim().equals(totalCost);
    }
}
