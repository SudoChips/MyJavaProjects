public class FruitsHardcoded {
    public static void main(String[] args) {
        String Fruit1 = "Bananas";
        String Fruit2 = "Apples";
        String Fruit3 = "Peaches";
        String Fruit4 = "Watermelon";

        double price1 = 0.17;
        double price2 = 1.24;
        double price3 = 1.39;
        double price4 = 0.38;

        double totalCost = 0.0;

        int pounds1 = 3;
        int pounds2 = 5;
        int pounds3 = 4;
        int pounds4 = 6;

        String fmtStrHdg = "%-12s      %8s     %6s      %6s\n";
        String fmtStr = "%-12s     $%8.2f     %6d     $%6.2f\n";
        String fmtStrTotal = "\n%-12s      %8s     %6s     $%6.2f\n";

        System.out.printf(fmtStrHdg, "Produce", "Price/lb", "Pounds", "Cost");
        System.out.printf(fmtStrHdg + '\n', "=======", "========", "======", "====");

        System.out.printf(fmtStr, Fruit1, price1, pounds1, price1 * pounds1);
        System.out.printf(fmtStr, Fruit2, price2, pounds2, price2 * pounds2);
        System.out.printf(fmtStr, Fruit3, price3, pounds3, price3 * pounds3);
        System.out.printf(fmtStr, Fruit4, price4, pounds4, price4 * pounds4);

        totalCost += price1 * pounds1;
        totalCost += price2 * pounds2;
        totalCost += price3 * pounds3;
        totalCost += price4 * pounds4;

        System.out.printf(fmtStrTotal, "Total", " ", " ", totalCost);
    }
}