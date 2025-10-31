package RunExe.RunExe.Phoenix;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;
import baseLib.ApplicationUtilities;
import baseLib.DatabaseConnection;
import baseLib.ExcelUtilities;
import org.openqa.selenium.WebDriver;

public class Dishtv_Recharge {

	static WebDriver driver;
	public static ExcelUtilities Exls = new ExcelUtilities("E:\\RunExe\\EPRSDishtv\\EPRSDISH.xlsx");
	public static String Strsheet = "VC";
	public static String VC = "";
	public static String AMT = "";
	public static String Strpath = "E:\\RunExe\\EPRSDishtv\\SS\\";
	public static String strYesvalue = "";
	public static int j = 2;

	public static void main(String[] args) {

		Openbrowser();
		Loginonpage();
		Easypayrecharge();

	}

	public static void Openbrowser() {
		try {

			System.setProperty("webdriver.chrome.driver", "D:\\RunExe\\Complaintlog\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://beta1-www.easy-pay.in/");
			driver.manage().window().maximize();
			ApplicationUtilities.Printscreen(Strpath, "Browser open");
		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Login Fail");
			System.out.println(ex);

		}
	}

	public static void Loginonpage() {
		try {

			driver.findElement(By.id("CphPageMiddle_txtUserID")).sendKeys("112237");
			driver.findElement(By.id("CphPageMiddle_txtPassword")).sendKeys("dish@123");
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//*[@id=\"CphPageMiddle_tdLogin\"]/table/tbody/tr[5]/td/table/tbody/tr/td[2]/input"))
					.click();
			waitForPageLoad(driver);
			Thread.sleep(1000);
			ApplicationUtilities.MouseHovernclick(driver, "Sales", "Customer Payment");
			waitForPageLoad(driver);
			Thread.sleep(1000);
		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Login Fail");
			System.out.println(ex);
		}
	}

	public static void Easypayrecharge() {
		try {
			int icount = Exls.getRowCount(Strsheet);
			for (int i = 2; i <= icount; i++) {
				String strstatus = Exls.getCellData(Strsheet, "RunStatus", i);
				if (strstatus.toUpperCase().equalsIgnoreCase("YES")) {
					VC = Exls.getCellData(Strsheet, "VC no", i);
					AMT = Exls.getCellData(Strsheet, "Amount", i);
					driver.findElement(By.xpath("//*[@id=\"CphPageMiddle_txtPaymentTo\"]")).sendKeys(VC);
					Thread.sleep(3000);		
					waitForPageLoad(driver);
					driver.findElement(By.xpath("//*[@id=\"CphPageMiddle_txtAmount\"]")).click();
					waitForPageLoad(driver);
					Thread.sleep(3000);					
					driver.findElement(By.xpath("//*[@id=\"CphPageMiddle_btnClosePopup\"]")).click();
					waitForPageLoad(driver);
					RechargeAmtClick();
					finalclick(i);
				}
			}

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Issue in record processing");
			System.out.println(ex);
		}
	}

	public static void RechargeAmtClick() {
		try {		
			driver.findElement(By.xpath("//*[@id=\"CphPageMiddle_txtAmount\"]")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"CphPageMiddle_txtAmount\"]")).sendKeys(AMT);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"CphPageMiddle_btnSubmit\"]")).click();
			Thread.sleep(2000);
			waitForPageLoad(driver);

		} catch (Exception ex) {
			ApplicationUtilities.Fun_FailScreenshot(driver, "Login Fail");
			System.out.println(ex);
		}
	}

	public static void finalclick(int i) {
		try {
			driver.findElement(By.xpath("//*[@id=\"CphPageMiddle_btnSubmit\"]")).click();
			Thread.sleep(3000);
			waitForPageLoad(driver);
			String strtrnsid = driver.findElement(By.xpath("//*[@id=\"lblMesg\"]")).getText();
			int len = strtrnsid.length();
			if (len == 0) {
				driver.findElement(By.xpath("//*[@id=\"CphPageMiddle_btnSubmit\"]")).click();
			}
			Thread.sleep(3000);
			strtrnsid = driver.findElement(By.xpath("//*[@id=\"lblMesg\"]")).getText();
			System.out.println(strtrnsid);
			Thread.sleep(3000);
			Exls.setCellData(Strsheet, "Trans No", i, strtrnsid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"pnlErrorMessage\"]/table/tbody/tr[1]/td[2]/img")).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void waitForPageLoad(WebDriver driver) {

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

}
