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

public class Activity5 {


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
                WebElement element = driver.findElement(By.id("toolbar"));

                String color = element.getCssValue("color");

                System.out.println(color);

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

