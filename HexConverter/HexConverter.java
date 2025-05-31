import java.util.Scanner;

public class HexConverter {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a decimal number: ");
    int decimal = input.nextInt();

    // turning decimal to hex
    if (decimal >= 0 && decimal <= 9)
      System.out.println("The hex value is: " + decimal);
    else if (decimal >= 10 && decimal <= 15)
      System.out.println("The hex value is: " + (char)(decimal + 'A' - 10));
    else
      System.out.println(decimal + " is an invalid input");

    input.close(); // close scanner

    /*
    System.out.print("Enter a hex digit: ");
    String hexString = input.nextLine();

    if (hexString.length() != 1) {
      System.out.println("You must enter exactly one character");
      System.exit(1);
    }

    // turning hex into a decimal
    char ch = Character.toUpperCase(hexString.charAt(0));

    if (ch <= 'F' && ch >= 'A') {
      int value = ch - 'A' + 10;
      System.out.println("The decimal value for hex digit " + ch + " is " + value);
    } else if (Character.isDigit(ch)) {
      System.out.println("The decimal value for hex digit " + ch + " is " + ch);
    } else {
      System.out.println(ch + " is an invalid input");
    }
    */
  }
}