import java.util.Scanner;

public class PosNegCalculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int pos = 0;
    int neg = 0;
    double total = 0;
    double average;
    int number;

    System.out.print("Enter a number ");
    number = input.nextInt();

    while (number != 0) {
      if (number > 0) {
        total += number;
        pos++;
      } else {
        total += number; // still add the negative to total
        neg++;
      }

      System.out.print("Enter a number ");
      number = input.nextInt();
    }

    if (pos + neg == 0) {
      System.out.println("No numbers are entered except 0");
    } else {
      average = total / (pos + neg);
      System.out.print("The number of positives is " + pos);
      System.out.print("\nThe number of negatives is " + neg);
      System.out.print("\nThe total is " + total);
      System.out.print("\nThe average is " + average);
      System.out.println();
    }

    input.close(); // close scanner
  }
}