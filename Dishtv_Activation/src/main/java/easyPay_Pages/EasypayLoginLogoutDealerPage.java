package easyPay_Pages;

import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;

import in.dishtv.library.WaitStatementsLib;

public class EasypayLoginLogoutDealerPage extends BaseLibrary {

	String Strloader = "//*[@id='imgAJAXLoader']";	
	WaitStatementsLib wait = new WaitStatementsLib();
	SoftAssert SoftA = new SoftAssert();
	String strhere = "here";
	public EasypayLoginLogoutDealerPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	// -- Login Xpath
	@FindBy(xpath = "//*[@id='form1']/div[4]/div/div/h2")
	private WebElement loginpageverify;
	@FindBy(xpath = "//*[@id='CphPageMiddle_txtUserID']")
	private WebElement loginuserid;
	@FindBy(xpath = "//*[@id='CphPageMiddle_txtPassword']")
	private WebElement loginpassword;
	@FindBy(name = "ctl00$CphPageMiddle$ctl00")
	private WebElement btnlogin;
	@FindBy(xpath = "//*[@id='lblPageTitle']")
	private WebElement Dashbaordpageverify;
	// -- Logout Xpath
	@FindBy(xpath = "//*[@id='RadMenu']/ul/li[7]/a/span")
	private WebElement logout;
	@FindBy(linkText = "Here")
	private WebElement ClickHere;
	@FindBy(xpath = "//*[@id='lblMesg']")
	private WebElement AlertArea;
	@FindBy(xpath = "//*[@id='Img1']")
	private WebElement AlertClose;
	@FindBy(xpath = "//*[@id='lblUserTitle']")
	private WebElement LoginId;
	@FindBy(xpath = "//*[@id='CphPageMiddle_btnCloseTradeMsg']")
	private WebElement Info_closebtn;
	@FindBy(xpath = "//*[@id=\"form1\"]/div[5]/div[2]/div/div/a")
	private WebElement clickHere;
	@FindBy(xpath = "//*[@id=\"ucHeader_DivTopHeader\"]/div[1]/a/img")
	private WebElement PageTitle;
	@FindBy(xpath = "//*[@id=\"CphPageMiddle_lnkForgotPassword\"]")
	private WebElement Forgotpass;
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Button'])[1]/following::td[5]")
	private WebElement ForGotPassLabel;
	@FindBy(id = "CphPageMiddle_btnContinue")
	private WebElement Continuebtn;
	@FindBy(id = "CphPageMiddle_BtnBack2")
	private WebElement Backbtn;
	@FindBy(linkText = "here")
	private WebElement Here;

	String strforgot = "Forgot Password";

	public WebElement getLoginuserid() {
		return loginuserid;
	}

	public WebElement ClickHereafterlogout() {
		return ClickHere;
	}

	public WebElement getLoginpassword() {
		return loginpassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}

	public WebElement getSigninpage() {
		return loginpageverify;
	}

	public WebElement getLogout() {
		return logout;
	}

	// public Web

	public void logineasypay(String username, String password) {
		try {
			
			
			//wait.waitForVisibilityOfElement(driver, loginuserid, 2000);
			loginuserid.clear();
			loginpassword.clear();
			loginuserid.sendKeys(username);
			loginpassword.sendKeys(password);
			//wait.waitForVisibilityOfElement(driver, btnlogin, 2000);
			//ApplicationUtilities.Fun_PassScreenshot(driver, "login");
			//ApplicationUtilities.click(btnlogin);
			driver.findElement(By.name("ctl00$CphPageMiddle$ctl01")).click();
			ApplicationUtilities.Fun_PassScreenshot(driver, "login");
		} catch (Exception ex) {

			Reporter.log(ex.getLocalizedMessage(), true);
		}
	}

	public void Info_close_btn() {
		try {

			Thread.sleep(2000);
			ApplicationUtilities.DynamicWait(driver, Strloader);
			Info_closebtn.click();

		} catch (Exception e) {
			System.out.println("Issue in easy pay info close button method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public void logouteasypay() {

		if (getLogout().isDisplayed()) {
			ApplicationUtilities.click(logout);
			ApplicationUtilities.DynamicWait(driver, strhere);
			Here.click();

		}

	}

	/*public void easyloginBlankValidation(String username, String password) {
		try {
			Thread.sleep(5000);
			loginuserid.clear();
			loginpassword.clear();
			username = "";
			password = "";
			String Strmsg = "";
			loginuserid.sendKeys(username);
			loginpassword.sendKeys(password);
			ApplicationUtilities.click(btnlogin);
			ApplicationUtilities.Fun_PassScreenshot(driver, "Login_Blank_Validation");
			Strmsg = ApplicationUtilities.getalerttext(driver, AlertArea);
			ApplicationUtilities.AlertClose(driver, AlertClose);
			System.out.println(Strmsg);
		} catch (Exception ex) {
			Reporter.log(ex.getLocalizedMessage(), true);
		}
	}

	public void easyloginValidationonlyUserID(String username, String password) {
		try {
			loginuserid.clear();
			loginpassword.clear();
			username = "";
			String Strmsg = "";
			loginuserid.sendKeys(username);
			loginpassword.sendKeys(password);
			ApplicationUtilities.click(btnlogin);
			Strmsg = ApplicationUtilities.getalerttext(driver, AlertArea);
			ApplicationUtilities.AlertClose(driver, AlertClose);
			System.out.println(Strmsg);
		} catch (Exception ex) {
			Reporter.log(ex.getLocalizedMessage(), true);
		}
	}

	public void EasyloginValidationonlyPassword(String username, String password) {
		try {
			loginuserid.clear();
			loginpassword.clear();
			password = "";
			String Strmsg = "";
			loginuserid.clear();
			loginuserid.sendKeys(username);
			loginpassword.sendKeys(password);
			ApplicationUtilities.click(btnlogin);
			Strmsg = ApplicationUtilities.getalerttext(driver, AlertArea);
			ApplicationUtilities.AlertClose(driver, AlertClose);
			System.out.println(Strmsg);
		} catch (Exception ex) {
			Reporter.log(ex.getLocalizedMessage(), true);
		}
	}

	public void Forgotpassword() {
		try {
			Thread.sleep(3000);
			Forgotpass.click();
			ApplicationUtilities.Fun_PassScreenshot(driver, strforgot);
			SoftA.assertEquals(ForGotPassLabel.getText(), strforgot);
			Continuebtn.click();
			ApplicationUtilities.Fun_PassScreenshot(driver, strforgot);
			ApplicationUtilities.AlertClose(driver, AlertClose);
			Backbtn.click();
			ApplicationUtilities.AlertClose(driver, AlertClose);

		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			ApplicationUtilities.Fun_FailScreenshot(driver, "Exception in Forgotpassword");
		}
	}

	public void EasyloginInvalidUserID(String username, String password) {
		try {
			loginuserid.clear();
			loginpassword.clear();
			username = "585566";
			String Strmsg = "";
			loginuserid.sendKeys(username);
			loginpassword.sendKeys(password);
			ApplicationUtilities.click(btnlogin);
			Strmsg = ApplicationUtilities.getalerttext(driver, AlertArea);

			ApplicationUtilities.AlertClose(driver, AlertClose);
			System.out.println(Strmsg);
		} catch (Exception ex) {
			Reporter.log(ex.getLocalizedMessage(), true);
		}
	}

	public void EasyloginInvalidPassword(String username, String password) {
		try {
			loginuserid.clear();
			loginpassword.clear();
			password = "abc123";
			String Strmsg = "";
			loginuserid.sendKeys(username);
			loginpassword.sendKeys(password);
			ApplicationUtilities.click(btnlogin);
			Strmsg = ApplicationUtilities.getalerttext(driver, AlertArea);
			ApplicationUtilities.AlertClose(driver, AlertClose);
			System.out.println(Strmsg);
		} catch (Exception ex) {
			Reporter.log(ex.getLocalizedMessage(), true);
		}
	}

	// Click on click here link and validate the page title
	public void ClickHere() {
		try {
			isClickable(btnlogin);
			Thread.sleep(3000);
			clickHere.click();
			String str = PageTitle.getAttribute("alt");
			Assert.assertEquals(str, "DTH India, Digital TV, DTH Services| Dish TV");
			driver.navigate().back();

		} catch (Exception ex) {
			System.out.println("Exception in click here link." + ex.getMessage());
			Reporter.log(ex.getLocalizedMessage(), true);
		}

	}

	public boolean isClickable(WebElement webel) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60000);
			wait.until(ExpectedConditions.elementToBeClickable(webel));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void easyPay_Login_DB_value_Validation() {
		try {
			DatabaseConnection Objcon = new DatabaseConnection(serverNode3, DBuserID, DBPass, DBname3Geas);
			ResultSet result = Objcon.executeQuery("select * from mLogin(nolock) where loginid="
					+ PropertiesLib.getPropertyValue("userideasypaydealer"));
			if (result.next()) {
				for (int i = 1; i <= result.getRow(); i++) {

					String StrloginID = LoginId.getText();
					StrloginID = StrloginID.substring(3, 12);
					Assert.assertEquals("001" + result.getString("LoginID"), StrloginID);
				}
				result.close();
			}
		} catch (Exception ex) {
			System.out.println("Exception in database value verification!");
		}

	}*/

}
