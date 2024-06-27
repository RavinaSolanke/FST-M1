package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Activity3 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }
    @Test
    public void FMessage() {
        System.out.println("Footer Text is:" +driver.findElement(By.id("admin_options")).getText());

    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
