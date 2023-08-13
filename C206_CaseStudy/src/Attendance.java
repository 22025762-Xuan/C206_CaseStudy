// Jay Sen 
// Achi
public class Attendance{
	
	private String studentID;
	private String attendance;
	private int lesson;
	private String module;
	
	public Attendance(String studentID, String attendance, int lesson, String module) {
		this.studentID = studentID;
		this.attendance = attendance;
		this.lesson = lesson;
		this.module = module;
	}
	
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public int getLesson() {
		return lesson;
	}
	public void setLesson(int lesson) {
		this.lesson = lesson;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}
	
	
}
