package pageobject.pastebin;

import pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='content_left']//h1")
    private WebElement xpahtTitle;
    @FindBy(id ="paste_code")
    private WebElement xpathPassedCode;
    private String xpathSyntax = "//*[@id=\"code_buttons\"]//a[contains(text(),'%s')]";

    public boolean isTitleTrue(String title) {
         new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(xpahtTitle));
        return xpahtTitle.getText().equals(title);
    }

    public boolean isSyntaxTrue(String syntax) {
        String fullName = String.format(xpathSyntax, syntax);
        WebElement xpathWebSyntax = driver.findElement(By.xpath(fullName));
        return xpathWebSyntax.getText().equals(syntax);
    }

    public boolean isPastedCodeTrue(String passedCode) {
        return xpathPassedCode.getText().equals(passedCode);
    }
}
