package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");

    }
    @Test
    public void exampleTestCase() {
        String title = driver.getTitle();

        System.out.println("Page title is: " + title);

        Assert.assertEquals("SuiteCRM", title);

    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
