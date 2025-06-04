import java.util.Scanner;
import java.io.*;

public class MonthlyInterestCalculator {

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "amount.txt";

        File fn = new File(INPUT_FILE);
        Scanner dataIn = new Scanner(fn);

        Scanner keyboard = new Scanner(System.in);

        double[] amount = new double[9];

        Account accounts = new Account(1122, 20000);
        accounts.annualInterestRate(4.5);

        fillArray(dataIn, amount, accounts);

        display(accounts);

        dataIn.close();
        keyboard.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner inFile, double[] amount, Account accounts) {

        int indx = 0;
        double withdraw = 0.0;
        double deposit = 0.0;

        while (inFile.hasNext()) {
            amount[indx] = inFile.nextDouble();
            if (amount[indx] < 0)
                withdraw += amount[indx];
            else
                deposit += amount[indx];
            indx++;
        }

        accounts.withdraw(withdraw);
        accounts.deposit(deposit);
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void display(Account accounts) {

        double monthlyInterest = accounts.getMonthlyInterest();

        System.out.printf("%-8s   %-10s             %-10s\n", "", "Monthly", "Date");
        System.out.printf("%-8s %10s           %10s\n", "Balance", "Interest", "Created");
        System.out.printf("%-8s %10s           %10s\n", "=======", "========", "=======");

        System.out.printf("%8.2f    %5.2f    %10s\n",
                accounts.total(monthlyInterest),
                monthlyInterest,
                accounts.getDateCreated());
    }
}