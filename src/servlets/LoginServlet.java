package servlets;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import models.DAO;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println("Login: GET REQUEST");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login: POST REQUEST");
		String user = null;
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		DAO dao = new DAO();
		try {
			user = dao.getUser(uname, password);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			System.out.println("Logged in");
			HttpSession session = request.getSession();
			session.setAttribute("loggedin", true);
			session.setAttribute("username", user);
			Controller.loggedIn = true;
			response.sendRedirect("http://localhost:8080");
		} else {
			System.out.println("Failed to login");
			HttpSession session = request.getSession();
			session.setAttribute("error", "invalid credentials");
			doGet(request, response);
		}

	}
}