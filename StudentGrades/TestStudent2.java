import java.util.Scanner;
import java.io.*;

public class TestStudent2 {

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "teststudentdata.txt";
        final int STUDENT_COUNT = 5;

        File fn = new File(INPUT_FILE);
        Scanner dataIn = new Scanner(fn);

        Student[] student = new Student[STUDENT_COUNT];

        for (int indx = 0; indx < STUDENT_COUNT; indx++)
            student[indx] = new Student();

        for (int indx = 0; indx < STUDENT_COUNT; indx++)
            getStudentData(dataIn, student[indx]);

        for (int indx = 0; indx < STUDENT_COUNT; indx++)
            displayStudent(student[indx]);

        displayReport(student);
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayReport(Student[] student) {
        System.out.println("\nStudents Report");
        System.out.printf("\n%5s    %-20s   %7s\n", "Id", "Student", "Reg Code");

        for (int indx = 0; indx < student.length; indx++)
            reportLineStudent(student[indx]);
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
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
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayStudent(Student studentIn) {
        System.out.printf("%-15s %-15s %5d %-15s\n",
                studentIn.firstName(), studentIn.lastName(),
                studentIn.studentId(), studentIn.major());
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void reportLineStudent(Student studentIn) {
        System.out.printf("%5d    %-20s %7s\n",
                studentIn.studentId(), studentIn.lastNameFirst(), regCode(studentIn));
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
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
}