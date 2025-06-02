import java.util.Scanner;

public class FractionSeries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("%-3s %7s\n", "i", "m(i)");

        for (int i = 1; i <= 20; i++) {
            System.out.printf("%-3d %7.4f\n", i, m(i));
        }

        input.close();
    }

    public static double m(int i) {
        return (double) i / (i + 1);
    }
}

/* 
Step 1: Create a public class.
Step 2: Add two methods: the main method and the m(int i) method.
Step 3: Implement the m(int i) method to return the summation as shown in the formula for m(i)
given in the description.
Step 3.1: declare and initialize sum.
Step 3.2: for each k from 1 to i, add k / (k + 1.0) to sum. Note we are using 1.0 rather than 1
to obtain a double result.
Step 3.3: return sum.
Step 4: Implement the main method as follows:
Step 4.1: Display the header of the table using printf. The header is “i m(i)”.
Step 4.2: Write a for loop as follows: for each i from 1 to 20, display i and the result from
invoking m(i).
The result of m(i) is displayed with four digits after the decimal point. So, 0.5 should be
displayed 0.5000 using printf.
*/