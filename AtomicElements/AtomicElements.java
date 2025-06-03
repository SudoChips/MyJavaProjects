import java.util.Scanner;
import java.io.*;

public class AtomicElements {

    public static void main(String[] args) throws IOException {

        final String IN_FILENAME = "elements.txt";
        final String OUT_FILENAME = "elementsReport.txt";
        final int ELEMENT_COUNT = 9;

        File fn = new File(IN_FILENAME);
        Scanner inputFile = new Scanner(fn);
        PrintWriter reportFile = new PrintWriter(OUT_FILENAME);
        Scanner keyboard = new Scanner(System.in);

        String[] name = new String[ELEMENT_COUNT];
        String[] symbol = new String[ELEMENT_COUNT];
        int[] atomicNo = new int[ELEMENT_COUNT];
        int[] atomicMass = new int[ELEMENT_COUNT];

        int printSelection = getPrintSelection(keyboard);

        fillArray(inputFile, symbol, name, atomicNo, atomicMass);
        sort(symbol, name, atomicNo, atomicMass);
        displayArrays(reportFile, printSelection, symbol, name, atomicNo, atomicMass);

        System.out.print("\n\n\n\n\n");

        infoByAtomicSymbol(reportFile, printSelection, keyboard, symbol, name, atomicNo, atomicMass);
        infoByAtomicNo(reportFile, printSelection, keyboard, symbol, name, atomicNo, atomicMass);

        inputFile.close();
        reportFile.close();
        keyboard.close();
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner inFile, String[] symbol, String[] name, int[] atomicNo, int[] atomicMass) {
        int indx = 0;

        while (inFile.hasNext()) {
            symbol[indx] = inFile.nextLine();
            if (symbol[indx].equals("")) symbol[indx] = inFile.nextLine();
            name[indx] = inFile.nextLine();
            if (name[indx].equals("")) name[indx] = inFile.nextLine();
            atomicNo[indx] = inFile.nextInt();
            atomicMass[indx] = inFile.nextInt();
            indx++;
        }
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayArrays(PrintWriter rpt, int printSelection, String[] symbol, String[] name, int[] atomicNo, int[] atomicMass) {
        String strHdg = "                 %-6s  %6s\n";
        String strHdg1 = "%-4s      %6s %6s   %4s\n";

        writeToFile(rpt, printSelection, String.format(strHdg, "Atomic", "Atomic"));
        writeToFile(rpt, printSelection, String.format(strHdg1, "Name", "Symbol", "Number", "Mass"));

        String fmtStr = "%-10s  %-2s     %-2d      %-3d\n";
        for (int indx = 0; indx < symbol.length; indx++) {
            writeToFile(rpt, printSelection, String.format(fmtStr, name[indx], symbol[indx], atomicNo[indx], atomicMass[indx]));
        }
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int getPrintSelection(Scanner keyboard) {
        int printSelection;
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
    public static int findAtomicNo(int numberSearch, int[] atomicNo) {
        int retIndx = -1;
        for (int indx = 0; indx < atomicNo.length; indx++) {
            if (atomicNo[indx] == numberSearch) {
                retIndx = indx;
                break;
            }
        }
        return retIndx;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void infoByAtomicNo(PrintWriter rpt, int printSelection, Scanner keyboard, String[] symbol, String[] name, int[] atomicNo, int[] atomicMass) {
        int searchNumber;
        do {
            System.out.print("Enter an Atomic number to search for: ");
            searchNumber = keyboard.nextInt();
        } while (searchNumber <= 0);
        keyboard.nextLine(); // absorb the extra carriage return

        int indxReturned = findAtomicNo(searchNumber, atomicNo);
        if (indxReturned != -1)
            displayAtomicInformation(rpt, printSelection, indxReturned, symbol, name, atomicNo, atomicMass);
        else
            System.out.println("Atomic number is not on file");
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int findSymbol(String symbolSearch, String[] symbol) {
        int retIndx = -1;
        for (int indx = 0; indx < symbol.length; indx++) {
            if (symbol[indx].equalsIgnoreCase(symbolSearch)) {
                retIndx = indx;
                break;
            }
        }
        return retIndx;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void infoByAtomicSymbol(PrintWriter rpt, int printSelection, Scanner keyboard, String[] symbol, String[] name, int[] atomicNo, int[] atomicMass) {
        String searchSymbol;
        do {
            System.out.print("Enter an Atomic symbol to search for: ");
            searchSymbol = keyboard.nextLine();
        } while (searchSymbol.equals(""));

        int indxReturned = findSymbol(searchSymbol, symbol);
        if (indxReturned != -1)
            displayAtomicInformation(rpt, printSelection, indxReturned, symbol, name, atomicNo, atomicMass);
        else
            System.out.println("Atomic symbol is not on file");
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayAtomicInformation(PrintWriter rpt, int printSelection, int indx, String[] symbol, String[] name, int[] atomicNo, int[] atomicMass) {
        String fmtStr = "%-3s  %-10s  %-2d  %-3d\n";
        writeToFile(rpt, printSelection, String.format(fmtStr, symbol[indx], name[indx], atomicNo[indx], atomicMass[indx]));
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void sort(String[] symbol, String[] name, int[] atomicNo, int[] atomicMass) {
        String tempStr, tempStr1;
        int tempInt, tempInt1;

        for (int i = 0; i < symbol.length - 1; i++) {
            for (int j = i + 1; j < symbol.length; j++) {
                if (atomicMass[i] < atomicMass[j]) {

                    tempStr = symbol[i];
                    symbol[i] = symbol[j];
                    symbol[j] = tempStr;

                    tempStr1 = name[i];
                    name[i] = name[j];
                    name[j] = tempStr1;

                    tempInt = atomicNo[i];
                    atomicNo[i] = atomicNo[j];
                    atomicNo[j] = tempInt;

                    tempInt1 = atomicMass[i];
                    atomicMass[i] = atomicMass[j];
                    atomicMass[j] = tempInt1;
                }
            }
        }
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}