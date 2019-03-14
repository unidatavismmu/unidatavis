package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DAO;

public class UpdateAccountServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println("Update Account: GET REQUEST");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Update: POST REQUEST");
		String user = null;
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		String firstName = request.getParameter("firstNameUpdate");
		String secondName = request.getParameter("secondNameUpdate");
		String password = request.getParameter("password");
		String emailAddress = request.getParameter("emailUpdate");

		DAO dao = new DAO();
		try {
			user = dao.getUser(username, password);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		if (user != null) {
			try {
				dao.updateUser(username, password, firstName, secondName, emailAddress);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("account.jsp");
		} else {
			response.sendRedirect("forbidden.jsp");
			System.out.println("Failed to update");
		}

	}

}
