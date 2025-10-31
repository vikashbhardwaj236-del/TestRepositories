
package RunExe.RunExe;

import java.io.File;
import java.io.FilenameFilter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import baseLib.ApplicationUtilities;
import baseLib.BaseLibrary;
import baseLib.DatabaseConnection;
import baseLib.ExcelUtilities;

public class phoenix_Call_Close extends BaseLibrary {

	static String strpath = "D:\\RunExe\\Phoenix\\Dish-CallClousre.xlsx";
	static ExcelUtilities xls = new ExcelUtilities(strpath);
	static String sheetname = "CallClousre";
	static public String DTserverNode2 = "DevDishV2n2Ln.dishtvindia-new.in:21444";
	static public String DTDBuserID = "Gen_Testing";
	static public String DTDBPass = "gentesting@12345";
	static public String DT_India_SR_DB = "DISHTVINDIA_SRCRM";
	static public String Ticketno="";
	public static String Strpath="D:\\RunExe\\Phoenix\\screenshots\\";

	public static void main(String[] args) {
		
		setUp();
		launchURL();
		Forgotpassword();
		login();
		ticketOpen();
		getWorkOrderDetails();
		getCallSchedule();
		serviceCallUpdate();
		materialConsumption();		
		tearDown();

	}

	private static WebDriver driver;
	public static JavascriptExecutor js;

	public static void setUp() {

		try {
			System.setProperty("webdriver.chrome.driver", "D:\\RunExe\\Phoenix\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			js = (JavascriptExecutor) driver;
			driver.manage().window().maximize();
			System.out.println("Browser Open Successfully." + ApplicationUtilities.Fun_DateTime());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void launchURL() {

		try {
			System.out.println("Login page open Successfully." + ApplicationUtilities.Fun_DateTime());
			driver.get("http://beta4-phoenix.dishtvbiz.in/");
			System.out.println("Login done Successfully in Phoenix." + ApplicationUtilities.Fun_DateTime());
			ApplicationUtilities.Printscreen(Strpath,"Browser launch URL");	
		} catch (Exception e) {

			System.out.println("Exception in  launchURL method : " + e);

		}

	}
	
	public static void Forgotpassword()
	{
		try
		{
			driver.findElement(By.linkText("I forgot my password")).click();	
			ApplicationUtilities.Printscreen(Strpath,"Forgot Password");
			
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	public static void login()
	{
		try
		{
			driver.findElement(By.id("txtUserID")).clear();
			driver.findElement(By.id("txtUserID")).sendKeys("927686");
			driver.findElement(By.id("txtPassword")).clear();
			driver.findElement(By.id("txtPassword")).sendKeys("dishtv@123");
			driver.findElement(By.xpath("//header[@id='gtco-header']/div[2]/div/div/div/div/div/div/div")).click();
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			ApplicationUtilities.Printscreen(Strpath,"Login");	
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	public static void ticketOpen() {

		try {
			
			driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li[2]/a/strong")).click();			
			driver.findElement(By.id("ddlOrgType")).click();
			int rowcount = xls.getRowCount(sheetname);
			for (int i = 2; i <= rowcount; i++) {
				String runstatus = xls.getCellData(sheetname, "RunStatus", i);
				String brand = xls.getCellData(sheetname, "Brand", i);
				if (runstatus.toUpperCase().equalsIgnoreCase("YES"))

					if (brand.toUpperCase().equalsIgnoreCase("DISHTV")) {

						driver.findElement(By.xpath("//*[@id=\"ddlOrgType\"]/option[1]")).click();
						driver.findElement(By.id("searchTokenDetails")).click();
						driver.findElement(By.id("searchTokenDetails")).clear();						
						driver.findElement(By.xpath("//a[@id='btnSerachToken']/i")).click();
						ApplicationUtilities.Printscreen(Strpath,"Ticket validation");
						Thread.sleep(1000);
						ApplicationUtilities.acceptAlert(driver);
						Ticketno = xls.getCellData(sheetname, "TicketNo", i);
						driver.findElement(By.id("searchTokenDetails")).sendKeys(String.valueOf(Ticketno));						
						//ApplicationUtilities.DynamicWait(driver, "//*[@id=\"disableProcess\"]/div/img");

						break;

					} else {

						driver.findElement(By.xpath("//*[@id=\"ddlOrgType\"]/option[1]")).click();

						driver.findElement(By.id("searchTokenDetails")).click();

						driver.findElement(By.id("searchTokenDetails")).clear();

						driver.findElement(By.id("searchTokenDetails"))

								.sendKeys(xls.getCellData(sheetname, "TicketNo", i));

						break;

					}

			}

			driver.findElement(By.xpath("//a[@id='btnSerachToken']/i")).click();
			driver.findElement(By.xpath("//table[@id='gvMain_Content_Freeze_Grid']/tr[2]/td[2]/div/a")).click();
			ApplicationUtilities.waitForPageLoad(driver);
			Thread.sleep(3000);
			ApplicationUtilities.Printscreen(Strpath,"Ticket Open");		
			System.out.println("Ticket search Successfully." + ApplicationUtilities.Fun_DateTime());

		} catch (Exception e) {

			System.out.println(e);

		}

	}	

	public static void getWorkOrderDetails() {

		try {
			Thread.sleep(2000);
			ApplicationUtilities.Printscreen(Strpath,"Work Order Details");		
			ApplicationUtilities.waitForPageLoad(driver);
			driver.findElement(By.linkText("Check Warranty")).click();
			Thread.sleep(5000);
			ApplicationUtilities.Printscreen(Strpath,"Warranty");	;
			driver.findElement(By.xpath("//button[@id='btnCloseWarranty']/i")).click();
			Thread.sleep(2000);
			expendandNclops();
			BoxservicePlan();
			System.out.println("Work Order Details Page open Successfully." + ApplicationUtilities.Fun_DateTime());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	public static void BoxservicePlan() {

		try {
			driver.findElement(By.linkText("Box Service Plan")).click();
			ApplicationUtilities.waitForPageLoad(driver);
			Thread.sleep(5000);
			ApplicationUtilities.Printscreen(Strpath,"Box service Plan");		
			driver.findElement(By.xpath("//*[@id=\"btnExtentionPay\"]")).click();
			ApplicationUtilities.acceptAlert(driver);
			driver.findElement(By.xpath("//*[@id=\"PGAccountNo_SVC\"]")).sendKeys("123456");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"btnExtentionPay\"]")).click();
			Thread.sleep(2000);
			ApplicationUtilities.acceptAlert(driver);
			driver.findElement(By.xpath("//*[@id=\"PGPassword_SVC\"]")).sendKeys("123456");			
			driver.findElement(By.xpath("//*[@id=\"btnCloseSmartStick\"]/i")).click();
			System.out.println("Box Service Plan Page open Successfully." + ApplicationUtilities.Fun_DateTime());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void expendandNclops() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"Header_WorkOrderDetails\"]/div")).click();
			ApplicationUtilities.Printscreen(Strpath,"Order Details expendandNclops");			
			driver.findElement(By.xpath("//*[@id=\"Header_WorkOrderDetails\"]/div")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"Header_CustomerDetails\"]/div/a/i")).click();
			ApplicationUtilities.Printscreen(Strpath,"Customer Details expendandNclops");		
			driver.findElement(By.xpath("//*[@id=\"Header_CustomerDetails\"]/div/a/i")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"Header_Remarks\"]/div/a/i")).click();
			ApplicationUtilities.Printscreen(Strpath,"Remarks expendandNclops");
			ApplicationUtilities.Mouseover_action(driver, driver.findElement(By.xpath("//*[@id=\"trigger\"]/div")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"Header_Remarks\"]/div/a/i")).click();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void getCallSchedule() {

		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ddlIsVisitRequired\"]/option[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"ddlTechnicianListForSchedule\"]/option[8]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnSlot\"]")).click();			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"divTimeSlotMatrix\"]/div[13]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"txtScheduleRemarks\"]")).sendKeys("Test "+ ApplicationUtilities.Fun_DateTime());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"btnScheduleToken\"]")).click();
			Thread.sleep(2000);
			System.out.println("Call Schedule slot." + ApplicationUtilities.Fun_DateTime());
			Thread.sleep(2000);
			ApplicationUtilities.Printscreen(Strpath,"Call Schedule");			
			driver.findElement(By.xpath("(//*[@id=\"btnClose\"]/i)[2]")).click();
			System.out.println("Call Schedule done Successfully." + ApplicationUtilities.Fun_DateTime());
			ApplicationUtilities.Printscreen(Strpath,"After Call Schedule");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void serviceCallUpdate() {

		try {
			driver.findElement(By.xpath("//*[@id=\"txtPersonFound\"]")).sendKeys("Test");
			driver.findElement(By.xpath("//*[@id=\"txtRemarks\"]")).sendKeys("Test");
			driver.findElement(By.xpath("//*[@id=\"ddlStatus\"]/option[2]")).click();
			driver.findElement(By.xpath("//*[text()='Resolved On Technician Visit']")).click();
			driver.findElement(By.xpath("//*[@id=\"ddlActualFault\"]/option[16]")).click();
			driver.findElement(By.xpath("//*[@id=\"txtDelayRemarks\"]")).sendKeys("Test "+ ApplicationUtilities.Fun_DateTime());
			WebElement webdddp = driver.findElement(By.xpath("//*[@id=\"ddlDeposition\"]"));			
			ApplicationUtilities.dropdownIndex(webdddp, 1);
			WebElement webdddrating = driver.findElement(By.id("ddlRating"));
			ApplicationUtilities.dropdownIndex(webdddrating, 3);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).click();
			Thread.sleep(3000);			
			driver.switchTo().alert().accept();
			Thread.sleep(2000);			
			driver.findElement(By.xpath("//*[@id=\"btnGenerateHappyCode\"]")).click();		
			System.out.println("Happy code generated successfully." + ApplicationUtilities.Fun_DateTime());
			driver.switchTo().alert().accept();			
			Thread.sleep(3000);			
			String StrHyCode = GetTokenno(xls.getCellData(sheetname, "TicketNo", 2));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"txtHappyCode\"]")).sendKeys(StrHyCode);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).click();
			Thread.sleep(3000);
			ApplicationUtilities.Scroll_Page_To_Bottom(driver);
			System.out.println("Service Call Update done Successfully." + ApplicationUtilities.Fun_DateTime());
			ApplicationUtilities.Printscreen(Strpath,"Service Call Update");				

		} catch (InterruptedException e) {

			System.out.println(e);

		}

	}

	public static void materialConsumption() {

		try {

			String visitcharge = driver.findElement(By.xpath("//*[@id=\"materialContent\"]/tbody/tr/td[1]")).getText();
			if (visitcharge.equalsIgnoreCase("VisitCharge")) {
				float iAvailableSVCRC=0;
				float iTotalAmtCollected=0;
				float ifinalamt=0;	
				float irequiredamt=0;
				String strrequiredamt=driver.findElement(By.xpath("//*[@id=\"txtReceiveAmt\"]")).getAttribute("value");
				irequiredamt=Float.parseFloat(strrequiredamt);
				String strSVCRC=  driver.findElement(By.xpath("//*[@id=\"txtAvailbaleServiceRecharge\"]")).getAttribute("value");
				String strAmtCollected=  driver.findElement(By.xpath("//*[@id=\"txtReceiveAmt\"]")).getAttribute("value");
				iAvailableSVCRC=Float.parseFloat(strSVCRC);
				iTotalAmtCollected=Float.parseFloat(strAmtCollected);
				if(iTotalAmtCollected<=0.00)
				{
					System.out.println("Service Call Update done Successfully." + ApplicationUtilities.Fun_DateTime());
					driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
				}
				ifinalamt=iAvailableSVCRC-iTotalAmtCollected;
				if(ifinalamt<=0)
				{
					driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
				}
				ApplicationUtilities.Printscreen(Strpath,"Material Consumption");
				ApplicationUtilities.acceptAlert(driver);
				System.out
						.println("Material Consumption page open Successfully." + ApplicationUtilities.Fun_DateTime());
				ApplicationUtilities.Printscreen(Strpath,"Material Consumption");		
				
			} else {
				driver.findElement(By.xpath("//*[@id=\"ddlServiceCharge\"]/option[6]")).click();
				driver.findElement(By.xpath("//*[@id=\"imgBtnAddServiceCharge\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).click();
			}

		} catch (Exception e) {

			System.out.println("Issue in materialConsumption " + e);

		}

	}
	
	public static String Service_RechargeCalc(String Stravi, String Stramt ) {
		try {
			
			int icurrentbal=Integer.parseInt(Stravi);
			int ireqamt=Integer.parseInt(Stramt);
			int ifinalamt;	
					
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return Stramt;

	}
	

	public static void Service_recharge(String StrComplaintNo, String StrAmount ) {
		try {
			ApplicationUtilities.Ntab(driver, "https://beta1-www.easy-pay.in/");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));			
			driver.findElement(By.id("CphPageMiddle_txtUserID")).clear();
			driver.findElement(By.id("CphPageMiddle_txtUserID")).sendKeys("112237");
			driver.findElement(By.id("CphPageMiddle_txtPassword")).clear();
			driver.findElement(By.id("CphPageMiddle_txtPassword")).sendKeys("dish@123");
			driver.findElement(By.xpath("//*[@id=\"CphPageMiddle_tdLogin\"]/table/tbody/tr[5]/td/table/tbody/tr/td[2]/input")).click();
			ApplicationUtilities.waitForPageLoad(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='RadMenu']/ul/li[3]/a/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='RadMenu']/ul/li[3]/div/ul/li[3]/a/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='CphPageMiddle_pnlSearch']/table/tbody/tr[5]/td[3]/input")).click();
			driver.findElement(By.xpath("//div[@id='CphPageMiddle_pnlSearch']/table/tbody/tr[5]/td[3]/input")).clear();
			driver.findElement(By.xpath("//div[@id='CphPageMiddle_pnlSearch']/table/tbody/tr[5]/td[3]/input")).sendKeys(StrComplaintNo);
			driver.findElement(By.xpath("//form[@id='form1']/div[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/center")).click();
			driver.findElement(By.id("CphPageMiddle_txtAmount")).click();
			driver.findElement(By.id("CphPageMiddle_txtAmount")).clear();
			driver.findElement(By.id("CphPageMiddle_txtAmount")).sendKeys(StrAmount);
			driver.findElement(By.id("CphPageMiddle_btnSubmit")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("CphPageMiddle_btnSubmit")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id='UpdatePanelError']/table/tbody/tr/td[2]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//img[@alt='Close']")).click();			
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public static void tearDown() {

		driver.quit();

	}

	public static String GetTokenno(String Ticketno) {
		String Happycode = null;
		try {

			if (Ticketno != "") {

				DatabaseConnection Objcon = new DatabaseConnection(DTserverNode2, DTDBuserID, DTDBPass, DT_India_SR_DB);
				String StrQry = "select top 1 * from DISHTVINDIA_SRCRM..tHappyCodeProcess(nolock) where TicketId= "
						+ Ticketno + "order by Date_time desc";

				ResultSet result1 = Objcon.executeQuery(StrQry);

				int size = 0;

				if (result1 != null) {

					result1.last();

					size = result1.getRow();

					if (size == 0) {

						System.out.println("Wrong happycode- " + Happycode);

						Objcon.con.close();

					}

				}

				if (size >= 1) {

					result1.beforeFirst();

					while (result1.next()) {

						Happycode = result1.getString("Happy_code");

					}
					Objcon.con.close();

				}
				Objcon.con.close();
			}

		} catch (Exception ex) {

			System.out.println("Issue in generate the Process ID and Name !");

		}

		return Happycode;

	}

	public static void Filerename() {
		try {
			String strLfile = "";
			File directoryPath = new File("D:\\RunExe\\Phoenix");
			FilenameFilter textFilefilter = new FilenameFilter() {
				public boolean accept(File dir, String name) {
					String lowercaseName = name.toLowerCase();
					if (lowercaseName.endsWith(".txt")) {
						return true;
					} else {
						return false;
					}
				}
			};

			String strdt = ApplicationUtilities.Fun_DateTime();
			String strNname = "D:\\RunExe\\Phoenix\\" + strdt + ".txt";
			ApplicationUtilities.TC_FileRename("D:\\RunExe\\Phoenix\\" + strLfile + ".txt", strNname);			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
