package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class to manage the results page.
 * 
 * @version 1.0
 * @author unidatavis
 */
public class ResultsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Manages the get request of the servlet and sets the page URL.
	 * 
	 * @param HttpServletRequest defines request to server
	 * @param HttpServletResponse gets the response from the server
	 * @throws ServletException, IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Sets the URL for the results page and forwards the request and response to the view (JSP page).
		RequestDispatcher view = req.getRequestDispatcher("results.jsp");
		view.forward(req, resp);
	}

}
