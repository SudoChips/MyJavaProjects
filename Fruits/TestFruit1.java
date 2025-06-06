import java.util.Scanner;
import java.io.*;

public class TestFruit1 {

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "fruitFile1.txt";
        final String OUTPUT_FILE = "fruitReport.txt";
        final int fruitCount = 5;

        File fn = new File(INPUT_FILE);
        Scanner dataIn = new Scanner(fn);

        PrintWriter produceReport = new PrintWriter(OUTPUT_FILE);
        Scanner keyboard = new Scanner(System.in);

        Fruit[] fruits = new Fruit[fruitCount];

        int printSelection = getPrintSelection(keyboard);
        int menuSelection = displayMenu(keyboard);

        fillArray(dataIn, fruits);
        displayMenuSelection(produceReport, printSelection, keyboard, menuSelection, fruits);

        dataIn.close();
        keyboard.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner dataFile, Fruit[] fruitData) {
        int indx = 0;

        while (dataFile.hasNext()) {
            fruitData[indx] = new Fruit();
            fruitData[indx].name(dataFile.nextLine());
            fruitData[indx].price(dataFile.nextDouble());
            fruitData[indx].pounds(dataFile.nextInt());
            if (dataFile.hasNext()) dataFile.nextLine();
            indx++;
        }
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
            System.out.println("1) Display unsorted report, 2) display report sorted by name, 3) display report sorted by cost, 4) lookup fruit by name, 5) display lowest cost, 6) display highest cost ");
            menuSelection = keyboard.nextInt();
            if (menuSelection > 6)
                System.out.println("invalid selection re-enter");
        } while (menuSelection > 6);
        return menuSelection;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayMenuSelection(PrintWriter produceReport, int printSelection, Scanner keyboard, int menuSelection, Fruit[] fruits) {
        while (menuSelection != 0) {
            if (menuSelection == 1) {
                writeReport(produceReport, printSelection, fruits);
                System.out.println("");
            } else if (menuSelection == 2) {
                sortArrayByName(fruits);
                System.out.println("");
                writeReport(produceReport, printSelection, fruits);
            } else if (menuSelection == 3) {
                sortArrayByCost(fruits);
                System.out.println("");
                writeReport(produceReport, printSelection, fruits);
            } else if (menuSelection == 4) {
                infoByName(produceReport, printSelection, keyboard, fruits);
                System.out.println("");
            } else if (menuSelection == 5) {
                displayFruit(produceReport, printSelection, fruits[lowestCost(fruits)]);
                System.out.println("");
            } else if (menuSelection == 6) {
                displayFruit(produceReport, printSelection, fruits[highestCost(fruits)]);
                System.out.println("");
            }
            menuSelection = displayMenu(keyboard);
        }
        produceReport.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayFruit(PrintWriter rpt, int printSelection, Fruit fruitIn) {
        String fmtStr = "%-10s  $%-4.2f   %5d       $%-4.2f\n";
        writeToFile(rpt, printSelection, String.format(fmtStr, fruitIn.name(), fruitIn.price(), fruitIn.pounds(), fruitIn.cost()));
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayHeader(PrintWriter rpt, int printSelection) {
        String strHdg = "%-10s %-10s %-10s %-10s \n";
        String strHdg1 = "%-10s %-10s %-10s %-10s \n";
        writeToFile(rpt, printSelection, String.format(strHdg, "Produce", "Price/lb", "Pounds", "Cost"));
        writeToFile(rpt, printSelection, String.format(strHdg1, "=======", "========", "======", "===="));
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void writeReport(PrintWriter rpt, int printSelection, Fruit[] fruitArray) {
        double totalCost = 0.0;

        displayHeader(rpt, printSelection);
        for (int indx = 0; indx < fruitArray.length; indx++)
            displayFruit(rpt, printSelection, fruitArray[indx]);

        for (int indx = 0; indx < fruitArray.length; indx++)
            totalCost += fruitArray[indx].cost();

        String fmtStr = "\n%-10s %-10s%-10s$%-10s \n";
        writeToFile(rpt, printSelection, String.format(fmtStr, "Total", "", "", totalCost));
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void sortArrayByName(Fruit[] fruits) {
        Fruit tempFruit;
        for (int i = 0; i < fruits.length - 1; i++) {
            for (int j = i + 1; j < fruits.length; j++) {
                if (fruits[i].name().compareTo(fruits[j].name()) > 0) {
                    tempFruit = fruits[i];
                    fruits[i] = fruits[j];
                    fruits[j] = tempFruit;
                }
            }
        }
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void sortArrayByCost(Fruit[] fruits) {
        Fruit tempFruit;
        for (int i = 0; i < fruits.length - 1; i++) {
            for (int j = i + 1; j < fruits.length; j++) {
                if (fruits[i].cost() > fruits[j].cost()) {
                    tempFruit = fruits[i];
                    fruits[i] = fruits[j];
                    fruits[j] = tempFruit;
                }
            }
        }
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int findByName(Fruit[] searchArray, String searchName) {
        int retValue = -1;
        for (int i = 0; i < searchArray.length; i++) {
            if (searchArray[i].name().equalsIgnoreCase(searchName)) {
                retValue = i;
                break;
            }
        }
        return retValue;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void infoByName(PrintWriter rpt, int printSelection, Scanner keyboard, Fruit[] array) {
        String searchName = "";
        do {
            System.out.print("Enter a fruit's name to search for: ");
            searchName = keyboard.nextLine();
            if (searchName.equals("")) searchName = keyboard.nextLine();
        } while (searchName.equals(""));

        int indxReturned = findByName(array, searchName);
        if (indxReturned != -1)
            displayFruit(rpt, printSelection, array[indxReturned]);
        else
            System.out.println("Fruit name is not on file");
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int highestCost(Fruit[] array) {
        int retIndx = 0;
        for (int i = 0; i < array.length; i++)
            if (array[retIndx].price() < array[i].price()) retIndx = i;
        return retIndx;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int lowestCost(Fruit[] array) {
        int retIndx = 0;
        for (int i = 0; i < array.length; i++)
            if (array[retIndx].price() > array[i].price()) retIndx = i;
        return retIndx;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}