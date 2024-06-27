package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
            WebElement element = driver.findElement(By.id("grouptab_0"));
            String text = element.getText();
            System.out.println(text);

            element.click();

            driver.findElement(By.linkText("Leads")).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr")));

            WebElement table = driver.findElement(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr"));
            WebElement icon = table.findElement(By.xpath(".//td[10]"));
            icon.click();

            String xpathExpression = "//div[contains(@class,'open ui-dialog-content ui-widget-content')]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));

            // Find the WebElement using the XPath expression
            WebElement divElement = driver.findElement(By.xpath(xpathExpression));

            String leadText = divElement.getText();
            System.out.println(leadText);
            System.out.println("*************");
            String mobile = leadText.split("Mobile:")[1].trim().split("Home")[0];

            System.out.println("Mobile No : "+mobile);

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
