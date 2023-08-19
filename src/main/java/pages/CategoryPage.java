package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1//span[contains(text(),'Sweatshirts & Hoodies')]")
    private WebElement categoryNameText;

    public String getOpenedCategoryName() {
        return categoryNameText.getText();
    }
}
