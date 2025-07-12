package AdminOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Bean.AdminBean;
import DBConn.DBConnection;

public class AdminRegistrationDAO {

  private static final String INSERT_SQL="INSERT INTO adminOLMS(USERNAME,PASS,EMAIL,MOB) values(?,?,?,?)";
  public boolean registerAdmin(AdminBean ab)
  {
	  boolean status=false;
	  try {
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection conn=DBConnection.getCon();
		 PreparedStatement  ps= conn.prepareStatement(INSERT_SQL);
		 ps.setString(1, ab.getUname());
		 ps.setString(2, ab.getPword());
		 ps.setString(3, ab.getEmail());
		 ps.setLong(4, ab.getPhone());
		 
		 int k=ps.executeUpdate();
		 if(k>0)
		 {
			 status=true;
			 
		 }
		 ps.close();
		 conn.close();
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return status;
  }
}
