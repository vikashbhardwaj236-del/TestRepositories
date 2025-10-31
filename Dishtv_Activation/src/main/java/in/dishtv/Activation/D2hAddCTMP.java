package in.dishtv.Activation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import in.dishtv.library.ApplicationUtilities;

public class D2hAddCTMP {

	public static String StrDt;
	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Automation\\Activation_New\\Dishtv_Activation\\DishTV\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("http://10.65.10.47:43765/activation/d2h/index?Key=Tyki3vLU7mCpVriZVeDppDXzHdk8BMupeqfngjCbjDeq2evtPDzKPhr6jH0MlxZvyPGLXBbBboZ79EhCPz1HlQ%3d%3d");
		AddCustomer();

	}
	
	
	

	public static void AddCustomer() {
		try {
			String strtemp="";
			StrDt=Fun_Time();
			StrDt=StrDt.replace(":", "");
			StrDt=StrDt.replace("/", "");
			StrDt=StrDt.replace(" ", "");
			 Thread.sleep(3000);
			    driver.findElement(By.xpath("(//input[@id='btnSearch'])[2]")).click();
			    //Thread.sleep(4000);
			    //ApplicationUtilities.DynamicWait(driver, "/html/body/div[22]/div/div/div/div/p");
			   // Wait();
			    driver.findElement(By.xpath("//*[@id=\"tblCustomerInfo\"]/tbody/tr[3]/td[1]/label[2]/span")).click();
			    //ValidateVoucher();		    
			    driver.findElement(By.id("ddlTitles")).click();
			    new Select(driver.findElement(By.id("ddlTitles"))).selectByVisibleText("DR.");
			    driver.findElement(By.id("ddlTitles")).click();
			    driver.findElement(By.id("txtFirstName")).click();
			    driver.findElement(By.id("txtFirstName")).clear();
			    driver.findElement(By.id("txtFirstName")).sendKeys("FirstName"+StrDt);
			    driver.findElement(By.id("txtMiddleName")).clear();
			    driver.findElement(By.id("txtMiddleName")).sendKeys("MiddleName"+StrDt);
			    driver.findElement(By.id("txtSurname")).clear();
			    driver.findElement(By.id("txtSurname")).sendKeys("Surname " + StrDt);
			    driver.findElement(By.id("txtCompany")).clear();
			    driver.findElement(By.id("txtCompany")).sendKeys("Company -" + StrDt);
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
			    driver.findElement(By.id("txtDirections")).sendKeys("Direction "+ StrDt);
			    driver.findElement(By.id("txtAddress1")).click();
			    driver.findElement(By.id("txtAddress1")).clear();
			    driver.findElement(By.id("txtAddress1")).sendKeys("Address 1" + StrDt);
			    driver.findElement(By.id("txtAddress2")).clear();
			    driver.findElement(By.id("txtAddress2")).sendKeys("Addrres 2" + StrDt);
			    driver.findElement(By.id("txtMobile1")).click();
			    driver.findElement(By.id("txtMobile1")).clear();
			    driver.findElement(By.id("txtMobile1")).sendKeys(strtemp=ApplicationUtilities.Dynamic_MobileNo());
			    driver.findElement(By.xpath("//table[@id='tblCustomerInfo']/tbody/tr[9]/td[2]")).click();
			    driver.findElement(By.xpath("//table[@id='tblCustomerInfo']/tbody/tr[9]/td[2]/label/span")).click();
			    driver.findElement(By.id("txtMobile2")).click();
			    driver.findElement(By.id("txtMobile2")).clear();		
			    driver.findElement(By.id("txtMobile2")).sendKeys(strtemp=ApplicationUtilities.Dynamic_MobileNo());
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
			    driver.findElement(By.id("txtEmail")).sendKeys(strtemp=ApplicationUtilities.Dynamic_Email());
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
			    driver.findElement(By.id("txtDealerName")).sendKeys("Dealername " + StrDt );
			    driver.findElement(By.id("txtDealerContact")).clear();
			    driver.findElement(By.id("txtDealerContact")).sendKeys(strtemp=ApplicationUtilities.Dynamic_MobileNo());
				  Thread.sleep(3000);
			   driver.findElement(By.xpath("//input[@value='Save']")).click();
			   Thread.sleep(5000);
			  ApplicationUtilities.acceptAlert(driver);
			  Wait();
			  //ApplicationUtilities.DynamicWait(driver, "/html/body/div[22]/div/div/div");
			  //ApplicationUtilities.DynamicWait(driver, "/html/body/div[19]/div");
			  Thread.sleep(9000);
			  strtemp= driver.findElement(By.xpath("//*[@id=\"tblCustomerInfo\"]/thead/tr/th/h6[1]")).getText();
			  System.out.println(strtemp);
			  
			//driver.quit();

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	
	public static void Wait() {
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 15);
			String expectedValue = "Please wait while we are processing your request...";
			String actualValue = driver.findElement(By.xpath("/html/body/div[22]/div/div/div/div/p")).getText().toLowerCase();
			//wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("path"), actualValue));
			//wait.until(ExpectedConditions.textToBePresentInElementLocated(actualValue, expectedValue));
			
			
			//WebDriverWait wait = new WebDriverWait(driver, 15);
			//wait.until((ExpectedConditions) driver -> driver.findElement(By.id("elementId")).getAttribute("value").length() != 0);
			
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[22]/div/div/div/div/p")));
			//WebElement myDynamicElement = (new WebDriverWait(driver, 10))
			//		.until(ExpectedConditions.presenceOfElementLocated(By.id("/html/body/div[22]/div/div/div/div/p")));
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	

	public static String Fun_Time() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		StrDt = dateFormat.format(date);
		//StrDt = StrDt.substring(10, 13);
		return StrDt;
	}

	public static String Fun_DateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		StrDt = dateFormat.format(date);
		return StrDt;
	}
	
	public static void ValidateVoucher ()
	{
		try
		{
			Thread.sleep(3000);
			
		    driver.findElement(By.id("txtVoucherPin")).click();
		    driver.findElement(By.id("txtVoucherPin")).clear();
			driver.findElement(By.id("txtVoucherPin")).sendKeys("PU0001838458");
		    driver.findElement(By.id("txtVoucherSerial")).click();
		    driver.findElement(By.id("txtVoucherSerial")).clear();
		    driver.findElement(By.id("txtVoucherSerial")).sendKeys("333096744258");
		    driver.findElement(By.xpath("//input[@value='Validate']")).click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
