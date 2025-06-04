import java.util.Scanner;
import java.io.*;

public class DriverAndMpgReportManager {

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "mpg.txt";
        final String OUTPUT_FILE = "mpgReport.txt";
        final int driverCount = 10;

        File fn = new File(INPUT_FILE);
        Scanner dataIn = new Scanner(fn);
        PrintWriter dataOut = new PrintWriter(OUTPUT_FILE);
        Scanner keyboard = new Scanner(System.in);

        Mpg1[] Mpg = new Mpg1[driverCount];

        int printSelection = getPrintSelection(keyboard);
        int menuSelection = displayMenu(keyboard);

        fillArray(dataIn, Mpg);
        displayMenuSelection(dataOut, printSelection, keyboard, menuSelection, Mpg);

        dataIn.close();
        keyboard.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner dataFile, Mpg1[] Mpg) {
        int indx = 0;

        while (dataFile.hasNext()) {
            Mpg[indx] = new Mpg1();
            Mpg[indx].name(dataFile.nextLine());
            Mpg[indx].miles(dataFile.nextInt());
            Mpg[indx].gallons(dataFile.nextInt());
            if (dataFile.hasNext()) dataFile.nextLine();
            indx++;
        }
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayMpg(PrintWriter rpt, int printSelection, Mpg1 Mpg) {
        String fmtStr = "%-16s   %4d        %3d       %-5d\n";
        writeToFile(rpt, printSelection, String.format(fmtStr, Mpg.name(), Mpg.miles(), Mpg.gallons(), Mpg.mpg()));
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayHeader(PrintWriter rpt, int printSelection) {
        String strHdg = "%-10s         %-10s %-10s %-10s \n";
        String strHdg1 = "%-10s         %-10s %-10s %-10s \n";

        writeToFile(rpt, printSelection, String.format(strHdg, "Name", "Miles", "Gallons", "MPG"));
        writeToFile(rpt, printSelection, String.format(strHdg1, "====", "=====", "=======", "==="));
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void writeReport(PrintWriter rpt, int printSelection, Mpg1[] MpgArray) {
        displayHeader(rpt, printSelection);
        for (int indx = 0; indx < MpgArray.length; indx++)
            displayMpg(rpt, printSelection, MpgArray[indx]);
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
    public static int displayMenu(Scanner keyboard) {
        int menuSelection = 0;
        do {
            System.out.println("1) Display report, 2) Sort report by mpg, 3) Sort report by name, 4) Search report by mpg, 5) Search report by name, 6) Exit");
            menuSelection = keyboard.nextInt();
            if (menuSelection < 1 || menuSelection > 6)
                System.out.println("invalid selection re-enter");
        } while (menuSelection < 1 || menuSelection > 6);

        return menuSelection;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayMenuSelection(PrintWriter dataOut, int printSelection, Scanner keyboard, int menuSelection, Mpg1[] Mpg) {
        while (menuSelection != 6) {
            if (menuSelection == 1) {
                writeReport(dataOut, printSelection, Mpg);
                System.out.println("");
            } else if (menuSelection == 2) {
                sortArrayByMpg(Mpg);
                writeReport(dataOut, printSelection, Mpg);
                System.out.println("");
            } else if (menuSelection == 3) {
                sortArrayByName(Mpg);
                writeReport(dataOut, printSelection, Mpg);
                System.out.println("");
            } else if (menuSelection == 4) {
                infoByMpg(dataOut, printSelection, keyboard, Mpg);
                System.out.println("");
            } else if (menuSelection == 5) {
                infoByName(dataOut, printSelection, keyboard, Mpg);
                System.out.println("");
            }

            menuSelection = displayMenu(keyboard);
        }
        dataOut.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int findByName(Mpg1[] searchArray, String searchName) {
        int retValue = -1;

        for (int indx = 0; indx < searchArray.length; indx++)
            if (searchArray[indx].name().equalsIgnoreCase(searchName)) {
                retValue = indx;
                break;
            }

        return retValue;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void infoByName(PrintWriter rpt, int printSelection, Scanner keyboard, Mpg1[] array) {
        String searchName = "";

        do {
            System.out.print("Enter a driver's name to search for: ");
            searchName = keyboard.nextLine();
            if (searchName.equals("")) searchName = keyboard.nextLine();
        } while (searchName.equals(""));

        int indxReturned = findByName(array, searchName);
        if (indxReturned != -1)
            displayMpg(rpt, printSelection, array[indxReturned]);
        else
            System.out.println("Driver name is not on file");
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int findByMpg(int numberSearch, Mpg1[] searchArray) {
        int retIndx = -1;

        for (int indx = 0; indx < searchArray.length; indx++)
            if (searchArray[indx].mpg() == numberSearch) {
                retIndx = indx;
                break;
            }

        return retIndx;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void infoByMpg(PrintWriter rpt, int printSelection, Scanner keyboard, Mpg1[] array) {
        int searchNumber = 0;

        do {
            System.out.print("Enter a mpg to search for: ");
            searchNumber = keyboard.nextInt();
        } while (searchNumber <= 0);

        keyboard.nextLine(); // absorb the extra carriage return

        int indxReturned1 = findByMpg(searchNumber, array);
        if (indxReturned1 != -1)
            displayMpg(rpt, printSelection, array[indxReturned1]);
        else
            System.out.println("mpg number is not on file");
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void sortArrayByName(Mpg1[] Mpg) {
        Mpg1 tempMpg;

        for (int i = 0; i < Mpg.length - 1; i++) {
            for (int j = i + 1; j < Mpg.length; j++) {
                if (Mpg[i].name().compareTo(Mpg[j].name()) > 0) {
                    tempMpg = Mpg[i];
                    Mpg[i] = Mpg[j];
                    Mpg[j] = tempMpg;
                }
            }
        }
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void sortArrayByMpg(Mpg1[] Mpg) {
        Mpg1 tempMpg;

        for (int i = 0; i < Mpg.length - 1; i++) {
            for (int j = i + 1; j < Mpg.length; j++) {
                if (Mpg[i].mpg() > Mpg[j].mpg()) {
                    tempMpg = Mpg[i];
                    Mpg[i] = Mpg[j];
                    Mpg[j] = tempMpg;
                }
            }
        }
    }
}