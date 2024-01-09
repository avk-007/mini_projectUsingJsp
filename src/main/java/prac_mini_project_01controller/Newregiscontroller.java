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

@WebServlet("/savereg")
public class Newregiscontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Newregiscontroller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newreg.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
try {
	
	HttpSession session = request.getSession(false);
	if (session.getAttribute("email") != null) {

		String name   = request.getParameter("name");
		String city   = request.getParameter("city");
		String mobile = request.getParameter("mobile");
		String email  = request.getParameter("email");

		DAOService service = new DAOServiceImpl();
		service.connectDB();
		service.saveregistrations(name, city, mobile, email);

		request.setAttribute("msg", "record is saved");

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newreg.jsp");
		rd.forward(request, response);
	} else {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
} catch (Exception e) {
	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}
		
	}

}
