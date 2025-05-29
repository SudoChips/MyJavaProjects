import java.util.Scanner;

public class DayOfWeekCalculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a month: 1-12: ");
    int month = input.nextInt();

    System.out.print("Enter a year ");
    int year = input.nextInt();

    System.out.print("Enter a day of the month: 1-31: ");
    int q = input.nextInt();

    if (month == 1) {
      month = 13;
      year -= 1;
    }
    if (month == 2) {
      month = 14;
      year -= 1;
    }

    int j = year / 100;
    int k = year % 100;
    int h;

    h = (q + 26 * (month + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;

    switch (h) {
      case 0: System.out.print("The day of the week is Saturday"); break;
      case 1: System.out.print("The day of the week is Sunday"); break;
      case 2: System.out.print("The day of the week is Monday"); break;
      case 3: System.out.print("The day of the week is Tuesday"); break;
      case 4: System.out.print("The day of the week is Wednesday"); break;
      case 5: System.out.print("The day of the week is Thursday"); break;
      case 6: System.out.print("The day of the week is Friday"); break;
    }

    System.out.println(); // ensures clean terminal formatting
    input.close(); // close scanner
  }
}