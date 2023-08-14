package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PDPPage extends BasePage {
    public PDPPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Add to bag']")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@data-testid='shopping-bag-badge']//span")
    WebElement productsCartCounter;

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public String getNumberOfProductsInCart() {
        try{
            return productsCartCounter.getText();
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
}
