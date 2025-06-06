import java.util.Scanner;

public class RecursiveCharSearch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            String str = input.nextLine().toLowerCase();

            if (str.isEmpty()) {
                System.out.println("String cannot be empty.");
            } else {
                System.out.print("Enter a character to search for: ");
                char a = input.next().charAt(0);
                System.out.println("The number of the character '" + a + "' is: " + count(str, a));
            }

        } catch (Exception ex) {
            System.out.println("Invalid input.\n");
            main(args);
        } finally {
            input.close();
        }
    }

    public static int count(String str, char a) {
        int characters = 0;
        if (str.charAt(0) == a)
            characters++;
        if (str.length() == 1)
            return characters;
        else
            return characters + count(str.substring(1), a);
    }
}