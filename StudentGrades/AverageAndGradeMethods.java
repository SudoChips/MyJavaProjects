import java.util.Scanner;

public class AverageAndGradeMethods {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int NUMBEROFTESTS = 7;

        Grades gr = new Grades();
        int totalGradePts = 0;
        char letterGrade;

        for (int grades = 1; grades <= NUMBEROFTESTS; grades++) {
            totalGradePts += getGrades(input);
        }

        gr.totalGradePoints(totalGradePts);
        gr.numberOfGrades(NUMBEROFTESTS);

        System.out.printf("\n\nYour average is %5.2f your grade is %s\n\n",
                gr.calculateAverage(), gr.assignLetterGrade());

        input.close();
    }

    public static int getGrades(Scanner kbd) {
        int gradeIn;

        do {
            System.out.print("Enter a score between 0 and 100: ");
            gradeIn = kbd.nextInt();
            if (gradeIn < 0 || gradeIn > 100)
                System.out.print("\nGrade is not within range\n");
        } while (gradeIn < 0 || gradeIn > 100);

        return gradeIn;
    }
}