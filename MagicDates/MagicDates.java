import java.util.Scanner;

public class MagicDates {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a month: (1-12): ");
    int month = input.nextInt();

    System.out.print("Enter a day: (1-31): ");
    int days = input.nextInt();

    System.out.print("Enter a two digit year (e.g., 1960 enter 60): ");
    int year = input.nextInt();

    int monthDay = month * days;

    if (monthDay == year)
      System.out.print("The date is magic");
    else
      System.out.print("The date is not magic");

    System.out.println();

    input.close(); // close scanner
  }
}