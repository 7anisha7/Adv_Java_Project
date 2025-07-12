package AdminOperations;

import java.io.IOException;

import Bean.AdminBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		AdminBean Admin = new AdminLoginDAO().verifyAdmin(uname, pass);
		
		if(Admin!=null)
		{
			req.setAttribute("ab", Admin);
			req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("msg", "Invalid credintioals");
			req.getRequestDispatcher("LoginAdmin.html").forward(req, resp);
		}
		
	}

}
