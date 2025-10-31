package in.dishtv.IB_CRM;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;

public class IB_CRM_Utility extends BaseLibrary {

	public IB_CRM_Utility() {
		super();
		PageFactory.initElements(driver, this);
	}

	// Method used for Update Subs information
	@FindBy(xpath = "//*[@id=\"rdoCallDrop\"]/tbody/tr/td[1]/label")
	private WebElement Option_Pre_Res;
	@FindBy(xpath = "//*[@id=\"rdoCallDrop_1\"]")
	private WebElement Option_Post_Res;
	@FindBy(xpath = "//*[@id=\"btnResolveOnline\"]")
	private WebElement Btn_Reslovedon_line;
	@FindBy(xpath = "//*[@id=\"rdFrontOfTV_1\"]")
	private WebElement Customer_In_front_of_TV_N;
	@FindBy(xpath = "//*[@id=\"btnNotinFrontTVCallComplete\"]")
	private WebElement Complte_Call;	
	@FindBy(xpath = "//*[@id=\"rdFrontOfTV_0\"]")
	private WebElement  Customer_In_front_of_TV_Y;
	@FindBy(xpath = "//*[@id=\"rdoSTBlight_1\"]")
	private WebElement  STB_Ligh_N;
	
	//--------------
	
	@FindBy(xpath = "//*[@id=\"ddlSTBReason\"]")
	private WebElement  ddl_Reason;	
	@FindBy(xpath = "//*[@id=\"rdobtnDishAlignment_2\"]")
	private WebElement  Subs_book_Tech_visit;	
	@FindBy(xpath = "//*[@id=\"ucUpdateCustNameAddress_rdoAddasPerZT_0\"]")
	private WebElement Add_As_Per_ZT;	
	@FindBy(xpath = "//*[@id=\"ucUpdateCustNameAddress_chkverifyAddress\"]")
	private WebElement Verify_Address;	
	@FindBy(xpath = "//*[@id=\"ucUpdateCustNameAddress_chkpincode\"]")
	private WebElement Verify_pincode;	
	@FindBy(xpath = "//*[@id=\"ucUpdateCustNameAddress_chkPhonenumber\"]")
	private WebElement Verify_ph;
	@FindBy(xpath = "//*[@id=\"ucUpdateCustNameAddress_chkAltNo\"]")
	private WebElement Verify_Alt_ph;	
	@FindBy(xpath = "//*[@id=\"ucUpdateCustNameAddress_txtCallPhoneNo\"]")
	private WebElement Enter_CallPhone;	
	@FindBy(xpath = "//*[@id=\"ucUpdateCustNameAddress_txtAltNo\"]")
	private WebElement Enter_Alt_CallPhone;	
	@FindBy(xpath = "//*[@id=\"ucUpdateCustNameAddress_txtRemarks\"]")
	private WebElement Enter_Remarks;	
	@FindBy(xpath = "//*[@id=\"ucUpdateCustNameAddress_btnCompltCall\"]")
	private WebElement btn_submit;
	
	
	SoftAssert sft_Ast = new SoftAssert();

	public void Updatesubsinfo(WebDriver driver) {
		try {
			driver.findElement(By.linkText("Misc")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Update Subs Info")).click();
			Thread.sleep(1000);
			ApplicationUtilities.acceptAlert(driver);
			Thread.sleep(2000);
			ApplicationUtilities.acceptAlert(driver);
		} catch (Exception ex) {
			System.out.println("Issue in Update Subs Info" + ex);
		}
	}

	// Method used to switch into iframe on TECHNICAL TROUBLESHOOTING LIST
	public void Trobleshootifrm(WebDriver driver, String Linkname) {
		try {
			final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			for (WebElement iframe : iframes) {
				String str = iframe.getAttribute("id");
				 System.out.println(str);
				driver.switchTo().frame(str);
				
				/*if (str.equalsIgnoreCase("iframePageBindingSMRT")) {
				driver.findElement(By.linkText(Linkname)).click();*/

				if (str.equalsIgnoreCase("IframPopUP")) {
					String strq="";
					List<WebElement> allLinks = driver.findElements(By.tagName("a"));
					
					//Traversing through the list and printing its text along with link address
					for(WebElement link:allLinks){
						strq=link.getText();
						System.out.println(strq);
						if(strq.equalsIgnoreCase("STB NOT WORKING"))
						{
							driver.findElement(By.linkText(Linkname)).click();
						}
						//System.out.println(link.getText() + " - " + link.getAttribute("name"));
					}
					
					driver.switchTo().frame("iframePageBindingSMRT");
					driver.findElement(By.linkText(Linkname)).click();
				} else
					driver.switchTo().defaultContent();

			}
		} catch (Exception ex) {
			System.out.println("Issue in Trobleshoot" + ex);
		}
	}

	// Method used to switch into iframe on TECHNICAL TROUBLESHOOTING LIST
	public void Trobleshoot(WebDriver driver, String Linkname, String strIfram) {
		try {
			final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			for (WebElement iframe : iframes) {
				String str = iframe.getAttribute("id");
				// System.out.println(str);
				driver.switchTo().frame(str);				
				  if(str.equalsIgnoreCase("NA")) { if (str.equalsIgnoreCase(strIfram)) {
				  driver.findElement(By.linkText(Linkname)).click(); } else
				  driver.switchTo().defaultContent();
				  
				  }
				 
			}
		} catch (Exception ex) {
			System.out.println("Issue in Trobleshoot" + ex);
		}
	}

	// Method used to apply validation for resolved on line
	public void Resloved_Online_Validation(WebDriver driver) {
		try {

			String Stractualalert = "Please enter Call Phone no.";
			driver.switchTo().frame("iframePageBinding");
			driver.findElement(By.xpath("//*[@id=\"txtCallPhoneNo\"]")).sendKeys("test");
			Option_Pre_Res.click();
			String stralert = ApplicationUtilities.getTextandCloseAlert(driver);
			sft_Ast.assertEquals(stralert, Stractualalert);
			Option_Post_Res.click();
			Thread.sleep(3000);
			stralert = ApplicationUtilities.getTextandCloseAlert(driver);
			sft_Ast.assertEquals(stralert, Stractualalert);
			Thread.sleep(3000);
			Btn_Reslovedon_line.click();
			Thread.sleep(3000);
			stralert = ApplicationUtilities.getTextandCloseAlert(driver);
			sft_Ast.assertEquals(stralert, Stractualalert);

		} catch (Exception ex) {
			System.out.println("Issue in Resloved_Online_Validation" + ex);
		}
	}

	public void CustomerinfrontofTV_No(WebDriver driver) {
		try {
			
			driver.switchTo().frame("iframePageBinding");
			Thread.sleep(3000);
			Customer_In_front_of_TV_N.click();
			Thread.sleep(3000);
			Complte_Call.click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifCallHistory");

		} catch (Exception ex) {
			System.out.println("Issue on CustomerinfrontofTV_No" + ex);
		}
	}

	
	public void CustomerInfrontofTV(WebDriver driver) {
		try {
			
			driver.switchTo().frame("iframePageBinding");
			Thread.sleep(3000);
			Customer_In_front_of_TV_Y.click();
			Thread.sleep(3000);			
			STB_Ligh_N.click();
			Thread.sleep(2000);
			ApplicationUtilities.dropdownTextContains(ddl_Reason, "STB dead");			
			Thread.sleep(2000);
			Subs_book_Tech_visit.click();
			Thread.sleep(2000);
			ApplicationUtilities.Scroll_Page_To_Bottom(driver);
			Add_As_Per_ZT.click();
			Thread.sleep(2000);
			Enter_CallPhone.sendKeys(ApplicationUtilities.Dynamic_MobileNo());
			Enter_Alt_CallPhone.sendKeys(ApplicationUtilities.Dynamic_MobileNo());			
			Thread.sleep(2000);
			Verify_Address.click();
			Verify_pincode.click();			
			Verify_ph.click();			
			Verify_Alt_ph.click();			
			Enter_Remarks.sendKeys("STB not Working "+ ApplicationUtilities.Fun_DateTime());
			Thread.sleep(2000);
			//btn_submit.click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifCallHistory");

		} catch (Exception ex) {
			System.out.println("Issue on CustomerinfrontofTV_No" + ex);
		}
	}
}
