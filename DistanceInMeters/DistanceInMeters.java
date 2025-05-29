import java.util.Scanner;

public class DistanceInMeters {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter a distance in meters: ");
    double meters = input.nextDouble();

    double kilometers = meters * 0.001;
    double inches = meters * 39.37;
    double feet = meters * 3.281;

    System.out.println("Select one from the following menu:");
    System.out.println("\n1. Convert to kilometers");
    System.out.println("2. Convert to inches");
    System.out.println("3. Convert to feet");
    System.out.println("4. Quit the program");

    int number = input.nextInt();

    if (number == 1)
      System.out.println("Your number in kilometers is " + kilometers);
    else if (number == 2)
      System.out.println("Your number in inches is " + inches);
    else if (number == 3)
      System.out.println("Your number in feet is " + feet);
    else if (number == 4)
      System.out.println("No conversion. Good-bye.");
    else
      System.out.println("Invalid selection.");

    input.close(); // close scanner
  }
}