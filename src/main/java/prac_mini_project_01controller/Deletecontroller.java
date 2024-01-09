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

@WebServlet("/delete")
public class Deletecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Deletecontroller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		DAOService service = new DAOServiceImpl();
		service.connectDB();
		service.deleteBYEmail(email);

		ResultSet result = service.listAllreg();

		request.setAttribute("result", result);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/listall.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
