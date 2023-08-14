package pages;

import org.openqa.selenium.NoSuchFrameException;
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
        try {
            addToCartButton.click();
        } catch (NoSuchFrameException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNumberOfProductsInCart() {
        try{
            return productsCartCounter.getText();
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
}
