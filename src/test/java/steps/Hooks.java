package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.ReadProperty;


public class Hooks {

    private static WebDriver driver;

    @Before
    public static void start() {

        String pathChromeDirver = "src/test/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", pathChromeDirver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--disable-blink-features=AutomationControlled ");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("disable-infobars");

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(ReadProperty.ReadProperties().getProperty("url"));

    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
