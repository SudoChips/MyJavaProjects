import java.util.Scanner; // Scanner is in the java.util package
import java.io.*;

public class StudentGradesFiles {
    public static void main(String[] args) throws IOException {

        final String FILE_NAME = "3grades.txt";

        File gr = new File(FILE_NAME);
        Scanner dataIn = new Scanner(gr);

        int grade1, grade2, grade3;
        int average;

        grade1 = dataIn.nextInt();
        grade2 = dataIn.nextInt();
        grade3 = dataIn.nextInt();

        average = (grade1 + grade2 + grade3) / 3;

        if (average >= 90)
            System.out.println("You earned an A");
        else if (average >= 80)
            System.out.println("You earned a B");
        else if (average >= 70)
            System.out.println("You earned a C");
        else if (average >= 60)
            System.out.println("You earned a D");
        else
            System.out.println("You earned an F");

        dataIn.close();
    }
}