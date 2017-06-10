
package test.appium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *  This class FeedTop Screen WebElement Class
 *  Implements function of FeedTop Screen
 *  
 *  @author CuongNV31
 */

public class TestUtilObjectParts {
	
	/*
	WebElement pushButton;
	WebElement sslButton;
	WebElement tutorial01;
	WebElement tutorial02;
	WebElement tutorial03;
	WebElement tutorial04;
	*/
	
	private TestUtilObjectParts(WebDriver driver) {
		//super(driver);
	}
	
	
	public static void checkSsl(WebDriver driver){
		if(driver.findElements(By.id("続ける")).size() > 0){
			driver.findElement(By.id("続ける")).click();
		}
	}

	public static void checkPush(WebDriver driver){
		if(driver.findElements(By.id("OK")).size() > 0){
			driver.findElement(By.id("OK")).click();
		}
	}
	
	public static void checkFox(WebDriver driver){
		if(driver.findElements(By.id("完了")).size() > 0){
			driver.findElement(By.id("完了")).click();
		}
	}
	
	public static void checkTutorial(WebDriver driver){
		if(driver.findElements(By.id("tutorial01")).size() > 0){
			driver.findElement(By.xpath("//UIAApplication")).click();
		}
		if(driver.findElements(By.id("tutorial02")).size() > 0){
			driver.findElement(By.xpath("//UIAApplication")).click();
		}
		if(driver.findElements(By.id("tutorial03")).size() > 0){
			driver.findElement(By.xpath("//UIAApplication")).click();
		}
		if(driver.findElements(By.id("tutorial04")).size() > 0){
			driver.findElement(By.xpath("//UIAApplication")).click();
		}
		if(driver.findElements(By.id("tutorial05")).size() > 0){
			driver.findElement(By.xpath("//UIAApplication")).click();
		}
	}
	
	public static void checkConsiderPh(WebDriver driver){
		if(driver.findElements(By.id("決まった")).size() > 0){
			driver.findElement(By.id("決まった")).click();
			driver.findElement(By.id("回答しない")).click();
			driver.findElement(By.id("決定")).click();
			driver.findElement(By.id("閉じる")).click();
		}
	}
	
}
