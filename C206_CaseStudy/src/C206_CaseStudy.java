import java.util.ArrayList;
//Asfar
//Achi
//xuan
//Jay Sen
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		
		studentList.add(new Student("Mary", "S12345", 1234.00));
		studentList.add(new Student("John", "S24689", 2100.00));
		
		courseList.add(new Course("Quote1", "Title1", "Instructor1", "Schedule1"));
		courseList.add(new Course("Quote2", "Title2", "Instructor2", "Schedule2"));
		
		adminList.add(new Admin("Terry", "admin1", "password0"));
		
		teacherList.add(new Teacher());

//		C206_CaseStudy.deleteFee(courseList);
//		C206_CaseStudy.viewAllCourse(courseList);
//		C206_CaseStudy.editFee(courseList);
//		C206_CaseStudy.retrieveAllCourse(courseList);
		
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
	
	//================================= Course =================================
	
	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	
	
	public static Course inputCourse() {
		String inputCode = Helper.readString("Enter Course Code > ");
		String inputTitle = Helper.readString("Enter Course Title > ");
		String inputInstructor = Helper.readString("Enter Course Instructor > ");
		String inputSchedule = Helper.readString("Enter Course Schedule > ");
		
		
		Course crs= new Course(inputCode, inputTitle, inputInstructor, inputSchedule);
		return crs;
	}
	
	public static void addCourse(ArrayList<Course> courseList, Course crs) {
		Course course;
		for(int i = 0; i < courseList.size(); i++) {
			course = courseList.get(i);
			if(course.getCourseCode().equalsIgnoreCase(crs.getCourseCode()) || course.getCourseTitle().equalsIgnoreCase(crs.getCourseTitle())){
				return;
			}
		}
		if(crs.getCourseCode().isEmpty() || crs.getCourseTitle().isEmpty()) {
			return;
		}
		courseList.add(crs);
		
		
	}
	
	public static void deleteCourse(ArrayList<Course> courseList) {
		String delCourse = Helper.readString("Enter course code to delete > ");
		
		char check = 'n';
		boolean match = false;
		for(int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);
			if(course.getCourseCode().equals(delCourse)) {
				match = true;
				check = Helper.readChar("Are you sure you want to delete course " + delCourse + "? (y/n) > ");
				if(check == 'y' || check == 'Y') {
					courseList.remove(i);
				}
			}
		}
		if(match == false) {
			System.out.println("There is no course code matching " + delCourse);
		}
		
		
		
	}
	
	//================================= Admin Fee Prompt System =================================
	
	public static void feePrompt(ArrayList<Student> studentList) {
		for (Student student : studentList) {
			if (student.getRemainingFee() > 0) {
				Helper.line(40, "=");
				System.out.println("\nYou have outstanding fees! > "+ student.getRemainingFee() +" <\n");
				System.out.println("1. Settle Payment");
				System.out.println("2. Proceed without paying");
				System.out.println("3. Exit");
				Helper.line(40, "=");
				
				int selection = Helper.readInt("Choose your option > ");
				
				if (selection == 1) {
					System.out.println("How would you like to pay?");
					System.out.println("1. Credit Card");
					System.out.println("2. Debit Card");
				} else if (selection == 2) {
					// Proceed to Login (Not Done)
				} else if (selection == 3) {
					System.out.println("Thank you!");
					break;
				} else {
					System.out.println("Invalid Input!");
				}
				
			}
		}
	}
}
