import java.util.Scanner;

public class RecursiveStringReverser {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            String x = input.nextLine().toLowerCase();
            System.out.println(reverseDisplay(x));
        } catch (Exception ex) {
            System.out.print("No no no");
        }

        input.close();
    }

    public static String reverseDisplay(String x) {
        if (x.isEmpty()) {
            return x;
        } else {
            return reverseDisplay(x.substring(1)) + x.charAt(0);
        }
    }
}