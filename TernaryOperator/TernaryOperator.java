public class TernaryOperator {
  public static void main(String[] args) {

    int number1 = 10;
    int number2 = 20;
    int number3 = 15;

    int result;
    char resultC;
    boolean resultB;

    result = (number1 > number2 || number1 > number3) ? 0 : 1;
    System.out.println("The result is " + result);

    resultC = (number1 > number2 || number1 > number3) ? 'T' : 'F';
    System.out.println("The result is " + resultC);

    resultB = (number1 > number2 || number1 > number3) ? true : false;
    System.out.println("The result is " + resultB);
  }
}