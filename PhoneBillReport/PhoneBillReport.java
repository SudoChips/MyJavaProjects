import java.util.Scanner;
import java.io.*;

public class PhoneBillReport {

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "phoneRecords.txt";
        final String OUTPUT_FILE = "recordsReport.txt";
        final int numberCount = 10;

        File fn = new File(INPUT_FILE);
        Scanner dataIn = new Scanner(fn);

        PrintWriter dataOut = new PrintWriter(OUTPUT_FILE);
        Scanner keyboard = new Scanner(System.in);

        String[] number = new String[numberCount];
        int[] seconds = new int[numberCount];
        int[] callType = new int[numberCount];

        fillArray(dataIn, number, seconds, callType);

        int printSelection = getPrintSelection(keyboard);

        displayArrays(dataOut, printSelection, number, seconds, callType);

        dataIn.close();
        dataOut.close();
        keyboard.close();
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner inFile, String[] number, int[] seconds, int[] callType) {
        int indx = 0;

        while (inFile.hasNext()) {
            number[indx] = inFile.nextLine();
            if (number[indx].equals("")) number[indx] = inFile.nextLine();
            seconds[indx] = inFile.nextInt();
            callType[indx] = inFile.nextInt();
            indx++;
        }
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayArrays(PrintWriter rpt, int printSelection, String[] number, int[] seconds, int[] callType) {
        String strHdg = "%-10s %7s %7s   %4s   %10s\n";
        writeToFile(rpt, printSelection, String.format(strHdg, "Number", "Minutes", "Seconds", "Cost", "Call Type"));

        String fmtStr = "%-10s  %-4d  %-4d   %-5.2f  %-10s\n";
        for (int indx = 0; indx < number.length; indx++) {
            writeToFile(rpt, printSelection, String.format(fmtStr,
                    number[indx],
                    getMinutes(seconds[indx]),
                    getSeconds(seconds[indx]),
                    getCostPerMinute(seconds[indx], callType[indx]),
                    getCallType(callType[indx])
            ));
        }

        writeToFile(rpt, printSelection, String.format("\nThe longest call is %s seconds\n", seconds[longestCall(seconds)]));
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int getPrintSelection(Scanner keyboard) {
        int printSelection = 0;
        do {
            System.out.println("1) Display to Screen, 2) Send to File, 3) Both");
            printSelection = keyboard.nextInt();
            if (printSelection < 1 || printSelection > 3)
                System.out.println("invalid selection re-enter");
        } while (printSelection < 1 || printSelection > 3);

        return printSelection;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void writeToFile(PrintWriter rpt, int printSelection, String oStr) {
        if (printSelection == 2 || printSelection == 3) rpt.print(oStr);
        if (printSelection == 1 || printSelection == 3) System.out.print(oStr);
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int getMinutes(int seconds) {
        return seconds / 60;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int getSeconds(int seconds) {
        return seconds % 60;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static String getCallType(int callType) {
        String result = "";
        switch (callType) {
            case 1: result = "interstate"; break;
            case 2: result = "intrastate"; break;
            case 3: result = "interLATA"; break;
            case 4: result = "intraLATA"; break;
            case 5: result = "Local"; break;
            default: result = "Error"; // not found
        }
        return result;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static double getCostPerMinute(int seconds, int callType) {
        int minutes = seconds / 60;
        if ((seconds % 60) > 6)
            minutes++;

        double result = 0.0;

        switch (callType) {
            case 1: result = minutes * 0.04; break;
            case 2: result = minutes * 0.03; break;
            case 3: result = minutes * 0.035; break;
            case 4: result = minutes * 0.015; break;
            case 5: result = minutes * 0.01; break;
            default: result = 0.0; // not found
        }

        return result;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int longestCall(int[] seconds) {
        int retIndx = 0;
        for (int indx = 0; indx < seconds.length; indx++)
            if (seconds[retIndx] < seconds[indx])
                retIndx = indx;

        return retIndx;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}