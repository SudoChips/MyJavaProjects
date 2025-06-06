import java.util.Scanner;

public class StudentGradesUsingArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the total number of students: ");
        int totalStudents = input.nextInt();

        int[] scores = new int[totalStudents];

        for (int i = 0; i < totalStudents; i++) {
            System.out.print("Enter student " + (i + 1) + "'s score: ");
            scores[i] = input.nextInt();
        }

        int bestScore = bestScore(scores);

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %d had %3d which is a %c\n",
                    i + 1, scores[i], assignLetterGrade(scores[i], bestScore));
        }

        input.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int bestScore(int[] scores) {
        int max = scores[0];
        int bestIndex = 1;

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                bestIndex = i + 1;
            }
        }

        System.out.println("The best score " + max + " was from student " + bestIndex);
        return max;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static char assignLetterGrade(int score, int bestScore) {
        if (score >= bestScore - 10)
            return 'A';
        else if (score >= bestScore - 20)
            return 'B';
        else if (score >= bestScore - 30)
            return 'C';
        else if (score >= bestScore - 40)
            return 'D';
        else
            return 'F';
    }
}