import java.util.Scanner;

public class SSNValidator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a Social Security Number: (###-##-####): ");
    String ssn = input.nextLine();

    if ((ssn.length() == 11) &&
        (Character.isDigit(ssn.charAt(0))) &&
        (Character.isDigit(ssn.charAt(1))) &&
        (Character.isDigit(ssn.charAt(2))) &&
        (ssn.charAt(3) == '-') &&
        (Character.isDigit(ssn.charAt(4))) &&
        (Character.isDigit(ssn.charAt(5))) &&
        (ssn.charAt(6) == '-') &&
        (Character.isDigit(ssn.charAt(7))) &&
        (Character.isDigit(ssn.charAt(8))) &&
        (Character.isDigit(ssn.charAt(9))) &&
        (Character.isDigit(ssn.charAt(10)))) {
      System.out.print(ssn + " is a valid social security number");
    } else {
      System.out.print(ssn + " is an invalid social security number");
    }

    input.close(); // close scanner
  }
}

/*
You will need to use s.length(), s.charAt(i), and Character.isDigit(ch) method in the program.
*/