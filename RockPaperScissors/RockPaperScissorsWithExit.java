import java.util.Scanner;

public class RockPaperScissorsWithExit {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String sysChoice;
        String userChoice;

        do {
            sysChoice = generateChoice();
            userChoice = getUserChoice(kb);
            if (userChoice.equals("exit"))
                break;
            displayResult(userChoice, sysChoice);
        } while (!userChoice.equals("exit"));

        System.out.println("Goodbye");
        kb.close();
    }

    public static boolean win(String userSel, String systemSel) {
        return (userSel.equals("rock") && systemSel.equals("scissors")) ||
               (userSel.equals("paper") && systemSel.equals("rock")) ||
               (userSel.equals("scissors") && systemSel.equals("paper"));
    }

    public static void displayResult(String uChoice, String sChoice) {
        System.out.print("Your Choice: " + uChoice + " | Computer Choice: " + sChoice + " → ");
        if (uChoice.equals(sChoice)) {
            System.out.println("It's a tie!");
        } else if (win(uChoice, sChoice)) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!");
        }
    }

    public static String getUserChoice(Scanner kb) {
        int choice;
        String value = "";

        System.out.println("\nSelect by Number:");
        System.out.println("1 - Rock");
        System.out.println("2 - Paper");
        System.out.println("3 - Scissors");
        System.out.println("4 - Exit");

        do {
            System.out.print("Your choice: ");
            choice = kb.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid entry. Please choose 1–4.");
            }
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1: value = "rock"; break;
            case 2: value = "paper"; break;
            case 3: value = "scissors"; break;
            case 4: value = "exit"; break;
        }

        return value;
    }

    public static String generateChoice() {
        int choice = (int)(Math.random() * 3 + 1);
        switch (choice) {
            case 1: return "rock";
            case 2: return "paper";
            default: return "scissors";
        }
    }
}