package in.dishtv.Activation;

import org.testng.Reporter;
import org.testng.annotations.Test;
import in.dishtv.library.BaseLibrary;

/**
 * @author vivek.kumar
 *
 */
public class D2h_Installation_IB_Test extends BaseLibrary {

	D2h_Installation_IB_Page comman_obj = new D2h_Installation_IB_Page();

	// To validate check Title
	@Test(priority = 1, enabled = true)
	public void check_title() {
		try {

			
			D2h_Installation_IB_Page obj = new D2h_Installation_IB_Page();
			obj.check_title();

		} catch (Exception e) {
			System.out.println("Issue in check_title  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// To Count Run Status
	@Test(priority = 2, enabled = false)
	public void countRunstatus() {
		try {

			D2h_Installation_IB_Page obj = new D2h_Installation_IB_Page();
			obj.countRunstatus();

		} catch (Exception e) {
			System.out.println("Issue in check_title  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// To Perform to get data in database and validate, then write to Excel
	@Test(priority = 3, enabled = false)
	public void WriteExel() {
		try {

			D2h_Installation_IB_Page obj = new D2h_Installation_IB_Page();
			obj.writedata_In_Excel();

		} catch (Exception e) {
			System.out.println("Issue in check_title  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// To process Installation process Phoenix
	@Test(priority = 4, enabled = true)
	public void Phoenix_Installation_Procss() {
		try {

			D2h_Installation_IB_Page obj = new D2h_Installation_IB_Page();
			obj.mousehover();

		} catch (Exception e) {
			System.out.println("Issue in InstallationProcss method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	@Test(priority = 6, enabled = false)
	public void WriteActivation_Data() {
		try {

			D2h_Installation_IB_Page obj = new D2h_Installation_IB_Page();
			obj.ActivationWritedata();

		} catch (Exception e) {
			System.out.println("Issue in InstallationProcss method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

}
