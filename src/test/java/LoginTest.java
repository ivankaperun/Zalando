import Listeners.Retry;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class LoginTest extends SetUp {
    @Test(retryAnalyzer = Retry.class)
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        LoginPage loginPage = new LoginPage();
        String expected_result = "authenticate";

        loginPage.goToLoginProcess();
        loginPage.setLoginUsername(username);
        loginPage.setLoginPassword(password);
        loginPage.doLogIn();
        String actual_result = loginPage.verifyLoginProcess();
        assertFalse(actual_result.contains(expected_result));
    }
}
