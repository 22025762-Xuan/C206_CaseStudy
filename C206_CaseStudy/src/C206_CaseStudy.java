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
	public static void addFee(ArrayList<Course> courseList) {
		for(int i=0; i<courseList.size();i++) {
			System.out.println( i +". "+ courseList.get(i).getCourseTitle());
		}
		int courseInput = Helper.readInt("Select the course to add fee > ");
		double fee = Helper.readDouble("Enter the fee amount > ");
		courseList.get(courseInput).setFee(fee);
	}
}
