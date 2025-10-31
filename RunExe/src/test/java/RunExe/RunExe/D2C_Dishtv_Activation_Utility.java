package RunExe.RunExe;

import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.google.common.base.Function;
import baseLib.*;

public class D2C_Dishtv_Activation_Utility {

	static public String strpath = "D:\\Dishtv_ActivationData_Prepration_New\\DishD2h_Phoenix_Data.xlsx";
	static public String strpath1 = "D:\\Dishtv_ActivationData_Prepration_New";
	public static ExcelUtilities Exls = new ExcelUtilities(strpath);
	static String Installation_sheet = "Data_Install_Ind_V2";
	static String Activation_sheet = "Data_Activation";
	static String Config_Sheet = "Config";
	static String strVCs="";
	String Namevalue = "Test ";
	String StrCurrentDT = ApplicationUtilities.Fun_DateTime();
	String kittyy;
	static public String DTserverNode1 = "DevDishV2n1Ln.dishtvindia-new.in:21443";
	static public String DTserverNode11 = "DEV-DISH-V1-N11.DishtvIndia-New.in:21453";
	static public String DTserverNode2 = "DevDishV2n2Ln.dishtvindia-new.in:21444";
	static public String DTserverNode3 = "DevDishV2n3Ln.dishtvindia-new.in:21445";
	static public String DTDBuserID = "Gen_Testing";
	static public String DTDBPass = "gentesting@12345";
	static public String DTDBPass1 = "gentesting@12345";
	static public String DT_India_DB = "DishtvIndia";
	static public String DT_India_SR_DB = "DISHTVINDIA_SRCRM";
	static public String DT_SMSDTH_DB = "SMSDTH2003";
	static public String DT_SMSDTH_DB11 = "DTH_Inventory_Ancillary_1";



	public static void main(String[] args) {
		deletefile();
		countRunstatus();
		//writedata_In_Excel();
		ActivationWritedata();
		deletefile();
		ApplicationUtilities.TC_Filedelete("D:\\Dishtv_ActivationData_Prepration_New\\Process complete.txt");
		createfile();

	}

	public static void deletefile() {
		try {
			File folder = new File(strpath1);
			for (File file : folder.listFiles()) {
				if (file.getName().endsWith(".txt")) {
					file.delete();
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void createfile() {
		try {
			String StrDt = ApplicationUtilities.Fun_DateTime();
			FileWriter myWriter = new FileWriter(strpath1 + "\\Process complete. " + StrDt + ".txt");
			myWriter.write("Process done" + StrDt);
			myWriter.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Below methods to use for write data in excel
	public static int countRunstatus() {
		int Runstatus = 0;
		int coloumn = Exls.getRowCount(Installation_sheet);
		try {

			for (int j = 2; j <= coloumn; j++) {
				String RunStatus = Exls.getCellData(Installation_sheet, "Run Status", j);
				{
					if (RunStatus.toUpperCase().equalsIgnoreCase("yes")) {

						Runstatus++;

					}

				}
			}
		} catch (Exception e) {
			System.out.println("Issue in countRunstatus  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return Runstatus;
	}

	public static void Fill_D2h_Data(int ivalue, String Stbmodelrowid) {
		try {
			DatabaseConnection Objcon;
			String strVC = "";
			String strSTB = "";
			String strSTBVC = "";
			String str1="('";			
			String str2=",";
			String str3="'";
			String str4=")";			
			String StrQury ="";
			
			//if(strSTBVC.isEmpty())			
			Objcon = new DatabaseConnection(DTserverNode11, DTDBuserID, DTDBPass, DT_SMSDTH_DB11);
			
			
				strSTBVC=str1+strVCs+str3+strVCs+str4;		
				 StrQury = "Select top "+ivalue+" VSC_ID, SerialNumber from DTH_Inventory_Ancillary_1..itemserialnomaster (nolock) where StockPointType= 'SP' and stbmodelrowid ="
							+ Stbmodelrowid + " and ItemCode=1 and VSC_ID not in "+ strSTBVC +" and VSC_ID is not null";
				
			
			ResultSet result1 = Objcon.executeQuery(StrQury);

			int size = 0;
			if (result1 != null) {
				result1.last();
				size = result1.getRow();
				if (size == 0) {

					Objcon.con.close();
					System.out.println("Data not found for STB Model Row id-" + Stbmodelrowid);
					Exls.setCellData(Activation_sheet, "VC No", ivalue,
							"Data not found for STB Model Row id-" + Stbmodelrowid);
				}
			}
			if (size >= 1) {
				result1.beforeFirst();
				while (result1.next()) {
					
					strVC = result1.getString("VSC_ID");
					strVCs=strVC;
					strSTB = result1.getString("SerialNumber");
					/*strSTBVC=strSTB+":"+strVC;							
					ArrayList<String> ListSTBVC = new ArrayList<String>();
					ListSTBVC.add(strSTBVC);				    
				    System.out.println(ListSTBVC);*/			    
					System.out .println("Data for STB Model Row id-" + Stbmodelrowid + " VC-" + strVC + " STB-" + strSTB);
					Exls.setCellData(Activation_sheet, "VC No", ivalue, strVC);
					Thread.sleep(2000);
					Exls.setCellData(Activation_sheet, "STB NO", ivalue, strSTB);
					break;

				}
				Objcon.con.close();
			}
			Objcon.con.close();

		} catch (Exception ex) {

			System.out.println("Exception in Get complaint from DB." + ex);
		}
	}
	
	// Write data in EXcel Sheet as per your requirement and base on Scheme ID
	public static void writedata_In_Excel() {
		try {
			int rws = Exls.getRowCount(Installation_sheet);
			for (int i = 2; i <= rws; i++) {
				String RunStatus = Exls.getCellData(Installation_sheet, 0, i);
				if (RunStatus.toUpperCase().equalsIgnoreCase("yes")) {
					String Scratchcode = null;
					String Voucher = null;
					LinkedList<String> readydata = update_On_schemeId();
					for (String fetchdata : readydata) {
						String[] voucher_scratchcode = ApplicationUtilities.split(fetchdata, ":");
						Scratchcode = voucher_scratchcode[1].toString().intern().trim();
						Voucher = voucher_scratchcode[0].toString().intern().trim();
						Thread.sleep(2000);
						Exls.setCellData(Installation_sheet, "Voucher", i, Scratchcode);
						Thread.sleep(2000);
						Exls.setCellData(Installation_sheet, "Scratch code", i, Voucher);
						Thread.sleep(2000);
						readydata.remove(fetchdata);
						break;

					}
				}

			}

		} catch (Exception e) {
			System.out.println("Issue in Loaddata_In_Excel  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}

	}

	// Update data as per requirement
	public static LinkedList<String> update_On_schemeId() {
		LinkedList<String> afterupdatedata = new LinkedList<String>();
		try {
			DatabaseConnection Objcon = new DatabaseConnection(DTserverNode2, DTDBuserID, DTDBPass, DT_India_DB);
			DatabaseConnection Objcon1 = new DatabaseConnection(DTserverNode1, DTDBuserID, DTDBPass1, DT_SMSDTH_DB);
			CopyOnWriteArrayList<String> complainttrndata = validateComplaiantTRN_OnNode1();
			int runstatus = countRunstatus();
			for (int i = 2; i <= runstatus + 1; i++) {
				String SchemeId = Exls.getCellData(Installation_sheet, "Voucher_Scheme_ID", i);
				String Location_ID = Exls.getCellData(Installation_sheet, "Location_ID", i);
				for (String itreatedata : complainttrndata) {
					String Voucher = ApplicationUtilities.getnoofstring(itreatedata, ":");
					Objcon.executeupdate("update dishtvindia..Voucherinfo set schemeid = " + SchemeId
							+ ", usedforActivation = 'N', LocationID =" + Location_ID + " where voucherno in ('"
							+ Voucher + "')");
					Objcon1.executeupdate("update  SMSdth2003.dbo.Subscribermaster set Hwvoucherno = " + SchemeId
							+ " where Hwvoucherno  in ('" + Voucher + "')");
					Objcon1.executeupdate("update Itemserialnomaster_voucher set schemeid =" + SchemeId
							+ ", Location = " + Location_ID + " where SerialNumber in ('" + Voucher + "')");
					afterupdatedata.add(itreatedata);
					complainttrndata.remove(itreatedata);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in update_On_schemeId  method.");
			 Reporter.log(e.getLocalizedMessage(), true);
		}
		return afterupdatedata;

	}

	// To validate fetch data is exist in Node 1 or Not
	public static CopyOnWriteArrayList<String> validateComplaiantTRN_OnNode1() {
		CopyOnWriteArrayList<String> Finallist = null;
		String data = null;
		try {

			CopyOnWriteArrayList<String> dataa = validateComplaiantTRN_OnNode2();
			Iterator<String> getvoucher = dataa.iterator();
			while (getvoucher.hasNext()) {
				String value = getvoucher.next();
				String combineddata = value;
				String Voucher = ApplicationUtilities.getnoofstring(combineddata, ":");
				DatabaseConnection Objcon = new DatabaseConnection(DTserverNode1, DTDBuserID, DTDBPass1, DT_SMSDTH_DB);
				ResultSet result = Objcon.executeQuery(
						"select rowid from complainttrn(nolock) where Voucherno=" + "'" + Voucher + "'" + "");
				if (result.next()) {
					data = result.getString("rowid");
					if (data == null) {

					} else {

						dataa.remove(value);
					}
				}
			}

			Finallist = new CopyOnWriteArrayList<String>(dataa);

		} catch (Exception e) {
			System.out.println("Issue in validateComplaiantTRN_OnNode1 method.");
			 Reporter.log(e.getLocalizedMessage(), true);
		}
		return Finallist;
	}

	// To validate fetch data is exist in Node 2 or Not
	public static CopyOnWriteArrayList<String> validateComplaiantTRN_OnNode2() {
		CopyOnWriteArrayList<String> orignallist = null;

		@SuppressWarnings("unused")
		ArrayList<String> rawdata = null;
		String data = null;
		try {
			DatabaseConnection Objcon = new DatabaseConnection(DTserverNode2, DTDBuserID, DTDBPass, DT_India_DB);
			rawdata = new ArrayList<String>();
			CopyOnWriteArrayList<String> dataa = getVoucher_ScratchCode();
			Iterator<String> getvoucher = dataa.iterator();
			while (getvoucher.hasNext()) {

				String value = getvoucher.next();
				String combineddata = value;
				String Voucher = ApplicationUtilities.getnoofstring(combineddata, ":");

				ResultSet result = Objcon.executeQuery(
						"select rowid from complainttrn(nolock) where Voucherno=" + "'" + Voucher + "'" + "");
				if (result.next()) {
					data = result.getString("rowid");
					if (data == null) {

					} else {

						dataa.remove(value);
					}
				}
			}

			orignallist = new CopyOnWriteArrayList<String>(dataa); // To copy one list to another list

		} catch (Exception e) {
			System.out.println("Issue in validateComplaiantTRN_OnNode2  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return orignallist;
	}

	// Get data form database
	public static CopyOnWriteArrayList<String> getVoucher_ScratchCode() {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		String Voucher = null;
		String Scratchcode = null;
		try {
			int randomno = ApplicationUtilities.getRandomDoubleBetweenRange(40, 30);
			DatabaseConnection Objcon = new DatabaseConnection(DTserverNode2, DTDBuserID, DTDBPass, DT_India_DB);
			ResultSet result1 = Objcon.executeQuery("Select top " + randomno
					+ "  VoucherCode,VoucherNo   from dishtvindia..Voucherinfo (nolock) \r\n"
					+ "			where  Activationid is null and locationtype ='DL' \r\n"
					+ "			and SchemeId = 717 and VoucherCode is not null and voucherno not in \r\n"
					+ "			(Select distinct  top 10 Voucherno from dishtvindia_srcrm..Complainttrn (nolock) where  voucherno is not null and voucherno <>'' and complaintdt>getdate()-30) \r\n"
					+ "			order by Date_time desc");

			while (result1.next()) {
				Scratchcode = result1.getString("VoucherCode");
				Voucher = result1.getString("VoucherNo");
				String concatetinate = Scratchcode + ":" + Voucher;
				list.add(concatetinate);
			}
			return list;
		} catch (Exception e) {
			System.out.println("Issue in getVoucher_ScratchCode  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return list;
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
	// ======================= Activation ==============

	// To Write data in Excel (VC and STB)
	public static void ActivationWritedata() {
		try {
			int actrowcount = Exls.getRowCount(Activation_sheet);
			for (int j = 2; j <= actrowcount; j++) {
				String StrRun = Exls.getCellData(Activation_sheet, "Run Status", j);
				if (StrRun.toUpperCase().equalsIgnoreCase("YES")) {
					String ProcessName = Exls.getCellData(Activation_sheet, "ProcessName", j);
					if (ProcessName.toUpperCase().equalsIgnoreCase("D2C")) {
						String stbmodelrowid = Exls.getCellData(Activation_sheet, "STB_Model_RowID", j);
						Fill_D2h_Data(j, stbmodelrowid);
					} else if (ProcessName.toUpperCase().equalsIgnoreCase("Trade")) {
						int rws = Exls.getRowCount(Activation_sheet);
						LinkedList<String> updateedata = updateActivation();					
						for (String getdata : updateedata) {
							String[] VC_STB = ApplicationUtilities.split(getdata, ":");
							String VCNo = VC_STB[0].toString();
							String STBNo = VC_STB[1].toString();
							Exls.setCellData(Activation_sheet, "VC No", j, VCNo);
							Thread.sleep(2000);
							Exls.setCellData(Activation_sheet, "STB NO", j, STBNo);
							updateedata.remove(getdata);
							break;
						}
						
					}
					else {
						System.out.println("Please select process Name.");
						Exls.setCellData(Activation_sheet, "Issues/Remarks", j, "Please select process Name.");
					}
				}

				
			}
		} catch (Exception e) {
			System.out.println("Issue in ActivationWritedata method.");
			 Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// To update data in Node 1 and Node 2 as per given data Like (Scheme ID, Dealer
	// ID, STBRow ID)
	public static LinkedList<String> updateActivation() {
		LinkedList<String> updatedata = new LinkedList<String>();
		try {
			DatabaseConnection Objcon = new DatabaseConnection(DTserverNode2, DTDBuserID, DTDBPass, DT_India_DB);
			DatabaseConnection Objcon1 = new DatabaseConnection(DTserverNode11, DTDBuserID, DTDBPass, DT_SMSDTH_DB11);

			int count = RunStauscountActivation();
			CopyOnWriteArrayList<String> data = GetdataActivation();
			for (int i = 2; i <= count + 1; i++) {
				String scheme = Exls.getCellData(Activation_sheet, "Scheme_ID", i);
				String ModelRowId = Exls.getCellData(Activation_sheet, "STB_Model_RowID", i);
				String locationId = Exls.getCellData(Activation_sheet, "Location_ID", i);
				for (String getdata : data) {
					String[] VC_STB = ApplicationUtilities.split(getdata, ":");
					String VCNo = VC_STB[0].toString();
					String STBNo = VC_STB[1].toString();
					/*
					 * Objcon.executeupdate("update dishtvindia..Stbinfo set Schemeid = " + scheme +
					 * ",LocationType='DC',LocationId= " + locationId + ",stbmodelrowid =" +
					 * ModelRowId + " where stbno in ('" + VCNo + "'" + "," + "'" + STBNo + "'" +
					 * ")");
					 */

					/*
					 * Objcon.executeupdate("update dishtvindia..vcinfo set Schemeid = " + scheme +
					 * ",LocationType='DC',LocationId= " + locationId + ",stbmodelrowid =" +
					 * ModelRowId + " where VCNo in ('" + VCNo + "'" + "," + "'" + STBNo + "'" +
					 * ")");
					 */

					Objcon.executedelete("delete from dishtvindia..libertyboxdump where serialnumber in('" + VCNo + "'"
							+ "," + "'" + STBNo + "'" + ")");

					Objcon1.executeupdate("update Itemserialnomaster set stbmodelrowid =" + ModelRowId + ",Schemeid ="
							+ scheme + ",stockpointtype = 'DC', location =" + locationId + " where SerialNumber in ('"
							+ VCNo + "'" + "," + "'" + STBNo + "'" + ")");

					updatedata.add(getdata);
					data.remove(getdata);
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Issue in updateActivation method.");
			 Reporter.log(e.getLocalizedMessage(), true);
		}
		return updatedata;
	}

	// Below process to use for Activation process
	public static int RunStauscountActivation() {
		int Runstatus = 0;
		try {
			int coloumn = Exls.getRowCount(Activation_sheet);
			for (int j = 2; j <= coloumn; j++) {
				String RunStatus = Exls.getCellData(Activation_sheet, 0, j);
				{
					if (RunStatus.toUpperCase().equalsIgnoreCase("yes")) {
						Runstatus++;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in RunStauscountActivation method.");
			 Reporter.log(e.getLocalizedMessage(), true);
		}
		return Runstatus;
	}

	// To Fill Fresh STB and VC in list from Database
	public static CopyOnWriteArrayList<String> GetdataActivation() {
		CopyOnWriteArrayList<String> token = new CopyOnWriteArrayList<String>();
		try {

			int count = RunStauscountActivation();
			DatabaseConnection Objcon = new DatabaseConnection(DTserverNode2, DTDBuserID, DTDBPass, DT_India_DB);
			ResultSet result = Objcon.executeQuery("Select top " + count
					+ " * from dishtvindia..Stbinfo a (nolock) where LocationType = 'SP' and stbmodelrowid =48  and VSC_ID is not null and SwapBoxflag<>1\r\n"
					+ "and not exists (select stbno from dishtvindia.dbo.subscribers b (nolock) where a.stbno=b.stbno)");
			while (result.next()) {
				String STBNo = result.getString("STBNo");
				String VCNo = result.getString("VSC_ID");
				String concatedata = VCNo.trim() + ":" + STBNo.trim();
				token.add(concatedata);
			}
			return token;

		} catch (Exception e) {
			System.out.println("Issue in GetdataActivation method.");
			 Reporter.log(e.getLocalizedMessage(), true);
		}
		return token;
	}

	public static void waitForSeconds(WebDriver driver, int timeSeconds) {
		driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
	}

	public static String extractInt(String str) {
		str = str.replaceAll("[^\\d]", " ");
		str = str.trim();
		str = str.replaceAll(" +", " ");
		str = str.replaceAll(" 9", " ");
		if (str.equals(""))
			return "-1";

		return str;
	}

}
