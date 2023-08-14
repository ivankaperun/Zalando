import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PDPPage;
import pages.PaginationPage;
import pages.SearchResultPage;

import static org.testng.Assert.assertEquals;

public class SimpleSearchTest extends SetUp {

    @Test
    @Parameters({"searchKey"})
    public void simpleSearchTest (String searchKey) {
    IndexPage indexPage = new IndexPage(driver);
    SearchResultPage searchResultPage = new SearchResultPage(driver);
    PaginationPage paginationPage = new PaginationPage(driver);
    PDPPage pdpPage = new PDPPage(driver);

    indexPage.setSearchInput(searchKey);
    indexPage.clickSearchResultsAutoSuggestions();

    String firstItemText = searchResultPage.getSearchResultsFirstElementText();
    System.out.println("First product name is " + firstItemText);

    String productWithHighestPrice = searchResultPage.findProductWithHighestPrice();
    System.out.println("Highest price for found products is " + productWithHighestPrice);

    String mostExpensiveProductOnThePage = searchResultPage.getTitleAndPriceOfMostExpensiveProduct();
    System.out.println("Most expensive product on the page is " + mostExpensiveProductOnThePage);

    searchResultPage.scrollDownToThePaginationAndClickNextPage();
    searchResultPage.clickOnBanner();

    paginationPage.clickFirstProductOnThePage();

    pdpPage.clickOnAddToCartButton();
    String actual_result = pdpPage.getNumberOfProductsInCart();
    System.out.println("Number of products in Cart: " + actual_result);
    assertEquals(actual_result, "1");

}
}
