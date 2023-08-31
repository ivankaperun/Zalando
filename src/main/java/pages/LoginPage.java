package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Constants.DEFAULT_TIMEOUT;

public class LoginPage extends BasePage {
    WebDriverWait wait;
    Actions actions = new Actions(driver);

    public LoginPage (WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    @FindBy (xpath = "//input[@id='login.email']")
    private WebElement emailInputField;

    @FindBy (xpath = "//input[@id='login.secret']")
    private WebElement passwordInputField;

    @FindBy (xpath = "//button[@data-testid='login_button']")
    private WebElement loginButton;

    @FindBy (xpath = "//button[@data-testid='user-account-icon']")
    private WebElement userAccountButton;


    public void insertEmailAddressIntoEmailField(String email) {
        emailInputField.sendKeys(email);
    }

    public void insertPasswordIntoPasswordField(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickOnLoginButton() throws InterruptedException {
        loginButton.click();
        waitUntilPageIsFullyLoaded(wait);
        //Thread.sleep(5000);
    }

}
