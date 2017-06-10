
package test.appium.procedure;

import org.openqa.selenium.WebDriver;

/**
 * This class Login Implements procedure how to
 * access Login Procedure No.01
 * 
 * @author CuongNV31
 */
public class LoginProcedure extends AbstractBaseProcedure {

	public LoginProcedure(WebDriver driver) {
		super(driver);
	}

	/**
	 * Procedure No.01
	 */
	public void loginScreen() {
		this.startApplication();
	}

}
