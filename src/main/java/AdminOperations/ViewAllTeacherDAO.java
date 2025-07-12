package AdminOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.CourseBean;
import Bean.Teacher;
import DBConn.DBConnection;

public class ViewAllTeacherDAO {
	public ArrayList<Teacher> retrieve()

	{
		ArrayList<Teacher> al= new ArrayList<Teacher>();
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from teacherOLMS_with_id");
			ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	Teacher cb=new Teacher();
		    	cb.setId(rs.getInt(1));
		    	cb.setTeacherName(rs.getString(2));
		    	cb.setCourseName(rs.getString(3));
		    	cb.setLang(rs.getString(4));
		    	cb.setWorkExp(rs.getInt(5));
		    	al.add(cb);
		    }
		    
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
		
	}
}
