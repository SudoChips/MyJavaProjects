import java.util.Scanner;

public class ReadingNumbers {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter a number between 1 and 10: ");
    int number = input.nextInt();

    System.out.println();

    if (number == 1)
      System.out.println("Your number is one");
    else if (number == 2)
      System.out.println("Your number is two");
    else if (number == 3)
      System.out.println("Your number is three");
    else if (number == 4)
      System.out.println("Your number is four");
    else if (number == 5)
      System.out.println("Your number is five");
    else if (number == 6)
      System.out.println("Your number is six");
    else if (number == 7)
      System.out.println("Your number is seven");
    else if (number == 8)
      System.out.println("Your number is eight");
    else if (number == 9)
      System.out.println("Your number is nine");
    else if (number == 10)
      System.out.println("Your number is ten");
    else
      System.out.println("That number is not between 1 and 10");

    input.close(); // Close scanner
  }
}