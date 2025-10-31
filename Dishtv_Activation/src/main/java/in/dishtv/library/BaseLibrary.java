package in.dishtv.library;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class BaseLibrary {
	static public WebDriver driver;
	static public String serverNode1 = "10.95.21.11";
	static public String serverNode2 = "10.95.21.12";
	static public String serverNode3 = "10.95.21.13";
	static public String DBuserID = "Renaissance";
	static public String DBPass = "Rd!$h25.two";
	static public String DBname3Geas = "GlobalEAS";
	static public String DBnameNode2DishtvIndia = "DISHTVINDIA";
	static public String DBnameDishtv = "DishtvIndia";
	static public String DBuserIDNode1 = "RenaissanceZT";
	static public String DBPassNode1 = "##Ren@iss@nceZT$";
	static public String DBnameNode2DishtvSRCRM = "DISHTVINDIA_SRCRM";
	static public String DBnameNode2DishtvOBCRM = "DISHTVINDIA_OBCRM";
	static public String DBnameNode1SMSDTH2003 = "SMSDTH2003";

	String StrPathexl = System.getProperty("user.dir") + "\\testdata\\DishD2h_Phoenix_Two.xlsx";
	ExcelUtilities xls = new ExcelUtilities(StrPathexl);

	public static void initializeApplication(String url) {
		driver.navigate().to(url);
		int time = Integer.parseInt(PropertiesLib.getPropertyValue("pageloadtime"));
		WaitStatementsLib.pageLoadWait(driver, time);
	}

	@BeforeSuite
	@Parameters("browser")
	public void launchBrowser(String browsername) {
		ArrayList<String> al;
		switch (browsername) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			al = new ArrayList<>();
			al.add("--start-maximized");
			al.add("disable-infobars");
			co.addArguments(al);
			driver = new ChromeDriver(co);
			Reporter.log("Chrome browser has been launched successfully.", true);			
			break;

		case "ie":
			System.setProperty("webdriver.chrome.driver", "");
			driver = new InternetExplorerDriver();
			Reporter.log("Internet Explorer browser has been launched successfully.", true);

		default:
			Reporter.log("Given browser does not exits...Please provide a valid browser name.", true);
			break;
		}
	}

	@AfterMethod
	public void resultAnalysis(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		if (result.isSuccess()) {
			Reporter.log(methodname + " has been passed successfully.", true);
			int i = xls.getCellRowNum("Login", "Method_Name", methodname);
			xls.setCellData("Login", "Status", i, "Pass");

		} else if (result.getStatus() == ITestResult.FAILURE) {
			ScreenshotsLib.getScreenshot(driver, "failedCases", methodname);
			Reporter.log(methodname + " has been failed. Check log and screenshots in respective folderes.", true);
			int i = xls.getCellRowNum("Login", "Method_Name", methodname);
			xls.setCellData("Login", "Status", i, "Fail");
		} else if (result.getStatus() == ITestResult.SKIP) {
			Reporter.log(methodname + " has been skipped. Check log and screenshots in respective folderes.", true);
			int i = xls.getCellRowNum("Login", "Method_Name", methodname);
			xls.setCellData("Login", "Status", i, "Skip");
		}

	}

	@AfterSuite
	public void sendamil() {
		//EmailUtilities objemail = new EmailUtilities();
	//	objemail.Send_email();
	}

	public void tearDown() {

		driver.quit();
		Reporter.log("Current browser instance has been closed.", true);

	}

	public static String getScreenshot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Path = System.getProperty("user.dir") + "/screenshots/" + "/failedCases/" + System.currentTimeMillis()
				+ ".png";
		File destination = new File(Path);
		try {
			Files.copy(src, destination);

		} catch (IOException e) {
			System.out.println("capture failed" + e.getMessage());
		}
		return Path;
	}
}
