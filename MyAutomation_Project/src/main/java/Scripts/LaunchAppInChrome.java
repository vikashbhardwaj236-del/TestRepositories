package Scripts;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;

public class LaunchAppInChrome 
{

	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\DISH_Automations\\MyAutomation_Project\\ChromeDriver\\chromedriver.exe");
		
		 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
	      driver.get("http://2www.d2h.com/user-login?returnurl=myaccount");
		
	      driver.findElement(By.id("userinput")).sendKeys("vikash.bhardwaj236@gmail.com");
	      
	      Thread.sleep(3000);  
	      
	      driver.findElement(By.name("pwd")).sendKeys("Password@12345");
	      
	      Thread.sleep(3000);  
	      
	      driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div[2]/div/div[3]/div[1]/input")).click();
	      
	      Thread.sleep(3000);
	      
	    //  driver.close();

	}

}
