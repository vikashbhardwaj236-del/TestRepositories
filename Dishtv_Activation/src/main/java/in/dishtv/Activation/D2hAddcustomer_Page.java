package in.dishtv.Activation;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;
import in.dishtv.library.ExcelUtilities;

public class D2hAddcustomer_Page extends BaseLibrary {

	String StrPathexl = System.getProperty("user.dir") + "//testdata//DishD2h_Phoenix_Data.xlsx";
	ExcelUtilities xls = new ExcelUtilities(StrPathexl);
	String Installation_sheet = "D2hAddCust-N";
	public static String StrDt;
	String strtemp = "";
	String FinalName = "";

	public D2hAddcustomer_Page() {
		super();
		PageFactory.initElements(driver, this);

	}

	// To perform Mouse hover and click
	public void OpenURL() {
		try {
			
			Thread.sleep(3000);
			String menu1 = "Utilities";
			String menu2 = "Add Installation Call (New)";
			driver.get("https://10.65.10.47:45951/");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"txtUserID\"]")).sendKeys("1794");
			driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("DISHtv@123");
			driver.findElement(By.xpath(
					"//*[@id=\"gtco-header\"]/div[2]/div/div/div/div[1]/div/div/div/div/div[6]/div/div/div/button"))
					.click();

			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"BrandChosse\"]/div/center/div/div[2]/div/div[2]/center/a/img"))
					.click();
			Thread.sleep(3000);
			ApplicationUtilities.MouseHovernclick(driver, menu1, menu2);
			ApplicationUtilities.Fun_PassScreenshot(driver, "Open Install.. Page");
			Thread.sleep(3000);
			
		} catch (Exception e) {
			System.out.println("Issue in Open URL.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public void AddCustomer() {
		try {

			int rws = xls.getRowCount(Installation_sheet);
			for (int i = 2; i <= rws; i++) {
				String strrun = xls.getCellData(Installation_sheet, "Run Status", i);
				if (strrun.toUpperCase().equalsIgnoreCase("Yes")) {

					StrDt = ApplicationUtilities.Fun_DateTime();
					Thread.sleep(3000);
					driver.findElement(By.xpath("(//input[@id='btnSearch'])[2]")).click();
					Thread.sleep(6000);
					driver.findElement(By.xpath("//*[@id=\"tblCustomerInfo\"]/tbody/tr[3]/td[1]/label[2]/span"))
							.click();
					// ValidateVoucher();
					driver.findElement(By.id("ddlTitles")).click();
					new Select(driver.findElement(By.id("ddlTitles"))).selectByVisibleText("DR.");
					driver.findElement(By.id("ddlTitles")).click();
					driver.findElement(By.id("txtFirstName")).click();
					driver.findElement(By.id("txtFirstName")).clear();
					Random r = new Random();
					int y = r.nextInt(10000);

					String strv = ApplicationUtilities.Getnofromint(y);
					driver.findElement(By.id("txtFirstName")).sendKeys("FistN" + strv);
					driver.findElement(By.id("txtMiddleName")).clear();
					driver.findElement(By.id("txtMiddleName")).sendKeys("MName");
					driver.findElement(By.id("txtSurname")).clear();
					driver.findElement(By.id("txtSurname")).sendKeys("SName");
					FinalName = "FistN" + strv + "MName" + "SName";
					driver.findElement(By.id("txtCompany")).clear();
					driver.findElement(By.id("txtCompany")).sendKeys("Company " + StrDt);
					driver.findElement(By.id("txtPin")).clear();
					driver.findElement(By.id("txtPin")).sendKeys("122001");
					Thread.sleep(4000);
					driver.findElement(By.id("txtAddress2")).click();
					Thread.sleep(4000);
					driver.findElement(By.xpath("(//a[contains(text(),'Select')])[6]")).click();
					Thread.sleep(4000);
					driver.findElement(By.id("txtLandmark")).click();
					driver.findElement(By.id("txtLandmark")).clear();
					driver.findElement(By.id("txtLandmark")).sendKeys("Landmark " + StrDt);
					driver.findElement(By.id("txtDirections")).clear();
					driver.findElement(By.id("txtDirections")).sendKeys("Direction " + StrDt);
					driver.findElement(By.id("txtAddress1")).click();
					driver.findElement(By.id("txtAddress1")).clear();
					driver.findElement(By.id("txtAddress1")).sendKeys("Address " + StrDt);
					driver.findElement(By.id("txtAddress2")).clear();
					driver.findElement(By.id("txtAddress2")).sendKeys("Address " + StrDt);
					driver.findElement(By.id("txtMobile1")).click();
					driver.findElement(By.id("txtMobile1")).clear();
					driver.findElement(By.id("txtMobile1")).sendKeys(strtemp = ApplicationUtilities.Dynamic_MobileNo());
					driver.findElement(
							By.xpath("//table[@id='tblCustomerInfo']/tbody/tr[9]/td[2]/div/div[2]/label/span")).click();

					driver.findElement(By.id("txtMobile2")).click();
					driver.findElement(By.id("txtMobile2")).clear();
					driver.findElement(By.id("txtMobile2")).sendKeys(strtemp = ApplicationUtilities.Dynamic_MobileNo());
					driver.findElement(By.id("txtAreaCode1")).click();
					driver.findElement(By.id("txtAreaCode1")).clear();
					driver.findElement(By.id("txtAreaCode1")).sendKeys("0120");
					driver.findElement(By.id("txtLandline1")).clear();
					driver.findElement(By.id("txtLandline1")).sendKeys("2345555559");
					driver.findElement(By.id("txtAreaCode2")).clear();
					driver.findElement(By.id("txtAreaCode2")).sendKeys("0120");
					driver.findElement(By.id("txtLandline2")).clear();
					driver.findElement(By.id("txtLandline2")).sendKeys("3434343433");
					driver.findElement(By.id("txtEmail")).clear();
					driver.findElement(By.id("txtEmail")).sendKeys(strtemp = ApplicationUtilities.Dynamic_Email());
					driver.findElement(By.id("ddlLanguages")).click();
					new Select(driver.findElement(By.id("ddlLanguages"))).selectByVisibleText("Hindi");
					driver.findElement(By.id("ddlLanguages")).click();
					driver.findElement(By.xpath("//table[@id='tblCustomerInfo']/tbody/tr[10]")).click();
					driver.findElement(By.id("txtBirthDate")).clear();
					driver.findElement(By.id("txtBirthDate")).sendKeys("1981-06-08");
					driver.findElement(By.id("txtCustRefCode")).click();
					driver.findElement(By.id("txtCustRefCode")).clear();
					driver.findElement(By.id("txtCustRefCode")).sendKeys("Refno " + StrDt);
					driver.findElement(By.id("txtDealerName")).clear();
					driver.findElement(By.id("txtDealerName")).sendKeys("Dealername " + StrDt);
					driver.findElement(By.id("txtDealerContact")).clear();
					driver.findElement(By.id("txtDealerContact"))
							.sendKeys(strtemp = ApplicationUtilities.Dynamic_MobileNo());
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@value='Save']")).click();
					Thread.sleep(5000);
					ApplicationUtilities.acceptAlert(driver);
					Thread.sleep(50000);
					getcustID(i, FinalName);
					driver.navigate().refresh();
				}

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void getcustID(int i, String strname) {
		try {
			strtemp = driver.findElement(By.xpath("//*[@id=\"trCustomerId\"]")).getText();
			// System.out.println(strtemp);
			Pattern pattern = Pattern.compile("\\w+([0-9]+)\\w+([0-9]+)");
			Matcher matcher = pattern.matcher(strtemp);
			for (int k = 1; k == 1; k++) {
				matcher.find(1);
			}
			System.out.println("Customer ID - " + matcher.group());
			xls.setCellData(Installation_sheet, "Customer ID", i, matcher.group());
			Thread.sleep(5000);
			// strtemp = strtemp.substring(27, strtemp.length());
			System.out.println("Customer Name - " + strname);
			xls.setCellData(Installation_sheet, "Customer Name", i, strname);
			Thread.sleep(4000);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void ValidateVoucher() {
		try {
			Thread.sleep(3000);

			driver.findElement(By.id("txtVoucherPin")).click();
			driver.findElement(By.id("txtVoucherPin")).clear();
			driver.findElement(By.id("txtVoucherPin")).sendKeys("PU0001838458");
			driver.findElement(By.id("txtVoucherSerial")).click();
			driver.findElement(By.id("txtVoucherSerial")).clear();
			driver.findElement(By.id("txtVoucherSerial")).sendKeys("333096744258");
			driver.findElement(By.xpath("//input[@value='Validate']")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
