import java.util.Scanner; // Scanner is in the java.util package

public class StudentGrades2 {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int grade;

        System.out.print("Enter the student's grade: ");
        grade = keyboard.nextInt();

        if (grade >= 93)
            System.out.println("Your grade is an A");
        else if (grade >= 90 && grade <= 92)
            System.out.println("Your grade is an A-");
        else if (grade >= 88 && grade <= 89)
            System.out.println("Your grade is a B+");
        else if (grade >= 84 && grade <= 87)
            System.out.println("Your grade is a B");
        else if (grade >= 80 && grade <= 83)
            System.out.println("Your grade is a B-");
        else if (grade >= 78 && grade <= 79)
            System.out.println("Your grade is a C+");
        else if (grade >= 70 && grade <= 77)
            System.out.println("Your grade is a C");
        else if (grade >= 60 && grade <= 69)
            System.out.println("Your grade is a D");
        else
            System.out.println("Your grade is an F");

        keyboard.close();
    }
}