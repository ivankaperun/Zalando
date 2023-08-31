package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;
import java.util.*;

import static utils.Constants.DEFAULT_TIMEOUT;

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
        By xpath_ = By.xpath("//article[@role='link']//h3[last()]");
        String text = "";
        try {
            text = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .pollingEvery(Duration.ofSeconds(1L))
                    .until(ExpectedConditions.visibilityOf(driver.findElements(xpath_).get(0))).getText();
        }
        catch (Exception e) {
            System.out.println(e.getClass() + " -- " + e.getMessage());
        }
        return text;
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
        String pageOneFirstProduct = getSearchResultsFirstElementText();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", paginationArrow);
        //
        clickOnBanner();
        //
        paginationArrow.click();
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(driver -> {
            while(true) {
                String pageTwoFirstProduct = getSearchResultsFirstElementText();
                if (!pageOneFirstProduct.equals(pageTwoFirstProduct)) break;
            }
            return true;
        });

        waitUntilPageIsFullyLoaded(wait);
    }

    public void clickFirstProductOnThePage() {
        waitVisibilityOfElement(DEFAULT_TIMEOUT, productsList.get(0));
        productsList.get(0).click();
        waitUntilPageIsFullyLoaded(wait);
    }

}
