import java.util.Scanner;

public class PhoneNumberMapping {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a phone number: ");
        String number = input.nextLine();

        for (int i = 0; i < number.length(); i++) {
            if (Character.isLetter(number.charAt(i))) {
                System.out.print(getNumber(Character.toUpperCase(number.charAt(i))));
            } else {
                System.out.print(number.charAt(i));
            }

            // char c = Character.toUpperCase(number.charAt(i));
            /*
            if (number.charAt(i) == 'A' || number.charAt(i) == 'B' || number.charAt(i) == 'C') {
                // replace with 2
            }

            if (number.charAt(i) == 'D' || number.charAt(i) == 'E' || number.charAt(i) == 'F') {
                // replace with 3
            }

            if (number.charAt(i) == 'G' || number.charAt(i) == 'H' || number.charAt(i) == 'I') {
                // replace with 4
            }

            if (number.charAt(i) == 'J' || number.charAt(i) == 'K' || number.charAt(i) == 'L') {
                // replace with 5
            }

            if (number.charAt(i) == 'M' || number.charAt(i) == 'N' || number.charAt(i) == 'O') {
                // replace with 6
            }

            if (number.charAt(i) == 'P' || number.charAt(i) == 'Q' || number.charAt(i) == 'R' || number.charAt(i) == 'S') {
                // replace with 7
            }

            if (number.charAt(i) == 'T' || number.charAt(i) == 'U' || number.charAt(i) == 'V') {
                // replace with 8
            }

            if (number.charAt(i) == 'W' || number.charAt(i) == 'X' || number.charAt(i) == 'Y' || number.charAt(i) == 'Z') {
                // replace with 9
            }
            */
        }

        input.close();
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int getNumber(char uppercaseLetter) {
        int letter = 0;

        switch (uppercaseLetter) {
            case 'A': case 'B': case 'C': letter = 2; break;
            case 'D': case 'E': case 'F': letter = 3; break;
            case 'G': case 'H': case 'I': letter = 4; break;
            case 'J': case 'K': case 'L': letter = 5; break;
            case 'M': case 'N': case 'O': letter = 6; break;
            case 'P': case 'Q': case 'R': case 'S': letter = 7; break;
            case 'T': case 'U': case 'V': letter = 8; break;
            case 'W': case 'X': case 'Y': case 'Z': letter = 9; break;
        }

        return letter;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}