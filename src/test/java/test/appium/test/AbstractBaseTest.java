package test.appium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.appium.util.MoveUtil;

/**
 *  This class all Screen Class must extends this class
 *  Because this class Menu function elements.
 * 
 *  
 *  @author Tiritiri
 */

public abstract class AbstractBaseTest {
	
	WebDriver driver;
	//メニューだけは定義しておく
	WebElement menuHomeButton;
	WebElement menuDandoriButton;
	WebElement menuWeddingRingButton;
	WebElement menuClipListButton;
	WebElement menuMenuButton;

	public AbstractBaseTest(WebDriver driver) {
		this.driver = driver;
		//Judge WebView or Native View
		if(driver.findElements(By.id("ホーム")).size() > 0){
			menuHomeButton = driver.findElement(By.id("ホーム"));
			menuDandoriButton = driver.findElement(By.id("ダンドリ"));
			menuWeddingRingButton = driver.findElement(By.id("式場・指輪検索"));
			menuClipListButton = driver.findElement(By.id("クリップ一覧"));
			menuMenuButton = driver.findElement(By.id("メニュー"));
		}
		
	}
	
	public void movedandoriPage() {
//		menuDandoriButton.click();
		MoveUtil.clickAtPosition(driver, "//UIAApplication[1]/UIAWindow[2]", 112, 632);
	}
	
	public void moveHomePage() {
//		menuHomeButton.click();
		MoveUtil.clickAtPosition(driver, "//UIAApplication[1]/UIAWindow[2]", 39, 632);
		//TestUtilObjectParts.checkConsiderPh(driver);
		//TestUtilObjectParts.checkTutorial(driver);
	}
	
	public void moveMenuPage() {
//		menuMenuButton.click();
		MoveUtil.clickAtPosition(driver, "//UIAApplication[1]/UIAWindow[2]", 336, 632);
	}
	
	public void moveWeddingRingPage() {
//		menuWeddingRingButton.click();
		MoveUtil.clickAtPosition(driver, "//UIAApplication[1]/UIAWindow[2]", 186, 632);
	}
	
	public void moveClipPage() {
//		menuClipListButton.click();
		MoveUtil.clickAtPosition(driver, "//UIAApplication[1]/UIAWindow[2]", 261, 632);
	}

	public void clickOn(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void sendKeys(String id, String keys) {
		driver.findElement(By.id(id)).sendKeys(keys);
	}

}
