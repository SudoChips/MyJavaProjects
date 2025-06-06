import java.util.Scanner; // Scanner is in the java.util package

public class StudentGrades {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int grade1, grade2, grade3;
        int average;

        System.out.print("Enter the first grade: ");
        grade1 = keyboard.nextInt();

        System.out.print("Enter the second grade: ");
        grade2 = keyboard.nextInt();

        System.out.print("Enter the third grade: ");
        grade3 = keyboard.nextInt();

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

        keyboard.close();
    }
}