package AdminOperations;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deleteCourse")
public class DeleteCourseServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String courseId=req.getParameter("cid");
	try {
		int deleteCourseById= new DeleteOperations().deleteCourseById(courseId);
		if(deleteCourseById==0)
		{
			req.setAttribute("msg", "Course Not Deleted");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Course Deleted Successfully");
			req.getRequestDispatcher("HomePage.jsp").forward(req, res);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
