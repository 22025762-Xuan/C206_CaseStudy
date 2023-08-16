// Jay Sen

public class Student extends User{
    private String studentName;
    private String studentId;
    private String enrolledCourses;
    private double courseFee;

    public Student(String studentName, String studentId, String username, String password) {
    	super(username,password);
    	this.studentName = studentName;
        this.studentId = studentId;
        this.enrolledCourses = "";
        this.courseFee = 0.0;
    }
    
    public Student(String studentName, String studentId, String enrolledCourses, String username, String password) {
    	super(username,password);
    	this.studentName = studentName;
        this.studentId = studentId;
        this.enrolledCourses = enrolledCourses;
    }
    


	public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void viewAccountDetails() {
    	System.out.println("Account Details for Student: " + studentName);
        System.out.println("Student ID: " + studentId);
    }

	public String getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(String enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	
	
}


