import java.util.Scanner;

public class IntegerFrequencyCounter {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int[] counts = new int[100];
        int number;

        System.out.println("Enter the integers between 1 and 100 (0 to stop):");

        do {
            number = keyboard.nextInt();
            if (number >= 1 && number <= 100) {
                counts[number - 1]++;
            }
        } while (number != 0);

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println((i + 1) + " occurs " + counts[i] + (counts[i] == 1 ? " time" : " times"));
            }
        }

        keyboard.close();
    }
}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/*Step 1: Create an array for counts using new int[100]. count[0] will store the number of 1s entered and
count[99] will store the number of 100 entered. By default, the count[i] is 0.
Step 2: Read a number.
Step 3: Write a while loop:
Step 3.1: The loop continuation condition is (number != 0).
Step 3.2: if number is between 1 and 100, count[number � 1]++.
Step 3.3: read the number again.
Step 4: Write a for loop to display the result as follows:
Step 4.1: for i from 0 to 99
Step 4.2: if counts[i] > 1, display number i + 1, counts[i] and �time� or �times�. If (counts[i] > 1), displays
�times�. If (counts[i] == 1), display �time�.*/
