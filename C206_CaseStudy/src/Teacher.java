// Isaac

public class Teacher {
	
	private String teacherName;
	private String assignedCourses;
	//private change for now;
	
	public Teacher(String teacherName) {
		this.teacherName = teacherName;
		this.assignedCourses = "";
	}
	public Teacher(String teacherName,String assignedCourses) {
		this.teacherName = teacherName;
		this.assignedCourses = assignedCourses;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public String getAssignedCourses() {
		return assignedCourses;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public void setAssignedCourses(String assignedCourses) {
		this.assignedCourses = assignedCourses;
	}
}
