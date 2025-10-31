package in.dishtv.Activation;

import org.testng.Reporter;
import org.testng.annotations.Test;
import in.dishtv.library.BaseLibrary;

/**
 * @author vivek.kumar
 *
 */
public class D2hAddcustomer_Test extends BaseLibrary {

	D2hAddcustomer_Page comman_obj = new D2hAddcustomer_Page();

	// To validate check Title
	@Test(priority = 1, enabled = true)
	public void Add_Cust_Normal_URL() {
		try {

			D2hAddcustomer_Page obj = new D2hAddcustomer_Page();
			obj.OpenURL();

		} catch (Exception e) {
			System.out.println("Issue in check_title  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
		
	}

	// To Count Run Status
	@Test(priority = 2, enabled = true)
	public void Add_Cust_Normal() {
		try {

			D2hAddcustomer_Page obj = new D2hAddcustomer_Page();
			obj.AddCustomer();

		} catch (Exception e) {
			System.out.println("Issue in check_title  method.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}


}
