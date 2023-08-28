package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.Constants.DEFAULT_TIMEOUT;

public class IndexPage extends BasePage {
    WebDriverWait wait;
    Actions actions = new Actions(driver);
    public IndexPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)); //will invoke parent class constructor
    }

    //elements
    @FindBy(xpath = "//input[@id='header-search-input']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@id='header-search-dropdown']//ul//li")
    private List<WebElement> searchResultsAutoSuggestions;

    @FindBy (xpath = "//button[@data-testid='user-account-icon']")
    private WebElement userAccountButton;

    @FindBy (xpath = "//a[@href='/login/']")
    private WebElement loginButton;

    //action methods
    public void setSearchInput(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void clickSearchResultsAutoSuggestions() {
        searchResultsAutoSuggestions.get(0).click();
        waitUntilPageIsFullyLoaded(wait);
    }

    public void hoverUserAccountButton() {
        actions.moveToElement(userAccountButton).perform();
    }

    public void clickOnLoginButton() {
        loginButton.click();
        waitUntilPageIsFullyLoaded(wait);
    }

    /*public SearchResultPage getSearchResultsPage() { //one more technique
        return new SearchResultPage(driver);
    }*/
}
