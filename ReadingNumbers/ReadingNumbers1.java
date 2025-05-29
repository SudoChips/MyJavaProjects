import java.util.Scanner;

public class ReadingNumbers1 {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter a number between 1 and 10: ");
    int number = input.nextInt();

    switch (number) {
      case 1: System.out.println("Your number is one"); break;
      case 2: System.out.println("Your number is two"); break;
      case 3: System.out.println("Your number is three"); break;
      case 4: System.out.println("Your number is four"); break;
      case 5: System.out.println("Your number is five"); break;
      case 6: System.out.println("Your number is six"); break;
      case 7: System.out.println("Your number is seven"); break;
      case 8: System.out.println("Your number is eight"); break;
      case 9: System.out.println("Your number is nine"); break;
      case 10: System.out.println("Your number is ten"); break;
      default: System.out.println("That number is not between 1 and 10");
    }

    input.close(); // close scanner
  }
}