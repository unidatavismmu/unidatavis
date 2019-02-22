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
		String query = "SELECT * FROM Universities ORDER BY university_name ASC";
		System.out.println(query);
		ArrayList<University> universities = new ArrayList<University>();
		try {
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			
			while(rs.next()) {	
				University uni = new University(rs.getInt("university_id"), rs.getInt("rank"), rs.getString("university_name"),
						rs.getInt("entry_standards"), rs.getFloat("student_satisfaction"), rs.getFloat("research_quality"), rs.getFloat("research_intensity"),
						rs.getFloat("graduate_prospects"), rs.getFloat("student_staff_ratio"), rs.getFloat("academic_services_spend"),
						rs.getInt("facilities_spend"), rs.getFloat("good_honours"), rs.getFloat("degree_completion"),
						rs.getInt("overall_score"));
								
				universities.add(uni);
				System.out.println(uni.getUniversity_name());
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