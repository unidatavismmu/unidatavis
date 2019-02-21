package models;

public class University {

	private int university_id;
	private int rank;
	private String university_name;
	private int entry_standards;
	private float student_satisfaction;
	private float research_quality;
	private float research_intensity;
	private float graduate_prospects;
	private float student_staff_ratio;
	private float academic_services_spend;
	private int facilities_spend;
	private float good_honours;
	private float degree_completion;
	private int overall_score;
	
	public University(int university_id, int rank, String university_name,
			int entry_standards, float student_satisfaction, float research_quality, float research_intensity,
			float graduate_prospects, float student_staff_ratio, float academic_services_spend,
			int facilities_spend, float good_honours, float degree_completion, int overall_score) {
		this.university_id = university_id;
		this.rank = rank;
		this.university_name = university_name;
		this.entry_standards = entry_standards;
		this.student_satisfaction = student_satisfaction;
		this.research_quality = research_quality;
		this.research_intensity = research_intensity;
		this.graduate_prospects = graduate_prospects;
		this.student_staff_ratio = student_staff_ratio;
		this.academic_services_spend = academic_services_spend;
		this.facilities_spend = facilities_spend;
		this.good_honours = good_honours;
		this.degree_completion = degree_completion;
		this.overall_score = overall_score;
	}
	
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

	public float getGraduate_prospects() {
		return graduate_prospects;
	}

	public void setGraduate_prospects(float graduate_prospects) {
		this.graduate_prospects = graduate_prospects;
	}

	public float getStudent_staff_ratio() {
		return student_staff_ratio;
	}

	public void setStudent_staff_ratio(float student_staff_ratio) {
		this.student_staff_ratio = student_staff_ratio;
	}

	public float getAcademic_services_spend() {
		return academic_services_spend;
	}

	public void setAcademic_services_spend(float academic_services_spend) {
		this.academic_services_spend = academic_services_spend;
	}

	public int getFacilities_spend() {
		return facilities_spend;
	}

	public void setFacilities_spend(int facilities_spend) {
		this.facilities_spend = facilities_spend;
	}

	public float getGood_honours() {
		return good_honours;
	}

	public void setGood_honours(float good_honours) {
		this.good_honours = good_honours;
	}

	public float getDegree_completion() {
		return degree_completion;
	}

	public void setDegree_completion(float degree_completion) {
		this.degree_completion = degree_completion;
	}

	public int getOverall_score() {
		return overall_score;
	}

	public void setOverall_score(int overall_score) {
		this.overall_score = overall_score;
	}

	public float getResearch_intensity() {
		return research_intensity;
	}

	public void setResearch_intensity(float research_intensity) {
		this.research_intensity = research_intensity;
	}
	

}
