import java.util.Scanner;

public class AreaOfAPolygon {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the number of sides: ");
    int n = input.nextInt();

    System.out.print("Enter the length of the side ");
    double s = input.nextDouble();

    double area = n * Math.pow(s, 2) / (4 * Math.tan(Math.PI / n));

    System.out.print("The area is: " + area);

    input.close(); // close scanner
  }
}