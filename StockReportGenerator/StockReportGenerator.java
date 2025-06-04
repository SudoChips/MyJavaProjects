import java.util.Scanner;
import java.io.*;

public class StockReportGenerator {

    public static void main(String[] args) throws IOException {

        final String IN_FILENAME = "stocks.txt";
        final String OUT_FILENAME = "companyReport.txt";

        File fn = new File(IN_FILENAME);
        Scanner inputFile = new Scanner(fn);

        PrintWriter reportFile = new PrintWriter(OUT_FILENAME);

        Scanner keyboard = new Scanner(System.in);

        double[] closingPrice = new double[5];
        double[] prevClosingPrice = new double[5];
        double[] low = new double[5];
        double[] high = new double[5];
        String[] symbol = new String[5];
        String[] stockName = new String[5];
        double[] profit = new double[5];
        String[] lossOrGain = new String[5];

        fillArray(inputFile, closingPrice, prevClosingPrice, low, high, symbol, stockName, profit, lossOrGain);
        displayArrays(keyboard, reportFile, closingPrice, prevClosingPrice, low, high, symbol, stockName, profit, lossOrGain);

        inputFile.close();
        reportFile.close();
        keyboard.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner input, double[] closingPrice, double[] prevClosingPrice, double[] low, double[] high, String[] symbol, String[] stockName, double[] profit, String[] lossOrGain) {
        int indx = 0;

        while (input.hasNext()) {
            closingPrice[indx] = input.nextDouble();
            prevClosingPrice[indx] = input.nextDouble();
            low[indx] = input.nextDouble();
            high[indx] = input.nextDouble();
            symbol[indx] = input.nextLine();
            if (symbol[indx].equals("")) symbol[indx] = input.nextLine();
            stockName[indx] = input.nextLine();
            if (stockName[indx].equals("")) stockName[indx] = input.nextLine();
            profit[indx] = profitPer100(closingPrice[indx], prevClosingPrice[indx]);
            lossOrGain[indx] = loss(profit[indx]);

            indx++;
        }
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayArrays(Scanner keyboard, PrintWriter rpt, double[] closingPrice, double[] prevClosingPrice, double[] low, double[] high, String[] symbol, String[] stockName, double[] profit, String[] lossOrGain) {
        int printSelection;
        do {
            System.out.println("1) Display to Screen, 2) Send to File, 3) Both");
            printSelection = keyboard.nextInt();
            if (printSelection < 1 || printSelection > 3)
                System.out.println("invalid selection re-enter");
        } while (printSelection < 1 || printSelection > 3);

        String fmtStrHdg1 = "                            %-3s       %-4s                %-8s     %-6s";// top heading spaces
        String fmtStrHdg = "%-6s   %-15s    %-5s     %-7s   %-5s     %-5s        %-7s     %-10s\n";// heading spaces
        String fmtStr = "%-6s   %-17s  %-6.2f    %-6.2f    %-6.2f    %-6.2f       %5.2f       %4s\n";
        String oStr = "";

        oStr = ("                Stock Report" + '\n' + '\n');
        if (printSelection == 2 || printSelection == 3) rpt.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        oStr = String.format(fmtStrHdg1, "Low", "High", "Previous", "Profit" + '\n');
        if (printSelection == 2 || printSelection == 3) rpt.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        oStr = String.format(fmtStrHdg, "Symbol", "Company", "Price", "Price", "Close", "Close", "Per 100", "Gain/Loss" + '\n');
        if (printSelection == 2 || printSelection == 3) rpt.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        for (int indx = 0; indx < stockName.length; indx++) {
            oStr = String.format(fmtStr, symbol[indx], stockName[indx], low[indx], high[indx], closingPrice[indx], prevClosingPrice[indx], profit[indx], lossOrGain[indx]);
            if (printSelection == 2 || printSelection == 3) rpt.print(oStr);
            if (printSelection == 1 || printSelection == 3) System.out.print(oStr);
        }

        oStr = String.format("\nThe Stock with the greatest gain is: %s \n", stockName[greatestGain(profit)]);
        if (printSelection == 2 || printSelection == 3) rpt.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        oStr = String.format("\nThe Stock with the smallest gain is:  %s \n", stockName[leastGain(profit)]);
        if (printSelection == 2 || printSelection == 3) rpt.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static double profitPer100(double closingPrice, double prevClosingPrice) {
        double profit;
        profit = (closingPrice - prevClosingPrice);
        return profit;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static String loss(double profit) {
        String loss = "Loss";
        String gain = "Gain";
        if (profit < 0)
            return loss;
        else
            return gain;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int greatestGain(double[] profit) {
        int retIndx = 0;
        for (int indx = 0; indx < profit.length; indx++)
            if (profit[retIndx] < profit[indx]) retIndx = indx;
        return retIndx;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int leastGain(double[] profit) {
        int retIndx = 0;
        for (int indx = 0; indx < profit.length; indx++)
            if (profit[retIndx] > profit[indx]) retIndx = indx;
        return retIndx;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}