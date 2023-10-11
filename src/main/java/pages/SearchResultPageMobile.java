package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchResultPageMobile {
    public SearchResultPageMobile() {}

    //elements
    private ElementsCollection searchResultElements = $$x("//article[@role='link']//h3[last()]");
    private ElementsCollection productCards = $$x("//a[@data-card-type='media']");

    //methods
    public boolean checkProductCardsAvailability() {
        return productCards.first().shouldBe(Condition.visible).isDisplayed();
    }
    public String getSearchResultsFirstElementText() {

        String text = "";
        try {
            text = searchResultElements.first().shouldBe(Condition.visible).getText();
        }
        catch (Exception e) {
            System.out.println(e.getClass() + " -- " + e.getMessage());
        }
        return text;
    }

}
