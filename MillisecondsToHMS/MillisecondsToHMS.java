import java.util.Scanner;

public class MillisecondsToHMS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter time in milliseconds: ");
        long totalMillis = input.nextLong();

        System.out.print(convertMillis(totalMillis));

        input.close(); // Close the scanner
    }

    public static String convertMillis(long millis) {
        long totalSeconds = millis / 1000;
        long seconds = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long minutes = totalMinutes % 60;
        long totalHours = totalMinutes / 60;

        return totalHours + ":" + minutes + ":" + seconds + "\n";
    }
}

   //Step 1: Create a public class.
   //Step 2: Add two methods: the main method and the convertMillis(long millis) method.
   //Step 3: Implement the convertMillis(long millis) method as follows:
   //Step 3.1: Obtain seconds from millis.
   //Step 3.2: Obtain totalMinutes from seconds.
   //Step 3.3: Obtain minutes from totalMinutes % 60.
   //Step 3.4: Obtain totalHours from totalMinutes / 60.
   //Step 3.5: Return a string: hours + ":" + minutes + ":" + seconds.
   //Step 4: Implement the main method as follows:
   //Step 4.1: Prompt the user to enter a long value using input.nextLong() into variable totalMillis.
   //Step 4.2: Invoke convertMillis(totalMillis) to return a string.
   //Step 4.3: Display this string.