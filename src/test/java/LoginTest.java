import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @AfterMethod
    public void methodPostCondition() {
        clickLogoutBtn();
        navigateToHomePage();
    }

    @Test
    public void positiveLoginTest() {
        // click on login btn by: //a[@href='/login']
        clickLoginOnNavBar();
        // fill email by: //input[@name='email']
        fillEmailOnLogin("testqa20@gmail.com");
        // fill password by: //input[@name='password'] "123456Aa$"
        fillPasswordOnLogin("123456Aa$");
        // click login btn by: //button[@name='login']
        clickLoginBtn();


        //  validation - verification by sign out //div[contains(@class,'navbar-logged')]//button
        // text: Sign Out

        WebElement signOutBtn = getSignOutBtnElement();
        String actualRes = getTextBase(signOutBtn);
        System.out.println(actualRes);

//        Assert.assertEquals(
//                driver.findElement(
//                        By.xpath("//div[contains(@class,'navbar-logged')]//button"))
//                        .getText().trim(),
//                "Sign Out");

        Assert.assertEquals(actualRes, "Sign Out");
    }

}
