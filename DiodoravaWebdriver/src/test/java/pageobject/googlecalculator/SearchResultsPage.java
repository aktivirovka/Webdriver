package pageobject.googlecalculator;

import pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private String xpathTextToSearch = "//*[@class='gs-title']//*[contains(text(),'%s')]";

    public CalculatorPage goToCalculatorPage(String textToSearch) {
        String fullName = String.format(xpathTextToSearch, textToSearch);
        new WebDriverWait(driver, 25)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fullName)));
        driver.findElement(By.xpath(fullName)).click();
        return new CalculatorPage(driver);
    }
}

