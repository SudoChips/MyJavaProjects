import java.util.Scanner;
import java.io.*;

public class SearchingStudentArrays {

public static void main(String[] args) throws IOException {

    final String IN_FILENAME = "grade.txt";
    final int STUDENT_COUNT = 5;

    File fn = new File(IN_FILENAME);
    Scanner inputFile = new Scanner(fn);

    Scanner keyboard = new Scanner(System.in);

    String[] studentName = new String[STUDENT_COUNT];
    int[] studentId = new int[STUDENT_COUNT];
    double[] scores = new double[STUDENT_COUNT];
    char[] letterGrade = new char[STUDENT_COUNT];

    fillArray(inputFile, studentName, studentId, scores, letterGrade);
    sort(studentName, studentId, scores, letterGrade);

    System.out.printf("\n%-15s  %5s  %6s  %s\n", "Name", "ID", "Avg", "Grade");
    displayArrays(studentName, studentId, scores, letterGrade);

    System.out.print("\n\n\n\n\n");

    infoByStudentName(keyboard, studentName, studentId, scores, letterGrade);
    infoByStudentId(keyboard, studentName, studentId, scores, letterGrade);

    inputFile.close();
    keyboard.close();
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void fillArray(Scanner inFile, String[] studentNames, int[] studentId, double[] scores, char[] letterGrade) {
    int indx = 0;
    while (inFile.hasNext()) {
        studentNames[indx] = inFile.nextLine().trim();
        while (studentNames[indx].equals("") && inFile.hasNextLine())
            studentNames[indx] = inFile.nextLine().trim();

        studentId[indx] = inFile.nextInt();
        scores[indx] = (inFile.nextDouble() + inFile.nextDouble() + inFile.nextDouble()) / 3.0;
        letterGrade[indx] = assignLetterGrade(scores[indx]);
        if (inFile.hasNextLine()) inFile.nextLine(); // consume leftover newline
        indx++;
    }
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void displayArrays(String[] studentNames, int[] studentId, double[] scores, char[] letterGrade) {
    String fmtStr = "%-15s  %5d  %6.2f  %s\n";
    for (int indx = 0; indx < studentNames.length; indx++) {
        System.out.printf(fmtStr, studentNames[indx], studentId[indx], scores[indx], letterGrade[indx]);
    }
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static char assignLetterGrade(double scores) {
    char retLetterGrade = ' ';
    if (scores >= 90.0)
        retLetterGrade = 'A';
    else if (scores >= 80.0)
        retLetterGrade = 'B';
    else if (scores >= 70.0)
        retLetterGrade = 'C';
    else if (scores >= 60.0)
        retLetterGrade = 'D';
    else
        retLetterGrade = 'F';
    return retLetterGrade;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static int findStudent(int sValue, int[] sArr) {
    int retIndx = -1;
    for (int indx = 0; indx < sArr.length; indx++)
        if (sArr[indx] == sValue) {
            retIndx = indx;
            break;
        }
    return retIndx;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void displayStudentInformation(int indx, String[] studentNames, int[] studentId, double[] scores, char[] letterGrade) {
    String fmtStr = "%-15s  %5d  %6.2f  %s\n";
    System.out.printf(fmtStr, studentNames[indx], studentId[indx], scores[indx], letterGrade[indx]);
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static int findStudent(String sValue, String[] sArr) {
    int retIndx = -1;
    for (int indx = 0; indx < sArr.length; indx++)
        if (sArr[indx].equalsIgnoreCase(sValue)) {
            retIndx = indx;
            break;
        }
    return retIndx;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void infoByStudentId(Scanner keyboard, String[] studentNames, int[] studentId, double[] scores, char[] letterGrade) {
    int searchId;
    do {
        System.out.print("Enter a studentId to search for: ");
        searchId = keyboard.nextInt();
    } while (searchId <= 0);
    keyboard.nextLine(); // absorb newline

    int indxReturned1 = findStudent(searchId, studentId);
    if (indxReturned1 != -1)
        displayStudentInformation(indxReturned1, studentNames, studentId, scores, letterGrade);
    else
        System.out.println("Student is not on file");
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void infoByStudentName(Scanner keyboard, String[] studentNames, int[] studentId, double[] scores, char[] letterGrade) {
    String searchName;
    do {
        System.out.print("Enter a student name to search for: ");
        searchName = keyboard.nextLine();
    } while (searchName.equals(""));

    int indxReturned = findStudent(searchName, studentNames);
    if (indxReturned != -1)
        displayStudentInformation(indxReturned, studentNames, studentId, scores, letterGrade);
    else
        System.out.println("Student is not on file");
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void sort(String[] studentNames, int[] studentId, double[] scores, char[] letterGrade) {
    String tempStr;
    int tempInt;
    double tempDouble;
    char tempChar;

    for (int indx = 0; indx < studentNames.length - 1; indx++)
        for (int indx1 = indx + 1; indx1 < studentNames.length; indx1++)
            if (studentNames[indx].compareToIgnoreCase(studentNames[indx1]) > 0) {
                tempStr = studentNames[indx];
                studentNames[indx] = studentNames[indx1];
                studentNames[indx1] = tempStr;

                tempInt = studentId[indx];
                studentId[indx] = studentId[indx1];
                studentId[indx1] = tempInt;

                tempDouble = scores[indx];
                scores[indx] = scores[indx1];
                scores[indx1] = tempDouble;

                tempChar = letterGrade[indx];
                letterGrade[indx] = letterGrade[indx1];
                letterGrade[indx1] = tempChar;
            }
}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}