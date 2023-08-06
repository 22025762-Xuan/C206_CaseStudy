import java.util.ArrayList;

//Achi
//xuan
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
	}
	public static String viewAttendace(boolean isPresent) {
		String attendance = "";
		
		if(isPresent==true) {
			attendance= "Present";
		}else {
			attendance= "Absent";
		}
		return attendance;
	}

}
