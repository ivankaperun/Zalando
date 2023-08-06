package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        ArrayList<Double> pricesList = new ArrayList<>();

        for(WebElement productPrice:productPricesList) {
            pricesList.add(Double.parseDouble(productPrice.getText().replace("£","")));
        }

        Collections.sort(pricesList, Collections.reverseOrder());

        return ("£" + pricesList.get(1));
    }

    public String getTitleAndPriceOfMostExpensiveProduct() {
        HashMap<String,Double> hm = new HashMap<>();

        for (WebElement product:productsTitles) {
            String productTitle = product.findElement(By.className("KxHAYs")).getText();
            String productPrice = product.findElement(By.tagName("span")).getText();
            Double productPriceDouble = Double.parseDouble(productPrice.replace("£",""));
            hm.put(productTitle,productPriceDouble);
        }


        //sorting hm by prices:
        LinkedHashMap<String, Double> sortedHm = new LinkedHashMap<>();
        ArrayList<Double> list = new ArrayList<>();

        for (Map.Entry<String, Double> entry : hm.entrySet()) {
            list.add(entry.getValue());
        }

        list.sort(Collections.reverseOrder());

        for (double price : list) {
            for (Map.Entry<String, Double> entry : hm.entrySet()) {
                if (entry.getValue().equals(price)) {
                    sortedHm.put(entry.getKey(), price);
                }
            }
        }

        Map.Entry<String,Double> entry = sortedHm.entrySet().iterator().next();
        return(entry.getKey() + " " + " - " + "£"+entry.getValue());
    }

}
