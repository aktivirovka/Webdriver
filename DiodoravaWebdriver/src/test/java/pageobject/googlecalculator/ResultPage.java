package pageobject.googlecalculator;

import pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends BasePage {
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id ='compute']//*[contains(text(), 'VM class:')]")
    private WebElement xpathMachineClass;
    @FindBy(xpath = "//*[@id ='compute']//*[contains(text(), 'Instance type:')]")
    private WebElement xpathMachineTypo;
    @FindBy(xpath = "//*[@id ='compute']//*[contains(text(), 'Region:')]")
    private WebElement xpathDatacenterLocation;
    @FindBy(xpath = "//*[@id ='compute']//*[contains(text(), 'local SSD')]")
    private WebElement xpathLocalSSD;
    @FindBy(xpath = "//*[@id ='compute']//*[contains(text(), 'Commitment term:')]")
    private WebElement xpathCommitedUsage;
    @FindBy(xpath = "//*[@id ='compute']//*[contains(text(), 'Estimated Component Cost:')]")
    private WebElement xpathCost;
    @FindBy(id = "email_quote")
    private WebElement buttonEmailEstimate;

    public FillEmailPage clickEmailEstimate() {
        buttonEmailEstimate.click();
        return new FillEmailPage(driver);
    }

    public boolean isMachineClassTrue(String choice) {
        String textFromXpath = xpathMachineClass.getText();
        String[] arrayWords = textFromXpath.split(":", 2);
        return arrayWords[1].trim().equals(choice.toLowerCase());
    }

    public boolean isMachineTypeTrue(String choice) {
        String textFromXpath = xpathMachineTypo.getText();
        String[] arrayWords = textFromXpath.split(":", 2);
        String[] choiceSplit = choice.split(" ", 2);
        return arrayWords[1].trim().equals(choiceSplit[0]);
    }

    public boolean isDatacenterLocationTrue(String choice) {
        String textFromXpath = xpathDatacenterLocation.getText();
        String[] arrayWords = textFromXpath.split(":", 2);
        String[] choiceSplit = choice.split(" ", 2);
        return arrayWords[1].trim().equals(choiceSplit[0]);

    }

    public boolean isLocalSSDTrue(String choice) {
        String textFromXpath = xpathLocalSSD.getText();
        String[] arrayWords = textFromXpath.split("space", 2);
        return arrayWords[1].trim().equals(choice);
    }

    public boolean isCommitedUsageTrue(String choice) {
        String textFromXpath = xpathCommitedUsage.getText();
        String[] arrayWords = textFromXpath.split(":", 2);
        return arrayWords[1].trim().equals(choice);

    }

    public boolean isCostTrue(String sum) {
        String textFromXpath = xpathCost.getText();
        String[] arrayWords = textFromXpath.split("USD", 2);
        String[] arrayWordsForCost = arrayWords[1].trim().split(" ", 2);
        return arrayWordsForCost[0].equals(sum);
    }
}
