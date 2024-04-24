import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends BaseTest{

    @BeforeClass
    public void preconditions() {
        clickLoginOnNavBar();
        login(user);
    }

    @AfterClass
    public void methodPostCondition() {
        clickLogoutBtn();
        navigateToHomePage();
    }

    @Test
    public void positiveAddContact() {
        clickAddOnNavBar();
        addContact("sjrfbhijs", "jedfnijs", "5554567890",
                "sjkfhj@mail.com", "ejuhrf", "jkfrnrj");

        pause(3000);

        Assert.assertTrue(isContactDisplaysOnThePage("5554567890"));
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addContact(String name, String lastName, String phone, String email,
                            String address, String description) {
        fillNameOnAddContact(name);
        fillLastNameOnAddContact(lastName);
        fillPhoneAddContact(phone);
        fillEmailAddContact(email);
        fillAddressAddContact(address);
        fillDescriptionAddContact(description);
        clickAddContact();
    }

    public boolean isContactDisplaysOnThePage(String phone) {
        List<WebElement> allPhones = driver.findElements(By.xpath("//div[contains(@class,'contact-item_card')]//h3"));
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
        driver.findElement(By.xpath("//div[contains(@class,'add_form')]//button")).click();
    }

    public void fillDescriptionAddContact(String description) {
        typeText(description, By.xpath("//input[@placeholder='description']"));
    }

    public void typeText(String text, By by) {
        WebElement element = driver.findElement(by);
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
        driver.findElement(By.xpath("//a[@href='/add']")).click();
    }
}
