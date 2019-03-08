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

public class AddServlet extends HttpServlet {
	// to do - user authentication
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object loggedin = session.getAttribute("loggedin");
		if (loggedin == null) {
			System.out.println("Not loggedin");
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			RequestDispatcher view = request.getRequestDispatcher("/jsp/forbidden.jsp");
			view.forward(request, response);
		} else {
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			RequestDispatcher view = request.getRequestDispatcher("/jsp/add.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object loggedin = session.getAttribute("loggedin");
		if (loggedin == null) {
			System.out.println("Not loggedin");
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			RequestDispatcher view = request.getRequestDispatcher("/jsp/forbidden.jsp");
			view.forward(request, response);
		} else {
			DAO dao = new DAO();

			ArrayList<String> errors = new ArrayList<String>();
			HashMap<String, String> values = new HashMap<String, String>();

			String make = request.getParameter("make");
			String model = request.getParameter("model");
			String year = request.getParameter("year");
			String price = request.getParameter("price");
			String license_number = request.getParameter("license_number");
			String colour = request.getParameter("colour");
			String number_doors = request.getParameter("number_doors");
			String transmission = request.getParameter("transmission");
			String mileage = request.getParameter("mileage");
			String fuel_type = request.getParameter("fuel_type");
			String engine_size = request.getParameter("engine_size");
			String body_style = request.getParameter("body_style");
			String condition = request.getParameter("condition");
			String notes = request.getParameter("notes");

			values.put("make", make);
			values.put("model", model);
			values.put("year", year);
			values.put("price", price);
			values.put("license_number", license_number);
			values.put("colour", colour);
			values.put("number_doors", number_doors);
			values.put("transmission", transmission);
			values.put("mileage", mileage);
			values.put("fuel_type", fuel_type);
			values.put("engine_size", engine_size);
			values.put("body_style", body_style);
			values.put("condition", condition);
			values.put("notes", notes);

			if (make.isEmpty()) {
				errors.add("make");
			}
			if (model.isEmpty()) {
				errors.add("model");
			}
			if (year.isEmpty()) {
				errors.add("year");
			}
			if (price.isEmpty()) {
				errors.add("price");
			}
			if (license_number.isEmpty()) {
				errors.add("license_number");
			}
			if (colour.isEmpty()) {
				errors.add("colour");
			}
			if (number_doors.isEmpty()) {
				errors.add("number_doors");
			}
			if (transmission.isEmpty()) {
				errors.add("transmission");
			}
			if (mileage.isEmpty()) {
				errors.add("mileage");
			}
			if (fuel_type.isEmpty()) {
				errors.add("fuel_type");
			}
			if (engine_size.isEmpty()) {
				errors.add("engine_size");
			}
			if (body_style.isEmpty()) {
				errors.add("body_style");
			}
			if (condition.isEmpty()) {
				errors.add("condition");
			}

			if (errors.size() != 0) {
				Set<String> errorSet = new HashSet<String>(errors);
				request.setAttribute("errors", errorSet);
				request.setAttribute("values", values);
				doGet(request, response);
			} else {
				boolean created;
				try {
					int newVehicle_id = dao.getLatestVehicle_id() + 1;
					Vehicle vehicle = new Vehicle(newVehicle_id, make, model, Integer.parseInt(year),
							Integer.parseInt(price), license_number, colour, Integer.parseInt(number_doors),
							transmission, Integer.parseInt(mileage), fuel_type, Integer.parseInt(engine_size),
							body_style, condition, notes);
					created = dao.insertVehicle(vehicle);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					created = false;
				}

				if (created) {
					// Dashboard
					System.out.println("Sucess");
					response.sendRedirect("http://localhost:8080/");
				} else {
					System.out.println("Fail");
					doGet(request, response);
				}
			}
		}
//		System.out.println(make);
//		//vehicle.setMake(make);

	}
}
