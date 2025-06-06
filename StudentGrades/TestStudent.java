import java.util.Scanner;

public class TestStudent {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();

		/*

		String fNameIn = "Harry";
		String lNameIn = "Trueman";
		int sIdIn = 34567;

		Student student1 = new Student();
		Student student2 = new Student("Joseph", "Biden");
		Student student3 = new Student("George", "Washington", 11111);
		Student student4 = new Student(fNameIn, lNameIn, sIdIn);

		System.out.println("Student 1");
		System.out.println("First Name: " + student1.firstName());
		System.out.println("Last Name: " + student1.lastName());
		System.out.println("Student ID: " + student1.studentId());
		System.out.println("Major: " + student1.major());

		System.out.println("\nStudent 2");
		System.out.println("First Name: " + student2.firstName());
		System.out.println("Last Name: " + student2.lastName());
		System.out.println("Student ID: " + student2.studentId());
		System.out.println("Major: " + student2.major());

		System.out.println("\nStudent 3");
		System.out.println("First Name: " + student3.firstName());
		System.out.println("Last Name: " + student3.lastName());
		System.out.println("Student ID: " + student3.studentId());
		System.out.println("Major: " + student3.major());

		System.out.println("\nStudent 4");
		System.out.println("First Name: " + student4.firstName());
		System.out.println("Last Name: " + student4.lastName());
		System.out.println("Student ID: " + student4.studentId());
		System.out.println("Major: " + student4.major());

		System.out.println("\nAll Students");

		student1.firstName("Karmala");
		student1.lastName("Harris");
		student1.studentId(33333);
		student1.major("Accounting");

		student2.studentId(44444);
		student2.major("Business");

		student3.major("Computer Science");

		student4.major("Math");

		*/

		getStudentData(keyboard, student1);
		getStudentData(keyboard, student2);
		getStudentData(keyboard, student3);
		getStudentData(keyboard, student4);

		displayStudent(student1);
		displayStudent(student2);
		displayStudent(student3);
		displayStudent(student4);

		System.out.println("\nStudents Report");
		System.out.printf("\n%5s   %-20s   %7s\n", "Id", "Student", "Reg Code");

		reportLineStudent(student1);
		reportLineStudent(student2);
		reportLineStudent(student3);
		reportLineStudent(student4);

	} // end main

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	public static void getStudentData(Scanner keyboard, Student studentData) {

		System.out.print("Enter Student first name: ");
		studentData.firstName(keyboard.next());

		System.out.print("Enter Student last name: ");
		studentData.lastName(keyboard.next());

		System.out.print("Enter Student Id: ");
		studentData.studentId(keyboard.nextInt());

		keyboard.nextLine(); // absorbs extra carriage return after numeric

		System.out.print("Enter Student's major: ");
		studentData.major(keyboard.next());

		System.out.println("");
	}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	public static void displayStudent(Student studentIn) {
		System.out.printf("%-15s %-15s %5d %-15s\n",
			studentIn.firstName(), studentIn.lastName(),
			studentIn.studentId(), studentIn.major());
	}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	public static void reportLineStudent(Student studentIn) {
		System.out.printf("%5d    %-20s %7s\n",
			studentIn.studentId(), studentIn.lastNameFirst(), regCode(studentIn));
	}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	public static String regCode(Student studentIn) {
		String regCode = "";

		if (studentIn.major().equals("Accounting") || studentIn.major().equals("Business"))
			regCode = "BUS";
		else if (studentIn.major().equals("Computer Science"))
			regCode = "CSC";
		else if (studentIn.major().equals("Math"))
			regCode = "MAT";

		return regCode;
	}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}