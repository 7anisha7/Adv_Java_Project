package AdminOperations;

import java.io.IOException;
import java.util.ArrayList;

import Bean.CourseBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/view")
public class ViewAllCourseServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	HttpSession hs=req.getSession(false);
	if(hs==null)
	{
		req.setAttribute("msg", "Session Expireed...<br>");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
		
	}else {
		ArrayList<CourseBean> al=new ViewAllCourseDAO().retrieve();
		if(!al.isEmpty()) {
			System.out.println(al.get(0).getCname());
				req.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllCourse.jsp").forward(req, res);
		}else {
			req.setAttribute("msg", "Data not found");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	
	}
	
}

}
