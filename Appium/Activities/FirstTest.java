package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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

    AppiumDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options().
                setPlatformName("android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.android.calculator2").
                setAppActivity(".Calculator").
                noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void multiplyTest() throws IOException {

        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();

        driver.findElement(AppiumBy.accessibilityId("×")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result =driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();

        Assert.assertEquals(result,"10");
        takeScreenshot(driver);
    }


    public void takeScreenshot(AppiumDriver driver) throws IOException {
        // Take screenshot
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // This specifies the location the screenshot will be saved
        File screenShotName = new File("src/test/resources/screenshot.jpg");

        // This will copy the screenshot to the file created
        FileUtils.copyFile(scrShot, screenShotName);

        // Set filepath for image
        String filePath = "../" + screenShotName;

        // Set image HTML in the report
        String path = "<img src='" + filePath + "'/>";

        // Show image in report
        Reporter.log(path);
    }


    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
