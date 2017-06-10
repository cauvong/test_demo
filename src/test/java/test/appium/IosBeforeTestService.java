package test.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

/**
 * @author CuongNV31
 */
public class IosBeforeTestService {
	IOSDriver<WebElement> driver;
	
	IosBeforeTestService(IOSDriver<WebElement> driver){
		this.driver = driver;
	}
	
	// TODO testing take screen function
	public String testTakeScreen() {
		if(driver.findElements(By.id("OK")).size() > 0){
			driver.findElement(By.id("OK")).click();
		}
		return Thread.currentThread().getStackTrace()[1].getMethodName();
	}

}
