package CourseRegistration;

import java.util.ArrayList;

public class CourseCat {
	
	private ArrayList <Course> courseList;
	
	public CourseCat() {
		courseList = LoadfromDb();
	}

	
	private static ArrayList<Course> LoadfromDb() {
		// TODO Auto-generated method stub
		// In real life course would be loaded from database or a hex file on disk or atleast
		// sort of file from disc. So imagine this is the loaded from the database.
		ArrayList<Course> imaginaryDB = new ArrayList<Course>();
		imaginaryDB.add(new Course("Engg" , 233));
		imaginaryDB.add(new Course("Ensf" , 607));
		imaginaryDB.add(new Course("physics" , 259));
		
		
		return imaginaryDB;
	}
	
	public ArrayList<Course> searchCat(String courseName) {
		ArrayList<Course> foundCourses = new ArrayList<Course>();
		
		// return the courses whose name matches with the course names
		return foundCourses;
	}
	
	public Course searchCat(String courseName, int courseNum) {
		
		for (Course c : courseList) {
			if (c.getCourseName().equals(courseName) && c.getCourseNum() == courseNum)
				return c;
		}
			System.err.println("Course " + courseName + "name" + courseNum + "does not exist");
		return null;
	}
	
	public void createOffering(Course theCourse, int secNum, int secCap) {
		if (theCourse != null) {
			Offering theOffering = new Offering(secNum, secCap);
			theOffering.setTheCourse(theCourse); // set the courseObject to the course
			theCourse.addOffering(theOffering);
			
		}
		
	}
	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
	

}
