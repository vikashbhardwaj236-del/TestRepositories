package in.dishtv.Activation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;

public class Installation_page extends BaseLibrary {

	String Str_Focuschange = "//*[@id=\"txtMobile2\"]";
	String Namevalue = "Test";
	String StrCurrentDT = ApplicationUtilities.Fun_DateTime();
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
	@FindBy(id = "txtMobileNo1")
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

	public void Installtion_process(WebDriver driver) {
		try {
			connectiontype.click();
			// driver.findElement(By.id("ddlConnectionType")).click();
			Boxtype.click();
			// driver.findElement(By.id("ddlBoxType")).click();
			new Select(Boxtype).selectByVisibleText("HD");
			// new
			// Select(driver.findElement(By.id("ddlBoxType"))).selectByVisibleText("HD");
			Thread.sleep(3000);
			// driver.findElement(By.id("ddlBoxType")).click();
			Boxtype.click();
			Thread.sleep(3000);
			TxtVoucherno.clear();
			TxtVoucherno.sendKeys("PU0001864642");
			// driver.findElement(By.id("txtVoucherNo")).clear();
			// driver.findElement(By.id("txtVoucherNo")).sendKeys("PU0001864642");
			Thread.sleep(3000);
			Body.click();
			// driver.findElement(By.xpath("//body")).click();
			Thread.sleep(3000);
			TxtVoucherCode.clear();
			TxtVoucherCode.sendKeys("179776400105");
			ApplicationUtilities.Fun_PassScreenshot(driver, "Stock Type");
			// driver.findElement(By.id("txtVoucherCode")).clear();
			// driver.findElement(By.id("txtVoucherCode")).sendKeys("179776400105");
			Thread.sleep(3000);
			Txtspoken.clear();
			Txtspoken.sendKeys(Namevalue + StrCurrentDT);
			// driver.findElement(By.id("txtSpokenWith")).clear();

			// driver.findElement(By.id("txtSpokenWith")).sendKeys("Test");
			Thread.sleep(2000);
			Txtcust.clear();
			Txtcust.sendKeys(Namevalue + StrCurrentDT);
			// driver.findElement(By.id("txtCustomerName")).clear();
			// driver.findElement(By.id("txtCustomerName")).sendKeys("Testone");
			TxtAdd1.clear();
			TxtAdd1.sendKeys(Namevalue + StrCurrentDT);
			// driver.findElement(By.id("txtAddress1")).clear();
			// driver.findElement(By.id("txtAddress1")).sendKeys("House one");
			TxtAdd2.clear();
			TxtAdd2.sendKeys(Namevalue + StrCurrentDT);
			// driver.findElement(By.id("txtAddress2")).clear();
			// driver.findElement(By.id("txtAddress2")).sendKeys("local");

			String mobile = ApplicationUtilities.Dynamic_MobileNo();
			Txtmobile.clear();
			Txtmobile.sendKeys(mobile);
			// driver.findElement(By.id("txtMobileNo")).clear();
			// driver.findElement(By.id("txtMobileNo")).sendKeys("9655987543");
			Thread.sleep(2000);
			Txtmobile1.clear();
			Txtmobile1.sendKeys(mobile);
			// driver.findElement(By.id("txtMobile2")).clear();
			// driver.findElement(By.id("txtMobile2")).sendKeys("9651414141");
			Thread.sleep(2000);
			TxtTel.clear();
			TxtTel.sendKeys(mobile);
			// driver.findElement(By.id("txtTel")).clear();
			// driver.findElement(By.id("txtTel")).sendKeys("0120458966555");
			TxtEmail.clear();
			TxtEmail.sendKeys(ApplicationUtilities.Dynamic_Email());
			// driver.findElement(By.id("txtEmail")).clear();
			// driver.findElement(By.id("txtEmail")).sendKeys("test@gmail.com");
			Thread.sleep(2000);
			TxtPinCode.clear();
			TxtPinCode.sendKeys("221303");
			ApplicationUtilities.Fun_PassScreenshot(driver, "Customer Info");
			// driver.findElement(By.id("txtPinCode")).clear();
			// driver.findElement(By.id("txtPinCode")).sendKeys("221303");
			Thread.sleep(3000);
			// driver.findElement(By.xpath("//body")).click();
			Body.click();
			Thread.sleep(3000);
			Ddl_Offer.click();
			ApplicationUtilities.Fun_PassScreenshot(driver, "Offer Name");
			// driver.findElement(By.id("ddlOffer")).click();
			Thread.sleep(3000);
			new Select(Ddl_Offer).selectByVisibleText("1800 Barebox Trade (HD)");
			// new Select(driver.findElement(By.id("ddlOffer"))).selectByVisibleText("1800
			// Barebox Trade (HD)");
			Ddl_Offer.click();
			// driver.findElement(By.id("ddlOffer")).click();
			Ddl_Language.click();
			ApplicationUtilities.Fun_PassScreenshot(driver, "Language Name");
			// driver.findElement(By.id("ddlLanguageZone")).click();
			Thread.sleep(3000);
			new Select(Ddl_Language).selectByVisibleText("HSM");
			// new
			// Select(driver.findElement(By.id("ddlLanguageZone"))).selectByVisibleText("HSM");
			Ddl_Language.click();
			// driver.findElement(By.id("ddlLanguageZone")).click();
			Ddl_Package.click();
			driver.findElement(By.id("ddlPackage")).click();
			ApplicationUtilities.Fun_PassScreenshot(driver, "Package Name");
			new Select(Ddl_Package).selectByVisibleText("Maxi Sports HD HSM");
			// new Select(driver.findElement(By.id("ddlPackage"))).selectByVisibleText("Maxi
			// Sports HD HSM");
			Thread.sleep(3000);
			Ddl_Package.click();
			// driver.findElement(By.id("ddlPackage")).click();
			Thread.sleep(3000);
			Txt_Remarks.clear();
			// driver.findElement(By.id("txtRemarks")).clear();
			Txt_Remarks.sendKeys(Namevalue + StrCurrentDT + "Remarks");
			// driver.findElement(By.id("txtRemarks")).sendKeys("ok");
			Thread.sleep(3000);
			ApplicationUtilities.Fun_PassScreenshot(driver, "Before Save");
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("btnSaveInstRequest")).click();
			Thread.sleep(2000);
			ApplicationUtilities.Fun_PassScreenshot(driver, "After Save");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
