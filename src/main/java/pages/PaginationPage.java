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
        if(productsList.size()!=0) {
        try {
            productsList.get(0).click();
            waitUntilPageIsFullyLoaded(wait);
        } catch (StaleElementReferenceException e) {
            if(productsList.size()!=0) {
                productsList.get(0).click();
                waitUntilPageIsFullyLoaded(wait);
            } else {
                System.out.println("Array productsList is empty");
            }
        }
        } else {
            System.out.println("Array productsList is empty");
        }
    }
}
