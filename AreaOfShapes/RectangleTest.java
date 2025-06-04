class Rectangle {

    private double width;
    private double height;

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // Constructors
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public Rectangle() {
        width = 1;
        height = 1;
    }

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // Accessors
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public double width() {
        return width;
    }

    public double height() {
        return height;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // Misc methods
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }
}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public class RectangleTest {

    public static void main(String[] args) {

        Rectangle rt = new Rectangle(4.0, 40.0);
        System.out.print("The area of a rectangle with width " + rt.width() + 
                         " and height " + rt.height() + " is " + rt.area() + 
                         "\nThe perimeter of a rectangle is " + rt.perimeter() + "\n");

        Rectangle rt1 = new Rectangle(3.5, 35.9);
        System.out.print("The area of a rectangle with width " + rt1.width() + 
                         " and height " + rt1.height() + " is " + rt1.area() + 
                         "\nThe perimeter of a rectangle is " + rt1.perimeter() + "\n");
    }
}