package in.dishtv.Activation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.dishtv.genericpages.BasePage;
import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.WaitStatementsLib;

public class D2h_PhoenixLoginPage extends BasePage {

	static Boolean bol = false;

	public D2h_PhoenixLoginPage() {
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
			for (int i = 1; i <= 5000; i++) {
				ApplicationUtilities.dropdownTextEqualIgnoreCase(usertypephoenix, usertype);
				System.out.println(
						"Iteration -" + i + " - Browser Launch Successfully. - " + ApplicationUtilities.Fun_DateTime());
				// ApplicationUtilities.DynamicWait(driver, "//*[@id=\"txtUserID\"]");
				useridphoenix.sendKeys(userid);
				passwordphoenix.sendKeys(password);
				System.out.println("Click on Submit button. - " + ApplicationUtilities.Fun_DateTime());
				ApplicationUtilities.click(btnsignin);
				System.out.println("Login Successfully. - " + ApplicationUtilities.Fun_DateTime());
				ApplicationUtilities.Fun_PassScreenshot(driver, "Login_Pass");
				driver.findElement(By.xpath(
						"(.//*[normalize-space(text()) and normalize-space(.)='PackageChange'])[1]/preceding::b[1]"))
						.click();
				System.out.println("Clicked on Dashboard. - " + ApplicationUtilities.Fun_DateTime());
				ApplicationUtilities.DynamicWait(driver, "//*[@id=\"ServiceDashboardD2HPendingTickets\"]/div/img");
				validatePendingTickets();
				/*if (bol = true) {
					MoveToWorkorderDetailsPage();
				}*/
				logoutPhoenix();
			}
		} catch (Exception ex) {
			System.out.println(ex);
			ApplicationUtilities.Fun_FailScreenshot(driver, "login_issue");
			// loginPhoenix("Trade Partner",);
		}
	}

	public static void validatePendingTickets() {
		try {
			String str = driver.findElement(By.xpath("//*[@id=\"d2hTable\"]/tbody/tr/td/b")).getText();
			if (str.contains("Due to - No Data Found.")) {
				System.out.println("No Data Found. " + ApplicationUtilities.Fun_DateTime());
				ApplicationUtilities.Fun_FailScreenshot(driver, "No Data Found");

			} else if (str.contains("Total")) {
				System.out.println("Data Found. " + ApplicationUtilities.Fun_DateTime());
				ApplicationUtilities.Fun_PassScreenshot(driver, "Data Found");
				bol = true;
			} else {
				System.out.println("oracal Issue " + ApplicationUtilities.Fun_DateTime());
				ApplicationUtilities.Fun_FailScreenshot(driver, "oracal Issue");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void logoutPhoenix() {
		try {
			WaitStatementsLib.waitForSeconds(driver, 20);
			System.out.println("Clicked on Logout. - " + ApplicationUtilities.Fun_DateTime());
			// driver.findElement(By.xpath("(.//*[normalize-space(text()) and
			// normalize-space(.)='Hi,'])[1]/following::span[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[10]/a/span/b/span")).click();
			// ApplicationUtilities.MouseHovernclick(driver, Strhoverobj, Strobjclick);
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("Logout Successfully - " + ApplicationUtilities.Fun_DateTime());
			ApplicationUtilities.Fun_PassScreenshot(driver, "Logout");

		} catch (Exception ex) {
			System.out.println(ex);
			ApplicationUtilities.Fun_FailScreenshot(driver, "Logout");
		}
	}

	public void MoveToWorkorderDetailsPage() {
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='ALL#0#REL#0#D2H'])[2]/following::td[3]"))
					.click();
			ApplicationUtilities.DynamicWait(driver, "//*[@id=\"disableProcess\"]/div/img");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Appointment Date'])[4]/following::a[1]"))
					.click();
			Thread.sleep(2000);
			ApplicationUtilities.DynamicWait(driver, "//*[@id=\"disableProcess\"]/div/img");
			ApplicationUtilities.Fun_PassScreenshot(driver, "Work_Order_page");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='btnClose']/i")).click();

		} catch (Exception ex) {
			//System.out.println(ex);
			ApplicationUtilities.Fun_FailScreenshot(driver, "Logout");
		}
	}

}
