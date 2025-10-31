package Scripts;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;

public class DatePicker {
	
	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\DISH_Automations\\MyAutomation_Project\\ChromeDriver\\chromedriver.exe");
		
		 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
	      driver.get("https://beta2-inbound.dishtvbiz.in/Default.aspx");
	      Thread.sleep(3000);  
		
	      driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserID")).sendKeys("123456");
	      
	      Thread.sleep(3000);  
	      
	      driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys("azure@123");
	      
	      Thread.sleep(3000);  
	      
	      driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin")).click();
	      
	      Thread.sleep(3000);
	      System.out.println("Logged-In at IBCRM Sucessfully.");
	      
	      driver.get("https://beta2-inbound.dishtvbiz.in/pages/customerservice/CustomerServiceMain.aspx");
	      Thread.sleep(6000);  
	      driver.findElement(By.id("btnCallRec")).click();
	      Thread.sleep(3000);  
	      System.out.println("Moved at Call Rec.");
	     String frameTitle =  driver.findElement(By.xpath("//*[@id=\"lblTableHeaderName\"]")).getText();
	     //System.out.println(frameTitle);
	     Thread.sleep(3000); 	     
	     //switch To IFrame using Web Element
         WebElement iframe = driver.findElement(By.id("IframPopUP"));
         //Switch to the frame
         driver.switchTo().frame(iframe);
         Thread.sleep(3000);  
         System.out.println("Switched at IFrame");
	     String iframeTitle =  driver.findElement(By.xpath("//*[@id=\"tcCallRecording_tabAddCall_rpbAlacarteList\"]/ul/li/a/span/span[2]")).getText();
	    // System.out.println(iframeTitle);
	     Thread.sleep(3000);  
	     driver.findElement(By.id("tcCallRecording_tabAddCall_rpbAlacarteList_i0_txtappointmentslotDate")).click();
         Thread.sleep(3000);  
         System.out.println("Entered in Appointment Slots:");
         Thread.sleep(3000); 
			
         WebElement mainMenu = driver.findElement(By.id("tcCallRecording_tabAddCall_rpbAlacarteList_i0_txtappointmentslotDate"));

         Actions actions = new Actions(driver);
         actions.moveToElement(mainMenu);
         WebElement subMenu = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/table/tbody/tr[6]/td[1]"));
         actions.moveToElement(subMenu);
         actions.click().build().perform();
         
         Thread.sleep(2000); 
         System.out.println("Appointment date selected successfully.");
         Thread.sleep(1000);  
	     driver.findElement(By.id("tcCallRecording_tabAddCall_rpbAlacarteList_i0_txtappointmentslotDate")).click();
	     Thread.sleep(1000);  
	     driver.findElement(By.name("tcCallRecording$tabAddCall$rpbAlacarteList$i0$btnAdd123")).click();
	     System.out.println("Test Case Executed - PASS" + "  -->  " + "JAY HIND JAY BHARAT");
	     driver.quit();
	     

	}

}
