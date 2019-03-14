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

import controller.Controller;
import models.DAO;

public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println("Register: GET REQUEST");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (Controller.loggedIn == true) {
			System.out.println("Already Logged in");
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
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String emailAddress = request.getParameter("emailAddress");


			values.put("username", username);
			values.put("password", password);
			values.put("firstName", firstName);
			values.put("lastName", lastName);
			values.put("emailAddress", emailAddress);


			if (username.isEmpty()) {
				errors.add("username");
			}
			if (password.isEmpty()) {
				errors.add("password");
			}
			if (firstName.isEmpty()) {
				errors.add("firstName");
			}
			if (lastName.isEmpty()) {
				errors.add("lastName");
			}
			if (emailAddress.isEmpty()) {
				errors.add("emailAddress");
			}

			if (errors.size() != 0) {
				Set<String> errorSet = new HashSet<String>(errors);
				request.setAttribute("errors", errorSet);
				request.setAttribute("values", values);
				doGet(request, response);
			} else {
				boolean created;
				try {
					created = dao.insertUser(username,password,firstName,lastName,emailAddress);
					created = true;
				} catch (SQLException e) {
					e.printStackTrace();
					created = false;
				}

				if (created) {
					System.out.println("Success");
					response.sendRedirect("http://localhost:8080");
				} else {
					System.out.println("Fail");
					doGet(request, response);
				}
			}
		}

	}
}
