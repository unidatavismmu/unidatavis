package controller;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Controller {

		public static void main(String[] args) throws Exception {
			Server server = new Server(8080);
			WebAppContext ctx = new WebAppContext();
			ctx.setResourceBase("webapp");
			ctx.setContextPath("/start");
			Configure(server); 
			ctx.addServlet("UniversitiesServlet", "/universities");
			server.setHandler(ctx); 
			server.start();
			server.join();
		}
		
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
