import java.util.Scanner;

public class EvenOddNumsSumAndCount {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int sumEven = 0;
        int sumOdd = 0;
        int countEven = 0;
        int countOdd = 0;

        System.out.print("Enter a number: ");
        int number = stdin.nextInt();

        while (number > 0) {
            if (number % 2 == 0) {
                sumEven += number;
                countEven++;
            } else {
                sumOdd += number;
                countOdd++;
            }

            System.out.print("Enter a number: ");
            number = stdin.nextInt();
        }

        System.out.println("\nThe sum of all the even integers is: " + sumEven);
        System.out.println("The count of even integers is: " + countEven);
        System.out.println("The sum of all the odd integers is: " + sumOdd);
        System.out.println("The count of odd integers is: " + countOdd);

        stdin.close();
    }
}