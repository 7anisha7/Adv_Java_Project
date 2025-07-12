package AdminOperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Bean.Teacher;
import DBConn.DBConnection;

public class TeacherDAO {
 
 public int addTeacher(Teacher teacher) {
   
     String sql = "INSERT INTO teacherOLMS_with_id (Teacher_ID, NAME, COURSE, LANGUAGE, WORK_EXP)\r\n"
     		+ "VALUES (teacher_id_seq.NEXTVAL, ?, ?, ?, ?)";

     int k=0;
     try {
    	 
    	 Connection con=DBConnection.getCon();
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, teacher.getTeacherName());
         ps.setString(2, teacher.getCourseName());
         ps.setString(3, teacher.getLang());
         ps.setInt( 4, teacher.getWorkExp());

          k=ps.executeUpdate();
		
         ps.close();
        
     } catch (Exception e) {
         e.printStackTrace();
     }
	return k;

     
 }
}
