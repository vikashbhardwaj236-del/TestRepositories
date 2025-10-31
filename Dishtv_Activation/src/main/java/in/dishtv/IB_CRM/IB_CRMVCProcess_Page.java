package in.dishtv.IB_CRM;

import java.sql.ResultSet;
import java.util.concurrent.CopyOnWriteArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import in.dishtv.library.ApplicationUtilities;

import in.dishtv.library.BaseLibrary;
import in.dishtv.library.DatabaseConnection;
import in.dishtv.library.ExcelUtilities;

/**
 * @author Vivek Kumar
 *
 */
public class IB_CRMVCProcess_Page extends BaseLibrary {
	String StrPath = System.getProperty("user.dir") + "//testdata//DishD2h_Phoenix_Two.xlsx";
	ExcelUtilities xls = new ExcelUtilities(StrPath);
	String SheetName = "Data_Activation";
	IB_CRM_Utility CRMUtitliy = new IB_CRM_Utility();

	public IB_CRMVCProcess_Page() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"imgBtnMore\"]")
	private WebElement More;
	@FindBy(xpath = "//*[@id=\"imgbtnPayLater\"]")
	private WebElement Paylater;
	@FindBy(xpath = "//*[@id='ddlSearchType']")
	private WebElement Ddp_VCNo;
	@FindBy(id = "imgBtTechCall")
	private WebElement techcall;
	@FindBy(xpath = "//*[@id=\"txtPhoneComp\"]")
	private WebElement complmobile;
	@FindBy(xpath = "//*[@id=\"txtAlternateNo\"]")
	private WebElement complaltmobile;
	@FindBy(xpath = "//*[@id=\"btnSaveComplaint\"]")
	private WebElement complSave;
	@FindBy(xpath = "//*[@id=\"lnkErrorMessage\"]")
	private WebElement complalclose;

	// ===========
	@FindBy(xpath = "//*[@id=\"divRenewalTab\"]/div")
	private WebElement rene_amt;

	@FindBy(xpath = "//*[@id=\"grdRSA\"]/tbody/tr[3]/td[2]")
	private WebElement last_row;

	@FindBy(xpath = "//*[@id=\"RadToolBar1\"]/div/div/div/ul/li[2]/a/span/span/span/span")
	private WebElement soa;

	@FindBy(xpath = "//*[@id=\"tcSOA_tabSOADetailed_lblBalDetailed\"]")
	private WebElement rs;

	@FindBy(xpath = "//*[@id=\"txtRenewalDate\"]")
	private WebElement switch_off;

	@FindBy(xpath = "//*[@id=\"RadToolBar1\"]/div/div/div/ul/li[11]/a/span/span/span/span[1]")
	private WebElement verify_pkg;

	@FindBy(xpath = "//*[@id=\"formMain\"]/div[1]/div/ul/li[1]/a/span")
	private WebElement verify_pack;

	@FindBy(xpath = "//*[@id=\"gvPKGDetails\"]/tbody/tr[3]/td[1]")
	private WebElement package_name;

	@FindBy(xpath = "//*[@id=\"grdRSA\"]/tbody/tr[3]/td[1]")
	private WebElement pack_id;

	@FindBy(xpath = "//*[@id=\"grdRSA\"]/tbody/tr[3]/td[3]")
	private WebElement pack_price;

	@FindBy(xpath = "//*[@id=\"repRenamount_ctl01_lblGrandTotalPrice\"]")
	private WebElement total_price;

	@FindBy(xpath = "//*[@id=\"updpnlPayterm\"]/div/table/tbody/tr[6]/td[1]")
	private WebElement recharge_amt;

	// Verify page navigation
	public void Pagenavigation() {
		try {
			IB_CRM_PageNavigation_Page IBN = new IB_CRM_PageNavigation_Page();
			IBN.IB_CRM_Page_Title();
			IBN.IB_CRM_Page_Navigation();
			String strVC = xls.getCellData(SheetName, "VC No", 2);
			//strVC = "02514144699";
			test(strVC);

		} catch (Exception ex) {
			System.out.println("Exception in page Navigation" + ex.getMessage());
			Reporter.log(ex.getLocalizedMessage(), true);
		}
	}

	// Verify page navigation
	public void test(String str) {
		try {
			IB_CRM_PageNavigation_Page IBN = new IB_CRM_PageNavigation_Page();
			IBN.IB_CRM_VC_Process(str, "VC No");
			int i = Process(str);
			if (i == 0) {
				for (int k = 0; k <= 10; k++) {
					IBN.IB_CRM_VC_Process(str, "VC No");
					Thread.sleep(3000);
					System.out.println("Re-processing VC again ...");
				}
				if(i==0)
				{
					System.out.println("Activation process Fail");
				}
				else
				{
					System.out.println("Activation process Done");
				}

			}

			/*
			 * String switchdate = ""; getdate(switchdate); Thread.sleep(5000); if
			 * (switchdate != "NA") { for (int i = 0; i <= 10; i++) {
			 * IBN.IB_CRM_VC_Process(str, "VC No"); getdate(switchdate); } if (switchdate !=
			 * "NA") { System.out.println("Activation process Fail"); } } else {
			 * System.out.println("Activation process Fail"); }
			 */

		} catch (Exception ex) {
			System.out.println("Exception in page Paylater Service" + ex.getMessage());
			Reporter.log(ex.getLocalizedMessage(), true);
		}
	}

	public int Process(String str) {
		try {
			int i;
			DatabaseConnection Objcon1 = new DatabaseConnection(serverNode1, DBuserIDNode1, DBPassNode1,
					DBnameNode1SMSDTH2003);
			ResultSet result = Objcon1.executeQuery("select * from SubscriberMaster where VCNo=" + "'" + str + "'");
			i = result.getRow();
			return i;

		} catch (Exception ex) {
			System.out.println("Exception in page Paylater Service" + ex.getMessage());
			Reporter.log(ex.getLocalizedMessage(), true);
		}
		return 0;
	}

	public void CustomerNotInfrontOfTV() {
		try {
			techcall.click();
			Thread.sleep(2000);
			CRMUtitliy.Trobleshootifrm(driver, "STB Not Working");
			CRMUtitliy.CustomerinfrontofTV_No(driver);
			Fill_Complaint_Details();
		} catch (Exception ex) {

		}

	}

	public void CustomerNotfrontofTV() {
		try {
			techcall.click();
			Thread.sleep(2000);
			CRMUtitliy.Trobleshootifrm(driver, "STB Not Working");
			CRMUtitliy.CustomerinfrontofTV_No(driver);
			Fill_Complaint_Details();
		} catch (Exception ex) {

		}

	}

	public void CustomerInfrontOfTV() {
		try {
			techcall.click();
			Thread.sleep(2000);
			CRMUtitliy.Trobleshootifrm(driver, "STB Not Working");
			CRMUtitliy.CustomerInfrontofTV(driver);
			// Fill_Complaint_Details();
			driver.navigate().refresh();
		} catch (Exception ex) {

		}

	}

	public void Fill_Complaint_Details() {
		try {
			String winHandleBefore = driver.getWindowHandle();
			String strMSG = "";
			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				strMSG = driver.switchTo().window(winHandle).getTitle();
				Thread.sleep(2000);
				Thread.sleep(2000);
				if (strMSG.contains(":: Request ::")) {
					complalclose.click();
					Thread.sleep(2000);
					strMSG = ApplicationUtilities.Dynamic_MobileNo();
					complmobile.sendKeys(strMSG);
					Thread.sleep(2000);
					strMSG = ApplicationUtilities.Dynamic_MobileNo();
					complaltmobile.sendKeys(strMSG);
					Thread.sleep(2000);
					complSave.click();
					Thread.sleep(3000);
					strMSG = ApplicationUtilities.getTextandCloseAlert(driver);
					System.out.println(strMSG);

				}

			}

			driver.switchTo().window(winHandleBefore);
		} catch (Exception ex) {
			System.out.println("Exception in Fillcomplaint" + ex);
		}
	}

	// To verify renewal amount

	public void renewal_amt() {
		try {

			driver.switchTo().frame("ifSubInfoPersonal");
			rene_amt.click();
			ApplicationUtilities.Fun_PassScreenshot(driver, "Renewal Amt");
			for (String handle : driver.getWindowHandles()) {

				driver.switchTo().window(handle);
			}
			driver.findElement(By.id("grdRSA"));

			String pack_id1 = pack_id.getText();
			System.out.println("ID: " + pack_id1);

			String pack_name = last_row.getText();
			System.out.println("Pack_Name " + pack_name);

			String pck_price = pack_price.getText();
			System.out.println("Pack_Price " + pck_price);

			driver.findElement(By.xpath("//*[@id=\"updpnlPayterm\"]/div/table"));

			String recharge_amt1 = recharge_amt.getText();
			System.out.println(recharge_amt1);

			String total_price1 = total_price.getText();
			System.out.println(total_price1);
			Thread.sleep(5000);
			driver.close();
			for (String handle : driver.getWindowHandles()) {

				driver.switchTo().window(handle);
			}

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Renewal_amt");
			System.out.println("Issue in renewal amount");

		}

	}

	// To verify SOA value

	public void soa() {
		try {
			String RS = "";
			String strvalue = "";
			float fvalue;
			Thread.sleep(5000);
			soa.click();
			ApplicationUtilities.Fun_PassScreenshot(driver, "SOA");
			for (String handle : driver.getWindowHandles()) {

				driver.switchTo().window(handle);
			}
			strvalue = rs.getText();
			strvalue = (String) strvalue.subSequence(0, 4);
			fvalue = Float.parseFloat(strvalue);
			// rs.getText();
			System.out.println("SOA Cr Amount - " + fvalue);
			// int SOA = Integer.parseInt(RS.replaceAll("[\\D]", ""));
			if (fvalue >= 10) {
				System.out.println("Issue in billing. ");
			} else {
				System.out.println("SOA value is correct.");
			}
			Thread.sleep(5000);
			driver.close();
			for (String handle : driver.getWindowHandles()) {

				driver.switchTo().window(handle);
			}

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "SOA");
			System.out.println("Issue in SOA");
		}
	}

	// To verify Switch off date
	public void Switch_off_date() {
		try {
			Thread.sleep(5000);
			ApplicationUtilities.Fun_PassScreenshot(driver, "IBPage");
			driver.switchTo().frame("ifSubInfoTechnical");
			String switchdate = switch_off.getAttribute("value");

			System.out.println(switchdate);
			for (String handle : driver.getWindowHandles()) {

				driver.switchTo().window(handle);
			}
			Thread.sleep(5000);

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Switchoff_Date");
			System.out.println("Issue in Switch off date");
		}

	}

	// To verify package window
	public void verify_package() {

		try {
			Thread.sleep(5000);
			verify_pkg.click();
			ApplicationUtilities.Fun_PassScreenshot(driver, "Packge");
			Thread.sleep(1000);
			verify_pack.click();
			for (String handle : driver.getWindowHandles()) {

				driver.switchTo().window(handle);
			}
			driver.findElement(By.id("tblSelectButton"));
			driver.switchTo().frame("IframPopUP");
			String pack = package_name.getText();
			System.out.println(pack);
			for (String handle : driver.getWindowHandles()) {

				driver.switchTo().window(handle);
			}
			driver.findElement(By.xpath("//*[@id=\"imgClose\"]")).click();
			Thread.sleep(5000);
		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Package");
			System.out.println("Issue in package");
		}

	}

}
