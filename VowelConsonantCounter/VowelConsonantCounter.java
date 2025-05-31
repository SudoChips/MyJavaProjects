import java.util.Scanner;

public class VowelConsonantCounter {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String word = input.nextLine();

    int numberOfVowels = 0;
    int numberOfConsonants = 0;

    for (int i = 0; i < word.length(); i++) {
      if (Character.isLetter(word.charAt(i))) {
        if (Character.toUpperCase(word.charAt(i)) == 'A' ||
            Character.toUpperCase(word.charAt(i)) == 'E' ||
            Character.toUpperCase(word.charAt(i)) == 'I' ||
            Character.toUpperCase(word.charAt(i)) == 'O' ||
            Character.toUpperCase(word.charAt(i)) == 'U') {
          numberOfVowels++;
        } else {
          numberOfConsonants++;
        }
      }
    }

    System.out.print("The number of vowels is " + numberOfVowels);
    System.out.println("\nThe number of consonants is " + numberOfConsonants);

    input.close(); // close scanner
  }
}

// Step 1: Declare and initialize variables numberOfVowels and numberOfConsonants with 0.
// Step 2: Prompt the user to enter a string using input.nextLine().
// Step 3: For each character in the string, do the following:
// Step 3.1: Convert the character to uppercase.
// Step 3.2: If the character is 'A', 'E', 'I', 'O', or 'U', increase numberOfVowels by 1.
// Step 3.3: else if the character is a letter, increase numberOfConsonants by 1.
// Step 4: Display the result using the wording as shown in the sample output