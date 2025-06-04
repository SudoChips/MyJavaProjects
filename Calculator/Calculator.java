import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char selection;
        int num1;
        int num2;
        boolean done = false;

        do {
            selection = getSelection(input);

            if (selection != 'X') {
                num1 = getNumber(input, "Enter the first number: ");
                num2 = getNumber(input, "Enter the second number: ");
                process(selection, num1, num2);
            } else {
                done = true;
            }
        } while (!done);

        System.out.print("\n\nThank you and Good-Bye");
        input.close();
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    public static int getNumber(Scanner input, String msg) {
        int retValue;
        do {
            System.out.print(msg);
            retValue = input.nextInt();
            input.nextLine(); // absorb leftover newline
            if (retValue <= 0)
                System.out.println("Value must be greater than zero, please re-enter.");
        } while (retValue <= 0);
        return retValue;
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    public static char getSelection(Scanner input) {
        char sel;
        boolean done;
        do {
            displayMenu();
            sel = input.nextLine().toUpperCase().charAt(0);
            done = sel == 'A' || sel == 'S' || sel == 'M' || sel == 'D' || sel == 'X';
            if (!done)
                System.out.println("Invalid entry, please try again.");
        } while (!done);
        return sel;
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    public static void process(char selection, int num1, int num2) {
        switch (selection) {
            case 'A': addition(num1, num2); break;
            case 'S': subtraction(num1, num2); break;
            case 'M': multiplication(num1, num2); break;
            case 'D': division(num1, num2); break;
            case 'X': break;
        }
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    public static void addition(int num1, int num2) {
        int result = num1 + num2;
        System.out.println("The result is " + result);
    }

    public static void subtraction(int num1, int num2) {
        int result = num1 - num2;
        System.out.println("The result is " + result);
    }

    public static void multiplication(int num1, int num2) {
        int result = num1 * num2;
        System.out.println("The result is " + result);
    }

    public static void division(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("Cannot divide by zero.");
        } else {
            int result = num1 / num2;
            System.out.println("The result is " + result);
        }
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    public static void displayMenu() {
        System.out.println("\n\nMenu");
        System.out.println("====");
        System.out.println("A - Add");
        System.out.println("S - Subtract");
        System.out.println("M - Multiply");
        System.out.println("D - Divide");
        System.out.println("X - Exit");
    }
}