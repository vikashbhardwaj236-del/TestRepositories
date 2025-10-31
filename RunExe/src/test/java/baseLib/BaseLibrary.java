package baseLib;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BaseLibrary {
	static public WebDriver driver;
	
	

	public static void initializeApplication(String url) {
		driver.navigate().to(url);
		String CurrentURL="https://beta2-inbound.dishtvbiz.in/LandingPage.aspx";
	
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

	
	@AfterSuite
	public void TC_FileRename()
	{
		try
		{
		
		driver.quit();
		}
		catch(Exception ex)
		{
			System.out.println("Exception in title verification" + ex.getMessage());
			Reporter.log(ex.getLocalizedMessage(), true);
		}
	}
	// Method used for Extended report
	public static String getScreenshot(){
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String Path = System.getProperty("user.dir")+"/screenshots/"+"/failedCases/"+System.currentTimeMillis()+ ".png";
        File destination = new File(Path);
        try{
             FileUtils.copyFile(src, destination);
             
        }catch(IOException e){
        System.out.println("capture failed" + e.getMessage());
        }
        return Path;
        }

}
