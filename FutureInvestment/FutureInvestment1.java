import java.util.Scanner;

public class FutureInvestment1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the investment amount, for example 120000.95: ");
    double investmentAmount = input.nextDouble();

    System.out.print("Enter annual interest rate, for example 8.25: ");
    double annualInterestRate = input.nextDouble();

    System.out.print("\nYears      Future Value\n\n");

    for (int year = 1; year <= 30; year++) {
      System.out.printf("%-2d          %-7.2f\n\n",
        year, futureInvestmentValue(investmentAmount, annualInterestRate / 1200, year));
    }

    input.close(); // close scanner
  }

  public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int year) {
    return investmentAmount * Math.pow(1 + monthlyInterestRate, year * 12);
  }
}