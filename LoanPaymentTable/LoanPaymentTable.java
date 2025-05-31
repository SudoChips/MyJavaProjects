import java.util.Scanner;

public class LoanPaymentTable {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double monthlyInterestRate = 0;
    double monthlyPayment = 0;
    double totalPayment = 0;

    System.out.print("Loan Amount: ");
    double loanAmount = input.nextDouble();

    System.out.print("Number of years: ");
    int numberOfYears = input.nextInt();

    System.out.printf("%-20s%-20s%-20s\n", "Interest Rate", "Monthly Payment", "Total Payment");

    for (double annualInterestRate = 5.0; annualInterestRate <= 8.0; annualInterestRate += 0.125) {
      monthlyInterestRate = annualInterestRate / 1200;
      monthlyPayment = monthlyInterestRate * loanAmount /
                       (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
      totalPayment = monthlyPayment * 12 * numberOfYears;

      System.out.printf("%-20.3f%-20.2f%-20.2f\n", annualInterestRate, monthlyPayment, totalPayment);
	  //System.out.printf("\n%5.3f %6.2f %-8.2f",annualInterestRate, monthlyPayment,totalPayment);
	}

    input.close(); // close scanner
  }
}

//For this program, you need to use the formula for computing monthlyPayment and totalPayment in Section
//2.16.
//How would you write this program? Here are some hints:
//Step 1: Prompt the user to read loanAmount (double) and numberOfYears (int).
//Step 2: Print the header using System.out.printf("%-20s%-20s%-20s\n", "Interest Rate", "Monthly
//Payment", "Total Payment");
//Step 3: Write a for loop as follows:
//Step 3.1: The initial action is to declare and initialize annualInterestRate to 5.0.
//Step 3.2: The loop continuation condition is <= 8.0.
//Step 3.3: The action after each iteration is annualInterestRate += 1.0/ 8.
//Step 3.4: In the loop body, compute monthlyPayment and totalPayment using the formula. Note the
//monthlyInterestRate is annualInterestRate / 1200. Display annualInterestRate, monthlyPayment, and
//totalPayment in one line using printf to format the output. Please note: in the first column, you need to put
//three digits after the decimal point. For example, 5.000% is correct, but 5% is wrong.