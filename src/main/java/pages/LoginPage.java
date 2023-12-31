package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public LoginPage() {}

    private SelenideElement accountIcon = $x("//button[@data-testid='user-account-icon']");
    private SelenideElement loginButton = $x("//a[@href='/login/']");
    private SelenideElement loginEmail =$x("//input[@id='login.email']");
    private SelenideElement loginPassword = $x("//input[@id='login.secret']");
    private SelenideElement logIn = $x("//button[@data-testid='login_button']");

    public void goToLoginProcess() {
        accountIcon.shouldBe(Condition.visible);
        actions().moveToElement(accountIcon).perform();
        loginButton.shouldBe(Condition.visible);
        actions().moveToElement(loginButton).click().perform();
    }
    public void setLoginUsername(String username) {
        loginEmail.shouldBe(Condition.visible).sendKeys(username);
    }
    public void setLoginPassword(String password) {
        loginPassword.shouldBe(Condition.visible).sendKeys(password);
    }
    public void doLogIn() {
        logIn.shouldBe(Condition.visible).click();
    }
    public String verifyLoginProcess() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
