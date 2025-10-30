package Day0_PersonalTasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;



public class LaunchChromeBrowser {
public static void main(String[] args) throws InterruptedException {

//System.setProperty("Webdriver.chrome.driver", "Chrome driver Exe path")
	
//ChromeDriver driver = new ChromeDriver();
 WebDriver driver = new ChromeDriver();
	
//Firefox browser
// WebDriver driver = new FirefoxDriver();
 
//Internet Explorer browser
 //WebDriver driver = new InternetExplorerDriver();
 
//Internet Explorer browser
//WebDriver driver = new EdgeDriver();


driver.manage().window().maximize();
driver.get("https://qms.dishtv.in/");
Thread.sleep(3000);
//driver.getTitle();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());

//Using CCS Selector - Tagname.classname
//Using CCS Selector - Tagname#id
//Using CCS Selector - Tagname[Attribute='value']
//Using Xpath - //Tagname[@Attribute='value']
//Another way of writing xpath = //Tagname[contains(@attribute, 'value')] - //button[contains(@class, 'Submit')]

driver.findElement(By.cssSelector("input#tbEmpID")).sendKeys("70104462");
Thread.sleep(2000);
driver.findElement(By.cssSelector("input#tbPassword")).sendKeys("abc@12345");
Thread.sleep(2000);
driver.findElement(By.cssSelector("input[value='Sign In']")).click();
Thread.sleep(2000);
String username = driver.findElement(By.cssSelector("label[style='vertical-align: middle']")).getText();
System.out.println(username);
Assert.assertEquals(username, "Welcome Vikas Bhardwaj");
Thread.sleep(1000);
System.out.println("TEST CASE - PASS");



//driver.close();
//driver.quit();

}
}
