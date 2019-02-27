package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * DAO class specifies methods for interacting with the database.
 * 
 * @version 1.0
 * @author unidatavis
 *
 */
public class DAO {
	
	/**
	 * Gets the connection to the sqlite database.
	 * 
	 * @return Connection to the database
	 */
	private static Connection getConnection() {
		Connection c = null;
		try {
			// Sets the type of database.
			Class.forName("org.sqlite.JDBC");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			// Sets the URL of the database and connects.
			String url = "jdbc:sqlite:universities.db";
			c = DriverManager.getConnection(url);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
    }

	/**
	 * Method returns all universities in the database with no conditions.
	 * 
	 * @return Array of all universities
	 * @throws SQLException to catch query failure
	 */
	public static ArrayList<University> getAllUniversities() throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM Universities ORDER BY university_name ASC";
		System.out.println(query);
		
		// Define array list to store all universities.
		ArrayList<University> universities = new ArrayList<University>();
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				University uni = new University(rs.getInt("university_id"), rs.getInt("rank"), rs.getString("university_name"),
						rs.getInt("entry_standards"), rs.getFloat("student_satisfaction"), rs.getFloat("research_quality"), rs.getFloat("research_intensity"),
						rs.getFloat("graduate_prospects"), rs.getFloat("student_staff_ratio"), rs.getFloat("academic_services_spend"),
						rs.getInt("facilities_spend"), rs.getFloat("good_honours"), rs.getFloat("degree_completion"),
						rs.getInt("overall_score"));
						
				// Adds the university to the array and prints the name for debugging.
				universities.add(uni);
				System.out.println(uni.getUniversity_name());
			}
		} catch (SQLException e) {
			e.printStackTrace();
				
		} finally {
			// Closes result set, statement and connection.
			if (rs != null) {
				rs.close();
			}
			if (s != null) {
				s.close();
			}
			if (c != null) {
				c.close();
			}
		}
		// Returns final list of university objects.
		return universities;
	 }
	
	/**
	 * Method for returning all universities using a university name as a condition.
	 * 
	 * @return Array of all universities that contain the search query.
	 * @throws SQLException to catch query failure
	 */
	public static ArrayList<University> searchUniversities(String universityName) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM Universities WHERE university_name LIKE '%"+universityName+"%' ORDER BY university_name ASC";
		System.out.println(query);
		
		// Define array list to store all universities.
		ArrayList<University> universities = new ArrayList<University>();
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				University uni = new University(rs.getInt("university_id"), rs.getInt("rank"), rs.getString("university_name"),
						rs.getInt("entry_standards"), rs.getFloat("student_satisfaction"), rs.getFloat("research_quality"), rs.getFloat("research_intensity"),
						rs.getFloat("graduate_prospects"), rs.getFloat("student_staff_ratio"), rs.getFloat("academic_services_spend"),
						rs.getInt("facilities_spend"), rs.getFloat("good_honours"), rs.getFloat("degree_completion"),
						rs.getInt("overall_score"));
				
				// Adds the university to the array and prints the name for debugging.	
				universities.add(uni);
				System.out.println(uni.getUniversity_name());
			}
		} catch (SQLException e) {
			e.printStackTrace();
				
		} finally {
			// Closes result set, statement and connection.
			if (rs != null) {
				rs.close();
			}
			if (s != null) {
				s.close();
			}
			if (c != null) {
				c.close();
			}
		}

		// Returns final list of university objects.
		return universities;
	 }
}