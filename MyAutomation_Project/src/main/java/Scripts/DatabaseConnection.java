package Scripts;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;

public class DatabaseConnection {

    private static  Connection con;
    private Statement stmt;

    // Fetch config values (no need to pass via constructor)
    private static String hostName = "DevDishV2n1Ln.dishtvindia-new.in"; // Correct server name
    private static String port = "21443"; // Correct port number
    private static String databaseName = "SMSdth2003"; // Replace with actual database name
    private static String userID = "Azureadmin"; // Replace with actual user ID
    private static String password = "dish@1234567"; // Replace with actual password
    private static String VCNo = "yourVCNumber"; // Replace with actual VC number
    private static String MobieNo = "yourMobileNumber"; // Replace with actual mobile number
    static ResultSet rs;

    // Constructor
    public DatabaseConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Build the database connection URL
            String url = "jdbc:sqlserver://" + hostName + ":" + port + ";databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true";
            System.out.println("Connecting to: " + url);
            con = DriverManager.getConnection(url, userID, password);
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            Reporter.log(e.getMessage(), true);
        }
    }

   
 

    // Main method for testing
    public static void main(String[] args) throws SQLException 
    {
        DatabaseConnection dbConn = new DatabaseConnection();
         System.out.println("Is connectin created or not ?");
         
        // Statement smt = con.createStatement();
        // ResultSet getVC = smt.executeQuery("Select top 1 vcno from SUBSCRIBERMASTER(NOLOCK) where vcno<> ' '");
        // System.out.println(getVC);
         
         Statement smt = con.createStatement();
         ResultSet getVC = smt.executeQuery("SELECT TOP 1 vcno FROM SUBSCRIBERMASTER WITH (NOLOCK) WHERE vcno <> ' '");

         if (getVC.next()) {  // Check if there is at least one result
             String vcno = getVC.getString("vcno");  // Retrieve vcno from the result set
             System.out.println("VC No: " + vcno);  // Print the VC No
         } else {
             System.out.println("No VC No found.");
         }
        
    }
    }




