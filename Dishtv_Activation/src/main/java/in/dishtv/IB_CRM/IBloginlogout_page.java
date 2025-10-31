package in.dishtv.IB_CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;

public class IBloginlogout_page extends BaseLibrary
{

	public IBloginlogout_page()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlUserType\"]")
	private WebElement UsertypeDropdown;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtUserID\"]")
	private WebElement UserId;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtPassword\"]")
	private WebElement Password;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnLogin\"]")
	private WebElement SignIn;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_imgBtnDishtv\"]")
	private WebElement Dishtv_content_btn;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	
	
	public void loginIBCRM(String Dealertypecrm,String useridDealerID, String passDealerID)
	{
		try {
			
			ApplicationUtilities.dropdownTextEqualIgnoreCase(UsertypeDropdown, Dealertypecrm);
		
			UserId.sendKeys(useridDealerID);
		
			Password.sendKeys(passDealerID);
		
			SignIn.click();
			
			
		} catch (Exception e) 
		{
			System.out.println("Issue in loginIBCRM method.");
			Reporter.log(e.getLocalizedMessage(), true);
			
		}
		
	}
	
	public void logoutIBCRM() 
	{
		try {
			Thread.sleep(3000);
			logout.click();
			} catch (Exception e)
			{
			System.out.println("Issue in logoutIBInstalationCRM method.");
			Reporter.log(e.getLocalizedMessage(), true);
			}
	
	}
	
	public void IBLoginInValidUseridValidPass(String Dealertypecrm, String useridDealerID, String passDealerID)
	{
		try 
		{
			ApplicationUtilities.dropdownTextEqualIgnoreCase(UsertypeDropdown, Dealertypecrm);
			UserId.sendKeys(useridDealerID);
			Thread.sleep(3000);
			Password.sendKeys(passDealerID);
			Thread.sleep(3000);
			SignIn.click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.navigate().refresh();
		} catch (Exception e) 
		{
			System.out.println("Issue in InstallationLoginInValidUseridValidPass method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}
	
	public void IBLoginValidUseridInValidPass(String Dealertypecrm, String useridDealerID, String passDealerID)
	{
		try 
		{
			ApplicationUtilities.dropdownTextEqualIgnoreCase(UsertypeDropdown, Dealertypecrm);
			Thread.sleep(3000);
			UserId.sendKeys(useridDealerID);
			Thread.sleep(3000);
			Password.sendKeys(passDealerID);
			Thread.sleep(3000);
			SignIn.click();
			Thread.sleep(3000);
			driver.navigate().refresh();
		} catch (Exception e) 
		{
			System.out.println("Issue in InstallationLoginValidUseridInValidPass method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}
	
	public void IBLoginUseridPass_Blank()
	{
		try 
		{
			SignIn.click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.navigate().refresh();
		} catch (Exception e) 
		{
			System.out.println("Issue in InstallationLoginUseridPass_Blank method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}
	public void IBLoginInValidUseridInValidPass(String Dealertypecrm, String useridDealerID, String passDealerID)
	{
		try 
		{
			ApplicationUtilities.dropdownTextEqualIgnoreCase(UsertypeDropdown, Dealertypecrm);
			Thread.sleep(3000);
			UserId.sendKeys(useridDealerID);
			Thread.sleep(3000);
			Password.sendKeys(passDealerID);
			Thread.sleep(3000);
			SignIn.click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.navigate().refresh();
		} catch (Exception e) 
		{
			System.out.println("Issue in InstallationLoginInValidUseridInValidPass method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}
}

