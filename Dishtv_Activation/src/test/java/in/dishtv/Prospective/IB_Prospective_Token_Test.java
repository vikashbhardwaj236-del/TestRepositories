/*
 * package in.dishtv.Prospective;
 * 
 * import org.testng.Reporter; import org.testng.annotations.Test; import
 * in.dishtv.library.BaseLibrary;
 * 
 * public class IB_Prospective_Token_Test extends BaseLibrary {
 * IB_Prospective_Token_Page tempdeact = new IB_Prospective_Token_Page(); String
 * Actual_Title;
 * 
 * // verify Title of the CRM home page
 * 
 * @Test(priority = 1, enabled = true) public void IB_CRM_Page_Navigation() {
 * try { IB_Prospective_Token_Page IB_Prospective = new
 * IB_Prospective_Token_Page(); IB_Prospective.Pagenavigation(); } catch
 * (Exception e) { System.out.println(e.getMessage());
 * Reporter.log(e.getLocalizedMessage(), true); } } // verify propsective page
 * is opening
 * 
 * @Test(priority = 2, enabled = true) public void
 * IB_Open_propsective_Tokenpage() { try { IB_Prospective_Token_Page
 * IB_Prospective = new IB_Prospective_Token_Page();
 * IB_Prospective.IB_Open_propsective_Token_Page(); } catch (Exception e) {
 * System.out.println(e.getMessage()); Reporter.log(e.getLocalizedMessage(),
 * true); } }
 * 
 * // verify propsective page is opening
 * 
 * @Test(priority = 3, enabled = true) public void
 * propsective_Tokenpage_Scenario() { try { IB_Prospective_Token_Page
 * IB_Prospective = new IB_Prospective_Token_Page();
 * IB_Prospective.TokenFieldvaldiation(); } catch (Exception e) {
 * System.out.println(e.getMessage()); Reporter.log(e.getLocalizedMessage(),
 * true); } } // verify propsective Generate Token
 * 
 * @Test(priority = 4, enabled = true) public void Generate_propsective_Token()
 * { try { IB_Prospective_Token_Page IB_Prospective = new
 * IB_Prospective_Token_Page();
 * IB_Prospective.Generate_propsective_Token_Page(); } catch (Exception e) {
 * System.out.println(e.getMessage()); Reporter.log(e.getLocalizedMessage(),
 * true); } }
 * 
 * }
 */