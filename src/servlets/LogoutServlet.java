package servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class LogoutServlet extends HttpServlet {      

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {  
		HttpSession session = request.getSession();
		session.invalidate();   
		Controller.loggedIn = false;
		response.sendRedirect("http://localhost:8080");   
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		doGet(request, response);

	}    	
}