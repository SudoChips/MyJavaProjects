import java.util.Scanner;

public class DriversLicense {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        char[] answerKey = {
            'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D',
            'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'
        };

        char[] responses = new char[20];
        int[] questionsMissed = new int[20];

        for (int indx = 0; indx < responses.length; indx++)
            responses[indx] = getAnswer(keyboard, indx + 1);

        System.out.println("You got " + totalCorrect(answerKey, responses, questionsMissed) + " right");

        if (passed(answerKey, responses, questionsMissed))
            System.out.println("You passed the test");
        else
            System.out.println("You failed the test");

        displayMissedQuestions(questionsMissed, responses, answerKey);
        keyboard.close();
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static char getAnswer(Scanner keyboard, int questionNumber) {
        char retValue;
        boolean valid;

        System.out.print("Answer Question " + questionNumber + " ");

        do {
            retValue = keyboard.nextLine().toUpperCase().charAt(0);
            valid = retValue == 'A' || retValue == 'B' || retValue == 'C' || retValue == 'D';
            if (!valid) System.out.println("Entry must be A, B, C, or D");
        } while (!valid);

        return retValue;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayMissedQuestions(int[] questionsMissed, char[] responses, char[] answers) {
        System.out.printf("%8s   %6s   %6s\n", "Question", "Your", "Correct");
        System.out.printf("%8s   %6s   %6s\n", " ", "Answer", "Answer");

        for (int indx = 0; indx < questionsMissed.length; indx++) {
            if (questionsMissed[indx] != 0) {
                int qIndex = questionsMissed[indx] - 1;
                System.out.printf("%-8d   %-6s   %-6s\n", questionsMissed[indx], responses[qIndex], answers[qIndex]);
            }
        }
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int totalCorrect(char[] answers, char[] responses, int[] questionsMissed) {
        int correct = 0;
        int i = 0;

        for (int indx = 0; indx < answers.length; indx++) {
            if (answers[indx] == responses[indx]) {
                correct++;
            } else {
                questionsMissed[i] = indx + 1;
                i++;
            }
        }
        return correct;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static boolean passed(char[] answers, char[] responses, int[] questionsMissed) {
        double correct = totalCorrect(answers, responses, questionsMissed);
        return (correct / answers.length) >= 0.7;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
} 