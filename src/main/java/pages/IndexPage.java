package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IndexPage extends BasePage {
    public IndexPage(WebDriver driver) {
        super(driver); //will invoke parent class constructor
    }

    //elements
    @FindBy(xpath = "//input[@id='header-search-input']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@id='header-search-dropdown']//ul//li")
    private List<WebElement> searchResultsAutoSuggestions;

    //action methods
    public void setSearchInput(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void clickSearchResultsAutoSuggestions() {
        searchResultsAutoSuggestions.get(0).click();
            waitUntilPageIsFullyLoaded(wait);
    }

    /*public SearchResultPage getSearchResultsPage() { //one more technique
        return new SearchResultPage(driver);
    }*/
}
