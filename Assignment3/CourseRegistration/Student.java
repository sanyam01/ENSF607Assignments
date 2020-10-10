

import java.util.ArrayList;

public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList<Registration> regList; // list of course sections for students
	
	public Student(String studentName, int studentId) {
		setStudentName(studentName);
		setStudentId(studentId);
		regList = new ArrayList<Registration>();
	}
	
	public void registerForCourse(CourseCat cat, String courseName, int courseNum, int section) {
	Course myCourse = cat.searchCat(courseName, courseNum);	
	// student need to make sure section exist and then register
	// student registers by creating a registration object and following the addRegistration
	Offering theOffering = myCourse.getOfferingList().get(section -1); // must chec this
	Registration reg = new Registration();
	reg.register(this, theOffering);
	}
	
	public ArrayList<Registration> getRegList() {
		return regList;
	}

	public void setRegList(ArrayList<Registration> regList) {
		this.regList = regList;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		regList.add(registration);
		
	}
	
	@Override
	public String toString() {
		return studentName;
	}
	
	
	
	

}
