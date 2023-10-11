import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IndexPageMobile;
import pages.SearchResultPageMobile;

public class SimpleSearchTestMobile extends SetUp {
    private SearchResultPageMobile searchResultPageMobile;
    @Test(priority = 1)
    @Parameters({"searchKey"})
    public void simpleSearchTestMobile (String searchKey) {
        IndexPageMobile indexPageMobile = new IndexPageMobile();
        searchResultPageMobile = new SearchResultPageMobile();

        indexPageMobile.setSearchInput(searchKey);
        indexPageMobile.clickSearchResultsAutoSuggestions();

        String firstItemText = searchResultPageMobile.getSearchResultsFirstElementText();
        System.out.println("First product name is " + firstItemText);
    }
}
