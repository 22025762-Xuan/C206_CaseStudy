// Jay Sen

public class Student extends User{
    private String studentName;
    private String studentId;
    private double remainingFee;
    private String enrolledCourses;

    public Student(String studentName, String studentId, double remainingFee, String username, String password) {
    	super(username,password);
    	this.studentName = studentName;
        this.studentId = studentId;
        this.remainingFee = remainingFee;
        this.enrolledCourses = "";
    }
    
    public Student(String studentName, String studentId, double remainingFee, String enrolledCourses, String username, String password) {
    	super(username,password);
    	this.studentName = studentName;
        this.studentId = studentId;
        this.remainingFee = remainingFee;
        this.enrolledCourses = enrolledCourses;
    }
    
    //when creating a new student, new constructor used
    public Student(String username, String password, String studentName, String studentId) {
		super(username, password);
		this.studentName = studentName;
        this.studentId = studentId;
        this.enrolledCourses = "";
        this.remainingFee = 0.00;
	}

	
    
    public double getRemainingFee() {
    	return remainingFee;
    }
    
    public double setRemainingFee(double remainingFee) {
    	return remainingFee;
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
}


