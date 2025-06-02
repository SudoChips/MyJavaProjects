public class Exercise07_21 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }

        System.out.println("The total is " + sum);
    }
}

//How would you write this program? Here are some hints:
//Step 1: Declare and initialize sum with 0.
//Step 2: Write a for loop. For each args[i], add Integer.parseInt(args[i]) to sum.
//Step 3: Display sum.