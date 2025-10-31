package in.dishtv.Activation;

import org.testng.Assert;
import org.testng.annotations.Test;

import in.dishtv.genericpages.BasePage;
import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;
import in.dishtv.library.PropertiesLib;
import in.dishtv.library.WaitStatementsLib;

public class PhoenixLoginTest extends BaseLibrary{
	PhoenixLoginPage login;
	BasePage base;
	String usertype=PropertiesLib.getPropertyValue("usertypephoenix");
	String userid=PropertiesLib.getPropertyValue("useridphoenix");
	String password=PropertiesLib.getPropertyValue("passwordphoenix");
	String urlphoenix=PropertiesLib.getPropertyValue("urlphoenix");
	
	@Test(priority=1,enabled=true)
	public void phoenixLoginValidUseridValidPassword() {
		login=new PhoenixLoginPage();
		base=new BasePage();
		initializeApplication(urlphoenix);
		String s=driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Phoenix :: User Login");
		login.loginPhoenix(usertype, userid, password);
		WaitStatementsLib.pageLoadWait(driver, 200);
		//Assert.assertTrue(base.getLogoPhoenixHomepage().isDisplayed());
		
	}
	@Test(enabled=false)
	public void phoenixLogout() {
		login=new PhoenixLoginPage();
		login.logoutPhoenix();
		WaitStatementsLib.waitForSeconds(driver, 10);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());
	}
	@Test(enabled=false)
	public void phoenixLoginInvalidUseridValidPassword() {
		login=new PhoenixLoginPage();
		base=new BasePage();
		initializeApplication(urlphoenix);
		Assert.assertEquals(driver.getTitle(), "Dishtv Biz");
		login.loginPhoenix(usertype, "invalid", password);
		WaitStatementsLib.pageLoadWait(driver, 180);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());
	}
	
	@Test(enabled=false)
	public void phoenixLoginValidUseridInvalidPassword() {
		login=new PhoenixLoginPage();
		base=new BasePage();
		initializeApplication(urlphoenix);
		Assert.assertEquals(driver.getTitle(), "Dishtv Biz");
		login.loginPhoenix(usertype, userid, "invalid");
		WaitStatementsLib.pageLoadWait(driver, 180);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());
	}
	@Test(enabled=false)
	public void phoenixLoginBlankValidation(){
		login=new PhoenixLoginPage();
		base=new BasePage();
		initializeApplication(urlphoenix);
		Assert.assertEquals(driver.getTitle(), "Dishtv Biz");
		ApplicationUtilities.click(login.getBtnsignin());
		WaitStatementsLib.pageLoadWait(driver, 180);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());
	}
	@Test(invocationCount=2,enabled=false)
	public void phoenixLoginInValidUseridInvalidPassword() {
		login=new PhoenixLoginPage();
		base=new BasePage();
		initializeApplication(urlphoenix);
		Assert.assertEquals(driver.getTitle(), "Dishtv Biz");
		login.loginPhoenix(usertype, "invalid", "invalid");
		WaitStatementsLib.pageLoadWait(driver, 180);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());
	}
	
}
















