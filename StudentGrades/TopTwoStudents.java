import java.util.Scanner;

public class TopTwoStudents {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String topSName = "";
        double topSScore = -1;
        String secondSName = "";
        double secondSScore = -1;

        System.out.print("Enter number of students: ");
        int studentCount = input.nextInt();

        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter a student name: ");
            String s = input.next();

            System.out.print("Enter a student score: ");
            double score = input.nextDouble();

            if (score > topSScore) {
                secondSName = topSName;
                secondSScore = topSScore;

                topSName = s;
                topSScore = score;
            } else if (score > secondSScore) {
                secondSName = s;
                secondSScore = score;
            }
        }

        System.out.println("\nTop two students: ");
        System.out.println(topSName + "'s score is " + topSScore);
        System.out.println(secondSName + "'s score is " + secondSScore);

        input.close();
    }
}