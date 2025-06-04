import java.util.Scanner;

public class SortedListChecker {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter list: ");
        int indx = keyboard.nextInt();
        int[] list = new int[indx];

        for (int i = 0; i < list.length; i++) {
            list[i] = keyboard.nextInt();
        }

        if (isSorted(list))
            System.out.print("The list is already sorted");
        else
            System.out.print("The list is not sorted");

        keyboard.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static boolean isSorted(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1])
                return false;
        }
        return true;
    }
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}

/*How would you write this program? Here are some hints:
Step 1: Create a class.
Step 2: Add a main method and the isSorted(int[] list) method in the class.
Step 3: Implement the isSorted(int[] list) method as follows:
Step 3.1: Write a for loop: for i from 0 to list.length � 2, if (list[i] > list[i + 1]), return false.
Step 3.2: If nothing is return in the for loop, return true after the for loop.
Step 4: Implement the main method as follows:
Step 4.1: Prompt the user to enter the size of list. Create list using new int[size].
Step 4.2: Prompt the user to enter int values for list.
Step 5: Invoke isSorted(list) to test if the elements in list are sorted.*/