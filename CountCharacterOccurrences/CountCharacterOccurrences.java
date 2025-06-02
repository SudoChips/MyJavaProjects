import java.util.Scanner;

public class CountCharacterOccurrences {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = input.nextLine();

        System.out.print("Enter a character: ");
        char ch = input.nextLine().charAt(0);

        System.out.print("The number of occurrences of " + ch + " in " + s + " is " + count(s, ch) + '\n');

        input.close(); // close the scanner
    }

    public static int count(String str, char a) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                count++;
            }
        }
        return count;
    }
}

 /*  Step 1: Create a public class.
   Step 2: Add two methods: the main method and the count(String str, char a) method.
   Step 3: Implement the count(String str, char a) as follows:
   Step 3.1: declare and initialize count.
   Step 3.2: for each i from 1 to str.length() - 1, if str.charAt(i) == a, increase count by 1.
   Step 3.3: return count.
   Step 4: Implement the main method as follows:
   Step 4.1: Prompt the user to enter a string s using input.nextLine().
   Step 4.2: Prompt the user to enter a char. To do so, read a line, and assign line.charAt(0) to character ch.
   Step 4.3: Simply invoke count(s, ch) to return the count and display the result as shown in the sample run.
*/