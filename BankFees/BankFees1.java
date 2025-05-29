import java.util.Scanner;
import java.io.*; // program with a file

public class BankFees1 {
  public static void main(String[] args) throws IOException {

    final String FILE_NAME = "BankFees.txt";

    File fn = new File(FILE_NAME);
    Scanner input = new Scanner(fn);

    int checks;
    double charges = 10;

    // First entry
    checks = input.nextInt();

    if (checks < 20)
      charges += checks * 0.10;
    else if (checks <= 39)
      charges += checks * 0.08;
    else if (checks <= 59)
      charges += checks * 0.06;
    else
      charges += checks * 0.04;

    System.out.println("The bank's service fee for the first entry is " + charges);

    // Second entry
    checks = input.nextInt();
    charges = 10;

    if (checks >= 60)
      charges += checks * 0.04;
    else if (checks >= 40)
      charges += checks * 0.08;
    else if (checks >= 20)
      charges += checks * 0.06;
    else
      charges += checks * 0.10;

    System.out.println("The bank's service fee for the second entry is " + charges);

    input.close(); // close scanner
  }
}