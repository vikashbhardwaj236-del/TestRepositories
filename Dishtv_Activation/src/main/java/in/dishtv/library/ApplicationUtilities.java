package in.dishtv.library;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.io.Files;

public class ApplicationUtilities {

	static Select sel;
	public static String StrDt;
	public static String Stralert;

	// This method is used for select dropdown values using contains.
	public static void dropdownTextContains(WebElement element, String text) {
		try {
			sel = new Select(element);
			List<WebElement> ops = sel.getOptions();
			for (WebElement webElement : ops) {
				String txt = webElement.getText();
				if (txt.toUpperCase().trim().contains(text.toUpperCase().trim())) {
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
		try {
			sel = new Select(element);
			List<WebElement> ops = sel.getOptions();
			for (WebElement webElement : ops) {
				String txt = webElement.getText();
				if (txt.trim().equalsIgnoreCase(text.trim())) {
					sel.selectByVisibleText(txt);
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception in drop down selection !");
			Reporter.log(ex.getLocalizedMessage(), true);
		}
	}

	public static String validatedata(WebElement element, String text) {
		String matchdata = null;
		try {
			sel = new Select(element);
			List<WebElement> ops = sel.getOptions();
			for (WebElement webElement : ops) {
				String txt = webElement.getText();
				if (txt.trim().equalsIgnoreCase(text.trim())) {
					return txt;
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception in drop down selection !");
			Reporter.log(ex.getLocalizedMessage(), true);
		}
		return matchdata;
	}

	public static void dropdownValue(WebElement element, String value) {
		sel = new Select(element);
		List<WebElement> ops = sel.getOptions();
		for (WebElement webElement : ops) {
			String val = webElement.getAttribute(value);
			if (val.equalsIgnoreCase(value)) {
				sel.selectByValue(val);
				break;
			}
		}
	}

	// Added by Santosh Bora - 22012019
	public static void closenormalpopup(WebElement element, WebDriver driver) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("unable to click closepopup");
			e.printStackTrace();
		}

	}

	public static void Fun_FailScreenshot(WebDriver driver, String screenshotname) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			StrDt = Fun_DateTime();
			Files.copy(source, new File(System.getProperty("user.dir") + "./screenshots/failedCases/"
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
			Files.copy(source, new File(System.getProperty("user.dir") + "./screenshots/passedCases/"
					+ screenshotname + " " + StrDt + ".png"));
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}

	}

	/// Function to get Current & Time
	public static String Fun_DateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy 'at' hh-mm-ss a zzz");
		Date date = new Date();
		String Str_Date = dateFormat.format(date);
		return Str_Date;
	}

	// Added by Santosh Bora - 18062019
	public static String closenormalpopup_returnString(WebElement element, WebElement Text_element, WebDriver driver) {
		String str = null;
		try {
			String text = Text_element.getText();
			element.click();
			return text;
		} catch (Exception e) {
			// System.out.println("unable to click closepopup");
			// e.printStackTrace();
			return str;
		}

	}

	// To validate drop-down data is exist or not
	public static boolean validatedropdowndata(WebElement element, String text) {
		boolean matchdata = false;
		try {

			sel = new Select(element);
			List<WebElement> ops = sel.getOptions();
			for (WebElement webElement : ops) {
				String txt = webElement.getText();

				if (txt.trim().equalsIgnoreCase(text.trim())) {
					return true;
				}

			}

		} catch (Exception ex) {
			System.out.println("Exception in drop down selection !");
			Reporter.log(ex.getLocalizedMessage(), true);
		}
		return matchdata;
	}

	public static boolean WebElementPrasant(WebElement Element) {
		boolean prasant = false;
		try {
			boolean bElement = Element.isEnabled();
			if (bElement == true) {
				return true;
			} else {
				return prasant;
			}

		} catch (Exception e) {
			try {
				return prasant;
			} catch (Exception e2) {
				System.out.println("Issue in - " + Element.getText());
				Reporter.log(e.getLocalizedMessage(), true);
			}

		}
		return prasant;
	}

	public static void getddpvalueusingstring(WebDriver driver, String strval, String Strddpval) {
		try {
			WebElement drp_element = driver.findElement(By.xpath(strval));
			Select Sel = new Select(drp_element);
			Sel.selectByVisibleText(Strddpval);
		} catch (Exception e) {
			System.out.println("Exception value selection.");
			Reporter.log(e.getLocalizedMessage(), true);
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

	public static String getTextandCloseAlert(WebDriver driver) {
		try {
			boolean acceptNextAlert = true;
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
		} catch (Exception e) {
			// System.out.println("Alert message clicked.");
		}
		return Stralert;
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
			Reporter.log("No Alert Present.", true);
			return false;
		}
	}

	public static void acceptAlert(WebDriver driver) {
		boolean bool = true;
		try {
			bool = isAlertPresent(driver);
			if (bool) {
				driver.switchTo().alert().accept();
			}
		} catch (Exception ex) {
			System.out.println(ex);
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
			System.out.println("Exception in open in new tab !");

		}

	}

	// Common method to quit from Driver
	public void Fun_DriverQuit(WebDriver driver) {
		try {
			driver.quit();
			driver = null;
		} catch (Exception e) {
			System.out.println("Exception on quit from Browser !");
		}
	}

	public void switchToTab(WebDriver driver) {
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

	// Common method to IB page in
	public void openIB(WebDriver driver) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			String StrURLIB = PropertiesLib.getPropertyValue("urlIB");
			driver.get(StrURLIB);
		} catch (Exception e) {
			System.out.println("Exception in open IB page");
			e.printStackTrace();
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

	// Method for Get numbers from String
	public static long getnumberfromstr(String strval) {
		long tokenno = (long) Double.parseDouble(strval.replaceAll("[^0-9\\.]+", ""));
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

	public void Inner_scroll(WebDriver driver) {
		try {

			WebElement scrollArea = driver.findElement(By.xpath("//*[@id='pnlAlignmentTrouble']"));
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

	public static String aa(String strvalue, String strsign) {
		String strfinal = "";
		try {
			// int i=strvalue.length();
			int strwl = strvalue.indexOf(strvalue, 4);
			// strfinal = strvalue.substring(strvalue.valueOf(strsign) ;
			strfinal = strfinal.trim();
			return strfinal;
		} catch (Exception e) {
			e.printStackTrace();
			return strfinal;
		}
	}

	// Created by Santosh - But not completed
	public static void dragandfrop(WebDriver driver) {
		try {
			driver.findElement(By.xpath(".//*[@id='header']/div[2]/ul/li[2]/a/b")).click();
			driver.findElement(By.xpath("//*[@id='dishTable']/tbody/tr[1]/td[6]")).click();
			WebElement Source = driver
					.findElement(By.xpath("//*[@id='OrdersGrid']/div[2]/div[1]/table/tbody/tr[1]/td[4]"));
			WebElement Target = driver
					.findElement(By.xpath("//*[@id='Schedule1_scroller']/div[1]/table/tbody/tr[3]/td[20]"));

			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			Actions builder = new Actions(driver);
			Action dragAndDrop = builder.moveToElement(Source).clickAndHold(Source).moveToElement(Target)
					.release(Target).build();
			Thread.sleep(10000);
			dragAndDrop.perform();
			Thread.sleep(10000);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public static String Phoenixalertclose(WebDriver driver) {
		String Strmsg = "";
		try {

			WebElement Weblmsg = driver.findElement(By.xpath("//*[@id=\"alertDiv\"]/p"));
			Strmsg = Weblmsg.getText();
			driver.findElement(By.xpath("//*[@id='btnClose'][@style='float:right;']")).click();

			return Strmsg;
		} catch (Exception e) {
			System.out.println("Issue in get alert Message");
			return "";
		}

	}

	public static String Dynamic_MobileNo() {
		String str = "";
		DateFormat dateFormat = new SimpleDateFormat("ddyymmss");
		Date date = new Date();
		str = dateFormat.format(date);
		return str = "98" + str;
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

	// santosh created
	public static boolean isClickable(WebElement Webel, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 6);
			wait.until(ExpectedConditions.elementToBeClickable(Webel));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String Getnofromint(int i) {
		String strvalue = "";
		String strvalue1 = "";
		String strvalue2 = "";
		String strvalue3 = "";
		String strvalue4 = "";

		int number = i;
		// Seperate number into digits.
		int digit4 = number % 10;
		number = number / 10;
		int digit3 = number % 10;
		number = number / 10;
		int digit2 = number % 10;
		number = number / 10;
		int digit1 = number % 10;
		number = number / 10;

		// Set up a switch statement to read through the number.
		switch (digit1) {

		// case 1: //System.out.print("One");
		case 1:
			strvalue1 = "One";
			break;
		case 2:
			strvalue1 = "Two";
			break;
		case 3:
			strvalue1 = "Three";
			break;
		case 4:
			strvalue1 = "Four";
			break;
		case 5:
			strvalue1 = "Five";
			break;
		case 6:
			strvalue1 = "Six";
			break;
		case 7:
			strvalue1 = "Seven";
			break;
		case 8:
			strvalue1 = "Eight";
			break;
		case 9:
			strvalue1 = "Nine";
			break;
		default:
			strvalue1 = "ZERO";
			break;

		}

		switch (digit2) {

		case 1:
			strvalue2 = "One";
			break;
		case 2:
			strvalue2 = "Two";
			break;
		case 3:
			strvalue2 = "Three";
			break;
		case 4:
			strvalue2 = "Four";
			break;
		case 5:
			strvalue2 = "Five";
			break;
		case 6:
			strvalue2 = "Six";
			break;
		case 7:
			strvalue2 = "Seven";
			break;
		case 8:
			strvalue2 = "Eight";
			break;
		case 9:
			strvalue2 = "Nine";
			break;
		default:
			strvalue2 = "Zero";
			break;
		}
		switch (digit3) {
		case 1:
			strvalue3 = "One";
			break;
		case 2:
			strvalue3 = "Two";
			break;
		case 3:
			strvalue3 = "Three";
			break;
		case 4:
			strvalue3 = "Four";
			break;
		case 5:
			strvalue3 = "Five";
			break;
		case 6:
			strvalue3 = "Six";
			break;
		case 7:
			strvalue3 = "Seven";
			break;
		case 8:
			strvalue3 = "Eight";
			break;
		case 9:
			strvalue3 = "Nine";
			break;
		default:
			strvalue3 = "Zero";
			break;
		}
		switch (digit4) {
		case 1:
			strvalue4 = "One";
			break;
		case 2:
			strvalue4 = "Two";
			break;
		case 3:
			strvalue4 = "Three";
			break;
		case 4:
			strvalue4 = "Four";
			break;
		case 5:
			strvalue4 = "Five";
			break;
		case 6:
			strvalue4 = "Six";
			break;
		case 7:
			strvalue4 = "Seven";
			break;
		case 8:
			strvalue4 = "Eight";
			break;
		case 9:
			strvalue4 = "Nine";
			break;
		default:
			strvalue4 = "Zero";
			break;
		}
		return strvalue = strvalue1 + strvalue2 + strvalue3 + strvalue4;
	}

}
