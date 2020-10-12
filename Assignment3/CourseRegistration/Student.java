
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

	/**
	 * registerForCourse registers the student in the given course
	 * 
	 * @param cat        represents an object of type course catalogue
	 * @param courseName name of the course
	 * @param courseNum  number of the course
	 * @param sectionCap section cap of the offering
	 * @return the message for successful registration or not
	 */
	public String registerForCourse(CourseCat cat, String courseName, int courseNum, int sectionCap) {
		Course myCourse = cat.searchCat(courseName, courseNum);

		if (myCourse == null) {
			return "Course not found";
		}
		String s = "";

		if (!(this.registrationLimit()))
			return "Maximum Registration limit reached";

		for (Registration r : this.regList) {
			if (r.getTheOffering().getTheCourse().getCourseNum() == courseNum
					&& r.getTheOffering().getTheCourse().getCourseName().contentEquals(courseName))
				return "Course is already registered";

		}

		if (!(myCourse.getPreReq().isEmpty())) {
			ArrayList<Course> requisiteCourses = myCourse.getPreReq();
			String checkRequisite = this.checkPreRequisite(requisiteCourses);
			if (!(checkRequisite.contentEquals("True")))
				return checkRequisite;

		}

		ArrayList<Offering> theOffering = myCourse.getOfferingList();

		Registration reg = new Registration();

		for (Offering i : theOffering) {
			if (i.getSectionCap() == sectionCap) {
				String p = reg.register(this, i);
				return "\n" + "Student has successfully been registered in course " + courseName
						+ ", with section name " + i.getSectionName() + ", and section cap " + i.getSectionCap() + "\n"
						+ p;
			}
		}

		return "Course offering not found";

	}

	/**
	 * checkPreRequisite checks if the student is already registered in all the
	 * courses that are in the pre requisite courses list
	 * 
	 * @param requisiteCourses list of pre requisite courses
	 * @return True if condition is met
	 */
	public String checkPreRequisite(ArrayList<Course> requisiteCourses) {
		ArrayList<Course> listCourses = new ArrayList<Course>();
		for (Course c : requisiteCourses)
			System.out.println("There" + c.getCourseName());
		for (Registration g : this.getRegList()) {
			listCourses.add(g.getTheOffering().getTheCourse());
			System.out.println("here " + g.getTheOffering().getTheCourse().getCourseName());
		}
		if (listCourses.containsAll(requisiteCourses)) {
			System.out.println("I am here");
			return "True";
		}
		return "Pre-requisite condition not met";

	}

	/**
	 * deleteCourse deletes the registration of the student from a particular course
	 * 
	 * @param courseCat  represents an object of type catalogue
	 * @param courseName name of the course
	 * @param courseNum  number of the course
	 * @return message for successful deletion or not
	 */
	public String deleteCourse(CourseCat courseCat, String courseName, int courseNum) {

		for (Registration r : this.getRegList())
			if (r.getTheOffering().getTheCourse().getCourseNum() == courseNum
					&& r.getTheOffering().getTheCourse().getCourseName().contentEquals(courseName)) {
				r.deleteRegistration();
				return ("Course " + courseName + " " + courseNum + " has successfully been deleted");
			}
		return ("Course " + courseName + " course num" + courseNum + " not found");
	}

	public void deleteRegistration(Registration reg) {
		regList.remove(reg);
	}

	/**
	 * registrationLimit checks the registration limit of the student
	 * 
	 * @return True if registration limit is not reached, else False
	 */
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
