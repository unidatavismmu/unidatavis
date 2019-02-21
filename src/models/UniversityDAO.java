package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UniversityDAO {
	
	private static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			String url = "jdbc:sqlite:universities.db";
			c = DriverManager.getConnection(url);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
    }

	public static ArrayList<University> getAll() throws SQLException {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		String query = "SELECT * FROM Universities";
		ArrayList<University> universities = new ArrayList<University>();
		try {
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			while(rs.next()) {	
				University uni = new University(rs.getInt("University ID"), rs.getInt("Rank"), rs.getString("University Name"),
						rs.getInt("Entry Standards"), rs.getFloat("Student Satisfaction"), rs.getFloat("Research Quality"), rs.getFloat("Research Intensity"),
						rs.getFloat("Graduate Prospects"), rs.getFloat("Student-Staff Ratio"), rs.getFloat("Academic Services Spend"),
						rs.getInt("Facilities Spend"), rs.getFloat("Good Honours"), rs.getFloat("Degree Completion"),
						rs.getInt("Overall Score"));
								
				universities.add(uni);
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

		return universities;
	 }
}