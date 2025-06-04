import java.util.Scanner;

public class MilesPerGallon1 {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double miles;
        double gallons;

        double tMiles = 0;
        double tGallons = 0;

        System.out.print("Enter the miles Driven ");
        miles = keyboard.nextDouble();

        System.out.print("Enter the gallons of gas used ");
        gallons = keyboard.nextDouble();

        tMiles += miles;
        tGallons += gallons;

        System.out.print("Enter the miles Driven ");
        miles = keyboard.nextDouble();

        System.out.print("Enter the gallons of gas used ");
        gallons = keyboard.nextDouble();

        tMiles += miles;
        tGallons += gallons;

        System.out.print("Enter the miles Driven ");
        miles = keyboard.nextDouble();

        System.out.print("Enter the gallons of gas used ");
        gallons = keyboard.nextDouble();

        tMiles += miles;
        tGallons += gallons;

        double MPG = tMiles / tGallons;

        System.out.println("The miles per gallons was " + MPG);

        keyboard.close();
    }
}