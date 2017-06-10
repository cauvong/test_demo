package test.appium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *  This class Move Util
 *  
 *  @author CuongNV31
 */

public class MoveUtil {

	public static void clickAtPosition(final WebDriver driver, final String xpath, final int x, final int y) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).moveByOffset(x, y).click().perform();
	}
}
