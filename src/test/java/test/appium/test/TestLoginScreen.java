package test.appium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

/**
 *  This class FeedTop Screen WebElement Class
 *  Implements function of FeedTop Screen
 *  
 *  @author CuongNV31
 */

public class TestLoginScreen extends AbstractBaseTest {
	
	public TestLoginScreen(WebDriver driver) {
		super(driver);
	}

	/**
	 * Procedure No.01 check Login pass on iOS
	 */
	public void checkLoginScreenIOS() {
		// Run with iOS
		driver.findElement(xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("abc@gmail.com");
		driver.findElement(xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[2]")).sendKeys("abc@123");
		driver.findElement(By.id("Login")).click();
	}

	/**
	 * Procedure No.01 check Login Fail on iOS
	 */
	public void checkLoginFailScreenIOS() {
		driver.findElement(xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("abc@gmail.com");
		driver.findElement(xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[2]")).sendKeys("abc@1234");
		driver.findElement(By.id("Login")).click();
	}

	/**
	 * Procedure No.02 check Login pass on Android
	 */
	public void checkLoginScreenAndroid() {

		// Run with Android
		List<WebElement> edts = driver.findElements(xpath("//android.widget.EditText"));
		edts.get(0).click();
		edts.get(0).sendKeys("abc@gmail.com");

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		edts.get(1).click();
		edts.get(1).sendKeys("abc@123");

		driver.findElement(xpath("//android.widget.Button[@text='Login']")).click();
	}

	/**
	 * Procedure No.02 check Login Fail on Android
	 */
	public void checkLoginFailScreenAndroid() {

		// Run with Android
		List<WebElement> edts = driver.findElements(xpath("//android.widget.EditText"));
		edts.get(0).click();
		edts.get(0).sendKeys("abc@gmail.com");

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		edts.get(1).click();
		edts.get(1).sendKeys("abc@1234");

		List<WebElement> cal = driver.findElements(xpath("//android.widget.Button"));
		cal.get(0).click();
	}
}
