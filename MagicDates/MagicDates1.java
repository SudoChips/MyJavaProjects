import java.util.Scanner; // Scanner is in the java.util package
import java.io.*;

public class MagicDates1 {
  public static void main(String[] args) throws IOException {

    Scanner input = new Scanner(System.in);

    System.out.println("The date June 10, 1960, is special because when we write it in the following format,");
    System.out.println("the month times the day equals the year: 6/10/60\n");

    System.out.print("Enter a number month: ");
    int month = input.nextInt();

    System.out.print("Enter a number day: ");
    int day = input.nextInt();

    System.out.print("Enter a year: ");
    int year = (input.nextInt() % 100); // Convert 4-digit year to 2-digit

    System.out.println("You entered " + month + " / " + day + " / " + year);

    if (month > 12 || day > 31)
      System.out.println("Invalid month or date");
    else {
      System.out.println("The entered month times the entered day is " + (month * day) + " and the year you entered is " + year);
      if (month * day == year)
        System.out.println("This date is magic \nbecause the month times the day equals the year");
      else
        System.out.println("This date is not magic \nbecause the month times the day does not equal the year");
    }

    input.close(); // close scanner
  }
}

/* 
2. Magic Dates
The date June 10, 1960, is special because when we write it in the following format,
the month times the day equals the year: 6/10/60

Write a program that asks the user to enter a month (in numeric form), a day, and a two-digit
year. The program should then determine whether the month times the day is equal
to the year. If so, it should display a message saying the date is magic. Otherwise, it should
display a message saying the date is not magic.
*/