package prac_mini_project_01controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prac_mini_project_01Model.DAOService;
import prac_mini_project_01Model.DAOServiceImpl;


@WebServlet("/verifylogin")
public class Newlogincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Newlogincontroller() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		DAOService service=new DAOServiceImpl();
		service.connectDB();


		boolean status=service.verifycredentials(email, password);
		//either stay or go to login pG  or go to new rg
		if(status==true) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			session.setMaxInactiveInterval(15);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newreg.jsp");
			rd.forward(request, response);
			
		}else {
		request.setAttribute("error", "invalid username/password");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);



		}
		
	} catch (Exception e) {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	
	}

}
