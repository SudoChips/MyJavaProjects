import java.util.Scanner;
public class AreaOfARectangle{
public static void main(String[] args){

Scanner keyboard = new Scanner(System.in);

System.out.print("Enter the length: ");
double length = keyboard.nextDouble();

System.out.print("Enter the width: ");
double width = keyboard.nextDouble();

double perimeter;
double area;

perimeter =(2 * length) + (2 * width);
area = length * width;

System.out.print("The perimeter is " + perimeter + "\nThe area is " + area + '\n');
close();
}
}