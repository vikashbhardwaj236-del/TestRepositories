package RunExe.RunExe.Phoenix;
import java.sql.ResultSet;

import baseLib.DatabaseConnection;
import baseLib.ExcelUtilities;

public class DishtvSwapdata {

	public static String rowid = "";
	public static String StrSTBno = "";
	static String StrPath = "C:\\DishtvsSwap\\Swapping_Data.xlsx";
	static ExcelUtilities objexl = new ExcelUtilities(StrPath);
	static String StrSwapdata = "SwapData";
	static String StrSQL = "SQL";
	static String StrSheetSwapver0 = "Swap-ver-0";
	static public String DTserverNode1 = "DEV-GRN-SQL1.dishtv-india.com:21443";
	static public String DTserverNode2 = "DEV-GRN-SQL2.dishtv-india.com:21444";
	static public String DTserverNode3 = "DEV-GRN-SQL3.dishtv-india.com:21445";
	static public String DTDBuserID = "vivek.kumar";
	static public String DTDBPass = "vivekkumar@2022";
	static public String DTDBPass1 = "vivekkumar@2022";
	static public String DT_India_DB = "DishtvIndia";
	static public String DT_India_SR_DB = "DISHTVINDIA_SRCRM";
	static public String DT_SMSDTH_DB = "SMSDTH2003";

	public static void main(String[] args) {
		try {

			Swappdata();
		} catch (Exception ex) {
		}
	}

	public static void Swappdata() {

		int Runstatus = 0;
		try {
			int coloumn = objexl.getColumnCount(StrSheetSwapver0);
			for (int j = 2; j <= coloumn; j++) {
				String RunStatus = objexl.getCellData(StrSheetSwapver0, "RunStatus", j);
				{
					if (RunStatus.toUpperCase().equalsIgnoreCase("yes")) {
						String strBrand = objexl.getCellData(StrSheetSwapver0, "Brand", j);
						String strBoxtype = objexl.getCellData(StrSheetSwapver0, "Box Type", j);
						String strservicerid = objexl.getCellData(StrSheetSwapver0, "Servicer ID", j);
						String strtechid = objexl.getCellData(StrSheetSwapver0, "Technicin ID", j);
						String stroldstb = objexl.getCellData(StrSheetSwapver0, "Old STB", j);
						if (strBrand.equalsIgnoreCase("Dishtv")) {
							DishtvBrand(strBrand, strBoxtype, strservicerid, strtechid, stroldstb,j);
						}
						if (strBrand.equalsIgnoreCase("D2h")) {
							D2hBrand();
						} else {
							System.out.println("Please select Brand");
						}

						
					}

				}
			}

		}

		catch (Exception ex) {
			System.out.println("Problem in Process..");
		}

	}

	public static void DishtvBrand(String strBrand, String strBoxtype, String strservicerid, String strtechid,
			String stroldstb, int iloop) {

		try {
			String Strstbverfiy = null;
			String StrNewSTB = null;
			DatabaseConnection Objconnode1 = new DatabaseConnection(DTserverNode1, DTDBuserID, DTDBPass, DT_SMSDTH_DB);
			ResultSet resultnode1 = Objconnode1
					.executeQuery("select stbno from Subscribermaster (NOLOCK) where stbno='" + stroldstb + "'");
			if (resultnode1.next()) {
				Strstbverfiy = resultnode1.getString("stbno");
				if (Strstbverfiy == null) {
					System.out.println("STB no is not correct.");
				} else {

					StrNewSTB = GetNewSTB(Strstbverfiy, strBoxtype,strservicerid,strtechid, stroldstb,iloop );
					Objconnode1.con.close();

				}
				 Objconnode1.con.close();
			}
			else
			{
				
				objexl.setCellData(StrSheetSwapver0, "Status / Remarks", iloop, "Issue- Old STB not  exists in Dishtv - " + stroldstb );
				Objconnode1.con.close();
			}
		} catch (Exception ex) {
			// Objconnode1.con.close();
			System.out.println("Problem in Process of DishtvBrand.");
		}

	}

	public static String GetNewSTB(String StrNewSTB, String strFresh,String strservicerid, String strtechid, String stroldstb, int iloop ) {

		try {
			String Strstbmodelrowid = null;
			String StrNewSTBno = null;
			int iBoxtype;
			int iservicerid;

			if (strFresh.toUpperCase().equalsIgnoreCase("FRESH")) {
				iBoxtype = 1;
			} else {
				iBoxtype = 0;
			}
			DatabaseConnection Objconnode2 = new DatabaseConnection(DTserverNode2, DTDBuserID, DTDBPass, DT_India_DB);
			ResultSet resultNode2 = Objconnode2.executeQuery(
					"select stbmodelrowid,* from dishtvindia..STBInfo(nolock) where stbno='" + stroldstb + "'");
			resultNode2.next();
			Strstbmodelrowid = resultNode2.getString("stbmodelrowid");
			ResultSet resultsetNewSTB = Objconnode2
					.executeQuery("select top 1  * from dishtvindia..stbinfo a(nolock)  where \r\n"
							+ " NOT EXISTS(Select 1 from subscribers where stbno=a.stbno) AND  locationtype in ('DC') and\r\n"
							+ " SwapBoxflag= " + iBoxtype + " and stbmodelrowid=" + Strstbmodelrowid + "");
			resultsetNewSTB.next();
			StrNewSTBno = resultsetNewSTB.getString("STBNo");
			StrNewSTBno=StrNewSTBno.trim();
			//--------------- Update STB to servicer ID 
			iservicerid=Integer.parseInt(strservicerid);
			Objconnode2.executeupdate("update dishtvindia..STBInfo set LocationID="+ iservicerid+", SwapBoxflag="+iBoxtype +", LocationType='DC' where STBNo='" + StrNewSTBno +"'"); 
			Objconnode2.executedelete("delete  from dishtvindia..mCFASTBRepairComplaintMaster where  OldSTBNo= '" + StrNewSTBno +"'"); 
			resultNode2.close();
			resultsetNewSTB.close();
			Objconnode2.con.close();
			
			
			MaterialassigntoTecnician(StrNewSTBno, strtechid, iloop);

		} catch (Exception ex) {
			System.out.println(ex+"Issue in Material assign to Servicer.");
		}
		return StrNewSTB;

	}
	
	public static void MaterialassigntoTecnician (String strnewSTB, String strtech, int iloop )
	{
		try
		{
			String Strserialno=null;
			DatabaseConnection Objconnode2 = new DatabaseConnection(DTserverNode2, DTDBuserID, DTDBPass, DT_India_SR_DB);
			ResultSet resultNode2 = Objconnode2.executeQuery(
					"select top 100 * from DISHTVINDIA_SRCRM..mspareIteminfo mi(nolock) where ItemCategory=1  order by CreatedON desc");
			resultNode2.next();
			Strserialno = resultNode2.getString("SerialNo");
			System.out.println(Strserialno);
			Objconnode2.executeupdate("update DISHTVINDIA_SRCRM..mspareIteminfo set SerialNo='"+ strnewSTB.trim()+"', Locationid="+strtech +"where SerialNo='" + Strserialno +"'and ItemCategory=1");
			System.out.println("New STB :- "+strnewSTB);
			objexl.setCellData(StrSheetSwapver0, "New STB", iloop, strnewSTB);
			objexl.setCellData(StrSheetSwapver0, "Status / Remarks", iloop, "New Swap STB generated successfully.");		
			
		}
		catch(Exception ex)
		{
			objexl.setCellData(StrSheetSwapver0, "Status / Remarks", iloop, "Issue - "+ex);
			System.out.println(ex + "Issue in Technician Material assign Process.");
		}
		
	}

	public static void D2hBrand() {

		try {

		} catch (Exception ex) {
			System.out.println("Problem in Process of D2hBrand.");
		}

	}
}
