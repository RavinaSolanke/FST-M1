package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
//declare driver
    AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //desired capabilities
        UiAutomator2Options options = new UiAutomator2Options().setPlatformName("android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.android.calculator2").
                setAppActivity(".Calculator").
                noReset();

        //Appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Android driver installation

        driver= new AppiumDriver(serverURL,options);
    }
    @Test
    public void multiplyTest() throws IOException {
        //find digit 5 and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();

        //find multiply symbol
        driver.findElement(AppiumBy.accessibilityId("×")).click();

        //find digit 2 and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2")).click();

        //find equals symbols and find it
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result= driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        Assert.assertEquals(result,"10");
        takeScreenshot(driver);
    }
    public static void takeScreenshot(AppiumDriver driver)throws IOException{
        File scrnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File saveLocation = new File ("src/test/resources/screenshot.jpg");
        FileUtils.copyFile(scrnShot,saveLocation);

        String filePath= "../*" +saveLocation;
        String logScreenshot = "<img src='" +filePath +"'/>";
        Reporter.log(logScreenshot);
    }
    @AfterClass
    public void tearDown(){
        //close the app
        driver.quit();

    }
}
