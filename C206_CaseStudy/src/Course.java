
public class Course extends Fee {
	
	private String courseCode;
	private String courseTitle;
	private String courseInstructor;
	private String courseSchedule;
	private boolean isAvailable;
	
	
	public Course(String courseCode, String courseTitle, String courseInstructor, String courseSchedule) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.courseInstructor = courseInstructor;
		this.courseSchedule = courseSchedule;
		this.isAvailable = true;
		
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
	
	public String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	
}
