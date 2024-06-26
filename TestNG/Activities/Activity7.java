package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test(dataProvider = "creds")
    public void loginTest(String username, String password, String message) {
        WebElement name = driver.findElement(By.id("username"));
        WebElement pwd = driver.findElement(By.id("password"));

        name.clear();
        pwd.clear();

        name.sendKeys(username);
        pwd.sendKeys(password);

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String Loginmessage = driver.findElement(By.id("action-confirmation")).getText();


        Assert.assertEquals(Loginmessage, message);

    }

    @DataProvider(name = "creds")
    public Object[][] credentials() {

        Object[][] inputs = {

                {"admin", "password", "Welcome Back, admin"},
                {"admin1", "password1", "Invalid Credentials"}
        };
        return inputs;
    }

    @AfterClass
    public void closeMethod() {
        driver.close();
    }
}

