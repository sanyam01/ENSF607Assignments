import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CourseRegistrationApp {

	public static void main(String[] args) throws IOException {

		CourseCat cat = new CourseCat(); // load course from db
		Student st1 = new Student("Sara", 1);
		Student st2 = new Student("joe", 1);

		Course myCourse = cat.searchCat("Engg", 233);
		if (myCourse != null) {
			cat.createOffering(myCourse, 1, 200);
			cat.createOffering(myCourse, 2, 150);
		}

		System.out.println(myCourse.getOfferingList().get(0).getTheCourse());
		st1.registerForCourse(cat, "Engg", 233, 200);
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
//
				//case 2:
				//addCourse();
				//break;
//
//			case 3:
//				removeCourse();
//				break;

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
