package PageObject.Pastebin;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(name = "paste_code")
    private WebElement pasteField;
    @FindBy(xpath = "//*[contains(text(),'Paste Expiration')]/..//b")
    private WebElement buttonOfChoiceExpiration;
    @FindBy(name = "paste_name")
    private WebElement pasteTitle;
    @FindBy(xpath = "//*[contains(text(), 'Syntax Highlighting')]/..//b")
    private WebElement buttonOfChoiceHighlighting;
    @FindBy(name="submit")
    private WebElement buttonCreateNewPaste;
    private String xpathPasteExpiration = "//li[contains(text(),'%s')]";
    private String xpathSyntaxHighlighting = "//li[contains(text(),'%s')]";


    public LoginPage(WebDriver driver) {
        super(driver);
        url = "https://pastebin.com";
    }

    public LoginPage enterNewPasteCode(String code){
        pasteField.sendKeys(code);
        return this;
    }

    public LoginPage choosePasteExpiration(String choice) {
        buttonOfChoiceExpiration.click();
        String fullName =String.format(xpathPasteExpiration, choice);
        driver.findElement(By.xpath(fullName)).click();
        return this;
    }

    public LoginPage chooseTitle(String text) {
        pasteTitle.sendKeys(text);
        return this;
    }

    public LoginPage chooseSyntaxHighlighting(String choice) {
        buttonOfChoiceHighlighting.click();
        String fullName =String.format(xpathSyntaxHighlighting, choice);
        driver.findElement(By.xpath(fullName)).click();
        return this;
    }

    public MainPage clickCreateNewPast() {
        buttonCreateNewPaste.click();
        return new MainPage(driver);
    }
}

