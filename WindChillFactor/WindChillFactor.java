import java.util.Scanner;

public class WindChillFactor {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.print("Enter a temperature between -58°F and 41°F: ");
    double temperature = keyboard.nextDouble();
    while (temperature < -58 || temperature > 41) {
      System.out.print("Invalid number: enter a temperature between -58°F and 41°F: ");
      temperature = keyboard.nextDouble();
    }

    System.out.print("Enter a wind speed greater than or equal to 2: ");
    double windSpeed = keyboard.nextDouble();
    while (windSpeed < 2) {
      System.out.print("Invalid number: Enter a wind speed greater than or equal to 2: ");
      windSpeed = keyboard.nextDouble();
    }

    double windChill = 35.74 
                     + (0.6215 * temperature) 
                     - (35.75 * Math.pow(windSpeed, 0.16)) 
                     + (0.4275 * temperature * Math.pow(windSpeed, 0.16));

    System.out.println("The wind chill is " + windChill);

    keyboard.close(); // close scanner
  }
}