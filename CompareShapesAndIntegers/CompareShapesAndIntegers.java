import java.util.Comparator;
import java.util.Scanner;

public class CompareShapesAndIntegers {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            // Sort numbers
            System.out.print("Enter the length for a number array: ");
            int index = input.nextInt();

            Integer[] arr = new Integer[index];
            for (int i = 0; i < index; i++) {
                System.out.print("Enter a number: ");
                arr[i] = input.nextInt();
            }

            bubbleSort(arr);
            System.out.print("The sorted number array is: ");
            for (int x : arr) {
                System.out.print(x + " ");
            }

            System.out.println("\n");

            // Sort Shapes
            Shape[] list = {
                new Circle(1.0),
                new Circle(6.7),
                new Circle(2.5),
                new Circle(1.3),
                new Circle(1.17)
            };

            bubbleSort(list, new ShapeComparator());

            System.out.print("The sorted circle sizes are: ");
            for (Shape s : list) {
                System.out.print(s.size + " ");
            }

            input.close();
        } catch (Exception ex) {
            System.out.println("No no no");
            System.out.println();
            main(args);
        }
    }

//-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list.length - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

//-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list.length - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}