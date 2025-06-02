import java.util.Scanner;

public class DistinctIntCounter {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int[] numbers = new int[10];
        int numberOfDistinctValues = 0;

        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < 10; i++) {
            int value = keyboard.nextInt();

            if (isInNumbers(numbers, numberOfDistinctValues, value)) {
                numbers[numberOfDistinctValues] = value;
                numberOfDistinctValues++;
            }
        }

        System.out.println("The number of distinct numbers is: " + numberOfDistinctValues);
        System.out.print("The distinct numbers are:");
        for (int i = 0; i < numberOfDistinctValues; i++) {
            System.out.print(" " + numbers[i]);
        }
        System.out.println();

        keyboard.close();
    }

    public static boolean isInNumbers(int[] numbers, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (numbers[i] == value)
                return false;
        }
        return true;
    }
}

//How would you write this program? Here are some hints:
//Step 1: Create an array for numbers using new int[10].
//Step 2: Declare and initialize an int variable numberOfDistinctValues (int).
//Step 3: Write a for loop to execute 10 times. Each iteration of the loop performs the following actions:
//Step 3.1: Read an int value.
//Step 3.2: Test if value is already in numbers.
//Step 3.3: if value is not numbers, add value to numbers: numbers[numberOfDistinctValues] = value.
//Step 3.4: Increase numberOfDistinctValues by 1.
//Step 4: Display the output: display numberOfDistinctValues and all the elements in //numbers.
//For Step 3.2, you may write a method
//public static boolean isInNumbers(int[] numbers, int size, int value)
//This method return true if value is equal to numbers[0], numbers[1], � numbers[size -1].