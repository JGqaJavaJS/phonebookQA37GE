package config;

import helpers.ContactHelper;
import helpers.HomePageHelper;
import helpers.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager {

    static WebDriver driver;
    String browser;
    ContactHelper contactHelper;
    HomePageHelper homePageHelper;
    UserHelper userHelper;

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public HomePageHelper getHomePageHelper() {
        return homePageHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        // common settings for the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://telranedu.web.app/home");

        // init helpers
        contactHelper = new ContactHelper(driver);
        homePageHelper = new HomePageHelper(driver);
        userHelper = new UserHelper(driver);
    }

    public void quit() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
