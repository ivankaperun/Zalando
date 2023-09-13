package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class PDPPage {
    public PDPPage() {}
    private SelenideElement addToCartButton = $x("//span[normalize-space()='Add to bag']");

    private SelenideElement productsCartCounter = $x("//div[@data-testid='shopping-bag-badge']//span");

    private SelenideElement chooseYourSize = $x("//button[@id='picker-trigger']");

    private ElementsCollection sizes = $$x("//div[@role='listbox']//div[@data-indicator='border']//label[@data-testid='pdp-stockAvailable-label']/span");
     public void clickOnAddToCartButton() {
        chooseYourSize.shouldBe(Condition.visible);
        if(chooseYourSize.exists()) {
            addToCartButton.shouldBe(Condition.visible).click();
            if (sizes.get(1).exists() && sizes.get(1).isDisplayed()) {
                sizes.get(1).shouldBe(Condition.visible);
                actions().moveToElement(sizes.get(1)).click(sizes.get(1)).perform();
            }
        }
        addToCartButton.shouldBe(Condition.visible).click();
    }
    public String getNumberOfProductsInCart() {
        return productsCartCounter.shouldBe(Condition.visible).getText();
    }
}
