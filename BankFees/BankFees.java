import java.util.Scanner;

public class BankFees {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter the number of checks for the month ");
    int checks = input.nextInt();

    double charges = 10;

    System.out.println();

    if (checks < 0) {
      System.out.println("Invalid number of checks.");
    } else {
      if (checks < 20)
        charges += checks * 0.10;
      else if (checks <= 39)
        charges += checks * 0.08;
      else if (checks <= 59)
        charges += checks * 0.06;
      else
        charges += checks * 0.04;

      System.out.println("The banks service fee for the month is " + charges);
    }

    input.close(); // close scanner
  }
}