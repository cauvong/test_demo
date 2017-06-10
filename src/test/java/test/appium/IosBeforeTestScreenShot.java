package test.appium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;

import io.appium.java_client.ios.IOSDriver;

/**
 * @author CuongNV31
 */
public class IosBeforeTestScreenShot {
	IOSDriver<WebElement> driver;
	public int caseCount;
	public String rootScreenDir = "screenshot";
	public String screenDir;
	
	IosBeforeTestScreenShot(IOSDriver<WebElement> driver, int caseCount){
		this.driver = driver;
		this.caseCount = caseCount;
	}
	
	public void beforeMethod(){
		caseCount++;
		screenDir = rootScreenDir + "/case_" + String.format("%03d", caseCount) + "/";
		mkdir(screenDir);
		ss("before.jpg");
	}
	
	public void afterMethod(){
		ss("after.jpg");
	}
	
	// Take screen shot to check
	public void ss(String path) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
			FileUtils.copyFile(
					ts.getScreenshotAs(OutputType.FILE),
					new File(screenDir + path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Create Directory
	private void mkdir(String dirPath){
		File f = new File(dirPath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}
}
