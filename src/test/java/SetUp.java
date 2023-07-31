import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class SetUp {
    public WebDriver driver;

    @BeforeClass
    @Parameters({"browser","url", "timeout"})
    protected void setUpBrowser(String browser, String url, long timeout) {
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
            driver.get(url);
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }

}
