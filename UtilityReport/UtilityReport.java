import java.util.Scanner;
import java.io.*;

public class UtilityReport {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        final String FILE_NAME = "dataA-7.txt";
        File fn = new File(FILE_NAME);
        Scanner inputFile = new Scanner(fn);

        PrintWriter reportFile = new PrintWriter("UtilityReport.txt");

        String address;
        double electric;
        double water;
        double average = 0.0;
        double totElectric = 0.0;
        double totWater = 0.0;

        int printSelection;
        String oStr;

        do {
            System.out.println("1) Display to Screen, 2) Send to File, 3) Both");
            printSelection = input.nextInt();
            if (printSelection < 1 || printSelection > 3)
                System.out.println("Invalid selection, re-enter");
        } while (printSelection < 1 || printSelection > 3);

        String fmtStrHdg = "%-15s   %-17s   %-14s    %-7s\n";
        String fmtStr = "%-17s           $  %6.2f          $  %,6.2f           $  %,6.2f\n";

        oStr = "Report version A by Sara Beberman\n\n";
        if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        oStr = String.format(fmtStrHdg, "Home", "Total Electric Bill", "Total Water Bill", "Average Expenses\n");
        if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        input.nextLine(); // flush the newline character

        while (inputFile.hasNext()) {
            address = inputFile.nextLine();
            if (address.equals("")) address = inputFile.nextLine();
            electric = inputFile.nextDouble();
            water = inputFile.nextDouble();
            if (inputFile.hasNextLine()) inputFile.nextLine(); // advance to next line

            totElectric += electric;
            totWater += water;
            average = (electric + water) / 2;

            oStr = String.format(fmtStr, address, electric, water, average);
            if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
            if (printSelection == 1 || printSelection == 3) System.out.print(oStr);
        }

        oStr = String.format(fmtStr, "Total", totElectric, totWater, (totElectric + totWater) / 2);
        if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        input.close();
        inputFile.close();
        reportFile.close();
    }
}