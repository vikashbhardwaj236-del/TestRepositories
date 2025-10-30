package Day0_PersonalTasks;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Delete_TC 
{
	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException 
	{
		
	//	System.setProperty("webdriver.chrome.driver","C:\\DISH_Automations\\MyAutomation_Project\\ChromeDriver\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
	      driver.get("http://qms.dishtv.in/");
	      
	      Thread.sleep(3000);  
		
	      driver.findElement(By.id("tbEmpID")).sendKeys("th340855");
	      
	      Thread.sleep(3000);  
	      
	      driver.findElement(By.id("tbPassword")).sendKeys("12Nayasa123456789#");
	      
	      Thread.sleep(3000);  
	      
	      driver.findElement(By.name("btnLogin")).click();
	      
	      Thread.sleep(3000);
	      
	      driver.findElement(By.id("ContentPlaceHolder1_gdProjDetails_lbtnSelect_0")).click();
	      Thread.sleep(3000);
	      
	      driver.get("http://qms.dishtv.in/pages/pm/assigned_task_detail.aspx");
	      
	      Thread.sleep(3000);

	      // Search CR number
	      
	      driver.findElement(By.xpath(("//*[@id=\"content_table_filter\"]/label/input"))).sendKeys("157073");
	      
	      Thread.sleep(3000);
	      
	      // Now clicked on the Test case iteration of the Respective CR
	      
	      //driver.findElement(By.xpath(("//*[@id=\"content_table\"]/tbody/tr[1]/td[2]/a[2]"))).click();
	      driver.findElement(By.xpath(("//*[@id=\"content_table\"]/tbody/tr[4]/td[2]/a[2]"))).click();
	     // Thread.sleep(3000);
	      
	      // NOw this Screen will open in New tab, switch to respective tab
	      driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
	      Thread.sleep(3000);
	      
	      // verify the new tab with 'Add New test Case' button
	      assertTrue(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnAdd\"]/a[1]")).isDisplayed());
	      Thread.sleep(3000);
	      
	      // Click on Delete button for very first test case
	    // driver.findElement(By.xpath("//*[@id=\"content_table\"]/tbody/tr[1]/td[9]/a[2]/img")).click();
	     // Thread.sleep(3000);
	      
	      for (int i = 0; i < 600; i++) 
	      {
	    	  driver.findElement(By.xpath("//*[@id=\"content_table\"]/tbody/tr[1]/td[9]/a[2]/img")).click();
		      Thread.sleep(3000);
		    // String GetAlertText = driver.switchTo().alert().getText();
		    // System.out.println("Pop up text is : " + GetAlertText);
		      
		     // driver.switchTo().alert().dismiss();
		      driver.switchTo().alert().accept();
		      Thread.sleep(2000);
		      driver.navigate().refresh();
		      Thread.sleep(2000);
		      System.out.println("Testcase: " + i +" is deleted.");

	}

}
}
