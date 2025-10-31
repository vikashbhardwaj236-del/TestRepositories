package in.dishtv.Activation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import easyPay_Pages.EasypayLoginLogoutDealerPage;
import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;
import in.dishtv.library.DatabaseConnection;
import in.dishtv.library.ExcelUtilities;
import in.dishtv.library.PropertiesLib;

/**
 * @author Vivek.Kumar
 * 
 *
 */
public class Phoenix_Installation_Version_Page extends BaseLibrary {

	String StrPathexl = System.getProperty("user.dir") + "//testdata//DishD2h_Phoenix_Two.xlsx";
	ExcelUtilities xls = new ExcelUtilities(StrPathexl);
	String Installation_sheet = "Data_Install_Ind_V2";
	String Activation_sheet = "Data_Activation";
	String strloader = "//*[@id='imgAJAXLoader']";
	static Select sel;
	SoftAssert assertion = new SoftAssert();
	String Namevalue = "Test ";
	String StrCurrentDT = ApplicationUtilities.Fun_DateTime();
	String kittyy;

	public Phoenix_Installation_Version_Page() {
		super();
		PageFactory.initElements(driver, this);

	}

	// x'path
	@FindBy(linkText = "Multi Conversion")
	private WebElement Dishtv_btn;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_ddlConnectionType\"]")
	private WebElement Connection_Type_dropdown;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_rdVoucherNo\"]")
	private WebElement Voucher_activation_Radiobtn;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtVoucherNo\"]")
	private WebElement Voucher_activation_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtVoucherCode\"]")
	private WebElement Pin_Scratch_code_textbox;
	String Str_Pin_Scratch_code_textbox = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtVoucherCode\"]";

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtBoxType\"]")
	private WebElement BoxType_dropdown;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_ddlParentType\"]")
	private WebElement ParentType_dropdown;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtParentVcNo\"]")
	private WebElement Parent_VC_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtSpokenWith\"]")
	private WebElement Spoken_With_Textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtCustomerName\"]")
	private WebElement customer_name_textBox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtAddress1\"]")
	private WebElement House_number_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtAddress2\"]")
	private WebElement AreaLocality_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtMobileNo\"]")
	private WebElement Mobile_no_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtAltMNo\"]")
	private WebElement Alternate_mobile_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtTelOff\"]")
	private WebElement Tel_official_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtIRCity\"]")
	private WebElement citytextbox_autofill;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtPinCode\"]")
	private WebElement pin_textbox;
	String Strpin_textbox = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtPinCode\"]";
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_ddlLocality\"]")
	private WebElement AreaLocalty_dropdown;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtEmail\"]")
	private WebElement Email_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtLandmark\"]")
	private WebElement Landmark_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_chkISIDU\"]")
	private WebElement Without_odu_checkbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_chkISIDU\"]")
	private WebElement Rs_600Insatalation_checkbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_pnlD4Offer\"]/table/tbody/tr[1]/td/label")
	private WebElement offergettext;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_rdbInstalCompY\"]")
	private WebElement instalation_req_yes_checkbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_rdbInstalCompN\"]")
	private WebElement instalation_req_No_checkbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_rbtnlstHDMICable_0\"]")
	private WebElement HDMI_cable_yes_checkbox;

	@FindBy(xpath = "//*[@id='ddlCableType']")
	private WebElement HDMIDROPDOWN;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_rbtnlstHDMICable_1\"]")
	private WebElement Skip_offer_checkbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lblRequiredKitty\"]")
	private WebElement required_kitty_amnt;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_ddlLangZone\"]")
	private WebElement Languagezone_dropdown;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_ddlOfferName\"]")
	private WebElement offername_dropdown;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_ddlPackage\"]")
	private WebElement Package_name_dropdwon;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList\"]/ul/li[2]/a/span/span[2]")
	private WebElement mera_apna_pack;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtRemarks\"]")
	private WebElement remarks_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]")
	private WebElement save_btn;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnModify\"]")
	private WebElement modify_btn;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnRefresh\"]")
	private WebElement resetbtn;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_ddlGenre\"]")
	private WebElement Genre_dropdown_apnapack;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_ddlHDSD\"]")
	private WebElement HD_SD_Dropdown_Meraapnakack;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_txtPkgName\"]")
	private WebElement channelname_MearaApna_pack_textbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_btnSubmitAddOn\"]")
	private WebElement Ok_mera_apna_pack;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_imgbtnSMSSendRequestClose\"]")
	private WebElement close_mera_apna_pack;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_lblHeadertext\"]")
	private WebElement mera_apna_pack_header;

	@FindBy(xpath = "//*[@id=\"ctl00_lblMessage\"]")
	private static WebElement error_bottam;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_pnlStock\"]/fieldset/legend")
	private static WebElement Stocktypeheader;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList\"]/ul/li[2]/a/span/span[2]")
	private WebElement Paid_On_btn;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList\"]/ul/li[4]/a/span/span[2]")
	private WebElement Apna_Pack_btn;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i1_gvlAlaCarteList_ctl03_chkBoxAlacarte\"]")
	private WebElement Paid_on_channel;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lblRequiredKitty\"]")
	private WebElement Kitty_amount;

	@FindBy(xpath = "//*[@id=\"ExistingPack\"]")
	private WebElement existing_pack;

	@FindBy(xpath = "//*[@id=\"ctl00_lblMessage\"]")
	private WebElement ticket;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_chkCopyToParent\"]")
	private WebElement Copy_to_all_checkbox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_pnlStock\"]/fieldset/legend")
	private WebElement Stock_type;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_rdVcNo\"]")
	private WebElement VC_radiobtn;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList_i0_txtStbNo\"]")
	private WebElement STB_Textbox;

	@FindBy(xpath = "//*[@id=\"CphPageMiddle_txtPaymentTo\"]")
	private WebElement VCRMN;

	@FindBy(xpath = "//*[@id=\"CphPageMiddle_txtAmount\"]")
	private WebElement customerpayement_amount;

	String customerpayment = "//*[@id=\"CphPageMiddle_txtAmount\"]";
	@FindBy(xpath = "//*[@id=\"CphPageMiddle_btnSubmit\"]")
	private WebElement submit;

	@FindBy(xpath = "//*[@id='CphPageMiddle_btnSubmit']")
	private WebElement confirmbtn;

	@FindBy(xpath = "//*[@id=\"pnlErrorMessage\"]/table/tbody/tr[1]/td[2]/img")
	private WebElement close_popup;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lblRequiredKitty\"]")
	private WebElement Requiredkitty;

	@FindBy(xpath = "//*[@id=\"navbar-collapse-1\"]/ul/li[2]/a/b")
	private WebElement Dashboard;

	@FindBy(xpath = "//*[@id=\"searchTokenDetails\"]")
	private WebElement Search_textbox;

	@FindBy(xpath = "//*[@id=\"btnSerachToken\"]")
	private WebElement Search_btn;

	@FindBy(xpath = "//*[@id=\"OrdersGrid\"]/div[2]/div[1]/table/tbody/tr/td[4]")
	private WebElement Doubleclick;

	@FindBy(xpath = "//*[@id=\"OrdersGrid\"]/div[2]/div[1]/table/tbody/tr/td")
	private WebElement no_record;

	@FindBy(xpath = "//*[@id='btnClose'][@style='float:right; z-index:40000;color:white;']")
	private WebElement close_work_order_sheet;

	@FindBy(xpath = "//*[@id=\"ddlIsVisitRequired\"]")
	private WebElement Is_visit_required_dropdown;

	@FindBy(xpath = "//*[@id=\"txtScheduleDatetime\"]")
	private WebElement Arival_date_time_textbox;

	@FindBy(xpath = "//*[@id=\"ddlTechnicianListForSchedule\"]")
	private WebElement Technician_dropdown;

	@FindBy(xpath = "//*[@id=\"txtScheduleRemarks\"]")
	private WebElement Remarks_textbox;

	@FindBy(xpath = "//*[@id=\"btnScheduleToken\"]")
	private WebElement Schedule_btn;

	@FindBy(xpath = "//*[@id=\"btnActivate\"]")
	private WebElement Activation_Btn;

	@FindBy(xpath = "//*[@id=\"txtVC\"]")
	private WebElement VC_textbox;

	@FindBy(xpath = "//*[@id=\"txtSTB\"]")
	private WebElement STB_no;

	@FindBy(xpath = "//*[@id=\"workOrderUpdateHeader\"]/h6")
	private WebElement Work_order_Update_header;

	@FindBy(xpath = "//*[@id=\"alertDiv\"]/p")
	private WebElement closegetdata;

	@FindBy(xpath = "//*[@id=\"modal-content-activation\"]/div[1]/div[1]/h6")
	private WebElement activavtionHeader;

	@FindBy(xpath = "//*[@id=\"txtSAF\"]")
	private WebElement SAFTextbox;

	@FindBy(xpath = "//*[@id=\"ddlCableType\"]")
	private WebElement cabletype_dropdown;

	@FindBy(xpath = "//*[@id=\"txtCableAmount\"]")
	private WebElement amounttextbox;

	@FindBy(xpath = "//*[@id=\"ddlTVType\"]")
	private WebElement TvTypedropdown;

	@FindBy(xpath = "//*[@id=\"txtFatherHusbandName\"]")
	private WebElement fathername;

	@FindBy(xpath = "//*[@id=\"div_Activation_PaymentGateway\"]/input")
	private WebElement continue_btn;

	@FindBy(xpath = "//*[@id=\"widget-box-1\"]/div[1]/h6")
	private WebElement Paid_on_pack_btn;

	@FindBy(xpath = "//*[@id=\"tbl_NP\"]/tbody/tr[3]/td[3]/label/span")
	private WebElement Paidonpack_channel;

	@FindBy(xpath = "//*[@id=\"widget-box-1\"]/div[1]/h6/div")
	private WebElement Mera_Apna_pack_btn;

	@FindBy(xpath = "//*[@id='PB_tblMeraApnaPack']/tbody/tr[2]/td[4]/label/span")
	private WebElement Meraapnapack_channel;

	@FindBy(xpath = "//*[@id=\"NP_txtFilterChannel\"]")
	private WebElement Package_Searchbox;

	@FindBy(xpath = "//*[@id='btnProceedToPay']")
	private WebElement proced_to_pay;

	@FindBy(xpath = "//*[@id=\"lblKitty\"]")
	private WebElement Avlbl_kitty;

	@FindBy(xpath = "//*[@id=\"tblAddonSummary\"]/tbody/tr[2]/td/table/tbody/tr[5]/td[4]")
	private WebElement Total_amount;

	@FindBy(xpath = "//*[@id=\"divPaymentModes\"]/table/tbody/tr/td/table/tbody/tr[1]/td/div[1]/label/span")
	private WebElement EPRSCheckbox;

	@FindBy(xpath = "//*[@id=\"divPaymentModes\"]/table/tbody/tr/td/table/tbody/tr[1]/td/div[2]/label/span")
	private WebElement AK_checkbox;

	@FindBy(xpath = "//*[@id=\"eprsUserName\"]")
	private WebElement Accountno_EPRS_checkbox;

	@FindBy(xpath = "//*[@id=\"eprsPassword\"]")
	private WebElement Password_EPRS_checkbox;

	@FindBy(xpath = "//*[@id=\"btnSaveActivation\"]")
	private WebElement Save_btn_EPRS;

	@FindBy(xpath = "//*[@id=\"divActivationReceipt\"]/center/label")
	private WebElement Activation_no;

	@FindBy(xpath = "//*[@id=\"ddlMonoTypeLNBF\"]")
	private WebElement monoblockLMC;

	@FindBy(xpath = "//*[@id=\"txtActHappyCode\"]")
	private WebElement HappycodeTextbox;

	@FindBy(xpath = "//*[@id=\"div_GenerateHappyCode\"]/table/tbody/tr/td[3]/input")
	private WebElement Happycodebtn;

	@FindBy(xpath = "//*[@id=\"divActivationForm\"]/div[1]/div/div/table/thead/tr/th")
	private WebElement Basic_details;

	@FindBy(xpath = "//*[@id=\"chkNonStopOffer\"]")
	private WebElement non_stop_checkbox;

	@FindBy(xpath = "//*[@id=\"ddlNonStopOffers\"]")
	private WebElement Non_stop_dropdown;

	@FindBy(xpath = "//*[@id=\"txtLandmark\"]")
	private WebElement landmark_txtbox;

	@FindBy(xpath = "//*[@id=\"txtCableAmount\"]")
	private WebElement HDMI_Amnt;

	@FindBy(xpath = "//*[@id=\"chkSmrtStick\"]")
	private WebElement Smart_stick_chkbox;

	@FindBy(xpath = "//*[@id=\"divAccessories\"]/div/div/div/table/tbody/tr[3]/td/strong")
	private WebElement Smart_stick_text;

	@FindBy(xpath = "//*[@id=\"widget-box-3\"]/div[2]/div[1]/table/tbody/tr[3]/td[4]")
	private WebElement Activationvalidate;

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
	@FindBy(xpath = "//*[@id=\"ddlLanguages\"]")
	private WebElement Langueddp;

	@FindBy(xpath = "//*[@id=\"ddlWhatsAppLang\"]")
	private WebElement WPLangueddp;

	@FindBy(xpath = "//*[@id=\"divSummary\"]/div[1]")
	private WebElement kittyamount;
	@FindBy(xpath = "//*[@id=\"lblInstReqError\"]")
	private WebElement Installation_Msg;

	@FindBy(xpath = "//*[@id=\"lblTokenNo\"]")
	private WebElement Tokenno;

	@FindBy(xpath = "//*[@id=\"lblInstReqError\"]")
	private WebElement lblerror;

	@FindBy(xpath = "//*[@id=\"divReceipt\"]/input")
	private WebElement CloseToken;
	@FindBy(id = "spnIDU")
	private WebElement ChkODU;

	@FindBy(xpath = "//*[@id=\"trOduInstallation\"]/td/strong/label[1]/span")
	private WebElement InsreYes;
	@FindBy(xpath = "//*[@id=\"trOduInstallation\"]/td/strong/label[2]/span")
	private WebElement InsreNo;
	@FindBy(xpath = "//*[@id=\"svcRow\"]/td/div/span/i[3]/a")
	private WebElement BSPTC;
	@FindBy(xpath = "//*[@id=\"svcRow\"]/td/div/label/span")
	private WebElement BSPON;

	// --------- End of Phoenix Installatin ------------

	// -------------------------- Easy Recharge ---
	String StrMenu = "Sales";
	String StrsubMenu = "Customer Payment";
	@FindBy(xpath = "//*[@id='CphPageMiddle_ddlPaymentType']")
	private WebElement PaymentTypeddp;
	@FindBy(xpath = "//*[normalize-space(text()) and normalize-space(.)='Account Balance:'])[1]/following::td[1]")
	private WebElement Balance;
	@FindBy(xpath = "//*[@id=\"CphPageMiddle_txtMobileNo\"]")
	private WebElement AltMobileno;
	@FindBy(xpath = "//*[@id='CphPageMiddle_btnSubmit']")
	private WebElement BtnFinalSubmit;
	String AltM = "//*[@id=\"CphPageMiddle_txtMobileNo\"]";
	@FindBy(xpath = "//*[@id=\"CphPageMiddle_txtAmount\"]")
	private WebElement txtAmtfirst;
	@FindBy(xpath = "//*[@id=\"CphPageMiddle_btnFeedbackSubmit\"]")
	private WebElement Feedbacksubmit;
	String Loader = "//*[@id='imgAJAXLoader']";
	@FindBy(xpath = "//*[@id='pnlErrorMessage']/table/tbody/tr[1]/td[2]/img")
	private WebElement AlertClose;
	@FindBy(xpath = "//*[@id='lblMesg']")
	private WebElement Alerttext;
	// ------------------------ End of Easy Recharge --------------

	// To perform Mouse hover and click
	public void mousehover() {
		try {
			Thread.sleep(3000);
			Brand_Selection();
			Thread.sleep(3000);
			Menu_Navigation();
			// driver.get("http://10.65.10.47:12345/activation/Installation/newrequest");
			Thread.sleep(3000);
			// Menu_Navigation();
			Thread.sleep(3000);
			Phoenix_Installation();
		} catch (Exception e) {
			System.out.println("Issue in mouse hover  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public void Menu_Nevigation() {
		try {
			ApplicationUtilities.MouseHovernclick(driver, "Utilities", "Add Installation Call (New)");

		} catch (Exception e) {
			System.out.println("Issue in Menu_Nevigation  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public void Brand_Selection() {
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"BrandChosse\"]/div/center/div/div[2]/div/div[1]/center/a/img")).click();

		} catch (Exception e) {
			System.out.println("Issue in Brand_Selection  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public void Menu_Navigation() {
		try {

			ApplicationUtilities.MouseHovernclick(driver, "Utilities", "Add Installation Call (New)");

		} catch (Exception e) {
			System.out.println("Issue in Menu_Navigation method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// TO VALIDATE CHECK TITLE
	public void check_title() {
		try {
			String Actual_Title = driver.getTitle();
			Reporter.log(StrCurrentDT = ApplicationUtilities.Fun_DateTime(), true);
			System.out.println("Title of Installation Page : " + driver.getTitle());
			Assert.assertTrue(Actual_Title.contains("Add Installation Request"),
					"We are not in Dealer Page:::Title Mistatch:::");

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
					Thread.sleep(2000);
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

	@SuppressWarnings("rawtypes")
	public void Activation() {

		String urlphoenix = PropertiesLib.getPropertyValue("urlphoenix");
		try {

			Thread.sleep(3000);
			ApplicationUtilities.Ntab(driver, urlphoenix);
			PhoenixLoginTest obj = new PhoenixLoginTest();
			obj.phoenixLoginValidUseridValidPassword();
			int rws = xls.getRowCount(Activation_sheet);
			for (int i = 2; i <= rws; i++) {
				String strrun = xls.getCellData(Activation_sheet, 0, i);

				if (strrun.toUpperCase().equalsIgnoreCase("Yes")) {
					@SuppressWarnings("unchecked")
					ArrayList tabs = new ArrayList(driver.getWindowHandles());
					driver.switchTo().window((String) tabs.get(1));
					Thread.sleep(2000);
					Dashboard.click();
					Thread.sleep(3000);
					String token = xls.getCellData(Activation_sheet, 2, i);
					Thread.sleep(2000);
					String LocationId = xls.getCellData(Activation_sheet, 9, i);
					installationtokenupdate(token, LocationId);
					Thread.sleep(2000);
					Search_textbox.sendKeys(token);
					Thread.sleep(2000);
					Search_btn.click();
					Thread.sleep(2000);
					if (no_record.getText().contains("No records to display")) {
						Thread.sleep(3000);
						xls.setCellData(Activation_sheet, "Issues/Remarks", i, "Sorry! Please enter Right Token");
						Thread.sleep(3000);
						continue;
					}

					ApplicationUtilities.Fun_PassScreenshot(driver, "InstallationTokenNumber");
					Actions action = new Actions(driver);
					action.moveToElement(Doubleclick);
					action.clickAndHold(Doubleclick);
					action.doubleClick().build().perform();
					Thread.sleep(3000);
					String ActivationVC = Activationvalidate.getText();
					if (ActivationVC.equalsIgnoreCase("0")) {
						boolean activatebtn = activatebtnvalidate();
						Thread.sleep(2000);
						if (activatebtn == false) {
							ApplicationUtilities.dropdownTextEqualIgnoreCase(Is_visit_required_dropdown, "Yes");
							Thread.sleep(3000);
							String Date = getcurrendate();
							String[] parts = ApplicationUtilities.split(Date, " ");
							String part1 = parts[0];
							String part2 = parts[1];
							int Part2 = Integer.parseInt(part2);
							int part3 = Part2 + 5;
							Arival_date_time_textbox.sendKeys(part1 + Keys.TAB + part3);
							Thread.sleep(3000);
							ApplicationUtilities.dropdownTextContains(Technician_dropdown,
									xls.getCellData(Activation_sheet, 4, i));
							Thread.sleep(3000);
							Remarks_textbox.sendKeys(Namevalue + "Remarks-" + StrCurrentDT);
							Thread.sleep(3000);
							Schedule_btn.click();
							Thread.sleep(3000);
							String getdata = ApplicationUtilities.Phoenixalertclose(driver);
							Thread.sleep(3000);
							if (getdata.contains("Failure")) {
								Thread.sleep(3000);
								xls.setCellData(Activation_sheet, "Issues/Remarks", i, closegetdata.getText());
								Thread.sleep(3000);
								Thread.sleep(3000);
								close_work_order_sheet.click();
								driver.navigate().refresh();
								i--;
								continue;
							} else if (getdata.contains("Success")) {

								Thread.sleep(3000);
								xls.setCellData(Activation_sheet, "Issues", i, closegetdata.getText());
								Thread.sleep(3000);
								Thread.sleep(3000);
								close_work_order_sheet.click();
								driver.navigate().refresh();
								i--;
								continue;
							}
						}
					} else {
						xls.setCellData(Activation_sheet, "Issues/Remarks", i, "Token No already Activation Done");
						continue;
					}
					Activation_Btn.click();
					Thread.sleep(2000);
					VC_textbox.sendKeys(xls.getCellData(Activation_sheet, 5, i));
					Thread.sleep(2000);
					VC_textbox.sendKeys(Keys.TAB);
					Thread.sleep(2000);
					String datee = getcurrendate();
					SAFTextbox.sendKeys("SAF" + datee);
					Thread.sleep(3000);
					Select indexbase = new Select(HDMIDROPDOWN);
					Thread.sleep(2000);
					indexbase.selectByIndex(1);
					Thread.sleep(2000);
					getwindowpopup_handles();
					Select indexbase1 = new Select(TvTypedropdown);
					indexbase1.selectByIndex(1);
					Thread.sleep(2000);
					Select indexbase2 = new Select(monoblockLMC);
					indexbase2.selectByIndex(1);
					Thread.sleep(2000);
					fathername.sendKeys("test" + datee);
					Thread.sleep(2000);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Activation_page");
					Thread.sleep(2000);
					scroll(continue_btn);
					Thread.sleep(3000);
					continue_btn.click();
					Thread.sleep(2000);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Payment_Summary");
					String alert = Getalertcapture();
					Thread.sleep(2000);
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnProceedToPay']")));
					if (alert == null) {
						Thread.sleep(3000);
						proced_to_pay.click();
						Thread.sleep(3000);
						ApplicationUtilities.Fun_PassScreenshot(driver, "Payment_Summary");
						Thread.sleep(2000);
						getamountvalidate(i);
					} else {
						Thread.sleep(3000);
						xls.setCellData(Activation_sheet, "Activation_Token No", i, alert);
						Thread.sleep(3000);
						driver.navigate().refresh();
						Thread.sleep(3000);
						continue;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in Activation method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
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
				Thread.sleep(3000);
				Accountno_EPRS_checkbox.sendKeys(userid);
				Thread.sleep(3000);
				Password_EPRS_checkbox.sendKeys(password);
				Thread.sleep(3000);
				Save_btn_EPRS.click();
				Thread.sleep(3000);
				xls.setCellData(Activation_sheet, "Activation_Token No", i, Activation_no.getText());
				Thread.sleep(3000);
				driver.navigate().refresh();
			} else {
				if (intkitty > intamount) {
					AK_checkbox.click();
					Thread.sleep(3000);
					Save_btn_EPRS.click();
					Thread.sleep(3000);
					xls.setCellData(Activation_sheet, "Activation_Token No", i, Activation_no.getText());
					Thread.sleep(3000);
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
		String username = PropertiesLib.getPropertyValue("userideasypaydealer");
		String password = PropertiesLib.getPropertyValue("passwordeasypaydealer");

		try {

			ApplicationUtilities.Ntab(driver, "http://10.95.21.15:8084/");
			Thread.sleep(3000);
			// easypayLoginLogoutPage obj = new easypayLoginLogoutPage();
			// obj.logineasypay(username, password);
			Thread.sleep(3000);
			ApplicationUtilities.MouseHovernclick(driver, "Sales", "Customer Payment");
			Thread.sleep(3000);

			ApplicationUtilities.dropdownTextEqualIgnoreCase(PaymentTypeddp, "Activation");
			Thread.sleep(3000);
			VCRMN.sendKeys(voucherNo);
			Thread.sleep(3000);
			ApplicationUtilities.Focuschange(driver, customerpayment, 3000);
			Thread.sleep(2000);
			String getkity = finalkitty();
			xls.setCellData(Installation_sheet, "Kitty Amount", i, getkity);
			ApplicationUtilities.DynamicWait(driver, strloader);
			Thread.sleep(3000);
			customerpayement_amount.sendKeys(getkity);
			Thread.sleep(3000);
			submit.click();
			Thread.sleep(4000);
			ApplicationUtilities.DynamicWait(driver, strloader);
			confirm_click();
			Thread.sleep(3000);
			ApplicationUtilities.DynamicWait(driver, strloader);
			ApplicationUtilities.Fun_PassScreenshot(driver, "Kitty Recharge");
			Thread.sleep(2000);
			close_popup.click();
			Thread.sleep(3000);
			driver.close();
			Thread.sleep(3000);
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
			Thread.sleep(3000);
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
				instalation_req_yes_checkbox.click();
				return true;
			} else {
				instalation_req_No_checkbox.click();
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
			Thread.sleep(1000);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i1_gvlAlaCarteList_ctl10_chkBoxAlacarte")).click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			Thread.sleep(1000);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i1_gvlAlaCarteList_ctl11_chkBoxAlacarte")).click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			Thread.sleep(1000);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i1_gvlAlaCarteList_ctl15_chkBoxAlacarte")).click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			Thread.sleep(1000);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i1_gvlAlaCarteList_ctl14_chkBoxAlacarte")).click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			Thread.sleep(3000);

			driver.findElement(
					By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_rpbAlacarteList\"]/ul/li[3]/a/span/span[2]")).click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			Thread.sleep(1000);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i3_gvEntertainmentPack_ctl10_chkBoxAlacarte"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);

			Thread.sleep(3000);
			driver.findElement(
					By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i3_gvEntertainmentPack_ctl09_chkBoxAlacarte"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			Thread.sleep(3000);
			driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Zee Super Pack TeluguKannada SD - (Rs. 35.00*)'])[1]/following::span[3]"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			ApplicationUtilities.DynamicWait(driver, strloader);
			Thread.sleep(3000);
			driver.findElement(By.id(
					"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_gvAddOnChannel_ctl04_chkBoxAddOns"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			Thread.sleep(3000);
			driver.findElement(By.id(
					"ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_gvAddOnChannel_ctl05_chkBoxAddOns"))
					.click();
			ApplicationUtilities.DynamicWait(driver, strloader);
			Thread.sleep(3000);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_rpbAlacarteList_i5_AddOnChannellist_btnSubmitAddOn"))
					.click();
			Thread.sleep(3000);
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
				Thread.sleep(3000);
				ApplicationUtilities.DynamicWait(driver, strloader);
				Apna_Pack_btn.click();
				Thread.sleep(3000);
				ApplicationUtilities.DynamicWait(driver, strloader);
				if (channel_name.isEmpty()) {
					Thread.sleep(3000);
					xls.setCellData(Installation_sheet, "Issue", 0, "channel name not found");
					Thread.sleep(3000);
					return false;
				}
				channelname_MearaApna_pack_textbox.sendKeys(channel_name);
				Thread.sleep(3000);
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
					Thread.sleep(3000);
					System.out.println("Channel not found");
					Thread.sleep(3000);
					xls.setCellData(Installation_sheet, "Issue", 0, "Channel Not choice");
					Thread.sleep(3000);
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
				Thread.sleep(2000);
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
						Thread.sleep(2000);
						xls.setCellData(Installation_sheet, "Voucher", i, Scratchcode);
						Thread.sleep(2000);
						xls.setCellData(Installation_sheet, "Scratch code", i, Voucher);
						Thread.sleep(2000);
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

				if (strrun.toUpperCase().equalsIgnoreCase("Yes")) {
					driver.navigate().refresh();
					ApplicationUtilities.dropdownIndex(connectiontype, 1);
					// connectiontype.click();
					Boxtype.click();
					new Select(Boxtype).selectByVisibleText(xls.getCellData(Installation_sheet, "Box Type", i));
					Thread.sleep(3000);
					TxtVoucherno.clear();
					Voucherno = xls.getCellData(Installation_sheet, "Voucher", i);
					TxtVoucherno.sendKeys(Voucherno);
					ApplicationUtilities.DynamicWait(driver, strLoader);
					Thread.sleep(3000);
					Body.click();
					Thread.sleep(3000);
					TxtVoucherCode.clear();
					TxtVoucherCode.sendKeys(xls.getCellData(Installation_sheet, "Scratch code", i));
					ApplicationUtilities.Fun_PassScreenshot(driver, "Stock Type");
					System.out.println("Stock Type data filled Successfully");
					Thread.sleep(3000);
					Txtspoken.clear();
					Txtspoken.sendKeys(Namevalue + StrCurrentDT);
					Thread.sleep(2000);
					Txtcust.clear();
					Txtcust.sendKeys(Namevalue + StrCurrentDT);
					TxtAdd1.clear();
					TxtAdd1.sendKeys(Namevalue + StrCurrentDT);
					TxtAdd2.clear();
					TxtAdd2.sendKeys(Namevalue + StrCurrentDT);

					String mobile = ApplicationUtilities.Dynamic_MobileNo();
					Txtmobile.clear();
					Txtmobile.sendKeys(mobile);
					Thread.sleep(2000);
					 whatsupconcent(i);

					ApplicationUtilities.dropdownTextContains(Langueddp, "Hindi");
					Thread.sleep(2000);
					Body.click();
					TxtPinCode.clear();
					TxtPinCode.sendKeys(xls.getCellData(Installation_sheet, "Pin code", i));
					Body.click();
					ApplicationUtilities.DynamicWait(driver, strLoader);
					Thread.sleep(5000);
					// Txt_Landmark.clear();
					// Txt_Landmark.sendKeys(Namevalue + StrCurrentDT);
					filllocality(i);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Customer Info");
					System.out.println("Customer Info data filled Successfully");
					Thread.sleep(2000);
					Body.click();
					Thread.sleep(3000);
					offer(i);
					ODU_IDU_Condition(i);
					Language_Name(i);
					Package_Name(i);
					BSP_Req(i);
					ApplicationUtilities.Scroll_Page_To_Bottom(driver);
					Txt_Remarks.clear();
					Thread.sleep(3000);
					Txt_Remarks.sendKeys(Namevalue + StrCurrentDT + " Remarks");
					Thread.sleep(3000);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Installation Before Save");
					System.out.println("Offer data filled Successfully");
					Btn_Submit.click();
					Thread.sleep(5000);
					Validate_Installation(i);

				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void whatsupconcent(int i) {
		try {
			String strp = "//*[@id=\"divCustomerInfo\"]/div/div/div/table/tbody/tr[2]/td[4]/div[2]/div[1]/div/div[2]/label/span";
			driver.findElement(By.xpath(strp)).click();
			Thread.sleep(3000);
			String Lug = (xls.getCellData(Installation_sheet, "Lug", i));
			ApplicationUtilities.dropdownTextEqualIgnoreCase(WPLangueddp, Lug);
		} catch (Exception ex) {

			System.out.println(ex);
		}
	}

	public void offer(int i) {
		try {
			Thread.sleep(5000);			
			ApplicationUtilities.Fun_PassScreenshot(driver, "Offer Name");
			Thread.sleep(3000);
			String stroffer = xls.getCellData(Installation_sheet, "Offer Name", i);
			new Select(Ddl_Offer).selectByVisibleText(stroffer);			
			System.out.println("Offer selected " + stroffer);
		} catch (Exception ex) {			
			ApplicationUtilities.dropdownIndex(Ddl_Offer, 1);
			ApplicationUtilities.Fun_FailScreenshot(driver, "Offer Name");
			System.out.println("Issue in Offer selection-default selected");
			System.out.println(ex);
		} 
	}

	public void Language_Name(int i) {
		try {
			Thread.sleep(5000);
			Ddl_Language.click();
			ApplicationUtilities.Fun_PassScreenshot(driver, "Language Name");
			String strlang = xls.getCellData(Installation_sheet, 11, i);
			Thread.sleep(3000);
			new Select(Ddl_Language).selectByVisibleText(strlang);
			Ddl_Language.click();
			System.out.println("Language selected " + strlang);

		} catch (Exception ex) {
			new Select(Ddl_Language).selectByIndex(1);
			System.out.println("Issue in Language selection- default selected");
			ApplicationUtilities.Fun_FailScreenshot(driver, "Language Name");
			System.out.println(ex);
		}
	}

	public void Package_Name(int i) {
		try {
			Thread.sleep(5000);
			ApplicationUtilities.Fun_PassScreenshot(driver, "Package Name");
			String Package = xls.getCellData(Installation_sheet, "Package", i);
			new Select(Ddl_Package).selectByVisibleText(Package);
			Thread.sleep(3000);
			ApplicationUtilities.Fun_PassScreenshot(driver, "Package Name");
			System.out.println("Language selected " + Package);
			ApplicationUtilities.DynamicWait(driver, strLoader);
			// Thread.sleep(3000);

		} catch (Exception ex) {
			new Select(Ddl_Package).selectByIndex(1);
			System.out.println("Issue in Language selection-default selected");
			ApplicationUtilities.Fun_FailScreenshot(driver, "Package Name");
			System.out.println(ex);
		}

	}

	public void ODU_IDU_Condition(int i) {
		try {
			String StrIDU = xls.getCellData(Installation_sheet, "IDU", i);
			if (StrIDU.toUpperCase().equalsIgnoreCase("Yes")) {
				ChkODU.click();
				System.out.println("IDU marked as checked");
				Installation_Req(i);
			}

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Without ODU-Yes - Fail");
			System.out.println("Issue in ODU_IDU_Condition");
			System.out.println(ex);
		}
	}

	public void Installation_Req(int i) {
		try {
			String StrIDU = xls.getCellData(Installation_sheet, "Installation_Req", i);
			if (StrIDU.toUpperCase().equalsIgnoreCase("Yes")) {
				InsreYes.click();
				System.out.println("Installation Required - Marked as Yes");
				ApplicationUtilities.Fun_PassScreenshot(driver, "Ins Req-Marked as Yes");
			} else {
				InsreNo.click();
				System.out.println("Installation Required - Marked as No");
				ApplicationUtilities.Fun_PassScreenshot(driver, "Ins Req-Marked as Yes");

			}

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Installation Required - Fail");
			System.out.println("Installation Required selection");
			System.out.println(ex);
		}
	}

	public void BSP_Req(int i) {
		try {
			String StrIDU = xls.getCellData(Installation_sheet, "BSP", i);
			if (StrIDU.toUpperCase().equalsIgnoreCase("YES")) {
				BSPTC.click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"CloseSVCModal\"]")).click();
				BSPON.click();
				Thread.sleep(3000);
				System.out.println("BSP Required - Marked as Yes");
				ApplicationUtilities.Fun_PassScreenshot(driver, "BSP-Marked as Yes");
			}

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "BSP Required - Fail");
			System.out.println("BSP Required Fail");
			System.out.println(ex);
		}
	}

	public void Validate_Installation(int i) {
		try {
			int iFkittyAmount;
			strkitty = kittyamount.getText();
			System.out.println("Available " + strkitty);
			strkitty = strkitty.substring(15, strkitty.length() - 2);
			int ikitty = Integer.parseInt(strkitty.replaceAll("[\\D]", ""));

			String str = driver.findElement(By
					.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Total Amount'])[1]/following::td[1]"))
					.getText();
			int iredkitty = Integer.parseInt(str.replaceAll("[\\D]", ""));
			iFkittyAmount = iredkitty - ikitty;
			System.out.println("Reuired Kitty Amount - " + iFkittyAmount);
			String strkitty = String.valueOf(iFkittyAmount);
			xls.setCellData(Installation_sheet, "Kitty Amount", i, strkitty);
			Thread.sleep(5000);
			if (iredkitty == ikitty) {
				Btn_final_Submit.click();
				ApplicationUtilities.Fun_PassScreenshot(driver, "Installation After Save");
				if (Installation_Msg.getText().equalsIgnoreCase(strmsg)) {
					System.out.println(strmsg);
					driver.navigate().refresh();
				}
			} else if (iredkitty > ikitty) {
				Btn_final_Submit.click();
				Thread.sleep(5000);
				ApplicationUtilities.Fun_PassScreenshot(driver, "Installation After Save");
				Thread.sleep(5000);
				if (Installation_Msg.getText().equalsIgnoreCase(strmsg)) {
					System.out.println(strmsg);
					driver.navigate().refresh();
				} else if ((Installation_Msg.getText().equalsIgnoreCase("Insufficient Kitty."))) {
					Thread.sleep(5000);
					eaypaylogin();
					ActivationVoucherVC(Voucherno, iFkittyAmount);
					Btn_final_Submit.click();
					Thread.sleep(8000);
					String StrToken = Tokenno.getText();
					System.out.println(StrToken);
					if (StrToken == "") {
						xls.setCellData(Installation_sheet, "Token No", i, "Installation Token no not generated.");
						driver.quit();
					}

					long Ltoken = Integer.parseInt(Tokenno.getText().replaceAll("[\\D]", ""));
					Thread.sleep(2000);
					String strToken = Long.toString(Ltoken);
					Thread.sleep(2000);
					xls.setCellData(Installation_sheet, "Token No", i, strToken);
					Thread.sleep(2000);
					xls.setCellData("Data_Activation", "Installation_TokenNo", i, strToken);
					Thread.sleep(2000);
					CloseToken.click();

				}
			} else if (iredkitty < ikitty) {
				Btn_final_Submit.click();
				if (Installation_Msg.getText().equalsIgnoreCase(strmsg)) {
					System.out.println(strmsg);
					// driver.navigate().refresh();
					System.out.println(strmsg + "Instllation failed..");
					countRunstatus();
					writedata_In_Excel();
					driver.navigate().refresh();
					Phoenix_Installation();

				} else if ((Installation_Msg.getText().equalsIgnoreCase("Insufficient Kitty."))) {
					eaypaylogin();
					ActivationVoucherVC(Voucherno, ikitty);
					Btn_final_Submit.click();
					Thread.sleep(2000);
					System.out.println(Tokenno.getText());
					int IToken = Integer.parseInt(Tokenno.getText().replaceAll("[\\D]", ""));
					String strToken = Integer.toString(IToken);
					xls.setCellData(Installation_sheet, "Token No", i, Tokenno.getText());
					xls.setCellData("Data_Activation", "Installation_TokenNo", i, strToken);
					Thread.sleep(2000);
					CloseToken.click();
				}

				if (ikitty >= iredkitty) {
					System.out.println(Tokenno.getText());
					int IToken = Integer.parseInt(Tokenno.getText().replaceAll("[\\D]", ""));
					String strToken = Integer.toString(IToken);
					xls.setCellData(Installation_sheet, "Token No", i, Tokenno.getText());
					xls.setCellData("Data_Activation", "Installation_TokenNo", i, strToken);
					Thread.sleep(2000);
					CloseToken.click();
				}
			}

		} catch (Exception ex) {

			xls.setCellData(Installation_sheet, "Issues/Remarks", i, lblerror.getText());
			System.out.println("Issue in Validate_Installation !" + ex);
		}
	}

	public void filllocality(int i) {
		try {

			String strLocality = Ddl_Locality.getText();
			if (strLocality.contains("Not Available")) {
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

	public void eaypaylogin() {
		String userid = PropertiesLib.getPropertyValue("userideasypaydealer");
		String pass = PropertiesLib.getPropertyValue("passwordeasypaydealer");
		String easyP_URL = PropertiesLib.getPropertyValue("urleasypay");
		ApplicationUtilities.Ntab(driver, easyP_URL);
		EasypayLoginLogoutDealerPage Obj_easy_pay = new EasypayLoginLogoutDealerPage();
		Obj_easy_pay.logineasypay(userid, pass);
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
