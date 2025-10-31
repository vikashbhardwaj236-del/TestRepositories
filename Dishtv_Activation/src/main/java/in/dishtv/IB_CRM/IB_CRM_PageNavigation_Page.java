package in.dishtv.IB_CRM;

import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;

public class IB_CRM_PageNavigation_Page extends BaseLibrary {

	SoftAssert assertdata = new SoftAssert();
	@FindBy(xpath = "//*[@id='ctl00_RadMenu1']/ul/li[2]/a/span")
	private WebElement customerservice_link;
	@FindBy(xpath = "//*[@id='ddlSearchType']")
	private WebElement Ddp_VCNo;
	@FindBy(xpath = "//*[@id='txtVCNo'][@name='txtVCNo']")
	private WebElement TxtVCNo;
	@FindBy(xpath = "//*[@type='image'][@src='../../Images/CustomerService/Blue arrow.ico']")
	private WebElement Btn_ProcessVC;

	public IB_CRM_PageNavigation_Page() {
		super();
		PageFactory.initElements(driver, this);
	}

	public void IB_CRM_Page_Title() {
		try {
			Thread.sleep(2000);
			System.out.println("Title of Page : " + driver.getTitle());
			assertdata.assertTrue(driver.getTitle().equalsIgnoreCase("DishTV :: Landing Page"), "Title Mistatch");
			assertdata.assertAll();
		} catch (Exception e) {
			ApplicationUtilities.Fun_PassScreenshot(driver, "IB_CRM_Isue");
			System.out.println("Problem in Title mismatch in CRM home page" + e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// Verify the title of customer service page
	public void IB_CRM_Page_Navigation() {
		try {
			customerservice_link.click();
			Thread.sleep(6000);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			Thread.sleep(3000);
			System.out.println("Title of Page : " + driver.getTitle());
			//assertdata.assertTrue(driver.getTitle().equalsIgnoreCase("DishTV :: Customer Service"), "Title Mistatch");
			//assertdata.assertAll();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Problem in Title mismatch in customer service page" + e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// VC process
	public void IB_CRM_VC_Process(String strVC, String strDDP) {
		try {
			TxtVCNo.clear();
			ApplicationUtilities.dropdownTextContains(Ddp_VCNo, strDDP);
			Thread.sleep(2000);
			TxtVCNo.sendKeys(strVC);
			Thread.sleep(2000);
			Btn_ProcessVC.click();
			Thread.sleep(5000);
			ApplicationUtilities.getTextandCloseAlert(driver);
			Close_Popup();
			ApplicationUtilities.getTextandCloseAlert(driver);

		} catch (Exception e) {
			System.out.println("Problem in VC process." + e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// Switch to new window opened
	public static void Close_Popup() {

		try {
			String winHandleBefore = driver.getWindowHandle();
			String str = "";
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				str = driver.switchTo().window(winHandle).getTitle();
				if (str.contains(":: Subscriber Offers ::")) {
					driver.close();
					break;
				}

			}

			driver.switchTo().window(winHandleBefore);
		} catch (Exception e) {
			System.out.println("Issue in close the popup !");
		}
	}

}
