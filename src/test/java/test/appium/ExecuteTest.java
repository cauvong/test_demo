package test.appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author CuongNV31
 */
public class ExecuteTest {
	IOSDriver<WebElement> driver;

	IosBeforeTestService iosService;
	IosBeforeTestScreenShot iosSS;

	public int firstCount = 6;
	
	private void init() throws MalformedURLException{

		DesiredCapabilities caps = new DesiredCapabilities();
		System.out.println("Start appium with file: " + System.getProperty("filePath"));
		File app = new File(System.getProperty("filePath"));
		caps.setCapability(MobileCapabilityType.APP, app);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.2");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");

		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		iosService = new IosBeforeTestService(driver);
		iosSS = new IosBeforeTestScreenShot(driver, firstCount);
	}
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		System.out.println("@BeforeClass");
		init();
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		System.out.println("@AfterClass");
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeScreen() throws Exception {
		System.out.println("@BeforeMethod");
		iosSS.beforeMethod();
	}

	@AfterMethod
	public void afterScreen() throws Exception {
		System.out.println("@AfterMethod");
		iosSS.afterMethod();
	}
}
