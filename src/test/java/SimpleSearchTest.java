import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PDPPage;
import pages.SearchResultPage;

import static org.testng.Assert.assertEquals;

public class SimpleSearchTest extends SetUp {

    @Test(priority = 1)
    @Parameters({"searchKey"})
    public void simpleSearchTest (String searchKey) {
    IndexPage indexPage = new IndexPage(driver);
    SearchResultPage searchResultPage = new SearchResultPage(driver);

    indexPage.setSearchInput(searchKey);
    indexPage.clickSearchResultsAutoSuggestions();

    String firstItemText = searchResultPage.getSearchResultsFirstElementText();
    System.out.println("First product name is " + firstItemText);
}
    @Test(priority = 2)
    public void findMostExpensiveProductTest () {
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        String productWithHighestPrice = searchResultPage.findProductWithHighestPrice();
        System.out.println("Highest price for found products is " + productWithHighestPrice);

        String mostExpensiveProductOnThePage = searchResultPage.getTitleAndPriceOfMostExpensiveProduct();
        System.out.println("Most expensive product on the page is " + mostExpensiveProductOnThePage);
    }
    @Test (priority = 3)
    public void addToCartTest () {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        PDPPage pdpPage = new PDPPage(driver);

        searchResultPage.scrollDownToThePaginationAndClickNextPage();
        searchResultPage.clickFirstProductOnThePage();

        pdpPage.clickOnAddToCartButton();
        String actual_result = pdpPage.getNumberOfProductsInCart();
        System.out.println("Number of products in Cart: " + actual_result);
        assertEquals(actual_result, "1");
    }
}
