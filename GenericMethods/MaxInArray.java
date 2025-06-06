public class MaxInArray {

    public static void main(String[] args) {
        Integer[] arr = new Integer[5];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.print("The largest number in the array is: " + max(arr));
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