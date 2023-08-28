import org.testng.annotations.Test;
import pages.IndexPage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginProcessTest extends SetUp {

    @Test
    public void loginProcessTest () throws InterruptedException {
        IndexPage indexPage = new IndexPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String expected_result = "Your account";

        indexPage.hoverUserAccountButton();
        indexPage.clickOnLoginButton();
        loginPage.insertEmailAddressIntoEmailField("sartozalte@gufum.com");
        loginPage.insertPasswordIntoPasswordField("sartozalte");
        loginPage.clickOnLoginButton();

    }
}
