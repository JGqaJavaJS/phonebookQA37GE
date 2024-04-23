import dto.UserDTO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    static WebDriver driver;

    @BeforeSuite
    public static void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        // implicit waiting's
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://telranedu.web.app/home");
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }

    public String getTextBase(WebElement element) {
        return element.getText().trim();
    }

    public WebElement getElementHomePageText() {
        return driver.findElement(By.cssSelector("div:nth-child(2) h1"));
    }

    public void navigateToHomePage() {
        driver.navigate().to("https://telranedu.web.app/home");
    }

    public void clickLogoutBtn() {
        driver.findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button"))
                .click();
    }

    public WebElement getSignOutBtnElement() {
        WebElement signOutBtn = driver.findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button")
        );
        return signOutBtn;
    }

    public void clickLoginBtn() {
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    public void fillPasswordOnLogin(String password) {
        WebElement inputPassword = driver.findElement(By
                .xpath("//input[@name='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void fillEmailOnLogin(String email) {
        WebElement inputEmail = driver.findElement(By
                .xpath("//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void clickLoginOnNavBar() {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
    }

    public void login(UserDTO user) {
        fillEmailOnLogin(user.getEmail());
        // fill password by: //input[@name='password'] "123456Aa$"
        fillPasswordOnLogin(user.getPassword());
        // click login btn by: //button[@name='login']
        clickLoginBtn();
    }
}
