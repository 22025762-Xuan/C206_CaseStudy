import java.util.ArrayList;
import java.util.regex.Pattern;

//Asfar
//Achi
//xuan
//Jay Sen
//Justin
public class C206_CaseStudy {
	private static final int Option_Quit = 5;
	private static final int Fee_View = 1;
	private static final int Fee_Add = 2;
	private static final int Fee_Edit = 3;
	private static final int Fee_Delete = 4;
	private static final int Fee_Option = 4;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ArrayList<Instructor> instructorList = new ArrayList<Instructor>();

		studentList.add(new Student("Mary", "S12345", 1234.00, "Mary123", "password0"));
		studentList.add(new Student("John", "S24689", 2100.00, "John456", "password1"));

		courseList.add(new Course("c206", "Software Dev", "nancy", "Schedule1"));
		courseList.add(new Course("c209", "Adv. OOP", "alec", "Schedule2"));

		adminList.add(new Admin("Terry", "admin1", "Terry789", "adminpw1"));

		instructorList.add(new Instructor("Boon Cheong", "LOL", "BCgg", "instructorpw1"));
		// Tuition Management Loop (Isaac)
		LoginMenu();
		int option = Helper.readInt("Please choose a login method > ");
		while (option != 4) {
			if (option == 1) {
				// ask for username and pw from admin list
				String adminUN = Helper.readString("Enter your username > ");

				for (int i = 0; i < adminList.size(); i++) {
					if (!adminUN.equals(adminList.get(i).getUsername())) {
						System.out.println("Username Invalid or User not found!");
					} else {
						String adminPW = Helper.readString("Enter your password > ");
						if (!adminPW.equals(adminList.get(i).getPassword())) {
							System.out.println("Password Invalid!");
						} else {
							System.out.println("\nWelcome " + adminList.get(i).getName() + " To the Tuition Management App");
							AdminMenu();
							int adminOpt = Helper.readInt("Enter an option you would like to choose > ");
							while (adminOpt != 7) {
								if (adminOpt == 1) {
									// Manage Users view add delete (Isaac)
									setHeader("\n User Management Menu \n");
									System.out.println("1. Add New User");
									System.out.println("2. View All Users");
									System.out.println("3. Delete User");
									int opt = Helper.readInt("Select a function>");
									if (opt == 1) {
										System.out.println("1. Add New Admin");
										System.out.println("2. Add New Instructor");
										int select = Helper.readInt("Enter option >");
										if (select == 1) {
											
										} 
										else if (select == 2) {
											
										}
									} 
									else if (opt == 2) {
										
									}
									else if (opt == 3) {
										
									}
									
									
									

								} else if (adminOpt == 2) {
									// Manage Courses (Jay Sen)
									setHeader("\nCourse Management Menu\n");
									managementMenu();
									int select = Helper.readInt("Select a function > ");
									while (select != 4) {
										if (select == 1) {
											viewAllCourse(courseList);
											break;
										} else if (select == 2) {
											Course c = inputCourse();
											addCourse(courseList,c);
											break;
										} else if (select == 3) {
											deleteCourse(courseList);
											break;
										} else if (select == 4) {
											System.out.println("Thank you!");
											break;
										} else {
											System.out.println("Invalid Input");
											break;
										}
									}
									
								} else if (adminOpt == 3) {
									// Manage Students view,add,delete (xuan)
									System.out.println("1. View all students");
									System.out.println("2. Add a new student");
									System.out.println("3. Delete an existing student \n");
									int choice = Helper.readInt("Enter a choice > ");

									if (choice == 1) {
										// viewAllStudents
										viewAllStudents(studentList);

									} else if (choice == 2) {
										// addNewStudent
										Student s = inputNewStudent();
										addNewStudent(studentList, s);

									} else if (choice == 3) {
										// deleteStudent
										Student student = declareStudent(studentList);
										if (student != null) {
											boolean outcome = deleteStudent(studentList, student);
											if (outcome) {
												System.out.println("Student successfully deleted!");
											} else {
												System.out.println("Deletion failed.");
											}
										}

									}

								} else if (adminOpt == Fee_Option) {
									// Manage Fees(Achi)
									System.out.println("1. View all fees");
									System.out.println("2. Add fees");
									System.out.println("3. Edit fees");
									System.out.println("4. Delete fees");
									System.out.println("5. Exit");
									int choice = Helper.readInt("Enter a choice >");
									while(choice != Option_Quit) {
										if(choice == Fee_View) {
											viewAllFee(courseList);
										} else if(choice == Fee_Add) {
											addFee(courseList);
										} else if(choice == Fee_Edit) {
											editFee(courseList);
										} else if(choice==Fee_Delete) {
											deleteFee(courseList);
										} else {
											System.out.println("Invalid input!");
										}
									}
									AdminMenu();
									adminOpt = Helper.readInt("Enter an option you would like to choose > ");
								} else if (adminOpt == 5) {
									// Manage Enrolment

								} else if (adminOpt == 6) {
									// Manage Attendance

								} else if (adminOpt == 7) {
									// Logout
									System.out.println("Thanks for using Tuition Management App!");
								}

							}
						}
					}
				}
				// error code and validation

			} else if (option == 2) {
				// ask for username and pw from student list
				String studUN = Helper.readString("Enter your username > ");

				for (int i = 0; i < studentList.size(); i++) {
					if (!studUN.equals(studentList.get(i).getUsername())) {
						System.out.println("Username Invalid or User not found!");
					} else {
						String studPW = Helper.readString("Enter your password > ");
						if (!studPW.equals(studentList.get(i).getPassword())) {
							System.out.println("Password Invalid!");
						} else {
							System.out.println("\nWelcome " + studentList.get(i).getStudentName() + " To the Tuition Management App");
							feePrompt(studentList, studentList.get(i).getStudentName());
							StudentMenu();
							int studOpt = Helper.readInt("Enter an option you would like to choose > ");
							while (studOpt != 6) {

								if (studOpt == 1) {
									// View account info

								} else if (studOpt == 2) {
									// Update info
								} else if (studOpt == 3) {
									// View Fee Details

								} else if (studOpt == 4) {
									// Enroll for new course

								} else if (studOpt == 5) {
									// View Attendance

								} else if (studOpt == 6) {
									// Logout
									System.out.println("Thanks for using Tuition Management App!");

								}

							}
						}
					}
				}
				// error code and validation
			} else if (option == 3) {
				// ask for username and pw from instructor list
				String instructUN = Helper.readString("Enter your username >");

				for (int i = 0; i < instructorList.size(); i++) {
					if (!instructUN.equals(instructorList.get(i).getUsername())) {
						System.out.println("Username Invalid or User not found!");
					} else {
						String instructPW = Helper.readString("Enter your password >");
						if (!instructPW.equals(instructorList.get(i).getPassword())) {
							System.out.println("Password Invalid!");
						} else {
							System.out.println("\nWelcome " + instructorList.get(i).getInstructorName() + " To the Tuition Management App");
							InstructorMenu();
							int instructOpt = Helper.readInt("Enter an option you would like to choose > ");
							while (instructOpt != 3) {
								System.out.println("1. View Assigned Courses");
								System.out.println("2. Manage Attendance Record");
								System.out.println("3. Logout");
								if (instructOpt == 1) {
									// View Assigned Courses
									break;
								} else if (instructOpt == 2) {
									// Manage Attendance Record
									break;
								} else if (instructOpt == 3) {
									// Logout
									System.out.println("Thanks for using Tuition Management App!");
									break;
								}
							}
						}
					}
					// error code and validation

				}
			} else if (option == 4) {
				System.out.println("Thanks for using the Tuition Management System!");
			} else {
				System.out.println("Invalid Option!");
			}
		}


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
		String output = String.format("\n%-10s %-30s %-20s %-10s %-12s %-10s\n", "CODE", "TITLE", "INSTRUCTOR", "SCHEDULE", "AVAILABILITY", "FEE");
		output += retrieveAllCourse(courseList);
		System.out.println(output);
	}

	public static String viewAttendace(boolean isPresent) {
		String attendance = "";

		if (isPresent == true) {
			attendance = "Present";
		} else {
			attendance = "Absent";
		}
		return attendance;
	}

// --------------------------------------- FEES (ACHI)-----------------------------------------------------------------
	public static void viewAllFee(ArrayList<Course> courseList) {
		Helper.line(50,"=");
		String output = String.format("%-30s %-20s %s\n", "COURSE TITLE","FEE TYPE" ,"FEE");
		for (Course c : courseList) {
			if (c.getFee() == 0)
				output += String.format("%-30s %-20s %s\n", c.getCourseTitle(),"","");

			else {
				output += String.format("%-30s %-20s $%1.2f\n", c.getCourseTitle(),c.getFeeType() ,c.getFee());
			}
		}

		System.out.println(output);
	}
	public static void addFee(ArrayList<Course> courseList) {
		for (int i = 0; i < courseList.size(); i++) {
			System.out.println((i + 1) + ". " + courseList.get(i).getCourseTitle());
		}
		int courseInput = Helper.readInt("Select the course to add fee > ");
		courseInput = courseInput - 1;
		int totalCourse = courseList.size();
		while ( courseInput >= totalCourse|| courseInput < 0) {
			System.out.println("Invalid course");
			courseInput = Helper.readInt("Select the course to add fee > ");
			courseInput = courseInput - 1;
		}
		double fee = Helper.readDouble("Enter the fee amount > $");
		String type = Helper.readString("Enter fee type > ");
		if(fee >= 0) {
			courseList.get(courseInput).setFee(fee);
			courseList.get(courseInput).setFeeType(type);
			System.out.println("Fee added");
		}else {
			System.out.println("Fee need to be more than $0");
		}
	}

	public static void editFee(ArrayList<Course> courseList) {
		for (int i = 0; i < courseList.size(); i++) {
			System.out.println((i + 1) + ". " + courseList.get(i).getCourseTitle());
		}
		int courseInput = Helper.readInt("Select the course to edit fee > ");
		courseInput = courseInput - 1;
		int totalCourse = courseList.size();
		while (courseInput >= totalCourse || courseInput < 0) {
			System.out.println("Invalid course");
			courseInput = Helper.readInt("Select the course to edit fee > ");
			courseInput = courseInput - 1;
		}
		if (courseList.get(courseInput).getFee() != 0) {
			double fee = Helper.readDouble("Enter the fee amount > $");
			String type = Helper.readString("Enter fee type > ");
			if(fee >= 0) {
				courseList.get(courseInput).setFee(fee);
				courseList.get(courseInput).setFeeType(type);
				System.out.println("Fee edited");
			}
			else {
				System.out.println("Fee must be more than or equal to $0");
			}
		} else {
			System.out.println("The course does not have fee");
		}
	}

	public static void deleteFee(ArrayList<Course> courseList) {
		for (int i = 0; i < courseList.size(); i++) {
			System.out.println((i + 1) + ". " + courseList.get(i).getCourseTitle());
		}
		int courseInput = Helper.readInt("Select the course to delete fee > ");
		courseInput = courseInput - 1;
		int totalCourse = courseList.size();
		while (courseInput >= totalCourse || courseInput < 0) {
			System.out.println("Invalid course");
			courseInput = Helper.readInt("Select the course to delete fee > ");
			courseInput = courseInput - 1;
		}
		if (courseList.get(courseInput).getFee() != 0) {
			courseList.get(courseInput).setFee(0);
			courseList.get(courseInput).setFeeType("");
			System.out.println("Fee deleted");
		}else {
			System.out.println("This course does not have fee");
		}
	}

	// ================================= login menus(Isaac) =================================

	public static void LoginMenu() {
		Helper.line(40, "=");
		System.out.println("\n Tuition Management App Login\n");
		Helper.line(40, "=");
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as Student");
		System.out.println("3. Login as Instructor");
		System.out.println("4. End Session");
		Helper.line(40, "=");

		System.out.println();
	}

	public static void AdminMenu() {
		Helper.line(40, "=");
		System.out.println("\n Admin Panel \n");
		Helper.line(40, "=");
		// user, course, student, fee, enrolment, attendance
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
		Helper.line(40, "=");
		System.out.println("\n Student Panel \n");
		Helper.line(40, "=");
		System.out.println("1. View Account Information");
		System.out.println("2. Update Information");
		System.out.println("3. View Fee Details");
		System.out.println("4. Enroll for new course");
		System.out.println("5. View Attendance");
		System.out.println("6. Logout");
		Helper.line(40, "=");

	}

	public static void InstructorMenu() {
		Helper.line(40, "=");
		System.out.println("\n Instructor Panel \n");
		Helper.line(40, "=");
		System.out.println("1. View Assigned Courses");
		System.out.println("2. Manage Attendance Record");
		System.out.println("3. Logout");
		Helper.line(40, "=");
	}
	
	

	// ================================= Course (Asfar) =================================


	public static void setHeader(String header) {
		Helper.line(40, "=");
		System.out.println(header);
		Helper.line(40, "=");
	}
	
	// Jay Sen
	public static void managementMenu() {
		System.out.println("1. View all Courses");
		System.out.println("2. Add a Course");	
		System.out.println("3. Delete a Course");
		System.out.println("4. Exit");
		Helper.line(40, "=");
		}
	
	public static Course inputCourse() {
		String inputCode = Helper.readString("Enter Course Code > ");
		String inputTitle = Helper.readString("Enter Course Title > ");
		String inputInstructor = Helper.readString("Enter Course Instructor > ");
		String inputSchedule = Helper.readString("Enter Course Schedule > ");

		Course crs = new Course(inputCode, inputTitle, inputInstructor, inputSchedule);
		System.out.println("Course Added!");
		return crs;
	}

	public static void addCourse(ArrayList<Course> courseList, Course crs) {

		boolean check = true;

		Course course;
		for (int i = 0; i < courseList.size(); i++) {
			course = courseList.get(i);
			if (course.getCourseCode().equalsIgnoreCase(crs.getCourseCode())
					|| course.getCourseTitle().equalsIgnoreCase(crs.getCourseTitle())) {
				check = false;
				System.out.println("Course Code/Ttitle already exist");
				;
			}
		}
		if (crs.getCourseCode().isEmpty() || crs.getCourseTitle().isEmpty() || crs.getCourseInstructor().isEmpty()
				|| crs.getCourseSchedule().isEmpty()) {
			check = false;
			System.out.println("Not all fields are filled in");
			;
		}
		if (check == true) {
			courseList.add(crs);
		}

	}
	
	// Jaysen & Asfar
	public static void deleteCourse(ArrayList<Course> courseList) {
		if (courseList.size() == 0) {
			System.out.println("There is no course at the moment");
		} else {
			String deleteCode = Helper.readString("Enter course code to delete > ");
			for (Course c : courseList) {
				if (c.getCourseCode().equals(deleteCode)) {
					char verify = Helper.readChar("Confirm deletion of Course: " + deleteCode + " ? (Y/N) > ");
					if (verify == 'Y' | verify == 'y') {
						courseList.remove(c);
						System.out.println("Course Deleted!");
					}
				} else {
					System.out.println("No such course found!");	
				}
			}
		}
	}


	// ================================= Admin Fee Prompt System (Jay Sen) ================================

	public static void feePrompt(ArrayList<Student> studentList,String studentName) {
		for (Student student : studentList) {
			if (student.getStudentName().equalsIgnoreCase(studentName))
			if (student.getRemainingFee() > 0) {
				Helper.line(40, "=");
				System.out.println("\nYou have outstanding fees! > " + student.getRemainingFee() + " <\n");
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

	// =================================Management of Students for admins (Xuan) ================================

	public static String retrieveAllStudents(ArrayList<Student> studentList) {
		String message = "";

		for (Student s : studentList) {
			message += String.format("%-25s %-20s %-15s %.2f\n", s.getStudentId(), s.getStudentName(),
					checkAttendCourse(s), s.getRemainingFee());
		}
		return message;
	}

	public static void viewAllStudents(ArrayList<Student> studentList) {
		Helper.line(50, "-");
		System.out.println("VIEW ALL STUDENTS");
		Helper.line(50, "-");
		System.out.println("");
		String message = String.format("%-25s %-20s %-15s %-15s\n", "Student ID", "Student Name", "Enrolled Course",
				"Pending Fee");

		message += retrieveAllStudents(studentList);

		System.out.println(message);
	}

	public static Student inputNewStudent() {
		Helper.line(50, "-");
		System.out.println("ADD NEW STUDENT");
		Helper.line(50, "-");
		String studentID = Helper.readString("Please enter student ID > ");
		String studentName = Helper.readString("Enter student name > ");
		String pw = confirmPw();
		String username = Helper.readString("Enter your username > ");
		Student student = new Student(username, pw, studentName, studentID); // ADD NEW STUDENT TO ARRAYLIST
		return student;
	}

	public static void addNewStudent(ArrayList<Student> studentList, Student student) {

		boolean found = false;
		for (Student s : studentList) {
			if (s.getStudentId().equals(student.getStudentId())) {
				found = true;
				break;
			}
		}
		if (!found) {
			studentList.add(student);
			System.out.println("Student successfully added!");
		} else {
			System.out.println("Student already exist!");
		}
	}

	// declare which student to delete
	public static Student declareStudent(ArrayList<Student> studentList) {

		if (studentList.size() == 0) {
			System.out.println("There is no student inside, please add a student first.");
			return null;
		} else {
			Helper.line(50, "-");
			System.out.println("DELETE A STUDENT");
			Helper.line(50, "-");
			String deleteID = Helper.readString("Enter Student ID to delete > ");
			for (Student s : studentList) {
				if (s.getStudentId().equals(deleteID)) {
					return s;
				} else {
					System.out.println("No such student found!");
					return null;
				}
			}
			return null;
		}

	}

	public static boolean deleteStudent(ArrayList<Student> studentList, Student student) {
		  String pattern = "\\d{8}";
		  boolean check = false;
		  if (Pattern.matches(pattern, student.getStudentId())) {
		   for (Student s : studentList) {
		    if (s.getStudentId().equalsIgnoreCase(student.getStudentId())) {
		     char verify = Helper
		       .readChar("Confirm deletion of student ID: " + student.getStudentId() + " ?(Y/N) > ");
		     if (verify == 'Y' | verify == 'y') {
		      studentList.remove(student); // REMOVE STUDENT FROM ARRAYLIST
		      check = true;
		      break;
		     }
		    }
		   }
		  } else {
		   System.out.println("The student ID is invalid!");
		   check = false;
		  }
		  return check;

		 }

	// for display purposes
	private static String checkAttendCourse(Student s) {

		if (s.getEnrolledCourses().equals("")) {
			return "No Course";
		} else {
			return s.getEnrolledCourses();
		}
	}

	// password confirmation
	private static String confirmPw() {
		boolean matches = false;
		while (!matches) {
			String input1 = Helper.readString("Enter password > ");
			String input2 = Helper.readString("Re-enter same password >");
			if (input1.equals(input2)) {
				return input1;
			} else {
				System.out.println("Password does not match!");
			}
		}

		return "";
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
 // ======================= Management of Users (isaac) ==================
		public static String showAdmins (ArrayList<Admin> adminList) {
			String msg = String.format("%-25s %-20s", "NAME","USERID");
			for (Admin a : adminList) {
				msg += String.format("%-25s %-20s \n",a.getName(),a.getUserID());
			}
			return msg;
		}
		
		
        public static void viewUsers (ArrayList<Admin> adminList, ArrayList<Instructor> instructorList) {
			Helper.line(50, "-");
			System.out.println("View Users");
			Helper.line(50, "-");
			String message = "";
			message += showAdmins(adminList);
			System.out.println(message);
		
		}
		
		public static void addAdmin (ArrayList<Admin> adminList, Admin admin) {
			boolean found = false;
			for (Admin a : adminList) {
				if (a.getUserID().equals(admin.getUserID())) {
					found = true;
					break;
				}
			}
			if (!found) {
				adminList.add(admin);
				System.out.println("Admin successfully added!");
			} else {
				System.out.println("Admin already exist!");
			}
		
			
		}
		public static Admin inputAdmin() {
			Helper.line(50, "-");
			System.out.println("Add new Admin");
			Helper.line(50, "-");
			String adminName = Helper.readString("Please enter Admin name > ");
			String userID = Helper.readString("Enter User ID > ");
			String pass = Helper.readString("Enter password > ");
			String username = Helper.readString("Enter your username > ");
			Admin admin = new Admin(username, pass, adminName, userID); 
			return admin;
		}

		public static Admin adminCheck(ArrayList<Admin> adminList) {

			if (adminList.size() == 0) {
				System.out.println("There is no admin inside, please add a admin first.");
				return null;
			} else {
				Helper.line(50, "-");
				System.out.println("Delete an Admin");
				Helper.line(50, "-");
				String deleteID = Helper.readString("Enter Admin ID to delete > ");
				for (Admin a : adminList) {
					if (a.getUserID().equals(deleteID)) {
						return a;
					} else {
						System.out.println("No such admin found!");
						return null;
					}
				}
				return null;
			}

		}

		
        public static boolean deleteAdmin (ArrayList<Admin> adminList, Admin admin) {
        	boolean checker = true;
        	
        	for (Admin a : adminList) {
        		if (a.getUserID().equalsIgnoreCase(admin.getUserID())) {
        			char verify = Helper.readChar
        					("Confirm deletion of admin ID: " + admin.getUserID() + " ?(Y/N) >");
        			
        			if (verify == 'Y' | verify == 'y') {
        				adminList.remove(admin);
        				checker = true;
        				break;
        			} 
        			
        		} else {
        			System.out.println("Admin user ID is invalid!");
        			checker = false;
        		}
        	
        	}
        	return checker;
        
        	

        }


}
