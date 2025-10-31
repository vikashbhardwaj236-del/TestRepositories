package in.dishtv.Activation;

import org.testng.Reporter;
import org.testng.annotations.Test;
import in.dishtv.library.BaseLibrary;

/**
 * @author vivek.kumar
 *
 */
public class Phoenix_Activation_Test extends BaseLibrary {

	Phoenix_Activation_Page comman_obj = new Phoenix_Activation_Page();

	// TO PERFROM NEGATIVE TESTING IN ACTIVATION MODULE
	@Test(priority = 1, enabled = true)
	public void Dealer_Login() {
		try {
			Phoenix_Activation_Page obj = new Phoenix_Activation_Page();
			obj.Dealerlogin();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// TO PERFROM NEGATIVE TESTING IN ACTIVATION MODULE
	@Test(priority = 2, enabled = false)
	public void TokenSearch() {
		try {
			Phoenix_Activation_Page obj = new Phoenix_Activation_Page();
			obj.ToeknSearch();

			obj.MAX_length_validation();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// TO PERFROM NEGATIVE TESTING IN ACTIVATION MODULE
	@Test(priority = 2, enabled = false)
	public void Negative_Search() {
		try {
			Phoenix_Activation_Page obj = new Phoenix_Activation_Page();
			obj.validate_BasicDetails();
			// obj.Validate_nonStopcheckbox();
			obj.MAX_length_validation();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// TO PERFOM CALL SCHEDULE
	@Test(priority = 3, enabled = true)
	public void Phoenix_call_Schedule() {
		try {
			Phoenix_Activation_Page obj = new Phoenix_Activation_Page();
			obj.Phoenix_callschudule();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	// TO PEROFM MULTI AND INDIVIDUAL ACTIVATION
	@Test(priority = 4, enabled = true)
	public void Phoenix_Activation() {
		try {
			Phoenix_Activation_Page obj = new Phoenix_Activation_Page();
			obj.Phoenix_activation();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

}
