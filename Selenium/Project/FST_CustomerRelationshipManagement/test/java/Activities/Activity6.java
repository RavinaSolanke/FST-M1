package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test(dataProvider = "loginCreds")
    public void loginTest(String username, String password)
    {
        try {
            WebElement user = driver.findElement(By.id("user_name"));
            WebElement pwd = driver.findElement(By.id("username_password"));

            user.clear();
            pwd.clear();

            user.sendKeys(username);
            pwd.sendKeys(password);

            driver.findElement(By.id("bigbutton")).click();

            // driver.findElement(By.id("toolbar"));
            WebElement element = driver.findElement(By.id("grouptab_3"));
            String text = element.getText();
            System.out.println(text);

            System.out.println("---Below are the Activities Options---");

            Actions activityActions = new Actions(driver);
            activityActions.moveToElement(element).build().perform();

            WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"toolbar\"]/ul/li[5]/span[2]/ul"));

            java.util.List<WebElement> dropdownLinks = dropdown.findElements(By.tagName("a"));

            for (WebElement link : dropdownLinks) {
                System.out.println(link.getText());
            }


        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @DataProvider(name="loginCreds")
    public Object[][] credentials()
    {

        Object[][] obj ={
                {"admin","pa$$w0rd"}
        };
        return obj;
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
