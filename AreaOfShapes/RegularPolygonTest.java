class RegularPolygon {

    private int n;
    private double side;
    private double x;
    private double y;

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // Constructors
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public RegularPolygon() {
        n = 3;
        side = 1;
        x = 0;
        y = 0;
    }

    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
        this.x = 0.0;
        this.y = 0.0;
    }

    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    // Methods
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public double area() {
        return n * Math.pow(side, 2) / (4 * Math.tan(Math.PI / n));
    }

    public double perimeter() {
        return n * side;
    }
}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public class RegularPolygonTest {

    public static void main(String[] args) {

        RegularPolygon rp = new RegularPolygon();
        RegularPolygon rp1 = new RegularPolygon(6, 4);
        RegularPolygon rp2 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Polygon 1 perimeter: " + rp.perimeter());
        System.out.println("Polygon 1 area: " + rp.area());

        System.out.println("Polygon 2 perimeter: " + rp1.perimeter());
        System.out.println("Polygon 2 area: " + rp1.area());

        System.out.println("Polygon 3 perimeter: " + rp2.perimeter());
        System.out.println("Polygon 3 area: " + rp2.area());
    }
}