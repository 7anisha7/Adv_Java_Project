package AdminOperations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.AdminBean;
import DBConn.DBConnection;

public class AdminLoginDAO {

	AdminBean ab=null;
	public AdminBean verifyAdmin(String uname,String pass)
	{
		
		try {
			PreparedStatement st = DBConnection.getCon().prepareStatement("select * from adminOLMS where USERNAME=? and PASS=?");
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				ab=new AdminBean();
				ab.setUname(rs.getString(1));
				ab.setPword(rs.getString(2));
				ab.setEmail(rs.getString(3));
				ab.setPhone(rs.getLong(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ab;
		
	}
}
