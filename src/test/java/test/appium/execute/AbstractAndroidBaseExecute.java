package test.appium.execute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


/**
 * Execute Controller class
 * This class implement init & finally process
 *
 * @author CuongNV31
 */

public abstract class AbstractAndroidBaseExecute {
    public static WebDriver driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        // Install and config
        init();
    }

    @SuppressWarnings("unchecked")
    @AfterSuite
    public void shutdown() {
        ((AndroidDriver<WebElement>) driver).removeApp("honeystudios.com.testauto");
        driver.quit();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("-----------Remove app-----------");
        ((AndroidDriver<WebElement>) driver).removeApp("honeystudios.com.testauto");
        driver.quit();
        System.out.println("-----------Re-install app-----------");
        // Install app again
        init();

    }

    private void init() {
        System.out.println("init method");

        DesiredCapabilities caps = new DesiredCapabilities();
        // Setup app with file name
        File appDir = new File("/Users/mac/Desktop/testApps/Butler.apk");
        caps.setCapability(MobileCapabilityType.APP, appDir);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Custom Phone - 4.2.2 - API 17 - 768x1280");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            System.out.println("Please start Appium server!!!!");
        }

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public boolean checkResult(final String keyID) {
        if (driver.findElements(By.id(keyID)).size() > 0) {
            return true;
        }
        return false;
    }

    public boolean checkResultAndroid(final String keyID) {
        try {
            driver.findElement(By.xpath(keyID));
        } catch (NullPointerException ex) {
            System.out.println("Error not find element");
            return false;
        }
        return true;
    }

}
