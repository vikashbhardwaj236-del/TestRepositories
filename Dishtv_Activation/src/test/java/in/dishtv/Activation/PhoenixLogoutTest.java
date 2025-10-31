package in.dishtv.Activation;

import org.testng.Assert;
import org.testng.annotations.Test;
import in.dishtv.genericpages.BasePage;
import in.dishtv.library.BaseLibrary;
import in.dishtv.library.WaitStatementsLib;

public class PhoenixLogoutTest extends BaseLibrary {
	PhoenixLogoutPage login;
	BasePage base;
	
	@Test(priority=1,enabled=true)
	public void phoenixLogout() {
		login = new PhoenixLogoutPage();
		login.logoutPhoenix();
		WaitStatementsLib.waitForSeconds(driver, 10);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());	
	}

}
