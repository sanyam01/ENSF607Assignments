import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CourseRegistrationApp {

	public static void main(String[] args) throws IOException {

		CourseCat cat = new CourseCat(); // load course from db

		ArrayList<Student> stu = new ArrayList<Student>();
		Student st1 = new Student("Sara", 1);
		stu.add(st1);
		Student st2 = new Student("joe", 1);
		Student st3 = new Student("Sanyam", 2);
		Student st4 = new Student("Mike", 3);
		stu.add(st2);
		stu.add(st3);
		stu.add(st4);
		
		Course myCourse = cat.searchCat("A", 100);
		if (myCourse != null) {
			cat.createOffering(myCourse, 1, 110);
			cat.createOffering(myCourse, 2, 120);
		}
		
		Course myCourse1 = cat.searchCat("B",200);
		if (myCourse1 != null) {
			cat.createOffering(myCourse1, 3, 210);
			cat.createOffering(myCourse1, 4, 220);
		}
		
		Course myCourse2 = cat.searchCat("C",300);
		if (myCourse2 != null) {
			cat.createOffering(myCourse2, 5, 310);
			cat.createOffering(myCourse2, 6, 320);
		}
		
		Course myCourse3 = cat.searchCat("D",400);
		if (myCourse3 != null) {
			cat.createOffering(myCourse3, 7, 410);
			cat.createOffering(myCourse3, 8, 420);
		}
		
		Course myCourse4 = cat.searchCat("E",500);
		if (myCourse4 != null) {
			cat.createOffering(myCourse4, 9, 510);
			cat.createOffering(myCourse4, 10, 520);
		}
		
		Course myCourse5 = cat.searchCat("F",600);
		if (myCourse5 != null) {
			cat.createOffering(myCourse5, 4, 610);
			cat.createOffering(myCourse5, 5, 620);
		}
		
		Course myCourse6 = cat.searchCat("G",700);
		if (myCourse6 != null) {
			cat.createOffering(myCourse6, 4, 710);
			cat.createOffering(myCourse6, 5, 720);
		}
		

		
		st1.registerForCourse(cat, "A", 100, 120);
		
		st2.registerForCourse(cat, "B", 200, 220);
		st2.registerForCourse(cat, "C", 300, 320);
		
		st3.registerForCourse(cat, "D", 400, 420);
		
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
				cat.addCourse(stu, reader);
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
