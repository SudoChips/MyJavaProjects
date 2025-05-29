import java.util.Scanner;

public class PayrollStatement {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter Employee's name (e.g., Smith): ");
    String name = input.nextLine();

    System.out.print("Enter the number of hours worked in a week (e.g., 10): ");
    double hours = input.nextDouble();

    System.out.print("Enter the hourly pay rate (e.g., 9.75): ");
    double hourlyPayRate = input.nextDouble();

    System.out.print("Enter the federal tax withholding rate (e.g., 0.20 for 20%): ");
    double fedTax = input.nextDouble();

    System.out.print("Enter the state tax withholding rate (e.g., 0.09 for 9%): ");
    double stateTax = input.nextDouble();

    double grossPay = hours * hourlyPayRate;
    double fedTaxTotal = fedTax * grossPay;
    double stateTaxTotal = stateTax * grossPay;
    double totalDeductions = fedTaxTotal + stateTaxTotal;
    double netPay = grossPay - totalDeductions;
    double displayFedTax = fedTax * 100;
    double displayStateTax = stateTax * 100;

    System.out.printf("\nEmployee Name: %s \nHours Worked: %5.2f \nPay Rate: $%-5.2f \nGross Pay: $%5.2f\n",name,hours,hourlyPayRate,grossPay);
    System.out.printf("Deductions:\n  Federal Withholding: (%5.2f%%): $%5.2f \n  State Withholding: (%1.1f%%): $%5.2f \n  Total Deduction: $%5.2f \nNet Pay:   $%5.2f\n",displayFedTax,fedTaxTotal,displayStateTax,stateTaxTotal,totalDeductions,netPay);

    input.close(); // close scanner
  }
}