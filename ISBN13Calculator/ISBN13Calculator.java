import java.util.Scanner;

public class ISBN13Calculator {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
    String number = input.nextLine();

    if (number.length() != 12) {
      System.out.print(number + " is an invalid input");
      input.close(); // close scanner
      return; // stop the program
    }

    int sum = 0;
    for (int i = 0; i < number.length(); i++) {
      int digit = number.charAt(i) - '0';

      if ((i + 1) % 2 == 0)
        sum += digit;
      else
        sum += digit * 3;
    }

    int checkSum = 10 - sum % 10;
    if (checkSum == 10)
      checkSum = 0;

    System.out.printf("The ISBN-13 number is %s%d\n", number, checkSum);

    input.close(); // close scanner
  }
}

/*
Step 1: Prompt the user to enter the first 12 digits of an ISBN-13 as a string s using input.nextLine().
Step 2: If the length of the input is not 12, exit the program using return.
Step 3: Declare and initialize variable sum.
Step 4: For each i from 0 to s.length() – 1, do the following:
  Step 4.1: If (i % 2 is 0), add (s.charAt(i) - '0') * 3 to sum.
  Step 4.2: else, add (s.charAt(i) - '0') to sum.
Step 5: Obtain checksum that is 10 – sum % 10.
Step 6: Display the entire ISBN-13 string whose last digit is checksum.
  Note: If checksum is 10, display 0.
*/