import java.util.Scanner; // Scanner is in the java.util package

public class FutureInvestment {
  public static void main(String[] args) {
    // Create a Scanner object
    Scanner input = new Scanner(System.in);

    System.out.print("Enter investment amount ");
    double amount = input.nextDouble();

    System.out.print("Enter annual interest rate ");
    double monthlyInterestRate = (input.nextDouble() / 100.0) / 12;

    System.out.print("Enter how many years ");
    double years = input.nextDouble();

    double futureInvestment = amount *
      (Math.pow((1 + monthlyInterestRate), (years * 12)));

    System.out.print("Your future investment amount is " + futureInvestment);

    input.close(); // close scanner
  }
}