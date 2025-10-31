package in.dishtv.Activation;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
 * @author vivek.kumar
 *
 */
public class Phoenix_Activation_Page extends BaseLibrary {

	String StrPathexl = System.getProperty("user.dir") + "//testdata//DishD2h_Phoenix_Two.xlsx";
	ExcelUtilities xls = new ExcelUtilities(StrPathexl);
	String Sheet_Name = "Data_Activation";
	SoftAssert assertion = new SoftAssert();
	String Strloader = "//*[@id=\"trWaitLoader\"]/td/i";
	PhoenixLoginPage login;
	String StrCurrentDT = ApplicationUtilities.Fun_DateTime();
	String strAlert = "";
	String Namevalue = "Test ";

	public Phoenix_Activation_Page() {
		super();
		PageFactory.initElements(driver, this);
	}

	String strLoader = "Please wait while we are processing your request...";

	@FindBy(linkText = "DashBoard")
	private WebElement Dashboard;

	@FindBy(xpath = "//*[@id=\"searchTokenDetails\"]")
	private WebElement Search_textbox;

	@FindBy(xpath = "//*[@id=\"btnSerachToken\"]")
	private WebElement Search_btn;

	@FindBy(xpath = "//*[@id=\"OrdersGrid\"]/div[2]/div[1]/table/tbody/tr/td[4]")
	private WebElement Doubleclick;

	@FindBy(xpath = "//*[@id=\"OrdersGrid\"]/div[2]/div[1]/table/tbody/tr/td")
	private WebElement no_record;

	@FindBy(xpath = "//i[@class= 'ace-icon fa fa-times']")
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

	@FindBy(xpath = "//*[@id=\"btnProceedToPay\"]")
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

	@FindBy(xpath = "//*[@id=\"txtTelO\"]")
	private WebElement TxttelOffice;
	@FindBy(xpath = "//*[@id=\"txtTelR\"]")
	private WebElement TxttelR;

	@FindBy(xpath = "//*[@id=\"txtMobile2\"]")
	private WebElement Txttelmobile2;
	@FindBy(xpath = "//*[@id=\"txtMobile3\"]")
	private WebElement Txttelmobile3;
	@FindBy(xpath = "//*[@id=\"txtEmail\"]")
	private WebElement TxtEmail;

	// TO VALIDATE BASIC DETAILS
	public void validate_BasicDetails() {
		try {

			Actions action = new Actions(driver);
			Thread.sleep(3000);
			Dashboard.click();
			Thread.sleep(3000);
			Search_textbox.sendKeys("1003948408");
			Thread.sleep(3000);
			Search_btn.click();
			action.moveToElement(Doubleclick);
			action.clickAndHold(Doubleclick);
			action.doubleClick().build().perform();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(Work_order_Update_header));
			Thread.sleep(3000);
			Activation_Btn.click();
			Thread.sleep(3000);
			assertion.assertEquals("Basic Details", Basic_details.getText());
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Issue in validate_BasicDetails method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// TO VALIDATE BASIC DETAILS
	public void ToeknSearch() {
		try {
			int irws = xls.getRowCount("Data_Activation");
			for (int i = 2; i <= irws; i++) {
				Actions action = new Actions(driver);
				Thread.sleep(3000);
				Dashboard.click();
				Thread.sleep(3000);
				Search_textbox.sendKeys(xls.getCellData(Sheet_Name, "Installation_TokenNo", i));
				Thread.sleep(3000);
				Search_btn.click();
				action.moveToElement(Doubleclick);
				action.clickAndHold(Doubleclick);
				action.doubleClick().build().perform();
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(Work_order_Update_header));
				Thread.sleep(3000);
				Activation_Btn.click();
				Thread.sleep(3000);
				assertion.assertEquals("Basic Details", Basic_details.getText());
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			System.out.println("Issue in validate_BasicDetails method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// TO PERFORM NON STOP CHECKBOX
	public void Validate_nonStopcheckbox() {
		try {
			non_stop_checkbox.click();
			Thread.sleep(3000);
			ApplicationUtilities.dropdownTextEqualIgnoreCase(Non_stop_dropdown, "Annual Bharat Cricket Combo");
			Thread.sleep(3000);
			assertion.assertTrue(Non_stop_dropdown.isDisplayed());
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println("Issue in Validate_nonStopcheckbox method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// TO PERFROM MAX LENGTH IN TEXTBOX
	public void MAX_length_validation() {
		try {
			SAFTextbox.sendKeys("fghgvjhvbjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjgfdsg");
			Thread.sleep(3000);
			fathername.sendKeys("fghgvjhvbjjjjjjjjjjjjjjjjfgfgjjjjjjjjjjjjjjjjjjjjjjjjj");
			Thread.sleep(3000);
			landmark_txtbox.sendKeys("ngfddsfdsjfsfdkhdsfhdsfldshfdsfkhdsfhdsfdskjhgfkjdshfdsfkj564564g");
			Thread.sleep(3000);
			continue_btn.click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.navigate().refresh();

		} catch (Exception e) {
			System.out.println("Issue in MAX_length_validation method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// TO PERFORM CALL SCHEDULE
	public void Phoenix_callschudule() {

		try {

			int rws = xls.getRowCount(Sheet_Name);
			for (int i = 2; i <= rws; i++) {
				String strrun = xls.getCellData(Sheet_Name, "Run Status", i);
				if (strrun.toUpperCase().equalsIgnoreCase("Yes")) {
					Actions action = new Actions(driver);
					Thread.sleep(3000);
					Dashboard.click();
					Thread.sleep(3000);
					String token = xls.getCellData(Sheet_Name, "Installation_TokenNo", i);
					Long iTokenno = Long.parseLong(token.replaceAll("[\\D]", ""));
					token = Long.toString(iTokenno);
					installationtokenupdate(token);
					Thread.sleep(3000);
					String avlbl = validate_installation_token(token);
					if (avlbl == null) {
						Thread.sleep(3000);
						xls.setCellData(Sheet_Name, "Issues/Remarks", i, "Sorry! Please enter installation token");
						Thread.sleep(3000);
						continue;
					}
					Search_textbox.sendKeys(token);
					Thread.sleep(3000);
					Search_btn.click();
					Thread.sleep(3000);
					if (no_record.getText().contains("No records to display")) {
						Thread.sleep(3000);
						xls.setCellData(Sheet_Name, "Issues/Remarks", i, "Sorry! Please enter Right Token");
						Thread.sleep(3000);
						continue;
					}

					action.moveToElement(Doubleclick);
					action.clickAndHold(Doubleclick);
					action.doubleClick().build().perform();
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.visibilityOf(Work_order_Update_header));
					Thread.sleep(3000);
					boolean yes = activatebtnvalidate();
					if (yes == true) {
						Thread.sleep(3000);
						// xls.setCellData(Sheet_Name, "Issues/Remarks", i, "Allready schedule");
						// Thread.sleep(3000);
						driver.navigate().refresh();
						Thread.sleep(3000);
						continue;
					}
					// --- Fill Arrival date
					Fill_ArrivalDate();
					Thread.sleep(3000);
					String strTech = xls.getCellData(Sheet_Name, 3, i);
					if (strTech == "") {
						ApplicationUtilities.dropdownTextContains(Technician_dropdown,
								xls.getCellData(Sheet_Name, 3, i));
					} else
						ApplicationUtilities.dropdownIndex(Technician_dropdown, 2);
					Thread.sleep(3000);
					ApplicationUtilities.Fun_PassScreenshot(driver, "Scheduling Done");
					Remarks_textbox.sendKeys(Namevalue + StrCurrentDT);
					Thread.sleep(3000);
					Schedule_btn.click();
					Thread.sleep(3000);
					String getdata = ApplicationUtilities.Phoenixalertclose(driver);
					Thread.sleep(3000);
					if (getdata.contains("Failure")) {
						Thread.sleep(3000);
						xls.setCellData(Sheet_Name, "Issues/Remarks", i, closegetdata.getText());
						Thread.sleep(5000);
						close_work_order_sheet.click();
						driver.navigate().refresh();
						continue;
					} else if (getdata.contains("Success")) {
						Thread.sleep(3000);
						xls.setCellData(Sheet_Name, "Issues/Remarks", i, closegetdata.getText());
						Thread.sleep(5000);
						List<WebElement> radioGrp01 = driver
								.findElements(By.xpath("//i[@class= 'ace-icon fa fa-times']"));
						radioGrp01.get(0).click();
						// close_work_order_sheet.click();
						// driver.navigate().refresh();
						continue;

					}

				}
			}

		} catch (Exception e) {
			System.out.println("Issue in call schedule method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// Method To set Arrival date
	public void Fill_ArrivalDate() {
		try {
			ApplicationUtilities.dropdownTextEqualIgnoreCase(Is_visit_required_dropdown, "Yes");
			Thread.sleep(3000);
			String Date = getcurrendate();
			String[] parts = ApplicationUtilities.split(Date, " ");
			String part1 = parts[0];
			String part2 = parts[1];
			int Part2 = Integer.parseInt(part2);
			int part3 = Part2 + 5;
			Arival_date_time_textbox.sendKeys(part1 + Keys.TAB + part3);
		} catch (Exception ex) {
			System.out.println("Issue in Fill_ArrivalDate");
		}
	}

	public void Phoenix_activation() {
		try {
			driver.navigate().refresh();
			int rws = xls.getRowCount(Sheet_Name);
			for (int i = 2; i <= rws; i++) {
				String strrun = xls.getCellData(Sheet_Name, "Run Status", i);
				if (strrun.toUpperCase().equalsIgnoreCase("Yes")) {
					String ActivationType = xls.getCellData(Sheet_Name, "ActivationType", i);
					if (ActivationType.toUpperCase().equalsIgnoreCase("individual")) {
						Thread.sleep(3000);
						Dashboard.click();
						Thread.sleep(3000);
						String token = xls.getCellData(Sheet_Name, "Installation_TokenNo", i);
						Long iTokenno = Long.parseLong(token.replaceAll("[\\D]", ""));
						token = Long.toString(iTokenno);
						installationtokenupdate(token);
						Thread.sleep(3000);
						String avlbl = validate_installation_token(token);
						if (avlbl == null) {
							Thread.sleep(3000);
							xls.setCellData(Sheet_Name, "Issues/Remarks", i, "Sorry! Please enter installation token");
							Thread.sleep(3000);
							continue;
						}
						Search_textbox.sendKeys(token);
						Thread.sleep(3000);
						Search_btn.click();
						Thread.sleep(3000);
						if (no_record.getText().contains("No records to display")) {
							Thread.sleep(3000);
							xls.setCellData(Sheet_Name, "Issues/Remarks", i, "Sorry! Please enter Right Token");
							Thread.sleep(3000);
							continue;
						}
						Actions action = new Actions(driver);
						Thread.sleep(3000);
						action.moveToElement(Doubleclick);
						action.clickAndHold(Doubleclick);
						action.doubleClick().build().perform();
						Thread.sleep(5000);
						boolean yes = activatebtnvalidate();
						if (yes == false) {
							Thread.sleep(3000);
							xls.setCellData(Sheet_Name, "Issues/Remarks", i, "Activation button is not display");
							Thread.sleep(3000);
							driver.navigate().refresh();
							Thread.sleep(3000);
							continue;
						}
						Thread.sleep(3000);
						Activation_Btn.click();
						Thread.sleep(5000);
						VC_textbox.sendKeys(xls.getCellData(Sheet_Name, "VC No", i));
						Thread.sleep(3000);
						VC_textbox.sendKeys(Keys.TAB);
						Thread.sleep(3000);
						SAFTextbox.sendKeys(StrCurrentDT);
						Thread.sleep(3000);
						SAFTextbox.sendKeys(Keys.TAB);
						Thread.sleep(3000);
						AccessoriesInfo(i);
						SubscribersInfo(i);
						String smartstickyes = xls.getCellData(Sheet_Name, "SmartStick", i);
						if (smartstickyes.toUpperCase().equalsIgnoreCase("yes")) {
							String smartsticky = smart_stick();
							if (smartsticky == null) {
								Thread.sleep(3000);
								xls.setCellData(Sheet_Name, "Issues/Remarks", i,
										"Smart Stick option is not allow for you");
								Thread.sleep(3000);

							} else {
								Thread.sleep(3000);
								Smart_stick_chkbox.click();
								Thread.sleep(3000);
							}
						}
						Thread.sleep(3000);
						scroll(continue_btn);
						Thread.sleep(3000);
						// Paid_on_pack_btn.click();
						Thread.sleep(3000);
						strAlert = ApplicationUtilities.getTextandCloseAlert(driver);

						// scroll(Package_Searchbox);
						// Thread.sleep(3000);
						/*
						 * Paidonpack_channel.click(); Thread.sleep(3000); Mera_Apna_pack_btn.click();
						 * Thread.sleep(5000);
						 */
						strAlert = ApplicationUtilities.getTextandCloseAlert(driver);
						// Thread.sleep(5000);/*
						// Meraapnapack_channel.click();
						// Thread.sleep(6000);
						continue_btn.click();
						Thread.sleep(3000);
						ApplicationUtilities.DynamicWait(driver, strLoader);
						
						strAlert = ApplicationUtilities.getAlertText(driver);
						if (strAlert.contains("Execution Timeout Expired.")) {
							ApplicationUtilities.Fun_FailScreenshot(driver, "Time out Activation Fail");
						}
						strAlert = ApplicationUtilities.getTextandCloseAlert(driver);

						if (strAlert == null) {
							Thread.sleep(8000);
							proced_to_pay.click();
							Thread.sleep(3000);
							ApplicationUtilities.Fun_PassScreenshot(driver, "Before Activation ");
							getamountvalidate(i);
						} else {
							Thread.sleep(3000);
							xls.setCellData(Sheet_Name, "Issues/Remarks/Remarks", i, strAlert);
							Thread.sleep(3000);
							driver.navigate().refresh();
							Thread.sleep(3000);
							continue;
						}

					} /*
						 * else { activationMulti(); }
						 */
				}

			}

		} catch (Exception e) {
			System.out.println("Issue in Individual Activation method.");
			Reporter.log(e.getLocalizedMessage(), true);

		}
	}

	public void SubscribersInfo(int i) {
		try {
			Thread.sleep(3000);
			fathername.sendKeys(Namevalue + StrCurrentDT);
			landmark_txtbox.sendKeys(Namevalue + StrCurrentDT);
			String mobile = ApplicationUtilities.Dynamic_MobileNo();
			TxttelOffice.sendKeys(mobile);
			Thread.sleep(1000);
			TxttelR.sendKeys(mobile);
			Thread.sleep(1000);
			TxttelOffice.sendKeys(mobile);
			Thread.sleep(1000);
			Txttelmobile2.sendKeys(mobile);
			Thread.sleep(1000);
			Txttelmobile3.sendKeys(mobile);
			Thread.sleep(1000);
			String Email = ApplicationUtilities.Dynamic_Email();
			TxtEmail.sendKeys(Email);
			Thread.sleep(1000);

		} catch (Exception e) {
			System.out.println("Issue in SubscribersInfo" + e);
			System.out.println(e);
		}
	}

	public void AccessoriesInfo(int i) {
		try {
			
			cableType(i);
			TVType(i);
			MonoblockLNB(i);

		} catch (Exception e) {
			System.out.println("Issue in AccessoriesInfo");
			System.out.println(e);
		}
	}

	public void cableType(int i) {
		try {
			Thread.sleep(3000);
			boolean cable = ApplicationUtilities.WebElementPrasant(cabletype_dropdown);
			if (cable == true) {
				String hdmi = xls.getCellData(Sheet_Name, "CableType", i);
				Boolean cabletype = ApplicationUtilities.validatedropdowndata(cabletype_dropdown, hdmi);
				Thread.sleep(3000);
				strAlert = ApplicationUtilities.getTextandCloseAlert(driver);
				if (cabletype == false) {
					ApplicationUtilities.dropdownIndex(cabletype_dropdown, 1);
				} else
					ApplicationUtilities.dropdownTextContains(cabletype_dropdown, hdmi);
				strAlert = ApplicationUtilities.getTextandCloseAlert(driver);
			}
			ApplicationUtilities.dropdownIndex(cabletype_dropdown, 1);
			strAlert = ApplicationUtilities.getTextandCloseAlert(driver);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void TVType(int i) {
		try {
			boolean Type = ApplicationUtilities.WebElementPrasant(TvTypedropdown);
			if (Type == true) {
				String strValue = xls.getCellData(Sheet_Name, "TVType", i);
				Boolean Vtype = ApplicationUtilities.validatedropdowndata(TvTypedropdown, strValue);
				strAlert = ApplicationUtilities.getTextandCloseAlert(driver);
				if (Vtype == false) {
					ApplicationUtilities.dropdownIndex(TvTypedropdown, 1);
				} else
					ApplicationUtilities.dropdownTextContains(TvTypedropdown, strValue);
				strAlert = ApplicationUtilities.getTextandCloseAlert(driver);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void MonoblockLNB(int i) {
		try {
			boolean MOType = ApplicationUtilities.WebElementPrasant(monoblockLMC);
			if (MOType == true) {
				String strValue = xls.getCellData(Sheet_Name, "MonoblockLNB", i);
				Boolean MONOtype = ApplicationUtilities.validatedropdowndata(monoblockLMC, strValue);
				strAlert = ApplicationUtilities.getTextandCloseAlert(driver);
				if (MONOtype == false) {
					ApplicationUtilities.dropdownIndex(monoblockLMC, 1);
				} else
					ApplicationUtilities.dropdownTextContains(monoblockLMC, strValue);
				strAlert = ApplicationUtilities.getTextandCloseAlert(driver);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void activationMulti() {
		try {

		} catch (Exception e) {
			System.out.println("Issue in Multi Activation method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public boolean installationtokenupdate(String Token) {
		boolean update = false;
		try {
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameNode2DishtvSRCRM);
			Objcon.executeQuery("update complainttrn set servicerid = 8094  where rowid in (" + Token + ")");
			System.out.println("Installation token no - " + Token + " updated successfully.");
			return true;

		} catch (Exception e) {
			System.out.println("Issue in installationtokenupdate method.");
			Reporter.log(e.getLocalizedMessage(), true);

		}
		return update;
	}

	public String genrateHappyCode(String TicketId) {
		String happycode = null;
		try {
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameNode2DishtvSRCRM);
			ResultSet result = Objcon.executeQuery("select Happy_code from tHappyCodeProcess(nolock) where TicketId ="
					+ TicketId + " order by Date_time desc");
			if (result.next()) {
				happycode = result.getString("Happy_code");
				return happycode;
			}

		} catch (Exception e) {
			System.out.println("Issue in genratehappycode method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return happycode;
	}

	public boolean LMC() {
		boolean lmc = false;
		try {
			lmc = monoblockLMC.isEnabled();
			if (lmc == true) {
				ApplicationUtilities.dropdownTextEqualIgnoreCase(monoblockLMC, "Monoblock");

				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			try {
				Thread.sleep(3000);
				xls.setCellData(Sheet_Name, "Issue", 0, "lmc dropdown is not displayed");
				Thread.sleep(3000);
				return lmc;
			} catch (Exception e2) {

			}
		}
		return lmc;
	}

	public String smart_stick() {
		String smartstick = null;
		try {
			smartstick = Smart_stick_text.getText();
			return smartstick;

		} catch (Exception e) {
			return null;
		}
	}

	public void getamountvalidate(int i) {
		try {
			String userid = PropertiesLib.getPropertyValue("accountnumberkitty");
			String password = PropertiesLib.getPropertyValue("passwordkittyamount");
			String avlblkitty = Avlbl_kitty.getText();
			String amount = Total_amount.getText();
			String strNew = avlblkitty.substring(0, avlblkitty.length() - 2);
			int intkitty = Integer.parseInt(strNew);
			int intamount = Integer.parseInt(amount);
			if (intkitty < intamount) {
				EPRSCheckbox.click();
				Thread.sleep(3000);
				Accountno_EPRS_checkbox.sendKeys(userid);
				Thread.sleep(3000);
				Password_EPRS_checkbox.sendKeys(password);
				Thread.sleep(3000);
				Save_btn_EPRS.click();
				Thread.sleep(3000);
				ApplicationUtilities.DynamicWait(driver, Strloader);
				Thread.sleep(3000);
				ApplicationUtilities.Fun_PassScreenshot(driver, "Activation done");
				xls.setCellData(Sheet_Name, "Issues/Remarks", i, Activation_no.getText());
				Thread.sleep(3000);
				driver.navigate().refresh();
			}
			if (intkitty == intamount) {
				AK_checkbox.click();
				Thread.sleep(3000);
				Save_btn_EPRS.click();
				Thread.sleep(3000);
				ApplicationUtilities.DynamicWait(driver, Strloader);
				Thread.sleep(7000);
				System.out.println(Activation_no.getText());
				ApplicationUtilities.Fun_PassScreenshot(driver, "Activation done");
				xls.setCellData(Sheet_Name, "Activation_Token No", i, Activation_no.getText());
				Thread.sleep(3000);
				driver.navigate().refresh();
			}

			else {
				if (intkitty > intamount) {
					AK_checkbox.click();
					Thread.sleep(3000);
					Save_btn_EPRS.click();
					Thread.sleep(3000);
					ApplicationUtilities.DynamicWait(driver, Strloader);
					Thread.sleep(7000);
					System.out.println(Activation_no.getText());
					ApplicationUtilities.Fun_PassScreenshot(driver, "Activation done");
					xls.setCellData(Sheet_Name, "Activation_Token No", i, Activation_no.getText());
					Thread.sleep(3000);
					driver.navigate().refresh();
				}
			}

		} catch (Exception e) {
			System.out.println("Issue in getamountvalidate method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	/*
	 * public String Getalertcapture() { String alerttext = null; try { Alert alert
	 * = driver.switchTo().alert(); alerttext = alert.getText();
	 * driver.switchTo().alert().accept(); return alerttext; } catch (Exception e) {
	 * 
	 * return alerttext; } }
	 */

	/*
	 * public boolean HDMI_validate() { boolean HDMI = false; try { boolean cable =
	 * cabletype_dropdown.isEnabled(); if (cable == true) { return true; } else {
	 * return HDMI; }
	 * 
	 * } catch (Exception e) { try { Thread.sleep(3000); xls.setCellData(Sheet_Name,
	 * "Issues/Remarks", 0, "HDMI Dropdown is not displayed"); Thread.sleep(3000);
	 * return HDMI; } catch (Exception e2) {
	 * System.out.println("Issue in HDMI_validate method.");
	 * Reporter.log(e.getLocalizedMessage(), true); }
	 * 
	 * } return HDMI; }
	 */

	public boolean activatebtnvalidate() {
		boolean button = false;
		try {

			boolean btn = Activation_Btn.isDisplayed();

			if (btn == true) {
				return true;
			}

			else {
				return button;
			}
		} catch (Exception e) {
			try {
				Thread.sleep(3000);
				xls.setCellData(Sheet_Name, "Issue", 0, "Activation button is not displayed");
				Thread.sleep(3000);
				return button;
			} catch (Exception e2) {
				System.out.println("Issue in activatebtnvalidate method.");
				Reporter.log(e.getLocalizedMessage(), true);
			}

		}
		return button;

	}

	public void scroll(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

		} catch (Exception e) {
			System.out.println("Issue in scroll method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public String OffervalidateonToken(String Token) {
		String offername = null;
		try {
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameDishtv);
			ResultSet result = Objcon.executeQuery(
					"Select OfferPackageID,* from dishtvindia_srcrm..Complainttrn (nolock)where rowid =" + Token);
			if (result.next()) {
				String offerpackageid = result.getString("OfferPackageID");
				ResultSet result1 = Objcon.executeQuery(
						"Select OfferID,* from dishtvindia..mOfferPackage (nolock) where OfferPackageID = "
								+ offerpackageid);
				if (result1.next()) {
					String offerid = result1.getString("OfferID");
					ResultSet result2 = Objcon
							.executeQuery("Select * from dishtvindia..mOfferType (nolock) where OfferID =" + offerid);
					if (result2.next()) {
						offername = result2.getString("OfferID");
						return offername;
					}
				}

			}
		} catch (Exception e) {
			System.out.println("Issue in OffervalidateonToken method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return offername;
	}

	public String validate_installation_token(String Token) {
		String callrow = null;
		try {
			DatabaseConnection Objcon = new DatabaseConnection(serverNode2, DBuserID, DBPass, DBnameNode2DishtvSRCRM);
			ResultSet result = Objcon.executeQuery(
					"select callmessagerowid,* from complainttrn (nolock) where rowid =" + "'" + Token + "'");
			if (result.next()) {
				callrow = result.getString("CallMessageRowID");
				DatabaseConnection Objcon1 = new DatabaseConnection(serverNode2, DBuserID, DBPass,
						DBnameNode2DishtvSRCRM);
				ResultSet result1 = Objcon1.executeQuery(
						"select * from mcallmessageinstallation (nolock) where CallMessageRowID = " + callrow);
				if (result1.next()) {
					String installationcall = result1.getString("CallMessageRowID");
					return installationcall;
				}
			}

		} catch (Exception e) {
			System.out.println("Issue in validate_installation_token method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return callrow;
	}

	public String getcurrendate() {
		String date = null;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy HHmm");
			LocalDateTime now = LocalDateTime.now();
			date = dtf.format(now);
			System.out.println("Arrival Date - " + date);
			return date;

		} catch (Exception e) {
			System.out.println("Issue in getcurrendate method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return date;
	}

	public void Dealerlogin() {
		try {
			String usertype = PropertiesLib.getPropertyValue("usertypephoenix");
			String userid = PropertiesLib.getPropertyValue("logindealer");
			String password = PropertiesLib.getPropertyValue("passwordphoenix");
			login = new PhoenixLoginPage();
			login.loginPhoenix(usertype, userid, password);
			WaitStatementsLib.pageLoadWait(driver, 180);

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
