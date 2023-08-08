import java.util.ArrayList;
//Asfar
//Achi
//xuan
//Jay Sen
//Justin
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
		
		studentList.add(new Student("Mary", "S12345", 1234.00, "Mary123","password0"));
		studentList.add(new Student("John", "S24689", 2100.00,"John456","password1"));
		
		courseList.add(new Course("Quote1", "Title1", "Instructor1", "Schedule1",234));
		courseList.add(new Course("Quote2", "Title2", "Instructor2", "Schedule2"));
		
		adminList.add(new Admin("Terry", "admin1", "Terry789","adminpw1"));
		
		
		instructorList.add(new Instructor("Boon Cheong","LOL","BCgg","instructorpw1"));
		
		//Tuition Management Loop (Isaac)
		LoginMenu();
		int option = Helper.readInt("Please choose the correct login method >");
		while (option != 4) {
			if (option == 1) {
				//ask for username and pw from admin list 
				String adminUN = Helper.readString("Enter your username >");
				
				for (int i =0; i < adminList.size(); i++) {
					if (adminUN != adminList.get(i).getUsername()) 
					{
						System.out.println("Username Invalid or User not found!");
					} else {
						String adminPW = Helper.readString("Enter your password >");
						if (adminPW != adminList.get(i).getPassword()) {
							System.out.println("Password Invalid!");
						} else {
							System.out.println("Welcome " + adminList.get(i).getName() + "To the Tuition Management App");
							AdminMenu();
							int adminOpt = Helper.readInt("Enter an option you would like to choose > ");
							while (adminOpt != 7) {
								if (adminOpt == 1) {
									//Manage Users
									
								}
								else if (adminOpt == 2) {
									//Manage Courses
								}
								else if (adminOpt == 3) {
									// Manage Students
	
                                }
								else if (adminOpt == 4) {
									//Manage Fees
	
                                }
								else if (adminOpt == 5) {
									// Manage Enrolment
	
								}
								else if (adminOpt == 6) {
									//Manage Attendance
	
								}
								else if (adminOpt == 7) {
									//Logout
									System.out.println("Thanks for using Tuition Management App!");
								}

								
							}
						}
					}
				}
				//error code and validation
			
				
			}
			else if (option == 2) {
				//ask for username and pw from student list
                String studUN = Helper.readString("Enter your username >");
				
				for (int i =0; i < studentList.size(); i++) {
					if (studUN != studentList.get(i).getUsername()) 
					{
						System.out.println("Username Invalid or User not found!");
					} else {
						String studPW = Helper.readString("Enter your password >");
						if (studPW != studentList.get(i).getPassword()) {
							System.out.println("Password Invalid!");
						} else {
							System.out.println("Welcome " + studentList.get(i).getStudentName() + "To the Tuition Management App");
							StudentMenu();
							int studOpt = Helper.readInt("Enter an option you would like to choose > ");
							while (studOpt != 6) {
						
								if (studOpt == 1) {
									//View account info
									
								}
								else if (studOpt == 2) {
									//Update info
								}
								else if (studOpt == 3) {
									// View Fee Details
	
                                }
								else if (studOpt == 4) {
									//Enroll for new course
	
                                }
								else if (studOpt == 5) {
									// View Attendance
	
								}
								else if (studOpt == 6) {
									//Logout
									System.out.println("Thanks for using Tuition Management App!");
	
								}
																
							}
						}
					}
				}
				//error code and validation
			}
			else if (option == 3) {
				//ask for username and pw from instructor list
                String instructUN = Helper.readString("Enter your username >");
				
				for (int i =0; i < instructorList.size(); i++) {
					if (instructUN != instructorList.get(i).getUsername()) 
					{
						System.out.println("Username Invalid or User not found!");
					} else {
						String instructPW = Helper.readString("Enter your password >");
						if (instructPW != instructorList.get(i).getPassword()) {
							System.out.println("Password Invalid!");
						} else {
							System.out.println("Welcome " + instructorList.get(i).getInstructorName() + "To the Tuition Management App");
							StudentMenu();
							int instructOpt = Helper.readInt("Enter an option you would like to choose > ");
							while (instructOpt != 3) {
								System.out.println("1. View Assigned Courses");
								System.out.println("2. Manage Attendance Record");
								System.out.println("3. Logout");
								if (instructOpt == 1) {
									//View Assigned Courses
																	
									
								}
								else if (instructOpt == 2) {
								//Manage Attendance Record
								}
								else if (instructOpt == 3) {
									//Logout
									System.out.println("Thanks for using Tuition Management App!");
	
															
							}
						}
					}
				}
				//error code and validation
	
            }
		}
			else if (option == 4) {
				System.out.println("Thanks for using the Tuition Management System!");
			} else {
				System.out.println("Invalid Option!");
			}
		}
		
//		C206_CaseStudy.addFee(courseList);
//		C206_CaseStudy.deleteFee(courseList);
//		C206_CaseStudy.viewAllCourse(courseList);
//		C206_CaseStudy.retrieveAllCourse(courseList); 

//		C206_CaseStudy.setHeader("VIEW ALL FEE");
//	    C206_CaseStudy.viewAllFee(courseList);
	}
	
// -------------------------------------------------(ACHI)-------------------------------------------------------------------------
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
// --------------------------------------- FEE (ACHI)-----------------------------------------------------------------
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
	
	//================================= login menus(Isaac) =================================

	public static void LoginMenu() {
		Helper.line(40,"=");
		System.out.println("\n Tuition Management App Login\n");
		Helper.line(40,"=");
		System.out.println("1. Login as admin");
		System.out.println("2. Login as instructor");
		System.out.println("3. Login as student");
		System.out.println("4. End Session");
		Helper.line(40,"=");
		
	
		System.out.println();
	}
	
	public static void AdminMenu() {
		Helper.line(40,"=");
		System.out.println("\n Admin Panel \n");
		Helper.line(40,"=");
		//user, course, student, fee, enrolment, attendance
		System.out.println("1. Manage Users");
		System.out.println("2. Manage Courses");
		System.out.println("3. Manage Students");
		System.out.println("4. Manage Fees");
		System.out.println("5. Manage Enrolment");
		System.out.println("6. Manage Attendance");
		System.out.println("7. Logout");
		Helper.line(40, "=");
	
		
	}
	
	public static void StudentMenu() {
		Helper.line(40,"=");
		System.out.println("\n Panel \n");
		Helper.line(40,"=");
		System.out.println("1. View Account Information");
		System.out.println("2. Update Information");
		System.out.println("3. View Fee Details");
		System.out.println("4. Enroll for new course");
		System.out.println("5. View Attendance");
		System.out.println("6. Logout");
		Helper.line(40,"=");
		
		
	}
	
	public static void InstructorMenu() {
		Helper.line(40,"=");
		System.out.println("\n Instructor Panel \n");
		Helper.line(40,"=");
		System.out.println("1. View Assigned Courses");
		System.out.println("2. Manage Attendance Record");
		System.out.println("3. Logout");
		Helper.line(40,"=");
	}
	
	//================================= Course (Asfar) =================================
	
//	public static String showAvailability(boolean isAvailable) {
//		String avail;
//
//		if (isAvailable == true) {
//			avail = "Yes";
//		} else {
//			avail = "No";
//		}
//		return avail;
//	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
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
		
		boolean check = true;
		
		Course course;
		for(int i = 0; i < courseList.size(); i++) {
			course = courseList.get(i);
			if(course.getCourseCode().equalsIgnoreCase(crs.getCourseCode()) || 
					course.getCourseTitle().equalsIgnoreCase(crs.getCourseTitle())){
				check = false;
				System.out.println("Course Code/ Ttitle already exist");;
			}
		}
		if(crs.getCourseCode().isEmpty() || crs.getCourseTitle().isEmpty() ||
				crs.getCourseInstructor().isEmpty() || crs.getCourseSchedule().isEmpty()) {
			check = false;
			System.out.println("Not all fields are filled in");;
		}
		if(check == true) {
			courseList.add(crs);
		}
		
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
			System.out.println("There is no course code matching '" + delCourse + "'");
		}
				
	}
	
	//================================= View All Fee (Asfar) =================================
	
	public static void viewAllFee(ArrayList<Course> courseList) {
		
		String output = String.format("%-20s %10s\n", "COURSE TITLE", "FEE" );
		for(Course c: courseList) {
			if (c.getFee() == 0)
			output += String.format("%-20s %s\n", c.getCourseTitle(),"");	
			
			else {
				output += String.format("%-20s %10.2f\n", c.getCourseTitle(),c.getFee());
			}
		}
		
		System.out.println(output);
	}
	
	
	
	//================================= Admin Fee Prompt System ================================
	
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
							double amount = Helper.readDouble("Enter amount to pay > ");
							double newAmt = student.getRemainingFee() - amount;
							student.setRemainingFee(newAmt);
							
							if (student.getRemainingFee() <= 0) {
								System.out.println("You have no remaining outstanding fees!");
							} else {
							System.out.println("Your remaining outstanding fee are > " + student.getRemainingFee());
							}	
							
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
		
	//================================= Manage Enrollment (Justin) ================================	
		
		
		public static void addEnrollment(ArrayList<Student> enrollmentList) {
			for(int i=0; i<enrollmentList.size();i++) {
				System.out.println( (i+1) +". "+ enrollmentList.get(i).getEnrolledCourses());
			}
			int courseInput = Helper.readInt("Select the course to add enrollment > ");
			courseInput = courseInput -1;
			int totalCourse = enrollmentList.size();
			while(courseInput >= totalCourse || courseInput >0) {
				System.out.println("Invalid course");
				courseInput = Helper.readInt("Select the course to add enrollment > ");
				courseInput = courseInput -1;
			}
			String enrollment = Helper.readString("Enter the new enrollment > ");
			enrollmentList.get(courseInput).setEnrolledCourses(enrollment);
			System.out.println("Enrollment added");
		}
		
		public static void editEnrollment(ArrayList<Student> enrollmentList) {
			for(int i=0; i<enrollmentList.size();i++) {
				System.out.println( (i+1) +". "+ enrollmentList.get(i).getEnrolledCourses());
			}
			int courseInput = Helper.readInt("Select the course to edit enrollment > ");
			courseInput = courseInput -1;
			int totalCourse = enrollmentList.size();
			while(courseInput >= totalCourse || courseInput >0) {
				System.out.println("Invalid course");
				courseInput = Helper.readInt("Select the course to edit enrollment > ");
				courseInput = courseInput -1;
			}
			if(!enrollmentList.get(courseInput).getEnrolledCourses().isEmpty()) {
				String enrollment = Helper.readString("Enter the new enrollment > ");
				enrollmentList.get(courseInput).setEnrolledCourses(enrollment);
				System.out.println("Enrollment edited");
			}else {
				System.out.println("The course does not have enrollment");
			}
		}
		public static void deleteEnrollment(ArrayList<Student> enrollmentList) {
			for(int i=0; i<enrollmentList.size();i++) {
				System.out.println( (i+1) +". "+ enrollmentList.get(i).getEnrolledCourses());
			}
			int courseInput = Helper.readInt("Select the course to delete enrollment > ");
			courseInput = courseInput -1;
			int totalCourse = enrollmentList.size();
			while(courseInput >= totalCourse || courseInput >0) {
				System.out.println("Invalid course");
				courseInput = Helper.readInt("Select the course to delete enrollment > ");
				courseInput = courseInput -1;
			}
			if(!enrollmentList.get(courseInput).getEnrolledCourses().isEmpty()) {
				enrollmentList.get(courseInput).setEnrolledCourses("");
				System.out.println("Enrollment deleted");
			}
		}
}
