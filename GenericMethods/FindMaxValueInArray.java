import java.util.Scanner;

public class FindMaxValueInArray {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the length for an array: ");
            int index = input.nextInt();

            Integer[] arr = new Integer[index];

            for (int i = 0; i < index; i++) {
                System.out.print("Enter number " + (i + 1) + ": ");
                arr[i] = input.nextInt();
            }

            System.out.println("The largest number in the array is: " + max(arr));

            input.close();
        } catch (Exception ex) {
            System.out.println("No no no\n");
            main(args);
        }
    }

    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(max) > 0) {
                max = list[i];
            }
        }
        return max;
    }
}