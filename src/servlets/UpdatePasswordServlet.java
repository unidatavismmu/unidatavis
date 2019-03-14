package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DAO;

public class UpdatePasswordServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println("Update Password: GET REQUEST");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Update Password: POST REQUEST");
		String user = null;
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		String newPassword = request.getParameter("newPassword");
		String currentPassword = request.getParameter("currentPassword");
		String confirmNewPassword = request.getParameter("confirmNewPassword");

		DAO dao = new DAO();
		try {
			user = dao.getUser(username, currentPassword);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		if (user != null) {
			try {			
				if (dao.getUser(username,currentPassword) != null) {
					if (newPassword.equals(confirmNewPassword)) {
						dao.updatePassword(username, newPassword);
						System.out.println(username + ": password updated");
					}else{
						System.out.println("Incorrect password");
					}
				}
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
