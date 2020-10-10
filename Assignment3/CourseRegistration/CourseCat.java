
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
		imaginaryDB.add(new Course("Engg", 233));
		imaginaryDB.add(new Course("Ensf", 607));
		imaginaryDB.add(new Course("physics", 259));

		return imaginaryDB;
	}

	public ArrayList<Course> searchCat(String courseName) {

		ArrayList<Course> foundCourses = new ArrayList<Course>();

		for (Course c : courseList) {
			if (c.getCourseName().equalsIgnoreCase(courseName))
				foundCourses.add(c);

		}

		// return the courses whose name matches with the course names
		return foundCourses;
	}

	public Course searchCat(String courseName, int courseNum) {

		for (Course c : courseList) {
			if (c.getCourseName().equals(courseName) && c.getCourseNum() == courseNum)
				return c;
		}

		return null;
	}

	public void createOffering(Course theCourse, int secNum, int secCap) {
		if (theCourse != null) {
			Offering theOffering = new Offering(secNum, secCap);
			theOffering.setTheCourse(theCourse); // set the courseObject to the course
			theCourse.addOffering(theOffering);

		}

	}

	public String viewAllCourses() {
		String s = "";
		for (Course i : courseList) {
			s = s + i.toString();
			s = s + "\n";
		}
		return s;
	}

	public void searchCatalogueCourses(BufferedReader reader) throws IOException {
		System.out.println("How do you want to search for courses.\n");
		System.out.println("1. Enter 1 if you want to search the course catalogue based on the course name");
		System.out.println(
				"2. Enter 2 if you want to search the course catalogue based on the course name and course num\n");
		System.out.print("Enter a number corresponding to the operation to be performed here : ");
		String input = reader.readLine();
		int operation = -1;
		try {
			operation = Integer.parseInt(input);
			if (!((operation == 1) || (operation == 2)))
				throw new ArithmeticException();
		} catch (ArithmeticException e) {
			System.out.println("..........................................");
			System.out.println("Invalid input. Please read below carfully");
			System.out.println("..........................................");
			return;
		}

		if (operation == 1) {
			System.out.print("Enter the name of the course : ");
			String nameFirst = reader.readLine();
			if (this.searchCat(nameFirst).get(0) == null) {
				System.out.println("No courses found for name  " + nameFirst);
				return;
			}
			System.out.println("Courses foudn are : ");
			for (Course i : this.searchCat(nameFirst))
				System.out.println(i.toString());
		}

		if (operation == 2) {
			System.out.print("Enter the name of course : ");
			String name = reader.readLine();
			System.out.print("Enter number of course : ");
			String num = reader.readLine();
			int numCourse = -1;
			try {
				numCourse = Integer.parseInt(num);
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



	public void viewStudentCourses(BufferedReader reader) throws IOException {

		System.out.print("Enter the name of student : ");
		String name = reader.readLine();
		System.out.print("Enter id of student : ");
		String num = reader.readLine();
		int numID = -1;
		try {
			numID = Integer.parseInt(num);
		} catch (Exception e) {
			System.out.println("..............................................");
			System.out.println("\nInvalid input. Entered number is not integer");
			System.out.println("Please try again\n");
			System.out.println("..............................................");
			return;
		}

		if ("".equals(this.getStudentCourses(name, numID)))
			System.err.println("Student with name" + name + " and ID " + numID + " has no courses registered");
		else
			System.out.println(this.getStudentCourses(name, numID));

	}


	public String getStudentCourses(String name, int num) {

		String s = "";
		
		System.out.println("I am here");
		System.out.println(" name is " + name);
		for (Course cor : this.courseList)
			for (Offering or : cor.getOfferingList())
				for (Registration reg : or.getStudentList())
					if (reg.getTheStudent().getStudentName().equals(name) && reg.getTheStudent().getStudentId() == num)
						s = s + cor.getCourseName() + " " + cor.getCourseNum() + "\n";

		return s;

	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

}
