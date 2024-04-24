package tests;

import config.ApplicationManager;
import dto.UserDTO;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    static ApplicationManager app =
            new ApplicationManager(System
                    .getProperty("browser", Browser.CHROME.browserName()));
    UserDTO user = new UserDTO().setEmail("testqa20@gmail.com").setPassword("123456Aa$");
    @BeforeSuite
    public static void startBrowser() {
        app.init();
    }
    @AfterSuite
    public static void tearDown() {
        app.quit();
    }

}
