import java.util.ArrayList;
import java.util.regex.Pattern;

//Isaac
//Asfar
//Achi
//xuan
//Jay Sen
//Justin
public class C206_CaseStudy {
	// XUAN
	private static final int STUDENT_MGMT_OPTION = 3;
	// ------(Achi)
	private static final int FEE_OPTION_QUIT = 5;
	private static final int FEE_VIEW = 1;
	private static final int FEE_ADD = 2;
	private static final int FEE_EDIT = 3;
	private static final int FEE_DELETE = 4;
	private static final int ADMIN_MANAGE_FEE = 4;
	// ----- (Isaac)
	private static final int LOOP_ADMIN = 1;
	private static final int LOOP_STUDENT = 2;
	private static final int LOOP_INSTRUCTOR = 3;
	private static final int LOOP_QUIT = 4;
	private static final int USER_ADD = 1;
	private static final int USER_VIEW = 2;
	private static final int USER_DELETE = 3;
	private static final int ADMIN_QUIT = 4;
	private static final int ADMIN_MANAGE_USER = 1;
	// AdminOpt 1-7 Manage User, Manage Course, Manage Students, Manage Fee, Manage
	// Enrollment, Manage Attendance, Logout

	private static final int ADMIN_MANAGE_COURSE = 2;
	private static final int COURSE_VIEW = 1;
	private static final int COURSE_ADD = 2;
	private static final int COURSE_DELETE = 3;

	private static final int ADMIN_MANAGE_ENROLMENT = 5;
	private static final int ADMIN_MANAGE_ATTENDANCE = 6;
	private static final int ADMIN_LOGOUT = 7;

	// studOpt 1-3 (Jay Sen)
	private static final int STUDENT_VIEW_DETAILS = 1;
	private static final int STUDENT_VIEW_COURSES = 2;
	private static final int STUDENT_VIEW_ALL_COURSE = 3;
	private static final int STUDENT_ADD_ENROLMENT = 4;
	private static final int STUDENT_VIEW_ATTENDANCE = 5;
	private static final int STUDENT_QUIT = 6;

	// instructor stuff
	private static final int INSTRUCTOR_VIEW = 1;
	private static final int INSTRUCTOR_MANAGE_ATTENDANCE = 2;
	private static final int INSTRUCTOR_QUIT = 3;

	// Enrolment Refactoring (Justin)
	private static final int ENROLLMENT_OPTION_QUIT = 5;
	private static final int ENROLLMENT_VIEW = 1;
	private static final int ENROLLMENT_ADD = 2;
	private static final int ENROLLMENT_EDIT = 3;
	private static final int ENROLLMENT_DELETE = 4;

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
		ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();

		studentList.add(new Student("Mary", "12345678", "c206", "Mary123", "password0"));
		studentList.add(new Student("John", "24689222", "c209", "John456", "password1"));
		studentList.add(new Student("Adam", "25689555", "c327", "Adam456", "password2"));
		studentList.add(new Student("Johnny", "26689111", "", "Johnny456", "password3"));

		attendanceList.add(new Attendance("12345678", "P", 1, "c206"));
		attendanceList.add(new Attendance("12345678", "P", 2, "c206"));
		attendanceList.add(new Attendance("12345678", "A", 1, "c209"));
		attendanceList.add(new Attendance("12345678", "P", 1, "c327"));

		courseList.add(new Course("c206", "Software Dev", "nancy", "Schedule1"));
		courseList.add(new Course("c209", "Adv. OOP", "alec", "Schedule2"));
		courseList.add(new Course("c327", "ist", "BoonCheong", "Schedule3"));

		adminList.add(new Admin("Terry", "admin1", "Terry789", "adminpw1"));

		instructorList.add(new Instructor("Boon Cheong", "c327", "BCgg", "instructorpw1"));
		// Tuition Management Loop (Isaac)

		while (true) {
			LoginMenu();
			int option = Helper.readInt("Please choose a login method > ");
			if (option == LOOP_QUIT) {
				break;
			} else if (option == LOOP_ADMIN) {
				// ask for username and pw from admin list
				String adminUN = Helper.readString("Enter your username > ");
				boolean usernameFound = false;

				for (int i = 0; i < adminList.size(); i++) {
					if (adminUN.equals(adminList.get(i).getUsername())) {
						usernameFound = true;
						String adminPW = Helper.readString("Enter your password > ");
						if (adminPW.equals(adminList.get(i).getPassword())) {
							System.out.println(
									"\nWelcome " + adminList.get(i).getName() + " To the Tuition Management App");
							AdminMenu();
							int adminOpt = Helper.readInt("Enter an option you would like to choose > ");
							while (adminOpt != ADMIN_LOGOUT) {
								if (adminOpt == ADMIN_MANAGE_USER) {
									// Manage Users view add delete (Isaac)
									adminManagementMenu();
									int opt = Helper.readInt("Select a function > ");
									while (opt != ADMIN_QUIT) {
										if (opt == USER_ADD) {
											// Add Admin
											Admin a = inputAdmin();
											addAdmin(adminList, a);
										} else if (opt == USER_VIEW) {
											// View Admin
											viewUsers(adminList);
										} else if (opt == USER_DELETE) {
											// Delete Admin
											Admin admin = adminCheck(adminList);
											if (admin != null) {
												boolean outcome = deleteAdmin(adminList, admin);
												if (outcome) {
													System.out.println("Admin successfully deleted!");
												} else {
													System.out.println("Delete failed.");
												}
											}
										} else if (opt == ADMIN_QUIT) {
											break;
										} else {
											System.out.println("Invalid Input");
										}
										adminManagementMenu();
										opt = Helper.readInt("Select a function > ");
									}
								} else if (adminOpt == ADMIN_MANAGE_COURSE) {
									// Manage Courses (Jay Sen)
									setHeader("\nCourse Management Menu\n");
									managementMenu();
									int select = Helper.readInt("Select a function > ");
									while (select != ADMIN_QUIT) {
										if (select == COURSE_VIEW) {
											viewAllCourse(courseList);
										} else if (select == COURSE_ADD) {
											Course c = inputCourse();
											addCourse(courseList, c);
										} else if (select == COURSE_DELETE) {
											Course crs = courseToDelete(courseList);
											deleteCourse(courseList, crs);
										} else {
											System.out.println("Invalid Input");
										}
										managementMenu();
										select = Helper.readInt("Select a function > ");
									}
								} else if (adminOpt == STUDENT_MGMT_OPTION) {
									// Manage Students view, add, delete (xuan)
									studentManagementOptions(studentList);
								} else if (adminOpt == ADMIN_MANAGE_FEE) {
									// Manage Fees (Achi)
									feeMenu();
									int choice = Helper.readInt("Enter a choice >");
									while (choice != FEE_OPTION_QUIT) {
										if (choice == FEE_VIEW) {
											viewAllFee(courseList);
										} else if (choice == FEE_ADD) {
											addFee(courseList);
										} else if (choice == FEE_EDIT) {
											editFee(courseList);
										} else if (choice == FEE_DELETE) {
											deleteFee(courseList);
										} else {
											System.out.println("Invalid input!");
										}
										feeMenu();
										choice = Helper.readInt("Enter a choice >");
									}
								} else if (adminOpt == ADMIN_MANAGE_ENROLMENT) {
									// Manage Enrolment (Justin)
									enrollmentMenu();
									int select = Helper.readInt("Select a function > ");
									while (select != ENROLLMENT_OPTION_QUIT) {
										if (select == ENROLLMENT_VIEW) {
											viewAllEnrollment(studentList);
										} else if (select == ENROLLMENT_ADD) {
											addEnrollment(studentList, courseList);
										} else if (select == ENROLLMENT_EDIT) {
											editEnrollment(studentList, courseList);
										} else if (select == ENROLLMENT_DELETE) {
											deleteEnrollment(studentList, courseList);
										} else {
											System.out.println("Invalid Input!");
										}
										enrollmentMenu();
										select = Helper.readInt("Select a function > ");
									}
								} else if (adminOpt == ADMIN_MANAGE_ATTENDANCE) {
									// Manage Attendance (Jay Sen)
									manageAttendance(attendanceList, courseList);
								} else if (adminOpt == ADMIN_LOGOUT) {
									// Logout
									System.out.println("Thanks for using Tuition Management App!");
								} else {
									System.out.println("Invalid Input");
								}
								AdminMenu();
								adminOpt = Helper.readInt("Enter an option you would like to choose > ");

							}
						} else {
							System.out.println("Password Invalid!");
						}
						break;
					}
				}

				if (!usernameFound) {
					System.out.println("Username Invalid or User not found!");
				}
				// error code and validation
				// Jay Sen
			} else if (option == LOOP_STUDENT) {
				String studUN = Helper.readString("Enter your username > ");
				boolean validStudentFound = false;

				for (int i = 0; i < studentList.size(); i++) {
					if (studUN.equals(studentList.get(i).getUsername())) {
						String studPW = Helper.readString("Enter your password > ");
						validStudentFound = true;
						if (studPW.equals(studentList.get(i).getPassword())) {
							System.out.println("\nWelcome " + studentList.get(i).getStudentName()
									+ " To the Tuition Management App");
							int studOpt;
							do {
								studentMenu();
								String studentID = studentList.get(i).getStudentId();
								studOpt = Helper.readInt("Enter an option you would like to choose > ");
								if (studOpt == STUDENT_VIEW_DETAILS) {
									// View Details
									viewDetails(studentList, studentID);
								} else if (studOpt == STUDENT_VIEW_COURSES) {
									// View Enrolled Courses
									viewEnrolledCourses(studentList, studentID);
								} else if (studOpt == STUDENT_VIEW_ALL_COURSE) {
									// View all Courses
									viewAllCourse(courseList);
								} else if (studOpt == STUDENT_ADD_ENROLMENT) {
									// Enroll in a course
									studentEnrol(studentList, courseList);
								} else if (studOpt == STUDENT_VIEW_ATTENDANCE) {
									// View Attendance
									viewAllAttendances(attendanceList, studentList.get(i).getStudentId());
								} else if (studOpt == STUDENT_QUIT) {
									// Logout
									System.out.println("Thanks for using Tuition Management App!");
									break;
								} else {
									System.out.println("Invalid Option!");
								}
							} while (studOpt != STUDENT_QUIT);
						} else {
							System.out.println("Password Invalid!");
						}

						break; // Exit the loop after valid student is found
					}
				}

				// Check if a valid student was found
				if (!validStudentFound) {
					System.out.println("Username Invalid or User not found!");
				}
			} else if (option == LOOP_INSTRUCTOR) {
				// ask for username and pw from instructor list
				String instructUN = Helper.readString("Enter your username > ");
				boolean usernameFound = false;

				for (int i = 0; i < instructorList.size(); i++) {
					if (instructUN.equals(instructorList.get(i).getUsername())) {
						usernameFound = true;
						String instructPW = Helper.readString("Enter your password > ");
						if (instructPW.equals(instructorList.get(i).getPassword())) {
							System.out.println("\nWelcome " + instructorList.get(i).getInstructorName()
									+ " To the Tuition Management App");
							int instructOpt;
							do {
								InstructorMenu(); // Moved outside of the loop
								instructOpt = Helper.readInt("Enter an option you would like to choose > ");
								if (instructOpt == INSTRUCTOR_VIEW) {
									// View Assigned Courses
									setHeader("View Assigned Course");
									Instructor instructorUN = instructorList.get(i);
									viewAssignedCourses(instructorList, courseList, studentList, instructorUN);
								} else if (instructOpt == INSTRUCTOR_MANAGE_ATTENDANCE) {
									// Manage Attendance Record
									manageAttendance(attendanceList, courseList);
								} else if (instructOpt == INSTRUCTOR_QUIT) {
									// Logout
									System.out.println("Thanks for using Tuition Management App!");
									break;
								} else {
									System.out.println("Invalid Option!");
								}
							} while (instructOpt != INSTRUCTOR_QUIT);
						} else {
							System.out.println("Password Invalid!");
						}
						break; // Break the loop after valid instructor is found
					}
				}

				if (!usernameFound) {
					System.out.println("Username Invalid or User not found!");
				}
			} else {
				System.out.println("Invalid Option!");
			}

		}
		System.out.println("Thanks for using Tuition Management App!");
	}

	// xuan
	private static void studentManagementOptions(ArrayList<Student> studentList) {
		int choice = 0;
		while (choice != 4) {
			studentManagementMenu();
			choice = Helper.readInt("Enter a choice > ");
			if (choice == 1) {
				// viewAllStudents
				viewAllStudents(studentList);
			} else if (choice == 2) {
				// addNewStudent
				Student s = inputNewStudent();
				addNewStudent(studentList, s);
			} else if (choice == 3) {
				// deleteStudent
				Student student = chooseStudentToDelete(studentList);
				deleteStudent(studentList, student);
			} else if (choice == 4) {
				System.out.println("Exiting student ");
				break;
			} else {
				System.out.println("Invalid input!");
			}
		}
	}

// --------------------------------------- FEES (ACHI)-----------------------------------------------------------------

	public static void viewAllFee(ArrayList<Course> courseList) {
		Helper.line(80, "=");
		String output = String.format("%-30s %-20s %s\n", "COURSE TITLE", "FEE TYPE", "FEE");
		for (Course c : courseList) {
			if (c.getFee() == 0)
				output += String.format("%-30s %-20s %s\n", c.getCourseTitle(), "", "");

			else {
				output += String.format("%-30s %-20s $%1.2f\n", c.getCourseTitle(), c.getFeeType(), c.getFee());
			}
		}

		System.out.println(output);
	}

	public static void addFee(ArrayList<Course> courseList) {
		Helper.line(80, "=");
		int i = 1;
		for (Course c : courseList) {
			System.out.println(i + ". " + c.getCourseTitle());
			i++;
		}
		int courseInput = Helper.readInt("Select the course to add fee > ");
		courseInput = courseInput - 1;
		int totalCourse = courseList.size();
		while (courseInput >= totalCourse || courseInput < 0) {
			System.out.println("Invalid course");
			courseInput = Helper.readInt("Select the course to add fee > ");
			courseInput = courseInput - 1;
		}
		double fee = Helper.readDouble("Enter the fee amount > $");
		String type = Helper.readString("Enter fee type > ");
		if (fee >= 0) {
			courseList.get(courseInput).setFee(fee);
			courseList.get(courseInput).setFeeType(type);
			System.out.println("Fee added");
		} else {
			System.out.println("Fee need to be more than $0");
		}
	}

	public static void editFee(ArrayList<Course> courseList) {
		Helper.line(80, "=");
		int i = 1;
		for (Course c : courseList) {
			System.out.println(i + ". " + c.getCourseTitle());
			i++;
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
			if (fee >= 0) {
				courseList.get(courseInput).setFee(fee);
				courseList.get(courseInput).setFeeType(type);
				System.out.println("Fee edited");
			} else {
				System.out.println("Fee must be more than or equal to $0");
			}
		} else {
			System.out.println("The course does not have fee");
		}
	}

	public static void deleteFee(ArrayList<Course> courseList) {
		Helper.line(80, "=");
		int i = 1;
		for (Course c : courseList) {
			System.out.println(i + ". " + c.getCourseTitle());
			i++;
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
		} else {
			System.out.println("This course does not have fee");
		}
	}

	public static void searchFee(ArrayList<Course> courseList, ArrayList<Student> studentList) {
		String search = Helper.readString("Search for an existing fee using student name > ");
		String output = String.format("%-20s %-20s %-10s %1s\n", "STUDENT NAME", "COURSE ENROLLED", "FEE TYPE",
				"FEE AMOUNT");
		for (Course c : courseList) {
			for (Student s : studentList) {
				if (search.equalsIgnoreCase(s.getStudentName())) {
					if (s.getEnrolledCourses().equalsIgnoreCase(c.getCourseCode())) {
						output += String.format("%-20s %-20s %-10s $%1.2f\n", s.getStudentName(),
								s.getEnrolledCourses(), c.getFeeType(), c.getFee());
					}
				} else {
					System.out.println("Student does not exist");
				}
			}
		}
		Helper.line(80, "=");
		System.out.println(output);
		Helper.line(80, "=");
	}

	// ================================= login menus(Isaac)
	// =================================

	// Asfar
	public static void setHeader(String header) {
		Helper.line(40, "=");
		System.out.println(header);
		Helper.line(40, "=");
	}

	// Achi
	public static void feeMenu() {
		setHeader("\n Fee Management \n");
		System.out.println("1. View all fees");
		System.out.println("2. Add fees");
		System.out.println("3. Edit fees");
		System.out.println("4. Delete fees");
		System.out.println("5. Exit");
	}

	public static void LoginMenu() {
		setHeader("\n Tuition App Management Login \n");
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as Student");
		System.out.println("3. Login as Instructor");
		System.out.println("4. End Session");
		Helper.line(40, "=");

	}

	public static void AdminMenu() {
		setHeader("\n Admin Panel \n");
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

	// Jay Sen
	public static void adminManagementMenu() {
		setHeader("\n User Management Menu \n");
		System.out.println("1. Add New User");
		System.out.println("2. View All Users");
		System.out.println("3. Delete User");
		System.out.println("4. Logout");
	}

	// xuan
	public static void studentManagementMenu() {
		setHeader("\n Student Management Panel \n");
		System.out.println("1. View all students");
		System.out.println("2. Add a new student");
		System.out.println("3. Delete an existing student");
		System.out.println("4. Exit");
		Helper.line(40, "=");

	}

	// Jay Sen
	public static void studentMenu() {
		setHeader("\n Student Panel \n");
		System.out.println("1. View Details");
		System.out.println("2. View Enrolled Courses");
		System.out.println("3. View All Courses");
		System.out.println("4. Enrol in a Course");
		System.out.println("5. View Attendance");
		System.out.println("6. Log Out");
		Helper.line(40, "=");
	}

	public static void InstructorMenu() {
		setHeader("\n Instructor Panel \n");
		System.out.println("1. View Assigned Courses");
		System.out.println("2. Manage Attendance Record");
		System.out.println("3. Logout");
		Helper.line(40, "=");
	}

	public static void enrollmentMenu() {
		setHeader("\n Admin Enrollment Panel \n");
		System.out.println("1. View all enrollments");
		System.out.println("2. Add enrollments");
		System.out.println("3. Edit enrollments");
		System.out.println("4. Delete enrollments");
		System.out.println("5. Exit");
		Helper.line(40, "=");
	}

	// Jay Sen
	public static void manageAttendanceMenu() {
		setHeader("\n Attendance Management Menu \n");
		System.out.println("1. Add Attendance");
		System.out.println("2. Delete Attendance");
		System.out.println("3. Exit");
		Helper.line(40, "=");
	}

	// ================================= Course (Asfar)
	// =================================

	public static String retrieveAllCourse(ArrayList<Course> courseList) {
		String output = "";

		for (int i = 0; i < courseList.size(); i++) {

			output += courseList.get(i).toString() + "\n";
		}
		return output;
	}

	public static void viewAllCourse(ArrayList<Course> courseList) {
		String output = String.format("\n%-10s %-20s %-20s %-10s %-12s %-10s %-10s\n", "CODE", "TITLE", "INSTRUCTOR",
				"SCHEDULE", "AVAILABILITY", "FEE", "FEE TYPE");
		output += retrieveAllCourse(courseList);
		System.out.println(output);
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

	// ================================= View assigned course (Asfar)
	// =================================

	public static void viewAssignedCourses(ArrayList<Instructor> instructorList, ArrayList<Course> courseList,
			ArrayList<Student> studentList, Instructor instructorUN) {

		System.out.println("\nAssigned Courses for " + instructorUN.getInstructorName() + ":\n");

		boolean found = false;
		boolean checkEnrolled = false;
		String message = String.format("%-15s %-20s \n", "Student ID", "Student Name");
		for (Course course : courseList) {
			if (course.getCourseCode().equals(instructorUN.getAssignedCourses())) {
				found = true;
				System.out.println("Course Code: " + course.getCourseCode());
				System.out.println("Course Title: " + course.getCourseTitle());
				System.out.println("Course Schedule: " + course.getCourseSchedule());
				System.out.println();

				System.out.println(
						"Enrolled Students in course " + course.getCourseCode() + "(" + course.getCourseTitle() + ")");
				for (Student student : studentList) {
					if (student.getEnrolledCourses().contains(course.getCourseCode())) {
						checkEnrolled = true;
						message += String.format("%-15s %-20s \n", student.getStudentId(), student.getStudentName(),
								student.getEnrolledCourses());
					}
				}

				System.out.println();
				found = true;
			}
		}
		System.out.println(message);

		if (found == false) {
			checkEnrolled = true;
			Helper.line(40, "=");
			System.out.println("No assigned courses found for " + instructorUN.getInstructorName() + "\n");
		}
		if (checkEnrolled == false) {
			Helper.line(40, "=");
			System.out.println("No enrolled students in course " + instructorUN.getAssignedCourses() + "\n");
		}
	}

	// ================================= delete course (Asfar)
	// =================================
	public static Course courseToDelete(ArrayList<Course> courseList) {

		String cCode = Helper.readString("Enter the course code of the course you want to delete > ");
		for (Course c : courseList) {
			if (c.getCourseCode().equals(cCode)) {
				return c;
			}
		}
		return null;

	}

	public static boolean deleteCourse(ArrayList<Course> courseList, Course crs) {

		if (crs != null) {
			for (Course c : courseList) {
				if (c.getCourseCode().equals(crs.getCourseCode())) {
					char verify = Helper.readChar("Confirm deletion of Course: " + crs.getCourseCode() + " ? (Y/N) > ");
					if (verify == 'y' || verify == 'Y') {
						courseList.remove(crs);
						System.out.println("Course deleted!");
						return true;
					} else {
						return false;
					}
				}
			}
		} else {
			System.out.println("Course code not found!");
			return false;
		}
		return false;

	}

	// ================================= View Course & Enrol for Students (Jay Sen)
	// ===========================================

	public static void studentEnrol(ArrayList<Student> studentList, ArrayList<Course> courseList) {
		String courseNo = Helper.readString("Enter the Course code > ");
		for (Student s : studentList) {
			for (Course c : courseList) {
				if (!c.getCourseCode().equals(courseNo)) {
					System.out.println("Course Code does not exist!");
				} else {
					String courseName = c.getCourseTitle();
					s.setEnrolledCourses(courseName);
					System.out.println("You have enrolled in the course!");
				}
			}
		}
	}

	public static void viewEnrolledCourses(ArrayList<Student> studentList, String studentID) {
		String output = "";
		int i = 0;
		for (Student s : studentList) {
			if (s.getStudentId().equals(studentID)) {
				String courseName = s.getEnrolledCourses();
				output += String.format("%d. %s\n", i + 1, courseName);
				i++;
			}
		}
		System.out.println(output);
	}

	public static void viewDetails(ArrayList<Student> studentList, String studentID) {
		for (Student s : studentList) {
			if (s.getStudentId().equals(studentID)) {
				System.out.println("Student ID: " + studentID);
				System.out.println("Student Name: " + s.getStudentName());
				System.out.println("Enrolled Course: " + s.getEnrolledCourses());
				break;
			}
		}
	}

	// ================================= Management of Students for admins (Xuan)
	// ================================

	public static String retrieveAllStudents(ArrayList<Student> studentList) {
		String message = "";

		for (Student s : studentList) {
			message += String.format("%-25s %-20s %-15s %.2f\n", s.getStudentId(), s.getStudentName(),
					checkAttendCourse(s), s.getCourseFee());
		}
		return message;
	}

	public static void viewAllStudents(ArrayList<Student> studentList) {
		setHeader("VIEW ALL STUDENTS");
		System.out.println("");
		String message = String.format("%-25s %-20s %-15s %-15s\n", "Student ID", "Student Name", "Enrolled Course",
				"Pending Fee");

		message += retrieveAllStudents(studentList);

		System.out.println(message);
	}

	public static Student inputNewStudent() {
		setHeader("ADD NEW STUDENT");
		String studentID = Helper.readString("Please enter student ID > ");
		boolean isValid = Pattern.matches("\\d{8}", studentID);
		while (!isValid) {
			System.out.println("Invalid StudentID");
			studentID = Helper.readString("Please enter student ID > ");
			isValid = Pattern.matches("\\d{8}", studentID);

		}

		String studentName = Helper.readString("Enter student name > ");
		String pw = confirmPw();
		String username = Helper.readString("Enter your username > ");
		Student student = new Student(studentName, studentID, username, pw); // ADD NEW STUDENT TO ARRAYLIST
		return student;

	}

	public static boolean addNewStudent(ArrayList<Student> studentList, Student student) {

		if (student != null) {
			for (Student s : studentList) {
				if (s.getStudentId().equals(student.getStudentId())) {
					System.out.println("Student already exist!");
					return false;
				}
			}
			studentList.add(student);
			System.out.println("Student successfully added!");
			return true;
		} else {
			return false;
		}
	}

	// declare which student to delete
	public static Student chooseStudentToDelete(ArrayList<Student> studentList) {

		if (studentList.size() == 0) {
			System.out.println("There is no student inside, please add a student first.");
			return null;
		} else {
			setHeader("DELETE A STUDENT");
			String deleteID = Helper.readString("Enter Student ID to delete > ");
			boolean isValid = Pattern.matches("\\d{8}", deleteID);
			while (!isValid) {
				System.out.println("The student ID is invalid!");
				deleteID = Helper.readString("Enter Student ID to delete > ");
				isValid = Pattern.matches("\\d{8}", deleteID);
			}
			for (Student s : studentList) {
				if (s.getStudentId().equals(deleteID)) {
					return s;
				}
			}
			System.out.println("No such student found!");
			return null;
		}

	}

	public static boolean deleteStudent(ArrayList<Student> studentList, Student student) {
		if (student != null) {
			if (Pattern.matches("\\d{8}", student.getStudentId())) {
				for (Student s : studentList) {
					if (s.getStudentId().equalsIgnoreCase(student.getStudentId())) {
						char verify = Helper
								.readChar("Confirm deletion of student ID: " + student.getStudentId() + " ?(Y/N) > ");
						if (verify == 'Y' | verify == 'y') {
							studentList.remove(student); // REMOVE STUDENT FROM ARRAYLIST
							System.out.println("Student successfully deleted!");
							return true;
						} else {
							return false;
						}
					}
				}
			} else {
				System.out.println("The student ID is invalid!");
				return false;
			}
		}
		System.out.println("DELETION FAILED");
		return false;
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

	// ================================= Manage Enrollment (Justin)
	// ================================

	public static void viewAllEnrollment(ArrayList<Student> studentList) {
		Helper.line(40, "=");
		String output = String.format("%-15s %-15s %s\n", "STUDENT NAME", "STUDENT ID", "ENROLLED COURSE");
		for (Student c : studentList) {
			output += String.format("%-15s %-15s %s\n", c.getStudentName(), c.getStudentId(), c.getEnrolledCourses());
			checkAttendCourse(c);
		}
		System.out.println(output);
	}

	public static void addEnrollment(ArrayList<Student> studentList, ArrayList<Course> courseList) {

		for (int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);
			System.out.println(i + 1 + ". " + course.getCourseTitle());
		}
		boolean valid = false;
		int courseInput = Helper.readInt("Select the course to add enrollment > ");
		courseInput = courseInput - 1;
		String add = courseList.get(courseInput).getCourseCode();
		String studentID = Helper.readString("Enter the student ID > ");
		for (Student s : studentList) {
			if (s.getStudentId().equals(studentID) && !s.getEnrolledCourses().equals(add)) {
				s.setEnrolledCourses(add);
				valid = true;
			}
		}
		if (valid == true) {
			System.out.println("Enrollment added");
		} else {
			System.out.println("Failed to add Enrollment");
		}

	}

	public static void editEnrollment(ArrayList<Student> studentList, ArrayList<Course> courseList) {
		for (int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);
			System.out.println(i + 1 + ". " + course.getCourseTitle());
		}
		String studentID = Helper.readString("Select a student to edit Enrolment > ");

		for (Student s : studentList) {
			if (s.getStudentId().equals(studentID)) {
				String enrollment = Helper.readString("Enter the new enrollment > ");
				s.setEnrolledCourses(enrollment);
				System.out.println("Enrollment edited");
			}
		}
	}

	public static void deleteEnrollment(ArrayList<Student> studentList, ArrayList<Course> courseList) {
		for (int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);
			System.out.println(i + 1 + ". " + course.getCourseTitle());
		}
		boolean valid = false;
		int courseInput = Helper.readInt("Select the course to delete enrollment > ");
		courseInput = courseInput - 1;
		String del = courseList.get(courseInput).getCourseCode();
		String studentID = Helper.readString("Enter the student ID > ");
		for (Student s : studentList) {
			if (s.getStudentId().equals(studentID) && s.getEnrolledCourses().equals(del)) {
				s.setEnrolledCourses("");
				valid = true;
			}
		}
		if (valid == true) {
			System.out.println("Enrollment Deleted");
		} else {
			System.out.println("Failed to delete Enrollment");
		}
	}

	// =============================================== Isaac
	// ===============================================
	public static String showAdmins(ArrayList<Admin> adminList) {
		String msg = String.format("%-25s %-20s \n", "NAME", "USERID");
		for (Admin a : adminList) {
			msg += String.format("%-25s %-20s \n", a.getName(), a.getUserID());
		}
		return msg;
	}

	public static void viewUsers(ArrayList<Admin> adminList) {
		Helper.line(40, "=");
		System.out.println("View Users");
		Helper.line(40, "=");
		String message = "";
		message += showAdmins(adminList);
		System.out.println(message);

	}

	public static void addAdmin(ArrayList<Admin> adminList, Admin admin) {
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
		Helper.line(50, "=");
		System.out.println("Add new Admin");
		Helper.line(50, "=");
		String adminName = Helper.readString("Please enter Admin name > ");
		String userID = Helper.readString("Enter User ID > ");
		String username = Helper.readString("Enter username > ");
		String pass = Helper.readString("Enter your password > ");
		Admin admin = new Admin(adminName, userID, username, pass);
		return admin;
	}

	public static Admin adminCheck(ArrayList<Admin> adminList) {
		if (adminList.isEmpty()) {
			System.out.println("There are no admins, please add an admin first.");
			return null;
		}
		Helper.line(50, "=");
		System.out.println("Delete an Admin");
		Helper.line(50, "=");
		String deleteID = Helper.readString("Enter Admin ID to delete > ").trim();
		for (Admin a : adminList) {
			if (a.getUserID().equals(deleteID)) {
				return a; // Found the admin, return it
			}
		}
		System.out.println("No such admin found!");
		return null;
	}

	public static boolean deleteAdmin(ArrayList<Admin> adminList, Admin admin) {
		char verify = Helper.readChar("Confirm deletion of admin ID: " + admin.getUserID() + " ? (Y/N) > ");
		if (verify == 'Y' || verify == 'y') {
			if (adminList.remove(admin)) {
				return true; // Admin removed successfully
			} else {
				System.out.println("Error deleting admin.");
				return false; // Deletion failed
			}
		} else {
			System.out.println("Admin deletion cancelled.");
			return false; // Deletion cancelled
		}
	}

	// ==================================== Attendance (Jay Sen)
	// =============================================

	public static void manageAttendance(ArrayList<Attendance> attendanceList, ArrayList<Course> courseList) {
		manageAttendanceMenu();

		while (true) {
			int option = Helper.readInt("Enter an option > ");

			if (option == 1 || option == 2 || option == 3) {
				if (option == 3) {
					break;
				}
				String studentID = Helper.readString("Indicate the Student ID to update the Attendance > ");
				boolean studentFound = false;

				for (Attendance a : attendanceList) {
					if (a.getStudentID().equals(studentID)) {
						studentFound = true;

						if (option == 1) {
							addAttendance(attendanceList, studentID, courseList);
						} else if (option == 2) {
							deleteAttendance(attendanceList, studentID);
						}
						break;
					}
				}
				if (!studentFound) {
					System.out.println("Student ID not found.");
				}
			} else {
				System.out.println("Invalid Option!");
			}
		}
	}

	public static void addAttendance(ArrayList<Attendance> attendanceList, String studentID,
			ArrayList<Course> courseList) {

		int lesson = Helper.readInt("Lesson of Attendance > ");
		String attendance = Helper.readString("Present/Absent (P/A) ");
		String course = Helper.readString("Enter Course Code > ");
		for (Course c : courseList) {
			if (c.getCourseCode().equals(course)) {
				Attendance newAttendance = new Attendance(studentID, attendance, lesson, course);
				attendanceList.add(newAttendance);
				System.out.println("Attendance added successfully.");
			} else {
				System.out.println("Course Code is Invalid");
			}
		}
	}

	// Static method to view all attendance records
	public static void viewAllAttendances(ArrayList<Attendance> attendanceList, String studentID) {
		String output = "";
		setHeader("All Attendance Records");
		System.out.println(String.format("%-20s %-20s %-20s", "STUDENT ID", "LESSON", "ATTENDANCE"));
		for (Attendance a : attendanceList) {

			output += String.format("%-20s %-20d %-20s\n", a.getStudentID(), a.getLesson(), a.getAttendance());
		}
		System.out.println(output);
	}

	// Static method to delete an existing attendance record
	public static void deleteAttendance(ArrayList<Attendance> attendanceList, String studentID) {
		int lesson = Helper.readInt("Lesson of Attendance > ");
		for (int i = 0; i < attendanceList.size(); i++) {
			Attendance attendance = attendanceList.get(i);
			if (attendance.getStudentID().equals(studentID) && attendance.getLesson() == lesson) {
				String confirm = Helper.readString("Confirm Deletion of Attendance (Y/N) > ");
				if (confirm.equalsIgnoreCase("y")) {
					attendanceList.remove(i);
					System.out.println("Attendance deleted successfully.");
					return;
				}
			}
		}
		System.out.println("Attendance record not found.");
	}
}
