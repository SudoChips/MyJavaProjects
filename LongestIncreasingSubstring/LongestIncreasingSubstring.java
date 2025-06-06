import java.util.Scanner;

public class LongestIncreasingSubstring {

    public static void main(String[] args) {
		//"abcdefghibcdefjkmnstwxyzabcmnsxyyyyy ";//"abcabcdgabmnsxy";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.next();
        input.close();

        String max = "";
        String temp = "" + str.charAt(0); // start with first character

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) >= str.charAt(i - 1)) {
                temp += str.charAt(i); // keep building the current increasing substring
            } else {
                if (temp.length() > max.length()) {
                    max = temp;
                }
                temp = "" + str.charAt(i); // reset temp to current char
            }
        }

        // final check after loop ends
        if (temp.length() > max.length()) {
            max = temp;
        }

        System.out.println("The longest substring in increasing order is: " + max);
    }
}