package in.dishtv.IB_CRM_Dishtv;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import in.dishtv.IB_CRM.IBloginlogout_page;
import in.dishtv.library.BaseLibrary;
import in.dishtv.library.PropertiesLib;

public class IBloginlogout_test extends BaseLibrary
{
	in.dishtv.IB_CRM.IBloginlogout_page login;
	
	String usertype=PropertiesLib.getPropertyValue("usertypecrm");
	String userid=PropertiesLib.getPropertyValue("useridcrm");
	String password=PropertiesLib.getPropertyValue("passwordcrm");
	String urlIBinstallation=PropertiesLib.getPropertyValue("urlcrm");
	
	@Test(priority=1,enabled=true)
	public void ActivationULRlaunch()
	{
		try {
			login=new IBloginlogout_page();
			initializeApplication(urlIBinstallation);
			
		} catch (Exception e) 
		{
			System.out.println("ActivationULRlaunch "+e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
		
	}
	
	@Test(priority=2,enabled=true)
	public void IBLoginValidUseridValidPassword()
	{
		try {
			login=new IBloginlogout_page();
			login.loginIBCRM(usertype, userid, password);
		} catch (Exception e) 
		{
			System.out.println("InstallationLoginValidUseridValidPassword "+e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
		
	}
	
	@Test(priority=3,enabled=false)
	public void logoutIBCRM()
	{
		try
		{
			login=new IBloginlogout_page();
			login.logoutIBCRM();
		} catch (Exception e) 
		{
			System.out.println("logoutIBInstalationCRM"+e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
		
	}
	
	@Test(priority=4,enabled=false)
	public void IBLoginInValidUseridValidPassword()
	{
		try {
			login=new IBloginlogout_page();
			Assert.assertEquals(driver.getTitle(), "DishTV :: Home");
			login.IBLoginInValidUseridValidPass(usertype, "invalid", password );
			
		} catch (Exception e) 
		{
			System.out.println("InstallationLoginInValidUseridValidPassword "+e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
		
	}
	
	@Test(priority=5,enabled=false)
	public void IBLoginValidUseridInValidPassword()
	{
		try {
			login=new IBloginlogout_page();
		
			Assert.assertEquals(driver.getTitle(), "DishTV :: Home");
			login.IBLoginValidUseridInValidPass(usertype, userid, "Invalid");
		} catch (Exception e) 
		{
			System.out.println("InstallationLoginValidUseridInValidPassword "+e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
		
	}
	
	@Test(priority=6,enabled=false)
	public void IBLoginUseridPassword_Blank()
	{
		try {
			login=new IBloginlogout_page();
			
			Assert.assertEquals(driver.getTitle(), "DishTV :: Home");
			login.IBLoginUseridPass_Blank();
		} catch (Exception e) 
		{
			System.out.println("InstallationLoginUseridPassword_Blank "+e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
		
	}
	
	@Test(priority=7,enabled=false)
	public void IBLoginInValidUseridInValidPassword()
	{
		try {
			login=new IBloginlogout_page();
			Assert.assertEquals(driver.getTitle(), "DishTV :: Home");
			login.IBLoginInValidUseridInValidPass(usertype, "Invalid", "Invalid");
		} catch (Exception e) 
		{
			System.out.println("InstallationLoginInValidUseridInValidPassword "+e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
		
	}
}

