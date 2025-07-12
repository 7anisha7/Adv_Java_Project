package AdminOperations;

import java.io.IOException;

import Bean.CourseBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		CourseBean course=new CourseBean();
		course.setCid(req.getParameter("course_id"));
		course.setCname(req.getParameter("courseName"));
		course.setCduration(Integer.parseInt(req.getParameter("courseDuration")));
		course.setTeachName(req.getParameter("options"));
		course.setCfee(Double.parseDouble(req.getParameter("courseFee")));
		course.setRate(Double.parseDouble(req.getParameter("rate")));
		course.setDesc(req.getParameter("description"));
		course.setLang(req.getParameter("Languages"));
		course.setImage(req.getParameter("image"));
		
		if(!new AddCourseDAO().insert(course))
		{
			req.setAttribute("msg", "Unable to find it....");
			req.getRequestDispatcher("AddCourse.jsp").forward(req,res);
		}
		else
		{
			req.setAttribute("msg", "Course Added succefully");
			req.getRequestDispatcher("HomePage.jsp").forward(req, res);
		}
		
	}

}
