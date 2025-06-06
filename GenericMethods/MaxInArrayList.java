import java.util.ArrayList;

public class MaxInArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(9);
        arr.add(6);
        arr.add(2);
        arr.add(2);
        arr.add(6);
        arr.add(8);
        arr.add(25);

        System.out.print("The largest number in the array is: " + max(arr));
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }
}