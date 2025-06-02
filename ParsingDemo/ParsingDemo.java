import java.util.Scanner;

public class ParsingDemo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String wrkString;
        wrkString = "100";

        int iNumber;
        double dNumber;

        double result;

        iNumber = Integer.parseInt(wrkString);
        System.out.println("Result (int): " + iNumber);

        wrkString = "124.99";
        dNumber = Double.parseDouble(wrkString);
        System.out.println("Result (double): " + dNumber);

        result = iNumber + dNumber;
        System.out.println("Result (sum): " + result);

        result = iNumber + Double.parseDouble(wrkString);
        System.out.println("Result (sum with inline parse): " + result);

        input.close();
    }
}