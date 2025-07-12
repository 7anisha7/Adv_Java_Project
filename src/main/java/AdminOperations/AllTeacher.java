package AdminOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Teacher;
import DBConn.DBConnection;

public class AllTeacher {

	public ArrayList<Teacher> getAllTeacher()
	{
		ArrayList<Teacher>al=new ArrayList<Teacher>();
		
		Connection conn=DBConnection.getCon();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from teacherOLMS_with_id");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Teacher t=new Teacher();
				t.setId(rs.getInt(1));
				t.setTeacherName(rs.getString(2));
				t.setCourseName(rs.getString(3));
				t.setLang(rs.getString(4));
				t.setWorkExp(((int)rs.getLong(5)));
				al.add(t);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return al;
	}
}
