package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PDPPage {
    public PDPPage() {}

    private SelenideElement addToCartButton = $x("//span[normalize-space()='Add to bag']");

    private SelenideElement productsCartCounter = $x("//div[@data-testid='shopping-bag-badge']//span");

    private SelenideElement chooseYourSize = $x("//button[@id='picker-trigger']");

    private ElementsCollection sizes = $$x("//label[@data-testid='pdp-stockAvailable-label']");

    private SelenideElement bannerContent = $x("//button[@id='uc-btn-accept-banner']");

    public void clickOnBanner() {
        if (bannerContent.isDisplayed()) {
            bannerContent.click();
        }
    }
    public void clickOnAddToCartButton() {
        clickOnBanner();
        addToCartButton.isDisplayed();
        if(chooseYourSize.exists()) {
            addToCartButton.shouldBe(Condition.visible).click();
            if (sizes.first().exists()) {
                sizes.first().shouldBe(Condition.visible).click();
            }
        }
        else {
            addToCartButton.shouldBe(Condition.visible).click();
        }
    }
    public String getNumberOfProductsInCart() {
        return productsCartCounter.shouldBe(Condition.visible).getText();
    }
}
