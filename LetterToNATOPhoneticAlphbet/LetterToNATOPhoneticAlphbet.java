import java.util.Scanner;

public class LetterToNATOPhoneticAlphbet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char c = ' '; // initialize with a default value

        do {
            System.out.print("Enter a letter to translate or 1 to exit: ");
            String choice = input.nextLine();

            if (choice.length() != 1) {
                System.out.println("Invalid input, try again.");
                continue;
            }

            c = Character.toLowerCase(choice.charAt(0));

            switch (c) {
                case 'a': System.out.println("Alpha"); break;
                case 'b': System.out.println("Bravo"); break;
                case 'c': System.out.println("Charlie"); break;
                case 'd': System.out.println("Delta"); break;
                case 'e': System.out.println("Echo"); break;
                case 'f': System.out.println("Foxtrot"); break;
                case 'g': System.out.println("Golf"); break;
                case 'h': System.out.println("Hotel"); break;
                case 'i': System.out.println("India"); break;
                case 'j': System.out.println("Juliet"); break;
                case 'k': System.out.println("Kilo"); break;
                case 'l': System.out.println("Lima"); break;
                case 'm': System.out.println("Mike"); break;
                case 'n': System.out.println("November"); break;
                case 'o': System.out.println("Oscar"); break;
                case 'p': System.out.println("Papa"); break;
                case 'q': System.out.println("Quebec"); break;
                case 'r': System.out.println("Romeo"); break;
                case 's': System.out.println("Sierra"); break;
                case 't': System.out.println("Tango"); break;
                case 'u': System.out.println("Uniform"); break;
                case 'v': System.out.println("Victor"); break;
                case 'w': System.out.println("Whiskey"); break;
                case 'x': System.out.println("X-ray"); break;
                case 'y': System.out.println("Yankee"); break;
                case 'z': System.out.println("Zulu"); break;
                case '1': System.out.println("Thank you for using my phonetic translator, Good-bye."); break;
                default: System.out.println("Invalid input, try again."); break;
            }

        } while (c != '1');

        input.close();
    }
}