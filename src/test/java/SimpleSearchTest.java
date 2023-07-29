import org.testng.annotations.Test;
import pages.IndexPage;
import pages.SearchResultPage;

public class SimpleSearchTest extends SetUp {

    @Test
    public void simpleSearchTest () {
    IndexPage indexPage = new IndexPage(driver);
    SearchResultPage searchResultPage = new SearchResultPage(driver);

    indexPage.setSearchInput("bags");
    indexPage.clickSearchResultsAutoSuggestions();

    String firstItemText = searchResultPage.getSearchResultsFirstElementText();
    System.out.println("First product name is " + firstItemText);

    String productWithHighestPrice = searchResultPage.findProductWithHighestPrice();
    System.out.println("Highest price for found products is " + productWithHighestPrice);

}
}
