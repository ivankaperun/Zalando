import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static utils.Constants.*;

public class SetUp {
    public WebDriver driver;

    @BeforeClass
    protected void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_TIMEOUT));
        driver.get(MAIN_URL);
        driver.manage().window().maximize();
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }

}
