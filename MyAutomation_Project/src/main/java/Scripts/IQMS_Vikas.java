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

public class IQMS_Vikas
{
	 
	static WebDriver driver;
    private boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();
    private static JavascriptExecutor js;
    static String StrPath = "C:\\DISH_Automations\\MyAutomation_Project\\ExcelUtilities\\Testing Template_Vikas.xlsx";
    //static String StrPath = "C:\\DISH_Automations\\MyAutomation_Project\\ExcelUtilities\\Testing Template.xlsx";
    public static ExcelUtilities Exls = new ExcelUtilities(StrPath);
    public static String Strsheet = "Sheet1";
	private static String Webelement;
    
    @BeforeClass(alwaysRun = true)
    public static void setUp() throws Exception {

        // System.setProperty("webdriver.chrome.driver", "C:\\IQMS\\chromedriver.exe");
         System.setProperty("webdriver.chrome.driver", "C:\\DISH_Automations\\MyAutomation_Project\\ChromeDriver\\chromedriver.exe");
              
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
         js = (JavascriptExecutor) driver;
         driver.manage().window().maximize();
         System.out.println("IQMS Opened Sucessfully");
}


	public static void main(String[] args) 
	{
		 try 
		 {
			 setUp();
			 Login();
			 SelectTeam_Vikas();
			 Nevigation_AssignedTaskDetails();
			 Search_CR();
			 Execute_TestCase();
			 
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Issue In- Login");
			 
		 }
	}
	
	public static void Login() {
        try {

                        driver.get("http://qms.dishtv.in/");
                        Thread.sleep(2000);
                        driver.findElement(By.id("tbEmpID")).click();
                        driver.findElement(By.id("tbEmpID")).clear();
                        driver.findElement(By.id("tbEmpID")).sendKeys(Exls.getCellData(Strsheet, "ID", 2));
                        driver.findElement(By.id("tbPassword")).clear();
                        driver.findElement(By.id("tbPassword")).sendKeys(Exls.getCellData(Strsheet, "Pass", 2));
                        Thread.sleep(2000);
                        driver.findElement(By.id("btnLogin")).click();
                        Thread.sleep(2000);
                        System.out.println("User Logged-In Successfully");

        } catch (Exception e) {
                        System.out.println("Issue in login !");
        }
                   
}
	
	public static void SelectTeam_Vikas()
	{
		try {
			
			//Thread.sleep(2000);
			driver.findElement(By.id("ContentPlaceHolder1_gdProjDetails_lbtnSelect_0")).click();
		      Thread.sleep(2000);
		      System.out.println("Team Selected Successfully");
		      Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[1]/ul/li/a"));
            Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println("Issue in 'SelectTeam_Vikas!'");
			
		}
	}

	
	public static void Nevigation_AssignedTaskDetails() 
	{
         try {                                        
                       
        	 // Go to 'Assigned Task Details' screen
              Thread.sleep(3000);
    	      driver.get("http://qms.dishtv.in/pages/pm/assigned_task_detail.aspx");
    	      Thread.sleep(3000);
    	      System.out.println("User Succesfully Navigated at 'Assigned Task Details' Dashboard.");
                         
         } catch (Exception e) {
                         System.out.println("Issue in Nevigation at 'Assigned Task Details' Dashboard !");
         }
}
	
	 
	public static void Search_CR()
	{
		
		try
		{
			
			//Search CR number
		      driver.findElement(By.xpath(("//*[@id=\"content_table_filter\"]/label/input"))).sendKeys("151293");
		      Thread.sleep(2000);
		      
		      //Now clicked on the 'TestCase' iteration of the Respective CR for Test case module
		      // driver.findElement(By.xpath(("//*[@id=\"content_table\"]/tbody/tr[2]/td[2]/a[2]"))).click();
		      // Thread.sleep(2000);
		      
		     //Now clicked on the 'TestCase Execution' iteration of the Respective CR for Test case module
		       driver.findElement(By.xpath(("//*[@id=\"content_table\"]/tbody/tr[2]/td[2]/a[2]"))).click();
		       Thread.sleep(2000);
		       
		      //Now this Screen will open in New tab, switch to respective tab
		      driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		      Thread.sleep(2000);
		      
		      //verify the new tab with 'Add New test Case' button
		      assertTrue(driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[1]/a")).isDisplayed());
		      Thread.sleep(2000);
		}
		catch (Exception e) 
		 {
                  System.out.println("Issue in Nevigation at 'CR_Search_Open_Testcase_Execution_Iteration' !");
         }
		
	}
	 
	 
	 public static void Execute_TestCase()
	 {
		 
		 
		 try
		 {
			 //Click at Execute hyperlink
			 driver.findElement(By.xpath("//*[@id=\"content_table\"]/tbody/tr[1]/td[10]/a")).click();
			 Thread.sleep(2000);
			 System.out.println("'Test Case Execution' window popup opend successfully.");
			 
			 // Switch to 'Test Case Execution' window popup
			// driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
			 
		      Thread.sleep(2000);
		     String TCExecution = driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div/div[1]/p")).getText();
		      System.out.println(TCExecution);
		      Thread.sleep(2000);
			 
			 
		 }
		 
			catch (Exception e) 
		 {
                  System.out.println("Getting some issue to execute Test Cases");
         }
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
