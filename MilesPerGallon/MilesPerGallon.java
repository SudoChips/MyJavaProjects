import java.util.Scanner;

public class MilesPerGallon {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double miles;
        double gallons;

        double miles1;
        double miles2;
        double miles3;

        double gallons1;
        double gallons2;
        double gallons3;

        System.out.print("Enter the miles Driven ");
        miles1 = keyboard.nextDouble();

        System.out.print("Enter the gallons of gas used ");
        gallons1 = keyboard.nextDouble();

        System.out.print("Enter the miles Driven ");
        miles2 = keyboard.nextDouble();

        System.out.print("Enter the gallons of gas used ");
        gallons2 = keyboard.nextDouble();

        System.out.print("Enter the miles Driven ");
        miles3 = keyboard.nextDouble();

        System.out.print("Enter the gallons of gas used ");
        gallons3 = keyboard.nextDouble();

        miles = miles1 + miles2 + miles3;
        gallons = gallons1 + gallons2 + gallons3;

        double MPG = miles / gallons;

        System.out.println("The miles per gallons was " + MPG);

        keyboard.close();
    }
}