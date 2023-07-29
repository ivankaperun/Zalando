package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResultPage extends BasePage {
    //constructor
    public SearchResultPage (WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//article[@role='link']//h3[last()]") //or
    //@FindBy(xpath = "//article[@role='link']//h3/following-sibling::h3")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//article[@role='link']//header/div/following-sibling::section//span")
    private List<WebElement> productPricesList;

    //methods
    public String getSearchResultsFirstElementText() {

        try {
            return (searchResultElements.get(1).getText());
        }
        catch(Exception e) {
            return (e.getMessage());
        }
    }
    public String findProductWithHighestPrice() {
        ArrayList<Double> pricesList = new ArrayList<Double>();

        for(WebElement productPrice:productPricesList) {
            pricesList.add(Double.parseDouble(productPrice.getText().replace("£","")));
        }

        Collections.sort(pricesList, Collections.reverseOrder());

        return ("£" + pricesList.get(1));
    }


}
