import java.util.Scanner;

public class InternetServiceProvider {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a package letter: (A, B, or C): ");
    char plan = input.next().toUpperCase().charAt(0);

    System.out.print("Enter the number of hours: ");
    int hours = input.nextInt();

    int baseHours;
    double baseCharges = 0;

    double charges;
    double overage;

    if (plan == 'A') {
      baseCharges = 9.95;
      if (hours > 10) {
        baseHours = 10;
        overage = (2.00 * (hours - baseHours));
        charges = overage + baseCharges;
        System.out.print("The total charges are " + charges);
        System.out.println("\nThe total overage is " + overage);
      } else {
        System.out.print("The total charges are " + baseCharges);
      }
    }

    else if (plan == 'B') {
      baseCharges = 13.95;
      if (hours > 20) {
        baseHours = 20;
        overage = (1.00 * (hours - baseHours));
        charges = overage + baseCharges;
        System.out.print("The total charges are " + charges);
        System.out.println("\nThe total overage is " + overage);
      } else {
        System.out.print("The total charges are " + baseCharges);
      }
    }

    else if (plan == 'C') {
      charges = 19.95;
      System.out.print("The total charges are " + charges);
    }

    else {
      System.out.print("Invalid package letter entered.");
    }

    System.out.println();
    input.close(); // close scanner
  }
}