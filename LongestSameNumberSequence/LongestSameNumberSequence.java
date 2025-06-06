import java.util.Scanner;

public class LongestSameNumberSequence {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a series of numbers ending with 0: ");
            String numbers = input.nextLine(); // Example: "2 4 4 8 8 8 8 2 4 4 0"

            String[] arr = numbers.split(" ");
            int count = 1;
            int max = 0;
            int begin = 0;
            int previousStart = 0;
            int endNumber = 0;

            for (int indx = 1; indx < arr.length; indx++) {
                if (Integer.parseInt(arr[indx]) == Integer.parseInt(arr[indx - 1])) {
                    count++;
                } else {
                    if (max < count) {
                        max = count;
                        previousStart = begin; // index with the highest count
                        endNumber = Integer.parseInt(arr[indx - 1]);
                    }
                    begin = indx;
                    count = 1;
                }
            }

            System.out.println(
                "The longest same number sequence starts at index " +
                previousStart + " with " + max + " values of " + endNumber
            );

            input.close();
        } catch (Exception ex) {
            System.out.println("No no no");
            System.out.println(" ");
            main(args); // retry on failure
        }
    }
}