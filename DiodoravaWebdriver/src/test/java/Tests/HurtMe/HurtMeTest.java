package Tests.HurtMe;
import PageObject.GoogleCalculator.CalculatorPage;
import PageObject.GoogleCalculator.GooglePage;
import PageObject.GoogleCalculator.ResultPage;
import PageObject.GoogleCalculator.SearchResultsPage;
import Tests.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class HurtMeTest extends BaseTest {
    private String textToSearch = "Google Cloud Platform Pricing Calculator";
    private String textToMachineClass = "Regular";
    private String textToMachineType = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private String textToDatacenterLocation = "Frankfurt (europe-west3)";
    private String textToLocalSSD = "2x375 GB";
    private String textToCommitedUsage = "1 Year";

    @Test
    public void fillCalculatorCheckSumAndFilledFields()  {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.goToPage();
        googlePage.clickOnIconSearch();
        SearchResultsPage searchResultsPage = googlePage.PasteTextInSearchField(textToSearch);
       CalculatorPage calculatorPage = searchResultsPage.goToCalculatorPage(textToSearch)
               .activateComputeEngine().pasteNumberOfInstance("4");

        ResultPage resultPage = calculatorPage.clearFieldInstancesFor()
                .chooseSoftware("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
                .chooseMachineClass(textToMachineClass)
                .chooseMachineType(textToMachineType)
                .tickAddGPUs().chooseNumberOfGPUs("1").chooseGPUType("NVIDIA Tesla V100")
                .chooseLocalSSD(textToLocalSSD).chooseDatacenterLocation(textToDatacenterLocation)
                .chooseCommitedUsage(textToCommitedUsage)
                .clickAddToEstimate();

        Assert.assertTrue("Machine Class is wrong", resultPage.isMachineClassTrue(textToMachineClass));
        Assert.assertTrue("Machine Type is wrong", resultPage.isMachineTypeTrue(textToMachineType));
        Assert.assertTrue("Datacenter Location is wrong", resultPage.isDatacenterLocationTrue(textToDatacenterLocation));
        Assert.assertTrue("Local SSD is wrong", resultPage.isLocalSSDTrue(textToLocalSSD));
        Assert.assertTrue("Commited usage is wrong", resultPage.isCommitedUsageTrue(textToCommitedUsage));
        Assert.assertTrue("Cost is wrong", resultPage.isCostTrue("1,082.77"));


       //выйти из фрэйма??


    }
}
