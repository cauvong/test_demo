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

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;


/**
 *  Execute Controller class
 *  This class implement init & finally process
 *  
 *  @author CuongNV31
 */

public abstract class AbstractIOSBaseExecute {
	public static WebDriver driver;

	@BeforeSuite
	public void setUp() throws MalformedURLException {
		// Install app and config
		init();
	}
	
	@SuppressWarnings("unchecked")
	@AfterSuite
	public void shutdown() {
		((IOSDriver<WebElement>) driver).removeApp("viwafoo.Butler");
		driver.quit();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("-----------Remove app-----------");
		((IOSDriver<WebElement>) driver).removeApp("viwafoo.Butler");
		driver.quit();
		System.out.println("-----------Re-install app-----------");
		// Config again
		init();

	}

	private void init(){
		System.out.println("init method");
		// Init
		DesiredCapabilities caps = new DesiredCapabilities();
		File appDir = new File(System.getProperty("filePath"));
//		File appDir = new File("/Users/mac/Desktop/testApps/Butler.app");
		caps.setCapability(MobileCapabilityType.APP, appDir);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.2");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		try {
			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println("Please start Appium server!!!!");
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}
	
	public boolean checkResult(final String keyID) {
		if(driver.findElements(By.id(keyID)).size() > 0){
			return true;
		}
		return false;
	}
	
}
