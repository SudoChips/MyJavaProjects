import java.util.Scanner;
import java.io.*;

public class StudentGradesUsingArray1 {

    public static void main(String[] args) throws IOException {

        File fn = new File("studentgrade.txt");
        Scanner inputFile = new Scanner(fn);

        String[] students = new String[4];
        double[] average = new double[4];

        fillArray(inputFile, students, average);
        displayStudents(students, average);

        inputFile.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner dataIn, String[] names, double[] gradeAvg) {
        int indx = 0;
        double grade;

        while (dataIn.hasNext() && indx < names.length) {
            names[indx] = dataIn.nextLine();
            if (names[indx].equals("")) names[indx] = dataIn.nextLine();

            grade = 0;
            for (int i = 1; i <= 3; i++) {
                grade += dataIn.nextInt();
            }
            gradeAvg[indx] = grade / 3.0;

            if (dataIn.hasNextLine()) dataIn.nextLine(); // Consume leftover newline

            indx++;
        }
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayStudents(String[] studentsIn, double[] avg) {
        for (int indx = 0; indx < studentsIn.length; indx++) {
            System.out.printf(
                "%-15s  %5.2f  %1s  %-15s\n",
                studentsIn[indx],
                avg[indx],
                assignLetterGrade(avg[indx]),
                gradeComment(avg[indx])
            );
        }
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static char assignLetterGrade(double grade) {
        if (grade >= 90)
            return 'A';
        else if (grade >= 80)
            return 'B';
        else if (grade >= 70)
            return 'C';
        else if (grade >= 60)
            return 'D';
        else
            return 'F';
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static String gradeComment(double grade) {
        if (grade >= 90)
            return "Excellent work";
        else if (grade >= 80)
            return "Good work";
        else if (grade >= 70)
            return "Average work";
        else if (grade >= 60)
            return "Poor work";
        else
            return "Failing grade";
    }
}