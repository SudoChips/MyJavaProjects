import java.util.Scanner;

public class ReverseArrayMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of an array");
        int indx = input.nextInt();

        System.out.println("Enter the array values");
        int[] arrayTest = makearray(indx, input);

        reverse(arrayTest);
        displayArray(arrayTest);
		//String numbers = keyboard.nextLine().replaceAll("\\s","");// remove white spaces
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int[] makearray(int x, Scanner input) {
        int[] arr = new int[x];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        return arr;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayArray(int[] arrayTest) {
        for (int i = 0; i < arrayTest.length; i++) {
            System.out.println(arrayTest[i]); // print array
        }
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void reverse(int[] arr) {
        int start = 0, end = arr.length - 1;
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	/*
	public static boolean isReverse(int[] arr, int[] arr1) {
    	if (arr.length != arr1.length) return false;

    	for (int i = 0; i < arr.length; i++) {
        	if (arr[i] != arr1[arr1.length - i - 1]) {
            return false;
        	}
    	}

    	return true;
	}
	*/
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}