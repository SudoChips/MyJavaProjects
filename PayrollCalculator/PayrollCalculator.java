import java.util.Scanner;
import java.io.*;

public class PayrollCalculator {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        final String FILE_NAME = "payInformation.txt";
        PrintWriter reportFile = new PrintWriter("payrollReport.txt");
        File fn = new File(FILE_NAME);
        Scanner inputFile = new Scanner(fn);

        String oStr;
        String employeeName;
        int payRate;
        int hours;
        double rateOfPay;
        double weeksPay = 0;
        int printSelection;

        do {
            System.out.println("1) Display to Screen, 2) Send to File, 3) Both");
            printSelection = input.nextInt();
            if (printSelection < 1 || printSelection > 3)
                System.out.println("Invalid selection, re-enter.");
        } while (printSelection < 1 || printSelection > 3);

        String fmtStr = "%-20s %8s %6s %10s\n";
        oStr = String.format(fmtStr, "Name", "Pay Rate", "Hours", "Weeks Pay\n");

        if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        fmtStr = "%-20s $%8.2f %6d $%10.2f\n";

        while (inputFile.hasNext()) {
            employeeName = inputFile.nextLine();
            if (employeeName.equals("")) employeeName = inputFile.nextLine();
            payRate = inputFile.nextInt();
            hours = inputFile.nextInt();

            switch (payRate) {
                case 1: rateOfPay = 15.00; break;
                case 2: rateOfPay = 20.00; break;
                case 3: rateOfPay = 25.00; break;
                default: rateOfPay = 0.0; break;
            }

            if (hours > 40)
                weeksPay = (40 * rateOfPay) + ((hours - 40) * (rateOfPay * 1.5));
            else
                weeksPay = hours * rateOfPay;

            oStr = String.format(fmtStr, employeeName, rateOfPay, hours, weeksPay);

            if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
            if (printSelection == 1 || printSelection == 3) System.out.print(oStr);
        }

        if (printSelection == 2 || printSelection == 3) reportFile.println();
        if (printSelection == 1 || printSelection == 3) System.out.println();

        inputFile.close();
        reportFile.close();
		input.close();
    }
}