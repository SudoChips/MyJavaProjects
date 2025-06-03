import java.util.Scanner;
import java.io.*;

public class ReceiptCalculator {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        // writing from file
        final String FILE_NAME = "reciept.txt";
        File fn = new File(FILE_NAME);
        Scanner inputFile = new Scanner(fn);

        int itemId = 0;
        int quantitySold = 0;
        double price = 0.0;
        double subTotal = 0.0;
        double cost = 0.0;
        double tax;

        while (inputFile.hasNext()) {
            itemId = inputFile.nextInt();
            quantitySold = inputFile.nextInt();
            price = inputFile.nextDouble();
            cost = price * quantitySold;

            System.out.printf("\n%-6d %3d %5.2f %5.2f", itemId, quantitySold, price, cost);
            subTotal += cost;
        }

        tax = subTotal * 0.0625;
        System.out.printf("\n\nSubtotal:    %5.2f", subTotal);
        System.out.printf("\nTax:         %5.2f", tax);
        System.out.printf("\nTotal:       %5.2f\n", subTotal + tax);

        inputFile.close();
        input.close();
    }
}