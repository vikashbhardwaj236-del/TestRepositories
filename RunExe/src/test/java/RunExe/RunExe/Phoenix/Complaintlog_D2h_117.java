package RunExe.RunExe.Phoenix;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import baseLib.ApplicationUtilities;
import baseLib.DatabaseConnection;
import baseLib.ExcelUtilities;

public class Complaintlog_D2h_117 {
	static WebDriver driver;	
	public static ExcelUtilities Exls = new ExcelUtilities("D:\\RunExe\\Complaintlog\\ComplaintLog_D2h_117.xlsx");
	public static String Strsheet = "Complaint";
	public static String Strsheet1 = "SQL";
	public static DatabaseConnection Objcon;
	public static String rowid = "";
	// public static String strq = "SELECT Top ";

	public static String strYesvalue = "";
	public static int j = 2;

	static String Missedsheet = "Complaint";
	static String Config_Sheet = "DBConfig";
	String StrCurrentDT = ApplicationUtilities.Fun_DateTime();
	static public String DTserverNode1 = Exls.getCellData(Config_Sheet, "Value", 2);
	static public String DTserverNode2 = Exls.getCellData(Config_Sheet, "Value", 3);
	static public String DTserverNode3 = Exls.getCellData(Config_Sheet, "Value", 4);
	static public String DTDBuserID = Exls.getCellData(Config_Sheet, "Value", 5);
	static public String DTDBPass = Exls.getCellData(Config_Sheet, "Value", 6);
	static public String DTDBPass1 = Exls.getCellData(Config_Sheet, "Value", 7);
	static public String DT_India_DB = Exls.getCellData(Config_Sheet, "Value", 8);
	static public String DT_India_SR_DB = Exls.getCellData(Config_Sheet, "Value", 9);
	static public String DT_SMSDTH_DB = Exls.getCellData(Config_Sheet, "Value", 9);
	
	public static void main(String[] args) {

		Openbrowser();
		Loginonpage();
		dataprationnew();
		// datapration();
		// VCProcess();
		ApplicationUtilities.Fun_DriverQuit(driver);

	}

	public static void Openbrowser() {
		try {
			
			System.setProperty("webdriver.chrome.driver", "D:\\RunExe\\Complaintlog\\chromedriver.exe");
			driver = new ChromeDriver();		
		
			driver.get("https://beta2-inbound.d2h.com/");
			driver.manage().window().maximize();
			ApplicationUtilities.Fun_PassScreenshot(driver, "Browser open");
		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Login Fail");
			
			System.out.println(ex);
			
		}
	}

	public static void Loginonpage() {
		try {

			driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserID")).sendKeys("123456");
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys("azure@123");
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin")).click();
			waitForPageLoad(driver);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='ctl00_RadMenu1']/ul/li[2]/a/span")).click();
			Thread.sleep(2000);
			ApplicationUtilities.Fun_PassScreenshot(driver, "Login Pass");
		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Login Fail");
			System.out.println(ex);
		}
	}

	

	public static void filldatainEXL(int irow) {
		try {

		} catch (Exception ex) {
			try {
				Objcon.con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			System.out.println(ex);
		}
	}

	public static void dataprationnew() {

		String strvalue = Exls.getCellData(Strsheet, "auto / Manual", 2);
		if (strvalue.toUpperCase().equalsIgnoreCase("AUTOMATIC")) {
			Objcon = new DatabaseConnection(DTserverNode2, DTDBuserID, DTDBPass, DT_India_SR_DB);
			try {

				// int irowcount = Exls.getRowCount(Strsheet);

				String sry = Exls.getCellData(Strsheet1, 0, 2);
				ResultSet result1;

				result1 = Objcon.executeQuery(sry);

				int size = 0;
				if (result1 != null) {
					result1.last();
					size = result1.getRow();
					if (size == 0) {
						System.out.println("Data not found!");
						Objcon.con.close();
					}
				}
				
				if (size != 1) {
					result1.beforeFirst();
					int illop = 1;
					while (result1.next()) {

						{
							illop++;

							rowid = result1.getString("D2HCustomerID");
							Exls.setCellData(Strsheet, "D2HCustomerID", illop, rowid);
							VCProcessautomatic(illop);
						}

					}
				}

				Objcon.con.close();
			} catch (Exception ex) {
				try {
					Objcon.con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println(ex);
			}
		} else {
			VCProcess();
		}

	}

	public static void filldatavalueinEXL(int irow) {
		try {
			String sry = Exls.getCellData(Strsheet1, 0, 2);
			ResultSet result1;
			if (irow == 2) {
				result1 = Objcon.executeQuery(sry + ")");

			} else {
				String strvalue = Exls.getCellData(Strsheet, "D2HCustomerID", irow - 1);
				if (strvalue.equalsIgnoreCase("")) {
					sry = sry + strvalue + "," + "999" + ")";
				} else {
					strvalue = "," + strvalue + ")";
					sry = sry + strvalue;
				}
				result1 = Objcon.executeQuery(sry);

			}

			int size = 0;
			if (result1 != null) {
				result1.last();
				size = result1.getRow();
				if (size == 0) {
					System.out.println("Data not found!");
					Objcon.con.close();
				}
			}

			result1.beforeFirst();
			while (result1.next()) {

				{

					rowid = result1.getString("D2HCustomerID");
					Exls.setCellData(Strsheet, "D2HCustomerID", irow, rowid);
					VCProcessautomatic(irow);
				}

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void Typeselection() {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(3000);
			Select sel = new Select(driver.findElement(By.id("ddlSearchType")));
			sel.selectByVisibleText("Customer ID");
			ApplicationUtilities.Fun_PassScreenshot(driver, "Customer id selection Pass");
		} catch (Exception e) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Customer id selection Fail");
			System.out.println("Issue in selection of drop down");
			System.out.println(e);
		}

	}

	public static void VCProcess() {
		try {
			int icount = Exls.getRowCount(Strsheet);
			for (int i = 2; i <= icount; i++) {
				String strstatus = Exls.getCellData(Strsheet, "RunStatus", i);
				if (strstatus.toUpperCase().equalsIgnoreCase("YES")) {
					driver.navigate().refresh();
					waitForPageLoad(driver);
					Thread.sleep(3000);
					Typeselection();
					waitForPageLoad(driver);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id=\"txtVCNo\"]")).clear();
					driver.findElement(By.xpath("//*[@id=\"txtVCNo\"]"))
							.sendKeys(Exls.getCellData(Strsheet, "D2HCustomerID", i));
					driver.findElement(By.xpath("//*[@id=\"UpdatePanelProcess\"]/input")).click();
					waitForPageLoad(driver);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Customer ID process Pass - "
							+ driver.findElement(By.xpath("//*[@id=\"txtVCNo\"]")).getText());
					Thread.sleep(3000);
					ApplicationUtilities.getTextandCloseAlert(driver);
					Close_Popup();
					ApplicationUtilities.getTextandCloseAlert(driver);
					getexitingcomplaint();
					complaintlogprocess();
					Fill_Complaint_Details(i);

				} else {

				}

			}

		} catch (Exception e) {
			System.out.println("Issue in Input data ");
			System.out.println(e);
		}

	}

	public static void VCProcessautomatic(int i) {
		try {

			driver.navigate().refresh();
			waitForPageLoad(driver);
			Thread.sleep(3000);
			Typeselection();
			waitForPageLoad(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"txtVCNo\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"txtVCNo\"]"))
					.sendKeys(Exls.getCellData(Strsheet, "D2HCustomerID", i));
			driver.findElement(By.xpath("//*[@id=\"UpdatePanelProcess\"]/input")).click();
			waitForPageLoad(driver);
			ApplicationUtilities.Fun_PassScreenshot(driver,
					"Customer ID process Pass - " + driver.findElement(By.xpath("//*[@id=\"txtVCNo\"]")).getText());
			Thread.sleep(3000);
			ApplicationUtilities.getTextandCloseAlert(driver);
			Close_Popup();
			ApplicationUtilities.getTextandCloseAlert(driver);
			getexitingcomplaint();
			complaintlogprocess();
			Fill_Complaint_Details(i);

		} catch (Exception e) {
			System.out.println("Issue in Input data ");
			System.out.println(e);
		}

	}

	public static void waitForPageLoad(WebDriver driver) {

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	public static void complaintlogprocess() {
		try {
			Thread.sleep(3000);
			driver.switchTo().defaultContent();

			driver.findElement(By.xpath("//*[@id=\"imgBtTechCall\"]")).click();

			Thread.sleep(3000);
			waitForPageLoad(driver);
			Trobleshootifrm(driver,
					"No Power in Satellite Product (No Display on front panel / No LED glowing) Satellite BOX");
			waitForPageLoad(driver);
			Calllog(driver);

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Complaint Log process");
			System.out.println(ex);
		}
	}

	public static void waitForSeconds(WebDriver driver, int timeSeconds) {
		driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
	}

	public static void Calllog(WebDriver driver) {
		try {

			driver.switchTo().frame("iframePageBinding");
			waitForSeconds(driver, 3);
			driver.findElement(By.xpath("//*[@id=\"rdFrontOfTV_0\"]")).click();
			waitForSeconds(driver, 3);
			driver.findElement(By.xpath("//*[@id=\"rdLedPanel_1\"]")).click();
			waitForSeconds(driver, 3);
			driver.findElement(By.xpath("//*[@id=\"rdoChannelResume_1\"]")).click();
			waitForSeconds(driver, 3);
			driver.findElement(By.xpath("//*[@id=\"rdoOtherDeviceworking_0\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"rdobtnDishAlignment_2\"]")).click();
			Thread.sleep(2000);
			ApplicationUtilities.Scroll_Page_To_Bottom(driver);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_rdoAddasPerZT_0\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_chkverifyAddress\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_chkpincode\"]")).click();
			Thread.sleep(2000);
			ApplicationUtilities
					.dropdownIndex(driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_ddlLocality\"]")), 1);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_chkRMN\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_chkPhonenumber\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_txtCallPhoneNo\"]"))
					.sendKeys(ApplicationUtilities.Dynamic_MobileNo());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_chkAltNo\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_txtAltNo\"]"))
					.sendKeys(ApplicationUtilities.Dynamic_MobileNo());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_txtRemarks\"]"))
					.sendKeys("STB not Working " + ApplicationUtilities.Fun_DateTime());
			waitForSeconds(driver, 3);
			driver.findElement(By.xpath("//*[@id=\"ucUpdateCustNameAddress_btnCompltCall\"]")).click();
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			ApplicationUtilities.Fun_PassScreenshot(driver, "Complaint process");

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Complaint Log");
			System.out.println("Issue on CustomerinfrontofTV_No" + ex);
		}
	}

	public static void Trobleshootifrm(WebDriver driver, String Linkname) {
		try {
			Close_Popup();
			final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			for (WebElement iframe : iframes) {
				String str = iframe.getAttribute("id");

				driver.switchTo().frame(str);
				if (str.equalsIgnoreCase("IframPopUP")) {
					String strq = "";
					List<WebElement> allLinks = driver.findElements(By.tagName("a"));
					for (WebElement link : allLinks) {
						strq = link.getText();
						waitForSeconds(driver, 3);

						if (strq.equalsIgnoreCase(
								"No Power in Satellite Product (No Display on front panel / No LED glowing) Satellite BOX")) {
							driver.findElement(By.linkText(Linkname)).click();
							break;
						}

					}
				} else
					driver.switchTo().defaultContent();

			}
		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Issue in No power in product link");
			System.out.println("Issue in Trobleshoot page open" + ex);
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
			ApplicationUtilities.Fun_FailScreenshot(driver, "Issue in close popup");
			System.out.println("Issue in close the popup !");
		}
	}

	public static void Fill_Complaint_Details(int ivalue) {
		try {

			String winHandleBefore = driver.getWindowHandle();
			String strMSG = "";
			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				strMSG = driver.switchTo().window(winHandle).getTitle();
				Thread.sleep(2000);

				if (strMSG.contains(":: Request ::")) {

					driver.findElement(By.xpath("//*[@id=\"lnkErrorMessage\"]")).click();
					Thread.sleep(2000);
					strMSG = ApplicationUtilities.Dynamic_MobileNo();
					driver.findElement(By.xpath("//*[@id=\"txtPhoneComp\"]")).sendKeys(strMSG);
					Thread.sleep(2000);
					strMSG = ApplicationUtilities.Dynamic_MobileNo();
					driver.findElement(By.xpath("//*[@id=\"txtAlternateNo\"]")).sendKeys(strMSG);
					Thread.sleep(2000);
					ApplicationUtilities.dropdownIndex(driver.findElement(By.id("ddlDishtvSpaceReason")), 1);
					Thread.sleep(2000);
					driver.findElement(By.id("btnSaveComplaint")).click();
					Thread.sleep(3000);
					strMSG = ApplicationUtilities.getTextandCloseAlert(driver);
					System.out.println(strMSG);
					String strtokenno;
					strtokenno = extractInt(strMSG);
					Exls.setCellData(Strsheet, "TranID/Remarks", ivalue, strtokenno.trim());
					ApplicationUtilities.Fun_PassScreenshot(driver, "Complaint log - " + strtokenno.trim());
					ApplicationUtilities.getTextandCloseAlert(driver);

				}

			}

			driver.switchTo().window(winHandleBefore);
		} catch (Exception ex) {
			ApplicationUtilities.Fun_PassScreenshot(driver, "Complaint log Fail");
			System.out.println("Exception in Fillcomplaint" + ex);
		}
	}

	public static void getexitingcomplaint() {
		try {

			driver.switchTo().frame("ifCallHistory");
			Thread.sleep(3000);

			int istrvalue = driver.findElements(By.xpath("//*[@id=\"tcCallHistory_tabInbound_gvInbound\"]/tbody/tr[1]"))
					.size();
			if (istrvalue >= 1) {

				String strtoken1 = "//*[@id=\"tcCallHistory_tabInbound_gvInbound\"]/tbody/tr[";
				String strtoken2 = "]/td[1]";
				String strtoken3 = "";
				String strtokenFW1 = "//*[@id=\"tcCallHistory_tabInbound_gvInbound\"]/tbody/tr[";
				String strtokenFW2 = "]/td[5]";
				String strtokenFW3 = "";

				for (int i = 1; i <= istrvalue; i++) {
					i++;
					strtoken3 = driver.findElement(By.xpath(strtoken1 + i + strtoken2)).getText();
					strtokenFW3 = driver.findElement(By.xpath(strtokenFW1 + i + strtokenFW2)).getText();
					if (strtokenFW3.toUpperCase().equalsIgnoreCase("FW")) {
						UpdatecompliantasRS(strtoken3);
					}
				}

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void UpdatecompliantasRS(String strtoken) {
		DatabaseConnection Objconsrcrm = new DatabaseConnection("d2hUAT-N2.dishtv-india.com:21344", "vivek.kumar", "vivekkumar@2022",
				"D2H_SRCRM_2019");
		DatabaseConnection Objconsmsd2h = new DatabaseConnection("d2hUAT-N1.dishtv-india.com:21343", "vivek.kumar", "vivekkumar@2022",
				"SMSD2H2019");
		try {

			Objconsrcrm.executeupdate("update D2H_SRCRM_2019..complainttrn set status='RS'where rowid =" + strtoken);
			Objconsmsd2h.executeupdate("update SMSD2H2019..complainttrn set status='RS'where rowid =" + strtoken);
			Objconsrcrm.con.close();
			Objconsmsd2h.con.close();

		} catch (Exception ex) {
			try {
				Objconsrcrm.con.close();
				Objconsmsd2h.con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			System.out.println(ex);
		}
	}

	public static String extractInt(String str) {
		try {
			str = str.replaceAll("[^\\d]", " ");
			str = str.trim();
			str = str.replaceAll(" +", " ");
			str = str.replaceAll(" 9", " ");
			if (str.equals(""))
				return "-1";
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return str;
	}

}
