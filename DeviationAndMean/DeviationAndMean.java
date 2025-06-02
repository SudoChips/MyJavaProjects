import java.util.Scanner;

public class DeviationAndMean {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        double[] numbers = new double[10];

        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = keyboard.nextDouble();

        System.out.printf("\nThe mean is: %4.2f\n", mean(numbers));
        System.out.printf("The standard deviation is: %7.5f\n", deviation(numbers));

        keyboard.close();
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static double deviation(double[] x) {
        double squareSum = 0;
        double avg = mean(x);
        for (int i = 0; i < x.length; i++) {
            squareSum += Math.pow((x[i] - avg), 2);
        }
        return Math.sqrt(squareSum / (x.length - 1));
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static double mean(double[] x) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum / x.length;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}

//Step 1: Create a class.
//Step 2: Add a main method, the mean method, and the deviation method in the class.
//Step 3: Implement the mean(double[] x) method as follows:
//Step 3.1: Declare and initialize a double variable sum.
//Step 3.2: Write a loop to all elements in array x into sum.
//Step 3.3: Return sum / x.length;
//Step 4: Implement the deviation(double [] x) method as follows:
//Step 4.1: Declare and initialize squareSum.
//Step 4.2: Write a loop. For each element x[i], add (x[i] � mean(x)) ^ 2 to squareSum.
//Step 4.3: return Math.sqrt(squareSum / (x.length � 1))
//Step 5: Implement the main method as follows:
//Step 5.1: Create an array numbers using new double[10].
//Step 5.2: Prompt the user to enter 10 numbers and store them in numbers.
//Step 5.3: Invoke mean(numbers) and deviation(numbers) to obtain mean and deviation for numbers.