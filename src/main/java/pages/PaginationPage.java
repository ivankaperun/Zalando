package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaginationPage extends BasePage {
    public PaginationPage (WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//article[@role='link']")
    private List<WebElement> productsList;

    public void clickFirstProductOnThePage() {
        driver.navigate().refresh();
        try {
            productsList.get(0).click();
            waitUntilPageIsFullyLoaded(wait);
        } catch (StaleElementReferenceException e) {
            driver.navigate().refresh();
            productsList.get(0).click();
            waitUntilPageIsFullyLoaded(wait);
        }
    }
}
