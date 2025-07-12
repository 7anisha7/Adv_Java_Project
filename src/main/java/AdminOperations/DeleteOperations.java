package AdminOperations;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBConn.DBConnection;

public class DeleteOperations 
{
 public int deleteTeacherById(int teacherId) throws SQLException
 {
	 PreparedStatement ps=DBConnection.getCon().prepareStatement("delete from teacherOLMS_with_id where Teacher_ID=?");
	 ps.setInt(1, teacherId);
	 
	 return ps.executeUpdate();
 }
 public int deleteCourseById(String courseId) throws SQLException
 {
	 PreparedStatement ps=DBConnection.getCon().prepareStatement("delete from courseOLMS where Course_id=?");
	 ps.setString(1, courseId);
	 
	 return ps.executeUpdate();
 }
}
