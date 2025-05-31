import java.util.Scanner;

public class VowelChecker {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a letter: ");
    String letter = input.nextLine();

    if (letter.length() != 1) {
      System.out.println(letter + " is an invalid input");
      input.close(); // close scanner
      return;
    }

    char ch = letter.toUpperCase().charAt(0);

    if (!Character.isLetter(ch)) {
      System.out.println(letter + " is an invalid input");
    } else {
      switch (ch) {
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
          System.out.println(letter + " is a vowel");
          break;
        default:
          System.out.println(letter + " is not a vowel");
      }
    }

    input.close(); // close scanner
  }
}

/*
Step 1: Prompt the user to enter a string into s using input.nextLine().
Step 2: if (s.length() != 1), display an error message as shown in the sample output.
Step 3: Get the first character from the string into ch.
Step 4: Convert ch into uppercase letter.
Step 5: if ch is not a letter, display an error message as shown in the sample output.
Step 6: else if ch is a vowel, display an appropriate message.
Step 7: else display an appropriate message for ch is a consonant.
*/