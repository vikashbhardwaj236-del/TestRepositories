package in.dishtv.IB_CRM_D2h;

import org.testng.Reporter;
import org.testng.annotations.Test;

import in.dishtv.IB_CRM.IB_CRMVCProcess_Page;
import in.dishtv.library.BaseLibrary;

public class IB_CRMVCProcess_Test extends BaseLibrary {
	IB_CRMVCProcess_Page tempdeact = new IB_CRMVCProcess_Page();
	String Actual_Title;

	// verify Title of the CRM home page
	@Test(priority = 1, enabled = true)
	public void IB_CRM_Page_Navigation() {
		try {
			IB_CRMVCProcess_Page ChlNotFound = new IB_CRMVCProcess_Page();
			ChlNotFound.Pagenavigation();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// verify Fill Data into excel
	@Test(priority = 2, enabled = false)
	public void FillData() {
		try {
			IB_CRMVCProcess_Page ChlNotFound = new IB_CRMVCProcess_Page();
			// ChlNotFound.Filldata();

		} catch (Exception ex) {
			System.out.println("Issue in VC process !");
		}
	}

	// To verify renewal amount
	@Test(priority = 3, enabled = true)

	public void Ren_amt() {

		IB_CRMVCProcess_Page Renwamt = new IB_CRMVCProcess_Page();
		Renwamt.renewal_amt();

	}

	// To verify SOA value
	@Test(priority = 4, enabled = true)

	public void SOA_Amount() {

		IB_CRMVCProcess_Page soa_amount = new IB_CRMVCProcess_Page();
		soa_amount.soa();

	}

	// To verify Switch off date
	@Test(priority = 5, enabled = true)

	public void Swich_off_date() {

		IB_CRMVCProcess_Page date_switch = new IB_CRMVCProcess_Page();
		date_switch.Switch_off_date();

	}

	// To verify package window

	@Test(priority = 6, enabled = true)

	public void Pack_Name() {

		IB_CRMVCProcess_Page pack_name = new IB_CRMVCProcess_Page();
		pack_name.verify_package();

	}

}
