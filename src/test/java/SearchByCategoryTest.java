import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.IndexPage;
import pages.WomenClothPage;

import static org.testng.Assert.assertEquals;

public class SearchByCategoryTest extends SetUp {
    @Test
    public void searchByCategoryTest () {
        IndexPage indexPage = new IndexPage(driver);
        WomenClothPage womenClothPage = new WomenClothPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        womenClothPage.clickOnWomenClothingTab();
        //womenClothPage.clickOnBanner();
        womenClothPage.searchByCategory();
        String actual_result = categoryPage.getOpenedCategoryName();
        System.out.println("Name of opened Category: " + actual_result);
        assertEquals(actual_result,"Sweatshirts & Hoodies");
    }
}
