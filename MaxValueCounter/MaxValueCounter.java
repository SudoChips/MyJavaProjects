import java.util.Scanner;

public class MaxValueCounter {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int count = 0;
    int max = 0;
    int number;

    System.out.print("Enter an integer (0: for end of input): ");
    number = input.nextInt();

    while (number > 0) {
      if (number > max) {
        max = number;
        count = 1;
      } else if (number == max) {
        count++;
      }

      System.out.print("Enter an integer (0: for end of input): ");
      number = input.nextInt();
    }

    if (max == 0)
      System.out.println("No numbers are entered except 0");
    else {
      System.out.print("The largest number is " + max);
      System.out.print("\nThe occurrence count of the largest number is " + count);
      System.out.println();
    }

    input.close(); // close scanner
  }
}