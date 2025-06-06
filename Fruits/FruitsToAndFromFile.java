import java.util.Scanner;
import java.io.*;

public class FruitsToAndFromFile {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        final String FILE_NAME = "fruitFile.txt";

        PrintWriter reportFile = new PrintWriter("fruitReport.txt");

        // reading from and writing to a file
        File fn = new File(FILE_NAME);
        Scanner inputFile = new Scanner(fn);

        String fruit;
        double price;
        int pounds;
        double totalCost = 0.0;
        int printSelection;

        System.out.println("1) Display to Screen, 2) Send to File, 3) Both");
        printSelection = input.nextInt();

        String fmtStrHdg = "%-12s      %8s     %6s      %6s\n";
        String fmtStr = "%-12s     $%8.2f     %6d     $%6.2f\n";
        String fmtStrTotal = "\n%-12s      %8s     %6s     $%6.2f\n";

        String oStr;

        oStr = String.format(fmtStrHdg, "Produce", "Price/lb", "Pounds", "Cost");
        if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        oStr = String.format(fmtStrHdg + "\n", "=======", "========", "======", "====");
        if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        for (int loopCount = 1; loopCount <= 5; loopCount++) {
            fruit = inputFile.nextLine();
            if (fruit.equals("")) fruit = inputFile.nextLine();
            price = inputFile.nextDouble();
            pounds = inputFile.nextInt();
            if (inputFile.hasNextLine()) inputFile.nextLine();

            oStr = String.format(fmtStr, fruit, price, pounds, price * pounds);
            if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
            if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

            totalCost += price * pounds;
        }

        oStr = String.format(fmtStrTotal, "Total", " ", " ", totalCost);
        if (printSelection == 2 || printSelection == 3) reportFile.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);

        reportFile.close();
        inputFile.close();
        input.close();
    }
}