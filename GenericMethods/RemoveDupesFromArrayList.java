import java.util.ArrayList;

public class RemoveDupesFromArrayList {

    public static void main(String[] args) {
        // Create and populate an ArrayList of integers
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(1);
        numbers.add(6);
        numbers.add(2);
        numbers.add(2);
        numbers.add(6);
        numbers.add(8);
        numbers.add(8);

        System.out.println(removeDuplicates(numbers));

        // Create and populate an ArrayList of strings
        ArrayList<String> words = new ArrayList<String>();
        words.add("Hello");
        words.add("Hi");
        words.add("Bye");
        words.add("Good-Bye");
        words.add("Hi");
        words.add("Hello");

        System.out.println(removeDuplicates(words));
    }

    // Generic method to remove duplicates from a list
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> list2 = new ArrayList<>();
        for (int indx = 0; indx < list.size(); indx++) {
            if (!list2.contains(list.get(indx))) {
                list2.add(list.get(indx));
            }
        }
        return list2;
    }

}