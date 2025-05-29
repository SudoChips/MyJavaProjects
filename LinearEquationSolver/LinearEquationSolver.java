import java.util.Scanner;

public class LinearEquationSolver {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double x;
    double y;

    System.out.print("Enter a value for a ");
    double a = input.nextDouble();

    System.out.print("Enter a value for b ");
    double b = input.nextDouble();

    System.out.print("Enter a value for c ");
    double c = input.nextDouble();

    System.out.print("Enter a value for d ");
    double d = input.nextDouble();

    System.out.print("Enter a value for e ");
    double e = input.nextDouble();

    System.out.print("Enter a value for f ");
    double f = input.nextDouble();

    double numbers = a * d - b * c;

    if (numbers == 0)
      System.out.println("The equation has no solution");
    else {
      x = ((e * d) - (b * f)) / numbers;
      y = ((a * f) - (e * c)) / numbers;
      System.out.print("x is " + x + " y is " + y);
    }

    input.close(); // close scanner
  }
}