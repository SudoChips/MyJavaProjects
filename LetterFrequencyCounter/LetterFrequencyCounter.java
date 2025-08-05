import java.io.File;
import java.util.Scanner;

public class LetterFrequencyCounter {

    public static void main(String[] args) throws Exception {

        int[] count = new int[26];
        char[] letters = new char[26];
        boolean fileFound = false;

        Scanner input = new Scanner(System.in);

        while (!fileFound) {
            System.out.print("Enter a file name: ");
            String fileName = input.nextLine();

            try (Scanner dataIn = new Scanner(new File(fileName))) {
                System.out.println("File found");
                fileFound = true;

                String x = "";

                while (dataIn.hasNext()) {
                    x += dataIn.nextLine().toLowerCase();
                }

                x = x.replaceAll(" ", ""); // remove all spaces

                for (int indx = 0; indx < x.length(); indx++) {
                    getCount(x.charAt(indx), count, letters);
                }

            } catch (Exception ex) {
                System.out.println("File not found");
            }
        }

        input.close();

        for (int i = 0; i < letters.length; i++) {
            if (count[i] > 0)
                System.out.println("Number of " + letters[i] + "'s: " + count[i]);
        }
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public static void getCount(char x, int[] a, char[] b) {
        switch (x) {
            case 'a': a[0]++; b[0] = 'A'; break;// a is count b is letters in the array
            case 'b': a[1]++; b[1] = 'B'; break;
            case 'c': a[2]++; b[2] = 'C'; break;
            case 'd': a[3]++; b[3] = 'D'; break;
            case 'e': a[4]++; b[4] = 'E'; break;
            case 'f': a[5]++; b[5] = 'F'; break;
            case 'g': a[6]++; b[6] = 'G'; break;
            case 'h': a[7]++; b[7] = 'H'; break;
            case 'i': a[8]++; b[8] = 'I'; break;
            case 'j': a[9]++; b[9] = 'J'; break;
            case 'k': a[10]++; b[10] = 'K'; break;
            case 'l': a[11]++; b[11] = 'L'; break;
            case 'm': a[12]++; b[12] = 'M'; break;
            case 'n': a[13]++; b[13] = 'N'; break;
            case 'o': a[14]++; b[14] = 'O'; break;
            case 'p': a[15]++; b[15] = 'P'; break;
            case 'q': a[16]++; b[16] = 'Q'; break;
            case 'r': a[17]++; b[17] = 'R'; break;
            case 's': a[18]++; b[18] = 'S'; break;
            case 't': a[19]++; b[19] = 'T'; break;
            case 'u': a[20]++; b[20] = 'U'; break;
            case 'v': a[21]++; b[21] = 'V'; break;
            case 'w': a[22]++; b[22] = 'W'; break;
            case 'x': a[23]++; b[23] = 'X'; break;
            case 'y': a[24]++; b[24] = 'Y'; break;
            case 'z': a[25]++; b[25] = 'Z'; break;
        }
    }
}