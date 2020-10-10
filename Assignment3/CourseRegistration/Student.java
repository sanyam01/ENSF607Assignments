
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

	public String registerForCourse(CourseCat cat, String courseName, int courseNum, int sectionCap) {
		Course myCourse = cat.searchCat(courseName, courseNum);
		
		if (myCourse == null) {
			return "Course not found";
		}
		String s = "";
		// student need to make sure section exist and then register
		// student registers by creating a registration object and following the
		// addRegistration
		// Offering theOffering = myCourse.getOfferingList().get(section-1); // must
		// check this

		if (!(this.registrationLimit()))
			return "Maximum Registration limit reached";

		ArrayList<Offering> theOffering = myCourse.getOfferingList();

		Registration reg = new Registration();

		for (Offering i : theOffering) {
			if (i.getSectionCap() == sectionCap) {
				reg.register(this, i);
				return "Student has successfully been registered in course " + courseName + ", with section name "
						+ i.getSectionName() + ", and section cap " + i.getSectionCap();
			}
		}

		return "Course offering not found";

	}
	
public String deleteCourse(CourseCat courseCat, String courseName, int courseNum) {
		
	for(Registration r:this.getRegList())
		if(r.getTheOffering().getTheCourse().getCourseNum() == courseNum && r.getTheOffering().getTheCourse().getCourseName().contentEquals(courseName)) {
			r.deleteRegistration();
			return ("Course " + courseName + "course number " + courseNum + "successfully delted");
		}
			return ("Course " + courseName + "course num" + courseNum +   "not found");
	}

public void deleteRegistration(Registration reg) {
	regList.remove(reg);
}



	public boolean registrationLimit() {
		boolean check = true;
		if (regList.size() < 6)
			return check;
		else
			return false;
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
