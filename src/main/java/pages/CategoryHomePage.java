package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CategoryHomePage {
    public CategoryHomePage() {
    }

    private ElementsCollection customerCategory = $$x("//span[@data-testid='genderLink']//span");

    private SelenideElement bannerContent = $x("//button[@id='uc-btn-accept-banner']");

    private ElementsCollection categoryClothing = $$x("//li[@data-testid='top-category']//a//span");

    private ElementsCollection subCategories = $$x("//div[@data-testid='categories-container']//div//a[@color='primary']");

    public void clickOnBanner() {
        if (bannerContent.isDisplayed()) {
            bannerContent.click();
        }
    }
    public void clickOnCustomerCategoryTab() {
        int random = (int) Math.floor(Math.random()*customerCategory.size());
        System.out.println("Selected customer category sequence number is - " + random);
        customerCategory.get(random).shouldBe(Condition.visible).click();
        bannerContent.shouldBe(Condition.visible);
        clickOnBanner();
    }
    public void searchByCategory() {
        int random = (int) Math.floor(Math.random()*categoryClothing.size());
        System.out.println("Selected category sequence number is - " + random);
        if(random!=1 || random!=8) {
            categoryClothing.get(random).shouldBe(Condition.visible).hover();
        } else {
            categoryClothing.get(random+1).hover();
        }
    }
    public void searchBySubCategory() {
        clickOnBanner();
        int random = (int) Math.floor(Math.random()*subCategories.size());
        System.out.println("Selected sub category sequence number is - " + random);
        subCategories.get(random).shouldBe(Condition.visible).hover().click();
    }
}
