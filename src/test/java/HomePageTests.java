import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest{

    @Test
    public void homePageOpened() {
        WebElement homePageText = driver.findElement(By.cssSelector("div:nth-child(2) h1"));
        String actualRes = homePageText.getText().trim();
        System.out.println(actualRes); // sout
        Assert.assertEquals(actualRes, "Home Component");
    }
}
