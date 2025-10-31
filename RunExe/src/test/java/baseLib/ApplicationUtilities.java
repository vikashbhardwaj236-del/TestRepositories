package baseLib;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.base.Function;

public class ApplicationUtilities {

	static Select sel;
	public static String StrDt;

	// This method is used for select dropdown values using contains.
	public static void dropdownTextContains(WebElement element, String text) {
		try {
			sel = new Select(element);
			List<WebElement> ops = sel.getOptions();
			for (WebElement webElement : ops) {
				String txt = webElement.getText();
				if (txt.contains(text)) {
					sel.selectByVisibleText(txt);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in drop down value selection");
			e.printStackTrace();
		}
	}

	public static void dropdownTextEqualIgnoreCase(WebElement element, String text) {
		sel = new Select(element);
		List<WebElement> ops = sel.getOptions();
		for (WebElement webElement : ops) {
			String txt = webElement.getText();
			if (txt.equalsIgnoreCase(text)) {
				sel.selectByVisibleText(txt);
				break;
			}
		}
	}

	public static void dropdownValue(WebElement element, String value) {
		sel = new Select(element);
		List<WebElement> ops = sel.getOptions();
		for (WebElement webElement : ops) {
			String val = webElement.getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				sel.selectByValue(val);

				break;
			}
		}
	}

	public static void getddpvalueusingstring(WebDriver driver, String strval, String Strddpval) {
		try {
			WebElement drp_element = driver.findElement(By.xpath(strval));
			Select Sel = new Select(drp_element);
			Sel.selectByVisibleText(Strddpval);
		} catch (Exception e) {
			System.out.println("Exception value selection.");
		
		}
	}

	public static void dropdownIndex(WebElement element, int index) {
		try {
			sel = new Select(element);
			sel.selectByIndex(index);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String[] split(String inputstring, String regex) {
		return inputstring.split(regex);
	}

	public static void scrollDown(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

		} catch (Exception e) {
			System.out.println("Exception scroll down." + e.getMessage());
			
		}
	}

	public static void Fun_FailScreenshot(WebDriver driver, String screenshotname) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			StrDt = Fun_DateTime();
			FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "./screenshots/failedCases/"
					+ screenshotname + " " + StrDt + ".png"));
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}

	}

	public static void Fun_PassScreenshot(WebDriver driver, String screenshotname) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			StrDt = Fun_DateTime();
			FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "./screenshots/passedCases/"
					+ screenshotname + " " + StrDt + ".png"));
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}

	}
	public static void Printscreen( String Strpath,String screenshotname ) {
		try {
			
			Robot r = new Robot(); 	
			StrDt = Fun_DateTime();			 
			String path = Strpath+screenshotname+" "+ StrDt + ".png"; 	
			Rectangle capture = 
			new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
			BufferedImage Image = r.createScreenCapture(capture); 
			ImageIO.write(Image, "png", new File(path)); 
			}
			catch(Exception ex)
			{
				System.out.println("Issue in take print screen");
			}

	}

	public static void Run_Screen_capture_video() {

		try {
			Runtime.getRuntime().exec("C:\\FastStone Capture\\FSCapture.exe");
			Thread.sleep(3000);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "//drivers//Record_RUN.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void CaptureScreenInword() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_PRINTSCREEN);
		} catch (Exception ex) {
			System.out.println("Issue in Capture ScreenInword " + ex);
		}
	}

	public static String getTextandCloseAlert(WebDriver driver) {
		String alertText="";
		try {
			
			boolean acceptNextAlert = true;
			try {
				Alert alert = driver.switchTo().alert();
				alertText = alert.getText();
				if (acceptNextAlert) {
					alert.accept();
				} else {
					alert.dismiss();
				}
				return alertText;
			} finally {
				acceptNextAlert = true;
			}
		} catch (Exception e) {
			System.out.println("Alert message clicked.");
		}
		return alertText;
	}

	public static void Focuschange(WebDriver driver, String strfocusobject, int iwaittimemilisend) {
		try {
			driver.findElement(By.xpath(strfocusobject)).click();
			Thread.sleep(iwaittimemilisend);

		} catch (Exception e) {
			System.out.println("Exception while focus change!" + e.getMessage());
		}

	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			
			return false;
		}
	}

	public static void acceptAlert(WebDriver driver) {
		boolean bool = true;
		bool = isAlertPresent(driver);
		if (bool) {
			driver.switchTo().alert().accept();
		}
	}

	public static String getAlertText(WebDriver driver) {
		String alertText = "";
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
			return alertText;
		} catch (Exception ex) {
			System.out.println(ex);
			return alertText;
		}

	}

	// method used to get alert text
	public static String getalerttext(WebDriver driver, WebElement WebElmentMessage) {
		String altext = "";
		try {
			altext = WebElmentMessage.getText();
			return altext;
		} catch (Exception ex) {
			System.out.println("Issue in get value from alert text.");
		}
		return altext;

	}

	// method used to close for custom control
	public static void AlertClose(WebDriver driver, WebElement WebElmentclose) {

		try {
			Thread.sleep(3000);
			WebElmentclose.click();

		} catch (Exception ex) {
			System.out.println("Issue in closed alert." + ex);
		}

	}

	
	/// Function to get Current & Time
	public static String Fun_DateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy 'at' hh-mm-ss a zzz");
		Date date = new Date();
		String Str_Date = dateFormat.format(date);
		return Str_Date;
	}
	// Open new tab

	/// method to highlight the click Area
	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: Green; border: 15px solid blue;');", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);

	}

	// Common method to open new tab
	public static void Ntab(WebDriver driver, String url) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get(url);
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Exception in open new tab !");

		}

	}

	// Common method to quit from Driver
	public static void Fun_DriverQuit(WebDriver driver) {
		try {
			driver.quit();
			driver = null;
		} catch (Exception e) {
			System.out.println("Exception on quit from Browser !");
		}
	}

	public static void switchToTab(WebDriver driver) {
		// Switching between tabs using CTRL + tab keys.
		try {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
			// Switch to current selected tab's content.
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Exception in Switch tab.");
		}

	}

	// Common method to Object identification
	public static boolean Fun_IsElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true; // Success!
		} catch (Exception ignored) {

			System.out.println("Exception in Object Identification ! ");
			return false;
		}
	}

	// Method for mouse-hover and click
	public static void MouseHovernclick(WebDriver driver, String Strhoverobj, String Strobjclick) {
		try {
			WebElement element = driver.findElement(By.linkText(Strhoverobj));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			Thread.sleep(4000);
			driver.findElement(By.linkText(Strobjclick)).click();
		} catch (Exception ex) {

			System.out.println("Exception in mouse-hover");
		}

	}
	// Method for mouse-hover and click
		public static void MouseHovernclickxpath(WebDriver driver, String Strhoverobj, String Strobjclick) {
			try {
				WebElement element = driver.findElement(By.xpath(Strhoverobj));
				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();
				Thread.sleep(4000);
				driver.findElement(By.xpath(Strhoverobj)).click();
				Thread.sleep(4000);
				driver.findElement(By.xpath(Strobjclick)).click();
				Thread.sleep(4000);
			} catch (Exception ex) {

				System.out.println("Exception in mouse-hover");
			}

		}

	// Method for mouse-hover
	public static void Mouseover_action(WebDriver driver, WebElement ele) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
		} catch (Exception e) {
			System.out.println("Issue in Mouse hover action");
		}
	}

	// Method for Get numbers from String
	public static long getnumberfromstr(String strval) {
		long tokenno = 0;
		try {
			tokenno = (long) Double.parseDouble((strval.trim().replaceAll("[^0-9\\.]+", "")));
			return tokenno;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return tokenno;
	}

	/// Function for Remove space of given String
	public static String Fun_RemoveSpace(String stringvalue) {
		String withoutspaces = "";
		char ch = 'a';
		for (int i = 0; i < stringvalue.length(); i++) {
			ch = stringvalue.charAt(i);
			if (ch != 32)
				withoutspaces += stringvalue.charAt(i);
		}
		return withoutspaces;
	}

	public static void Scroll_Page_To_Bottom(WebDriver driver) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception ex) {
			System.out.println("Exception scroll.");
		}
	}

	public static boolean isClickable(WebElement Webel, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 6);
			wait.until(ExpectedConditions.elementToBeClickable(Webel));
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	public static void Inner_scroll(WebDriver driver, WebElement xth) {
		try {

			WebElement scrollArea = driver.findElement(By.xpath(xth.toString()));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollTop = arguments[1];", scrollArea, 500);
		} catch (Exception ex) {
			System.out.println("Exception in inner scroll.");
		}

	}

	// Method for Clear the all textbox
	public static void CleartextCollection(WebDriver driver) {
		try {
			List<WebElement> links = driver.findElements(By.tagName("input"));
			System.out.println(links.size());
			for (int i = 0; i < links.size(); i++) {
				if (links.get(i).isDisplayed() == true) {
					links.get(i).clear();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in clear all text box.");
			e.printStackTrace();
		}
	}

	public static void DynamicWait(WebDriver driver, String StrXpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(StrXpath)));
		} catch (Exception e) {
			System.out.println("Exception dynamic wait mathod.");
		}
	}

	public static void waitForPageLoad(WebDriver driver) {

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	public static void Delete_All_File_From_DIR(String path) {
		try {
			File file = new File(path);
			File[] files = file.listFiles();
			for (File f : files) {
				f.delete();
			}
		} catch (Exception ex) {
			System.out.println("Problem in file delete process.");
			System.out.println(ex.getMessage());
		}
	}

	// Method to get the number from string
	public static String getnoofstring(String strvalue, String strsign) {
		String strfinal = "";
		try {
			strfinal = strvalue.substring(strvalue.lastIndexOf(strsign) + 1);
			strfinal = strfinal.trim();
			return strfinal;
		} catch (Exception e) {
			e.printStackTrace();
			return strfinal;
		}
	}

	// File Test case copy
	public static void TC_FileRename(String stroldName, String strnewName) {
		try {
			File oldName = new File(stroldName);
			File newName = new File(strnewName);
			if (oldName.renameTo(newName)) {
				System.out.println("Test case Renamed.");
			} else {
				System.out.println("Error in test case rename.");
			}

		} catch (Exception ex) {
			System.out.println("Problem in file rename process.");
			System.out.println(ex.getMessage());
		}
	}

	// Test Case file delete
	public static void TC_Filedelete(String strFileName) {
		try {
			File Fname = new File(strFileName);
			Fname.delete();

		} catch (Exception ex) {
			System.out.println("Problem in file delete process.");
			System.out.println(ex.getMessage());
		}
	}

	public static void CloseNewlyopentab(WebDriver driver) {
		try {
			String originalHandle = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(originalHandle)) {
					driver.switchTo().window(handle);
					driver.close();
				}
			}

			driver.switchTo().window(originalHandle);
		} catch (Exception ex) {
			System.out.println("Exception Closed og tabs." + ex.getMessage());
			
		}
	}

	
	
	public static String removeLastChar(String str, int i) {
		try {
			return str.substring(0, str.length() - i);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return str;
	}

	public static String Dynamic_MobileNo() {
		String str = "";
		
		DateFormat dateFormat = new SimpleDateFormat("ddyymmss");
		Date date = new Date();
		str = dateFormat.format(date);
		return str = "64" + str;
	}

	public static String Dynamic_Email() {
		String str = "";
		DateFormat dateFormat = new SimpleDateFormat("ddyymmss");
		Date date = new Date();
		str = dateFormat.format(date);
		return str = "Testemail" + str + "@test.com";
	}

	public static int getRandomDoubleBetweenRange(int min, int max) {
		int x = (int) ((Math.random() * ((max - min) + 1)) + min);
		return x;
	}
	public static void change_window(WebDriver driver , int index)
	{
	try {
	ArrayList<String>tabs=new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs.get(index));
	} catch (Exception e)
	{
	System.out.println("Issue in Change Window Method" +e);
	}
	}

	public static String extractInt(String str) {
		try {
			str = str.replaceAll("[^\\d]", " ");
			str = str.trim();
			str = str.replaceAll(" +", " ");
			str = str.replaceAll(" 9", " ");
			if (str.equals(""))
				return "-1";
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return str;
	}
	

}
