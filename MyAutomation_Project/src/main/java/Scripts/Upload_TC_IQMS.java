package Scripts;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload_TC_IQMS 
{
	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\DISH_Automations\\MyAutomation_Project\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
	      driver.get("http://qms.dishtv.in/");
	      Thread.sleep(3000);  
		
	      driver.findElement(By.id("tbEmpID")).sendKeys("70104462");
	      Thread.sleep(3000);  
	      
	      driver.findElement(By.id("tbPassword")).sendKeys("abc@12345");
	      Thread.sleep(3000);  
	      
	      driver.findElement(By.name("btnLogin")).click();
	      Thread.sleep(3000);
	      
	      driver.findElement(By.id("ContentPlaceHolder1_gdProjDetails_lbtnSelect_0")).click();
	      Thread.sleep(3000);
	      
	      driver.get("http://qms.dishtv.in/pages/pm/assigned_task_detail.aspx");
	      Thread.sleep(3000);

	      //Search CR number
	      
	      driver.findElement(By.xpath(("//*[@id=\"content_table_filter\"]/label/input"))).sendKeys("149420");
	      Thread.sleep(3000);
	      
	      //Now clicked on the Test case iteration of the Respective CR
	        driver.findElement(By.xpath(("//*[@id=\"content_table\"]/tbody/tr[1]/td[2]/a[2]"))).click();
	     // Thread.sleep(3000);
	      
	      //NOw this Screen will open in New tab, switch to respective tab
	      driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
	      Thread.sleep(3000);
	      
	      //Verify the new tab with 'Add New test Case' button
	      assertTrue(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnAdd\"]/a[1]")).isDisplayed());
	      Thread.sleep(3000);
	      
	      //Click at Upload Testcase button
	      driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnAdd\"]/a[3]")).click();
	      Thread.sleep(3000);
	      
	      
	   // FILE UPLOADING USING SENDKEYS ....
	            
		WebElement browse = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_fucImport\"]"));
		//click on ‘Choose file’ to upload the desired file
	      browse.sendKeys("‪D:\\WatchoGanericTC.xlsx"); //Uploading the file using sendKeys
	      System.out.println("File is Uploaded Successfully");
	      
	      
	      
	      
	      

	}

}
