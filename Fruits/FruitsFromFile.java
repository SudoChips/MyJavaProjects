import java.io.*;

public class FruitsFromFile {
    public static void main(String[] args) throws IOException {

        final String FILE_NAME = "fruitFile.txt";

        // reading from a file
        File fn = new File(FILE_NAME);
        Scanner inputFile = new Scanner(fn);

        String fruit;
        double price;
        int pounds;

        double totalCost = 0.0;

        String fmtStrHdg = "%-12s      %8s     %6s      %6s\n";
        String fmtStr = "%-12s     $%8.2f     %6d     $%6.2f\n";
        String fmtStrTotal = "\n%-12s      %8s     %6s     $%6.2f\n";

        System.out.printf(fmtStrHdg, "Produce", "Price/lb", "Pounds", "Cost");
        System.out.printf(fmtStrHdg + "\n", "=======", "========", "======", "====");

        fruit = inputFile.nextLine();
        price = inputFile.nextDouble();
        pounds = inputFile.nextInt();
        System.out.printf(fmtStr, fruit, price, pounds, price * pounds);
        totalCost += price * pounds;

        fruit = inputFile.nextLine();
        if (fruit.equals("")) fruit = inputFile.nextLine();
        price = inputFile.nextDouble();
        pounds = inputFile.nextInt();
        System.out.printf(fmtStr, fruit, price, pounds, price * pounds);
        totalCost += price * pounds;

        fruit = inputFile.nextLine();
        if (fruit.equals("")) fruit = inputFile.nextLine();
        price = inputFile.nextDouble();
        pounds = inputFile.nextInt();
        System.out.printf(fmtStr, fruit, price, pounds, price * pounds);
        totalCost += price * pounds;

        fruit = inputFile.nextLine();
        if (fruit.equals("")) fruit = inputFile.nextLine();
        price = inputFile.nextDouble();
        pounds = inputFile.nextInt();
        System.out.printf(fmtStr, fruit, price, pounds, price * pounds);
        totalCost += price * pounds;

        fruit = inputFile.nextLine();
        if (fruit.equals("")) fruit = inputFile.nextLine();
        price = inputFile.nextDouble();
        pounds = inputFile.nextInt();
        System.out.printf(fmtStr, fruit, price, pounds, price * pounds);
        totalCost += price * pounds;

        System.out.printf(fmtStrTotal, "Total", " ", " ", totalCost);

        inputFile.close();
    }
}