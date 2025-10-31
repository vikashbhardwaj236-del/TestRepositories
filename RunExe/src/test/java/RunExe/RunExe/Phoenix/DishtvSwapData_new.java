package RunExe.RunExe.Phoenix;

import baseLib.ExcelUtilities;

public class DishtvSwapData_new {
	public static String rowid = "";
	public static String StrSTBno = "";
	static String StrPath = "C:\\DishtvsSwap\\Swapping_Data.xlsx";
	static ExcelUtilities objexl = new ExcelUtilities(StrPath);
	static String StrSheet1 = "SwapData";
	static String StrSheet2 = "SQL";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		readfile();
	}

	public static void readfile() {

		try {
			String str = objexl.getCellData(StrSheet2, "SQL", 2);
			String strprocess = objexl.getCellData(StrSheet1, "Auto/Manual", 2);
			if (strprocess.toUpperCase().equalsIgnoreCase("MANUAL")) {

				int k = objexl.getRowCount(StrSheet1);
				for (int i = 2; i == k; i++) {

					//String str = objexl.getCellData(StrSheet2, "SQL", 2);

				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
