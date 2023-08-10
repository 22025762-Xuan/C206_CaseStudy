import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

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

	@Before
	public void setUp() throws Exception {

		sofie = new Student("sofie", "22001234", 0.00, "sofie123", "student1");
		adam = new Student("adam", "22001235", 0.00, "adam123", "student2");
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

	}

	@Test
	public void testDeleteStudent() {
		assertNotNull("Test if there is valid student arraylist to add to", studentList);
		C206_CaseStudy.addNewStudent(studentList, sofie);

		// delete an existing student - normal
		Boolean outcome = C206_CaseStudy.deleteStudent(studentList, sofie);
		assertTrue("Test if student can be deleted", outcome);

		// delete a student with invalid studentID - error
		Boolean ok = C206_CaseStudy.deleteStudent(studentList,
				new Student("sofie", "22101", 0.00, "sofie123", "student1"));
		assertFalse("Test if student cannot be deleted", ok);

		// delete a student with no student in ArrayList - error
		Boolean result = C206_CaseStudy.deleteStudent(studentList, adam);
		assertFalse("Test that student cannot be deleted", result);
	}
	@Test
	public void testDeleteFee() {
		c206 = new Course("c206", "Software Dev", "nancy", "Schedule1", 123);
		courseList.add(c206);
		courseList.add(c209);
		C206_CaseStudy.viewAllCourse(courseList);
		// fee variable is not null, so that we can delete a fee - boundary
		assertNotNull("Check if there is fee variable in the course to delete fee to", courseList.get(0).getFee());
		// Given that Software Dev have a fee of 123, after deleting fees, the fees is $0.00 - normal
		C206_CaseStudy.deleteFee(courseList);
		assertSame("Test that fee is now deleted",0, courseList.get(0).getFee());
		//Given that Adv. OOP does not have fee, the fee will not be deleted - error
		C206_CaseStudy.deleteFee(courseList);
		assertSame("This course does not have fee","This course does not have fee");
		C206_CaseStudy.viewAllCourse(courseList);
	}
	@Test
	public void testAddFee() {
		courseList.add(c206);
		courseList.add(c209);
		C206_CaseStudy.viewAllCourse(courseList);
		// fee variable is not null, so that we can add a new fee - boundary
		assertNotNull("Check if there is fee variable in the course to add fee to", courseList.get(0).getFee());
		// Given the fees is 0.00 for Software Dev, after adding fees, the fees is now $1.00 - normal
		C206_CaseStudy.addFee(courseList);
		assertEquals(1.00, c206.getFee(), 0.01);
		// Given the fees is 0.00 for Adv. OOP, after adding fees, the fees is now $20.00 - normal
		C206_CaseStudy.addFee(courseList);
		assertEquals(20.00, c209.getFee(), 0.01);
		C206_CaseStudy.viewAllCourse(courseList);
	}
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
