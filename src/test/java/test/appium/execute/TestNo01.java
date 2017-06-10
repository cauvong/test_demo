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
public class TestNo01 extends AbstractIOSBaseExecute {

	@BeforeMethod
	public void beforeMethod() {
		LoginProcedure loginProcedure = new LoginProcedure(driver);
		loginProcedure.loginScreen();
	}
	
	@Test
	public void case01() {
		TestLoginScreen testLoginScreen = new TestLoginScreen(driver);
		testLoginScreen.checkLoginScreenIOS();
		assertEquals(checkResult("New contact request"), true);
	}
	
	@Test
	public void case02() {
		TestLoginScreen testLoginScreen = new TestLoginScreen(driver);
		testLoginScreen.checkLoginFailScreenIOS();
		assertEquals(checkResult("Alert"), true);
	}
}
