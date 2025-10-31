package in.dishtv.Activation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import in.dishtv.genericpages.BasePage;
import in.dishtv.library.WaitStatementsLib;

public class PhoenixLogoutPage extends BasePage {

	public PhoenixLogoutPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ddlUserType")
	private WebElement usertypephoenix;
	@FindBy(id = "txtUserID")
	private WebElement useridphoenix;
	@FindBy(xpath = "//*[@id=\"Password\"]")
	private WebElement passwordphoenix;
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement btnsignin;
	@FindBy(xpath = "//*[@id=\"navbar-collapse-1\"]/ul/li[8]/a")
	private WebElement logoPhoenixLoginPage;

	@FindBy(linkText = "Logout")
	private WebElement Logoutlink;
	
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

	public void logoutPhoenix() {
		try {
			//WaitStatementsLib.waitForSeconds(driver, 20);
			//getWelcomeIconPhoenix().click();
			Thread.sleep(3000);
			WaitStatementsLib.waitForSeconds(driver, 10);
			//getLogoutPhoenix().click();
			driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[8]/a")).click();
			Thread.sleep(3000);
		    driver.findElement(By.linkText("Logout")).click();
		    Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
