package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChrome {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\DISH_Automations\\MyAutomation_Project\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("Opened");
		
		

	}

}
