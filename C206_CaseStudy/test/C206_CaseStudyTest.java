import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	// xuan
	private Student sofie;
	private Student adam;
	private Course c206;
	private Course c209;
	private Admin john;
	private Admin ben;
	private Instructor alec;
	private Instructor nancy;

	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	private ArrayList<Admin> adminList;
	private ArrayList<Instructor> instructorList;

	public C206_CaseStudyTest() {
		super();
	}

	// xuan
	@Before
	public void setUp() throws Exception {

		sofie = new Student("sofie", "22001234", "sofie123", "student1");
		adam = new Student("adam", "22001235", "adam123", "student2");
		c206 = new Course("c206", "Software Dev", "nancy", "Schedule1");
		c209 = new Course("c209", "Adv. OOP", "alec", "Schedule2");
		john = new Admin("john", "admin1", "john123", "adminpw1");
		ben = new Admin("ben", "admin2", "ben123", "adminpw2");
		nancy = new Instructor("nancy", "c206", "nancy123", "instructorpw1");
		alec = new Instructor("alec", "c209", "alec123", "instructorpw2");
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		adminList = new ArrayList<Admin>();
		instructorList = new ArrayList<Instructor>();
	}

	// xuan
	@Test
	public void testViewAllStudents() {
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Student Arraylist to retrieve item from", studentList);

		// test if the list of students retrieved is empty - boundary
		String allStudents = C206_CaseStudy.retrieveAllStudents(studentList);
		String testOutput = "";
		assertEquals("Test that the retrieved Studentlist is empty?", testOutput, allStudents);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addNewStudent(studentList, sofie);
		C206_CaseStudy.addNewStudent(studentList, adam);
		assertEquals("Test that chromebook arraylist size is 2", 2, studentList.size());

		// test if the expected output string same as the list of students retrieved
		allStudents = C206_CaseStudy.retrieveAllStudents(studentList);
		testOutput = String.format("%-25s %-20s %-15s %.2f\n", "22001234", "sofie", "No Course", 0.00);
		testOutput += String.format("%-25s %-20s %-15s %.2f\n", "22001235", "adam", "No Course", 0.00);
		assertEquals("Test that ViewAllChromebooklist", testOutput, allStudents);
	}

	// xuan
	@Test
	public void testAddNewStudents() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Student arraylist to add to", studentList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addNewStudent(studentList, sofie);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that sofie is added", sofie, studentList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addNewStudent(studentList, adam);
		assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
		assertSame("Check that adam is added", adam, studentList.get(1));

		// try add an existing student - sofie - error
		Boolean result = C206_CaseStudy.addNewStudent(studentList, sofie);
		assertFalse("Test that student cannot be added", result);
		assertEquals("Check that Student arraylist size remains unchanged", 2, studentList.size());

		
	}

	// xuan
	@Test
	public void testDeleteStudent() {
		assertNotNull("Test if there is valid student arraylist to add to", studentList);
		C206_CaseStudy.addNewStudent(studentList, sofie);

		// delete an existing student - normal
		Boolean outcome = C206_CaseStudy.deleteStudent(studentList, sofie);
		assertTrue("Test if student can be deleted", outcome);

		// delete a student with invalid studentID - error
		Boolean ok = C206_CaseStudy.deleteStudent(studentList, new Student("sofie", "22101", "sofie123", "student1"));
		assertFalse("Test if student cannot be deleted", ok);

		// delete a student with no student in ArrayList - error
		Boolean result = C206_CaseStudy.deleteStudent(studentList, adam);
		assertFalse("Test that student cannot be deleted", result);
	}

	// Achi
	@Test
	public void testviewAllFee() {
		// Test if course is not null but empty - boundary
		assertNotNull("Test if there is course in the courseList to retrieve item from", courseList);
		courseList.add(c206);
		courseList.add(c209);
		// Given that the fee for Adv. OOP is empty, after adding $100 fee, test if the
		// $100 fee is display for Adv. OOP
		c209.setFee(100.00);
		c209.setFeeType("Exam");
		assertEquals("Test that fee for Adv. OOP is display as $100", 100, c209.getFee(), 0.01);
		C206_CaseStudy.viewAllFee(courseList);
		// Given that the fee for Software Dev is empty, after adding $150 fee, test if
		// the $150 fee is display for Software Dev
		c206.setFee(150.00);
		c206.setFeeType("Tuition");
		assertEquals("Test that fee for Software dev is display as $150", 150, c206.getFee(), 0.01);
		C206_CaseStudy.viewAllFee(courseList);
	}

	// Achi
	@Test
	public void testAddFee() {
		// fee variable is not null, so that we can add a new fee - boundary
		assertNotNull("Check if there is course in the courseList to add fee to", courseList);
		c206 = new Course("c206", "Software Dev", "nancy", "Schedule1");
		courseList.add(c206);
		courseList.add(c209);
		// Given the fees is 0.00 for Software Dev, after adding fees, the fees is now
		// $1.00 - normal
		C206_CaseStudy.addFee(courseList);
		assertEquals(1.00, c206.getFee(), 0.01);
		// Given the fees is 0.00 for Adv. OOP, after adding fees, the fees is now
		// $20.00 - normal
		C206_CaseStudy.addFee(courseList);
		assertEquals(20.00, c209.getFee(), 0.01);
		C206_CaseStudy.viewAllCourse(courseList);
	}

	// Achi
	@Test
	public void testDeleteFee() {
		// fee courseList is not null, so that we can delete a fee - boundary
		assertNotNull("Check if there is course in the courseList to delete fee to", courseList);

		c206 = new Course("c206", "Software Dev", "nancy", "Schedule1", 123, "Exam");
		courseList.add(c206);
		courseList.add(new Course("c209", "Adv. OOP", "alec", "Schedule2"));
		// Given that Software Dev have a fee of 123, after deleting fees, the fees is
		// $0.00 - normal
		C206_CaseStudy.deleteFee(courseList);
		assertEquals("Test that the fee is deleted", 0, c206.getFee(), 0.01);
		// Given that there are only Software Dev have fees and if we choose Adv. OOP,
		// the fee will not be deleted - error
		C206_CaseStudy.deleteFee(courseList);
		assertEquals("Test that fee for Advance OOP is still 0.00", 0, c209.getFee(), 0.01);
		C206_CaseStudy.viewAllCourse(courseList);
	}

	// Achi
	@Test
	public void testEditFee() {
		// fee courseList is not null, so that we can delete a fee - boundary
		assertNotNull("Check if there is course in the courseList to edit fee", courseList);

		c206 = new Course("c206", "Software Dev", "nancy", "Schedule1", 123, "Exam");
		courseList.add(c206);
		courseList.add(new Course("c209", "Adv. OOP", "alec", "Schedule2", 20, "Exam"));
		// Given that Software Dev have a fee of 123, after editing fees, the fees is
		// $10.00
		C206_CaseStudy.editFee(courseList);
		assertEquals("Test that the fee is edited to $10", 10, c206.getFee(), 0.01);
		// Given that Software Dev have a fee of $20 after editing the fee will be
		// $1.23,
		// the fee type will change to tuition
		C206_CaseStudy.editFee(courseList);
		assertEquals("Test that fee for Advance OOP is $1.23", 1.23, c209.getFee(), 0.01);
	}

	// Asfar
	@Test
	public void testAddCourse() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Course arraylist to add to", courseList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addCourse(courseList, c206);
		assertEquals("Check that Course arraylist size is 1", 1, courseList.size());
		assertSame("Check that c206 is added", c206, courseList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addCourse(courseList, c209);
		assertEquals("Check that Student arraylist size is 2", 2, courseList.size());
		assertSame("Check that c209 is added", c209, courseList.get(1));

	}

	// Asfar
	@Test
	public void testDeleteCourse() {
		// Test setup: Add some courses to the courseList
		courseList.add(c206);
		courseList.add(c209);

		// Ensure that the courseList is not null before deletion - boundary check
		assertNotNull("Check if there is a course in the courseList to delete", courseList);

		// Test deletion of a course
		// Course code to be deleted
		boolean courseDeleted = C206_CaseStudy.deleteCourse(courseList, c206);

		// Test if course can delete
		assertTrue("Check that a course is deleted", courseDeleted);
		// test that only one course remaining after deleting one
		assertEquals("Check that the courseList size is reduced to 1", 1, courseList.size());
		// Test that the coruse remaining is c209
		assertSame("Check that the correct course is deleted", c209, courseList.get(0));
	}

	// Asfar
	@Test
	public void testRetrieveAllCourse() {

		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Course arraylist to retrieve item from", courseList);

		// test if the list of courses retrieved is empty - boundary
		String allCourse = C206_CaseStudy.retrieveAllCourse(courseList);
		String testOutput = "";
		assertEquals("Test that the retrieved courseList is empty?", testOutput, allCourse);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addCourse(courseList, c206);
		C206_CaseStudy.addCourse(courseList, c209);
		assertEquals("Test that course arraylist size is 2", 2, courseList.size());

		// test if the expected output string same as the list of course retrieved

		allCourse = C206_CaseStudy.retrieveAllCourse(courseList);

		testOutput = "";
		for (int i = 0; i < courseList.size(); i++) {

			testOutput += courseList.get(i).toString() + "\n";

		}

		assertEquals("Test that viewAllCourse", testOutput, allCourse);

	}

	// Isaac
	@Test
	public void testRetrieveAllUser() {

		// Test if Admin list is not null and empty
		assertNotNull("Test if there is valid admin arraylist to add to", adminList);
		assertEquals("Test that the admin arraylist is empty.", 0, adminList.size());
		// Attempt to retrieve the Admin
		String allAdmin = C206_CaseStudy.showAdmins(adminList);
		String testOutput = String.format("%-25s %-20s \n", "NAME", "USERID");
		;
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allAdmin);
	}

	// Isaac
	@Test
	public void testAddUser() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Admin arraylist to add to", adminList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addAdmin(adminList, john);
		assertEquals("Check that admin arraylist size is 1", 1, adminList.size());
		assertSame("Check that john is added", john, adminList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addAdmin(adminList, ben);
		assertEquals("Check that Admin arraylist size is 2", 2, adminList.size());
		assertSame("Check that ben is added", ben, adminList.get(1));

	}

	// Isaac
	@Test
	public void testDeleteUser() {

		Admin john = new Admin("john", "admin1", "john123", "adminpw1");
		Admin ben = new Admin("ben", "admin2", "ben123", "adminpw2");
		adminList.add(john);
		adminList.add(ben);

		assertNotNull("Check if there is an admin in the adminList to delete", adminList);

		boolean adminDeleted = C206_CaseStudy.deleteAdmin(adminList, john);

		assertTrue("Check that an admin is deleted", adminDeleted);
		assertEquals("Check that the adminList size is reduced to 1", 1, adminList.size());
		assertSame("Check that the correct admin is deleted", ben, adminList.get(0));
	}

	// Justin
		@Test
		public void testViewAllEnrollments() {
			// Test that student is not null but empty - boundary
			assertNotNull("Test if there is student in the studentList to retrieve item from", studentList);
			studentList.add(sofie);
			studentList.add(adam);

			// Given that the enrolled course for sofie is empty, after adding C209 course,
			// test if the course enrollment is displayed for sofie
			sofie.setEnrolledCourses("C209");
			assertEquals("C209", sofie.getEnrolledCourses());
			C206_CaseStudy.viewAllEnrollment(studentList);

			// Given that the enrolled course for adam is empty, after adding C206 course,
			// test if the course enrollment is displayed for adam
			adam.setEnrolledCourses("C206");
			assertEquals("C206", adam.getEnrolledCourses());
			C206_CaseStudy.viewAllEnrollment(studentList);

		}

		@Test
		public void testAddEnrollment() {
			// test that there is a valid student to add enrollment to - boundary
			assertNotNull("Check if there is valid Student in the StudentList to add to", studentList);
			adam = new Student("adam", "22001235", "c206", "adam123", "student2");
			studentList.add(sofie);
			studentList.add(adam);
			courseList.add(c206);
			courseList.add(c209);

			// Given that adam is already enrolled into C206, when trying to add another
			// course called C206, the add will fail - error
			C206_CaseStudy.addEnrollment(studentList, courseList);
			assertEquals("c206" , adam.getEnrolledCourses());
			
			// Given that sofie is not enrolled in any courses, after adding enrollment, the
			// course enrolled is now C209 - normal
			C206_CaseStudy.addEnrollment(studentList, courseList);
			assertEquals("c209", sofie.getEnrolledCourses());

			C206_CaseStudy.viewAllEnrollment(studentList);

		}

		@Test
		public void testDeleteEnrollment() {
			// test that there is a valid student to delete enrollment from - boundary
			assertNotNull("Check if there is valid Student in the StudentList to delete from", studentList);
			Student adam = new Student("adam", "22001235", "c206", "adam123", "student2");
			studentList.add(sofie);
			studentList.add(adam);
			courseList.add(c206);
			courseList.add(c209);

			// Given that sofie does not have a course enrollment, there will be nothing
			// changed after the deletion of enrollment - error
			C206_CaseStudy.deleteEnrollment(studentList, courseList);
			assertEquals("", sofie.getEnrolledCourses());

			// Given that adam is enrolled in the C206 course, after deletion the enrolled
			// course will be deleted - normal
			C206_CaseStudy.deleteEnrollment(studentList, courseList);
			assertEquals("", adam.getEnrolledCourses());
			C206_CaseStudy.viewAllEnrollment(studentList);

		}

	// Jay Sen

	public void testConstructorAndGetters() {
		String studentID = "12345678";
		String attendance = "P";
		int lesson = 3;
		String module = "c327";

		Attendance attendanceObj = new Attendance(studentID, attendance, lesson, module);

		assertEquals(studentID, attendanceObj.getStudentID());
		assertEquals(attendance, attendanceObj.getAttendance());
		assertEquals(lesson, attendanceObj.getLesson());
		assertEquals(module, attendanceObj.getModule());
	}

	@Test
	public void testSetters() {
		Attendance attendanceObj = new Attendance("12345678", "P", 3, "c327");

		attendanceObj.setStudentID("12345678");
		attendanceObj.setAttendance("A");
		attendanceObj.setLesson(5);
		attendanceObj.setModule("c327");

		assertEquals("12345678", attendanceObj.getStudentID());
		assertEquals("A", attendanceObj.getAttendance());
		assertEquals(5, attendanceObj.getLesson());
		assertEquals("c327", attendanceObj.getModule());
	}

	// xuan
	@After
	public void tearDown() throws Exception {
		sofie = null;
		adam = null;
		c206 = null;
		c209 = null;
		john = null;
		ben = null;
		alec = null;
		nancy = null;
		studentList = null;
		courseList = null;
		adminList = null;
		instructorList = null;

	}
}
