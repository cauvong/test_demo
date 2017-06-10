package test.appium.procedure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *  This class all Screen Class must extends this class
 *  Because this class Menu function elements.
 * 
 *  
 *  @author CuongNV31
 */

public abstract class AbstractBaseProcedure {
	
	WebDriver driver;
	//メニューだけは定義しておく
	WebElement menuHomeButton;
	WebElement menuDandoriButton;
	WebElement menuWeddingRingButton;
	WebElement menuClipListButton;
	WebElement menuMenuButton;

	public AbstractBaseProcedure(WebDriver driver) {
		this.driver = driver;
		//Judge WebView or Native View
//		if(driver.findElements(By.id("ホーム")).size() > 0){
//			menuHomeButton = driver.findElement(By.id("ホーム"));
//			menuDandoriButton = driver.findElement(By.id("ダンドリ"));
//			menuWeddingRingButton = driver.findElement(By.id("式場・指輪検索"));
//			menuClipListButton = driver.findElement(By.id("クリップ一覧"));
//			menuMenuButton = driver.findElement(By.id("メニュー"));
//		}
		
	}
	
	protected void startApplication() {
		// Reset app to initial status
		System.out.println("--------startApplication--------");
	}
}
