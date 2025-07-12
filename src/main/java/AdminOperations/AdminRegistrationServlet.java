package AdminOperations;

import java.io.IOException;

import Bean.AdminBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminRegistrationServlet extends HttpServlet{

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		AdminBean ab=new AdminBean();
		ab.setUname(req.getParameter("uname"));
		ab.setPword(req.getParameter("pass"));
		ab.setEmail(req.getParameter("email"));
		ab.setPhone(Long.parseLong(req.getParameter("phone")));
		
		
		if(!new AdminRegistrationDAO().registerAdmin(ab))
		{
			req.setAttribute("msg", "Login Failed");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs=req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("LoginAdmin.html").forward(req, res);
		}
		
	}
	
}
