import java.util.Scanner;
import java.io.*;

public class SalesReportingFromFileToFile {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        final String FILE_NAME = "sales.txt";
        File fn = new File(FILE_NAME);
        Scanner inputFile = new Scanner(fn);

        PrintWriter reportFile = new PrintWriter("SalesReport.txt");

        String region;
        int units;
        double sales;

        int totUnits = 0;
        double totSales = 0.0;
        int printSelection;
        String oStr;

        do {
            System.out.println("1) Display to Screen, 2) Send to File, 3) Both");
            printSelection = input.nextInt();
            if (printSelection < 1 || printSelection > 3)
                System.out.println("Invalid selection, re-enter");
        } while (printSelection < 1 || printSelection > 3);

        String fmtStrHdg = "%-15s   %-5s   %-14s     %-14s\n";
        String fmtStr = "%-15s   %-5d   $%,14.2f    $%,13.2f\n";

        oStr = String.format(fmtStrHdg, "Region", "Units", "Sales", "Per Unit Sales");
        if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        oStr = "===============   =====   ===============     ==============\n";
        if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        while (inputFile.hasNext()) {
            region = inputFile.nextLine();
            if (region.equals("")) region = inputFile.nextLine();
            units = inputFile.nextInt();
            sales = inputFile.nextDouble();

            totUnits += units;
            totSales += sales;

            oStr = String.format(fmtStr, region, units, sales, sales / units);
            if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
            if (printSelection == 1 || printSelection == 3) System.out.print(oStr);
        }

        oStr = String.format("\n" + fmtStr, "Total Sales", totUnits, totSales, totSales / totUnits);
        if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        inputFile.close();
        reportFile.close();
        input.close();
    }
}