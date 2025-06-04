import java.util.Scanner;
import java.io.*;

public class CarArrays {

    public static void main(String[] args) throws IOException {
        final String IN_FILENAME = "fuelrecord.txt";
        final String OUT_FILENAME = "autoMPGReport.txt";

        File fn = new File(IN_FILENAME);
        Scanner inputFile = new Scanner(fn);
        PrintWriter reportFile = new PrintWriter(OUT_FILENAME);
        Scanner keyboard = new Scanner(System.in);

        String[] carNames = new String[5];
        int[] milesDriven = new int[5];
        double[] galUsed = new double[5];
        double[] MPGCalculated = new double[5];

        fillArray(inputFile, carNames, milesDriven, galUsed);
        calculateMPG(milesDriven, galUsed, MPGCalculated);
        displayArrays(keyboard, reportFile, carNames, milesDriven, galUsed, MPGCalculated);

        inputFile.close();
        reportFile.close();
        keyboard.close();
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayArrays(Scanner keyboard, PrintWriter rpt, String[] cars, int[] miles, double[] gallons, double[] MPG) {
        int printSelection;
        do {
            System.out.println("1) Display to Screen, 2) Send to File, 3) Both");
            printSelection = keyboard.nextInt();
            if (printSelection < 1 || printSelection > 3)
                System.out.println("Invalid selection. Re-enter.");
        } while (printSelection < 1 || printSelection > 3);

        String header = String.format("%-10s  %6s  %6s  %6s\n", "Car", "Miles", "Gallons", "MPG");
        if (printSelection == 2 || printSelection == 3) rpt.print(header);
        if (printSelection == 1 || printSelection == 3) System.out.print(header);

        String fmtStr = "%-10s  %6d  %6.2f  %6.2f\n";
        for (int i = 0; i < cars.length; i++) {
            String line = String.format(fmtStr, cars[i], miles[i], gallons[i], MPG[i]);
            if (printSelection == 2 || printSelection == 3) rpt.print(line);
            if (printSelection == 1 || printSelection == 3) System.out.print(line);
        }

        printLine(printSelection, rpt, cars[findBestMPG(MPG)], "The car with the best MPG is %s\n");
        printLine(printSelection, rpt, cars[findWorstMPG(MPG)], "The car with the worst MPG is %s\n");
        printLine(printSelection, rpt, cars[shortestTrip(miles)], "The car with the shortest trip is %s\n");
        printLine(printSelection, rpt, cars[longestTrip(miles)], "The car with the longest trip is %s\n");
        printLine(printSelection, rpt, cars[mostFuel(gallons)], "The car which used the most fuel is %s\n");
        printLine(printSelection, rpt, cars[leastFuel(gallons)], "The car which used the least fuel is %s\n");
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    private static void printLine(int selection, PrintWriter rpt, String car, String format) {
        String line = String.format(format, car);
        if (selection == 2 || selection == 3) rpt.print(line);
        if (selection == 1 || selection == 3) System.out.print(line);
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner input, String[] cars, int[] miles, double[] gallons) {
        int i = 0;
        while (input.hasNext() && i < cars.length) {
            cars[i] = input.nextLine();
            if (cars[i].isEmpty()) cars[i] = input.nextLine();
            miles[i] = input.nextInt();
            gallons[i] = input.nextDouble();
            input.nextLine(); // clear newline
            i++;
        }
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void calculateMPG(int[] miles, double[] gallons, double[] MPG) {
        for (int i = 0; i < miles.length; i++)
            MPG[i] = miles[i] / gallons[i];
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int findBestMPG(double[] MPG) {
        int index = 0;
        for (int i = 1; i < MPG.length; i++)
            if (MPG[i] > MPG[index]) index = i;
        return index;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int findWorstMPG(double[] MPG) {
        int index = 0;
        for (int i = 1; i < MPG.length; i++)
            if (MPG[i] < MPG[index]) index = i;
        return index;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int shortestTrip(int[] miles) {
        int index = 0;
        for (int i = 1; i < miles.length; i++)
            if (miles[i] < miles[index]) index = i;
        return index;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int longestTrip(int[] miles) {
        int index = 0;
        for (int i = 1; i < miles.length; i++)
            if (miles[i] > miles[index]) index = i;
        return index;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int mostFuel(double[] gallons) {
        int index = 0;
        for (int i = 1; i < gallons.length; i++)
            if (gallons[i] > gallons[index]) index = i;
        return index;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int leastFuel(double[] gallons) {
        int index = 0;
        for (int i = 1; i < gallons.length; i++)
            if (gallons[i] < gallons[index]) index = i;
        return index;
    }
}