import java.util.ArrayList;

public class ArrayListDupeRemoverClass {

    public static void removeDuplicate(ArrayList<Integer> list) {
        for (int indx = 0; indx < list.size(); indx++) {
            for (int indx1 = indx + 1; indx1 < list.size(); indx1++) {
                if (list.get(indx).equals(list.get(indx1))) {
                    list.remove(indx1);
                    indx1--; // prevent skipping next element after removal
                }
            }
        }

        System.out.println("\nThe distinct integers are:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}