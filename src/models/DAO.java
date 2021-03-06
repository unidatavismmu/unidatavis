package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			String url = "jdbc:sqlite:database.db";
			c = DriverManager.getConnection(url);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
    }
	
	/**
	 * Method updates user in the database
	 * 
	 * @param username
	 * @param password
	 * @param firstName
	 * @param secondName
	 * @param emailAddress
	 * @return true or false depending whether update was executed.
	 * @throws SQLException
	 */
	public Boolean updateUser(String username, String password, String firstName, String secondName, String emailAddress) throws SQLException {
		
		// Creates connection and prepared statement variables.
		Connection c = null;
		PreparedStatement ps = null;
		
		// Query to be run.
		String query = "UPDATE Users SET firstName=?, lastName=?, emailAddress=? WHERE username = ? AND password = ?";		
		
		try {
			// Sets the prepared statement and gets the connection.
			c = getConnection();
			System.out.println("Query: " + query);
			ps = c.prepareStatement(query);
			
			// Sets values for the prepared statement.
			ps.setString(1, firstName);
			ps.setString(2, secondName);
			ps.setString(3, emailAddress);
			ps.setString(4, username);
			ps.setString(5, password);
			
			// Executes the update and returns true if there are any rows in the database (data has been inserted).
			int rs = ps.executeUpdate();
			if (rs != 0) {
				return true;
			}
			
		} catch(Exception e) {
			
			// Returns false if the data has not been inserted.
			System.out.println(e.getMessage());
			return false;
			
		} finally {
			
			// Close variables.
			if(ps != null) {
				ps.close();
			}
			if(c != null) {
				c.close();
			}
		}
			
		return true;
	}
	
	public Boolean updatePassword(String username, String password) throws SQLException {
		
		// Creates connection and prepared statement variables.
		Connection c = null;
		PreparedStatement ps = null;
		
		// Query to be run.
		String query = "UPDATE Users SET password = ? WHERE username = ?";		
		
		try {
			// Sets the prepared statement and gets the connection.
			c = getConnection();
			System.out.println("Query: " + query);
			ps = c.prepareStatement(query);
			
			// Sets values for the prepared statement.
			ps.setString(1, password);
			ps.setString(2, username);
			
			// Executes the update and returns true if there are any rows in the database (data has been inserted).
			int rs = ps.executeUpdate();
			if (rs != 0) {
				return true;
			}
			
		} catch(Exception e) {
			
			// Returns false if the data has not been inserted.
			System.out.println(e.getMessage());
			return false;
			
		} finally {
			
			// Close variables.
			if(ps != null) {
				ps.close();
			}
			if(c != null) {
				c.close();
			}
		}
			
		return true;
	}
	
	/**
	 * Method used to insert a user to the database.
	 * 
	 * @param User object to insert
	 * @return Boolean depending on if the user has been inserted or not.
	 * @throws SQLException
	 */
	public Boolean insertUser(String username, String password, String firstName, String lastName, String emailAddress) throws SQLException {
		
		// Creates connection and prepared statement variables.
		Connection c = null;
		PreparedStatement ps = null;
		
		// Query to be run.
		String query = "INSERT INTO Users (username, password, firstName, lastName, emailAddress) "
				+ "VALUES (?,?,?,?,?)";		
		
		try {
			// Sets the prepared statement and gets the connection.
			c = getConnection();
			System.out.println("Query: " + query);
			ps = c.prepareStatement(query);
			
			// Sets values for the prepared statement.
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, emailAddress);
			
			// Executes the update and returns true if there are any rows in the database (data has been inserted).
			int rs = ps.executeUpdate();
			if (rs != 0) {
				return true;
			}
			
		} catch(Exception e) {
			
			// Returns false if the data has not been inserted.
			System.out.println(e.getMessage());
			return false;
			
		} finally {
			
			// Close variables.
			if(ps != null) {
				ps.close();
			}
			if(c != null) {
				c.close();
			}
		}
			
		return true;
	}
	
	public Boolean saveUni(String username, String uniName) throws SQLException {
		
		// Creates connection and prepared statement variables.
		Connection c = null;
		PreparedStatement ps = null;
		
		// Query to be run.
		String query = "INSERT INTO SavedUnis (username, uniName) "
				+ "VALUES (?,?)";		
		
		try {
			// Sets the prepared statement and gets the connection.
			c = getConnection();
			System.out.println("Query: " + query);
			ps = c.prepareStatement(query);
			
			// Sets values for the prepared statement.
			ps.setString(1, username);
			ps.setString(2, uniName);
			
			// Executes the update and returns true if there are any rows in the database (data has been inserted).
			int rs = ps.executeUpdate();
			if (rs != 0) {
				System.out.println("Uni saved: " + username + " " + uniName);
				return true;
			}
			
		} catch(Exception e) {
			
			// Returns false if the data has not been inserted.
			System.out.println(e.getMessage());
			return false;
			
		} finally {
			
			// Close variables.
			if(ps != null) {
				ps.close();
			}
			if(c != null) {
				c.close();
			}
		}
			
		return true;
	}
	
	public String getUser(String uname, String password) throws SQLException {

		String userName = null;
		Connection getConnection = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		String query = "SELECT * FROM Users WHERE username = ? AND password = ?;";
		
		try {
			getConnection = getConnection();
			statement = getConnection.prepareStatement(query);
			statement.setString(1, uname);
			statement.setString(2, password);
			System.out.println("Query: " + query);
			result = statement.executeQuery();

			while (result.next()) {
				userName = result.getString("username");
			}
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (getConnection != null) {
				getConnection.close();
			}
		}
		return userName;
	}
	
	public float getStudentSatisfaction(String uniName, String courseName) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM '" + courseName + "' WHERE \"University Name\" = '"+uniName+"'";
		System.out.println(query);
		
		float studentSatisfaction = 0;
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				studentSatisfaction = rs.getFloat("Student Satisfaction");
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
		return studentSatisfaction;
	 }
	
	public float getDegreeCompletion(String uniName) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM Universities WHERE \"University Name\" = '"+uniName+"'";
		System.out.println(query);
		
		float degreeCompletion = 0;
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				degreeCompletion = rs.getFloat("Degree Completion");
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
		return degreeCompletion;
	 }
	
	public float getGoodHonours(String uniName) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM Universities WHERE \"University Name\" = '"+uniName+"'";
		System.out.println(query);
		
		float goodHonours = 0;
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				goodHonours = rs.getFloat("Good Honours");
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
		return goodHonours;
	 }
	
	public float getEntryStandards(String uniName, String courseName) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM '" + courseName + "' WHERE \"University Name\" = '"+uniName+"'";
		System.out.println(query);
		
		float entryStandards = 0;
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				entryStandards = rs.getFloat("Entry Standards");
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
		return entryStandards;
	 }
	
	public float getAverageEntryStandards(String uniName, String courseName) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT AVG(\"Entry Standards\") AS \"Avg\" FROM '" + courseName + "'";
		System.out.println(query);
		
		float avgEntryStandards = 0;
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				avgEntryStandards = rs.getFloat("Avg");
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
		return avgEntryStandards;
	 }
	
	public float getResearchQuality(String uniName, String courseName) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM '" + courseName + "' WHERE \"University Name\" = '"+uniName+"'";
		System.out.println(query);
		
		float researchQuality = 0;
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				researchQuality = rs.getFloat("Research Quality");
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
		return researchQuality;
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
		String query = "SELECT * FROM Universities ORDER BY \"University Name\" ASC";
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
				University uni = new University(rs.getInt("University ID"), rs.getInt("Rank"), rs.getString("University Name"),
						rs.getInt("Entry Standards"), rs.getFloat("Student Satisfaction"), rs.getFloat("Research Quality"), rs.getFloat("Research Intensity"),
						rs.getFloat("Graduate Prospects"), rs.getFloat("Student-Staff Ratio"), rs.getFloat("Academic Services Spend"),
						rs.getInt("Facilities Spend"), rs.getFloat("Good Honours"), rs.getFloat("Degree Completion"),
						rs.getInt("Overall Score"));
						
				// Adds the university to the array and prints the name for debugging.
				universities.add(uni);
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
	
	
	public ArrayList<String> getAllUsernames() throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM Users";
		System.out.println(query);
		
		// Define array list to store all universities.
		ArrayList<String> usernames = new ArrayList<String>();
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				usernames.add(rs.getString("username"));
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
		return usernames;
	 }
	
	public int getUniID(String uniName) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM Universities WHERE \"University Name\"='"+uniName+"'";
		System.out.println(query);
		int uniID = 0;
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			if(rs.next()) {	
				uniID = rs.getInt("University ID");
				System.out.println("UniID returned: " + uniID);
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
		return uniID;
	 }
	
	public ArrayList<String> getAllSavedUnis(String username) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM SavedUnis WHERE username='"+username+"'";
		System.out.println(query);
		
		// Define array list to store all universities.
		ArrayList<String> unis = new ArrayList<String>();
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				unis.add(rs.getString("uniName"));
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
		return unis;
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
		String query = "SELECT * FROM Universities WHERE \"University Name\" LIKE '%"+universityName+"%' ORDER BY \"University Name\" ASC";
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
				University uni = new University(rs.getInt("University ID"), rs.getInt("Rank"), rs.getString("University Name"),
						rs.getInt("Entry Standards"), rs.getFloat("Student Satisfaction"), rs.getFloat("Research Quality"), rs.getFloat("Research Intensity"),
						rs.getFloat("Graduate Prospects"), rs.getFloat("Student-Staff Ratio"), rs.getFloat("Academic Services Spend"),
						rs.getInt("Facilities Spend"), rs.getFloat("Good Honours"), rs.getFloat("Degree Completion"),
						rs.getInt("Overall Score"));
				
				// Adds the university to the array and prints the name for debugging.	
				universities.add(uni);
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
	 * Method for returning all course names.
	 * 
	 * @return Array of all course names..
	 * @throws SQLException to catch query failure
	 */
	public static ArrayList<String> getAllCourseNames() throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM sqlite_master WHERE type='table' AND name !='Universities' AND name != 'SavedUnis' AND name != 'sqlite_sequence' AND name != 'Users'";
		System.out.println(query);
		
		ArrayList<String> courseNames = new ArrayList<String>();
				
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all table names and adds them to the array.
			while(rs.next()) {	
				courseNames.add(rs.getString("name"));
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

		// Prints final array.
		return courseNames;

	 }
	
	/**
	 * Method for returning all universities using a university name as a condition.
	 * 
	 * @return Array of all universities that contain the search query.
	 * @throws SQLException to catch query failure
	 */
	public static ArrayList<String> searchCourses(String courseName) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM sqlite_master WHERE type='table' AND name LIKE '%"+courseName+"%' AND name !='Universities' AND name != 'SavedUnis' AND name != 'sqlite_sequence' AND name != 'Users'";
		System.out.println(query);
		
		// Define array list to store all universities.
		ArrayList<String> courseNames = new ArrayList<String>();
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				courseNames.add(rs.getString("name"));
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
		return courseNames;
	 }
	
	public static String getDescription(String uniName) throws SQLException {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		String description = "";
		
			String query = "SELECT * FROM Universities WHERE \"University Name\"='" + uniName + "'";
			System.out.println(uniName);
			try {
				c = getConnection();
				s = c.createStatement();
				System.out.println("Query: " + query);
				rs = s.executeQuery(query);
	
				if (rs.next()) {
					description = rs.getString("Description");
					System.out.println(description);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			
		} finally {
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
		
		return description;
	}
	
	public static ArrayList<String> getAllCoursesOfferedByUni(int uniID) throws SQLException {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		ArrayList<String> courseNames = new ArrayList<String>();
		String courseName;
		
		for (int i=0;i<(getAllCourseNames().size())-4;i++) {
			courseName = getAllCourseNames().get(i);
		
			String query = "SELECT * FROM \"" + courseName + "\" WHERE \"University ID\"= " + uniID;
	
			try {
				c = getConnection();
				s = c.createStatement();
				System.out.println("Query: " + query);
				rs = s.executeQuery(query);
	
				while (rs.next()) {
					courseNames.add(courseName);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			
		} finally {
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
		}
		return courseNames;
	}
	
	public static University getUniByID(int uniID) throws SQLException {
		// Define connection, statement and result set variables to be used later.
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		// Query to be run. Printed for debugging.
		String query = "SELECT * FROM Universities WHERE \"University ID\" = '"+uniID+"'";
		System.out.println(query);
		
		University uni = null;
		
		try {
			// Gets the connection and executes the query using the string above.
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			// Loops through all rows in the result set and creates a new university object with all the data.
			while(rs.next()) {	
				uni = new University(rs.getInt("University ID"), rs.getInt("Rank"), rs.getString("University Name"),
						rs.getInt("Entry Standards"), rs.getFloat("Student Satisfaction"), rs.getFloat("Research Quality"), rs.getFloat("Research Intensity"),
						rs.getFloat("Graduate Prospects"), rs.getFloat("Student-Staff Ratio"), rs.getFloat("Academic Services Spend"),
						rs.getInt("Facilities Spend"), rs.getFloat("Good Honours"), rs.getFloat("Degree Completion"),
						rs.getInt("Overall Score"));
				
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
		return uni;
	 }
	
	public static ArrayList<University> getAllUnisThatOfferCourse(String courseName) throws SQLException {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		ArrayList<University> uniList = new ArrayList<University>();
		University uni;
		
		courseName = courseName.replaceAll("\\s+$", "");
		
			String query = "SELECT * FROM \"" + courseName + "\"";
	
			try {
				c = getConnection();
				s = c.createStatement();
				System.out.println("Query: " + query);
				rs = s.executeQuery(query);
	
				while (rs.next()) {
					int uniID = rs.getInt("University ID");
					uni = getUniByID(uniID);
					uniList.add(uni);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			
		} finally {
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
		
		return uniList;
	}
	
}
