import java.util.Scanner;

public class AreaOfARectangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the length: ");
        double length = keyboard.nextDouble();

        System.out.print("Enter the width: ");
        double width = keyboard.nextDouble();

        double perimeter = (2 * length) + (2 * width);
        double area = length * width;

        System.out.println("The perimeter is " + perimeter);
        System.out.println("The area is " + area);

        keyboard.close();
    }
}