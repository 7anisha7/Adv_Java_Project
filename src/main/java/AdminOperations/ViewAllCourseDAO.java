package AdminOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.CourseBean;
import DBConn.DBConnection;

public class ViewAllCourseDAO {

public ArrayList<CourseBean> retrieve()

{
	ArrayList<CourseBean> al= new ArrayList<CourseBean>();
	try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("select * from courseOLMS");
		ResultSet rs=ps.executeQuery();
	    while(rs.next())
	    {
	    	CourseBean cb=new CourseBean();
	    	cb.setCid(rs.getString(1));
	    	cb.setCname(rs.getString(2));
	    	cb.setCduration(rs.getInt(3));
	    	cb.setCfee(rs.getDouble(4));
	    	cb.setRate(rs.getDouble(5));
	    	cb.setTeachName(rs.getString(6));
	    	cb.setLang(rs.getString(7));
	    	cb.setDesc(rs.getString(8));
	    	al.add(cb);
	    }
	    
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return al;
	
}
}
