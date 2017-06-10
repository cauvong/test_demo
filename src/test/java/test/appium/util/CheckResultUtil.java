package test.appium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *  This class Check Util
 *  
 *  @author CuongNV31
 */
public class CheckResultUtil {

	public static String getValueElement(final WebDriver driver, final String keys, final String xpath) {
		String result = driver.findElement(By.xpath(xpath)).getAttribute(keys);
		return result;
	}
}
