import java.util.Scanner; // Scanner is in the java.util package

public class MinutesToYearsAndDays {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Enter minutes to know number of years and days: ");
        int minutes = input.nextInt();

        int minutesInHour = 60;
        int hoursInDay = 24;
        int daysInYear = 365;

        int totalDays = minutes / (minutesInHour * hoursInDay);
        int years = totalDays / daysInYear;
        int days = totalDays % daysInYear;

        System.out.print(minutes + " minutes is approximately " + years + " years and " + days + " days.");

        input.close();
    }
}