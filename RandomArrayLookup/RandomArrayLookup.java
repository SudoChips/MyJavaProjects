import java.util.Scanner;

public class RandomArrayLookup {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean validIndex = false;

        while (!validIndex) {
            try {
                int[] rando = new int[100];

                // Fill array with random numbers
                for (int i = 0; i < rando.length; i++) {
                    rando[i] = (int) (Math.random() * 100);
                }

                System.out.print("Enter an index (0 to 99): ");
                int index = input.nextInt();

                System.out.println("The number at index " + index + " is " + rando[index]);
                validIndex = true;

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index out of bounds. Please enter a number between 0 and 99.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.nextLine(); // Clear invalid input
            }
        }

        input.close();
    }
}