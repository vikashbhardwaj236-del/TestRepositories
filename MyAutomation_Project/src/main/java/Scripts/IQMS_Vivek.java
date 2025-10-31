
 package Scripts; 
import static org.junit.Assert.fail;
import java.util.ArrayList; 
import java.util.List; 
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*; 
import org.openqa.selenium.*; 
import org.openqa.selenium.chrome.ChromeDriver;
 
 public class IQMS_Vivek 
 {
     static WebDriver driver;
     private boolean acceptNextAlert = true;
     private static StringBuffer verificationErrors = new StringBuffer();
     private static JavascriptExecutor js;
     static String StrPath = "C:\\DISH_Automations\\MyAutomation_Project\\ExcelUtilities\\Testing Template.xlsx";
     public static ExcelUtilities Exls = new ExcelUtilities(StrPath);
     public static String Strsheet = "Sheet1";

     @BeforeClass(alwaysRun = true)
     public static void setUp() throws Exception {

                     //System.setProperty("webdriver.chrome.driver", "C:\\IQMS\\chromedriver.exe");
                     System.setProperty("webdriver.chrome.driver", "C:\\DISH_Automations\\MyAutomation_Project\\ChromeDriver\\chromedriver.exe");
                     driver = new ChromeDriver();
                     driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                     js = (JavascriptExecutor) driver;
                     driver.manage().window().maximize();
     }

     public static void main(String[] args) {
                     try {
                                     setUp();
                                     Login();
                                     SelectTeam();
                                     Nevigation();
                                     Search();
                                     AddnewTCClick();
                                     //tearDown();

                     } catch (Exception e) {
                                     System.out.println("Issue in login !");
                     }

     }
     public static void SelectTeam() {
                     try {

                                     driver.findElement(By.xpath("//*[@id=\"ddlFunction_chzn\"]/a/div/b")).click();
                                     Thread.sleep(2000);
                                     driver.findElement(By.xpath("//*[@id=\"ddlFunction_chzn\"]/a/span")).click();              
                                     driver.findElement(By.xpath("//*[@id=\"ddlRole_chzn\"]")).click();
                                     //Thread.sleep(2000);
                                     driver.findElement(By.xpath("//*[@id=\"ddlRole_chzn\"]/a/span")).click();
                     
                                     
                                     
                     } catch (Exception e) {
                                     System.out.println("Issue In selectTeam !");
                     }
     }
     
     public static void Login() {
                     try {

                                     driver.get("http://qms.dishtv.in/");
                                     driver.findElement(By.id("tbEmpID")).click();
                                     driver.findElement(By.id("tbEmpID")).clear();
                                     driver.findElement(By.id("tbEmpID")).sendKeys(Exls.getCellData(Strsheet, "ID", 2));
                                     driver.findElement(By.id("tbPassword")).clear();
                                     driver.findElement(By.id("tbPassword")).sendKeys(Exls.getCellData(Strsheet, "Pass", 2));
                                     Thread.sleep(2000);
                                     driver.findElement(By.id("btnLogin")).click();

                     } catch (Exception e) {
                                     System.out.println("Issue in login !");
                     }
     }

     public static void Nevigation() {
                     try {                                        
                                     Thread.sleep(2000);
                                     driver.findElement(By.xpath("//*[@id=\"ddlFunction_chzn\"]/a/span")).click();
                                     Thread.sleep(1000);
                                     driver.findElement(By.xpath("//*[@id=\"ddlFunction_chzn_o_1\"]")).click();
                                     Thread.sleep(1000);
                                     driver.findElement(By.xpath("//*[@id=\"ddlRole_chzn\"]/a/span")).click();
                                     Thread.sleep(1000);
                                     driver.findElement(By.xpath("//*[@id=\"ddlRole_chzn_o_1\"]")).click();                                            
                                     driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).click();
                                     Thread.sleep(1000);
                                     driver.findElement(By.id("ContentPlaceHolder1_gdProjDetails_lbtnSelect_0")).click();
                                     Thread.sleep(2000);
                                     driver.get("http://qms.dishtv.in/pages/pm/assigned_task_detail.aspx");
                                     Thread.sleep(2000);
                                     // driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[1]/a")).click();
                                     // Thread.sleep(3000);
                                     // driver.findElement(By.linkText("Assigned Task Grid View")).click();
                                     // Thread.sleep(4000);
                     } catch (Exception e) {
                                     System.out.println("Issue in Nevigation !");
                     }
     }

     public static void Search() {
                     try {

                                     driver.findElement(By.xpath("//*[@id=\"content_table_filter\"]/label/input"))
                                                                     .sendKeys(Exls.getCellData(Strsheet, "CR", 2));

                     } catch (Exception e) {
                                     System.out.println("Issue in Search !");
                     }
     }

     public static void AddnewTCClick() {
                     try {

                                     Thread.sleep(2000);
                                     String strlink = driver.findElement(By.xpath("//*[@id=\"content_table\"]/tbody/tr[1]/td[2]")).getText();
                                     if (strlink.equalsIgnoreCase("Click  | Testcase")) {
                                                     // boolean bolTC = isElementPresent(By.linkText("Testcase"));
                                                     // if (bolTC == true) {
                                                     driver.findElement(By.linkText("Testcase")).click();
                                                     Move_to_newtab();
                                                     String strcong = Exls.getCellData(Strsheet, "Configure", 2);
                                                     if (strcong.toUpperCase().equalsIgnoreCase("Add")) {
                                                                     driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnAdd\"]/a[1]")).click();
                                                                     driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));

                                                                     AddTC();
                                                     } else if (strcong.toUpperCase().equalsIgnoreCase("Delete")) {
                                                                     DeleteTC();

                                                     } else if (strcong.toUpperCase().equalsIgnoreCase("Pass")) {
                                                                     PassTC();

                                                     }
                                     } else if (strlink.equalsIgnoreCase("Click  | Testcase Execution")) {
                                                     PassTC();

                                     }
                                     // }

                     } catch (Exception e) {
                                     System.out.println("Issue in Addnew TC Click !");
                     }
     }

     
     public static void Move_to_newtab()
     {
                     try {
                     ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
                     driver.switchTo().window(tabs2.get(1));
                     }
                     catch (Exception e) {
                                     // TODO: handle exception
                     }
                     
                     
     }
     
     public static void Click_on_Testcase_Execution()
     {
                     try {
                                     driver.findElement(By.linkText("Testcase Execution")).click();
                     }
                     catch (Exception e) {
                                     // TODO: handle exception
                     }
                     
                     
     }
     
     public static void selectDDP()
     {
                     try
                     {
                                     driver.findElement(By.xpath("//*[@id=\"content_table_length\"]/label/select")).click();
                                     Thread.sleep(1000);
                                     driver.findElement(By.xpath("//*[@id=\"content_table_length\"]/label/select/option[4]")).click();
                                     Thread.sleep(1000);
                                     driver.findElement(By.xpath("//*[@id=\"content_table_length\"]/label/select")).click();
                                     Thread.sleep(1000);
                     }
                     catch (Exception e) {
                                     // TODO: handle exception
                     }
                     
     }
     public static void PassTC() {
                     try {
                                     Click_on_Testcase_Execution();                                               
                                     Move_to_newtab();
                                     selectDDP();
                                     //String strcong = Exls.getCellData(Strsheet, "Configure", 2);
                                     List<WebElement>textDemo= driver.findElements(By.xpath("//*[contains(text(),'Execute')]"));
                                     //System.out.println("Number of web elements: " +textDemo.size());

                                     List<WebElement> rows = driver.findElements(By.tagName("tr"));
                                                                     String str="//*[@id=\"content_table\"]/tbody/tr[";
                                                                     String str1="]/td[10]/a";
                                                                     int k=0;
                                     for (WebElement e : rows) {
                                                     Thread.sleep(1000);
                                                     k++;
                                                     str=str+k+str1;
                                                     
                                                     
                                                     driver.findElement(By.xpath(str)).click();
                                                     
                                                     //driver.findElement(By.xpath("//*[@id=\"content_table\"]/tbody/tr[1]/td[10]/a")).click();
                                                     //Thread.sleep(1000);
                                                     
                                                     Thread.sleep(1000);
                                                     

                                     }

                     } catch (Exception e) {
                                     System.out.println(e);
                                     System.out.println("Issue in DeleteTC!");
                     }
     }

     public static void DeleteTC() {
                     try {
                                     //System.out.println("test");
                                     driver.findElement(By.xpath("//*[@id=\"content_table_last\"]")).click();
                                     String strvalue=driver.findElement(By.xpath("//*[@id=\"content_table\"]/tbody/tr/td[1]")).getText();
                                     int ivalue= Integer.parseInt(strvalue);
                                     //List<WebElement> rows = driver.findElements(By.tagName("tr"));
                                     //int count = rows.size() - 1;
                                     //int count = rows.size() - 1;
                                     //for (WebElement e : rows) {
                                     for (int i=1;i<=ivalue;i++)
                                     {
                                                     ApplicationUtilities.Scroll_Page_To_Bottom(driver);
                                                     Thread.sleep(2000);
                                                     driver.findElement(By.xpath("//*[@id=\"content_table\"]/tbody/tr[1]/td[9]/a[2]/img")).click();                                                             
                                                     ApplicationUtilities.acceptAlert(driver);
                                                     Thread.sleep(2000);
                                                     

                                     }

                     } catch (Exception e) {
                                     System.out.println(e);
                                     System.out.println("Issue in DeleteTC!");
                     }
     }

     public static void AddTC() {
                     try {

                                     Thread.sleep(2000);
                                     int icount = Exls.getRowCount(Strsheet);

                                     for (int i = 2; i <= icount; i++) {
                                                     String Strstatus = Exls.getCellData(Strsheet, "Run Status", i);
                                                     if (Strstatus.toUpperCase().equalsIgnoreCase("YES")) {
                                                                     driver.findElement(By.xpath("//*[@id=\"ddlPriority_chzn\"]")).click();
                                                                     Thread.sleep(2000);
                                                                     driver.findElement(By.xpath("//*[@id=\"ddlPriority_chzn_o_1\"]")).click();
                                                                     driver.findElement(By.xpath("//*[@id=\"tbApp\"]")).clear();
                                                                     driver.findElement(By.xpath("//*[@id=\"tbApp\"]"))
                                                                     .sendKeys(Exls.getCellData(Strsheet, "App", i));
                                                                     driver.findElement(By.xpath("//*[@id=\"tbModule\"]"))
                                                                                                     .sendKeys(Exls.getCellData(Strsheet, "Module/Sub Module", i));

                                                                     driver.findElement(By.xpath("//*[@id=\"tbSummary\"]"))
                                                                                                     .sendKeys(Exls.getCellData(Strsheet, "Test case Description", i));

                                                                     driver.findElement(By.xpath("//*[@id=\"tbExpacted\"]"))
                                                                                                     .sendKeys(Exls.getCellData(Strsheet, "Expected", i));

                                                                     driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnSubmit\"]")).click();
                                                                     Thread.sleep(1000);
                                                     }
                                     }

                     } catch (Exception e) {
                                     System.out.println("Issue in ADD TC !");
                     }
     }

     public static void tearDown() throws Exception {
                     try {
                     driver.quit();
                     String verificationErrorString = verificationErrors.toString();
                     if (!"".equals(verificationErrorString)) {
                                     fail(verificationErrorString);
                     }
                     }
                     catch(Exception ex)
                     {
                                     System.out.println(ex);
                     }
     }

     private static boolean isElementPresent(By by) {
                     try {
                                     driver.findElement(by);
                                     return true;
                     } catch (NoSuchElementException e) {
                                     return false;
                     }
     }

     private static boolean isAlertPresent() {
                     try {
                                     driver.switchTo().alert();
                                     return true;
                     } catch (NoAlertPresentException e) {
                                     return false;
                     }
     }

     private String closeAlertAndGetItsText() {
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
     }
	 
	 
	 
	 
	 
 }