package in.dishtv.Activation;

import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.dishtv.genericpages.BasePage;
import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.DatabaseConnection;
import in.dishtv.library.WaitStatementsLib;

public class PhoenixLoginPage extends BasePage {

	public PhoenixLoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ddlUserType")
	private WebElement usertypephoenix;
	@FindBy(id = "txtUserID")
	private WebElement useridphoenix;
	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	private WebElement passwordphoenix;
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement btnsignin;
	@FindBy(xpath = "//img[@src='../../Images/logo.png']")
	private WebElement logoPhoenixLoginPage;
	public static String OTP = "";

	public WebElement getUsertypephoenix() {
		return usertypephoenix;
	}

	public WebElement getUseridphoenix() {
		return useridphoenix;
	}

	public WebElement getPasswordphoenix() {
		return passwordphoenix;
	}

	public WebElement getBtnsignin() {
		return btnsignin;
	}

	public WebElement getLogoPhoenixLoginPage() {
		return logoPhoenixLoginPage;
	}

	public void loginPhoenix(String usertype, String userid, String password) {
		try {
			ApplicationUtilities.dropdownTextEqualIgnoreCase(usertypephoenix, usertype);
			useridphoenix.sendKeys(userid);
			passwordphoenix.sendKeys(password);
			Thread.sleep(2000);
			// ApplicationUtilities.click(btnsignin);
			driver.findElement(By.xpath(
					"//*[@id=\"gtco-header\"]/div[2]/div/div/div/div[1]/div/div/div/div/div[6]/div/div/div/button"))
					.click();
			String stro = Getotp("1794");
			driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(stro);
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//*[@id=\"gtco-header\"]/div[2]/div/div/div/div[1]/div/div/div/div/div[5]/div/div[2]/div/button"))
					.click();

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static String Getotp(String sotp) {
		try {

			DatabaseConnection Objcon = new DatabaseConnection("10.95.21.13", "Renaissance", "R$n@lss*nCE", "D2H2019");
			ResultSet result1 = Objcon.executeQuery(
					"select  top 1  otp  from tOTPDetails(nolock) where UserId=" + sotp + " order by OtpId desc");
						while (result1.next()) {
				OTP = result1.getString("otp");

				return OTP;

			}

			Objcon.con.close();
		} catch (Exception ex) {

			System.out.println("Issue in connection");
			ex.printStackTrace();
		}
		return OTP;
	}

	public void logoutPhoenix() {
		try {
			WaitStatementsLib.waitForSeconds(driver, 20);
			getWelcomeIconPhoenix().click();
			WaitStatementsLib.waitForSeconds(driver, 10);
			getLogoutPhoenix().click();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
