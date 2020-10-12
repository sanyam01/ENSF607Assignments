
public class Registration {

	private Student theStudent;
	private Offering theOffering;
	private char grade;

	public String register(Student theStudent, Offering theOffering) {
		setTheStudent(theStudent);
		setTheOffering(theOffering);
		String s = addRegistration();
		return s;
	}

	/**
	 * addRegistration() adds the registration of the student in the Student class
	 * and in the Offering class
	 * 
	 * @return the message for successful registration or not
	 */
	private String addRegistration() {

		theStudent.addRegistration(this);
		String s = theOffering.addRegistration(this);
		return s;
	}

	/**
	 * addRegistration() deletes the registration of the student from the Student
	 * class and from the Offering class
	 */
	public void deleteRegistration() {
		theOffering.deleteRegistration(this);
		theStudent.deleteRegistration(this);

	}

	public Student getTheStudent() {
		return theStudent;
	}

	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}

	public Offering getTheOffering() {
		return theOffering;
	}

	public void setTheOffering(Offering theOffering) {
		this.theOffering = theOffering;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

}
