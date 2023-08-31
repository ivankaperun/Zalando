import org.testng.annotations.Test;
import pages.IndexPage;
import pages.LoginPage;


public class LoginProcessTest extends SetUp {

    @Test
    public void loginProcessTest () {
        IndexPage indexPage = new IndexPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        indexPage.hoverUserAccountButton();
        indexPage.clickOnLoginButton();
        loginPage.insertEmailAddressIntoEmailField("sartozalte@gufum.com");
        loginPage.insertPasswordIntoPasswordField("sartozalte");
        loginPage.clickOnLoginButton();

    }
}
