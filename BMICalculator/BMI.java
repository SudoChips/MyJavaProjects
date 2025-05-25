import java.util.Scanner;
public class BMI{
public static void main(String[] args){

Scanner keyboard = new Scanner(System.in);

System.out.print("Enter a weight in pounds: ");
double pounds = keyboard.nextDouble();

System.out.print("Enter a height in inches: ");
double inches = keyboard.nextDouble();

final double KILOGRAMS_PER_POUND = 0.45359237;
final double METERS_PER_INCH = 0.0254;

double weightInKIlos = pounds * KILOGRAMS_PER_POUND;
double heightInMeters = inches * METERS_PER_INCH;
double BMI = weightInKIlos / (heightInMeters * heightInMeters);


System.out.print("BMI is " + BMI + '\n');
close();
}
}
