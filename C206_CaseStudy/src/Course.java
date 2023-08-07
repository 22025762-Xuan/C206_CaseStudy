//Asfar
//Achi - fee

public class Course{
	
	private String courseCode;
	private String courseTitle;
	private String courseInstructor;
	private String courseSchedule;
	private boolean isAvailable;
	private double fee;
	
	public Course(String courseCode, String courseTitle, String courseInstructor, String courseSchedule) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.courseInstructor = courseInstructor;
		this.courseSchedule = courseSchedule;
		this.isAvailable = true;
		this.fee = 0.00;
	}
	public Course(String courseCode, String courseTitle, String courseInstructor, String courseSchedule,double fee) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.courseInstructor = courseInstructor;
		this.courseSchedule = courseSchedule;
		this.isAvailable = true;
		this.fee = fee;
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
	public void setFee(double fee) {
		this.fee = fee;
	}
	public double getFee() {
		return fee;
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
	public String toString() {
		String courseInfo;
		if(fee == 0) {
			courseInfo = String.format("%-10s %-30s %-20s %-10s %-10s", courseCode, courseTitle, courseInstructor, courseSchedule, showAvailability(isAvailable));
			return courseInfo;
		}
		else {
			courseInfo = String.format("%-10s %-30s %-20s %-10s %-12s $%-10.2f", courseCode, courseTitle, courseInstructor, courseSchedule, showAvailability(isAvailable),fee);
			return courseInfo;	
		}
	}
	
	
	
}
