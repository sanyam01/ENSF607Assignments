
import java.util.ArrayList;

public class Course {

	private String courseName;
	private int courseNum;
	private ArrayList<Course> preReq;
	private ArrayList<Offering> offeringList;
	

	public Course(String courseName, int courseNum) {

		setCourseName(courseName);
		setCourseNum(courseNum);

		// This is not composition because not constructing an Offering object. We are
		// constructing the array.
		preReq = new ArrayList<Course>();
		offeringList = new ArrayList<Offering>();

	}

	// adding a single offering to a course
	// it is association [between offering and course]
	public void addOffering(Offering theOffering) {
		offeringList.add(theOffering);

	}

	public String getCourseName() {
		return courseName;
	}
	
	@Override
	public String toString() {
		String st = "";
		st+="\n";
		st += "Course name " + courseName + " with course number " + courseNum + "has following offering list :";
		st += "\n";
		for (Offering offering : offeringList) {
			st += offering; // means u need to have a toString in offering
		}
		return st;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}

	public ArrayList<Course> getPreReq() {
		return preReq;
	}

	public void setPreReq(ArrayList<Course> preReq) {
		this.preReq = preReq;
	}

	public ArrayList<Offering> getOfferingList() {
		return offeringList;
	}

	public void setOfferingList(ArrayList<Offering> offeringList) {
		this.offeringList = offeringList;
	}

}
