package AdminOperations;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteTeacher")
public class DeleteTeacherServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int int1 = Integer.parseInt(req.getParameter("teacherId"));
		try {
			int deleteTeacherById = new DeleteOperations().deleteTeacherById(int1);
			if(deleteTeacherById==0)
			{
				req.setAttribute("msg", "Teacher Not Deleted");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("msg", "Teacher Deleted Successfully");
				req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
