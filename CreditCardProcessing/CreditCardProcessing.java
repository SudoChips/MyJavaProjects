import java.util.Scanner;

public class CreditCardProcessing {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long number = 0;

        do {
            System.out.print("Enter a credit card number between 13 & 16 digits: ");
            number = input.nextLong();
            System.out.println(number + " was entered");
        } while (!isValid(number));

        input.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int getSize(long d) {
        String str = d + "";
        int temp = str.length();
        return temp;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static long getPrefix(long number, int k) {
        String str1 = number + "";
        long temp = 0;
        String temp1 = "";
        for (int i = 0; i < k; i++) {
            temp1 += Character.toString(str1.charAt(i));
        }
        System.out.println("Running getPrefix");
        temp = Integer.parseInt(temp1);
        return temp;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static boolean prefixMatched(long number, int d) {
        String str2 = number + "";
        boolean temp;
        if (str2.charAt(0) == '3' && str2.charAt(1) == '7')
            temp = true;
        else if (str2.charAt(0) == '4' || str2.charAt(0) == '5' || str2.charAt(0) == '6')
            temp = true;
        else
            temp = false;

        System.out.println("Running prefixMatched: " + temp);
        return temp;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int getDigit(int number) {
        System.out.println("Running getDigit");
        String str3 = number + "";
        int sum = 0;
        String num1 = str3.charAt(0) + "";
        String num2 = str3.charAt(1) + "";

        sum = Integer.parseInt(num1) + Integer.parseInt(num2);
        return sum;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int sumOfDoubleEvenPlace(long number) {
        String str4 = number + "";
        int sum = 0;
        int num = 0;
        for (int i = str4.length() - 2; i >= 0; i -= 2) {
            num = Integer.parseInt(str4.charAt(i) + "") * 2;
            if (num > 9)
                sum += getDigit(num);
            else
                sum += num;
        }
        System.out.println("Running sumofDoubleEvenPlace, the total is: " + sum);
        return sum;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int sumOfOddPlace(long number) {
        String str5 = number + "";
        int sum1 = 0;
        for (int i = str5.length() - 1; i >= 0; i -= 2) {
            sum1 += Integer.parseInt(str5.charAt(i) + "");
        }
        System.out.println("Running sumofOddPlace, the total is: " + sum1);
        return sum1;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static boolean isValid(long number) {
        int k = 2;
        boolean validCheck = false;
        int size = getSize(number);

        if (size < 13 || size > 16) {
            System.out.print("Number is invalid");
            return validCheck;
        } else {
            System.out.print("Is a valid length\n");
        }

        long preFix = getPrefix(number, k);
        boolean prefixCheck = prefixMatched(number, (int) preFix);
        int sumCheckIO = (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10;

        if (prefixCheck)
            if (sumCheckIO == 0)
                validCheck = true;

        System.out.print("Running valid check: " + validCheck + '\n');
        return validCheck;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}
 /*take in dummy number that would be valid
//get size check  	public static int getSize(long d) between 13 & 16 && 4388576018402626L
read prefix 	 public static long getPrefix(long number, int k) first digit except 37 then 2 digits
prefix valid check 		public static boolean prefixMatched(long number, int d) changes /\ to true or false
add the even spots 		public static int getDigit(int number)  if 2 digit then ->  public static int sumOfDoubleEvenPlace(long number)
manipulate the > than 9 numbers for even spots if ten or above break apart
add the odd spots  		public static int sumOfOddPlace(long number)
add both sums together and divide by 10 to determine validity % 10 = 0 valid in the main
put inside isvalid and call to main 	public static boolean isValid(long number)
*/