public class AreaAndPerimeterOfACircle{
public static void main(String[] args){

double radius = 5.5;
double perimeter;
double area;

perimeter = 2 * radius * Math.PI;
area = radius * radius * Math.PI;

System.out.print("The perimeter is " + perimeter + "\nThe area is " + area + '\n');

}
}