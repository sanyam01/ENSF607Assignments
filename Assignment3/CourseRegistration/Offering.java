
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

	public String addRegistration(Registration reg) {

		// we need to add logic to ensure the requirement for minimum number of students
		// in a section is met
		studentList.add(reg);

		if (studentList.size() < 8)
			return "Number of student regisrtered in this offering is still less than 8. So, its not confirmed yet.\n";
		return "Offering has equal to or more than 8 students";

	}

	public void deleteRegistration(Registration reg) {

		studentList.remove(reg);

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
		st += "SectionName: " + sectionName + " and SectionCap: " + sectionCap + "\n" + "\n";
		st += "Students in this section are : ";

		String check = "";
		for (Registration r : studentList) {
			if (r.getTheStudent() != null) {
				// here we get each student
				check = check + r.getTheStudent() + " ";
			}

		}
		if ("".equals(check)) {
			check = "NONE";
		}
		st = st + check + "\n";
		return st;
	}

	public ArrayList<Registration> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Registration> studentList) {
		this.studentList = studentList;
	}

}
