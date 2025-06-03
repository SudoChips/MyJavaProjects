import java.util.Scanner;
import java.io.*;

public class StockReport {

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "stock.txt";
        final int stockCount = 5;

        File fn = new File(INPUT_FILE);
        Scanner dataIn = new Scanner(fn);

        Scanner keyboard = new Scanner(System.in);

        Stock[] report = new Stock[stockCount];

        fillArray(dataIn, report);
        writeReport(report);

        dataIn.close();
        keyboard.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner dataFile, Stock[] report) {
        int indx = 0;

        while (dataFile.hasNext()) {
            report[indx] = new Stock();
            report[indx].symbol(dataFile.nextLine());
            report[indx].company(dataFile.nextLine());
            report[indx].previousClose(dataFile.nextDouble());
            report[indx].currentClose(dataFile.nextDouble());
            report[indx].PercentChange(dataFile.nextDouble());
            if (dataFile.hasNext()) dataFile.nextLine();
            indx++;
        }
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayStock(Stock report) {
        System.out.printf("%-4s    %-35s  $ %5.2f   $ %5.2f    $ %5.2f\n",
                report.symbol(),
                report.company(),
                report.previousClose(),
                report.currentClose(),
                report.PercentChange());
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayHeader() {
        System.out.printf("%-5s   %-35s    %-8s   %-8s  %-10s\n", "", "", "Previous", "Current", "Percent");
        System.out.printf("%-5s   %-35s    %-5s      %-5s    %-10s\n", "Symbol", "Company", "Close", "Price", "Change");
        System.out.printf("%-5s   %-35s    %-5s      %-5s    %-10s\n", "======", "=======", "=====", "=====", "======");
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void writeReport(Stock[] stockArray) {
        displayHeader();
        for (int indx = 0; indx < stockArray.length; indx++)
            displayStock(stockArray[indx]);
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

}