import java.io.File;
import java.util.Scanner;

public class RemoveNameFromFile {

    public static void main(String[] args) throws Exception {
        boolean fileFound = false;
        Scanner input = new Scanner(System.in); // only create this once

        while (!fileFound) {
            System.out.print("Enter the name of the file: ");
            String fileName = input.nextLine();

            try (Scanner dataIn = new Scanner(new File(fileName))) {
                fileFound = true;
                String x = "";

                while (dataIn.hasNext()) {
                    x += dataIn.nextLine();
                }

                x = x.replaceAll("John", "");
                System.out.println(x);

            } catch (Exception ex) {
                System.out.println("File not found");
            }
        }

        input.close();
    }
}