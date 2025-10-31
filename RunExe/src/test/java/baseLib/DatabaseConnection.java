package baseLib;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;



public class DatabaseConnection {
	public java.sql.Connection con = null;
	java.sql.Statement stmt = null;
	String hostName;
	String databaseName;
	String userID;
	String password;

	public DatabaseConnection(String hostName, String userID, String password, String databasename) {
		this.hostName = hostName;
		this.userID = userID;
		this.password = password;
		this.databaseName = databasename;
		try {			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://" + hostName + ";" + "DatabaseName=" + databasename;
			con = DriverManager.getConnection(url, userID, password);
			stmt = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			//Reporter.log(e.getMessage(), true);
		}
	}

	public  ResultSet RunProc(String Strpoc, String value)
	{
		ResultSet result = null;
		try {
			String storedProc="{call stored_proc(?)}";
			Statement stmt =con.prepareStatement(storedProc);
			((CallableStatement) stmt).setString(1,Strpoc);
			stmt.execute(storedProc);
		}
		catch(Exception ex)
		{
			return result;
		}
		return result;
	}
	
	public ResultSet executeQuery(String query) {
		ResultSet result = null;
		try {
			  Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 
			result = stmt.executeQuery(query);
			return result;
			
		} catch (SQLException e) {
			//Reporter.log(e.getMessage(), true);
			return result;
		}
	}
	public ResultSet executeproc(String query) {
		ResultSet result = null;
		try {
			
			//query="execute usp_msg_node_1 '918776765765'";
			Statement cstmt = con.prepareCall(
	                    "{call usp_msg_node_1 '918776765765'}",
	                    ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
			
			result=stmt.executeQuery("call usp_msg_node_1 '918776765765'");
			
			//Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 result = stmt.executeQuery(query);
			return result;
			
		} catch (SQLException e) {
			//Reporter.log(e.getMessage(), true);
			return result;
		}
	}

	public int executeupdate(String query) {
		int data = 0;
		try {
			data = stmt.executeUpdate(query);
			return data;
		} catch (Exception e) {

			Reporter.log(e.getMessage(), true);
			return data;

		}

	}
	public boolean executeinsert(String query) {
		boolean data = false ;
		try {
		
			data=stmt.execute(query);
			return data;
		} catch (Exception e) {

			//Reporter.log(e.getMessage(), true);
			return data;

		}

	}
	

	
	public int executedelete(String query) {
        int data = 0;
        try {
            data = stmt.executeUpdate(query);
            return data;

        } catch (Exception e) {
            //Reporter.log(e.getMessage(), true);
            return data;
        }

   }

}
