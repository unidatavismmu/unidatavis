package controller;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 
 * The Controller class controls the creation of the web server and handles servlets.
 * 
 * @version 1.0
 * @author unidatavis
 *
 */
public class Controller {

		/**
		 * Main method of the program, creates server and instantiates servlets.
		 * 
		 * @param args
		 * @throws Exception which handles server creation failure
		 */
		public static void main(String[] args) throws Exception {
			// Creates a new server and sets the context path to the webapp folder.
			Server server = new Server(8080);
			WebAppContext ctx = new WebAppContext();
			ctx.setResourceBase("webapp");
			ctx.setContextPath("/");
			
			// Sets jetty configuration.
			Configure(server); 
			
			// Adds servlets used on the website.
			ctx.addServlet("ResultsServlet", "/results");
			ctx.addServlet("UniversitiesServlet", "/universities");
			ctx.addServlet("CoursesServlet", "/courses");
			
			// Sets the handler and starts the server.
			server.setHandler(ctx); 
			server.start();
			server.join();
		}
		
		/**
		 * Method sets configuration paths for the jetty server.
		 * 
		 * @param server created in the main method.
		 */
		private static void Configure(Server server) {
			org.eclipse.jetty.webapp.Configuration.ClassList classlist =
			org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(server);
			classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration",
			"org.eclipse.jetty.plus.webapp.EnvConfiguration",
			"org.eclipse.jetty.plus.webapp.PlusConfiguration");
			classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
			"org.eclipse.jetty.annotations.AnnotationConfiguration");
		}
	
}