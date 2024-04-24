import config.ApplicationManager;
import dto.ContactDTO;
import dto.UserDTO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    static ApplicationManager app =
            new ApplicationManager(System
                    .getProperty("browser", Browser.CHROME.browserName()));
    UserDTO user = new UserDTO().setEmail("testqa20@gmail.com").setPassword("123456Aa$");
    @BeforeSuite
    public static void startBrowser() {
        ApplicationManager.init();
    }
    @AfterSuite
    public static void tearDown() {
        ApplicationManager.quit();
    }

    public String getTextBase(WebElement element) {
        return element.getText().trim();
    }

    public WebElement getElementHomePageText() {
        return ApplicationManager.getDriver().findElement(By.cssSelector("div:nth-child(2) h1"));
    }

    public void navigateToHomePage() {
        ApplicationManager.getDriver().navigate().to("https://telranedu.web.app/home");
    }

    public void clickLogoutBtn() {
        ApplicationManager.getDriver().findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button"))
                .click();
    }

    public WebElement getSignOutBtnElement() {
        WebElement signOutBtn = ApplicationManager.getDriver().findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button")
        );
        return signOutBtn;
    }

    public void clickLoginBtn() {
        ApplicationManager.getDriver().findElement(By.xpath("//button[@name='login']")).click();
    }

    public void fillPasswordOnLogin(String password) {
        WebElement inputPassword = ApplicationManager.getDriver().findElement(By
                .xpath("//input[@name='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void fillEmailOnLogin(String email) {
        WebElement inputEmail = ApplicationManager.getDriver().findElement(By
                .xpath("//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void clickLoginOnNavBar() {
        ApplicationManager.getDriver().findElement(By.xpath("//a[@href='/login']")).click();
    }

    public void login(UserDTO user) {
        fillEmailOnLogin(user.getEmail());
        // fill password by: //input[@name='password'] "123456Aa$"
        fillPasswordOnLogin(user.getPassword());
        // click login btn by: //button[@name='login']
        clickLoginBtn();
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addContact(ContactDTO contactDTO) {
        fillNameOnAddContact(contactDTO.getName());
        fillLastNameOnAddContact(contactDTO.getLastName());
        fillPhoneAddContact(contactDTO.getPhone());
        fillEmailAddContact(contactDTO.getEmail());
        fillAddressAddContact(contactDTO.getAddress());
        fillDescriptionAddContact(contactDTO.getDescription());
        clickAddContact();
    }

    public boolean isContactDisplaysOnThePage(String phone) {
        List<WebElement> allPhones = ApplicationManager.getDriver().findElements(By.xpath("//div[contains(@class,'contact-item_card')]//h3"));
        boolean res = false;
        for(WebElement el:allPhones) {
            if(getTextBase(el).equals(phone)) {
                res = true;
                break;
            }
        }
        return res;
    }

    public void clickAddContact() {
        ApplicationManager.getDriver().findElement(By.xpath("//div[contains(@class,'add_form')]//button")).click();
    }

    public void fillDescriptionAddContact(String description) {
        typeText(description, By.xpath("//input[@placeholder='description']"));
    }

    public void typeText(String text, By by) {
        WebElement element = ApplicationManager.getDriver().findElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void fillAddressAddContact(String address) {
        typeText(address,By.xpath("//input[@placeholder='Address']"));
    }

    public void fillEmailAddContact(String email) {
        typeText(email, By.xpath("//input[@placeholder='email']"));
    }

    public void fillPhoneAddContact(String phone) {
        typeText(phone, By.xpath("//input[@placeholder='Phone']"));
    }

    public void fillLastNameOnAddContact(String lastName) {
        typeText(lastName, By.xpath("//input[@placeholder='Last Name']"));
    }

    public void fillNameOnAddContact(String name) {
        typeText(name, By.xpath("//input[@placeholder='Name']"));
    }

    public void clickAddOnNavBar() {
        ApplicationManager.getDriver().findElement(By.xpath("//a[@href='/add']")).click();
    }
}
