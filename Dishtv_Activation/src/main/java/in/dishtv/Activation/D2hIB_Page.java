package in.dishtv.Activation;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;
import in.dishtv.library.DatabaseConnection;
import in.dishtv.library.ExcelUtilities;
import in.dishtv.library.PropertiesLib;
import in.dishtv.library.WaitStatementsLib;

/**
 * @author Vivek.Kumar For D2h
 * 
 *
 */
public class D2hIB_Page extends BaseLibrary {

	String StrPathexl = System.getProperty("user.dir") + "//testdata//D2h_Phoenix_Ins.xlsx";
	ExcelUtilities xls = new ExcelUtilities(StrPathexl);

	public String strtoken = "";
	String Installation_sheet = "D2h_IB_Data_Install";
	String Activation_sheet = "Data_Activation";
	String strloader = "//*[@id='imgAJAXLoader']";
	static Select sel;
	SoftAssert assertion = new SoftAssert();
	String Namevalue = "Test ";
	String StrCurrentDT = ApplicationUtilities.Fun_DateTime();
	String kittyy;
	public long ltoken = 0;
	public long lcallcategory = 0;
	public String scallcategory = "";

	int iloop = 0;

	public D2hIB_Page() {
		super();
		PageFactory.initElements(driver, this);

	}

	// x'path
	@FindBy(xpath = "//*[text()='Customer Service']")
	private WebElement customerservice; // Click on customer service

	@FindBy(xpath = "//*[text()='Installation Request']")
	private WebElement checkboxinstallationrequest; // Click on check box installation Request

	@FindBy(xpath = "//*[text()='Tagging']")
	private WebElement Tagging; // Click On Tagging button

	// Installation Request Page WebElements
	@FindBy(xpath = "//*[text()='Box Type']")
	private WebElement BoxType_dropdown;

	@FindBy(xpath = "//*[text()='Spoken With']")
	private WebElement Spoken_With_Textbox;

	@FindBy(xpath = "//*[text()='Customer Name']")
	private WebElement customer_name_textBox;

	@FindBy(xpath = "//*[text()='House No.']")
	private WebElement House_number_textbox;

	@FindBy(xpath = "//*[text()='Locality:']")
	private WebElement AreaLocality_textbox;

	@FindBy(xpath = "//*[text()='Landmark:']")
	private WebElement Landmark_textbox;

	@FindBy(xpath = "//*[text()='Offer Name']")
	private WebElement offername_dropdown;

	@FindBy(xpath = "//*[text()='Language Zone']")
	private WebElement Languagezone_dropdown;

	@FindBy(xpath = "//*[text()='Mobile No.']")
	private WebElement Mobile_no_textbox;

	@FindBy(xpath = "//*[text()='Alternate Mobile No.:']")
	private WebElement Alternate_mobile_textbox;

	@FindBy(xpath = "//*[text()='Pin Code']")
	private WebElement pin_textbox;

	@FindBy(xpath = "//*[text()='Package']")
	private WebElement Package_name_dropdwon;

	@FindBy(linkText = "Multi Conversion")
	private WebElement Dishtv_btn;

	@FindBy(xpath = "//*[@id=\"ddlLanguages\"]")
	private WebElement Langueddp;

	@FindBy(xpath = "//*[@id=\"txtFirst\"]")
	private WebElement EPRS_ID;

	@FindBy(xpath = "//*[@id='txtComplaintCategory']")
	private WebElement searchcategory;

	@FindBy(xpath = "//*[@id=\"eprsPassword\"]")
	private WebElement Password_EPRS_checkbox;

	@FindBy(xpath = "//*[@id=\"btnSaveActivation\"]")
	private WebElement Save_btn_EPRS;
	@FindBy(xpath = "//*[@id=\"btnActivate\"]")
	private WebElement Activation_Btn;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtTelOff\"]")
	private WebElement Tel_official_textbox;
	@FindBy(xpath = "//*[@id=\"ctl00_lblMessage\"]")
	private WebElement ticket;
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtRemarks\"]")
	private WebElement remarks_textbox;
	@FindBy(xpath = "//*[@id='CphPageMiddle_btnSubmit']")
	private WebElement confirmbtn;

	@FindBy(xpath = "//*[@id=\"pnlErrorMessage\"]/table/tbody/tr[1]/td[2]/img")
	private WebElement close_popup;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_rdbInstalCompY\"]")
	private WebElement instalation_req_yes_checkbox;

	// --------- Phoenix Installatin ------------
	String strLoader = "Please wait while we are processing your request...";
	String strmsg = "Request is already exist for this Voucher/VC No.";
	String strkitty = "";
	String Voucherno = "";
	String VoucherCode = "";
	@FindBy(id = "ddlConnectionType")
	private WebElement connectiontype;
	@FindBy(id = "ddlBoxType")
	private WebElement Boxtype;
	@FindBy(id = "txtVoucherNo")
	private WebElement TxtVoucherno;
	@FindBy(id = "txtVoucherCode")
	private WebElement TxtVoucherCode;
	@FindBy(id = "txtSpokenWith")
	private WebElement Txtspoken;
	@FindBy(id = "txtCustomerName")
	private WebElement Txtcust;
	@FindBy(id = "txtAddress1")
	private WebElement TxtAdd1;
	@FindBy(id = "txtAddress2")
	private WebElement TxtAdd2;
	@FindBy(id = "txtMobileNo")
	private WebElement Txtmobile;
	@FindBy(id = "txtMobile2")
	private WebElement Txtmobile1;
	@FindBy(id = "txtTel")
	private WebElement TxtTel;
	@FindBy(id = "txtEmail")
	private WebElement TxtEmail;
	@FindBy(id = "txtPinCode")
	private WebElement TxtPinCode;
	@FindBy(id = "ddlOffer")
	private WebElement Ddl_Offer;
	@FindBy(id = "ddlLanguageZone")
	private WebElement Ddl_Language;
	@FindBy(id = "ddlPackage")
	private WebElement Ddl_Package;
	@FindBy(xpath = "//body")
	private WebElement Body;
	@FindBy(id = "txtRemarks")
	private WebElement Txt_Remarks;
	@FindBy(id = "btnSaveInstRequest")
	private WebElement Btn_final_Submit;
	@FindBy(id = "btnSave")
	private WebElement Btn_Submit;
	@FindBy(id = "ddlLocality")
	private WebElement Ddl_Locality;
	@FindBy(id = "txtLandmark")
	private WebElement Txt_Landmark;
	@FindBy(xpath = "//*[text()='Remarks: ']")
	private WebElement Remarks_textbox;

	@FindBy(xpath = "//*[@id=\"divSummary\"]")
	private WebElement kittyamount;
	@FindBy(xpath = "//*[@id=\"lblInstReqError\"]")
	private WebElement Installation_Msg;

	@FindBy(xpath = "//*[@id=\"lblTokenNo\"]")
	private WebElement Tokenno;

	@FindBy(xpath = "//*[@id=\"divReceipt\"]/input")
	private WebElement CloseToken;
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_ddlLocality\"]")
	private WebElement AreaLocalty_dropdown;
	@FindBy(id = "spnIDU")
	private WebElement ChkODU;
	@FindBy(xpath = "//*[@id='rdOduInstYes']")
	private WebElement installreqyes;
	@FindBy(xpath = "//*[@id='rdOduInstNo']")
	private WebElement installreqno;
	@FindBy(xpath = "//*[@id=\"tblInsReqSummary\"]/tbody/tr[5]/td[2]")
	private WebElement totalamount;
	// --------- End of Phoenix Installatin ------------

	// -------------------------- Easy Recharge --- String StrMenu = "Sales";

	@FindBy(xpath = "//*[@id=\"txtPhoneComp\"]")
	private WebElement complmobile;

	@FindBy(xpath = "//*[@id=\"txtAlternateNo\"]")
	private WebElement complaltmobile;

	@FindBy(xpath = "//*[@id=\"btnSaveComplaint\"]")
	private WebElement complSave;
	@FindBy(xpath = "//*[@id=\"tblAddonSummary\"]/tbody/tr[2]/td/table/tbody/tr[5]/td[4]")
	private WebElement Total_amount;
	@FindBy(xpath = "//*[@id=\"lblKitty\"]")
	private WebElement Avlbl_kitty;

	@FindBy(xpath = "//*[@id=\"divPaymentModes\"]/table/tbody/tr/td/table/tbody/tr[1]/td/div[1]/label/span")
	private WebElement EPRSCheckbox;
	@FindBy(xpath = "//*[@id=\"eprsUserName\"]")
	private WebElement Accountno_EPRS_checkbox;
	@FindBy(xpath = "//*[@id=\"divActivationReceipt\"]/center/label")
	private WebElement Activation_no;
	@FindBy(xpath = "//*[@id=\"divPaymentModes\"]/table/tbody/tr/td/table/tbody/tr[1]/td/div[2]/label/span")
	private WebElement AK_checkbox;

	@FindBy(xpath = "//*[@id='spnKitty']")
	private WebElement Kittybalanceinfo;

	@FindBy(xpath = "//*[text()='Voucher No']")
	private WebElement Voucher_activation_textbox;

	@FindBy(xpath = "//*[text()='Voucher Code']")
	private WebElement Pin_Scratch_code_textbox;
	String Str_Pin_Scratch_code_textbox = "//*[text()='Voucher Code']]";

	@FindBy(xpath = "//*[@id=\"ctl00_lblMessage\"]")
	private static WebElement error_bottam;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtEmail\"]")
	private WebElement Email_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]")
	private WebElement save_btn;
	@FindBy(xpath = "//*[@id=\"CphPageMiddle_txtPaymentTo\"]")
	private WebElement VCRMN;

	@FindBy(xpath = "//*[@id=\"CphPageMiddle_txtAmount\"]")
	private WebElement customerpayement_amount;

	String customerpayment = "//*[@id=\"CphPageMiddle_txtAmount\"]";
	@FindBy(xpath = "//*[@id=\"CphPageMiddle_btnSubmit\"]")
	private WebElement submit;
	@FindBy(xpath = "//*[@id='CphPageMiddle_ddlPaymentType']")
	private WebElement PaymentTypeddp;
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_rdbInstalCompN\"]")
	private WebElement instalation_req_No_checkbox;
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_txtPkgName\"]")
	private WebElement channelname_MearaApna_pack_textbox;
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList\"]/ul/li[2]/a/span/span[2]")
	private WebElement Paid_On_btn;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList\"]/ul/li[4]/a/span/span[2]")
	private WebElement Apna_Pack_btn;
	@FindBy(xpath = "//*[@id=\"ExistingPack\"]")
	private WebElement existing_pack;
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_rbtnlstHDMICable_0\"]")
	private WebElement HDMI_cable_yes_checkbox;
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_rbtnlstHDMICable_1\"]")
	private WebElement Skip_offer_checkbox;
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_chkISIDU\"]")
	private WebElement Without_odu_checkbox;

	String StrMenu = "Sales";
	String StrsubMenu = "Customer Payment";
	String AltM = "//*[@id=\"CphPageMiddle_txtMobileNo\"]";
	@FindBy(xpath = "//*[@id='CphPageMiddle_btnSubmit']")
	private WebElement BtnFinalSubmit;
	@FindBy(xpath = "//*[@id=\"CphPageMiddle_txtMobileNo\"]")
	private WebElement AltMobileno;
	@FindBy(xpath = "//*[@id=\"CphPageMiddle_txtAmount\"]")
	private WebElement txtAmtfirst;
	String Loader = "//*[@id='imgAJAXLoader']";
	@FindBy(xpath = "//*[@id=\"CphPageMiddle_btnFeedbackSubmit\"]")
	private WebElement Feedbacksubmit;
	@FindBy(xpath = "//*[@id='lblMesg']")
	private WebElement Alerttext;
	@FindBy(xpath = "//*[@id='pnlErrorMessage']/table/tbody/tr[1]/td[2]/img")
	private WebElement AlertClose;
	@FindBy(xpath = "//*[@id=\"txtSecond\"]")
	private WebElement eprspassword;
	@FindBy(xpath = "//*[@id='btnRecharge']")
	private WebElement rechargebuttoneprs;
	@FindBy(xpath = "//*[@id=\"divKittyRechargeBody\"]")
	private WebElement rechargebodymsg;
	@FindBy(xpath = "//*[@id=\"spnSuccess\"]/center/input")
	private WebElement closerechargebtn;
	@FindBy(xpath = "//*[@id=\"btnSaveInstRequest\"]")
	private WebElement savebtnkitty;
	@FindBy(xpath = "//*[@id=\"spnSuccess\"]/center/input")
	private WebElement afterrechargeclose;
	@FindBy(xpath = "(//*[@class='close'])[4]")
	private WebElement afterrechargekittyclose;
	@FindBy(xpath = "//*[@id=\"btnSave\"]")
	private WebElement continueagain;
	@FindBy(xpath = "//*[@id=\"divSummary\"]/div[1]/i")
	private WebElement refreshkitybalance;

	// ------------------------ End of Easy Recharge --------------

	// To perform Mouse hover and click

	public void mousehover() {
		try {
			IB_Pageopen();
			Move_To_Installation_Page(1);
			// Move_To_Installation_Page();
			// Phoenix_Installation();

		} catch (Exception e) {
			System.out.println("Issue in mouse hover  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public void IB_Pageopen() {
		try {

			customerservice.click();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			Thread.sleep(2000);
			System.out.println("Title of Page : " + driver.getTitle());
			Thread.sleep(2000);
			// checkboxinstallationrequest.click();
			// WaitStatementsLib.waitForVisibilityOfElement(driver, Tagging, 10);
			// Tagging.click();
			WaitStatementsLib.waitForSeconds(driver, 3);
		} catch (Exception e) {
			System.out.println("Issue IB page navigation.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	/*
	 * public void Move_To_Installation_Page() { try {
	 * 
	 * String winHandleBefore = driver.getWindowHandle(); String strMSG = ""; //
	 * Switch to new window opened for (String winHandle :
	 * driver.getWindowHandles()) {
	 * 
	 * driver.switchTo().window(winHandle); strMSG =
	 * driver.switchTo().window(winHandle).getTitle(); if (strMSG.trim().isEmpty())
	 * { driver.close(); }
	 * 
	 * if (strMSG.contains("Installation Request")) {
	 * driver.manage().window().maximize(); Phoenix_Installation();
	 * 
	 * }
	 * 
	 * } if (strMSG != "::: Installation Request :::") { for (String winHandle :
	 * driver.getWindowHandles()) { // Thread.sleep(5000);
	 * driver.switchTo().window(winHandle); strMSG =
	 * driver.switchTo().window(winHandle).getTitle(); Thread.sleep(3000); if
	 * (strMSG.trim().isEmpty()) { driver.close(); } // Thread.sleep(4000); if
	 * (strMSG.contains("Installation Request")) { // complalclose.click();
	 * Thread.sleep(2000); driver.manage().window().maximize();
	 * Phoenix_Installation();
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } driver.switchTo().window(winHandleBefore);
	 * 
	 * } catch (Exception ex) { // xls.setCellData(SheetName, "Issues/Remarks", k,
	 * "Issue in Token generation"); System.out.println("Exception in Fillcomplaint"
	 * + ex); } }
	 */

	public void Move_To_Installation_Page(int k) {
		try {
			driver.findElement(By.xpath("//*[@id=\"chkInstallationRequest\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"RadToolBar1\"]/div/div/div/ul/li[1]/a/span")).click();
			Thread.sleep(8000);
			String winHandleBefore = driver.getWindowHandle();
			String strMSG = "";
			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {

				driver.switchTo().window(winHandle);
				strMSG = driver.switchTo().window(winHandle).getTitle();
				
				if (strMSG.trim().isEmpty()) {
					driver.close();
				}

				if (strMSG.contains("::: Installation Request :::")) {
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();
					Phoenix_Installation();
					Thread.sleep(2000);

				}

			}
			/*
			 * if (strMSG != "::: Installation Request :::") { for (String winHandle :
			 * driver.getWindowHandles()) { //Thread.sleep(5000);
			 * driver.switchTo().window(winHandle); strMSG =
			 * driver.switchTo().window(winHandle).getTitle(); Phoenix_Installation();
			 * Thread.sleep(2000); if (strMSG.trim().isEmpty()) { driver.close(); }
			 * 
			 * 
			 * }
			 * 
			 * }
			 */
			driver.switchTo().window(winHandleBefore);

		} catch (Exception ex) {
			// xls.setCellData(SheetName, "Issues/Remarks", k, "Issue in Token generation");
			System.out.println("Exception in Fillcomplaint" + ex);
		}
	}

	public void Brand_Selection() {
		try {
			driver.findElement(By.xpath("//img[@alt='DishD2h']")).click();
			;
		} catch (Exception e) {
			System.out.println("Issue in Brand_Selection  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public void Menu_Navigation() {
		try {

			ApplicationUtilities.MouseHovernclick(driver, "Utilities", "Add Installation Call (New)");

		} catch (Exception e) {
			System.out.println("Issue in Menu_Navigation  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// TO VALIDATE CHECK TITLE

	public void check_title() {
		try {
			String menu1 = "Utilities";
			String menu2 = "Add Installation Call (New)";
			// WaitStatementsLib.waitForSeconds(driver, 30);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"BrandChosse\"]/div/center/div/div[2]/div/div[2]/center/a/img"))
					.click();
			// WaitStatementsLib.waitForSeconds(driver, 30);
			Thread.sleep(3000);
			ApplicationUtilities.MouseHovernclick(driver, menu1, menu2);
			ApplicationUtilities.Fun_PassScreenshot(driver, "Open Install.. Page");
			// WaitStatementsLib.waitForSeconds(driver, 30);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Issue in mouse hover  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// Below process to use for Activation process
	public int RunStauscountActivation() {
		int Runstatus = 0;
		try {
			int coloumn = xls.getColumnCount(Activation_sheet);
			for (int j = 2; j <= coloumn; j++) {
				String RunStatus = xls.getCellData(Activation_sheet, 0, j);
				{
					if (RunStatus.toUpperCase().equalsIgnoreCase("yes")) {
						Runstatus++;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in RunStauscountActivation method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return Runstatus;
	}

	// To Fill Fresh STB and VC in list from Database
	public CopyOnWriteArrayList<String> GetdataActivation() {
		CopyOnWriteArrayList<String> token = new CopyOnWriteArrayList<String>();
		try {

			int count = RunStauscountActivation();
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameDishtv);
			ResultSet result = Objcon.executeQuery("Select top " + count
					+ " * from dishtvindia..Stbinfo (nolock) where LocationType = 'SP' and stbmodelrowid =48  and VSC_ID is not null");
			while (result.next()) {
				String STBNo = result.getString("STBNo");
				String VCNo = result.getString("VSC_ID");
				String concatedata = VCNo.trim() + ":" + STBNo.trim();
				token.add(concatedata);
			}
			return token;

		} catch (Exception e) {
			System.out.println("Issue in GetdataActivation method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return token;
	}

	// To update data in Node 1 and Node 2 as per given data Like (Scheme ID, Dealer
	// ID, STBRow ID)
	public LinkedList<String> updateActivation() {
		LinkedList<String> updatedata = new LinkedList<String>();
		try {
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameDishtv);
			DatabaseConnection Objcon1 = new DatabaseConnection(serverNode1, DBuserIDNode1, DBPassNode1,
					DBnameNode1SMSDTH2003);
			int count = RunStauscountActivation();
			CopyOnWriteArrayList<String> data = GetdataActivation();
			for (int i = 2; i <= count + 1; i++) {
				String scheme = xls.getCellData(Activation_sheet, 7, i);
				String ModelRowId = xls.getCellData(Activation_sheet, 8, i);
				String locationId = xls.getCellData(Activation_sheet, 9, i);
				for (String getdata : data) {
					String[] VC_STB = ApplicationUtilities.split(getdata, ":");
					String VCNo = VC_STB[0].toString();
					String STBNo = VC_STB[1].toString();
					Objcon.executeupdate("update dishtvindia..Stbinfo set Schemeid = " + scheme
							+ ",LocationType='DC',LocationId= " + locationId + ",stbmodelrowid =" + ModelRowId
							+ " where stbno in ('" + VCNo + "'" + "," + "'" + STBNo + "'" + ")");

					Objcon.executeupdate("update dishtvindia..vcinfo set Schemeid = " + scheme
							+ ",LocationType='DC',LocationId= " + locationId + ",stbmodelrowid =" + ModelRowId
							+ " where VCNo in ('" + VCNo + "'" + "," + "'" + STBNo + "'" + ")");

					Objcon.executedelete("delete from dishtvindia..libertyboxdump where serialnumber in('" + VCNo + "'"
							+ "," + "'" + STBNo + "'" + ")");

					Objcon1.executeupdate("update smsdth2003..Itemserialnomaster set stbmodelrowid =" + ModelRowId
							+ ",Schemeid =" + scheme + ",stockpointtype = 'DC', location =" + locationId
							+ " where SerialNumber in ('" + VCNo + "'" + "," + "'" + STBNo + "'" + ")");

					updatedata.add(getdata);
					data.remove(getdata);
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Issue in updateActivation method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return updatedata;
	}

	// To Write data in Excel (VC and STB)
	public void ActivationWritedata() {
		try {

			int rws = xls.getRowCount(Activation_sheet);
			LinkedList<String> updateedata = updateActivation();
			for (int i = 2; i <= rws; i++) {
				for (String getdata : updateedata) {
					String[] VC_STB = ApplicationUtilities.split(getdata, ":");
					String VCNo = VC_STB[0].toString();
					String STBNo = VC_STB[1].toString();
					xls.setCellData(Activation_sheet, "VC No", i, VCNo);
					WaitStatementsLib.waitForSeconds(driver, 3);
					xls.setCellData(Activation_sheet, "STB NO", i, STBNo);
					updateedata.remove(getdata);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in ActivationWritedata method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// To update installation number on complaintTRN
	public void getupdatecompntTRN() {
		// to check using debug
		try {
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameNode2DishtvSRCRM);
			int rws = xls.getRowCount(Activation_sheet);
			for (int i = 2; i <= rws; i++) {
				String RunStatus = xls.getCellData(Activation_sheet, 0, i);
				{
					if (RunStatus.toUpperCase().equalsIgnoreCase("yes")) {

						String Installationno = xls.getCellData(Activation_sheet, 2, i).trim();
						Objcon.executeupdate(
								"Update complainttrn set servicerid ='8094' where rowid='" + Installationno + "'");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in getupdatecompntTRN method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public boolean installationtokenupdate(String Token, String Serviceid) {
		boolean update = false;
		try {
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameNode2DishtvSRCRM);
			Objcon.executeupdate(
					"update complainttrn set servicerid = " + Serviceid + " where rowid in (" + Token + ")");
			return true;

		} catch (Exception e) {
			System.out.println("Issue in installationtokenupdate method.");
			Reporter.log(e.getLocalizedMessage(), true);

		}
		return update;
	}

	// Kitty validate
	public void getamountvalidate(int i) {
		try {
			String userid = PropertiesLib.getPropertyValue("accountnumberkitty");
			String password = PropertiesLib.getPropertyValue("passwordkittyamount");
			String avlblkitty = Avlbl_kitty.getText();
			String amount = Total_amount.getText();
			String strNew = avlblkitty.substring(0, avlblkitty.length() - 2);
			int intkitty = Integer.parseInt(strNew);
			int intamount = Integer.parseInt(amount);
			if (intkitty <= intamount) {
				EPRSCheckbox.click();
				WaitStatementsLib.waitForSeconds(driver, 3);
				Accountno_EPRS_checkbox.sendKeys(userid);
				WaitStatementsLib.waitForSeconds(driver, 3);
				Password_EPRS_checkbox.sendKeys(password);
				WaitStatementsLib.waitForSeconds(driver, 3);
				Save_btn_EPRS.click();
				WaitStatementsLib.waitForSeconds(driver, 3);
				xls.setCellData(Activation_sheet, "Activation_Token No", i, Activation_no.getText());
				WaitStatementsLib.waitForSeconds(driver, 3);
				driver.navigate().refresh();
			} else {
				if (intkitty > intamount) {
					AK_checkbox.click();
					WaitStatementsLib.waitForSeconds(driver, 3);
					Save_btn_EPRS.click();
					WaitStatementsLib.waitForSeconds(driver, 3);
					xls.setCellData(Activation_sheet, "Activation_Token No", i, Activation_no.getText());
					WaitStatementsLib.waitForSeconds(driver, 3);
					driver.navigate().refresh();
				}
			}

		} catch (Exception e) {
			System.out.println("Issue in getamountvalidate method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// get alert capture
	public String Getalertcapture() {
		String alerttext = null;
		try {
			Alert alert = driver.switchTo().alert();
			alerttext = alert.getText();
			driver.switchTo().alert().accept();
			return alerttext;
		} catch (Exception e) {

			return alerttext;
		}
	}

	// To get Current date And Time
	public String getcurrendate() {
		String date = null;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy HHmm");
			LocalDateTime now = LocalDateTime.now();
			date = dtf.format(now);
			System.out.println(date);
			return date;
		} catch (Exception e) {
			System.out.println("Issue in getcurrendate method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return date;
	}

	// To validate Activation button is displayed or Not
	public boolean activatebtnvalidate() {
		boolean button = false;
		try {
			boolean btn = Activation_Btn.isDisplayed();
			if (btn == true) {
				return true;
			} else {
				return button;
			}
		} catch (Exception e) {
			return button;
		}

	}

	// Below methods to use perform the installation process.

	public void Addinstallation() {
		try {
			int rws = xls.getRowCount(Installation_sheet);
			for (int i = 2; i <= rws; i++) {
				String RunStatus = xls.getCellData(Installation_sheet, 0, i);
				if (RunStatus.toUpperCase().equalsIgnoreCase("Yes")) {

					String voucherNo = xls.getCellData(Installation_sheet, 4, i);
					Thread.sleep(3000);
					Voucher_activation_textbox.sendKeys(voucherNo);
					ApplicationUtilities.DynamicWait(driver, strloader);
					Thread.sleep(2000);
					ApplicationUtilities.Focuschange(driver, Str_Pin_Scratch_code_textbox, 3000);
					Thread.sleep(2000);
					boolean error = errorcatchup();
					if (error == true) {
						xls.setCellData(Installation_sheet, "Issues/Remarks", i, error_bottam.getText());
						Thread.sleep(3000);
						driver.navigate().refresh();
						continue;
					}
					Thread.sleep(2000);
					ApplicationUtilities.Focuschange(driver, Str_Pin_Scratch_code_textbox, 3000);
					Pin_Scratch_code_textbox.sendKeys(xls.getCellData(Installation_sheet, 5, i));
					Thread.sleep(2000);
					String Boxtyped = xls.getCellData(Installation_sheet, 8, i);
					Thread.sleep(2000);
					if (BoxType_dropdown.isEnabled()) {
						ApplicationUtilities.dropdownTextEqualIgnoreCase(BoxType_dropdown, Boxtyped);
						Thread.sleep(2000);
					} else {
						xls.setCellData(Installation_sheet, "Issues/Remarks", i, "Box Type is not enabled");
						Thread.sleep(2000);
						driver.navigate().refresh();
						continue;
					}
					System.out.println("Consumer Sections Filled for " + voucherNo);
					String mobile = ApplicationUtilities.Dynamic_MobileNo();
					Spoken_With_Textbox.sendKeys(Namevalue + "Spoken With-" + StrCurrentDT);
					Thread.sleep(2000);
					customer_name_textBox.sendKeys(Namevalue + "Customer-" + StrCurrentDT);
					Thread.sleep(2000);
					House_number_textbox.sendKeys(Namevalue + "House No-" + StrCurrentDT);
					Thread.sleep(2000);
					AreaLocality_textbox.sendKeys(Namevalue + "AreaLocality-" + StrCurrentDT);
					Thread.sleep(2000);
					Mobile_no_textbox.sendKeys(mobile);
					Thread.sleep(2000);
					Alternate_mobile_textbox.sendKeys(mobile);
					Thread.sleep(2000);
					Tel_official_textbox.sendKeys(mobile);
					String pin = xls.getCellData(Installation_sheet, 9, i);
					Thread.sleep(2000);
					ApplicationUtilities.DynamicWait(driver, strloader);
					pin_textbox.sendKeys(pin);
					Thread.sleep(2000);
					pin_textbox.sendKeys(Keys.TAB);
					Thread.sleep(2000);
					error = errorcatchup();
					if (error == true) {
						xls.setCellData(Installation_sheet, "Issues/Remarks", i, error_bottam.getText());
						Thread.sleep(2000);
						driver.navigate().refresh();
						continue;
					}
					boolean alert = getwindowpopup_handles();
					if (alert == true) {
						xls.setCellData(Installation_sheet, "Issues/Remarks", i, "Invalid Pin Code");
						driver.navigate().refresh();
						continue;
					}
					Thread.sleep(2000);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Fill PIN");
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					boolean areaa = AreaLocalty_dropdown.isEnabled();
					Thread.sleep(2000);
					if (areaa == true) {
						Thread.sleep(2000);
						String area = xls.getCellData(Installation_sheet, 22, i);
						Thread.sleep(3000);
						if (area.isEmpty()) {
							Select indexbase = new Select(AreaLocalty_dropdown);
							indexbase.selectByIndex(1);
						} else {
							boolean arealocalityexist = ApplicationUtilities.validatedropdowndata(AreaLocalty_dropdown,
									area);
							if (arealocalityexist == true) {
								ApplicationUtilities.dropdownTextEqualIgnoreCase(AreaLocalty_dropdown, area);
							} else {
								Select indexbase = new Select(AreaLocalty_dropdown);
								indexbase.selectByIndex(1);
							}
						}
					}
					Thread.sleep(3000);
					String Email = ApplicationUtilities.Dynamic_Email();
					Thread.sleep(2000);
					Email_textbox.sendKeys(Email);
					Thread.sleep(2000);
					Landmark_textbox.sendKeys("test" + mobile);
					Thread.sleep(2000);
					System.out.println("Customer information filled ");

					boolean offer = ApplicationUtilities.validatedropdowndata(offername_dropdown,
							xls.getCellData(Installation_sheet, 10, i));
					if (offer == true) {
						ApplicationUtilities.dropdownTextEqualIgnoreCase(offername_dropdown,
								xls.getCellData(Installation_sheet, 10, i));
					} else {
						xls.setCellData(Installation_sheet, "Issues/Remarks", i, "Offername not Matched");
						driver.navigate().refresh();
						continue;
					}
					Thread.sleep(2000);
					String Languagedata = xls.getCellData(Installation_sheet, 11, i);
					boolean language = ApplicationUtilities.validatedropdowndata(Languagezone_dropdown, Languagedata);
					Thread.sleep(2000);
					if (language == true) {
						ApplicationUtilities.dropdownTextEqualIgnoreCase(Languagezone_dropdown, Languagedata);
						Thread.sleep(2000);
						ApplicationUtilities.DynamicWait(driver, strloader);
						Thread.sleep(2000);
					} else {
						xls.setCellData(Installation_sheet, "Issues/Remarks", i, "languageZone not Matched");
						driver.navigate().refresh();
						continue;
					}
					Thread.sleep(3000);
					ApplicationUtilities.DynamicWait(driver, strloader);

					boolean packagename = ApplicationUtilities.validatedropdowndata(Package_name_dropdwon,
							xls.getCellData(Installation_sheet, 12, i));
					if (packagename == true) {
						ApplicationUtilities.dropdownTextEqualIgnoreCase(Package_name_dropdwon,
								xls.getCellData(Installation_sheet, 12, i));
					} else {
						xls.setCellData(Installation_sheet, "Issues/Remarks", i, "Package Not matched");
						driver.navigate().refresh();
						continue;

					}
					Thread.sleep(2000);
					String odu = xls.getCellData(Installation_sheet, 15, i);
					if (odu.equalsIgnoreCase("yes")) {
						ODU(i);
					}
					Thread.sleep(2000);

					installation_validation(i);
					Thread.sleep(2000);
					String HDMI = xls.getCellData(Installation_sheet, 13, i);
					if (HDMI.equalsIgnoreCase("Yes")) {
						HDMICable(i, Boxtyped);
					}
					Thread.sleep(2000);
					remarks_textbox.sendKeys(Namevalue + "Remarks-" + StrCurrentDT);
					Thread.sleep(2000);
					System.out.println("Offer Details filled");
					ApplicationUtilities.Fun_PassScreenshot(driver, "Before Submit");
					Thread.sleep(2000);
					ApplicationUtilities.Scroll_Page_To_Bottom(driver);
					// selectAddon();
					Thread.sleep(2000);
					save_btn.click();
					ApplicationUtilities.Fun_PassScreenshot(driver, "After Submit");
					Thread.sleep(3000);
					getwindowpopup_handles();
					Thread.sleep(3000);
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_lblMessage']")));
					String data = error_bottam.getText();
					Thread.sleep(2000);
					if (data.contains("SuccessFully!! ")) {
						Thread.sleep(3000);
						String token = ticket.getText();
						System.out.println(token);
						Thread.sleep(2000);
						String[] installationToken = ApplicationUtilities.split(token, ":");
						String TokenNo = installationToken[1].toString();
						Thread.sleep(2000);
						xls.setCellData(Installation_sheet, "Token No", i, TokenNo);
						Thread.sleep(2000);

						Thread.sleep(2000);
						xls.setCellData(Activation_sheet, "Installation_TokenNo", i, TokenNo);
						Thread.sleep(3000);
						ApplicationUtilities.DynamicWait(driver, strloader);
						driver.navigate().refresh();
						continue;
					} else if (data.contains("Not Sufficient Kitty Amount")) {

						Thread.sleep(3000);
						System.out.println(ticket.getText());
						xls.setCellData(Installation_sheet, "Issues/Remarks", i, error_bottam.getText());
						Thread.sleep(3000);
						ApplicationUtilities.DynamicWait(driver, strloader);
						String kityrecharge = xls.getCellData(Installation_sheet, 3, i);
						// This code use for kitty Re-charge
						if (kityrecharge.toUpperCase().equalsIgnoreCase("yes")) {
							kittyy = error_bottam.getText();
							getkittyrecharge(voucherNo, i);
							System.out.println("Kitty recharge successfully");
							Thread.sleep(2000);
							i--;
							driver.navigate().refresh();
							continue;
						}
						driver.navigate().refresh();
						continue;

					} else {
						boolean error1 = errorcatchup();
						if (error1 == true) {
							xls.setCellData(Installation_sheet, "Issues/Remarks", i, error_bottam.getText());
							Thread.sleep(3000);
							driver.navigate().refresh();
							continue;
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Issue in Addinstallation  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public String finalkitty() {

		String finalamnt;
		try {

			String kity = kittyy;
			String[] aftersplit = ApplicationUtilities.split(kity, "and");
			String newstring = aftersplit[0].toString();
			String[] requiredprice = ApplicationUtilities.split(newstring, "Rs.");
			String newstring1 = requiredprice[1].toString();
			newstring1 = newstring1.substring(0, newstring1.length() - 4);

			String Actualprice = newstring1;
			String balance = aftersplit[1].toString();
			String[] balance1 = ApplicationUtilities.split(balance, "Rs.");
			String balancekitty = balance1[1].toString();
			int ActualpriceInt = Integer.parseInt(Actualprice);
			int balancekittyInt = Integer.parseInt(balancekitty);
			int finalamount = ActualpriceInt - balancekittyInt;
			finalamnt = Integer.toString(finalamount);
			return finalamnt;

		} catch (Exception e) {
			System.out.println("Issue in finalkitty method.");
			Reporter.log(e.getLocalizedMessage(), true);

		}
		return null;
	}

	public void getkittyrecharge(String voucherNo, int i) {
		// String username = PropertiesLib.getPropertyValue("userideasypaydealer");
		// String password = PropertiesLib.getPropertyValue("passwordeasypaydealer");

		try {

			ApplicationUtilities.Ntab(driver, "http://10.95.21.15:8084/");
			WaitStatementsLib.waitForSeconds(driver, 3);
			// easypayLoginLogoutPage obj = new easypayLoginLogoutPage();
			// obj.logineasypay(username, password);
			WaitStatementsLib.waitForSeconds(driver, 3);
			ApplicationUtilities.MouseHovernclick(driver, "Sales", "Customer Payment");
			WaitStatementsLib.waitForSeconds(driver, 3);

			ApplicationUtilities.dropdownTextEqualIgnoreCase(PaymentTypeddp, "Activation");
			WaitStatementsLib.waitForSeconds(driver, 3);
			VCRMN.sendKeys(voucherNo);
			WaitStatementsLib.waitForSeconds(driver, 3);
			ApplicationUtilities.Focuschange(driver, customerpayment, 3000);
			WaitStatementsLib.waitForSeconds(driver, 3);
			String getkity = finalkitty();
			xls.setCellData(Installation_sheet, "Kitty Amount", i, getkity);
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);
			customerpayement_amount.sendKeys(getkity);
			WaitStatementsLib.waitForSeconds(driver, 3);
			submit.click();
			WaitStatementsLib.waitForSeconds(driver, 3);
			ApplicationUtilities.DynamicWait(driver, strloader);
			confirm_click();
			WaitStatementsLib.waitForSeconds(driver, 3);
			ApplicationUtilities.DynamicWait(driver, strloader);
			ApplicationUtilities.Fun_PassScreenshot(driver, "Kitty Recharge");
			WaitStatementsLib.waitForSeconds(driver, 3);
			close_popup.click();
			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.close();
			WaitStatementsLib.waitForSeconds(driver, 3);
			@SuppressWarnings({ "unchecked", "rawtypes" })
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(0));

		} catch (Exception e) {
			System.out.println("Issue in getkittyrecharge  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public void confirm_click() {
		try {
			confirmbtn.click();
			WaitStatementsLib.waitForSeconds(driver, 3);
			confirmbtn.click();
		} catch (Exception e) {
			System.out.println("Issue in confirm_click  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public boolean installation_validation(int i) {
		try {
			String installtion = xls.getCellData(Installation_sheet, 17, i);
			if (installtion.toUpperCase().equalsIgnoreCase("yes")) {
				installreqyes.click();
				return true;
			} else {
				installreqno.click();
				return true;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public void selectAddon() {
		try {

			driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=':'])[25]/following::span[3]"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i1_gvlAlaCarteList_ctl10_chkBoxAlacarte")).click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i1_gvlAlaCarteList_ctl11_chkBoxAlacarte")).click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i1_gvlAlaCarteList_ctl15_chkBoxAlacarte")).click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i1_gvlAlaCarteList_ctl14_chkBoxAlacarte")).click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);

			driver.findElement(
					By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList\"]/ul/li[3]/a/span/span[2]")).click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i3_gvEntertainmentPack_ctl10_chkBoxAlacarte"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);

			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i3_gvEntertainmentPack_ctl09_chkBoxAlacarte"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Zee Super Pack TeluguKannada SD - (Rs. 35.00*)'])[1]/following::span[3]"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.findElement(By.id(
					"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_gvAddOnChannel_ctl04_chkBoxAddOns"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.findElement(By.id(
					"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_gvAddOnChannel_ctl05_chkBoxAddOns"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			WaitStatementsLib.waitForSeconds(driver, 3);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_btnSubmitAddOn"))
					.click();
			WaitStatementsLib.waitForSeconds(driver, 3);
		} catch (Exception ex) {
			Reporter.log("Issue on selection of Add-on !!", true);
			System.out.println("Issue on selection of Add-on !!" + ex);
		}
	}

	// To Select channels at Installation Time
	public boolean mera_Pack(String channel_name) {
		boolean flag = false;
		try {
			String paidon = Paid_On_btn.getText();
			String apnapack = Apna_Pack_btn.getText();
			if (paidon.contains("Add-on packs") && apnapack.contains("Mera Apna Pack")) {
				WaitStatementsLib.waitForSeconds(driver, 3);
				ApplicationUtilities.DynamicWait(driver, strloader);
				Apna_Pack_btn.click();
				WaitStatementsLib.waitForSeconds(driver, 3);
				ApplicationUtilities.DynamicWait(driver, strloader);
				if (channel_name.isEmpty()) {
					WaitStatementsLib.waitForSeconds(driver, 3);
					xls.setCellData(Installation_sheet, "Issue", 0, "channel name not found");
					WaitStatementsLib.waitForSeconds(driver, 3);
					return false;
				}
				channelname_MearaApna_pack_textbox.sendKeys(channel_name);
				WaitStatementsLib.waitForSeconds(driver, 3);
				String packname = existing_pack.getText();
				if (packname.contains(channel_name)) {
					for (int i = 2; i <= 138; i++) {

						String channelname = driver.findElement(By.xpath(
								"//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_gvAddOnChannel\"]/tbody/tr["
										+ i + "]/td[1]"))
								.getText();
						if (channelname.contains(channel_name)) {
							if (i <= 9) {

								driver.findElement(By.xpath(
										"//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_gvAddOnChannel_ctl0"
												+ i + "_chkBoxAddOns\"]"))
										.click();
								return true;
							} else {
								driver.findElement(By.xpath(
										"//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_gvAddOnChannel_ctl"
												+ i + "_chkBoxAddOns\"]"))
										.click();
								return true;

							}
						}

					}
				} else {
					WaitStatementsLib.waitForSeconds(driver, 3);
					System.out.println("Channel not found");
					WaitStatementsLib.waitForSeconds(driver, 3);
					xls.setCellData(Installation_sheet, "Issue", 0, "Channel Not choice");
					WaitStatementsLib.waitForSeconds(driver, 3);
					return false;
				}

			}
		} catch (Exception e) {
			System.out.println("Issue in Mera apna Pack " + e);
		}
		return flag;
	}

	// To validate HDMI cable display or not
	public boolean HDMICable(int i, String Boxtype) {
		boolean HDMIenable = false;
		try {
			if (Boxtype.contains("HD")) {
				String HDMI = xls.getCellData(Installation_sheet, 14, i);
				if (HDMI.contains("yes")) {
					HDMI_cable_yes_checkbox.click();
				} else {
					Skip_offer_checkbox.click();
				}
			}
			return true;

		} catch (Exception e) {
			return HDMIenable;
		}

	}

	// To validate ODU is display or Not
	public void ODU(int i) {
		try {
			String ODU = xls.getCellData(Installation_sheet, 16, i);
			if (ODU.contains("Yes")) {
				Without_odu_checkbox.click();
				WaitStatementsLib.waitForSeconds(driver, 3);
				String instlation = xls.getCellData(Installation_sheet, 18, i);
				if (instlation.contains("yes")) {
					instalation_req_yes_checkbox.click();
				} else {
					instalation_req_No_checkbox.click();
				}
			}

		} catch (Exception e) {
			System.out.println("Issue in ODU method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// To get the Error capture on the bottom
	public static boolean errorcatchup() {
		boolean wrongvalue = false;
		try {
			String data = error_bottam.getText();
			if (data.isEmpty()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Issue in errorcatchup  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return wrongvalue;
	}

	// To Handles the window Pop-ups
	public boolean getwindowpopup_handles() {
		boolean status = false;
		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			return status;
		}
	}

	// Below methods to use for write data in excel
	public int countRunstatus() {
		int Runstatus = 0;
		try {
			int coloumn = xls.getColumnCount(Installation_sheet);
			for (int j = 2; j <= coloumn; j++) {
				String RunStatus = xls.getCellData(Installation_sheet, 0, j);
				{
					if (RunStatus.toUpperCase().equalsIgnoreCase("yes")) {

						Runstatus++;
					}

				}
			}
		} catch (Exception e) {
			System.out.println("Issue in countRunstatus  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return Runstatus;
	}

	// Write data in EXcel Sheet as per your requirement and base on Scheme ID
	public void writedata_In_Excel() {
		try {
			System.out.println("Start time to write Excel" + ApplicationUtilities.Fun_DateTime());
			String Scratchcode = null;
			String Voucher = null;
			int rws = xls.getRowCount(Installation_sheet);
			LinkedList<String> readydata = update_On_schemeId();
			for (int i = 2; i <= rws; i++) {
				String RunStatus = xls.getCellData(Installation_sheet, 0, i);
				if (RunStatus.toUpperCase().equalsIgnoreCase("yes")) {
					for (String fetchdata : readydata) {
						String[] voucher_scratchcode = ApplicationUtilities.split(fetchdata, ":");
						Scratchcode = voucher_scratchcode[1].toString().intern().trim();
						Voucher = voucher_scratchcode[0].toString().intern().trim();
						WaitStatementsLib.waitForSeconds(driver, 3);
						xls.setCellData(Installation_sheet, "Voucher", i, Scratchcode);
						WaitStatementsLib.waitForSeconds(driver, 3);
						xls.setCellData(Installation_sheet, "Scratch code", i, Voucher);
						WaitStatementsLib.waitForSeconds(driver, 3);
						readydata.remove(fetchdata);

						break;

					}
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in Loaddata_In_Excel  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		System.out.println("End time to write Excel" + ApplicationUtilities.Fun_DateTime());
	}

	// Get data form database
	public CopyOnWriteArrayList<String> getVoucher_ScratchCode() {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		String Voucher = null;
		String Scratchcode = null;
		try {
			int randomno = ApplicationUtilities.getRandomDoubleBetweenRange(40, 30);
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameDishtv);
			/*
			 * ResultSet result1 = Objcon.executeQuery("Select top " + randomno +
			 * "  VoucherCode,VoucherNo   from dishtvindia..Voucherinfo (nolock) where  Activationid is null and locationtype ='DL' and SchemeId = 717 and VoucherCode is not null  order by Date_time desc"
			 * );
			 */

			ResultSet result1 = Objcon.executeQuery("Select top " + randomno
					+ "  VoucherCode,VoucherNo   from dishtvindia..Voucherinfo (nolock) \r\n"
					+ "			where  Activationid is null and locationtype ='DL' \r\n"
					+ "			and SchemeId = 717 and VoucherCode is not null and voucherno not in \r\n"
					+ "			(Select distinct  top 10 Voucherno from dishtvindia_srcrm..Complainttrn (nolock) where  voucherno is not null and voucherno <>'' and complaintdt>getdate()-30) \r\n"
					+ "			order by Date_time desc");

			while (result1.next()) {
				Scratchcode = result1.getString("VoucherCode");
				Voucher = result1.getString("VoucherNo");
				String concatetinate = Scratchcode + ":" + Voucher;
				list.add(concatetinate);
			}
			return list;
		} catch (Exception e) {
			System.out.println("Issue in getVoucher_ScratchCode  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return list;
	}

	// Update data as per requirement
	public LinkedList<String> update_On_schemeId() {
		LinkedList<String> afterupdatedata = new LinkedList<String>();
		try {
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameDishtv);
			DatabaseConnection Objcon1 = new DatabaseConnection(serverNode1, DBuserIDNode1, DBPassNode1,
					DBnameNode1SMSDTH2003);
			CopyOnWriteArrayList<String> complainttrndata = validateComplaiantTRN_OnNode1();
			int runstatus = countRunstatus();
			for (int i = 2; i <= runstatus + 1; i++) {
				String SchemeId = xls.getCellData(Installation_sheet, 7, i);
				for (String itreatedata : complainttrndata) {
					String Voucher = ApplicationUtilities.getnoofstring(itreatedata, ":");
					Objcon.executeupdate("update dishtvindia..Voucherinfo set schemeid = " + SchemeId
							+ " where voucherno in ('" + Voucher + "')");
					Objcon.executeupdate("update dishtvindia..Subscribers set Hwvoucherno = " + SchemeId
							+ " where Hwvoucherno  in ('" + Voucher + "')");
					Objcon1.executeupdate("update Itemserialnomaster_voucher set schemeid =" + SchemeId
							+ " where SerialNumber in ('" + Voucher + "')");
					afterupdatedata.add(itreatedata);
					complainttrndata.remove(itreatedata);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in update_On_schemeId  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return afterupdatedata;

	}

	// To validate fetch data is exist in Node 2 or Not
	public CopyOnWriteArrayList<String> validateComplaiantTRN_OnNode2() {
		CopyOnWriteArrayList<String> orignallist = null;

		@SuppressWarnings("unused")
		ArrayList<String> rawdata = null;
		String data = null;
		try {
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameDishtv);
			rawdata = new ArrayList<String>();
			CopyOnWriteArrayList<String> dataa = getVoucher_ScratchCode();
			Iterator<String> getvoucher = dataa.iterator();
			while (getvoucher.hasNext()) {

				String value = getvoucher.next();
				String combineddata = value;
				String Voucher = ApplicationUtilities.getnoofstring(combineddata, ":");
				ResultSet result = Objcon.executeQuery(
						"select rowid from complainttrn(nolock) where Voucherno=" + "'" + Voucher + "'" + "");
				if (result.next()) {
					data = result.getString("rowid");
					if (data == null) {

					} else {

						dataa.remove(value);
					}
				}
			}

			orignallist = new CopyOnWriteArrayList<String>(dataa); // To copy one list to another list

		} catch (Exception e) {
			System.out.println("Issue in validateComplaiantTRN_OnNode2  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return orignallist;
	}

	// To validate fetch data is exist in Node 1 or Not
	public CopyOnWriteArrayList<String> validateComplaiantTRN_OnNode1() {
		CopyOnWriteArrayList<String> Finallist = null;
		String data = null;
		try {

			CopyOnWriteArrayList<String> dataa = validateComplaiantTRN_OnNode2();
			Iterator<String> getvoucher = dataa.iterator();
			while (getvoucher.hasNext()) {

				String value = getvoucher.next();
				String combineddata = value;
				String Voucher = ApplicationUtilities.getnoofstring(combineddata, ":");
				DatabaseConnection Objcon = new DatabaseConnection(serverNode1, DBuserIDNode1, DBPassNode1,
						DBnameNode1SMSDTH2003);
				ResultSet result = Objcon.executeQuery(
						"select rowid from complainttrn(nolock) where Voucherno=" + "'" + Voucher + "'" + "");
				if (result.next()) {
					data = result.getString("rowid");
					if (data == null) {

					} else {

						dataa.remove(value);
					}
				}
			}

			Finallist = new CopyOnWriteArrayList<String>(dataa);

		} catch (Exception e) {
			System.out.println("Issue in validateComplaiantTRN_OnNode1 method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return Finallist;
	}

	public void scroll(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

		} catch (Exception e) {
			System.out.println("Issue in scroll method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// vivek

	public void Phoenix_Installation() {
		try {

			int rws = xls.getRowCount(Installation_sheet);

			for (int i = 2; i <= rws; i++) {
				String strrun = xls.getCellData(Installation_sheet, 0, i);

				if (strrun.toUpperCase().equalsIgnoreCase("Yes"))

				{
					iloop = iloop + 1;

					if (iloop >= 2) {
						//driver.switchTo().defaultContent();

						String strMSG = "";
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
							strMSG = driver.switchTo().window(winHandle).getTitle();
							Thread.sleep(3000);
							if (strMSG.contains("D2H :: Customer Service")) {
								// complalclose.click();
								WaitStatementsLib.waitForSeconds(driver, 3);
								driver.switchTo().defaultContent();
								Move_To_Installation_Page(i);
							}

						}

						
					}

					driver.navigate().refresh();
					Thread.sleep(2000);
					driver.switchTo().frame("ifPhoenix");
					connectiontype.click();
					new Select(connectiontype)
							.selectByVisibleText(xls.getCellData(Installation_sheet, "Connection Type", i));
					Boxtype.click();
					new Select(Boxtype).selectByVisibleText(xls.getCellData(Installation_sheet, "Box Type", i));
					WaitStatementsLib.waitForSeconds(driver, 3);
					TxtVoucherno.clear();
					Voucherno = xls.getCellData(Installation_sheet, "Voucher", i);
					TxtVoucherno.sendKeys(Voucherno);
					ApplicationUtilities.DynamicWait(driver, strLoader);
					WaitStatementsLib.waitForSeconds(driver, 3);
					Body.click();
					WaitStatementsLib.waitForSeconds(driver, 3);
					TxtVoucherCode.clear();
					TxtVoucherCode.sendKeys(xls.getCellData(Installation_sheet, "Scratch code", i));
					ApplicationUtilities.Fun_PassScreenshot(driver, "Stock Type");
					System.out.println("Stock Type data filled Successfully");
					WaitStatementsLib.waitForSeconds(driver, 3);
					Txtspoken.clear();
					Txtspoken.sendKeys(Namevalue + StrCurrentDT);
					WaitStatementsLib.waitForSeconds(driver, 3);
					Txtcust.clear();
					Txtcust.sendKeys(Namevalue + StrCurrentDT);
					TxtAdd1.clear();
					TxtAdd1.sendKeys(Namevalue + StrCurrentDT);
					TxtAdd2.clear();
					TxtAdd2.sendKeys(Namevalue + StrCurrentDT);
					String mobile = ApplicationUtilities.Dynamic_MobileNo();
					Txtmobile.clear();
					Txtmobile.sendKeys(mobile);
					WaitStatementsLib.waitForSeconds(driver, 3);
					Txtmobile1.clear();
					Txtmobile1.sendKeys(mobile);
					WaitStatementsLib.waitForSeconds(driver, 3);
					Txt_Landmark.clear();
					Txt_Landmark.sendKeys(Namevalue + StrCurrentDT);
					ApplicationUtilities.dropdownTextContains(Langueddp, "Hindi");
					TxtPinCode.clear();
					TxtPinCode.sendKeys(xls.getCellData(Installation_sheet, "Pin code", i));
					WaitStatementsLib.waitForSeconds(driver, 3);
					Body.click();
					ApplicationUtilities.DynamicWait(driver, strLoader);
					WaitStatementsLib.waitForSeconds(driver, 3);
					filllocality(i);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Customer Info");
					System.out.println("Customer Info data filled Successfully");
					WaitStatementsLib.waitForSeconds(driver, 3);
					Body.click();
					offer_section(i);
					ODU_IDU_Condition(i);
					ApplicationUtilities.Scroll_Page_To_Bottom(driver);
					Txt_Remarks.clear();
					WaitStatementsLib.waitForSeconds(driver, 3);
					Txt_Remarks.sendKeys(Namevalue + StrCurrentDT + " Remarks");
					WaitStatementsLib.waitForSeconds(driver, 3);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Installation Before Save");
					System.out.println("Offer data filled Successfully");
					Thread.sleep(2000);
					Btn_Submit.click();
					// WaitStatementsLib.waitForSeconds(driver, 3);
					Thread.sleep(3000);
					Validate_Installation(i);
					Thread.sleep(3000);
					Fill_Complaint_Details(i);

				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void Offer_Name(int i) {
		try {
			Ddl_Offer.click();
			WaitStatementsLib.waitForSeconds(driver, 3);

			ApplicationUtilities.dropdownTextContains(Ddl_Offer, xls.getCellData(Installation_sheet, "Offer Name", i));
			WaitStatementsLib.waitForSeconds(driver, 3);
		} catch (Exception ex) {
			try {
				new Select(Ddl_Offer).selectByIndex(1);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("There are no Offer Name.");
				xls.setCellData(Installation_sheet, "Issues/Remarks", i, "There are no Offer Name.");
				e.printStackTrace();
			}
			System.out.println(ex);
		}
	}

	public void Language_Name(int i) {
		try {
			new Select(Ddl_Language).selectByVisibleText(xls.getCellData(Installation_sheet, 11, i));
			WaitStatementsLib.waitForSeconds(driver, 3);
			ApplicationUtilities.DynamicWait(driver, strLoader);
		} catch (Exception ex) {
			try {
				new Select(Ddl_Language).selectByIndex(1);
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				System.out.println("There are no language Name.");
				xls.setCellData(Installation_sheet, "Issues/Remarks", i, "There are no language Name.");
				e.printStackTrace();
			}
			System.out.println(ex);
		}
	}

	public void Package_Name(int i) {
		try {
			String Package = xls.getCellData(Installation_sheet, "Package", i);
			new Select(Ddl_Package).selectByVisibleText(Package);
			Thread.sleep(3000);
			ApplicationUtilities.DynamicWait(driver, strLoader);
			Thread.sleep(8000);
		} catch (Exception ex) {
			try {
				new Select(Ddl_Package).selectByIndex(1);
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				System.out.println("There are no Package Name.");
				xls.setCellData(Installation_sheet, "Issues/Remarks", i, "There are no Package Name.");
				e.printStackTrace();
			}
			System.out.println(ex);
		}
	}

	public void Fill_Complaint_Details(int k) {
		try {

			String strMSG = "";
			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				strMSG = driver.switchTo().window(winHandle).getTitle();
				Thread.sleep(3000);
				if (strMSG.contains(":: Request ::")) {
					// complalclose.click();
					WaitStatementsLib.waitForSeconds(driver, 3);
					strMSG = ApplicationUtilities.Dynamic_MobileNo();
					complmobile.sendKeys(strMSG);
					WaitStatementsLib.waitForSeconds(driver, 3);
					strMSG = ApplicationUtilities.Dynamic_MobileNo();
					complaltmobile.sendKeys(strMSG);
					WaitStatementsLib.waitForSeconds(driver, 3);
					scallcategory = searchcategory.getAttribute("value");
					WaitStatementsLib.waitForSeconds(driver, 3);
					xls.setCellData(Installation_sheet, "Call Category", k, scallcategory);
					WaitStatementsLib.waitForSeconds(driver, 3);
					complSave.click();
					Thread.sleep(3000);
					strMSG = ApplicationUtilities.getTextandCloseAlert(driver);
					Thread.sleep(3000);
					System.out.println(strMSG);
					Thread.sleep(3000);
					if (strMSG != null && !strMSG.isEmpty()) {
						long Tokennumber = Integer.parseInt(strMSG.replaceAll("[^0-9]", ""));
						Thread.sleep(3000);
						strtoken = Long.toString(Tokennumber);
						Thread.sleep(3000);
						System.out.println("Your Token Number is : " + strtoken);
						Thread.sleep(3000);
						xls.setCellData(Installation_sheet, "Token No", k, strtoken);
						Thread.sleep(2000);
					} else {
						System.out.println("Issue in Fillcomplaint" );
						xls.setCellData(Installation_sheet, "Token No", k, "Issue in Fillcomplaint");
						//driver.switchTo().window(winHandle).get("D2H :: Landing Page");
						//driver.switchTo().defaultContent();

					}

				}

			}

		} catch (Exception ex) {
			// driver.switchTo().window(winHandle).get("D2H :: Customer Service");
			driver.switchTo().defaultContent();

			System.out.println("Exception in Fillcomplaint" + ex);
		}
	}

	public void getWindowName() {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			Thread.sleep(2000);
			checkboxinstallationrequest.click();
			WaitStatementsLib.waitForVisibilityOfElement(driver, Tagging, 10);
			Tagging.click();
			WaitStatementsLib.waitForSeconds(driver, 3);

			driver.navigate().refresh();
			driver.switchTo().frame("ifPhoenix");
			// Phoenix_Installation();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void offer_section(int i) {

		try {
			Offer_Name(i);
			Language_Name(i);
			Package_Name(i);
		} catch (Exception e) {
			System.out.println("Issue in offer_section");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ODU_IDU_Condition(int i) {
		try {
			String StrIDU = xls.getCellData(Installation_sheet, "IDU", i);
			if (StrIDU.toUpperCase().equalsIgnoreCase("Yes")) {
				ChkODU.click();
				System.out.println("IDU marked as checked");
			}

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "ODU_IDU_Condition");
			System.out.println("Issue in ODU_IDU_Condition");
			System.out.println(ex);
		}
	}

	public void Validate_Installation(int i) {
		try {
			System.out.println("");
			strkitty = kittyamount.getText();
			String[] excelamount = strkitty.split("Amount");
			System.out.println(excelamount[1]);
			String excelamt = excelamount[1];
			xls.setCellData(Installation_sheet, "Kitty Amount", i, excelamt);
			System.out.println("Available " + strkitty);
			String kittyinfo = Kittybalanceinfo.getText();
			String[] strArray = kittyinfo.split(": ");
			System.out.println(strArray[1]);
			String amount = strArray[1];

			double Amt = Double.parseDouble(amount);
			System.out.println(Amt);
			String TotalAmountValue = totalamount.getText();
			System.out.println(TotalAmountValue);
			int Amount1 = Integer.parseInt(TotalAmountValue);
			if (Amt == 0.0) {

				// xls.setCellData(Installation_sheet, "Amount1", i, TotalAmountValue);
				Thread.sleep(2000);
				try {
					savebtnkitty.click();
					eaypay(i);

				} catch (Exception e) {
					System.out.println(e);
				}

			} else if (Amt >= Amount1) {
				Thread.sleep(3000);
				getKittyAmount();
				Thread.sleep(3000);
				savebtnkitty.click();
				Thread.sleep(3000);
				xls.setCellData(Installation_sheet, "Amount1", i, TotalAmountValue);
			} else if (Amt < Amount1) {

				savebtnkitty.click();
				Thread.sleep(2000);
				eaypay(i);
			}

		} catch (Exception ex) {
			System.out.println("Issue in Validate_Installation !" + ex);
		}
	}

	public void getKittyAmount() {
		try {
			Thread.sleep(3000);
			int x = afterrechargekittyclose.getLocation().getX();
			int y = afterrechargekittyclose.getLocation().getY();
			System.out.println("x cord" + x);
			System.out.println("Y cord" + y);

			if (x != 0) {
				Thread.sleep(3000);
				afterrechargekittyclose.click();
			}
			Thread.sleep(3000);
			continueagain.click();
			Thread.sleep(2000);
			int a = refreshkitybalance.getLocation().getX();
			int b = refreshkitybalance.getLocation().getY();
			System.out.println("X coordinate : " + a + "Y cordinate : " + b);
			if (x != 0) {
				Thread.sleep(3000);
				refreshkitybalance.click();
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			savebtnkitty.click();
		} catch (Exception e) {
			System.out.println("Issue in getKittyAmount Method :" + e);
		}
	}

	public void Savetoken(int i) {
		try {
			strtoken = driver.findElement(By.xpath("//*[@id=\"lblTokenNo\"]")).getText();
			Thread.sleep(3000);
			System.out.println(strtoken);
			String strerror = driver.findElement(By.xpath("//*[@id=\"lblInstReqError\"]")).getText();
			if (strerror.contains("Request is already")) {
				driver.findElement(By.xpath("//*[@id=\"btnSaveInstRequest\"]")).click();
				System.out.println(strerror);
				xls.setCellData(Installation_sheet, "Token No", i, strerror);
				driver.navigate().refresh();

			} else {
				long Ltoken = Integer.parseInt(strtoken.replaceAll("[\\D]", ""));
				Thread.sleep(2000);
				String strToken = Long.toString(Ltoken);
				xls.setCellData(Installation_sheet, "Token No", i, strToken);
				driver.findElement(By.xpath("//*[@id=\"divReceipt\"]/input")).click();
				driver.navigate().refresh();
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void filllocality(int i) {
		try {
			Thread.sleep(2000);
			ApplicationUtilities.dropdownTextContains(Ddl_Locality, "Not Aware");

			String strLocality = Ddl_Locality.getText();
			if (strLocality.contains("Not Aware")) {
				System.out.println("Area/Locality- Not Available !");
			} else {
				ApplicationUtilities.dropdownTextContains(Ddl_Locality,
						xls.getCellData(Installation_sheet, "Arealocality", i));
				ApplicationUtilities.DynamicWait(driver, strLoader);
				Thread.sleep(4000);
			}

		} catch (Exception ex) {
			System.out.println("Issue in select Area locality !" + ex);
		}
	}

	public void eaypay(int i) {
		try {

			String strerror = "";
			Thread.sleep(2000);
			EPRS_ID.clear();
			EPRS_ID.sendKeys("1017");
			eprspassword.clear();
			eprspassword.sendKeys("dish@123");
			rechargebuttoneprs.click();
			WaitStatementsLib.waitForSeconds(driver, 5);
			strerror = rechargebodymsg.getText();
			System.out.println(strerror);
			Thread.sleep(2000);
			closerechargebtn.click();
			Thread.sleep(3000);
			getKittyAmount();

			// Savetoken(i);

		} catch (Exception ex) {
			// System.out.println(driver.findElement(By.xpath("//*[@id=\"spnError\"]")).getText());
			System.out.println(ex);
		}

	}

	/// Read the Offer details in case offer are showing
	public void ActivationVoucherVC(String Voucherno, int Amont) {
		try {
			Thread.sleep(5000);
			ApplicationUtilities.MouseHovernclick(driver, StrMenu, StrsubMenu);
			Thread.sleep(3000);
			VCRMN.clear();
			ApplicationUtilities.dropdownTextContains(PaymentTypeddp, "Activation");
			Thread.sleep(2000);
			VCRMN.sendKeys(Voucherno);
			ApplicationUtilities.Focuschange(driver, AltM, 4000);
			Validatealert();
			if (BtnFinalSubmit.isEnabled()) {
				ApplicationUtilities.DynamicWait(driver, Loader);
				Thread.sleep(2000);
				AltMobileno.clear();
				AltMobileno.sendKeys(ApplicationUtilities.Dynamic_MobileNo());
				txtAmtfirst.clear();
				txtAmtfirst.sendKeys(String.valueOf(Amont));
				if (BtnFinalSubmit.isEnabled()) {
					first_Submit();
					Thread.sleep(2000);
					first_Submit();
					Thread.sleep(2000);
					ApplicationUtilities.DynamicWait(driver, Loader);
					FinalSubmit(1);

					@SuppressWarnings({ "unchecked", "rawtypes" })
					ArrayList tabs = new ArrayList(driver.getWindowHandles());
					driver.switchTo().defaultContent();
					driver.close();
					driver.switchTo().window((String) tabs.get(0));

				}
			}
			// driver.navigate().refresh();

		} catch (Exception e) {
			System.out.println("Exception VC recharge page." + e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}

	}

	/// Click on Final submit button
	public void FinalSubmit(int i) {
		try {
			Thread.sleep(1000);
			BtnFinalSubmit.click();
			ApplicationUtilities.DynamicWait(driver, Loader);
			Thread.sleep(1000);
			Validatealert();
		} catch (Exception ex) {
			System.out.println("Exception in Final submit click." + ex.getMessage());
			Reporter.log(ex.getLocalizedMessage(), true);

		}
	}

	/// Click on First submit button
	public void first_Submit() {
		try {
			Thread.sleep(3000);
			BtnFinalSubmit.click();
			Thread.sleep(1000);
			if (Feedbacksubmit.isDisplayed()) {
				Feedbacksubmit.click();
			}
			Validatealert();
		} catch (Exception ex) {
			System.out.println("Exception in submit click." + ex.getMessage());
			Reporter.log(ex.getLocalizedMessage(), true);

		}
	}

	// Method to validate alert and write value into excel
	public void Validatealert() {
		String stralert = "";
		try {
			Thread.sleep(2000);
			ApplicationUtilities.DynamicWait(driver, Loader);
			stralert = ApplicationUtilities.getalerttext(driver, Alerttext);
			if (stralert != null && !stralert.trim().isEmpty()) {
				if (stralert.contains("success")) {
					System.out.println(stralert);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Recharge");
					Thread.sleep(3000);
					ApplicationUtilities.AlertClose(driver, AlertClose);
				} else {
					System.out.println(stralert);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Recharge");
					Thread.sleep(3000);
					ApplicationUtilities.AlertClose(driver, AlertClose);
				}
			}

		} catch (Exception ex) {
			System.out.println("Exception in Validate Alert." + ex.getMessage());
			Reporter.log(ex.getLocalizedMessage(), true);

		}
	}

}
