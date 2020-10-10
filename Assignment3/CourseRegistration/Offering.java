package CourseRegistration;

import java.util.ArrayList;

public class Offering {

	private int sectionName;
	private int sectionCap;
	private Course theCourse;

	private ArrayList<Registration> studentList;

	public Offering(int sectionName, int sectionCap) {

		setSectionName(sectionName);
		setSectionCap(sectionCap);
		studentList = new ArrayList<Registration>();
	}

	public void addRegistration(Registration reg) {

		// we need to add logic to ensure the requirement for minimum number of students
		// in a section is met
		studentList.add(reg);
	}

	public int getSectionName() {
		return sectionName;
	}

	public void setSectionName(int sectionName) {
		this.sectionName = sectionName;
	}

	public int getSectionCap() {
		return sectionCap;
	}

	public void setSectionCap(int sectionCap) {
		this.sectionCap = sectionCap;
	}

	public Course getTheCourse() {
		return theCourse;
	}
 
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	
	@Override
	public String toString() {
		String st = "";
		st = st + "\n";
		st += "SectionName"  + sectionName + "SectionCap"  + sectionCap + "\n" + "\n";
		st += "Students in this section are :\n\n";
		
		for (Registration r : studentList) {
			//here we get each student
			st += "\n\n";
			st = st+  r.getTheStudent() + "Grade.." + r.getGrade();
		
		}
		return st;
	}

	public ArrayList<Registration> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Registration> studentList) {
		this.studentList = studentList;
	}

}
