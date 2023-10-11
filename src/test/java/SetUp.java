import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SetUp {
    //For remote Lambda tests launch
    static final String LT_USERNAME ="ivkaloz";
    static final String LT_ACCESS_KEY = "3vVtIdvjtp4pzne0yetVKk1UGK61JEaDzFJVUMAxvyUkUfLBO1";
    static final String HUB_URL = "https://" + LT_USERNAME + ":" + LT_ACCESS_KEY + "@hub.lambdatest.com/wd/hub";

    @BeforeClass
    //@BeforeMethod //for retry analyzer as it works on method level
    @Parameters({"browser", "url","timeout"})
    protected void configureDriver(String browser, String url, long timeout) {
        //Selenide configs
        Configuration.timeout = timeout;
        Configuration.screenshots = false;

        //WebDriver create
        WebDriverManager.chromedriver().setup();
        final WebDriver webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();

        //for iPhone 14 pro:
        //webDriver.manage().window().setSize(new Dimension(390,844));

        //Selenide add webDriver
        WebDriverRunner.setWebDriver(webDriver);
        Selenide.open(url);
    }

    @AfterClass(alwaysRun = true)
    //@AfterMethod //for retry analyzer as it works on method level
    protected void cleanUp() {
        WebDriverRunner.getWebDriver().quit();
    }



    // For remote lambda tests launch
    /*
    @BeforeMethod //for retry analyzer as it works on method level
    @Parameters({"browser","remote","url","timeout"})
    protected void configureDriver(String browser, String remote, String url, long timeout) {
        System.out.println("ENTERING CONFIG DRIVER");
        final WebDriver webDriver;
        //Selenide configs
        Configuration.timeout = timeout;
        Configuration.screenshots = false;
        //WebDriver create
        if(Boolean.valueOf(remote)) {
            try {
                webDriver = new RemoteWebDriver(new URL(HUB_URL), getOptions());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().maximize();
        }
        //Selenide add webDriver
        WebDriverRunner.setWebDriver(webDriver);
        Selenide.open(url);
    }

    @AfterMethod(alwaysRun = true)
    protected void cleanUp() {
        WebDriverRunner.getWebDriver().quit();
    }

    private static ChromeOptions getOptions() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("117.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("build","Zalando");
        ltOptions.put("project","Demo");
        ltOptions.put("w3c",true);
        ltOptions.put("plugin","java-java");
        browserOptions.setCapability("LT:Options",ltOptions);
        return browserOptions;
    }
     */
}
