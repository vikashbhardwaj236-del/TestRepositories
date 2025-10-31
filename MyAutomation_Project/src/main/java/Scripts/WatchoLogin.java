package Scripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class WatchoLogin {
	static String mobileno;
    static String otp;
    static ResultSet rs;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		
		
      Connection con = DriverManager.getConnection("jdbc:sqlserver://DevDishV2n1Ln.dishtvindia-new.in:21443;database=SMSdth2003", "Azureadmin", "dish@1234567");
      System.out.println("SQL Connection Successfully Established.");
      Statement smt = con.createStatement();
      
  	  // To Call Watcho OTP SQL Query
	  ResultSet otp = smt.executeQuery("Select top 5 * from .OTTGenrateOTP(NOLOCK) where Mobileno='8826132288'");
	  while (otp.next()) 
	  {
	   String WatchoOTP = otp.getString("OTP");
	   String Mobileno = otp.getString("Mobileno");
	   System.out.println("Latest OTP Sent against Mobile NO: "+Mobileno+"Is - "+WatchoOTP);
	  }  

	}

}
