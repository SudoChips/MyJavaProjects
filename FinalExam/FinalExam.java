import java.util.Scanner;
import java.io.*;

public class FinalExam {

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "finalExam.txt";
        final String OUTPUT_FILE = "finalExamReport.txt";
        final int inventoryCount = 25;

        File fn = new File(INPUT_FILE);
        Scanner dataIn = new Scanner(fn);
        PrintWriter dataOut = new PrintWriter(OUTPUT_FILE);
        Scanner keyboard = new Scanner(System.in);

        Cargo[] cargos = new Cargo[inventoryCount];

        fillArray(dataIn, cargos);

        int printSelection = getPrintSelection(keyboard);
        int menuSelection = displayMenu(keyboard);
        int totalCargoWeight = getTotal(cargos);

        displayMenuSelection(dataOut, printSelection, keyboard, menuSelection, cargos, totalCargoWeight);

        dataIn.close();
        dataOut.close();
        keyboard.close();
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner dataFile, Cargo[] cargos) {
        int indx = 0;

        while (dataFile.hasNext()) {
            cargos[indx] = new Cargo();
            cargos[indx].containerNumber(dataFile.nextInt());
            if (dataFile.hasNext()) dataFile.nextLine();
            cargos[indx].name(dataFile.nextLine());
            cargos[indx].tareWeight(dataFile.nextInt());
            cargos[indx].grossWeight(dataFile.nextInt());
            indx++;
        }
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayCargo(PrintWriter rpt, int printSelection, Cargo cargos, int totalCargoWeight) {
        double temp1 = cargos.percentCargoWeight(
            cargos.cargoWeight(cargos.grossWeight(), cargos.tareWeight()),
            cargos.grossWeight()
        );
        double temp2 = cargos.percentTotal(
            cargos.cargoWeight(cargos.grossWeight(), cargos.tareWeight()),
            totalCargoWeight
        );

        String fmtStr = "%-6d      %-20s %4d      %5d    %5d    %5.2f %%   %5.2f %%\n";
        writeToFile(rpt, printSelection, String.format(
            fmtStr,
            cargos.containerNumber(),
            cargos.name(),
            cargos.tareWeight(),
            cargos.grossWeight(),
            cargos.cargoWeight(cargos.grossWeight(), cargos.tareWeight()),
            temp1,
            temp2
        ));
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayHeader(PrintWriter rpt, int printSelection) {
        String strHdg = "                  %-15s\n";
        String strHdg1 = "%-10s  %-10s          %-6s    %-6s    %-6s   %-7s  %-15s\n";
        String strHdg2 = "%-10s  %-10s          %-6s    %-6s    %-6s   %-7s  %-15s\n";
        String strHdg3 = "%-10s  %-10s          %-6s    %-6s    %-6s   %-7s  %-15s\n\n";

        writeToFile(rpt, printSelection, String.format(strHdg, "Final Exam"));
        writeToFile(rpt, printSelection, String.format(strHdg1, "Container", "Ship", "Tare", "Gross", "Cargo", "% Cargo", "% of Total"));
        writeToFile(rpt, printSelection, String.format(strHdg2, "Number", "Name", "Weight", "Weight", "Weight", "Weight", "Cargo Weight"));
        writeToFile(rpt, printSelection, String.format(strHdg3, "=========", "====", "======", "======", "======", "======", "============"));
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
    public static void writeReport(PrintWriter rpt, int printSelection, Cargo[] cargoArray, int totalCargoWeight) {
        displayHeader(rpt, printSelection);
        for (int indx = 0; indx < cargoArray.length; indx++)
            displayCargo(rpt, printSelection, cargoArray[indx], totalCargoWeight);
        displayTotal(rpt, printSelection, cargoArray, totalCargoWeight);
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int getTotal(Cargo[] cargos) {
        int totalTare = 0;
        int totalGross = 0;

        for (int indx = 0; indx < cargos.length; indx++) {
            totalTare += cargos[indx].tareWeight();
            totalGross += cargos[indx].grossWeight();
        }
        return totalTare + totalGross;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayTotal(PrintWriter rpt, int printSelection, Cargo[] cargos, int totalCargoWeight) {
        int totalTare = 0;
        int totalGross = 0;

        for (int indx = 0; indx < cargos.length; indx++) {
            totalTare += cargos[indx].tareWeight();
            totalGross += cargos[indx].grossWeight();
        }

        String fmtStr = "\n%-10s %-10s%-10s %-6d    %-7d  %-7d \n";
        writeToFile(rpt, printSelection, String.format(fmtStr, "Total ", "", "", totalTare, totalGross, totalCargoWeight));
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void sortArrayByContainer(Cargo[] cargos) {
        Cargo tempCargo;

        for (int indx = 0; indx < cargos.length - 1; indx++) {
            for (int indx1 = indx + 1; indx1 < cargos.length; indx1++) {
                if (cargos[indx].containerNumber() > cargos[indx1].containerNumber()) {
                    tempCargo = cargos[indx];
                    cargos[indx] = cargos[indx1];
                    cargos[indx1] = tempCargo;
                }
            }
        }
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void sortArrayByName(Cargo[] cargos) {
        Cargo tempCargo;

        for (int indx = 0; indx < cargos.length - 1; indx++) {
            for (int indx1 = indx + 1; indx1 < cargos.length; indx1++) {
                if (cargos[indx].name().compareTo(cargos[indx1].name()) > 0) {
                    tempCargo = cargos[indx];
                    cargos[indx] = cargos[indx1];
                    cargos[indx1] = tempCargo;
                }
            }
        }
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int findByContainer(int containerSearch, Cargo[] searchArray) {
        int retIndx = -1;

        for (int indx = 0; indx < searchArray.length; indx++) {
            if (searchArray[indx].containerNumber() == containerSearch) {
                retIndx = indx;
                break;
            }
        }

        return retIndx;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void infoByContainer(PrintWriter rpt, int printSelection, Scanner keyboard, Cargo[] array, int totalCargoWeight) {
        int searchNumber = 0;

        do {
            System.out.print("Enter a container number to search for: ");
            searchNumber = keyboard.nextInt();
        } while (searchNumber <= 0);
        keyboard.nextLine(); // absorb the extra carriage return

        int indxReturned1 = findByContainer(searchNumber, array);
        if (indxReturned1 != -1)
            displayCargo(rpt, printSelection, array[indxReturned1], totalCargoWeight);
        else
            System.out.println("Container number is not on file");
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int displayMenu(Scanner keyboard) {
        int menuSelection = 0;
        do {
            System.out.println("1) Display unsorted report, 2) Display report sorted by container number, 3) Display report sorted by ship name, 4) Lookup item by container number, 5) Exit ");
            menuSelection = keyboard.nextInt();
            if (menuSelection > 5)
                System.out.println("invalid selection re-enter");
        } while (menuSelection > 5);

        return menuSelection;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayMenuSelection(PrintWriter dataOut, int printSelection, Scanner keyboard, int menuSelection, Cargo[] cargos, int totalCargoWeight) {
        while (menuSelection != 5) {
            if (menuSelection == 1) {
                writeReport(dataOut, printSelection, cargos, totalCargoWeight);
                System.out.println("");
            } else if (menuSelection == 2) {
                sortArrayByContainer(cargos);
                System.out.println("");
                writeReport(dataOut, printSelection, cargos, totalCargoWeight);
            } else if (menuSelection == 3) {
                sortArrayByName(cargos);
                System.out.println("");
                writeReport(dataOut, printSelection, cargos, totalCargoWeight);
            } else if (menuSelection == 4) {
                infoByContainer(dataOut, printSelection, keyboard, cargos, totalCargoWeight);
                System.out.println("");
            }

            menuSelection = displayMenu(keyboard);
        }
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}