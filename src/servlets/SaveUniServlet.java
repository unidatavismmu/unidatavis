package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DAO;

public class SaveUniServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println("Save Uni: GET REQUEST");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uniName = request.getParameter("uniName");
		DAO dao = new DAO();
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		System.out.println(username + uniName);
		try {
			dao.saveUni(username, uniName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
