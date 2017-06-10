package test.appium.execute;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.appium.procedure.LoginProcedure;
import test.appium.test.TestLoginScreen;

import static org.testng.Assert.assertEquals;


/**
 * This class contain testcase for procedure No 1
 *  
 *  @author CuongNV31
 */
public class TestNo02 extends AbstractAndroidBaseExecute {

	@BeforeMethod
	public void beforeMethod() {
		LoginProcedure loginProcedure = new LoginProcedure(driver);
		loginProcedure.loginScreen();
	}

	@Test
	public void case03() {
		TestLoginScreen testLoginScreen = new TestLoginScreen(driver);
		testLoginScreen.checkLoginScreenAndroid();
		assertEquals(checkResultAndroid("//android.widget.Button[@text='Send']"), true);
	}

	@Test
	public void case04() {
		TestLoginScreen testLoginScreen = new TestLoginScreen(driver);
		testLoginScreen.checkLoginFailScreenAndroid();
//		assertEquals(checkResult("Alert"), true);
	}
}
