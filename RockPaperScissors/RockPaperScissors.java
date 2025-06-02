import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String systemChoice;
        String userChoice;

        systemChoice = generateChoice();
        userChoice = getUserChoice(keyboard);

        displayResult(userChoice, systemChoice);

        keyboard.close();
    }

    public static void displayResult(String uChoice, String sChoice) {
        System.out.print("Your Choice: " + uChoice + " Computer Choice: " + sChoice + " ");
        if (uChoice.equals(sChoice)) {
            System.out.println("You Tie");
        } else if (win(uChoice, sChoice)) {
            System.out.println("You Won");
        } else {
            System.out.println("You Lose");
        }
    }

    public static String getUserChoice(Scanner kbd) {
        String retValue = "";
        int choice = 0;

        System.out.println("\n\nSelect by Number");
        System.out.println("1 - Rock");
        System.out.println("2 - Paper");
        System.out.println("3 - Scissor\n");

        do {
            choice = kbd.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid entry");
            }
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1: retValue = "rock"; break;
            case 2: retValue = "paper"; break;
            case 3: retValue = "scissor"; break;
        }

        return retValue;
    }

    public static String generateChoice() {
        int choice = (int) (Math.random() * 3 + 1);
        String retValue = "";

        switch (choice) {
            case 1: retValue = "rock"; break;
            case 2: retValue = "paper"; break;
            case 3: retValue = "scissor"; break;
        }

        return retValue;
    }

    public static boolean win(String userSelection, String systemSelection) {
        boolean retResult = true;

        if (userSelection.equals("rock") && (systemSelection.equals("paper") || systemSelection.equals("rock")))
            retResult = false;
        else if (userSelection.equals("paper") && (systemSelection.equals("scissor") || systemSelection.equals("paper")))
            retResult = false;
        else if (userSelection.equals("scissor") && (systemSelection.equals("rock") || systemSelection.equals("scissor")))
            retResult = false;

        return retResult;
    }
}