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

    private ElementsCollection sizes = $$x("//div[@role='listbox']//div[@data-indicator='border']//label[@data-testid='pdp-stockAvailable-label']/span");

    private SelenideElement bannerContent = $x("//button[@id='uc-btn-accept-banner']");

    public void clickOnBanner() {
        if (bannerContent.isDisplayed()) {
            bannerContent.click();
        }
    }
    public void clickOnAddToCartButton() {
        addToCartButton.isDisplayed();
        System.out.println("from clickOnAddToCartButton method");
        if(chooseYourSize.exists()) {
            System.out.println("from 1st if block of clickOnAddToCartButton method");
            addToCartButton.shouldBe(Condition.visible).click();
            if (sizes.first().exists() && sizes.first().isDisplayed()) {
                for(SelenideElement size:sizes) {
                    System.out.println(size.getText());
                }
                System.out.println("from 2nd if block of clickOnAddToCartButton method");
                sizes.first().shouldBe(Condition.visible).hover().click();
            }
        }
        addToCartButton.shouldBe(Condition.visible).click();
    }
    public String getNumberOfProductsInCart() {
        return productsCartCounter.shouldBe(Condition.visible).getText();
    }
}
