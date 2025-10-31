package Scripts;
//import com.watcho.utils.Utils;
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

public class Abhishek_Dubey_Code {

    static String mobileno;
    static String otp;
    static ResultSet rs;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {


        /* String host = "DevDishV2n1Ln.dishtvindia-new.in";

          String port = "21443";*/
       //DevDishV2n1Ln.dishtvindia-new.in:21443

        Connection con = DriverManager.getConnection("jdbc:sqlserver://DevDishV2n1Ln.dishtvindia-new.in:21443;database=SMSdth2003", "AbhishekD_70104616", "Welcome@12345678");

        System.out.println("Connected to SQL Server Successfully");

        Statement s = con.createStatement();

//        ResultSet rs = s.executeQuery("select *from OTTCouponPkgSchemeMapping(nolock) where couponcode ='TESTASHU53'");

//        rs = s.executeQuery("Select top 10 * from SMSdth2003..OTTGenrateOTP (NOLOCK) ORDER BY 1 DESC");

        /*rs = s.executeQuery("Select top 1 * from SMSdth2003..OTTGenrateOTP (NOLOCK) where Mobileno='6574879845'");

        while (rs.next()) {


            mobileno = rs.getString("Mobileno");
            otp = rs.getString("OTP");


            System.out.println("This is number " + mobileno + " And OTP " + otp);

        }*/

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhishek.dubey\\IdeaProjects\\watcho\\drivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().deleteAllCookies();

        driver.manage().window().maximize();

        driver.get("https://dishtv-uatweb.revlet.net/");

        driver.findElement(By.xpath("//a[text()='SIGN IN']")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("mobile")).sendKeys("9794979387");
        Thread.sleep(2000);


        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement popup =  driver.findElement(By.xpath("//div[contains(text(), 'Would you like to receive Push Notifications?')]"));
            wait.until(ExpectedConditions.visibilityOf(popup));

            if (popup.isDisplayed()) {

                driver.findElement(By.xpath("//button[contains(text(), 'No thanks')]")).click();
                System.out.println("Push notification pop-up handled successfully.");
            }
        } catch (Exception e) {
            System.out.println("Push notification pop-up did not appear, continuing execution.");
        }




        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div//button[text()='Verify'])[1]")).click();

        Thread.sleep(4000);
        rs = s.executeQuery("Select top 1 * from SMSdth2003..OTTGenrateOTP (NOLOCK) where Mobileno='9794979387'");

        while (rs.next()) {


//            mobileno = rs.getString("Mobileno");
               otp = rs.getString("OTP");


//            System.out.println("This is number " + mobileno + " And OTP " + otp);

        }


        Thread.sleep(2000);
        driver.findElement(By.name("otp")).sendKeys(otp);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div//button[text()='Continue']")).click();
        Thread.sleep(2000);


        System.out.println(driver.findElement(By.xpath("//div//h1[text()='Name Your Profile']")).getText());

        WebElement enterNameField = driver.findElement(By.xpath("//div//input[@id='name']"));

        enterNameField.sendKeys("Abhishek");


        Thread.sleep(2000);

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement popup =  driver.findElement(By.xpath("//div[contains(text(), 'Would you like to receive Push Notifications?')]"));
            wait.until(ExpectedConditions.visibilityOf(popup));

            if (popup.isDisplayed()) {

                driver.findElement(By.xpath("//button[contains(text(), 'No thanks')]")).click();
                System.out.println("Push notification pop-up handled successfully.");
            }
        } catch (Exception e) {
            System.out.println("Push notification pop-up did not appear, continuing execution.");
        }

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div//button[text()='Continue']")).click();


        Thread.sleep(2000);
        driver.findElement(By.xpath("//div//img[@alt='Abhishek']")).click();

        System.out.println("Login Successfully....");

        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//div//span//img[@src='https://d2ivesio5kogrp.cloudfront.net/static/watcho/images/profile-pic1.svg']"))).build().perform();


        driver.findElement(By.xpath("//div[text()='Sign Out']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div//button[text()='Sign Out']")).click();

        System.out.println("Logout Successfully");
    }
}

