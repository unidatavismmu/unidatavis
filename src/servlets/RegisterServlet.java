package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DAO;

public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object loggedin = session.getAttribute("loggedin");
		if (loggedin == null) {
			System.out.println("Not logged in");
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			RequestDispatcher view = request.getRequestDispatcher("/forbidden.jsp");
			view.forward(request, response);
		} else {
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			RequestDispatcher view = request.getRequestDispatcher("/register.jsp");
			view.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object loggedin = session.getAttribute("loggedin");
		if (loggedin == null) {
			System.out.println("Not loggedin");
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			RequestDispatcher view = request.getRequestDispatcher("/forbidden.jsp");
			view.forward(request, response);
		} else {
			DAO dao = new DAO();

			ArrayList<String> errors = new ArrayList<String>();
			HashMap<String, String> values = new HashMap<String, String>();

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			values.put("username", username);
			values.put("password", password);

			if (username.isEmpty()) {
				errors.add("username");
			}
			if (password.isEmpty()) {
				errors.add("password");
			}

			if (errors.size() != 0) {
				Set<String> errorSet = new HashSet<String>(errors);
				request.setAttribute("errors", errorSet);
				request.setAttribute("values", values);
				doGet(request, response);
			} else {
				boolean created;
				try {
					created = dao.insertUser(username,password);
				} catch (SQLException e) {
					e.printStackTrace();
					created = false;
				}

				if (created) {
					System.out.println("Success");
					response.sendRedirect("../");
				} else {
					System.out.println("Fail");
					doGet(request, response);
				}
			}
		}

	}
}
