package prac_mini_project_01controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prac_mini_project_01Model.DAOService;
import prac_mini_project_01Model.DAOServiceImpl;

@WebServlet("/update")
public class Updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Updatecontroller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		DAOService service = new DAOServiceImpl();
		service.connectDB();
		
		service.updatreg(email, mobile);

		ResultSet result = service.listAllreg();

		request.setAttribute("result", result);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/listall.jsp");
		rd.forward(request, response);

	}

}
