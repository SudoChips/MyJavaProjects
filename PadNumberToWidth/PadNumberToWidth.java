import java.util.Scanner;

public class PadNumberToWidth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        System.out.print("Enter the width: ");
        int width = input.nextInt();

        System.out.println(format(number, width));

        input.close(); // Close the scanner
    }

    public static String format(int number, int width) {
        String result = number + "";
        int numberOfDigits = result.length();

        for (int i = 1; i <= width - numberOfDigits; i++) {
            result = "0" + result;
        }

        return result;
    }
}

   //Step 1: Create a public class.
   //Step 2: Add two methods: the main method and the format(int number, int width).
   //Step 3: Implement the format(int number, int width) method as follows:
   //Step 3.1: Assign number + "" to a String variable result.
   //Step 3.2: Obtain the numberOfDigits in number. For example, if number is 231, the numberOfDigits
   //is 3. A simple way of obtaining numberOfDigits is (number + "").length(). number + "" is a
   //string representation for number. Since result is number + "", numberOfDigits is result.length().
   //Step 3.3: Add width-numberOfDigits number of 0 before result. To accomplish this, write a for loop as
   //follows: for each i from 1 to width � numberOfDigits, do result = "0" + result, which add a digit
   //0 before result.
   //Step 3.4: return result.
   //Step 4: Implement the main method as follows:
   //Step 4.1: Prompt the user to enter an integer number.
   //Step 4.2: Prompt the user to enter an integer width.
   //Step 4.3: Invoke format(number, width) to return a string and display it.