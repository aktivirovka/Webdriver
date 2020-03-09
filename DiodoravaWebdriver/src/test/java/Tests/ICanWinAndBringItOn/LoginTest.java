package Tests.ICanWinAndBringItOn;

import PageObject.Pastebin.LoginPage;
import PageObject.Pastebin.MainPage;
import Tests.BaseTest;
import com.sun.org.glassfish.gmbal.Description;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {
private String pastedCode = "git config --global user.name  \"New Sheriff in Town\"\n" +
        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
        "git push origin master --force";
private String title = "how to gain dominance among developers";
private String syntaxHighlighting = "Bash";

    @Test
    @Description(value = "ICanWin")
    public void createNewPasteWithCodePasteExpirationAndTitle() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToPage();
        MainPage mainPage = loginPage.enterNewPasteCode("Hello from WebDriver")
                .choosePasteExpiration("10 Minutes").chooseTitle("helloweb").clickCreateNewPast();
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
    @Test
    @Description(value = "BringItOn")
    public void saveNewPasteWithCodePasteExpirationSyntaxTitleAndCheckThem(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToPage();
        MainPage mainPage = loginPage.enterNewPasteCode(pastedCode)
                .chooseSyntaxHighlighting(syntaxHighlighting).choosePasteExpiration("10 Minutes")
                .chooseTitle(title).clickCreateNewPast();
       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Assert.assertTrue("Title is wrong", mainPage.isTitleTrue(title));
        Assert.assertTrue("Syntax is wrong", mainPage.isSyntaxTrue(syntaxHighlighting));
        Assert.assertTrue("Code isn't right", mainPage.isPastedCodeTrue(pastedCode));
    }
}
