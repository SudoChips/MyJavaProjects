import java.util.Scanner; // Scanner is in the java.util package

public class HiFive1 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    int number;

    number = 25;

    if ((number % 5) == 0)
      System.out.println("Hifive");
    else
      System.out.println("Not divisible by five");

    if ((number % 2) == 0)
      System.out.println("Hieven");
    else
      System.out.println("Not even");

    keyboard.close(); // Close scanner
  }
}
