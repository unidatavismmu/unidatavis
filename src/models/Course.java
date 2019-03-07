package models;

/**
 * Model class for the courses.
 * 
 * @version 1.0
 * @author unidatavis
 */
public class Course {
	
	// Defines private variables.
	private int university_id;
	private int rank;
	private String university_name;
	private int entry_standards;
	private float student_satisfaction;
	private float research_quality;
	private float research_intensity;
	private float graduate_prospects;
	private int overall_score;
	
	// Constructor sets private variables.
	public Course(int university_id, int rank, String university_name, int entry_standards, float student_satisfaction,
			float research_quality, float research_intensity, float graduate_prospects, int overall_score) {
		this.university_id = university_id;
		this.rank = rank;
		this.university_name = university_name;
		this.entry_standards = entry_standards;
		this.student_satisfaction = student_satisfaction;
		this.research_quality = research_quality;
		this.research_intensity = research_intensity;
		this.graduate_prospects = graduate_prospects;
		this.overall_score = overall_score;
	}
	
	// Getters and setters for each variable.
	public int getUniversity_id() {
		return university_id;
	}

	public void setUniversity_id(int university_id) {
		this.university_id = university_id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	public int getEntry_standards() {
		return entry_standards;
	}

	public void setEntry_standards(int entry_standards) {
		this.entry_standards = entry_standards;
	}

	public float getStudent_satisfaction() {
		return student_satisfaction;
	}

	public void setStudent_satisfaction(float student_satisfaction) {
		this.student_satisfaction = student_satisfaction;
	}

	public float getResearch_quality() {
		return research_quality;
	}

	public void setResearch_quality(float research_quality) {
		this.research_quality = research_quality;
	}

	public float getResearch_intensity() {
		return research_intensity;
	}

	public void setResearch_intensity(float research_intensity) {
		this.research_intensity = research_intensity;
	}

	public float getGraduate_prospects() {
		return graduate_prospects;
	}

	public void setGraduate_prospects(float graduate_prospects) {
		this.graduate_prospects = graduate_prospects;
	}

	public int getOverall_score() {
		return overall_score;
	}

	public void setOverall_score(int overall_score) {
		this.overall_score = overall_score;
	}

}
