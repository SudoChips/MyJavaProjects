import java.util.Scanner;
import java.io.*;

public class Books {

    public static void main(String[] args) throws IOException {
        final String INPUT_FILE = "inventory.txt";
        final String OUTPUT_FILE = "inventoryReport.txt";
        final int inventoryCount = 10;

        File fn = new File(INPUT_FILE);
        Scanner dataIn = new Scanner(fn);
        PrintWriter dataOut = new PrintWriter(OUTPUT_FILE);
        Scanner keyboard = new Scanner(System.in);

        BookStore[] books = new BookStore[inventoryCount];

        fillArray(dataIn, books);

        int printSelection = getPrintSelection(keyboard);
        int menuSelection = displayMenu(keyboard);
        double totalProfit = getTotalProfit(books);

        displayMenuSelection(dataOut, printSelection, keyboard, menuSelection, books, totalProfit);

        dataIn.close();
        dataOut.close();
        keyboard.close();
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void fillArray(Scanner dataFile, BookStore[] books) {
        int indx = 0;
        while (dataFile.hasNext()) {
            books[indx] = new BookStore();
            books[indx].sku(dataFile.nextInt());
            if (dataFile.hasNext()) dataFile.nextLine();
            books[indx].item(dataFile.nextLine());
            books[indx].price(dataFile.nextDouble());
            books[indx].cost(dataFile.nextDouble());
            books[indx].quantity(dataFile.nextInt());
            indx++;
        }
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayBooks(PrintWriter rpt, int printSelection, BookStore books, double totalProfit) {
        String fmtStr = "%-5d   %-10s  $ %5.2f  $ %5.2f   %3d    $ %7.2f       $ %5.2f %%\n";
        writeToFile(rpt, printSelection,
                String.format(fmtStr, books.sku(), books.item(), books.price(), books.cost(), books.quantity(), books.profit(), books.percentProfit(totalProfit)));
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayHeader(PrintWriter rpt, int printSelection) {
        String strHdg = "                  %-15s\n";
        String strHdg1 = "%-5s  %-10s    %-5s    %-5s %-10s %-10s  %-15s\n";
        String strHdg2 = "%-5s  %-10s    %-5s    %-5s %-10s %-10s  %-15s\n";
        writeToFile(rpt, printSelection, String.format(strHdg, "MCC BOOK STORE"));
        writeToFile(rpt, printSelection, String.format(strHdg1, "Sku", "Description", "Price", "Cost", "Quantity", "Profit", "Percent Profit"));
        writeToFile(rpt, printSelection, String.format(strHdg2, "===", "===========", "=====", "====", "========", "======", "=============="));
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
    public static void writeReport(PrintWriter rpt, int printSelection, BookStore[] bookArray, double totalProfit) {
        displayHeader(rpt, printSelection);
        for (int indx = 0; indx < bookArray.length; indx++)
            displayBooks(rpt, printSelection, bookArray[indx], totalProfit);
        displayTotal(rpt, printSelection, totalProfit);
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static double getTotalProfit(BookStore[] bookArray) {
        double totalProfit = 0.0;
        for (BookStore book : bookArray) totalProfit += book.profit();
        return totalProfit;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayTotal(PrintWriter rpt, int printSelection, double totalProfit) {
        String fmtStr = "\n%-10s %-10s%-10s                             $%-6.2f \n";
        writeToFile(rpt, printSelection, String.format(fmtStr, "Total Profit", "", "", totalProfit));
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int findByName(BookStore[] searchArray, String searchName) {
        for (int indx = 0; indx < searchArray.length; indx++) {
            if (searchArray[indx].item().equalsIgnoreCase(searchName)) return indx;
        }
        return -1;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void infoByName(PrintWriter rpt, int printSelection, Scanner keyboard, BookStore[] array, double totalProfit) {
        String searchName = "";
        do {
            System.out.print("Enter an item's name to search for: ");
            searchName = keyboard.nextLine();
            if (searchName.equals("")) searchName = keyboard.nextLine();
        } while (searchName.equals(""));

        int indxReturned = findByName(array, searchName);
        if (indxReturned != -1)
            displayBooks(rpt, printSelection, array[indxReturned], totalProfit);
        else
            System.out.println("Item name is not on file");
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int findBySku(int skuSearch, BookStore[] searchArray) {
        for (int indx = 0; indx < searchArray.length; indx++) {
            if (searchArray[indx].sku() == skuSearch) return indx;
        }
        return -1;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void infoBySku(PrintWriter rpt, int printSelection, Scanner keyboard, BookStore[] array, double totalProfit) {
        int searchNumber = 0;
        do {
            System.out.print("Enter a sku to search for: ");
            searchNumber = keyboard.nextInt();
        } while (searchNumber <= 0);
        keyboard.nextLine(); // absorb the extra carriage return

        int indxReturned1 = findBySku(searchNumber, array);
        if (indxReturned1 != -1)
            displayBooks(rpt, printSelection, array[indxReturned1], totalProfit);
        else
            System.out.println("Sku number is not on file");
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void sortArrayByName(BookStore[] books) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = i + 1; j < books.length; j++) {
                if (books[i].item().compareTo(books[j].item()) > 0) {
                    BookStore tempBook = books[i];
                    books[i] = books[j];
                    books[j] = tempBook;
                }
            }
        }
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void sortArrayBySku(BookStore[] books) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = i + 1; j < books.length; j++) {
                if (books[i].sku() > books[j].sku()) {
                    BookStore tempBook = books[i];
                    books[i] = books[j];
                    books[j] = tempBook;
                }
            }
        }
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static int displayMenu(Scanner keyboard) {
        int menuSelection = 0;
        do {
            System.out.println("1) Display unsorted report, 2) display report sorted by item, 3) display report sorted by Sku, 4) lookup item by name, 5) lookup item by sku, 6) Exit ");
            menuSelection = keyboard.nextInt();
            if (menuSelection > 6) System.out.println("invalid selection re-enter");
        } while (menuSelection > 6);
        return menuSelection;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayMenuSelection(PrintWriter dataOut, int printSelection, Scanner keyboard, int menuSelection, BookStore[] books, double totalProfit) {
        while (menuSelection != 6) {
            if (menuSelection == 1) {
                writeReport(dataOut, printSelection, books, totalProfit);
                System.out.println("");
            } else if (menuSelection == 2) {
                sortArrayByName(books);
                System.out.println("");
                writeReport(dataOut, printSelection, books, totalProfit);
            } else if (menuSelection == 3) {
                sortArrayBySku(books);
                System.out.println("");
                writeReport(dataOut, printSelection, books, totalProfit);
            } else if (menuSelection == 4) {
                infoByName(dataOut, printSelection, keyboard, books, totalProfit);
                System.out.println("");
            } else if (menuSelection == 5) {
                infoBySku(dataOut, printSelection, keyboard, books, totalProfit);
                System.out.println("");
            }
            menuSelection = displayMenu(keyboard);
        }
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}