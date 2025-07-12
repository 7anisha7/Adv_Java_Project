package DBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection conn=null;
	static 
	{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			catch(Exception e)
			{
				
			}
	}
	public static Connection getCon()
	{
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anisha");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
