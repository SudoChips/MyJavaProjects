import java.util.Scanner;
import java.io.*;

public class TestStudent1 {

	public static void main(String[] args) throws IOException {

		final String INPUT_FILE = "teststudentdata.txt";

		File fn = new File(INPUT_FILE);
		Scanner dataIn = new Scanner(fn);
		Scanner keyboard = new Scanner(System.in);

		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		Student student5 = new Student();

		getStudentData(dataIn, student1);
		getStudentData(dataIn, student2);
		getStudentData(dataIn, student3);
		getStudentData(dataIn, student4);
		getStudentData(dataIn, student5);

		displayStudent(student1);
		displayStudent(student2);
		displayStudent(student3);
		displayStudent(student4);
		displayStudent(student5);

		System.out.println("\nStudents Report");
		System.out.printf("\n%5s   %-20s   %7s\n", "Id", "Student", "Reg Code");

		reportLineStudent(student1);
		reportLineStudent(student2);
		reportLineStudent(student3);
		reportLineStudent(student4);
		reportLineStudent(student5);

	} // end main

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	public static void getStudentData(Scanner dataFile, Student studentData) {

		studentData.firstName(dataFile.nextLine());
		studentData.lastName(dataFile.nextLine());
		studentData.studentId(dataFile.nextInt());
		if (dataFile.hasNext()) dataFile.nextLine();
		studentData.major(dataFile.nextLine());
		studentData.grade1(dataFile.nextInt());
		studentData.grade2(dataFile.nextInt());
		studentData.grade3(dataFile.nextInt());
		if (dataFile.hasNext()) dataFile.nextLine();

		/*
		// Uncomment this block for keyboard input instead of file input

		System.out.print("Enter Student first name: ");
		studentData.firstName(keyboard.nextLine());

		System.out.print("Enter Student last name: ");
		studentData.lastName(keyboard.nextLine());

		System.out.print("Enter Student Id: ");
		studentData.studentId(keyboard.nextInt());

		keyboard.nextLine(); // absorbs extra carriage return

		System.out.print("Enter Student's major: ");
		studentData.major(keyboard.nextLine());

		System.out.println("");
		*/
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

		if (studentIn.major().equals("Accounting") || studentIn.major().equals("Business")) // not using ignoreCase
			regCode = "BUS";
		else if (studentIn.major().equals("Computer Science"))
			regCode = "CSC";
		else if (studentIn.major().equals("Math"))
			regCode = "MAT";

		return regCode;
	}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}