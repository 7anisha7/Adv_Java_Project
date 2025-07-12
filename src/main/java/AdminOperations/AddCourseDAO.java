package AdminOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bean.CourseBean;
import DBConn.DBConnection;

public class AddCourseDAO {

	 public boolean insert(CourseBean cb)
	  {
		  boolean status=false;
		  try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection conn=DBConnection.getCon();
			 PreparedStatement  ps= conn.prepareStatement("insert into courseOLMS values(?,?,?,?,?,?,?,?,?)");
			 ps.setString(1, cb.getCid());
			 ps.setString(2, cb.getCname());
			 ps.setInt(3, cb.getCduration());
			 ps.setDouble(4, cb.getCfee());
			 ps.setDouble(5, cb.getRate());
			 ps.setString(6, cb.getTeachName());
			 ps.setString(7, cb.getLang());
			 ps.setString(8, cb.getDesc());
			 ps.setString(9, cb.getImage());
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
