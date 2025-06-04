import java.util.Scanner;
import java.io.*;

public class SalesReportingFromFile {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        final String FILE_NAME = "sales.txt";
        File fn = new File(FILE_NAME);
        Scanner inputFile = new Scanner(fn);

        String region;
        int units;
        double sales;

        int totUnits = 0;
        double totSales = 0.0;

        String fmtStrHdg = "%-15s   %-5s   %-14s     %-14s\n";
        String fmtStr = "%-15s   %-5d   $%,14.2f    $%,13.2f\n";

        System.out.printf(fmtStrHdg, "Region", "Units", "Sales", "Per Unit Sales");
        System.out.println("==============   =====   ==============     =============");

        while (inputFile.hasNext()) {
            region = inputFile.nextLine();
            if (region.equals("")) region = inputFile.nextLine();
            units = inputFile.nextInt();
            sales = inputFile.nextDouble();

            totUnits += units;
            totSales += sales;

            System.out.printf(fmtStr, region, units, sales, sales / units);
        }

        System.out.println();
        System.out.printf(fmtStr, "Total Sales", totUnits, totSales, totSales / totUnits);

        inputFile.close();
        input.close();
    }
}