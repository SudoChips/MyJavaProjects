import java.util.Scanner;

public class MonthAndDayOfTheWeek {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a year: ");
    int year = input.nextInt();

    System.out.print("Enter a month (1–12): ");
    int originalMonth = input.nextInt(); // keep original for name

    System.out.print("Enter a day of the month (1–31): ");
    int q = input.nextInt();

    int month = originalMonth;

    if (month == 1) {
      month = 13;
      year -= 1;
    } else if (month == 2) {
      month = 14;
      year -= 1;
    }

    int j = year / 100;
    int k = year % 100;

    int h = (q + (26 * (month + 1)) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;

    // Month name
    switch (originalMonth) {
      case 1: System.out.print("The month is January "); break;
      case 2: System.out.print("The month is February "); break;
      case 3: System.out.print("The month is March "); break;
      case 4: System.out.print("The month is April "); break;
      case 5: System.out.print("The month is May "); break;
      case 6: System.out.print("The month is June "); break;
      case 7: System.out.print("The month is July "); break;
      case 8: System.out.print("The month is August "); break;
      case 9: System.out.print("The month is September "); break;
      case 10: System.out.print("The month is October "); break;
      case 11: System.out.print("The month is November "); break;
      case 12: System.out.print("The month is December "); break;
    }

    // Day of the week
    switch (h) {
      case 0: System.out.print("and the day of the week is Saturday"); break;
      case 1: System.out.print("and the day of the week is Sunday"); break;
      case 2: System.out.print("and the day of the week is Monday"); break;
      case 3: System.out.print("and the day of the week is Tuesday"); break;
      case 4: System.out.print("and the day of the week is Wednesday"); break;
      case 5: System.out.print("and the day of the week is Thursday"); break;
      case 6: System.out.print("and the day of the week is Friday"); break;
    }

    input.close(); // close scanner
  }
}