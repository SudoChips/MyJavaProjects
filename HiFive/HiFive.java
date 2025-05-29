import java.util.Scanner; // Scanner is in the java.util package

public class HiFive {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    int number;
    number = 10;

    if ((number % 5) == 0) System.out.println("Hifive");

    keyboard.close(); // Close the scanner
  }
}