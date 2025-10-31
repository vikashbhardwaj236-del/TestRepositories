package in.dishtv.Activation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;

public class Testlogin extends BaseLibrary{

	public Testlogin() {
		super();
		PageFactory.initElements(driver, this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login();
	}
	
	public static void login()
	{
		try {
			driver.get("http://beta.phoenix.dishtvbiz.in/");
		    driver.findElement(By.id("txtUserID")).click();
		    driver.findElement(By.id("txtUserID")).clear();
		    driver.findElement(By.id("txtUserID")).sendKeys("171748");
		    driver.findElement(By.id("txtPassword")).click();
		    driver.findElement(By.id("txtPassword")).clear();
		    driver.findElement(By.id("txtPassword")).sendKeys("DISHtv@123");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::button[1]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='PackageChange'])[1]/preceding::b[1]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ALL#0#REL#7#D2H'])[1]/following::td[6]")).click();
		    driver.findElement(By.linkText("Logout")).click();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
