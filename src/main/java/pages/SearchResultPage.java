package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class SearchResultPage extends BasePage {
    //constructor
    public SearchResultPage (WebDriver driver) {
        super(driver);
    }
    //elements
    @FindBy(xpath = "//article[@role='link']//h3[last()]")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//article[@role='link']//header/div/following-sibling::section//span")
    private List<WebElement> productPricesList;

    @FindBy(xpath = "//div[@data-zalon-partner-target='true']//article[@role='link']//a//header")
    private List<WebElement> productsTitles;

    @FindBy(xpath = "//a[@title='next page']")
    private WebElement paginationArrow;

    @FindBy(xpath = "//button[@id='uc-btn-accept-banner']")
    private WebElement bannerContent;

    @FindBy(xpath = "//article[@role='link']")
    private List<WebElement> productsList;

    //methods
    public String getSearchResultsFirstElementText() {

        if (searchResultElements.size()!=0) {
            return (searchResultElements.get(0).getText());
        }
        else {
            return ("Array searchResultElements is empty");
        }
    }
    public String findProductWithHighestPrice() {
        ArrayList<Double> pricesList = new ArrayList<>();

        if(productPricesList.size()!=0) {
            for (WebElement productPrice : productPricesList) {
                pricesList.add(Double.parseDouble(productPrice.getText().replace("£", "")));
            }

            pricesList.sort(Collections.reverseOrder());

            return ("£" + pricesList.get(0));
        } else
            {
                return ("Array productPricesList is empty");
            }
    }

    public String getTitleAndPriceOfMostExpensiveProduct() {
        TreeMap<Double, String> hm = new TreeMap<>();

        if(productsTitles.size()!=0) {
            for (WebElement product:productsTitles) {
                String productTitle = product.findElement(By.tagName("h3")).getText();
                String productPrice = product.findElement(By.tagName("span")).getText();
                Double productPriceDouble = Double.parseDouble(productPrice.replace("£",""));
                hm.put(productPriceDouble,productTitle);
            }

            double lastEntry = hm.lastKey();

            return(hm.get(lastEntry) + " " + " - " + "£" + lastEntry);
        } else
        {
            return ("Array productsTitles is empty");
        }
    }

    public void clickOnBanner() {
        if (bannerContent.isDisplayed()) {
            bannerContent.click();
        }
    }

    public void scrollDownToThePaginationAndClickNextPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", paginationArrow);
        paginationArrow.click();
        waitUntilPageIsFullyLoaded(wait);
    }

    public void clickFirstProductOnThePage() {
        driver.navigate().refresh();
        productsList.get(0).click();
        waitUntilPageIsFullyLoaded(wait);
    }

}
