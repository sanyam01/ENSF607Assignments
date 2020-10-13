CourseRegistration [Important points to run the code]

*Basic points about code*

1. Search methods are case sensitives, i.e. name of the courses to be searched must be exact.(e.g. Engg is not same as engg). Similarily all the names are case sensitive as well.
Take precaution while entering integer values(avoid putting space before and after).


2.List of students which are added in main are:-

Each student has a student name and student ID as given below(name and id are separated
by commas):

Sara, 1
Joe, 1
Sanyam, 2
Mike, 3
Pro, 4
Yves, 5
Stan, 6
Neha, 7
Sonia, 8
Prince, 9


If you wish to add more students, you have to do it in main and add them to the student list in main, as it was mentioned in the requirements that students object can be build in the main.

3. Course details added are:

First line shows Course name and Course num
Second and third line each shows course offerings of that course, where each second and third line includes section name and section cap e.g. 'A' and '100' is course name and number respectively, and (1,110) and (2, 120) are two course offerings. '1' and '2' are section names of two sections and '110' and '120' are section caps. 
...............................................
A			100		   
					   1			 110
					   2			 120				   
...............................................
B			200		   
					   3			 210
					   4			 220
					   
..............................................
C			300		   
					   5			 310
					   6			 320
					   
.............................................
D			400		   
					   7			 410
					   8			 420
					   
............................................
E			500		   
					   9			 510
					   10			 520
					   
...........................................
F			600		   
					   11			 610
					   12			 620
					   
...............................................
G			700		   
					   13			 710
					   14			 720
					   
...............................................

4. A condition has been added for checking the preRequisite functionality in class Student. In main, a pre-requisite subject for course 'B' has been added i.e. one must be registered in course 'A' for taking the course 'B'. This can be tested by trying to register a student in course 'B' without adding course 'A' to its registration. For adding the pre-requisite courses, you have to use function 'addPreRequisite(Course preRequisite)' in main itself( it has been already done once for course 'B').

5. If you try to register a student in more than six courses, then you will get a message that student can't be register in more than six courses.

6. When you register for a course, you will get a message displaying the validity of the offering i.e. if an offering has minimum students or not.

6. Few registrations are already done in main for the 'four' students. Those can be commented.

7. One student can only be registered in one offering of each course.

8. When a course is returned, I have also returned its offerings and students. However it can be changed depending upon the specifications.

9. If you enter any input wrong then you will have to perform that operation again. However, you will be continuously displayed with the menu until you press 6.

**How code runs**

Menu is displayed to you and you can perform various functions displayed in the menu by pressing from 1 to 6.

1. Pressing 1 asks to search the catalogue.

a) you can search the catalogue based on only course name or based on the course name and the num.
---- For course name, just enter the name of the course. e.g. 'A' or 'B'.
---- For course name and num, you have to first input name and then num. e.g. 'A' and then '100'.

2. Pressing 2 will start the process of registering a student to the course.

a) First you will be asked to enter student name and id in two steps. i.e. you can input student name and id, exactly as they are. e.g. input 'Sanyam' and then input '2'.
b) Following this you will be asked to enter course name,  num, and section cap. Here you can enter e.g. 'A', then '100', and then section cap i.e. '120' or '110'.

Message will be displayed for the successful registration or not, along with the validity of the course offering.

3. For deleting the course, process is mostly same for adding the course. Here, you wont be asked for section cap, as one student can only be registered in one offering of a course.

4. Pressing 4 will yield on console all the courses, their offerings, and the number of students registered in those offerings.

5. Pressing 5 will yield the courses taken by each student.

a) you have to input the student name and id. e.g.  input 'Sanyam' and then input '2'.

6. Pressing 6 will exit the program.
