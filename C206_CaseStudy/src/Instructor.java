//Isaac
//sss
public class Instructor extends User{
	
	private String instructorName;
	private String assignedCourses;

	public Instructor(String instructorName, String username, String password) {
		super(username,password);
		this.instructorName = instructorName;
		this.assignedCourses = "";
	}
	public Instructor(String instructorName,String assignedCourses, String username, String password) {
		super(username,password);
		this.instructorName = instructorName;
		this.assignedCourses = assignedCourses;
	}
	public String getTeacherName() {
		return instructorName;
	}
	public String getAssignedCourses() {
		return assignedCourses;
	}
	public void setTeacherName(String instructorName) {
		this.instructorName = instructorName;
	}
	public void setAssignedCourses(String assignedCourses) {
		this.assignedCourses = assignedCourses;
	}
	public void showInstructorInfo() {
		System.out.println("Instructor Name: " + instructorName);
		//Assigned courses use in CaseStudy with courseList
	}
	
}
