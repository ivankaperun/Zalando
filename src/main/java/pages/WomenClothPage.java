package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WomenClothPage extends BasePage {
    public WomenClothPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);
    @FindBy(xpath = "//span[@data-testid='genderLink']//span[contains(text(),'Women')]")
    private WebElement womenClothingButton;

    @FindBy(xpath = "//button[@id='uc-btn-accept-banner']")
    private WebElement bannerContent;

    @FindBy(xpath = "//li[contains(@aria-label,'Clothing')]//a//span[normalize-space()='Clothing']")
    private WebElement categoryClothing;

    @FindBy(xpath = "//span[normalize-space()='Hoodies & sweatshirts']")
    private WebElement subCategoryHoodie;

    public void clickOnBanner() {
        if (bannerContent.isDisplayed()) {
            bannerContent.click();
        }
    }
    public void clickOnWomenClothingTab() {
        womenClothingButton.click();
        waitUntilPageIsFullyLoaded(wait);
    }
    public void searchByCategory() {
        wait.until(ExpectedConditions.visibilityOf(categoryClothing));
        actions.moveToElement(categoryClothing).perform();
        actions.moveToElement(subCategoryHoodie).click().perform();
        waitUntilPageIsFullyLoaded(wait);
    }
}
