package AdminOperations;

import java.io.IOException;
import java.io.PrintWriter;

import Bean.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

    Teacher t=new Teacher();
    
        String teacherName = request.getParameter("techerName"); // note: typo in HTML form
        String courseName = request.getParameter("courseName");
        String language = request.getParameter("options");
        int workExperience =Integer.parseInt(request.getParameter("WorkExperience"));
		t.setTeacherName(teacherName);
		t.setCourseName(courseName);
		t.setLang(language);
		t.setWorkExp(workExperience);
       int teacher = new TeacherDAO().addTeacher(t);
       if(teacher==0)
       {
    	   request.setAttribute("msg", "Unable to find it....");
    	   request.getRequestDispatcher("AddTeacher.jsp").forward(request,response);
       }
       else
       {
    	   request.setAttribute("msg", "Teacher Added succefully");
    	   request.getRequestDispatcher("HomePage.jsp").forward(request, response);
       }
    }
}

