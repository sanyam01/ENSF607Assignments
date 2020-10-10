import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CourseRegistrationApp {

	public static void main(String[] args) throws IOException {

		CourseCat cat = new CourseCat(); // load course from db
		Student st1 = new Student("Sara", 1);
		Student st2 = new Student("joe", 1);
		Student st3 = new Student("Sanyam", 2);
		Student st4 = new Student("Mike", 3);
		
		Course myCourse = cat.searchCat("Engg", 233);
		if (myCourse != null) {
			cat.createOffering(myCourse, 1, 200);
			cat.createOffering(myCourse, 2, 150);
		}
		
		Course myCourse1 = cat.searchCat("physics",259);
		if (myCourse1 != null) {
			cat.createOffering(myCourse1, 2, 300);
			cat.createOffering(myCourse1, 3, 450);
		}
		
		Course myCourse2 = cat.searchCat("Ensf",607);
		if (myCourse2 != null) {
			cat.createOffering(myCourse2, 4, 500);
			cat.createOffering(myCourse2, 5, 550);
		}
		
		Course myCourse3 = cat.searchCat("Chemistry",340);
		if (myCourse3 != null) {
			cat.createOffering(myCourse3, 4, 500);
			cat.createOffering(myCourse3, 5, 550);
		}

		
		st1.registerForCourse(cat, "Engg", 233, 200);
		
		st2.registerForCourse(cat, "Chemistry", 340, 500);
		st2.registerForCourse(cat, "Ensf", 607, 500);
		
		st3.registerForCourse(cat, "physics", 259, 300);
		
		//System.out.println(myCourse.getOfferingList().get(0).getTheCourse());
		
		// System.out.println(myCourse.getOfferingList().get(0).getStudentList().get(0).getTheStudent().getStudentName());
		System.out.println(myCourse.getOfferingList().get(0).getTheCourse());

		int num = 1;
		while (num >= 1 && num <= 6) {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("For performing the operations, enter respective serial numbers\n");
			System.out.println(
					"1. Search catalogue courses\n2. Add course to student courses \n3. Remove courses from student courses");
			System.out.println("4. View all courses in catalogue \n5. View all courses taken by student\n6. Quit");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.print("Enter a no here : ");
			String read;

			try {
				read = reader.readLine();
				num = Integer.parseInt(read);
				if (!(num >= 1 && num <= 6))
					throw new NumberFormatException();
			} catch (Exception e) {
				System.out.println("Enter an integer between 1 and 6");
				num = 1;
				continue;
			}

			switch (num) {
			
			case 1:
				cat.searchCatalogueCourses(reader);
				break;

			case 2:
				cat.addCourse(reader);
				break;

			case 3:
				cat.removeCourse(reader);
				break;

			case 4:
				System.out.println(cat.viewAllCourses());
				break;

			case 5:
				cat.viewStudentCourses(reader);
				break;

			case 6:
				System.out.println("You have exited the menu");
				System.exit(1);
				break;

			}

		}

	}

}
