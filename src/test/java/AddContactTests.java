import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends BaseTest{

    @BeforeClass
    public void preconditions() {
        // TODO login
        // click on login btn by: //a[@href='/login']
        clickLoginOnNavBar();
        // fill email by: //input[@name='email']
        fillEmailOnLogin("testqa20@gmail.com");
        // fill password by: //input[@name='password']
        fillPasswordOnLogin("123456Aa$");
        // click login btn by: //button[@name='login']
        clickLoginBtn();

    }

    @AfterClass
    public void methodPostCondition() {
        clickLogoutBtn();
        navigateToHomePage();
    }

    @Test
    public void positiveAddContact() throws InterruptedException {
        // click on //a[@href='/add'] - open add contact page
        driver.findElement(By.xpath("//a[@href='/add']")).click();
        // fill name in //input[@placeholder='Name']
        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        name.click();
        name.clear();
        name.sendKeys("lksdjfno");
        // fill last name //input[@placeholder='Last Name']
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys("dfjkgn");
        // fill phone //input[@placeholder='Phone']
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
        phone.clear();
        phone.click();
        String numberPhone = "5554567890";
        phone.sendKeys(numberPhone);
        // fill email //input[@placeholder='email']
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='email']"));
        email.click();
        email.clear();
        email.sendKeys("sjkf@sjfh.com");
        // fill address //input[@placeholder='Address']
        WebElement address = driver.findElement(By.xpath("//input[@placeholder='Address']"));
        address.click();
        address.clear();
        address.sendKeys("sbhfih");
        // fill description //input[@placeholder='description']
        WebElement description = driver.findElement(By.xpath("//input[@placeholder='description']"));
        description.click();
        description.clear();
        description.sendKeys("dfjhg");
        // click save //div[contains(@class,'add_form')]//button
        driver.findElement(By.xpath("//div[contains(@class,'add_form')]//button")).click();

        Thread.sleep(3000);

        List<WebElement> allPhones = driver.findElements(By.xpath("//div[contains(@class,'contact-item_card')]//h3"));

        boolean res = false;
        for(WebElement el:allPhones) {
            if(getTextBase(el).equals(numberPhone)) {
                res = true;
                break;
            }
        }
        Assert.assertTrue(res);
    }
}
