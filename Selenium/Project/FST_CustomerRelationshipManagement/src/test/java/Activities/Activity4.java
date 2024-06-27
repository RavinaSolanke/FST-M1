package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity4 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }
    @Test
    public void loginTest() {
        WebElement username = driver.findElement(By.id("user_name"));
        WebElement password = driver.findElement(By.id("username_password"));

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();

        WebElement suitDashboard = driver.findElement(By.id("tab0"));
        boolean suite = suitDashboard.isDisplayed();

        //String suiteText = suitDashboard.getText();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (suite == true){
            System.out.println("Login successful , SuitDashboard is displaying");
        }
        else {
            System.out.println("Login failed");
        }
    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
