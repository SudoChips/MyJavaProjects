import java.util.Scanner;

public class CurrencyConversion {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.print("Enter the exchange rate from currency in U.S. dollars to Chinese RMB: ");
    double exchangeRate = keyboard.nextDouble();

    System.out.print("Enter 0 to convert from U.S. dollars to Chinese RMB or Enter 1 to convert from Chinese RMB to U.S. dollars: ");
    int convert = keyboard.nextInt();

    while (convert != 0 && convert != 1) {
      System.out.print("Invalid selection, Enter 0 to convert from U.S. dollars to Chinese RMB or Enter 1 to convert from Chinese RMB to U.S. dollars: ");
      convert = keyboard.nextInt();
    }

    if (convert == 0) {
      System.out.print("Enter the amount in U.S. dollars to convert it to Chinese RMB: ");
      double amountofDollars = keyboard.nextDouble();
      double dollarsToRMB = amountofDollars * exchangeRate;
      System.out.println("The amount of U.S. Dollars " + amountofDollars + " converted to Chinese RMB is: " + dollarsToRMB);
    }

    if (convert == 1) {
      System.out.print("Enter the amount in Chinese RMB to convert it to U.S. dollars: ");
      double amountofRMB = keyboard.nextDouble();
      double RMBToDollars = amountofRMB / exchangeRate; // Use division to convert *from* RMB
      System.out.println("The amount of Chinese RMB " + amountofRMB + " converted to U.S. Dollars is: " + RMBToDollars);
    }

    keyboard.close(); // close scanner
  }
}