
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseCat {

	private ArrayList<Course> courseList;

	public CourseCat() {
		courseList = LoadfromDb();
	}

	private static ArrayList<Course> LoadfromDb() {
		// TODO Auto-generated method stub
		// In real life course would be loaded from database or a hex file on disk or
		// atleast
		// sort of file from disc. So imagine this is the loaded from the database.
		ArrayList<Course> imaginaryDB = new ArrayList<Course>();
		imaginaryDB.add(new Course("A", 100));
		imaginaryDB.add(new Course("B", 200));
		imaginaryDB.add(new Course("C", 300));
		imaginaryDB.add(new Course("D", 400));
		imaginaryDB.add(new Course("E", 500));
		imaginaryDB.add(new Course("F", 600));
		imaginaryDB.add(new Course("G", 700));

		return imaginaryDB;
	}

	/**
	 * searchCat searches the course based on the name
	 * 
	 * @param courseName name of the course
	 * @return the list of courses
	 */
	public ArrayList<Course> searchCat(String courseName) {

		ArrayList<Course> foundCourses = new ArrayList<Course>();

		for (Course c : courseList) {
			if (c.getCourseName().equalsIgnoreCase(courseName))
				foundCourses.add(c);

		}

		// return the courses whose name matches with the course names
		return foundCourses;
	}

	/**
	 * searchCat searches the course based on the name and the number
	 * 
	 * @param courseName name of the course
	 * @param courseNum  number of the course
	 * @return the list of courses
	 */

	public Course searchCat(String courseName, int courseNum) {

		for (Course c : courseList) {
			if (c.getCourseName().equals(courseName) && c.getCourseNum() == courseNum)
				return c;
		}

		return null;
	}

	/**
	 * createOffering creates the offering for a course. It takes offering name and
	 * cap, along with the course as arguments
	 * 
	 * @param theCourse represents the course
	 * @param secNum    section number of the offering
	 * @param secCap    section cap of the offering
	 */
	public void createOffering(Course theCourse, int secNum, int secCap) {
		if (theCourse != null) {
			Offering theOffering = new Offering(secNum, secCap);
			theOffering.setTheCourse(theCourse); // set the courseObject to the course
			theCourse.addOffering(theOffering);

		}

	}

	/**
	 * viewAllCourses gets the list of all the courses
	 * 
	 * @return list of all the courses
	 */
	public String viewAllCourses() {
		String s = "";
		for (Course i : courseList) {
			s = s + i.toString();
			s = s + "\n";
		}
		return s;
	}

	/**
	 * searchCatalogueCourses() calls the searchCat method to get the reuired course
	 * from the catalogue
	 * 
	 * @param reader object of type BufferedReader
	 * @throws IOException
	 */
	public void searchCatalogueCourses(BufferedReader reader) throws IOException {
		System.out.println("How do you want to search for courses.\n");
		System.out.println("1. Enter 1 if you want to search the course catalogue based on the course name");
		System.out.println(
				"2. Enter 2 if you want to search the course catalogue based on the course name and course num\n");
		System.out.print("Enter a number corresponding to the operation to be performed here : ");
		String input = reader.readLine();
		int operation = -1;
		try {
			operation = Integer.parseInt(input.strip());
			if (!((operation == 1) || (operation == 2)))
				throw new ArithmeticException();
		} catch (Exception e) {
			System.out.println("..........................................");
			System.out.println("Invalid input. Please read below carfully");
			System.out.println("..........................................");
			return;
		}

		if (operation == 1) {
			System.out.print("Enter the name of the course : ");
			String nameFirst = reader.readLine();
			if (this.searchCat(nameFirst).size() == 0) {
				System.out.println("No courses found for name  " + nameFirst);
				return;
			}
			System.out.println("Courses found are : ");
			ArrayList<Course> listCourse = this.searchCat(nameFirst);
			for (Course i : this.searchCat(nameFirst))
				System.out.println(i.toString());
		}

		if (operation == 2) {
			System.out.print("Enter the name of course : ");
			String name = reader.readLine();
			System.out.print("Enter the number of course : ");
			String num = reader.readLine();
			int numCourse = -1;
			try {
				numCourse = Integer.parseInt(num.strip());
			} catch (Exception e) {
				System.out.println("..............................................");
				System.out.println("\nInvalid input. Entered number is not integer");
				System.out.println("Please try again\n");
				System.out.println("..............................................");
				return;
			}
			if (this.searchCat(name, numCourse) != null)
				System.out.println(this.searchCat(name, numCourse).toString());
			else
				System.err.println(name + " " + numCourse + " not found");

		}

	}

	/**
	 * viewStudentCourses() calls the getStudentCourses() to get the courses in
	 * which a particular student is registered in.
	 * 
	 * @param reader object og type BufferedReader
	 * @throws IOException
	 */
	public void viewStudentCourses(BufferedReader reader) throws IOException {

		System.out.print("Enter the name of student : ");
		String name = reader.readLine();
		System.out.print("Enter id of student : ");
		String num = reader.readLine();
		int numID = -1;
		try {
			numID = Integer.parseInt(num.strip());
		} catch (Exception e) {
			System.out.println("..............................................");
			System.out.println("\nInvalid input. Entered number is not integer");
			System.out.println("Please try again\n");
			System.out.println("..............................................");
			return;
		}

		if ("".equals(this.getStudentCourses(name, numID)))
			System.err.println("Student with name " + name + " and ID " + numID + " is not registered in any course");
		else {
			System.out.println("\nStudent is registered in following courses : ");
			System.out.println(this.getStudentCourses(name, numID));
		}

	}

	/**
	 * getStudentCourses gets based on the student name and the number searches all
	 * the courses taken by that student
	 * 
	 * @param name represents the student name
	 * @param num  represents the student id
	 * @return all the courses for that student
	 */
	public String getStudentCourses(String name, int num) {

		String s = "";

		for (Course cor : this.courseList)
			for (Offering or : cor.getOfferingList())
				for (Registration reg : or.getStudentList())
					if (reg.getTheStudent().getStudentName().equals(name) && reg.getTheStudent().getStudentId() == num)
						s = s + cor.getCourseName() + " " + cor.getCourseNum() + "\n";

		return s;

	}

	public Student getTheStudent(String name, int num) {

		for (Course cor : this.courseList)
			for (Offering or : cor.getOfferingList())
				for (Registration reg : or.getStudentList())
					if (reg.getTheStudent().getStudentName().equals(name) && reg.getTheStudent().getStudentId() == num)
						return reg.getTheStudent();

		return null;

	}

	/**
	 * addCourse calls the function registerForCourse of class Student to register
	 * the student in particular course.
	 * 
	 * @param stu    represents list of object of students
	 * @param reader an object of type BufferedReader
	 * @throws IOException
	 */
	public void addCourse(ArrayList<Student> stu, BufferedReader reader) throws IOException {

		System.out.print("Enter the name of student for which registration is to be done : ");
		String studentName = reader.readLine();
		int studentID = -1000;
		System.out.print("Enter the id of the student : ");
		try {
			String studentIDString = reader.readLine();
			studentID = Integer.parseInt(studentIDString.strip());
		} catch (NumberFormatException e) {
			System.out.println("\nInput is invalid. Input must be an integer\nPlease try again");
			return;
		}

		Student theStudent = null;
		for (Student s : stu)
			if (s.getStudentName().equals(studentName) && s.getStudentId() == studentID)
				theStudent = s;

		if (theStudent == null) {
			System.out.println("Student '" + studentName + "' with ID '" + studentID + "' not found");
			return;
		}

		System.out.print("Enter the name of course : ");
		String name = reader.readLine();
		System.out.print("Enter number of course : ");
		String courseNumString = reader.readLine();
		int courseNum = -1;
		int courseSectionNum = -1;
		try {
			courseNum = Integer.parseInt(courseNumString.strip());
			System.out.print("Enter section cap : ");
			String courseSectionString = reader.readLine();
			courseSectionNum = Integer.parseInt(courseSectionString.strip());
		} catch (Exception e) {
			System.out.println("..............................................");
			System.out.println("\nInvalid input. Entered number is not integer");
			System.out.println("Please try again\n");
			System.out.println("..............................................");
			return;
		}

		System.out.println(theStudent.registerForCourse(this, name, courseNum, courseSectionNum));

	}

	/**
	 * removeCourse calls the function deleteCourse() of class Student to delete the
	 * registration of the student from a particular offering
	 * 
	 * @param reader an object of type BufferedReader
	 * @throws IOException
	 */
	public void removeCourse(BufferedReader reader) throws IOException {

		System.out.print("Enter the name of student for which registration is to be removed : ");
		String studentName = reader.readLine();
		int studentID = -1000;
		System.out.print("Enter the id of the student : ");
		try {
			String studentIDString = reader.readLine();
			studentID = Integer.parseInt(studentIDString.strip());
		} catch (NumberFormatException e) {
			System.out.println("\nInput is invalid. Input must be an integer\nPlease try again");
			return;
		}
		Student theStudent = this.getTheStudent(studentName, studentID);
		if (theStudent == null) {
			System.out.println("Student " + studentName + " with ID" + studentID + " is not registered in any course");
			return;
		}

		System.out.print("Enter the name of course : ");
		String name = reader.readLine();
		System.out.print("Enter number of course : ");
		String courseNumString = reader.readLine();
		int courseNum = -1;
		// int courseSectionNum = -1;
		try {
			courseNum = Integer.parseInt(courseNumString.strip());
		} catch (Exception e) {
			System.out.println("..............................................");
			System.out.println("\nInvalid input. Entered number is not integer");
			System.out.println("Please try again\n");
			System.out.println("..............................................");
			return;
		}

		System.out.println(theStudent.deleteCourse(this, name, courseNum));

	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

}
