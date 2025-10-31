package in.dishtv.Activation;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import in.dishtv.library.BaseLibrary;

import static org.testng.Assert.*;
import org.openqa.selenium.*;


public class D2hdealerlink extends BaseLibrary {
  //private WebDriver driver;
  //private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

 // @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
   // baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test(priority = 1, enabled = true)
  public void testUntitledTestCase() throws Exception {
    driver.get("http://10.95.21.15:5051/Default.aspx");
    driver.findElement(By.id("CphPageMiddle_txtUserID")).click();
    driver.findElement(By.id("CphPageMiddle_txtUserID")).clear();
    driver.findElement(By.id("CphPageMiddle_txtUserID")).sendKeys("1017");
    driver.findElement(By.id("CphPageMiddle_txtPassword")).clear();
    driver.findElement(By.id("CphPageMiddle_txtPassword")).sendKeys("dish@123");
    driver.findElement(By.name("ctl00$CphPageMiddle$ctl00")).click();
    driver.findElement(By.xpath("//div[@id='RadMenu']/ul/li[7]/a/span")).click();
    driver.findElement(By.linkText("here")).click();
    driver.findElement(By.id("CphPageMiddle_txtUserID")).click();
    driver.findElement(By.id("CphPageMiddle_txtUserID")).clear();
    driver.findElement(By.id("CphPageMiddle_txtUserID")).sendKeys("1017");
    driver.findElement(By.id("CphPageMiddle_txtPassword")).clear();
    driver.findElement(By.id("CphPageMiddle_txtPassword")).sendKeys("dish@123");
    driver.findElement(By.id("CphPageMiddle_txtPassword")).click();
    driver.findElement(By.id("CphPageMiddle_txtPassword")).clear();
    driver.findElement(By.id("CphPageMiddle_txtPassword")).sendKeys("dish@1234");
    driver.findElement(By.name("ctl00$CphPageMiddle$ctl00")).click();
    driver.findElement(By.id("Img1")).click();
    driver.findElement(By.id("CphPageMiddle_txtUserID")).click();
    driver.findElement(By.id("CphPageMiddle_txtPassword")).clear();
    driver.findElement(By.id("CphPageMiddle_txtPassword")).sendKeys("dish@123");
    driver.findElement(By.id("CphPageMiddle_txtPassword")).click();
    driver.findElement(By.id("CphPageMiddle_tdLogin")).click();
    driver.findElement(By.name("ctl00$CphPageMiddle$ctl00")).click();
    driver.findElement(By.xpath("//div[@id='RadMenu']/ul/li/a/span")).click();
    driver.findElement(By.xpath("//div[@id='RadMenu']/ul/li[3]/div/ul/li/a/span")).click();
    driver.findElement(By.xpath("//div[@id='RadMenu']/ul/li[7]/a/span")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  /*private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }*/

  /*private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }*/
}
