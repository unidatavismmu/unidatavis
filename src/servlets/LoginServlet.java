package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.UniDAO;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Log in </h1>");
		out.println("<form action=\"Login\" method=\"post\" >");
		out.println("Enter username: <input type=\"text\" name=\"username\"> <br>");
		out.println(" Enter password: <input type=\"password\" name=\"password\"> <br>");
		out.println("<input type=\"submit\" value=\"Login\">");
		out.println("</form>");
		out.println("<a href=\"http://localhost:8080/\">home</a>");
		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = null;
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		UniDAO dao = new UniDAO();
		try {
			user = dao.getUser(uname, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (user != null) {
			System.out.println("Sucess");
			HttpSession session = request.getSession();
			session.setAttribute("loggedin", true);
			session.setAttribute("username", user);
			response.sendRedirect("http://localhost:8080");
		} else {
			System.out.println("Fail");
			HttpSession session = request.getSession();
			session.setAttribute("error", "invalid credentials");
			doGet(request, response);
		}

	}
}