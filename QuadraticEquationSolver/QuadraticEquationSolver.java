import java.util.Scanner;

public class QuadraticEquationSolver {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a value for a ");
    double a = input.nextDouble();

    System.out.print("Enter a value for b ");
    double b = input.nextDouble();

    System.out.print("Enter a value for c ");
    double c = input.nextDouble();

    double discriminant = b * b - 4 * a * c;
    double root1 = 0;
    double root2 = 0;

    // double root1 = (-b + Math.pow((b * b) - (4*a*c ), .05)) / (2 * a);
    // double root2 = (-b - Math.pow((b * b) - (4*a*c ), .05)) / (2 * a);

    if (discriminant > 0) {
      root1 = ((-b + Math.sqrt(discriminant)) / (2 * a));
      root2 = ((-b - Math.sqrt(discriminant)) / (2 * a));
      System.out.print("root 1 is " + root1 + " and root 2 is " + root2);
    } else if (discriminant == 0) {
      root1 = root2 = -b / (2 * a);
      System.out.print("root 1 is " + root1);
    } else {
      System.out.println("The equation has no real roots");
    }

    input.close(); // close scanner
  }
}