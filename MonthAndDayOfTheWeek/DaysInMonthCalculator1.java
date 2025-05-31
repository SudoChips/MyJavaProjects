import java.util.Scanner;

public class DaysInMonthCalculator1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a year: ");
    int year = input.nextInt();

    System.out.print("Enter the first three letters of a month (With the first letter capital, e.g., Jan, Dec): ");
    String month = input.next();

    int days = 0;

    switch (month) {
      case "Jan":
        System.out.println(month + " " + year + " has 31 days");
        break;
      case "Feb":
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
          days = 29;
        } else {
          days = 28;
        }
        System.out.println(month + " " + year + " has " + days + " days");
        break;
      case "Mar":
        System.out.println(month + " " + year + " has 31 days");
        break;
      case "Apr":
        System.out.println(month + " " + year + " has 30 days");
        break;
      case "May":
        System.out.println(month + " " + year + " has 31 days");
        break;
      case "Jun":
        System.out.println(month + " " + year + " has 30 days");
        break;
      case "Jul":
        System.out.println(month + " " + year + " has 31 days");
        break;
      case "Aug":
        System.out.println(month + " " + year + " has 31 days");
        break;
      case "Sep":
        System.out.println(month + " " + year + " has 30 days");
        break;
      case "Oct":
        System.out.println(month + " " + year + " has 31 days");
        break;
      case "Nov":
        System.out.println(month + " " + year + " has 30 days");
        break;
      case "Dec":
        System.out.println(month + " " + year + " has 31 days");
        break;
      default:
        System.out.println(month + " is not a correct month name");
    }

    input.close(); // close scanner
  }
}

/*
Hint: Prompt the user to enter year (int) and a string for month, and displays
the number of days in the month. To test if a string is "Jan", use s.equals("Jan").
To test if a year is a leap year, see Section 3.11.
*/