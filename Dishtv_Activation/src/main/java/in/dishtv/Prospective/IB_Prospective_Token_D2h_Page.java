/*
 * package in.dishtv.Prospective;
 * 
 * import java.sql.ResultSet; import java.util.List; import
 * java.util.concurrent.CopyOnWriteArrayList; import org.openqa.selenium.Alert;
 * import org.openqa.selenium.By; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.Select; import
 * org.openqa.selenium.support.ui.WebDriverWait; import org.testng.Reporter;
 * import in.dishtv.IB_CRM.IB_CRM_PageNavigation_Page; import
 * in.dishtv.IB_CRM_Dishtv.*; import in.dishtv.library.ApplicationUtilities;
 * import in.dishtv.library.BaseLibrary; import
 * in.dishtv.library.DatabaseConnection; import
 * in.dishtv.library.ExcelUtilities;
 * 
 *//**
	 * @author Vivek Kumar
	 *
	 *//*
		 * public class IB_Prospective_Token_D2h_Page extends BaseLibrary { String
		 * StrPath = System.getProperty("user.dir") +
		 * "//testdata//DishD2h_Phoenix_Prospective.xlsx"; ExcelUtilities xls = new
		 * ExcelUtilities(StrPath); String SheetName = "D2h_Prospective"; public String
		 * strtoken = ""; public String strticket = ""; public String scallcategory =
		 * ""; public String strwait =
		 * "//*[@id=\"UpdateProgress2\"]/span/center/table/tbody/tr/td[2]/strong/h2";
		 * public long ltoken = 0; public long lcallcategory = 0;
		 * 
		 * @FindBy(xpath = "//*[@id=\"imgBtnMore\"]") private WebElement More;
		 * 
		 * @FindBy(xpath = "//*[@id=\"imgbtnPayLater\"]") private WebElement Paylater;
		 * 
		 * @FindBy(xpath = "//*[@id='ddlSearchType']") private WebElement Ddp_VCNo;
		 * 
		 * @FindBy(id = "imgBtTechCall") private WebElement techcall;
		 * 
		 * @FindBy(xpath = "//*[@id=\"txtPhoneComp\"]") private WebElement complmobile;
		 * 
		 * @FindBy(xpath = "//*[@id=\"txtAlternateNo\"]") private WebElement
		 * complaltmobile;
		 * 
		 * @FindBy(xpath = "//*[@id=\"btnSaveComplaint\"]") private WebElement
		 * complSave;
		 * 
		 * @FindBy(xpath = "//*[@id=\"lnkErrorMessage\"]") private WebElement
		 * complalclose;
		 * 
		 * public IB_Prospective_Token_D2h_Page() { super();
		 * PageFactory.initElements(driver, this); }
		 * 
		 * // Verify page navigation public void Pagenavigation() { try {
		 * IB_CRM_PageNavigation_Page objCRMNavigation = new
		 * IB_CRM_PageNavigation_Page(); objCRMNavigation.IB_CRM_Page_Navigation();
		 * 
		 * } catch (Exception ex) { System.out.println("Exception in page Navigation" +
		 * ex.getMessage()); Reporter.log(ex.getLocalizedMessage(), true); } }
		 * 
		 * // Verify page navigation public void IB_Open_propsective_Token_Page() { try
		 * {
		 * driver.findElement(By.xpath("//*[@id=\"ImgbtnProspectiveSubsDtls\"]")).click(
		 * );
		 * 
		 * } catch (Exception ex) { System.out.println("Exception in page Navigation" +
		 * ex.getMessage()); Reporter.log(ex.getLocalizedMessage(), true); } }
		 * 
		 * // Verify page navigation public void IB_propsective_Token_Page_close() { try
		 * { driver.switchTo().defaultContent();
		 * driver.findElement(By.xpath("//*[@id=\"imgClose\"]")).click();
		 * 
		 * } catch (Exception ex) { System.out.println("Exception in page Navigation" +
		 * ex.getMessage()); Reporter.log(ex.getLocalizedMessage(), true); } }
		 * 
		 * // Verify page Generate public void Generate_propsective_Token_Page() { try {
		 * 
		 * int rws = xls.getRowCount(SheetName); for (int i = 2; i <= rws; i++) { String
		 * strrun = xls.getCellData(SheetName, 0, i); if
		 * (strrun.toUpperCase().equalsIgnoreCase("Yes")) {
		 * IB_Open_propsective_Token_Page(); driver.switchTo().frame("IframPopUP");
		 * driver.findElement(By.id("txtCallerName")).clear();
		 * driver.findElement(By.id("txtCallerName")) .sendKeys("Caller Name -" +
		 * ApplicationUtilities.Dynamic_MobileNo());
		 * driver.findElement(By.id("txtMobileNO")).clear();
		 * driver.findElement(By.id("txtMobileNO")).sendKeys(ApplicationUtilities.
		 * Dynamic_MobileNo()); driver.findElement(By.id("txtAlternateNo")).clear();
		 * driver.findElement(By.id("txtAlternateNo")).sendKeys(ApplicationUtilities.
		 * Dynamic_MobileNo()); driver.findElement(By.id("txtRemarks"))
		 * .sendKeys("Test- Remarks-" + ApplicationUtilities.Dynamic_MobileNo());
		 * GetLeadType(i); // Thread.sleep(3000); //
		 * driver.findElement(By.id("ddlRegionalLang")).click(); //Thread.sleep(2000);
		 * //new
		 * Select(driver.findElement(By.id("ddlRegionalLang"))).selectByVisibleText(
		 * "HINDI"); Thread.sleep(2000); driver.findElement(By.id("btnSave")).click();
		 * //WebDriverWait wait = new WebDriverWait(driver, 15);
		 * //wait.until(ExpectedConditions.alertIsPresent()); // WebDriverWait wait =
		 * new WebDriverWait(driver, 15); //
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strwait)));
		 * // ApplicationUtilities.DynamicWait(driver, strwait); Thread.sleep(5000);
		 * strtoken = ApplicationUtilities.getTextandCloseAlert(driver);
		 * System.out.println(strtoken); if(strtoken.equalsIgnoreCase("success")) {
		 * xls.setCellData(SheetName, "Token No", i, strtoken);
		 * 
		 * } else { ltoken = Integer.parseInt(strtoken.replaceAll("[\\D]", ""));
		 * strtoken = Long.toString(ltoken); xls.setCellData(SheetName, "Token No", i,
		 * strtoken); } driver.switchTo().defaultContent(); Fill_Complaint_Details(i);
		 * //IB_propsective_Token_Page_close(); // driver.navigate().refresh(); } }
		 * 
		 * } catch (Exception ex) { System.out.println("Exception in page Navigation" +
		 * ex.getMessage()); Reporter.log(ex.getLocalizedMessage(), true); } }
		 * 
		 * public void GetLeadType(int j) { try {
		 * 
		 * String Leadtype = xls.getCellData(SheetName, "Lead Type", j); if
		 * (Leadtype.equalsIgnoreCase("Multi TV")) {
		 * driver.findElement(By.id("rdolistLeadType_0")).click(); } else if
		 * (Leadtype.equalsIgnoreCase("New Connection")) {
		 * driver.findElement(By.id("rdolistLeadType_1")).click(); } else if
		 * (Leadtype.equalsIgnoreCase("Magic Stick")) {
		 * driver.findElement(By.id("rdolistLeadType_2")).click(); } else if
		 * (Leadtype.equalsIgnoreCase("Magic Stick + Alexa")) {
		 * driver.findElement(By.id("rdolistLeadType_3")).click(); } else if
		 * (Leadtype.equalsIgnoreCase("SD/HD to Android Box")) {
		 * driver.findElement(By.id("rdolistLeadType_4")).click(); } } catch (Exception
		 * ex) { System.out.println(ex); }
		 * 
		 * }
		 * 
		 * public void Fill_Complaint_Details(int k) { try {
		 * 
		 * String winHandleBefore = driver.getWindowHandle(); String strMSG = ""; //
		 * Switch to new window opened for (String winHandle :
		 * driver.getWindowHandles()) { driver.switchTo().window(winHandle); strMSG =
		 * driver.switchTo().window(winHandle).getTitle(); Thread.sleep(4000); if
		 * (strMSG.contains(":: Request ::")) { // complalclose.click();
		 * Thread.sleep(2000); strMSG = ApplicationUtilities.Dynamic_MobileNo();
		 * complmobile.sendKeys(strMSG); Thread.sleep(2000); strMSG =
		 * ApplicationUtilities.Dynamic_MobileNo(); complaltmobile.sendKeys(strMSG);
		 * Thread.sleep(2000); scallcategory =
		 * driver.findElement(By.xpath("//*[@id=\"txtComplaintCategory\"]"))
		 * .getAttribute("value"); Thread.sleep(2000); xls.setCellData(SheetName,
		 * "Call Category", k, scallcategory); Thread.sleep(2000); complSave.click();
		 * Thread.sleep(3000); strMSG =
		 * ApplicationUtilities.getTextandCloseAlert(driver);
		 * System.out.println(strMSG); ltoken =
		 * Integer.parseInt(strMSG.replaceAll("[\\D]", "")); strtoken =
		 * Long.toString(ltoken); xls.setCellData(SheetName, "Ticket no", k, strtoken);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * driver.switchTo().window(winHandleBefore); } catch (Exception ex) {
		 * xls.setCellData(SheetName, "Issues/Remarks", k, "Issue in Token generation");
		 * System.out.println("Exception in Fillcomplaint" + ex); } }
		 * 
		 * public void TokenFieldvaldiation() { try {
		 * 
		 * driver.switchTo().frame("IframPopUP");
		 * driver.findElement(By.id("btnSave")).click(); Thread.sleep(4000);
		 * assertEquals(closeAlertAndGetItsText(), "Pleae enter Caller name.");
		 * driver.findElement(By.id("txtCallerName")).clear();
		 * driver.findElement(By.id("txtCallerName")).sendKeys("Caller Name ");
		 * driver.findElement(By.id("btnSave")).click(); Thread.sleep(4000);
		 * assertEquals(closeAlertAndGetItsText(), "Please enter Mobile no.");
		 * driver.findElement(By.id("txtMobileNO")).clear();
		 * driver.findElement(By.id("txtMobileNO")).sendKeys("2342432435");
		 * driver.findElement(By.id("btnSave")).click(); Thread.sleep(4000);
		 * assertEquals(closeAlertAndGetItsText(),
		 * "Mobile Number Must Start With 9,8,7 and 6."); driver.findElement(By.xpath(
		 * "//div[@id='updSearchToken']/table/tbody/tr[3]/td/table/tbody/tr[3]")).click(
		 * ); driver.findElement(By.id("txtMobileNO")).clear();
		 * driver.findElement(By.id("txtMobileNO")).sendKeys("343");
		 * driver.findElement(By.id("btnSave")).click(); Thread.sleep(4000);
		 * assertEquals(closeAlertAndGetItsText(), "Invalid Mobile no.");
		 * driver.findElement(By.id("txtMobileNO")).click();
		 * driver.findElement(By.xpath(
		 * "//div[@id='updSearchToken']/table/tbody/tr[3]/td/table/tbody/tr[3]")).click(
		 * ); driver.findElement(By.id("txtMobileNO")).clear();
		 * driver.findElement(By.id("txtMobileNO")).sendKeys(ApplicationUtilities.
		 * Dynamic_MobileNo()); driver.findElement(By.id("btnSave")).click();
		 * Thread.sleep(4000); assertEquals(closeAlertAndGetItsText(),
		 * "Please enter Remarks."); Thread.sleep(2000);
		 * driver.findElement(By.id("txtAlternateNo")).sendKeys(ApplicationUtilities.
		 * Dynamic_MobileNo()); driver.findElement(By.id("txtRemarks")).clear();
		 * driver.findElement(By.id("txtRemarks")).sendKeys("test");
		 * driver.findElement(By.id("btnSave")).click(); Thread.sleep(4000);
		 * assertEquals(closeAlertAndGetItsText(), "Please select lead type.");
		 * Thread.sleep(2000); driver.findElement(By.id("rdolistLeadType_1")).click();
		 * Thread.sleep(4000);
		 * 
		 * driver.findElement(By.id("btnSave")).click(); Thread.sleep(4000);
		 * assertEquals(closeAlertAndGetItsText(),
		 * "Please select subscriber preferred language."); Thread.sleep(4000); new
		 * Select(driver.findElement(By.id("ddlRegionalLang"))).selectByVisibleText(
		 * "HINDI"); Thread.sleep(2000); IB_propsective_Token_Page_close();
		 * 
		 * } catch (Exception ex) { ApplicationUtilities.Fun_FailScreenshot(driver,
		 * "Token Field valdi"); System.out.println(ex); } }
		 * 
		 * private String closeAlertAndGetItsText() { boolean acceptNextAlert = false;
		 * try { Alert alert = driver.switchTo().alert(); String alertText =
		 * alert.getText(); if (acceptNextAlert) { alert.accept(); } else {
		 * alert.dismiss(); } return alertText; } finally { acceptNextAlert = true; } }
		 * 
		 * }
		 */