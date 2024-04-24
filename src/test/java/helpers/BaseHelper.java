package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    // find elemnt / s

    protected WebElement findElementBase(By by) {
        System.out.println("Locator: findElement: " + by.toString());
        return driver.findElement(by);
    }

    protected List<WebElement> findElementsBase(By by) {
        return driver.findElements(by);
    }

    //-------------------------------------------

    // text

    protected String getTextBaseByLocator(By by) {
        return findElementBase(by).getText().trim();
    }

    protected String getTextBaseByElement(WebElement el) {
        return el.getText().trim();
    }

    protected void typeText(String text, By by) {
        WebElement element = findElementBase(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    //-------------------------

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
