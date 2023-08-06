import java.util.ArrayList;

//Achi
//xuan
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		courseList.add(new Course("CB002", "HP Chromebook", "Win 10","Today",10.00));
		C206_CaseStudy.deleteFee(courseList);
		C206_CaseStudy.viewAllCourse(courseList);
		//C206_CaseStudy.editFee(courseList);
	}
	public static String retrieveAllCourse(ArrayList<Course> courseList) {
		String output = "";

		for (int i = 0; i < courseList.size(); i++) {

			output += courseList.get(i).toString() + "\n";
					}
		return output;
	}
	
	public static void viewAllCourse(ArrayList<Course> courseList) {
		String output = String.format("%-10s %-30s %-20s %-10s %-12s %-10s\n", "CODE", "TITLE",
				"INSTRUCTOR", "SCHEDULE","AVAILABILITY","FEE");
		 output += retrieveAllCourse(courseList);	
		System.out.println(output);
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
			System.out.println( (i+1) +". "+ courseList.get(i).getCourseTitle());
		}
		int courseInput = Helper.readInt("Select the course to add fee > ");
		courseInput = courseInput -1;
		int totalCourse = courseList.size();
		while(courseInput >= totalCourse || courseInput >0) {
			System.out.println("Invalid course");
			courseInput = Helper.readInt("Select the course to add fee > ");
			courseInput = courseInput -1;
		}
		double fee = Helper.readDouble("Enter the fee amount > $");
		courseList.get(courseInput).setFee(fee);
		System.out.println("Fee added");
	}
	
	public static void editFee(ArrayList<Course> courseList) {
		for(int i=0; i<courseList.size();i++) {
			System.out.println( (i+1) +". "+ courseList.get(i).getCourseTitle());
		}
		int courseInput = Helper.readInt("Select the course to edit fee > ");
		courseInput = courseInput -1;
		int totalCourse = courseList.size();
		while(courseInput >= totalCourse || courseInput >0) {
			System.out.println("Invalid course");
			courseInput = Helper.readInt("Select the course to edit fee > ");
			courseInput = courseInput -1;
		}
		if(courseList.get(courseInput).getFee() != 0) {
			double fee = Helper.readDouble("Enter the fee amount > $");
			courseList.get(courseInput).setFee(fee);
			System.out.println("Fee edited");
		}else {
			System.out.println("The course does not have fee");
		}
	}
	public static void deleteFee(ArrayList<Course> courseList) {
		for(int i=0; i<courseList.size();i++) {
			System.out.println( (i+1) +". "+ courseList.get(i).getCourseTitle());
		}
		int courseInput = Helper.readInt("Select the course to delete fee > ");
		courseInput = courseInput -1;
		int totalCourse = courseList.size();
		while(courseInput >= totalCourse || courseInput >0) {
			System.out.println("Invalid course");
			courseInput = Helper.readInt("Select the course to delete fee > ");
			courseInput = courseInput -1;
		}
		if(courseList.get(courseInput).getFee() != 0) {
			courseList.get(courseInput).setFee(0);
			System.out.println("Fee deleted");
		}
	}
}
