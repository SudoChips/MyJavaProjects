import java.io.*;

public class TestFruit {

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "fruitFile.txt";
        final String OUTPUT_FILE = "fruitReport.txt";

        File fn = new File(INPUT_FILE);
        Scanner dataIn = new Scanner(fn);

        PrintWriter produceReport = new PrintWriter(OUTPUT_FILE);

        Fruit fruit1 = new Fruit();
        double totalCost = 0.0;

        displayHeader();

        while (dataIn.hasNext()) {
            getFruitData(dataIn, fruit1);
            displayFruit(fruit1);
            totalCost += fruit1.cost(); // reads and displays the whole file
        }

        System.out.printf("\n%-10s %-10s%-10s$%-10.2f \n", "Total", "", "", totalCost);

        dataIn.close();
        produceReport.close();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void getFruitData(Scanner dataFile, Fruit fruitData) {
        fruitData.name(dataFile.nextLine());
        fruitData.price(dataFile.nextDouble());
        fruitData.pounds(dataFile.nextInt());
        if (dataFile.hasNext()) dataFile.nextLine();
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayFruit(Fruit fruitIn) {
        System.out.printf("%-10s  $%-4.2f   %5d       $%-4.2f\n",
            fruitIn.name(), fruitIn.price(), fruitIn.pounds(), fruitIn.cost());
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayHeader() {
        System.out.printf("%-10s %-10s %-10s %-10s \n", "Produce", "Price/lb", "Pounds", "Cost");
        System.out.printf("%-10s %-10s %-10s %-10s \n", "=======", "========", "======", "====");
    }
}