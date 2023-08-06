
public class Course {
	
	private String courseCode;
	private String courseTitle;
	private String courseInstructor;
	private String courseSchedule;
	
	
	public Course(String courseCode, String courseTitle, String courseInstructor, String courseSchedule) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.courseCode = courseCode;
		this.courseInstructor = courseInstructor;
		this.courseSchedule = courseSchedule;
		
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getCourseTitle() {
		return courseTitle;
	}


	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}


	public String getCourseInstructor() {
		return courseInstructor;
	}


	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}


	public String getCourseSchedule() {
		return courseSchedule;
	}


	public void setCourseSchedule(String courseSchedule) {
		this.courseSchedule = courseSchedule;
	}
	
	
}
