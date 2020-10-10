

public class CourseRegistrationApp {
	
	public static void main(String[] args) {
		CourseCat cat =new CourseCat(); //load course from db
		Student st1 = new Student("Sara",1 );
		Student st2 = new Student("joe",1 );
		
		Course myCourse = cat.searchCat("Engg", 233);
		if (myCourse != null) {
			cat.createOffering(myCourse, 1, 200);
			cat.createOffering(myCourse, 2, 150);
		}
		
		System.out.println(myCourse.getOfferingList().get(0).getTheCourse());
		st1.registerForCourse(cat, "Engg", 233, 1);
		//System.out.println(myCourse.getOfferingList().get(0).getStudentList().get(0).getTheStudent().getStudentName());
		System.out.println(myCourse.getOfferingList().get(0).getTheCourse());
		
		
	}

}
