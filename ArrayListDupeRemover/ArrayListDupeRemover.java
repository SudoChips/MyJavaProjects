import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDupeRemover {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        getNumbers(list, input);
        ArrayListDupeRemoverClass.removeDuplicate(list);
        input.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void getNumbers(ArrayList<Integer> list, Scanner input) {
        System.out.println("Enter 10 integers");

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter a number: ");
            list.add(input.nextInt());
        }

        System.out.println("The integers entered are: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println(); // Newline for clean output
    }
}