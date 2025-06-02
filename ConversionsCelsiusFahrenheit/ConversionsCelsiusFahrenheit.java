import java.util.Scanner;

public class ConversionsCelsiusFahrenheit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] fahrenheit = {120.0, 110.0, 100.0, 90.0, 80.0, 70.0, 60.0, 50.0, 40.0, 30.0};
        double[] celsius = {40.0, 39.0, 38.0, 37.0, 36.0, 35.0, 34.0, 33.0, 32.0, 31.0};

        displayArrays(fahrenheit, celsius);

        input.close();
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void displayArrays(double[] fahrenheit, double[] celsius) {
        System.out.printf("Celsius    Fahrenheit    |    Fahrenheit    Celsius\n");
        System.out.printf("-----------------------------------------------------\n");
        for (int i = 0; i < fahrenheit.length; i++) {
            System.out.printf("%-10.1f%-14.2f|%14.2f%12.2f\n",
                celsius[i],
                celsiusToFahrenheit(celsius[i]),
                fahrenheit[i],
                fahrenheitToCelsius(fahrenheit[i]));
        }
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5) + 32;
    }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}